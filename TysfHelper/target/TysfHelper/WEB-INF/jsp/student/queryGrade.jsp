<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"></c:set>
<!DOCTYPE html>
<html>

	<head>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<meta charset="UTF-8">
		<title></title>
		<link href="https://res.wx.qq.com/open/libs/weui/1.1.2/weui.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${path}/css/queryGrade.css" />
		<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
		<script type="text/javascript" src="https://res.wx.qq.com/open/libs/weuijs/1.1.2/weui.min.js"></script>
	</head>

	<body style="background-color: wheat;">
		<div class="page">
			<div class="page__hd">
				<div class="page__title">
					<h2 style="text-align: center;">成绩查询</h2></div>
			</div>
			<div class="page__bd page__bd_spacing">
				<div class="weui-cells">
					<form action="" method="post" id="queryFrom">
					<div class="weui-cell weui-cell_select">
						<div class="weui-cell__bd">
							<select class="weui-select" name="sel_xn">
								<option  value="2016">2016-2017学年</option>
								<option value="2015">2015-2016学年</option>
								<option value="2014">2014-2015学年</option>
							</select>
						</div>
					</div>
					<div class="weui-cell weui-cell_select">
						<div class="weui-cell__bd">
							<select class="weui-select" name="sel_xq">
								<option  value="0">第一学期</option>
								<option value="1">第二学期</option>
							</select>
						</div>
					</div>
					<div class="weui-cell weui-cell_select">
						<div class="weui-cell__bd">
							<select class="weui-select" name="SJ">
								<option value="1">有效成绩</option>
					          <option value="0">原始成绩</option>
							</select>
						</div>
					</div>
					<input type="hidden"  name="btn_search" value="检索"/>
					<input type="hidden" name="SelXNXQ" value="2"/>
					<input type="hidden" name="zfx_flag"  value="0"/>
					<input type="hidden" name="zxf" value="0"/>
					
					</form>
				</div>
				<div class="weui-cells" style="overflow-x:scroll; border:10px solid springgreen;" hidden="hidden" id="showImg">
					<img src="" id="resultShow" />
				</div>
				<div class="weui-btn-area">
					<button class="weui-btn weui-btn_primary"  id="select-btn">查询成绩</button>
				</div>
			</div>
	            <div class="weui-footer">
	                <p class="weui-footer__links">
	                    <a href="javascript:void(0);" class="weui-footer__link">太原师范学院校园助手</a>
	                </p>
	                <p class="weui-footer__text">Copyright &copy; 2017-2018 wuzhe</p>
	            </div>
		</div>
	</body>
	<script type="text/javascript">
		$().ready(function() {
			$("#select-btn").click(function() {
				var loading = weui.loading('查询中', {
					className: 'custom-classname'
				}); 
				 $.ajax({
						async:false,
						type:"POST",
						url:"/TysfHelper/queryGrade.do",
						data:$("#queryFrom").serialize(),
						success:function  (data) {
							console.log(data);
							if(data==1){
								loading.hide();
								var dt = new Date();
								$("#resultShow").attr("src","${path}/showGrade.do?t="+dt.getMilliseconds());
								$("#showImg").show();       
							}
						},
						error:function(data){
							weui.alert("很抱歉,发生一个错误")
						}
					});
					
			})

		})
	</script>

</html>