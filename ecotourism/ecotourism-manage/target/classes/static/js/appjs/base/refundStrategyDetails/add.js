$().ready(function() {
    loadStrategy();
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
		url : "/base/refundStrategyDetails/save",
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
            strategyDetailName : {
                required : true
            },
            strategyDetailTime : {
                required : true
            },
            strategyNo : {
                required : true
            },
            refundProportion : {
                required : true
            }
		},
		messages : {
            strategyDetailName : {
				required : icon + "请输入明细名称"
			},
            strategyDetailTime : {
                required : icon + "请输入购票后时长"
            },
            strategyNo : {
                required : icon + "请选择退票策略"
            },
            refundProportion : {
                required : icon + "请输入退票比例"
            }
		}
	})
}

function loadStrategy(){
    var html = "";
    $.ajax({
        url : '/base/refundStrategy/listAll',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].strategyNo + '">' + data[i].strategyName + '</option>'
            }
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight : 200
            });
            //点击事件
            $('.chosen-select').on('change', function(e, params) {
                console.log(params.selected);
                var opt = {
                    query : {
                        type : params.selected,
                    }
                };
                $('#exampleTable').bootstrapTable('refresh', opt);
            });
        }
    });
}