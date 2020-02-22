$().ready(function() {
    loadArea();
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
        save();
    }
});
function save() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/base/spotManagement/save",
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

function loadArea(){
    var html = "";
    $.ajax({
        url : '/base/areaManagement/listAll',
        success : function(data) {
            //加载数据
            for (var i = 0; i < data.length; i++) {
                html += '<option value="' + data[i].areaNo + '">' + data[i].areaName + '</option>'
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