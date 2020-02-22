$().ready(function() {
    $('.summernote').summernote({
        height : '150px',
        lang : 'zh-CN',
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(files);
            }
        }
    });
    var content = $("#content").val();
    $('#content_en').summernote('code', content);
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
    var content = $("#content_en").summernote('code');
    $("#content").val(content);
	$.ajax({
		cache : true,
		type : "POST",
		url : "/information/indexContent/update",
        data : new FormData($("#signupForm")[0]),// 你的formid
        async : false,
        processData: false,  // 告诉jQuery不要去处理发送的数据
        contentType: false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}