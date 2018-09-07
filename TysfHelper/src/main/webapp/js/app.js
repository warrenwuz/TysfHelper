  $(document).ready(function () {
        $(".dropdownMenu").dropdown();
        $(".nav-left-dropdown>a").click(function () {
            if ($(this).attr("d") != 1 && $(this).attr("d") != undefined) {
                $(this).removeClass("nav-left-dropdown-a");
                $this = $(this);
                $(this).next("ul").slideUp(300, function () {
                    $this.removeClass("nav-left-bottrom-border");
                    $this.removeClass("nav-left-dropdown-ul")
                });

                $(this).attr("d", "1");

            } else {
                $(this).addClass("nav-left-dropdown-a");
                $(this).addClass("nav-left-bottrom-border");
                $(this).next("ul").addClass("nav-left-dropdown-ul").slideDown(300);
                $(this).attr("d", "2");
            }
        });
        //上传文件
      $.ajax({
          type : "post",
          url : "/TysfHelper/teacher/querySchoolClass.do",
          success : function(json) {
              $.each($.parseJSON(json), function(i, val) {
                  $("#usertype").append(
                      "<option value='"+val.cid+"'>"
                      + val.cname + "</option>");
              })
              $('#usertype').multiselect({
                  nonSelectedText : "请选择需要通知的班级",
                  nSelectedText : "个班级",
                  allSelectedText : "全部班级",
              });
          }
      })
      $('#datetimepicker').datetimepicker({
          format: 'yyyy-mm-dd',
          language: 'zh-CN',
          minView: "month",
          autoclose:true,
          todayBtn:true
      });
      var uploader = WebUploader.create({
          auto : true,
          // swf文件路径
          swf : '${path}/js/Uploader.swf',
          // 文件接收服务端。
          server : '${path}/Uploadfile.do',
          // 选择文件的按钮。可选。
          // 内部根据当前运行是创建，可能是input元素，也可能是flash.
          pick : '#picker',
          // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
          resize : false,
          multiple : false
      });
      uploader.on(
              'uploadProgress',
              function(file, percentage) {
                  $("#ctlBtn").attr("disabled",
                      "disabled");
                  var $li = $('#' + file.id), $percent = $li
                      .find('.progress .progress-bar');
                  // 避免重复创建
                  if (!$percent.length) {
                      $percent = $(
                          '<div class="progress progress-striped active">'
                          + '<div class="progress-bar" role="progressbar" style="width: 0%">'
                          + '</div>'
                          + '</div>')
                          .appendTo($li)
                          .find('.progress-bar');
                  }

                  $li.find('p.state').text('上传中');

                  $percent.css('width', percentage
                      * 100 + '%');
              });
      // 当有文件被添加进队列的时候
      uploader.on('fileQueued', function(file) {
          $("#thelist").append(
              '<li id="' + file.id + '" class="item list-group-item">'
              + '<h4 class="info">' + file.name
              + '</h4>'
              + '<p class="state">等待上传...</p>'
              + '</li>');
      });
      uploader.on('uploadSuccess',
          function(file, data) {
              $("#ctlBtn").attr("disabled", null);
              if (data._raw == 0) {
                  $('#' + file.id).find('p.state').text('服务器上传出错');
              } else {
                  $("#" + file.id).append("<input type='checkbox' name='file' value='"+data._raw+"' checked='checked' hidden='hidden'>")
                  $('#' + file.id).find('p.state').text('已上传');
              }
          });

      uploader.on('uploadError', function(file) {
          $("#ctlBtn").attr("disabled", null);
          $('#' + file.id).find('p.state').text('上传出错');
      });

      uploader.on('uploadComplete', function(file) {
          $('#' + file.id).find('.progress').fadeOut();
      });

      $("#ctlBtn").on('click', function() {
          $("#sumbitdate").val();
          uploader.upload();
          $.ajax({
              type : "post",
              url : "${path}/teacher/releasehomework.do",
              data : $("#Hfrom").serialize(),
              success:function(){
                  alert('发布成功')
              }
          })

      });
    })
