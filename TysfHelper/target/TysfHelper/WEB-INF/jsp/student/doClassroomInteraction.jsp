<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no"/>
    <link href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css" rel="stylesheet"/>
    <title>课堂互动</title>
    <style type="text/css">
        input {
            padding-left: 10%;
        }

        .weui-cell_access {
            color: #A9A9A9;
            padding-left: 10%;
        }

        .page__hd {
            background-image: url(${path}/img/logobg.png);
            height: 50px;
            width: 100%;
        }

        #text_title {
            text-align: center;
            color: white;
        }

        .page__desc {
            color: #888;
            font-size: 18px
        }

        p {
            word-wrap: break-word;
            word-break: break-all;
            overflow: hidden;
        }

        .tone-text {
            color: #0088CC;
        }
    </style>
</head>

<body bgcolor="#f8f8f8">
<div class="page">
    <div class="page__hd">
        <div class="page__title">
            <h3 id="text_title" style="padding-top: 8px;">课堂互动</h3>
        </div>
    </div>
    <div class="page__bd">
        <div class="weui-cells">
            <div class="weui-cells__title">在分时系统中,时间片一定,(),响应时间越长</div>
            <div class="weui-cells weui-cells_radio">
                <label class="weui-cell weui-check__label" for="x11">
                    <div class="weui-cell__bd">
                        <p>内存越多</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" class="weui-check" name="radio1" id="x11"/>
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>
                <label class="weui-cell weui-check__label" for="x12">

                    <div class="weui-cell__bd">
                        <p>用户数越多</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" name="radio1" class="weui-check" id="x12" checked="checked"/>
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>
                <label class="weui-cell weui-check__label" for="x12">

                <div class="weui-cell__bd">
                    <p>队列越短</p>
                </div>
                <div class="weui-cell__ft">
                    <input type="radio" name="radio1" class="weui-check" id="x12" checked="checked"/>
                    <span class="weui-icon-checked"></span>
                </div>
            </label>
                <label class="weui-cell weui-check__label" for="x12">

                    <div class="weui-cell__bd">
                        <p>用户数越少</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="radio" name="radio1" class="weui-check" id="x12" checked="checked"/>
                        <span class="weui-icon-checked"></span>
                    </div>
                </label>
            </div>
        </div>
        <button value="提交" class="weui-btn weui-btn_primary" style="margin-top: 50px;" id='classsumbit'>提交</button>
    </div>
    <div class="page__ft" style="padding-top: 30px;">
        <div class="weui-footer">
            <p class="weui-footer__text">Copyright &copy; 2017-2018 太原师范学院校园助手</p>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="https://res.wx.qq.com/open/libs/weuijs/1.1.2/weui.min.js"></script>
<script type="text/javascript">
    $().ready(function () {
        $("#classsumbit").click(function () {
            var answerText = $("#answerText").val();
            if (answerText == '') {
                weui.alert("请输入你的答案")
                return;
            }
        })
    })
</script>
</html>