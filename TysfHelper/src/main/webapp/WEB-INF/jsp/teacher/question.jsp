<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
<%@ include file="/common/common.jsp" %>
<body style="min-height: 800px; height: auto">
<div class="container-fluid">
    <%@ include file="head.jsp" %>
    <div class="row" style="margin-top: 70px">
        <%@ include file="menu.jsp" %>
        <div class="col-md-10 ">
            <div class="col-md-12">
                <ol class="breadcrumb">
                    <li><a href="${path}/teacher/classroomInteraction.do" class="no-hover">课堂互动</a></li>
                    <li class="active">课堂互动试题</li>
                </ol>
                <div class="panel panel-info">

                  <div class="panel-heading">
                      试题
                        <button class="btn btn-primary pull-right" data-toggle="modal" style="margin-top: -8px;"
                                data-target="#myModal">新增
                        </button>
                    </div>
                    <table id="table"></table>
                </div>
            </div>
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
                                aria-hidden="true">&times;
                        </button>
                        <h4 class="modal-title" id="myModalLabel">课堂互动</h4>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label for="questionContent">试题题目</label>
                            <textarea class="form-control" rows="3" name="questionContent"
                                      id="questionContent"></textarea>
                        </div>
                        <div class="form-group">
                            <label>选项设置</label>
                            <div class="radio">
                                <label><input type="radio" value="0" name="questionOption" class="questionOptionIndex">A</label>
                                <textarea class="form-control questionOption" rows="2"></textarea>
                            </div>
                            <div class="radio">
                                <label><input type="radio" value="1" name="questionOption" class="questionOptionIndex">B</label>
                                <textarea class="form-control questionOption" rows="2"></textarea>
                            </div>
                            <div class="radio">
                                <label><input type="radio" value="2" name="questionOption" class="questionOptionIndex">C</label>
                                <textarea class="form-control questionOption" rows="2"></textarea>
                            </div>
                            <div class="radio">
                                <label><input type="radio" value="3" name="questionOption" class="questionOptionIndex">D</label>
                                <textarea class="form-control questionOption" rows="2"></textarea>
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
<script id="questionJs" src="${path}/js/teacher/question.js" data="${ciid}"></script>
<%@ include file="/common/foot.jsp" %>
</html>