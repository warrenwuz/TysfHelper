<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css"
	rel="stylesheet" />
<script type="text/javascript"
	src="https://res.wx.qq.com/open/libs/weuijs/1.1.2/weui.min.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<title></title>
</head>

<body style="background-color: wheat;">
	<div class="page">
		<div class="weui-tab" id="tab">
			<div class="weui-navbar">
				<div class="weui-navbar__item weui-bar__item_on">老师留言</div>
				<div class="weui-navbar__item">留言记录</div>
			</div>
			<div class="weui-tab__panel">
				<div class="weui-tab__content">
					<div class="weui-cells">
						<div class="weui-cell">
							<div class="weui-cell__hd">
								<label class="weui-label">老师工号</label>
							</div>
							<div class="weui-cell__bd">
								<input class="weui-input" type="number" pattern="[0-9]*"
									placeholder="请输入老师工号" id="tid" />
							</div>
						</div>
						<div class="weui-cell">
							<div class="weui-cell__bd">
								<textarea class="weui-textarea" placeholder="写下想对老师说的话" rows="7"
									id="text"></textarea>
								<div class="weui-textarea-counter">
									<span id="wordNumber">0</span>/200
								</div>
							</div>
						</div>
					</div>
					<button class="weui-btn weui-btn_primary" style="margin-top: 20px;"
						id="sumbit">提交</button>
				</div>
				<div class="weui-tab__content">
					<div class="weui-panel weui-panel_access">
						<div class="weui-panel__hd">留言记录</div>
						<div class="weui-panel__bd" id="showMessage"></div>
					</div>

				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$().ready(
				function() {
					$(".weui-navbar__item").click(
							function() {
								//查找每个 weui-bar__item_on元素的所有类名为 ".weui-bar__item_on" 的所有同胞元素
								$(this).addClass('weui-bar__item_on').siblings(
										'.weui-bar__item_on').removeClass(
										'weui-bar__item_on');
								/* $(".weui-message_item").toggle(); */
							})
					weui.tab('#tab', {
						defaultIndex : 0,
						onChange : function(index) {
							if(index==1){
								$("#showMessage").html("");
							$.ajax({
								type : "get",
								url : "${path}/showMessage.do",
								success : function(data) {
									$.each($.parseJSON(data),function(i,val){
										$("#showMessage").append("<div class='weui-media-box weui-media-box_text'><h4 class='weui-media-box__title'>"+val.tname+"老师</h4><p class='weui-media-box__desc'>"+val.content+"</p></div>");
									})
								}
							});
							}
						}
					})

					$(" #sumbit").click(function() {
						var id = $("#tid").val();
						var text = $("#text").val();
						if (id == "") {
							weui.alert("请输入老师工号")
						} else if (text == "") {
							weui.alert("请输入你想对老师说的话")
						} else {
							var param = {
								id : id,
								text : text
							}
							$.ajax({
								async : false,
								type : "post",
								url : "${path}/writerMessage.do",
								data : param,
								success : function(data) {
									if (data == 1) {
										weui.alert("没有查看该工号的老师")
									} else if (data == 0) {
										weui.toast('留言成功', 3000);
										$("#tid").val("");
										$("#text").val("");
									}
								}
							});

						}
					});
					$("#text").bind('input propertychange',function(){
				     var text=$("#text").val();
				     if(text.length>200){
				    	 $("#wordNumber").css("color","red").html("超出了规定字数"+(text.length-200));
				    	 $("#sumbit").attr("disabled",true).addClass("weui-btn_disabled");
				     }else{
						$("#wordNumber").html(text.length).css("color","");
						$("#sumbit").attr("disabled",false).removeClass("weui-btn_disabled");
				     }
						});
				})
	</script>
</body>

</html>