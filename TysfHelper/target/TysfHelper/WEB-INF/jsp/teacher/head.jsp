<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
 <link href="${path}/css/base.css" rel="stylesheet" />
<link rel="stylesheet" href="${path}/css/index.css" />
</head>
<body style="min-height: 800px; height: auto">
	<div class="container-fluid">
		<nav class="navbar navbar-default row no-yj  navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#nav-list-left"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">太原师范学院自动办公</a>
				</div>
				<div class="collapse navbar-collapse pull-right"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a class="dropdown-toggle" data-toggle="dropdown" 
						href="#"><i class="glyphicon glyphicon-bell"><i
									class="label label-warning label-nav">2</i></i> </a>
							<ul class="dropdown-menu dropdown-menu-right">
								<li><a href="#">提醒</a></li>
							</ul></li>
						<li><a class="dropdown-toggle" data-toggle="dropdown"
							href="#"><i class="glyphicon glyphicon-envelope"><i
									class="label label-success label-nav">${sessionScope.unreadcount}</i></i> </a>
                          <c:if test="${sessionScope.unreadcount!=''}">
							<ul class="dropdown-menu dropdown-menu-right">
								<li><a href="${path}/teacher/showUnreadMessage.do">你有${sessionScope.unreadcount}条留言消息待查看</a></li>
							</ul>
							</c:if>
							</li>
						<li><a class="dropdown-toggle" data-toggle="dropdown"
							href="#" style="height: 50px"> <img
								class="img-circle pull-left img-responsive nav-user-img"
								src="${path}/img/user/user.jpg" /><span class="pull-left nav-username">${teacher.tname}</span></a>

							<ul class="dropdown-menu dropdown-menu-right clearfix"
								style="padding-top: 0px">
								<li class="user-li-head"><span> <img
										class="img-circle nav-user-img-xiala center-block"
										src="${path}/img/user/user.jpg" /></span>
									<p></p>
									<p class="text-center text-primary">
										<span>${sessionScope.name}</span>
									</p>
									<p class="text-center text-primary">
										工号:<span>${sessionScope.id}</span>
									</p></li>
								<li style="padding: 10px 20px; padding-bottom: 20px">

									<div class="pull-left">
										<a href="${path}/teacher/showTeacherMessage.do" class="btn btn-default btn-flat no-yj">资料</a>
									</div>
									<div class="pull-right">
										<a href="${path}/quitLogin.do" class="btn btn-default btn-flat no-yj">注销</a>
									</div>
								</li>
							</ul></li>
					</ul>
				</div>
			</div>
		</nav>
		<div class="row" style="margin-top: 70px">
			<div class="  nav-left col-md-2 no-padding" id="nav-list-left">
				<div class="user-panel">
					<img src="${path}/img/user/user.jpg" class="img-circle center-block" />
				</div>
				<div class="nav-list">
					<ul>
						<li class="nav-left-dropdown"><a href="#">教学安排</a>
							<ul class="nav-left-dropdown-menu">
								<li><a href="${path}/teacher/classroomInteraction.do">课堂互动</a></li>
                               <li><a href="${path}/teacher/releasehomework.do">发布作业</a></li>
							</ul></li>
						<li><a href="${path}/teacher/showMessage.do">学生留言</a></li>
					
					</ul>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(function() {
		$(".dropdownMenu").dropdown();
		$(".nav-left-dropdown>a").click(function() {
			if($(this).attr("d") != 1 && $(this).attr("d") != undefined) {
				$(this).removeClass("nav-left-dropdown-a");
				$this = $(this);
				$(this).next("ul").slideUp(300, function() {
					$this.removeClass("nav-left-bottrom-border");
					$this.removeClass("nav-left-dropdown-ul")
				});

				$(this).attr("d", "1");

			} else {
				$(this).addClass("nav-left-dropdown-a");
				$(this).addClass("nav-left-bottrom-border");
				$(this).next("ul").addClass("nav-left-dropdown-ul").slideDown(300);
				$(this).attr("d", "2");

			}

		});
	})
	
	</script>
