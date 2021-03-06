
var prefix = "/fin/completedSettlement";
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
                        searchName:$('#searchName').val(),
                        spotNo:$('#spotNo').val(),
                        sellUser:$('#sellUser').val()
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
                        field : 'settlementNo',
                        title : '结算编码'
                    },
                    {
                        field : 'spotNo',
                        title : '景区名称'
                    },
                    {
                        field : 'sellUser',
                        title : '分销商'
                    },
                    {
                        field : 'settlementNumber',
                        title : '结算数量'
                    },
                    {
                        field : 'settlementAcoumt',
                        title : '结算金额'
                    },
                    {
                        field : 'refundNum',
                        title : '退票数量'
                    },
                    {
                        field : 'refundAcoumt',
                        title : '退票金额'
                    },
                    {
                        field : 'receivableAmount',
                        title : '应收金额'
                    },
                    {
                        field : 'settlementUser',
                        visible:false,
                        title : '结算人'
                    },
                    {
                        field : 'settlementTime',
                        visible:false,
                        title : '结算时间'
                    },
                    {
                        field : 'settlementReviewPerson',
                        visible:false,
                        title : '审核人'
                    },
                    {
                        field : 'settlementReviewTime',
						visible:false,
                        title : '审核时间'
                    },
                    {
                        field : 'reviewAmount',
                        title : '审核金额'
                    },
                    {
                        field : 'remarks',
                        visible:false,
                        title : '备注'
                    },
                    {
                        title : '操作',
                        field : 'id',
                        align : 'center',
                        formatter : function(value, row, index) {
                            var e = '<a class="btn btn-primary btn-sm '+s_print_h+'" href="#" mce_href="#" title="打印" onclick="openP(\''
                                + row.settlementNo
                                + '\')"><i class="fa fa-print"></i></a> ';
                            var f = '<a class="btn btn-success btn-sm '+s_excel_h+'" href="#" title="下载明细"  mce_href="#" onclick="expotExcel(\''
                                + row.settlementNo
                                + '\')"><i class="fa fa-cloud-download"></i></a> ';
                            return e+f ;
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
                'id' : id
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
            ids[i] = row['id'];
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

function expotExcel(settlementNo) {
    window.location.href="/fin/ticketSettlement/excel?settlementNo="+settlementNo;
}

function openP(settlementNo){
    window.open(prefix+"/printPage?settlementNo="+settlementNo, "", 'left=250,top=150,width=850,height=500,toolbar=no,menubar=no,status=no,scrollbars=yes,resizable=yes');
}