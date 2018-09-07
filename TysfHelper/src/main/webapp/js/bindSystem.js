   $()
			.ready(
					function() {
						var sPC = MSIE ? window.navigator.userAgent
								+ window.navigator.cpuClass
								+ window.navigator.appMinorVersion + ' SN:NULL'
								: window.navigator.userAgent
										+ window.navigator.oscpu
										+ window.navigator.appVersion
										+ ' SN:NULL';
						$('#pcInfo').val(sPC);
					/*	$("#bindForm").submit(function() {
							$("#txt_pewerwedsdfsdff").val("");
							$("#txt_sdertfgsadscxcadsads").val("");
							
							return false;
						});*/
						 $("#imgCode").click(function(){
				               	var dt = new Date();
								this.src = "http://localhost:8080/TysfHelper/ValidateCode.do?t=" + dt.getMilliseconds();
				               });
						 $("#btn").click(function(){
							 $.ajax({
									async:false,
									type:"POST",
									url:"http://localhost:8080/TysfHelper/bindWxSystem.do",
									data:$("#bindForm").serialize(),
									success:function  (data) {
										console.log(data);
									}
								})
								weui.alert("验证码错误");
							/*	$(window).attr('location','http://www.baidu.com');*/
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