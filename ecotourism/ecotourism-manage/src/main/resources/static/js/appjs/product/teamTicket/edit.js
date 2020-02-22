$().ready(function() {
    $('.summernote').summernote({
        height : '150px',
        lang : 'zh-CN',
        callbacks: {
            onImageUpload: function(files, editor, $editable) {
                sendFile(this,files[0]);
            }
        }
    });
    var useExplain = $("#useExplain").val();
    $('#useExplain_en').summernote('code', useExplain);
    var refundExplain = $("#refundExplain").val();
    $('#refundExplain_en').summernote('code', refundExplain);
    var parkAddress = $("#parkAddress").val();
    $('#parkAddress_en').summernote('code', parkAddress);
    var costIncludes = $("#costIncludes").val();
    $('#costIncludes_en').summernote('code', costIncludes);
    var costNotIncludes = $("#costNotIncludes").val();
    $('#costNotIncludes_en').summernote('code', costNotIncludes);
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
    var useExplain = $("#useExplain_en").summernote('code');
    $("#useExplain").val(useExplain);
    var refundExplain = $("#refundExplain_en").summernote('code');
    $("#refundExplain").val(refundExplain);
    var parkAddress = $("#parkAddress_en").summernote('code');
    $("#parkAddress").val(parkAddress);
    var costIncludes = $("#costIncludes_en").summernote('code');
    $("#costIncludes").val(costIncludes);
    var costNotIncludes = $("#costNotIncludes_en").summernote('code');
    $("#costNotIncludes").val(costNotIncludes);
	$.ajax({
		cache : false,
		type : "POST",
		url : "/product/teamTicket/update",
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
            productName : {
                required : true
            },
            ticketNo : {
                required : true
            },
            productTypeName : {
                required : true
            },
            distributionChannel : {
                required : true
            },
            ticketGrouping : {
                required : true
            },
            payPrice : {
                required : true
            },
            settlementPrice : {
                required : true
            },
            termNo : {
                required : true
            }
        },
        messages : {
            productName : {
                required : icon + "请输入产品名称"
            },
            ticketNo : {
                required : icon + "请输入票种名称"
            },
            productTypeName : {
                required : icon + "请输入产品类型"
            },
            distributionChannel : {
                required : icon + "请输入销售渠道"
            },
            ticketGrouping : {
                required : icon + "请输入票种分组"
            },
            payPrice : {
                required : icon + "请输入售价"
            },
            settlementPrice : {
                required : icon + "请输入结算单价"
            },
            termNo : {
                required : icon + "请输入使用期限"
            }
        }
    })
}

var openStrategy = function(){
    layer.open({
        type:2,
        title:"选择退票策略",
        area : [ '300px', '450px' ],
        content:"/base/refundStrategyDetails/treeView"
    })
};

function loadUser(ids,txt,parentId){
    $("#strategyNo").val(parentId);
    $("#strategyDetailName").val(txt);
    $("#refundStrategyDetailNo").val(ids);
}
var openProductType = function(){
    var productType = '043006';
    layer.open({
        type:2,
        title:"选择票种类型",
        area : [ '300px', '450px' ],
        content:"/product/productType/treeView?productType="+productType
    })
};

function loadProductType(ids,txt,parentId){
    $("#productType").val(parentId);
    $("#productTypeName").val(txt);
    $("#productSecondType").val(ids);
}