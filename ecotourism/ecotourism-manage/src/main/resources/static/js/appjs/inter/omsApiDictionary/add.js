$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
    $("#apinos").val(getCheckedApinos());
	$.ajax({
		cache : true,
		type : "POST",
		url : "/inter/omsApiDictionary/save",
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
function getCheckedApinos() {
    var apinos = "";
    $("input:checkbox[name=apino]:checked").each(function(i) {
        if (0 == i) {
            apinos = $(this).val();
        } else {
            apinos += ("," + $(this).val());
        }
    });
    return apinos;
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
            distributionNo : {
				required : true
			}
		},
		messages : {
            distributionNo : {
				required : icon + "请选择分销商"
			}
		}
	})
}