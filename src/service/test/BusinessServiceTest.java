package service.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.junit.Test;

import Utils.HibernateUtil;
import domain.User;
import hibernate.News;
import service.BusinessService;

public class BusinessServiceTest {
	@Test
	public void testLogin() throws Exception{
		BusinessService service = new BusinessService();
		
		User user = service.login("bybywudi", "123");
		
		if(user == null) {
			System.out.println("null");
		}else {
			System.out.println(user.getUsername());
		}
	}
	
	public  void hiber() throws Exception{
		

		/*Configuration conf = new Configuration().configure();

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // configures settings from hibernate.cfg.xml
				.build();
		
		
		SessionFactory sf = conf.buildSessionFactory(registry);
		Session sess = sf.openSession();*/
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		
		User user = new User();
		
		user.setUsername("bybywudi2");
		user.setPassword("123");
		
		sess.save(user);
		tx.commit();
		HibernateUtil.closeSession();
	}
	 
	
	public void testHiber() throws Exception{
		BusinessServiceTest bst = new BusinessServiceTest();
		bst.hiber();
		HibernateUtil.sessionFactory.close();
	}
}
