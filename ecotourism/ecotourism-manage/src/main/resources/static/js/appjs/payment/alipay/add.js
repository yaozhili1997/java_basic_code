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
		cache : true,
		type : "POST",
		url : "/payment/alipay/save",
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
            appid : {
				required : true
			},
            rsaPrivateKey : {
				required : true
			},
            alipayPublicKey : {
				required : true
			},
            charset : {
				required : true
			},
            format : {
				required : true
			},
            signtype : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			},
            appid : {
                required : icon + "请输入商户appid"
            },
            rsaPrivateKey : {
                required : icon + "请输入私钥(pkcs8)"
            },
            alipayPublicKey : {
                required : icon + "请输入支付宝公钥"
            },
            charset : {
                required : icon + "请输入编码"
            },
            format : {
                required : icon + "请输入返回格式"
            },
            signtype : {
                required : icon + "请输入签名类型"
            }
		}
	})
}