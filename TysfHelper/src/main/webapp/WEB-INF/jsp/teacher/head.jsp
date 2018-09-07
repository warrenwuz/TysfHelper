<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<nav class="navbar navbar-default row no-yj  navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav-list-left"
                    aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">太原师范学院自动办公</a>
        </div>
        <div class="collapse navbar-collapse pull-right" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-bell"><i
                        class="label label-warning label-nav">2</i></i> </a>
                    <ul class="dropdown-menu dropdown-menu-right">
                        <li><a href="#">提醒</a></li>
                    </ul>
                </li>
                <li><a class="dropdown-toggle" data-toggle="dropdown" href="#"><i
                        class="glyphicon glyphicon-envelope"><i
                        class="label label-success label-nav">${sessionScope.unreadcount}</i></i> </a>
                    <c:if test="${sessionScope.unreadcount!=''}">
                        <ul class="dropdown-menu dropdown-menu-right">
                            <li><a href="${path}/teacher/showUnreadMessage.do">你有${sessionScope.unreadcount}条留言消息待查看</a>
                            </li>
                        </ul>
                    </c:if>
                </li>
                <li><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="height: 50px"> <img
                        class="img-circle pull-left img-responsive nav-user-img" src="${path}/img/user/user.jpg"/><span
                        class="pull-left nav-username">${teacher.tname}</span></a>
                    <ul class="dropdown-menu dropdown-menu-right clearfix" style="padding-top: 0px">
                        <li class="user-li-head"><span> <img class="img-circle nav-user-img-xiala center-block"
                                                             src="${path}/img/user/user.jpg"/></span>
                            <p></p>
                            <p class="text-center text-primary">
                                <span>${sessionScope.name}</span>
                            </p>
                            <p class="text-center text-primary">
                                工号:<span>${sessionScope.id}</span>
                            </p></li>
                        <li style="padding: 10px 20px; padding-bottom: 20px">
                            <div class="pull-left"><a href="${path}/teacher/showTeacherMessage.do"
                                                      class="btn btn-default btn-flat no-yj">资料</a></div>
                            <div class="pull-right"><a href="${path}/quitLogin.do"
                                                       class="btn btn-default btn-flat no-yj">注销</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

