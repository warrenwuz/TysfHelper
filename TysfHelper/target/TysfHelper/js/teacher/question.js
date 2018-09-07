$().ready(function() {
	var ciid=$("#questionJs").attr("data");
	console.log(ciid)
	$('#table').bootstrapTable({
		 url:'/TysfHelper/teacher/question/'+ciid+'.do',
		 method:'post',
		 pagination : true,
		 cache: false,     //是否使用缓冲
		 queryParamsType:'',
		 sidePagination:'server',
		 pageNumber:1,      //初始化加载第一页，默认第一页
         pageSize: 10,      //每页的记录行数（*）
         pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
         uniqueId:'ciid',
		columns : [
			{
				field : 'id',
				title : '编号',
				width:'5%',
				formatter:function(value,row,index){
			       return index+1;
				}
			},{
			field : 'questionContent',
			title : '题目',
		},{
			field:'id',
			title:'操作',
			width:'20%',
			formatter:function(value,row,index){
				return "<div class='btn-group'>" +
					"<button class='btn btn-default btn-xs btn-primary' >" + "查看</button>" +
					"<button class='btn btn-default btn-xs btn-success'>修改</button>" +
					"<button class='btn btn-default btn-xs btn-danger'>删除</button>" +
					"</div>"
			},
			events:window.operateEvents = {
				 'click .create': function (e, value, row, index) {
					 console.log(row)
					 $("#ciid").val(row.ciid);
					 $("#addSchoolCLass").modal("show");
					 $.ajax({
							type : "post",
							url : "/TysfHelper/teacher/querySchoolClass.do",
							success : function(json) {
								$.each($.parseJSON(json), function(i, val) {
									$("#schoolclass").append(
											"<option value='"+val.cid+"'>"
													+ val.cname + "</option>");
								})
								$('#schoolclass').multiselect({
									nonSelectedText : "请选择课堂互动的班级",
									nSelectedText : "个班级",
									allSelectedText : "全部班级",
								});
							}
						})
				 }
			}
		} ],
		onLoadSuccess:function(){
			/**
			 * 加载数据完成后,对描述的td进行加title属性
			 */
			$("#table").find("td[class='projectdetail']").each(function(i,val){
			          $(this).attr("title",$(this).html())
			})
		},
		 onEditableSave: function (field, row, oldValue, $el) {
		    	console.log(row)
		        $.ajax({
		        	type:'POST',
		        	url:'/TysfHelper/teacher/modifyClassroomInteraction.do',
		        	contentType:'application/x-www-form-urlencoded',
		        	data:{
		        		ciid:row.ciid,
		        		ciname:row.ciname,
		        	}
		        })
		    }
	});
	$("#questionSubmit").click(function(){
		var questionContent=$("#questionContent").val();//问题内容
        var questionOptions=new Array();//选项集合
        var questionOptionIndex=parseInt($(".questionOptionIndex:checked").val());
        var correctOption="";
        $(".questionOption").each(function (index,item) {
            questionOptions.push($(this).val())
            if (index==questionOptionIndex){
                correctOption=$(this).val()
            }
        });
		var count=$("#table").bootstrapTable("getData").length;
		$.ajax({
			url:'/TysfHelper/teacher/addQuestion.do',
			method:'POST',
            traditional:true,
			data:{
                questionContent:questionContent,
                questionOptions:questionOptions,
                questionOptionIndex:questionOptionIndex,
                ciid:ciid
			},
			success:function(data){
				 $("#myModal").modal('hide');
				 $("#table").bootstrapTable("insertRow",{
					 index:count+1,
					 row:{
                         questionContent:questionContent,
                         correctOption:correctOption
					 }
				 })
			}
		})
	})
	$("#createClassroomInteraction").click(function(){
		if($("#schoolclass").val().length==0){
			alert("请选择互动班级")
			return
		}
		$("#createClassroomInteractionForm").submit();
	})
})
/**************************************时间格式化处理************************************/
function dateFtt(fmt,date)   
{ //author: meizz   
  var o = {   
    "M+" : date.getMonth()+1,                 //月份   
    "d+" : date.getDate(),                    //日   
    "h+" : date.getHours(),                   //小时   
    "m+" : date.getMinutes(),                 //分   
    "s+" : date.getSeconds(),                 //秒   
    "q+" : Math.floor((date.getMonth()+3)/3), //季度   
    "S"  : date.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}
