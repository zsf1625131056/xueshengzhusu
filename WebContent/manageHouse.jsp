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
	<div style="margin-left: 200px; float:left"><b>管理房屋</b></div>
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
		<th>地区</th>
		<th>类型</th>
		<th>人数限制</th>
		<th>租金</th>
		<c:if test="${not empty sessionScope.houseowner }"><th>出租状态</th></c:if>
		<th>其他信息</th>
	</tr>
	<c:forEach items="${requestScope.houseList }" var="houseInfo">
		<tr>
			<td>${houseInfo.location}</td>
			<td>${houseInfo.type }</td>
			<td>${houseInfo.theLimit }</td>
			<td>${houseInfo.rent }</td>
			<c:if test="${not empty sessionScope.student }">
				<td><a href="information?houseOwnerId=${houseInfo.houseOwnerId }">房主信息</a>
				<td><a href="deal?idHouseInfo=${houseInfo.idHouseInfo}&available=1&studentId=${sessionScope.student.studentId}">申请退房</a></td>
			</c:if>  
			<c:if test="${not empty sessionScope.houseowner }">
			<td>
				<c:if test="${houseInfo.available==0}">
					已租出
				</c:if>
				<c:if test="${houseInfo.available==1}">
					待租出
				</c:if>
			</td>
			<td><c:if test="${houseInfo.available==0}">
				<a href="information?idHouseInfo=${houseInfo.idHouseInfo}">房客信息</a>
			</c:if></td>
			<td><a href="editHouse?idHouseInfo=${houseInfo.idHouseInfo}">修改房屋</a></td>
			<td><a href="deleteHouse?idHouseInfo=${houseInfo.idHouseInfo}">删除房屋</a></td>
			</c:if>
		</tr>
	</c:forEach>
	<c:if test="${not empty sessionScope.houseowner }">
		<tr>
			<td><input type="button" value="添加房屋信息" onclick="window.location.href='addHouse.jsp'"/></td>
		</tr>
	</c:if>
</table>
</div>
<div class="footer" align="center">
	<p>DZGodly@github</p>
</div>
</body>
</html>