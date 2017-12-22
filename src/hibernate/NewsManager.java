package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class NewsManager {
	
	public  void hiber() throws Exception{
		
		Configuration conf = new Configuration().configure();

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		
		
		SessionFactory sf = conf.buildSessionFactory(registry);
		Session sess = sf.openSession();
		
		Transaction tx = sess.beginTransaction();
		
		News n = new News();
		n.setTitle("bai");
		n.setContent("baiyang");
		
		sess.save(n);
		tx.commit();
		sess.close();
		sf.close();
	}
	@Test
	public void testHiber() throws Exception{
		hiber();
	}
}
