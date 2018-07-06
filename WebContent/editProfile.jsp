<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生住房系统</title>
<style type="text/css">
	table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;}
	th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
	.top{
		height: 25px;
		width: 100%;
		background-color: #ddd;
		position: fixed;
		top: 0;
		}
	 .center-in-center{   
        overflow:auto;
        position: absolute;        
        top: 25px;
        left:25%;
        }
	
	.footer{
		height: 50px;
		width: 100%;
		background-color: #ddd;
		position: fixed;
		bottom: 0;
		}
</style>
</head>
<body>
<div class="top">
	<div style="float:left">
		<c:if test="${not empty sessionScope.houseowner }">欢迎[${sessionScope.houseowner.ownerName }]访问</c:if>
		<c:if test="${not empty sessionScope.student }">欢迎[${sessionScope.student.studentName }]访问</c:if>  
	</div>
	<div style="margin-left: 200px; float:left"><b>修改您的资料</b></div>
	<div style="margin-right:20px; float:right">
		<a href="showInvation">查看请求</a>
		<a href="editProfile">修改资料</a>
		<a href="manageHouse">管理房屋</a>
		<a href="exit"style="color: #FF0000">退出</a>
	</div>
</div>
<div class="center-in-center">
<form method="post" action="edit" >
<table width="800" border="0" align="center">  
	<c:if test="${not empty sessionScope.houseowner }"> 
	  <tr>  
	      <td><b>电话：</b></td>  
	      <td colspan="2">  
	      <input type="text" name="studentPhone" size="20" value="${houseowner.getPhone()}"/>  
	      </td>  
	  </tr>  
	  <tr>  
	      <td><b>现住址:</b></td>  
	      <td><input type="text" name="studentLocation" value="${houseowner.getLocation()}"/></td>  
	  </tr>  
	  <input type="hidden" name="houseOwnerId" value="${houseowner.getHouseOwnerId()}"/>
	</c:if>
	<c:if test="${not empty sessionScope.student }">
	  <tr>  
	      <td><b>电话：</b></td>  
	      <td colspan="2">  
	      <input type="text" name="studentPhone" size="20" value="${student.getStudentPhone()}"/>  
	      </td>  
	  </tr>  
	  <tr>  
	      <td><b>现住址:</b></td>  
	      <td><input type="text" name="studentLocation" value="${student.getStudentLocation()}"/></td>  
	  </tr>  
	  <tr>  
	      <td><b>年龄：</b></td>  
	      <td colspan="2">  
	      <input type="text" name="studentAge" size="20" value="${student.getStudentAge()}"/>  
	      </td>
	  </tr> 
	  	  <input type="hidden" name="studentId" value="${student.getStudentId()}"/>
	</c:if>  
	<tr align="center">
		<td colspan="2"><input type="submit" value="提交"/></td>
	</tr>
</table>
</form>
</div>
<div class="footer" align="center">
	<p>DZGodly@github</p>
</div>
</body>
</html>