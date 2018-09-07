<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${path}/css/base.css" rel="stylesheet" />
<link rel="stylesheet" href="${path}/css/index.css" />
<script type="text/javascript"
	src="http://cdn.bootcss.com/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript"
	src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
	<div class="main-right  col-md-10 col-md-offset-2">
		<div class="col-md-12">
			<div class="panel panel-info">
				<div class="panel-heading">互动详情</div>
				<div class="panel-body">
					<table class="table table-bordered tb-hover">
						<thead>
							<tr>
								<td class="text-center">序号</td>
								<td class="text-center">标题</td>
								<td class="text-center">时间</td>
								<td class="text-center">班级</td>
								<td class="text-center">操作</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="text-center">1</td>
								<td class="text-center">小易速度发货的顺丰快递费是</td>
								<td class="text-center">8:00~9:00</td>
								<td class="text-center">201401,201402</td>
								<td class=" text-center"><a href="#"><i
										class="glyphicon glyphicon-search"></i></a>&nbsp;&nbsp; <a
									href="#"><i class="glyphicon glyphicon-edit"></i></a></td>
							</tr>
							<tr>
								<td class="text-center">1</td>
								<td class="text-center">小易速度发货的顺丰快递费是</td>
								<td class="text-center">8:00~9:00</td>
								<td class="text-center">201401,201402</td>
								<td class=" text-center"><a href="#"><i
										class="glyphicon glyphicon-search"></i></a>&nbsp;&nbsp; <a
									href="#"><i class="glyphicon glyphicon-edit"></i></a></td>
							</tr>
						</tbody>
					</table>
					<button type="button" class="btn btn-block btn-primary"
						data-toggle="modal" data-target="#myModal2">添加试题</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal2" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">添加试题</h4>
				</div>
				<div class="modal-body">
					<form role="form" action="http://www.baidu.com">
						<div class="form-group">
							<label for="name">试题类型</label> <select class="form-control"
								name="questionType" id="questionType">
								<option value="1">选择题</option>
								<option value="2">问答题</option>
							</select>
						</div>
						<div class="form-group">
							<label for="questionContent">试题题目</label>
							<textarea class="form-control" rows="3" name="questionContent"
								id="questionContent"></textarea>
						</div>
						<div class="form-group" id="questionKeyword" hidden="hidden">
							<label for="questionKeyword" data-toggle="tooltip"
								title="用于评定学生的答题情况，最多为4个关键字">关键字</label> <input type="text"
								class="form-control" placeholder="每个关键字用逗号隔开" />
						</div>
						<div class="form-group" id="questionAnswer" hidden="hidden">
							<label for="questionContent">试题答案</label>
							<textarea class="form-control" rows="6" name="questionContent"
								id="questionContent"></textarea>
						</div>
						<div class="form-group" id="questionOption">
							<label for="questionOption">选项设置</label>
							<div class="radio">
								<label><input type="radio" value=""
									name="questionOption">A</label>
								<textarea class="form-control" rows="2" name="questionContent"
									id="questionContent"></textarea>
							</div>
							<div class="radio">
								<label><input type="radio" value=""
									name="questionOption">B</label>
								<textarea class="form-control" rows="2" name="questionContent"
									id="questionContent"></textarea>
							</div>
							<div class="radio">
								<label><input type="radio" value=""
									name="questionOption">C</label>
								<textarea class="form-control" rows="2" name="questionContent"
									id="questionContent"></textarea>
							</div>
							<div class="radio">
								<label><input type="radio" value=""
									name="questionOption">D</label>
								<textarea class="form-control" rows="2" name="questionContent"
									id="questionContent"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<input type="submit" class="btn btn-primary" />
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>
</body>
<script type="text/javascript">
$().ready(function() {
	$("#questionType").change(function(){
		$("#questionKeyword").toggle();
	   $("#questionAnswer").toggle();
	   $("#questionOption").toggle();
	})

})

</script>
</html>