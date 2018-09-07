<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<title>详情</title>
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
	<div class="main-right  col-md-10 col-md-offset-2">
<div class="col-lg-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					个人信息
				</div>
				<div class="panel-body">
			<table class="table table-hover">
				<tr>
					<th class="col-lg-6">姓名</th>
					<td class="col-lg-12">吴哲</td>
				</tr>
				<tr>
					<th class="col-lg-6">工号</th>
					<td class="col-lg-6">400003</td>
				</tr>
				<tr>
					<th class="col-lg-6">所教班级</th>
					<td class="col-lg-6">2014计算 2014计算 2014计算 2014计算 </td>
				</tr>
				<tr>
					<th class="col-lg-6">课程</th>
					<td class="col-lg-6"> Java C语言 </td>
				</tr>
			</table>
			</div>
			</div>
		</div>
		</div>
</body>
</html>