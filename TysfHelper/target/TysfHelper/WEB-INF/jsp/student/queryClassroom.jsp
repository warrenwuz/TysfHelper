<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />

<link href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="${path}/css/queryClassroom.css" />
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://res.wx.qq.com/open/libs/weuijs/1.1.2/weui.min.js"></script>
<script type="text/javascript" src="${path}/js/queryClassroom.js"></script>
<title></title>
</head>

<body style="background-color: wheat;">
	<div class="page">
		<div class="page__hd">
			<div class="page__title">
				<h1>空教室查询</h1>
			</div>
			<div class="page__bd">
				<form action="${path}/queryClassroom.do"
					method="post" id="formRoom">
					<div class="weui-cells  emptyfree-room">
						<div class="weui-cell weui-cell_select weui-cell_select-after">
							<div class="weui-cell__hd">
								<label class="weui-label" for="">教学楼</label>
							</div>
							<div class="weui-cell__bd">
								<div class="weui-cell weui-cell_access JXL-picker">请选择教学楼</div>
								<input type="hidden" name="Sel_JXL" value="" id="Sel_JXL" /> <input
									type="hidden" name="JXL_Name" value="" id="JXL_Name" />
							</div>
						</div>
						<div class="weui-cell weui-cell_select weui-cell_select-after">
							<div class="weui-cell__hd">
								<label class="weui-label" for="">教室类型</label>
							</div>
							<div class="weui-cell__bd">
								<div class="weui-cell weui-cell_access jslx——picker">一般教室</div>
								<input type="hidden" name="sel_jslx" value="01" id="sel_jslx" />
							</div>
						</div>
						<div class="weui-cell weui-cell_select weui-cell_select-after">
							<div class="weui-cell__hd">
								<label class="weui-label" for="">日期</label>
							</div>
							<div class="weui-cell__bd">
								<div class="weui-cell weui-cell_access date-picker"></div>
								<input type="hidden" name="Sel_ZC" value="" id="Sel_ZC" />
							</div>
						</div>
						<div class="weui-cell weui-cell_select weui-cell_select-after">
							<div class="weui-cell__hd">
								<label class="weui-label" for="">时间</label>
							</div>
							<div class="weui-cell__bd">
								<div class="weui-cell weui-cell_access time-picker">请选择时间段</div>
								<input type="hidden" name="Sel_JC" value="" id="Sel_JC" />
							</div>
						</div>
						<input type="hidden" name="Submit01" value="检索" /> <input
							type="hidden" name="selxqs" value="" id="selxqs" /> <input
							type="hidden" name="sel_room" value="" /> <input type="hidden"
							name="sel_roomname" value="" /> <input type="hidden"
							name="SelXN" value="20170" /> <input type="hidden" name="sel_xq"
							value="4" />
					</div>
					<input type="submit" value="一键查询"
						class="weui-btn weui-btn_primary form-submit" />
				</form>
			</div>
			<div class="page__ft">
				<div class="weui-footer">
					<p class="weui-footer__links">
						<a href="javascript:void(0);" class="weui-footer__link">太原师范学院助手</a>
					</p>
					<p class="weui-footer__text">Copyright &copy; 2008-2017 weui.io</p>
				</div>
			</div>
		</div>
	</div>
</body>

</html>