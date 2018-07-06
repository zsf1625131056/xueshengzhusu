<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生住房系统</title>
<style type="text/css">
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
	<div style="margin-left: 200px; float:left"><b>展示邀请</b></div>
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
		<th>会面时间</th>
		<th>会面地点</th>
		<th>房屋详情</th>
		<th>会面对象</th>
		<th>会面状态</th>
		<th>进行操作</th>
	</tr>
	<c:forEach items="${requestScope.meetInfos}" var="meetInfos" varStatus="status">
		<tr>
			<td>${meetInfos.meetTime}</td>
			<td>${meetInfos.meetLocation }</td>
			<td>位于${houseInfos[status.count-1].location}的${houseInfos[status.count-1].type}</td>
			<td><a href="information?studentId=${meetInfos.studentId }&houseOwnerId=${meetInfos.houseOwnerId}">查看对方信息</a>
			<c:if test="${not empty sessionScope.houseowner }">
				<td>
					<c:if test="${meetInfos.state==0}">未处理</c:if>
					<c:if test="${meetInfos.state==1}">已接受</c:if>
					<c:if test="${meetInfos.state==2}">已拒绝</c:if>
					<c:if test="${meetInfos.state==3}">已完成</c:if>
				</td>
				<td>
					<c:if test="${meetInfos.state==0}">
						<a href="handleInvation?idMeetInfo=${meetInfos.idMeetInfo}&state=1">进行会面</a>
						<a href="handleInvation?idMeetInfo=${meetInfos.idMeetInfo}&state=2">拒绝申请</a>
					</c:if>
					<c:if test="${meetInfos.state==1}">
						<a href="deal?idHouseInfo=${meetInfos.idHouseInfo}&available=0&studentId=${meetInfos.studentId}&state=3&idMeetInfo=${meetInfos.idMeetInfo}">同意申请</a>
					</c:if>
					<c:if test="${meetInfos.state==2}">
						<a href="handleInvation?idMeetInfo=${meetInfos.idMeetInfo}&state=4">删除邀请</a>
					</c:if>
				</td>
			</c:if>
			<c:if test="${not empty sessionScope.student }">
				<td>
					<c:if test="${meetInfos.state==0}">待处理</c:if>
					<c:if test="${meetInfos.state==1}">已通过</c:if>
					<c:if test="${meetInfos.state==2}">被拒绝</c:if>
					<c:if test="${meetInfos.state==3}">已完成</c:if>
				</td>
				<td>
					<c:if test="${meetInfos.state==2}">
						<a href="handleInvation?idMeetInfo=${meetInfos.idMeetInfo}&state=4">删除邀请</a>
					</c:if>
				</td>
			</c:if>
		</tr>
	</c:forEach>
</table>
</div>
<div class="footer" align="center">
	<p>DZGodly@github</p>
</div>
</body>
</html>