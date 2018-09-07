<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
<%@ include file="/common/common.jsp" %>
<div class="container-fluid">
    <%@ include file="head.jsp" %>
    <div class="row" style="margin-top: 70px">
        <%@ include file="menu.jsp" %>
        <div class="col-md-10 ">
            <div class="col-md-12">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        课堂互动
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
                    <form role="form" action="http://www.baidu.com">
                        <div class="form-group">
                            <label for="name">互动主题</label>
                            <input type="text" class="form-control" id="ciname" placeholder="请输入互动主题">
                        </div>
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
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">课堂互动</h4>
                </div>
                <div class="modal-body">
                    <form role="form" id="createClassroomInteractionForm"
                          action="${path}/teacher/createClassroomInteraction.do">
                        <input type="hidden" name='ciid' id='ciid'>
                        <div class="form-group">
                            <label for="name">通知班级</label> <select id="schoolclass"
                                                                   multiple="multiple" class="form-control"
                                                                   name="schoolclass">
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
<%@ include file="/common/foot.jsp" %>
<script src="${path}/js/teacher/hudong.js"></script>
</html>