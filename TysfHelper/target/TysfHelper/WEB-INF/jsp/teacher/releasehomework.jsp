<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="${path}/css/webuploader.css" />
<link rel="stylesheet"href="${path}/css/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="${path}/css/bootstrap-multiselect.css" />
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap-datetimepicker.min.js"></script>
<script type="text/javascript"src="${path}/js/bootstrap-datetimepicker.zh-CN.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap-multiselect.js"></script>
<script type="text/javascript" src="${path}/js/webuploader.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="main-right  col-md-10 col-md-offset-2">
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">发布作业</div>
				<div class="panel-body">
					<div class="col-md-2"></div>
					<div class="col-md-8">
						<form role="form" class="form-horizontal" id="Hfrom">
							<div class="form-group">
								<label for="title" class="control-label">作业标题</label> <input
									type="text" class="form-control" id="htitle"
									placeholder="请输入作业标题" name="title">
							</div>
							<div class="form-group">
								<label for="sumbitdate" class="control-label">提交日期</label> 
								<div class="input-group">
								<input type="datetime" class="form-control" id="datetimepicker"name="sumbitdate"> 
								<span class="input-group-addon">
								<span class="glyphicon glyphicon-calendar"></span>
								</span>
								</div>
							</div>
							<div class="form-group">
								<label for="name">通知班级</label> <select id="usertype"
									multiple="multiple" class="form-control" name="schoolclass">
								</select>
							</div>
							<div class="form-group">
								<label for="name">作业要求 </label> <span><a id="picker">添加附件</a></span>
								<textarea class="form-control" rows="3" placeholder="请输入作业要求"
									id="hcontent" name="content"></textarea>
								<ul id="thelist" class="list-group">
								</ul>
							</div>
						</form>
					</div>
					<div class="col-md-12">
						<button class="btn btn-success col-md-12" id="ctlBtn">发布作业</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$().ready(
					function() {
						$.ajax({
							type : "post",
							url : "${path}/teacher/querySchoolClass.do",
							success : function(json) {
								$.each($.parseJSON(json), function(i, val) {
									$("#usertype").append(
											"<option value='"+val.cid+"'>"
													+ val.cname + "</option>");
								})
								$('#usertype').multiselect({
									nonSelectedText : "请选择需要通知的班级",
									nSelectedText : "个班级",
									allSelectedText : "全部班级",
								});
							}
						})
						$('#datetimepicker').datetimepicker({
							format: 'yyyy-mm-dd',
					        language: 'zh-CN',
					        minView: "month",
					        autoclose:true,
					        todayBtn:true
						});
						var uploader = WebUploader.create({
							auto : true,
							// swf文件路径
							swf : '${path}/js/Uploader.swf',
							// 文件接收服务端。
							server : '${path}/Uploadfile.do',
							// 选择文件的按钮。可选。
							// 内部根据当前运行是创建，可能是input元素，也可能是flash.
							pick : '#picker',
							// 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
							resize : false,
							multiple : false
						});
						uploader
								.on(
										'uploadProgress',
										function(file, percentage) {
											$("#ctlBtn").attr("disabled",
													"disabled");
											var $li = $('#' + file.id), $percent = $li
													.find('.progress .progress-bar');
											// 避免重复创建
											if (!$percent.length) {
												$percent = $(
														'<div class="progress progress-striped active">'
																+ '<div class="progress-bar" role="progressbar" style="width: 0%">'
																+ '</div>'
																+ '</div>')
														.appendTo($li)
														.find('.progress-bar');
											}

											$li.find('p.state').text('上传中');

											$percent.css('width', percentage
													* 100 + '%');
										});
						// 当有文件被添加进队列的时候
						uploader.on('fileQueued', function(file) {
							$("#thelist").append(
									'<li id="' + file.id + '" class="item list-group-item">'
											+ '<h4 class="info">' + file.name
											+ '</h4>'
											+ '<p class="state">等待上传...</p>'
											+ '</li>');
						});
						uploader.on('uploadSuccess',
										function(file, data) {
											$("#ctlBtn").attr("disabled", null);
											if (data._raw == 0) {
												$('#' + file.id).find('p.state').text('服务器上传出错');
											} else {
												$("#" + file.id).append("<input type='checkbox' name='file' value='"+data._raw+"' checked='checked' hidden='hidden'>")
												$('#' + file.id).find('p.state').text('已上传');
											}
										});

						uploader.on('uploadError', function(file) {
							$("#ctlBtn").attr("disabled", null);
							$('#' + file.id).find('p.state').text('上传出错');
						});

						uploader.on('uploadComplete', function(file) {
							$('#' + file.id).find('.progress').fadeOut();
						});

						$("#ctlBtn").on('click', function() {
							$("#sumbitdate").val();
							uploader.upload();
							$.ajax({
								type : "post",
								url : "${path}/teacher/releasehomework.do",
								data : $("#Hfrom").serialize(),
								success:function(){
									alert('发布成功')
								}
							})

						});

					})
</script>
</html>