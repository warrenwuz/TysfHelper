$().ready(function() {
	$('#table').bootstrapTable({
		 url:'/TysfHelper/teacher/classroomInteractionForJson.do',
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
				field : 'ciid',
				title : '序号',
				width:'5%',
				formatter:function(value,row,index){
			       return index+1;
				}
			},{
			field : 'citimestamp',
			title : '时间',
			width:'20%',
			formatter:function(value,row,index){
				 var date = new Date(value);
		            return dateFtt('yyyy-MM-dd hh:mm:ss',date);
			}
		}, {
			field : 'ciname',
			title : '主题',
			width:'55%',
			editable:{
			 type: 'text',
             title: '主题',
            validate: function (v) {
              if (!v) return '主题不能为空';
             }
		  }
		},{
                field : 'ciid',
                title : '互动试题',
                width:'10%',
                formatter:function(value,row,index){
                    return "<a href='/TysfHelper/teacher/question/" +value+ ".do'><i class='glyphicon glyphicon-pencil'style='color: #000080;'></i></a>"
                }
            },{
			field:'wpid',
			title:'生成互动',
			width:'10%',
			formatter:function(value,row,index){
				return "<a href='javascript:void(0)' class='create'><i class='glyphicon glyphicon-pencil'style='color: #000080;'></i></a>"
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
	$("#hudongsumbit").click(function(){
		var ciname=$("#ciname").val();
		if(ciname==''){
			alert('主题不能为空')
			return;
		}
		var count=$("#table").bootstrapTable("getData").length;
		$.ajax({
			url:'/TysfHelper/teacher/addClassroomInteraction.do',
			method:'get',
			data:{
              ciname:$("#ciname").val()
			},
			success:function(data){
				 $("#myModal").modal('hide');
				 $("#table").bootstrapTable("insertRow",{
					 index:count+1,
					 row:{
						 ciid:data,
						 ciname:ciname,
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
