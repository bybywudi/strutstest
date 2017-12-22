package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import Utils.HibernateUtil;
import domain.User;

public class UserDao {
	public User find(String username,String password) {
		Session sess = HibernateUtil.currentSession();
		
		Transaction tx = sess.beginTransaction();
		
		//List userlist = sess.createQuery("select distinct user from User user where user.username=:userName and user.password=:passWord").setString("userName", username).setString("passWord", password).list();
		//User user = (User) sess.createCriteria(User.class).add(Restrictions.eq("username", username)).add(Restrictions.eq("password", password)).uniqueResult();
		String sqlString = "select * from user where username=?1 and password=?2";
		User user = (User) sess.createSQLQuery(sqlString).addEntity(User.class).setString("1", username).setString("2", password).uniqueResult();
		tx.commit();
		HibernateUtil.closeSession();
		if(user == null) {

			return null;
		}else {

			return user;
		}
	}
	
	public void add(User user) {
		Session sess = HibernateUtil.currentSession();
		Transaction tx = sess.beginTransaction();
		
		sess.save(user);
		
		tx.commit();
		HibernateUtil.closeSession();
	}
	
	public User findByUsername(String username) {
		Session sess = HibernateUtil.currentSession();
		
		Transaction tx = sess.beginTransaction();
		
		//List userlist = sess.createQuery("select distinct user from User user where user.username=:userName and user.password=:passWord").setString("userName", username).setString("passWord", password).list();
		//User user = (User) sess.createCriteria(User.class).add(Restrictions.eq("username", username)).add(Restrictions.eq("password", password)).uniqueResult();
		String sqlString = "select * from user where username=?1";
		User user = (User) sess.createSQLQuery(sqlString).addEntity(User.class).setString("1", username).uniqueResult();
		tx.commit();
		HibernateUtil.closeSession();
		if(user == null) {

			return null;
		}else {

			return user;
		}
	}
	
}
