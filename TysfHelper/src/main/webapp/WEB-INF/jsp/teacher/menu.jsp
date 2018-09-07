<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="  nav-left col-md-2 no-padding" id="nav-list-left">
    <div class="user-panel">
        <img src="${path}/img/user/user.jpg" class="img-circle center-block"/>
    </div>
    <div class="nav-list">
        <ul>
            <li class="nav-left-dropdown"><a href="#">教学安排</a>
                <ul class="nav-left-dropdown-menu">
                    <li><a href="${path}/teacher/classroomInteraction.do">课堂互动</a></li>
                    <li><a href="${path}/teacher/releasehomework.do">发布作业</a></li>
                </ul>
            </li>
            <li><a href="${path}/teacher/showMessage.do">学生留言</a></li>

        </ul>
    </div>
</div>

