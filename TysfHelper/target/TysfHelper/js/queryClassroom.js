	$().ready(function() {
		console.log(Math.random())
		var startDay = new Date("2017/8/28");
		var endDay = new Date("2018/1/14");
		var date = new Date();
		var year = date.getFullYear();
		var mouth = date.getMonth();
		var day = date.getDate();
		var week = date.getDay();
		$(".date-picker").html(date.toLocaleDateString());
		var Sel_ZC = parseInt((date - startDay) / (24 * 60 * 60 * 1000 * 7)) + 1
		$("#Sel_ZC").val(Sel_ZC);
		$("#selxqs").val(week + 1); //设置星期
		/**
		 * 选择日期  start
		 */
		$(".date-picker").click(function() {
			weui.datePicker({
				start: 2014, // 从今天开始
				end: 2030,
				defaultValue: [year, mouth + 1, day],
				onConfirm: function(result) {
					var str = result[0].label + result[1].label + result[2].label
					var strDate = str.replace("年", "/").replace("月", "/").replace("日", "")
					var confirmDate = new Date(strDate);
					if(confirmDate >= startDay && confirmDate <= endDay) {
						$(".date-picker").html(strDate)
						var Sel_ZC = parseInt((confirmDate - startDay) / (24 * 60 * 60 * 1000 * 7)) + 1
						$("#Sel_ZC").val(Sel_ZC);
					} else {
						weui.alert("2017/8/28~2018/1/14", {
							title: "请选择本学期学习周时间,",
							buttons: [{
								label: '知道了',
								type: 'primary',
							}]
						});
					}
				},
				id: 'datePicker'
			});
		});
		//选择日期   end
		/**
		 * 选择时间段 start
		 */
		$(".time-picker").click(function() {
			weui.picker([{
					label: '8:00~10:00',
					value: 01,
				},
				{
					label: '10:00~12:00',
					value: 03
				},
				{
					label: '14:00~16:00',
					value: 05
				},
				{
					label: '16:00~18:00',
					value: 07,
				},
				{
					label: '18:30~20:30',
					value: 09,
				}
			], {
				className: 'custom-classname',
				container: 'body',
				defaultValue: [3],
				onConfirm: function(result) {
					var data = result[0];
					$(".time-picker").html(data.label);
					$("#Sel_JC").val(data.value);
				},
				id: 'timePicker'
			})
		});
		//选择时间段 end
		/**
		 * 选择教学楼
		 */
		$(".JXL-picker").click(function() {
			weui.picker([{
					label: '三行楼',
					value: 401,
				},
				{
					label: '求真楼',
					value: 402
				},
				{
					label: '慎思楼',
					value: 403
				},
				{
					label: '乐馨楼',
					value: 404,
				},
				{
					label: '舞韵楼',
					value: 405,
				},
				{
					label: '美瀛楼',
					value: 406,
				},
				{
					label: '格物楼',
					value: 407,
				},
				{
					label: '明理书院c座',
					value: 408,
				},
				{
					label: '明辩楼',
					value: 409,
				},
				{
					label: '汇文书院',
					value: 410,
				}
			], {
				className: 'jxl-classname',
				container: 'body',
				defaultValue: [1],
				onConfirm: function(result) {
					var data = result[0];
					$(".JXL-picker").html(data.label);
					$("#JXL_Name").val(data.label);
					$("#Sel_JXL").val(data.value);
				},
				id: 'JXlPicker'
			})
		});
		//选择教学楼end
		/**
		 * 教室类型start
		 */
		$(".jslx——picker").click(function() {
			weui.picker([{
					label: '一般教室',
					value: 01,
				},
				{
					label: '实验室',
					value: 03
				},
				{
					label: '语音室',
					value: 04,
				},
				{
					label: '多媒体教室',
					value: 05,
				},
				{
					label: '计算机机房',
					value: 08,
				},
				{
					label: '练功房',
					value: 10,
				},
				{
					label: '画室',
					value: 13,
				},
				{
					label: '教室休息室',
					value: 14,
				},
				{
					label: '报告厅',
					value: 15,
				}
			], {
				className: 'jxl-classname',
				container: 'body',
				defaultValue: [3],
				onConfirm: function(result) {
					var data = result[0];
					$(".jslx——picker").html(data.label);
					$("#sel_jslx").val(data.value);
				},
				id: 'jslxPicker'
			})
		});
		//选择教室类型end
		$("#formRoom").submit(function() {
			var Sel_JXL = $("#Sel_JXL").val();
			var Sel_JC = $("#Sel_JC").val();
			if(Sel_JXL == "") {
				weui.alert("请选择教学楼")
				return false;
			} else if(Sel_JC == "") {
				weui.alert("请选择时间段")
				return false;
			}
			weui.loading('搜索中', {
				className: 'custom-classname'
			});
		})
	})