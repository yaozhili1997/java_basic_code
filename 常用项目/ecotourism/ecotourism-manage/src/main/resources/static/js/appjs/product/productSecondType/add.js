$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : false,
		type : "POST",
		url : "/product/productSecondType/save",
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
            productTypeName : {
                required : true
            },
            parentTypeNo : {
                required : true
            },
            alias : {
                required : true
            }
        },
        messages : {
            productTypeName : {
                required : icon + "请输入类型名称"
            },
            parentTypeNo : {
                required : icon + "请输入父类"
            },
            alias : {
                required : icon + "请输入类型别名"
            }
        }
	})
}