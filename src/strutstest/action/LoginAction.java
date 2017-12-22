package strutstest.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import domain.User;
import service.BusinessService;

public class LoginAction extends ActionSupport {
	private String username;
	private String password;
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
		User user = service.login(getUsername(), getPassword());
		if(user!= null) {
			ActionContext.getContext().getSession().put("user",user);
			return SUCCESS;
		}else {
			ActionContext.getContext().put("message", "用户名或密码错误！");  
			return INPUT;
		}
	}
	
}
