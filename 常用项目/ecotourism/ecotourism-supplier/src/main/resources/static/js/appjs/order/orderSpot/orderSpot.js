
var prefix = "/order/orderSpot";
$(function() {
    load();
});

function load() {
    $('#exampleTable')
        .bootstrapTable(
            {
                method : 'get', // 服务器数据的请求方式 get or post
                url : prefix + "/list", // 服务器数据的加载地址
                //	showRefresh : true,
                //	showToggle : true,
                //	showColumns : true,
                iconSize : 'outline',
                toolbar : '#exampleToolbar',
                striped : true, // 设置为true会有隔行变色效果
                dataType : "json", // 服务器返回的数据类型
                pagination : true, // 设置为true会在底部显示分页条
                // queryParamsType : "limit",
                // //设置为limit则会发送符合RESTFull格式的参数
                singleSelect : false, // 设置为true将禁止多选
                // contentType : "application/x-www-form-urlencoded",
                // //发送到服务器的数据编码类型
                pageSize : 10, // 如果设置了分页，每页数据条数
                pageNumber : 1, // 如果设置了分布，首页页码
                //search : true, // 是否显示搜索框
                showColumns : true, // 是否显示内容下拉框（选择显示的列）
                sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
                queryParams : function(params) {
                    var productNo = $('#productNo').val()+"";
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset:params.offset,
                        searchName:$('#searchName').val(),
                        payStatus:$('#payStatus').val(),
                        orderStatus:$('#orderStatus').val(),
                        refundStatus:$('#refundStatus').val(),
                        ticketType:$('#ticketType').val(),
                        payStartTime:$('#payStartTime').val(),
                        payEndTime:$('#payEndTime').val(),
                        playStartTime:$('#playStartTime').val(),
                        playEndTime:$('#playEndTime').val(),
                        orderDistributor:$('#orderDistributor').val(),
                        productNo:productNo
                    };
                },
                // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
                // queryParamsType = 'limit' ,返回参数必须包含
                // limit, offset, search, sort, order 否则, 需要包含:
                // pageSize, pageNumber, searchText, sortName,
                // sortOrder.
                // 返回false将会终止请求
                columns : [
                    {
                        checkbox : true
                    },
                    {
                        field : 'customerName',
                        title : '客户名称'
                    },
                    {
                        field : 'customerPhone',
                        title : '客户电话'
                    },
                    {
                        field : 'customerUserId',
                        visible:false,
                        title : '客户身份证'
                    },
                    {
                        field : 'orderNo',
                        title : '订单编号'
                    },
                    {
                        field : 'electronicTicket',
                        title : '电子票'
                    },
                    {
                        field : 'productNo',
                        visible:false,
                        title : '产品编号'
                    },
                    {
                        field : 'productName',
                        title : '产品名称'
                    },
                    {
                        field : 'orderQuantity',
                        title : '数量'
                    },
                    {
                        field : 'payPrice',
                        visible:false,
                        title : '售价'
                    },
                    {
                        field : 'totalAmount',
                        visible:false,
                        title : '总金额'
                    },
                    {
                        field : 'payType',
                        visible:false,
                        title : '支付方式',
                        formatter : function(value, row, index){
                            return '<span class="label label-primary">'+value+'</span>';
                        }
                    },
                    {
                        field : 'payStatus',
                        title : '支付状态',
                        formatter : function(value, row, index){
                            if(value=='已支付'){
                                return '<span class="label label-primary">'+value+'</span>';
                            }else{
                                return '<span class="label label-danger">'+value+'</span>';
                            }
                        }
                    },
                    {
                        field : 'orderStatus',
                        title : '订单状态',
                        formatter : function(value, row, index){
                            if(value=='已消费'){
                                return '<span class="label label-primary">'+value+'</span>';
                            }else if(value=='已退票'){
                                return '<span class="label label-danger">'+value+'</span>';
                            }else if(value=='已结算'){
                                return '<span class="label label-info">'+value+'</span>';
                            }else {
                                return '<span class="label label-warning">'+value+'</span>';
                            }
                        }
                    },
                    {
                        field : 'refundStatus',
                        title : '退款状态',
                        formatter : function(value, row, index){
                        if(value=='未退款'){
                            return '<span class="label label-primary">'+value+'</span>';
                        }else if(value=='已退款'){
                            return '<span class="label label-danger">'+value+'</span>';
                        }
                    }
                    },
                    {
                        field : 'orderDistributor',
                        visible:false,
                        title : '分销商'
                    },
                    {
                        field : 'waybillNo',
                        visible:false,
                        title : '运单编号'
                    },
                    {
                        field : 'logisticsCompany',
                        visible:false,
                        title : '物流公司'
                    },
                    {
                        field : 'purchaseTime',
                        visible:false,
                        title : '购买时间'
                    },
                    {
                        field : 'consumptionTime',
                        visible:false,
                        title : '消费时间'
                    },
                    {
                        field : 'playTime',
                        title : '游玩时间',
                        formatter: function (value, row, index) {
                            return value.substr(0,10);
                        }
                    },
                    {
                        field : 'messageStatus',
                        visible:false,
                        title : '短信状态'
                    },
                    {
                        field : 'checkEquipmentNo',
                        visible:false,
                        title : '检票设备编码'
                    },
                    {
                        field : 'spotNo',
                        visible:false,
                        title : '景点编号'
                    },
                    {
                        field : 'ticketType',
                        visible:false,
                        title : '票种类型'
                    },
                    {
                        field : 'ticketNo',
                        visible:false,
                        title : '票种定义'
                    },
                    {
                        field : 'checkTime',
                        visible:false,
                        title : '检票时间'
                    },
                    {
                        field : 'orderVoucherno',
                        visible:false,
                        title : '取票凭证码'
                    },
                    {
                        field : 'selfMachineNo',
                        visible:false,
                        title : '购票设备编码'
                    },
                    {
                        field : 'isTransit',
                        title : '是否使用公交',
                        formatter : function(value, row, index) {
                            if (value == '1') {
                                return '<span class="label label-primary">是</span>';
                            } else {
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        field : 'bz',
                        visible:false,
                        title : '备注'
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var f = '<a class="btn btn-success btn-sm '+s_editStatus_h+'" href="#" title="人工核销"  mce_href="#" onclick="editStatus(\''
                                + row.orderId
                                + '\')"><i class="fa fa-key"></i></a> ';
                            var a = '<a class="btn btn-warning btn-sm '+s_editRefundStatus_h+'" href="#" title="人工退票"  mce_href="#" onclick="editRefundStatus(\''
                                + row.orderId
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var b = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" title="发货"  mce_href="#" onclick="sendGoods(\''+ row.orderId+ '\')"><i class="fa fa-key"></i></a> ';
                            if('未消费'==row.orderStatus){
                                if('1'==row.whetherSend){
                                    return f + a ;
                                }else{
                                    if('043004'==row.productType){
                                        return f + a + b;
                                    }else{
                                        return f + a ;
                                    }
                                }
                            }else{
                                if('043004'==row.productType){
                                    return b;
                                }
                            }
                        }
                    } ]
            });
}
function reLoad() {
    $('#exampleTable').bootstrapTable('refresh');
}
function add() {
    layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/add' // iframe的url
    });
}
function edit(id) {
    layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/edit/' + id // iframe的url
    });
}
function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : prefix+"/remove",
            type : "post",
            data : {
                'orderId' : id
            },
            success : function(r) {
                if (r.code==0) {
                    layer.msg(r.msg);
                    reLoad();
                }else{
                    layer.msg(r.msg);
                }
            }
        });
    })
}

function editStatus(id) {
    layer.confirm('确定要人工核销？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url: prefix + "/updateOrderStatus",
            type: "post",
            data: {
                'orderId': id
            },
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}
function sendGoods(orderId){
    layer.open({
        type : 2,
        title : '发货',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content : prefix + '/sendGoods/' + orderId // iframe的url
    });
}
function editRefundStatus(id) {
    layer.confirm('确定要人工退票？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url: prefix + "/updateRefundStatus",
            type: "post",
            data: {
                'orderId': id
            },
            success: function (r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}

function expotExcel() {
    var searchName = $('#searchName').val();
    var payStatus = $('#payStatus').val();
    var orderStatus = $('#orderStatus').val();
    var refundStatus = $('#refundStatus').val();
    var ticketType = $('#ticketType').val();
    var payStartTime = $('#payStartTime').val();
    var payEndTime = $('#payEndTime').val();
    var playStartTime = $('#playStartTime').val();
    var playEndTime = $('#playEndTime').val();
    var orderDistributor = $('#orderDistributor').val();
    var productNo = $('#productNo').val();
    var url = "?searchName="+searchName+"&payStatus="+payStatus+"&orderStatus="+orderStatus+"&ticketType="+ticketType
        +"&refundStatus="+refundStatus+"&payStartTime="+payStartTime+"&payEndTime="+payEndTime+"&playStartTime="+playStartTime+"&playEndTime="+playEndTime
        +"&productNo="+productNo+"&orderDistributor="+orderDistributor;
    window.location.href=prefix+"/excel.do"+url;
}

function batchRemove() {
    var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
    if (rows.length == 0) {
        layer.msg("请选择要删除的数据");
        return;
    }
    layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
        btn : [ '确定', '取消' ]
        // 按钮
    }, function() {
        var ids = [];
        // 遍历所有选择的行数据，取每条数据对应的ID
        $.each(rows, function(i, row) {
            ids[i] = row['orderId'];
        });
        $.ajax({
            type : 'POST',
            data : {
                "ids" : ids
            },
            url : prefix + '/batchRemove',
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    }, function() {

    });
}