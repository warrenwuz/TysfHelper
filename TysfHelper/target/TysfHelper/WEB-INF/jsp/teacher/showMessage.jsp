<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript" src="${path}/js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="main-right  col-md-10 col-md-offset-2">
		<div class="col-md-12">
			<c:forEach items="${messageList}" var="map">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">学号:${map.stuId} 班级:${map.cname}
							姓名:${map.sname}</h3>
					</div>
					<div class="panel-body">
						    ${map.content}<!-- 留言的内容 -->
						<div class="time clearfix">
						<!-- 留言的时间戳 -->
							<span class="pull-right">${map.timestamp}</span>
						</div>
						<div class="replyMessage" style="margin-top: 20px;">
							<ul class="list-group" id="replayMessage_${map.mid}">
							<!-- 回复留言的列表-->
						<c:forEach items="${map.repalyMessageList}" var="replymessage">
						  <li class="list-group-item">
								  <span class="text-primary">
									   <c:if test="${replymessage.usermark==1}">我</c:if>
									   <c:if test="${replymessage.usermark==2}">${map.sname}</c:if> 
								  </span>:${replymessage.rmcontent}
											 <!-- 回复留言的时间戳 -->
								<div class="time clearfix">
									 <span class="pull-right">${fn:substring(replymessage.timestamp, 0, 19)}</span>
								</div>
							</li>
						</c:forEach>
							</ul>
						</div>
						<div class="text-success clearfix">
							<span class="pull-right">
								<button class="btn btn-primary reply-btn" value="${map.mid}">回复</button>
								<button class="btn btn-danger delete-btn" value="${map.mid}">删除</button>
							</span>
						</div>
						<div class="form" style="margin-top: 20px;" hidden="hidden"
							id="form${map.mid}">
							<form role="form">
								<div class="form-group">
									<textarea class="form-control" rows="3"
										id="reply-content_${map.mid}" placeholder="请输入你想回复的话"></textarea>
								</div>
							</form>
							<button class="btn btn-default reply-submit" value="${map.mid}">提交</button>
							<button class="btn btn-default reply-cancel" value="${map.mid}">取消</button>
						</div>
					</div>

				</div>
			</c:forEach>
		</div>
	</div>
</body>
<script type="text/javascript" src="${path}/js/showmessage.js"></script>
</html>