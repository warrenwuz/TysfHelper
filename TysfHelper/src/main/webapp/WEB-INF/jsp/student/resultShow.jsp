<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/zepto/1.2.0/zepto.js"></script>
		<script type="text/javascript" src="https://res.wx.qq.com/open/libs/weuijs/1.1.2/weui.min.js"></script>
		<link rel="stylesheet" href="${path}/css/resultShow.css" />
		<title></title>
	</head>

	<body style="background-color: wheat;">
		<div class="page">
			<div class="page__hd">
				<div class="page__title">
					<h2>太原师范学院空闲教室</h2>
				</div>
			</div>
			<div class="page__bd page__bd_spacing">
			<c:forEach items="${resultMap}"  var="result">
				<div class="weui-flex weui-result_hd">
					<div class="weui-flex__item">
						<div class="placeholder" style="color: gray;">
							<h3>${floor} &nbsp;&nbsp;&nbsp;&nbsp;${result.key}层</h3>
						</div>
					</div>
				</div>
					<div class="weui-cell weui-result_bd">
				<c:forEach items="${result.value}" var="value">
					<div class="weui-cell__item weui-result_item">
						<div class="placeholder">${value}</div>
					</div>
				</c:forEach>
				</div>
				</c:forEach>
			</div>
		</div>
	</body>

</html>