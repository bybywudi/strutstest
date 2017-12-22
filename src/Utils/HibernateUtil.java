package Utils;

import org.hibernate.*;
import org.hibernate.service.*;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.*;
import org.hibernate.cfg.*;

public class HibernateUtil
{
	public static final SessionFactory sessionFactory;

	static
	{
		try
		{
			
			Configuration cfg = new Configuration()
				.configure();

			/*ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties()).build();
			sessionFactory = cfg.buildSessionFactory(serviceRegistry);*/
			
			StandardServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();

			sessionFactory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}


	public static final ThreadLocal<Session> session
		= new ThreadLocal<Session>();

	public static Session currentSession()
		throws HibernateException
	{
		Session s = session.get();

		if (s == null)
		{
			s = sessionFactory.openSession();

			session.set(s);
		}
		return s;
	}

	public static void closeSession()
		throws HibernateException
	{
		Session s = session.get();
		if (s != null)
			s.close();
		session.set(null);
	}
}