<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">  
<title>学生住房系统</title>  
<style>
	.font1{  
        color:#666;}  
        
</style>
<script >
function onCheck()
{
  if((form1.name==null||form1.name.value=="")&&(form1.studentpwd==null||form1.studentpwd.value==""))
 {
    alert("用户名，密码都不能为空");
    return false;
 }
  else if(form1.name==null||form1.name.value=="")
 {
    alert("用户名不能为空");
    return false;
 }
  else  if(form1.studentpwd==null||form1.studentpwd.value==""||form1.password11==null||form1.password11.value=="")
 {
    alert("密码不能为空");
    return false;
 }
  else if(form1.studentpwd!=form1.password11)
  {
	alert("两次密码不一致")
	return false;
  }
 else
 return true;
}
</script>
</head>  
<body>  
    <b>用户注册</b>  
<br><br>  
<form method="post" action="regist">
  <table width="800" border="0" align="center" name="form1">  
  <tr>  
      <td width="80"><b>用户名:</b></td>  
      <td><input type="text" name="name"/></td>
      <td class="font1">不超过7个汉字，或14个字节（数字，字母和下划线）</td>  
  </tr>  
  <tr>  
     <td><b>密码：  </b></td>  
     <td><input type="password" name="password" size="20"/></td>  
     <td class="font1">最少6个字符，不超过14个字符（数字，字母和下划线）</td>  
  </tr>  
  <tr>  
      <td><b>确定密码：</b></td>  
      <td colspan="2">  
      <input type="password" name="password11" size="20"/>  
      </td>  
  </tr>  
  <tr>  
      <td><b>电话：</b></td>  
      <td colspan="2">  
      <input type="text" name="phone" size="20"/>  
      </td>  
  </tr>  
  <tr>  
      <td><b>现住址:</b></td>  
      <td><input type="text" name="location"/></td>  
      <td class="font1">请输入详细的现住址，接受活动邮件</td>  
  </tr>  
   <% String role  = request.getParameter("role"); 
		if (role.equals("student")) { %> 
  <tr>  
      <td><b>年龄：</b></td>  
      <td colspan="2">  
      <input type="text" name="studentAge" size="20"/>  
      </td>
  </tr> 
  <tr>  
     <td><b>性别：  </b></td>  
      <td colspan="2">  
      <input type="radio"  name="gender" value="女" checked/>女  
      <input type="radio"  name="gender" value="男"/>男<br><br>  
      </td>  
  </tr>  
  <%  } %> 
  <!-- <tr>  
    <td><b>验证码：</b></td>  
    <td><input type="text" name="check-img"/></td>  
    <td><img src="img/p2.png"></td>  
  </tr>    -->
  <!-- <tr>
  	<td colspan="3">  
  	<input type="radio" name="role" value="houseowner"/> 房主
    <input type="radio" name="role" value="student"/> 学生<br><br> 
    </td>
  </tr> -->
  <tr>  
    <td colspan="3">  
    <form method="post" action="">是否同意条款内容  
    <input type="radio" name="aggree" value="aggree" checked/> 我同意  
    <input type="radio" name="aggree" value="disaggree"/> 我不同意<br><br>  
    <textarea name="textarea" cols="100" rows="10" wrap="hard" >
    	条约内容...
    </textarea>  
    </form>  
    </td>     
  </tr>  
  <tr>  
  <td colspan="3" ><input type="submit" value="提交"/>  
  </td>  
  <td colspan="3" ><input type="reset" value="重置"/>  
  </td>  
  </tr>  
 </table>  
</form>
</body>  
</html>  