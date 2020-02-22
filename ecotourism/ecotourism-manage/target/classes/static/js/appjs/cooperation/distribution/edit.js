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
		type : "POST",
		url : "/cooperation/distribution/update",
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
            type : {
                required : true
            },
            saleChannelCode : {
                required : true
            },
            payType : {
                required : true
            },
            appId : {
                required : true
            },
            appSecret : {
                required : true
            },
            startDate : {
                required : true,
                date:true
            },
            endDate : {
                required : true,
                date:true
            },
            bankAccount : {
                digits:true
            },
            contactQq : {
                digits:true
            },
        },
        messages : {
            name: {
                required: icon + "请输入合作商名称"
            },
            type: {
                required: icon + "请选择合作商类型"
            },
            saleChannelCode: {
                required: icon + "请选择销售渠道"
            },
            payType: {
                required: icon + "请选择支付方式"
            },
            appId: {
                required: icon + "请选择生成appId"
            },
            appSecret: {
                required: icon + "请选择生成appSecret"
            },
            startDate: {
                required: icon + "请输入签约开始日期"
            },
            endDate: {
                required: icon + "请输入签约结束日期"
            }
        }
	})
}