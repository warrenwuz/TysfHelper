<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/css/base.css" rel="stylesheet" />
<link rel="stylesheet" href="${path}/css/index.css" />
<link rel="stylesheet" href="${path}/css/bootstrap-multiselect.css" />
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">
<link href="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet"/>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
	 <jsp:include page="head.jsp"></jsp:include>
	<div class="main-right  col-md-10 col-md-offset-2">
		<div class="col-md-12">
			<div class="panel panel-info">
				<div class="panel-heading">
				课堂互动
					<!-- <div class="clearfix">
						<div class="pull-left" style="font-size: 24px;"></div>
						
					</div> -->
							<button class="btn btn-primary pull-right" data-toggle="modal" style="margin-top: -8px;"
								data-target="#myModal">新增</button>
				</div>
				<table id="table"></table>
			</div>
		</div>
	</div>
	<!-- 增加互动 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">课堂互动</h4>
				</div>
				<div class="modal-body">
					<form role="form" action="http://www.baidu.com">
						<div class="form-group">
							<label for="name">互动主题</label> <input type="text"
								class="form-control" id="ciname" placeholder="请输入互动主题">
						</div>
						<!-- <div class="form-group">
								<label for="name">通知班级</label> <select id="schoolclass"
									multiple="multiple" class="form-control" name="schoolclass">
								</select>
					    </div> -->
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id='hudongsumbit'>提交</button>
				</div>
			</div>
		</div>
	</div>
		<!-- 设置互动班级 -->
	<div class="modal fade" id="addSchoolCLass" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">课堂互动</h4>
				</div>
				<div class="modal-body">
					<form role="form" id="createClassroomInteractionForm" action="${path}/teacher/createClassroomInteraction.do">
					 <input type="hidden" name='ciid' id='ciid'> 
					 <div class="form-group">
								<label for="name">通知班级</label> <select id="schoolclass"
									multiple="multiple" class="form-control" name="schoolclass">
								</select>
					    </div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" id='createClassroomInteraction'>生成</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/js/bootstrap-multiselect.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/x-editable/1.5.0/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/extensions/editable/bootstrap-table-editable.min.js"></script>
<script src="${path}/js/layer/layer.js"></script>
<script src="${path}/js/teacher/hudong.js"></script>
</html>