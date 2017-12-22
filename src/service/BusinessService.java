package service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import Utils.HibernateUtil;
import dao.UserDao;
import domain.User;

public class BusinessService {
	UserDao udao = new UserDao();
	
	public User login(String username,String password) {
		return udao.find(username, password);
	}
	
	public boolean regist(User user) {
		if(udao.findByUsername(user.getUsername()) == null) {
			udao.add(user);
			return true;
		}else {
			return false;
		}
	}
}
