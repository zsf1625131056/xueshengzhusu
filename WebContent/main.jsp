<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生住房系统</title>
<style type="text/css">
	table{border-collapse:collapse;border-spacing:0;border-left:1px solid #888;border-top:1px solid #888;background:#efefef;}
	th,td{border-right:1px solid #888;border-bottom:1px solid #888;padding:5px 15px;}
	th{font-weight:bold;background:#ccc;}
	
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
	<div style="margin-left: 200px; float:left"><b>首页</b>------显示可租用房屋</div>
	 <div style="margin-right:20px; float:right">
		<a href="showInvation">查看请求</a>
		<a href="editProfile">修改资料</a>
		<a href="manageHouse">管理房屋</a>
		<a href="exit"style="color: #FF0000">退出</a>
	</div>
</div>
<div class="center-in-center">
<table border="1"  align="center">
	<tr>
		<th>地区</th><th>类型</th><th>人数限制</th><th>租金</th>
	</tr>
	<c:forEach items="${requestScope.house_list }" var="HouseInfo">
		<tr>
			<td>${HouseInfo.location}</td>
			<td>${HouseInfo.type }</td>
			<td>${HouseInfo.theLimit }</td>
			<td>${HouseInfo.rent }</td>
			<td><a href="detail?houseId=${HouseInfo.idHouseInfo}">查看详情</a></td>
		</tr>
	</c:forEach>
	<tr><td><input type="button" value="显示已租用房屋" onclick="window.location.href='main'">
</table>
</div>
<div class="footer" align="center">
	<p>DZGodly@github</p>
</div>
</body>
</html>