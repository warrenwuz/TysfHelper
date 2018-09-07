<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="weui-tab__content">
		<div class="weui-panel weui-panel_access">
			<div class="weui-panel__hd">留言记录</div>
			<div class="weui-panel__bd">
				<c:forEach var="message" items="${messageList}">
					<div class="weui-media-box weui-media-box_text">
						<h4 class="weui-media-box__title">${message.tname}:</h4>
						<p class="weui-media-box__desc">${message.content}</p>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>