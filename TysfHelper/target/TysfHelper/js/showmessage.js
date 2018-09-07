            	$().ready(function(){
            		$(".reply-btn").click(function(){
            			var mid=$(this).val();
            			$("#form"+mid).show();
            		})
            		$(".reply-cancel").click(function(){
            			var mid =$(this).val();
            			$("#form"+mid).hide();
            		})
            		$(".reply-submit").click(function(){
            			var mid=$(this).val();
            			var content=$("#reply-content_"+mid).val();
            			var date=new Date().Format("yyyy-MM-dd hh:mm:ss");
            			var param={
            			  mid:mid,
            			  content:content,
            			  date:date
            			}
            			$.ajax({
            				type:"post",
            				data:param,
            				url:"/TysfHelper/teacher/writerReplayMessageService.do",
            			    success:function(data){
            			    	if(data==1){
            			       $("#reply-content_"+mid).val("");
            			    	$("#form"+mid).hide();
            			        $("#replayMessage_"+mid).append("<li class='list-group-item'><span class='text-primary'>我</span>:"+content+"<div class='time clearfix'><span class='pull-right'>"+date+"</span></div></li>")  
            			    	}
            			    }
            			})
            		})
            	})
            	/**
            	 * 日期格式的转化方法
            	 */
  Date.prototype.Format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
            	
      