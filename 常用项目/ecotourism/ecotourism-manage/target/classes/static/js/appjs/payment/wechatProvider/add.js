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
		url : "/payment/wechatProvider/save",
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
            providerName : {
                required : true
            },
            appId : {
                required : true
            },
            privateKey : {
                required : true
            },
            mchId : {
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
            providerName : {
                required : icon + "请输入服务商名称"
            },
            appId : {
                required : icon + "请输入appid"
            },
            privateKey : {
                required : icon + "请输入商户私钥"
            },
            mchId : {
                required : icon + "请输入商户ID"
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