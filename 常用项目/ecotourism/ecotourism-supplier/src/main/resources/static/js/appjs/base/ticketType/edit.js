$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
    if(!$("#isSelf").is(':checked') && ''==$("#ticketSupplier").val()){
        parent.layer.msg("请选择供应商!");
        return
    }
	$.ajax({
		cache : true,
		type : "POST",
		url : "/base/ticketType/update",
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
            spotNo : {
                required : true
            },
            ticketNo : {
                required : true
            },
            ticketName : {
                required : true
            },
            ticketType : {
                required : true
            },
            ticketPrice : {
                required : true,
                number: true,
                min: 0.01
            },
            productType : {
                required : true
            },
            abbreviation : {
                required : true
            }
        },
        messages : {
            spotNo : {
            required : icon + "请选择景点"
        },
        ticketNo : {
            required : icon + "请输入票种编号"
        },
        ticketName : {
            required : icon + "请输入票种名称"
        },
        ticketType : {
            required : icon + "请输入票种类型"
        },
        ticketPrice : {
            required: "请填写金额",
                number: "请正确输入金额",
                min: "输入最小金额为0.01"
        },
        productType : {
            required : icon + "请输入所属产品类型"
        },
        abbreviation : {
            required : icon + "请输入票种简称"
        }
    }
	})
}