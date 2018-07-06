<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">  
    var str=${requestScope.message };
    if(str=="注册成功，请登陆~")document.getElementById("message").color="green";
</script>
<title>学生住房系统</title>
</head>
<body>
<h3>登录页面</h3>
<form action="login" method="post" align="center">
	<font color="red"id="message">${requestScope.message }</font>
     <table>
         <tr>
         	<td><label>登录名: </label></td>
             <td><input type="text" id="loginId" name="loginId" ></td>
         </tr>
         <tr>
         	<td><label>密码: </label></td>
            <td><input type="password" id="password" name="password" ></td>
         </tr>
         <tr>
         	<td><input type="radio" name="role" value="houseowner">房主</td>
			<td><input type="radio" name="role" value="student">学生</td>
         </tr>
         <tr>
            <td><input type="submit" value="登录"></td>
            <td><input type="button"  value="房主注册" onclick="window.location.href = 'registForm.jsp?role=houseowner'"/></td>
            <td><input type="button"  value="学生注册" onclick="window.location.href = 'registForm.jsp?role=student'"/></td>
         </tr>
     </table>
</form>
</body>
</html>