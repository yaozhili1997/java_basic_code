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
		cache : false,
		type : "POST",
		url : "/payment/wechatMch/update",
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
            mchName : {
                required : true
            },
            mchId : {
                required : true
            },
            privateKey : {
                required : true
            },
            file : {
                required : true
            },
            certPassword : {
                required : true
            }
        },
        messages : {
            mchName : {
                required : icon + "请输入商户名"
            },
            mchId : {
                required : icon + "请输入商户号ID"
            },
            privateKey : {
                required : icon + "请输入商户私钥"
            },
            file : {
                required : icon + "请选择商户证书"
            },
            certPassword : {
                required : icon + "请选择证书密码"
            }
        }
	})
}