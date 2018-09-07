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
    <link rel="stylesheet" href="${path}/js/layer/theme/default/layer.css">
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
                课堂互动试题
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
                    <div class="form-group">
                        <label for="questionContent">试题题目</label>
                        <textarea class="form-control" rows="3" name="questionContent" id="questionContent"></textarea>
                    </div>
                    <div class="form-group">
                        <label>选项设置</label>
                        <div class="radio">
                            <label><input type="radio" value="0" name="questionOption" class="questionOptionIndex">A</label>
                            <textarea class="form-control questionOption" rows="2" ></textarea>
                        </div>
                        <div class="radio">
                            <label><input type="radio" value="1" name="questionOption" class="questionOptionIndex">B</label>
                            <textarea class="form-control questionOption" rows="2" ></textarea>
                        </div>
                        <div class="radio">
                            <label><input type="radio" value="2" name="questionOption" class="questionOptionIndex">C</label>
                            <textarea class="form-control questionOption" rows="2" ></textarea>
                        </div>
                        <div class="radio">
                            <label><input type="radio" value="3" name="questionOption" class="questionOptionIndex">D</label>
                            <textarea class="form-control questionOption"  rows="2"></textarea>
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id='questionSubmit'>提交</button>
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
<script id="questionJs" src="${path}/js/teacher/question.js" data="${ciid}"></script>
</html>