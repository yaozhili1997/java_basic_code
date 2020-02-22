$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	var subordinateLine = $("#subordinateLine option:selected").text();
	if(subordinateLine !='-- 所属线路 --'){
        $("#transitNo").val(subordinateLine);
	}
	$.ajax({
		cache : true,
		type : "POST",
		url : "/device/carEquipment/save",
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
            deviceNo : {
				required : true
			},
            deviceName : {
                required : true
            },
            equipmentNumber : {
                required : true
            },
            welcomeText : {
                required : true
            },
            basePrice : {
                required : true
            },
            carNo : {
                required : true
            },
            prompt : {
                required : true
            },
            baseText : {
                required : true
            },
            vehicleNumber : {
                required : true
            }
		},
		messages : {
            deviceNo : {
				required : icon + "请输入设备编码"
			},
            deviceName : {
                required : icon + "请输入设备名称"
            },
            equipmentNumber : {
                required : icon + "请输入设备编号"
            },
            welcomeText : {
                required : icon + "请输入欢迎乘坐"
            },
            basePrice : {
                required : icon + "请输入基础票价"
            },
            carNo : {
                required : icon + "请输入车牌号"
            },
            prompt : {
                required : icon + "请输入请刷卡"
            },
            baseText : {
                required : icon + "请输入基础信息"
            },
            vehicleNumber : {
                required : icon + "请输入车辆编号"
            }
		}
	})
}