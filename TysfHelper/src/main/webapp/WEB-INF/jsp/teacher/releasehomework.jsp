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
                                        <input type="datetime" class="form-control" id="datetimepicker"
                                               name="sumbitdate">
                                        <span class="input-group-addon">
								<span class="glyphicon glyphicon-calendar"></span>
								</span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="name">通知班级</label> <select id="usertype"
                                                                           multiple="multiple" class="form-control"
                                                                           name="schoolclass">
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
    </div>
</div>
</body>
<%@ include file="/common/foot.jsp" %>
</html>