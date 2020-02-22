
var prefix = "/product/spotTicket";
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
                    return {
                        //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        limit: params.limit,
                        offset:params.offset,
                        sort:"sort",
                        order:"desc",
                        searchName:$('#searchName').val(),
                        distributionChannel:$('#distributionChannel').val(),
                        whetherShelves:$('#whetherShelves').val(),
                        productSecondType:$('#productSecondType').val(),
                        ticketGrouping:$('#ticketGrouping').val(),
                        ticketNo:$('#ticketNo').val()
                        // username:$('#searchName').val()
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
                        field : 'ticketNo',
                        visible:false,
                        title : '票种编号'
                    },
                    {
                        field : 'imgUrl',
                        title : '产品图片',
                        formatter:function(value,row,index){
                            var s;
                            if(row.imgUrl!=null){
                                var url = row.imgUrl;
                                s = '<a class = "view"  href="javascript:void(0)"><img style="width:80px;height:60px;"  src="'+url+'" /></a>';
                            }
                            return s;
                        }
                    },
                    {
                        field : 'productNo',
                        title : '产品编号'
                    },
                    {
                        field : 'productName',
                        title : '产品名称'
                    },
                    {
                        field : 'distributionChannel',
                        title : '销售渠道'
                    },
                    {
                        field : 'payPrice',
                        title : '售价'
                    },
                    {
                        field : 'orderCancel',
                        visible:false,
                        title : '订单取消设置',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">是</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        field : 'whetherUserPhone',
                        visible:false,
                        title : '是否需要联系人手机',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">是</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        field : 'whetherUserId',
                        visible:false,
                        title : '是否需要身份证',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">是</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        field : 'whetherMake',
                        visible:false,
                        title : '是否需要预约',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">是</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        field : 'certificateExchange',
                        visible:false,
                        title : '兑换凭证'
                    },
                    {
                        field : 'parkWay',
                        visible:false,
                        title : '入园方式'
                    },
                    {
                        field : 'tickType',
                        visible:false,
                        title : '门票类型'
                    },
                    {
                        field : 'whetherRefund',
                        visible:false,
                        title : '是否可以退款',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">是</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        field : 'whetherExamine',
                        visible:false,
                        title : '是否需要审核',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">是</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        field : 'whetherUserName',
                        visible:false,
                        title : '是否需要联系人',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">是</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        field : 'whetherShelves',
                        title : '是否上架',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">上架</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">下架</span>';
                            }
                        }
                    },
                    {
                        field : 'templateSmsNo',
                        visible:false,
                        title : '短信模板'
                    },
                    {
                        field : 'templateMmsNo',
                        visible:false,
                        title : '彩信模板'
                    },
                    {
                        field : 'settlementPrice',
                        title : '结算单价'
                    },
                    {
                        field : 'ticketGrouping',
                        title : '票种分组'
                    },
                    {
                        field : 'sort',
                        title : '排序',
                        formatter:function(value,row,index){
                            var s;
                            s = '<input id="sort" name="sort" style="width: 30px;" onblur="changeSort(\''+row.productId+'\',this)"  value="'+value+'" />';
                            return s;
                        }
                    },
                    {
                        field : 'effectiveDays',
                        visible:false,
                        title : '有效天数'
                    },
                    {
                        field : 'whetherShelvesAdvance',
                        visible:false,
                        title : '是否预售',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">是</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        field : 'advanceStartDate',
                        visible:false,
                        title : '预售开始时间'
                    },
                    {
                        field : 'advanceEndDate',
                        visible:false,
                        title : '预售结束时间'
                    },
                    {
                        field : 'whetherRefundStrategy',
                        visible:false,
                        title : '是否使用退票策略',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">是</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        field : 'whetherLimitSell',
                        visible:false,
                        title : '是否限购',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">是</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        field : 'whetherLimitStock',
                        visible:false,
                        title : '是否启用库存',
                        formatter : function(value, row, index){
                            if(value==1){
                                return '<span class="label label-primary">是</span>';
                            }else if(value==0){
                                return '<span class="label label-danger">否</span>';
                            }
                        }
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
                                + row.productId
                                + '\')"><i class="fa fa-edit"></i></a> ';
                            var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
                                + row.productId
                                + '\')"><i class="fa fa-remove"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
                                + row.productId
                                + '\')"><i class="fa fa-key"></i></a> ';
                            var c = '<a class="btn btn-primary btn-sm" href="#" title="价格库存日历"  mce_href="#" onclick="editPriceAndStock(\''
                                + row.productId
                                + '\')"><i class="fa fa-calendar"></i></a> ';

                            return e + c + d ;
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
        area : [ '100%', '100%' ],
        content : prefix + '/add' // iframe的url
    });
}
function edit(id) {
    layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '100%', '100%' ],
        content : prefix + '/edit/' + id // iframe的url
    });
}
function editPriceAndStock(id) {
    layer.open({
        type : 2,
        title : '编辑',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '100%', '100%' ],
        content : '/product/productPriceStock/edit/' + id // iframe的url
    });
}
function changeSort(id,_this) {
    $.ajax({
        url : prefix+"/changeSort",
        type : "post",
        data : {
            'productId' : id,
            'sort': $(_this).val()
        },
        success : function(r) {
            if (r.code==0) {
                layer.msg("操作成功");
                reLoad();
            }else{
                layer.msg(r.msg);
            }
        }
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
                'productId' : id
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

function resetPwd(id) {
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
            ids[i] = row['productId'];
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