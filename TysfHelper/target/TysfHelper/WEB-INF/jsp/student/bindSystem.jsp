<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath }" var="path"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
<link href="https://cdn.bootcss.com/weui/1.1.2/style/weui.min.css"
	rel="stylesheet">
<title>绑定教务系统</title>
</head>
<body style="background-color: wheat;">
	<div class="page">
		<div class="page__hd" style="text-align: center; padding-top: 50px;">
			<img src="${path}/img/logo/logo.jpg" style="height: 150px;" />
		</div>
		<div class="page__bd">
			<form action="${path}/bindWxSystem.do" method="post" id="bindForm">
				<!--隐藏表单元素 Start-->
				<input type="hidden" name="__VIEWSTATE" value="${__VIEWSTATE}" /> <input
					id="pcInfo" type="hidden" name="pcInfo"> <input
					id="typeName" type="hidden" name="typeName" value="学生"> <input
					type="hidden" id="dsdsdsdsdxcxdfgfg" name="dsdsdsdsdxcxdfgfg">
				<input type="hidden" id="fgfggfdgtyuuyyuuckjg"
					name="fgfggfdgtyuuyyuuckjg"> <input type="hidden"
					name="Sel_Type" value="STU">
				<!--隐藏表单元素 END-->
				<div class="weui-cells weui-cells_form">
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">学号</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text" placeholder="教务系统账号"
								name="txt_asmcdefsddsd" id="txt_asmcdefsddsd" />
						</div>
					</div>
					<div class="weui-cell">
						<div class="weui-cell__hd">
							<label class="weui-label">密码</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="password" placeholder="教务系统密码"
								name="txt_pewerwedsdfsdff" id="txt_pewerwedsdfsdff"
								onblur="chkpwd(this)" onkeyup="chkpwd(this)" />
						</div>
					</div>
					<div class="weui-cell weui-cell_vcode">
						<div class="weui-cell__hd">
							<label class="weui-label">验证码</label>
						</div>
						<div class="weui-cell__bd">
							<input class="weui-input" type="text"
								id="txt_sdertfgsadscxcadsads" name="txt_sdertfgsadscxcadsads"
								onblur="chkyzm(this)" onkeyup="chkyzm(this)" />
						</div>
						<div class="weui-cell__ft">
							<img class="weui-vcode-img" id="imgCode"
								src="${path}/ValidateCode.do" />
						</div>
					</div>
				</div>
				<a class="weui-btn weui-btn_primary" style="margin-top: 50px;"
					id="btn">绑定教务系统</a>
			</form>
		</div>
		 <div class="weui-msg__extra-area">
            <div class="weui-footer">
                <p class="weui-footer__links">
                    <a href="javascript:void(0);" class="weui-footer__link">太原师范学院校园助手</a>
                </p>
                <p class="weui-footer__text">Copyright &copy; 2017-2018 wuzhe</p>
            </div>
        </div>
	</div>
</body>
<script type="text/javascript" src="${path}/js/global.js"></script>
<script type="text/javascript" src="${path}/js/md5.js"></script>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript"
	src="https://res.wx.qq.com/open/libs/weuijs/1.1.2/weui.min.js"></script>
<script type="text/javascript">
$()
.ready(
		function() {
			var sPC="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36undefined5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36 SN:NULL";
			$('#pcInfo').val(sPC);//浏览器标识
			 $("#imgCode").click(function(){
	               	var dt = new Date();
					this.src="${path}/ValidateCode.do?t="+dt.getMilliseconds();
	               });
			 $("#btn").click(function(){
				 var statusResult="";
				 var sid=$("#txt_asmcdefsddsd").val();
				 var password=$("#txt_pewerwedsdfsdff").val();
				 var vcode=$("#txt_sdertfgsadscxcadsads").val();
				 if(sid==""){
					 weui.alert("请输入学号");
				 }else if(password==""){
					 weui.alert("请输入密码")
				 }else if(vcode==""){
					 weui.alert("请输入验证码")
				 }else{
					 $("#txt_pewerwedsdfsdff").val("");
					 $("#txt_sdertfgsadscxcadsads").val("");
					 $.ajax({
							async:false,
							type:"POST",
							url:"/TysfHelper/bindWxSystem.do",
							data:$("#bindForm").serialize(),
							success:function  (data) {
								statusResult=data;
							},
							error:function(data){
								weui.alert("很抱歉,发生一个错误")
							}
						}) 
						console.log(statusResult)
						if(statusResult=="0"){
							$(window).attr('location','${path}/success.html');
						}else if(statusResult=="1"){
							var dt = new Date();
							 $("#imgCode").attr('src',"${path}/ValidateCode.do?t="+dt.getMilliseconds())
							weui.alert("用户名或密码错误");
						}else if(statusResult=="2"){
							var dt = new Date();
							 $("#imgCode").attr('src',"${path}/ValidateCode.do?t="+dt.getMilliseconds())
							weui.alert("验证码错误");
						}else if(statusResult="3"){
							var dt = new Date();
							 $("#imgCode").attr('src',"${path}/ValidateCode.do?t="+dt.getMilliseconds())
							weui.alert("很抱歉,发生一个错误")
						}
				 }
				
					
			 })
		      })
function chkpwd(obj) {
console.log("dianji ")
if (obj.value != '') {
var s = md5(
		document.all.txt_asmcdefsddsd.value
				+ md5(obj.value).substring(0, 30).toUpperCase()
				+ '10119').substring(0, 30).toUpperCase();
document.all.dsdsdsdsdxcxdfgfg.value = s;
} else {
document.all.dsdsdsdsdxcxdfgfg.value = obj.value;
}
}
function chkyzm(obj) {
if (obj.value != '') {
var s = md5(
		md5(obj.value.toUpperCase()).substring(0, 30).toUpperCase()
				+ '10119').substring(0, 30).toUpperCase();
document.all.fgfggfdgtyuuyyuuckjg.value = s;
} else {
document.all.fgfggfdgtyuuyyuuckjg.value = obj.value.toUpperCase();
}
}

</script>
</html>