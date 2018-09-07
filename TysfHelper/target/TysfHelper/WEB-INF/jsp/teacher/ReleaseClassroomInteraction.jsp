<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>发布课堂互动</title>
		<link href="https://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	</head>
	<script>
		$().ready(function() {
			var index = 0;
			var websocket = null;
			//判断当前浏览器是否支持WebSocket
			if('WebSocket' in window) {
				websocket = new WebSocket("ws://localhost:8080/TysfHelper/ClassroomInteractionWebSocket.do");
			} else {
				alert('当前浏览器 Not support websocket')
			}
			//连接发生错误的回调方法
			websocket.onerror = function() {};
			//连接成功建立的回调方法
			websocket.onopen = function() {
			}
			//接收到消息的回调方法
			websocket.onmessage = function(event) {
				var li = $("<li class='list-group-item'>"+event.data+"</li>");
				$(".list-group").append(li);
				li.fadeIn("slow")
			}
			//连接关闭的回调方法
			websocket.onclose = function() {
				alert('WebSocket连接关闭')
			}
			//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
			window.onbeforeunload = function() {
				closeWebSocket();
			}
			$("#test").click(function() {
				websocket.send('你好')
			})
		})
	</script>
	<body>
		<div class="row">
			<div class="panel panel-primary">
				<div class="panel-heading text-center">在线课堂互动</div>

			</div>
			<div class="col-md-4">
				<img src="${path}/teacher/downCodeImage.do?ticket=${ticket}" class="img-rounded">
				<button class="btn btn-primary" id="test">测试</button>
			</div>
			<div class="col-md-7">
				<ul class="list-group">
					<li class="list-group-item">免费域名注册231121231231231123112313333333333333333333 免费域名注册231121231231231123112313333333333333333333免费域名注册231121231231231123112313333333333333333333
					</li>
					<li class="list-group-item">免费 Window 空间托管</li>
					<li class="list-group-item">图像的数量</li>
					<li class="list-group-item">24*7 支持</li>
					<li class="list-group-item">每年更新成本</li>
				</ul>
			</div>
		</div>
	</body>
</html>