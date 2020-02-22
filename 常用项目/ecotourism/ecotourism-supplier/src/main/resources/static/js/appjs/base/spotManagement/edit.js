$().ready(function() {
    //时间选择器
    laydate.render({
        elem: '#openingHours'
        ,type: 'time'
    });
    laydate.render({
        elem: '#closingHours'
        ,type: 'time'
    });
    laydate.render({
        elem: '#stopSellingTicketsTime'
        ,type: 'time'
    });
    laydate.render({
        elem: '#stopCheckingTime'
        ,type: 'time'
    });
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
		url : "/base/spotManagement/update",
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
            spotName : {
                required : true
            },
            areaNo : {
                required : true
            },
            openingHours : {
                required : true
            },
            closingHours : {
                required : true
            },
            stopSellingTicketsTime : {
                required : true
            },
            stopCheckingTime : {
                required : true
            }
        },
        messages : {
            spotName : {
                required : icon + "请输入景点名称"
            },
            areaNo : {
                required : icon + "请选择景区"
            },
            openingHours : {
                required : icon + "请输入开园时间"
            },
            closingHours : {
                required : icon + "请输入闭园时间"
            },
            stopSellingTicketsTime : {
                required : icon + "请输入停止售票时间"
            },
            stopCheckingTime : {
                required : icon + "请输入停止检票时间"
            }
        }
    })
}