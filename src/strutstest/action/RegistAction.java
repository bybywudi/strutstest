package strutstest.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.User;
import service.BusinessService;

public class RegistAction extends ActionSupport {
	private String username;
	private String password;
	private String nickname;
	private String email;
	private Date birthday;

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	BusinessService service = new BusinessService();
	public String execute() {
		User user = new User();
		user.setUsername(getUsername());
		user.setPassword(getPassword());
		user.setEmail(getEmail());
		user.setBirthday(getBirthday());
		user.setNickname(getNickname());
		
		if(service.regist(user)) {
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}else {
			ActionContext.getContext().put("message", "该用户已存在");
			return INPUT;
		}
		
		
		
	}
}
