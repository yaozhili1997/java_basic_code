$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/payment/wechat/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
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
            },
            appId : {
                required : true
            },
            appSecret : {
                required : true
            },
            mchNo : {
                required : true
            }
        },
        messages : {
            name : {
                required : icon + "请输入应用名称"
            },
            appId : {
                required : icon + "请输入appId"
            },
            appSecret : {
                required : icon + "请输入appSecret"
            },
            mchNo : {
                required : icon + "请选择商户"
            }
        }
	})
}