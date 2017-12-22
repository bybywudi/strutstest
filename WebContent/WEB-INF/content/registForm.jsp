<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:text name="loginPage"/></title>
</head>
<s:property value="#message"/>
<s:form action="regist" validate="true">
	<s:textfield name="username" label="用户名"/>
	<s:textfield name="password" label="密码"/>
	<s:textfield name="nickname" label="昵称"/>
	<s:textfield name="email" label="邮箱"/>
	<s:textfield name="birthday" label="生日"/>
	<s:submit value="注册"/>
</s:form>
</body>
</html>