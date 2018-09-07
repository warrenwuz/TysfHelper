<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="icon" href="img/logo.png" />
		<title>师院助手管理系统</title>
		<link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
		<style>
			html,
			body {
				height: 100%;
			}
			
			.box {
				background-image: url("${path}/img/bg-login.png");
				background-repeat: no-repeat;
				background-size: 100%;
				margin: 0 auto;
				position: relative;
				width: 100%;
				height: 100%;
			}
			
			.login-box {
				width: 100%;
				max-width: 500px;
				height: 400px;
				position: absolute;
				top: 50%;
				margin-top: -200px;
				/*设置负值，为要定位子盒子的一半高度*/
			}
			
			@media screen and (min-width:500px) {
				.login-box {
					left: 50%;
					/*设置负值，为要定位子盒子的一半宽度*/
					margin-left: -250px;
				}
			}
			
			.form {
				width: 100%;
				max-width: 500px;
				height: 275px;
				margin: 25px auto 0px auto;
				padding-top: 25px;
			}
			
			.login-content {
				height: 340px;
				width: 100%;
				max-width: 500px;
				background-color: rgba(255, 250, 2550, .6);
				float: left;
			}
			
			.input-group {
				margin: 0px 0px 30px 0px !important;
			}
			
			.form-control,
			.input-group {
				height: 40px;
			}
			
			.form-group {
				margin-bottom: 0px !important;
			}
			
			.login-title {
				padding: 20px 10px;
				background-color: rgba(0, 0, 0, .6);
			}
			
			.login-title h1 {
				margin-top: 10px !important;
			}
			
			.login-title small {
				color: #fff;
			}
			
			.link p {
				line-height: 20px;
				margin-top: 30px;
			}
			
			.btn-sm {
				padding: 8px 24px !important;
				font-size: 16px !important;
			}
			
			.text-white {
				color: white;
			}
		</style>
	</head>

	<body>
		<div class="box">
			<br/>
			<h1 class="text-center text-white"><span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;师院助手系统</h1>
			<div class="login-box">
				<div class="login-title text-center">
					<h1><small>登录</small></h1>
				</div>
				<div class="login-content ">
					<div class="form">
						<form action="${path}\login.do" method="post" id="loginForm">
							<div class="form-group">
								<div class="col-xs-12">
									<div class="input-group">
										<span class="input-group-addon"><span class="glyphicon glyphicon-education"></span></span>
										<select class="form-control" name="type">
											<option value="">请选择身份</option>
											<option value="teacher">教师</option>
											<option value="classadmin">班级管理员</option>
											<option value="admin">后台管理员</option>
										</select>
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-12  ">
									<div class="input-group">
										<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
										<input type="text" id="username" name="username" class="form-control" placeholder="用户名">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-12  ">
									<div class="input-group">
										<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
										<input type="password" id="password" name="password" class="form-control" placeholder="密码">
									</div>
										<span style="color: red;">${error}</span>
								</div>
							</div>
							<div class="form-group form-actions">
								<div class="col-xs-4 col-xs-offset-4 " style="margin: 0 37%;">
									<input class="btn btn-sm btn-info" type="submit" value="登陆"></input>
								</div>
							</div>
							
						</form>
					</div>
				</div>
			</div>
		</div>

		<script src="https://cdn.bootcss.com/jquery/2.2.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="https://cdn.bootcss.com/jquery-validate/1.17.0/jquery.validate.min.js"></script>
		<script type="text/javascript">
			$().ready(function() {
				$("#loginForm").validate({
					rules: {
						type: "required",
						username: "required",
						password: "required"
					},
					messages: {
						type: "请选择您的身份",
						username: "请输入用户ID",
						password: "请输入密码"
					},
					errorClass: "error",
					success: 'valid',
					unhighlight: function(element, errorClass, validClass) { //验证通过
						$(element).tooltip('destroy').removeClass(errorClass);
					},
					errorPlacement: function(error, element) {
						if($(element).next("div").hasClass("tooltip")) {
							$(element).attr("data-original-title", $(error).text()).tooltip("show");
						} else {
							$(element).attr("title",$(error).text()).tooltip("show");
						}
					},
					submitHandler: function(form) {
						form.sumbit();
					}
				})

			})
		</script>
	</body>
</html>