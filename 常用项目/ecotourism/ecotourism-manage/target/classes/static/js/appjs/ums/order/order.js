
var prefix = "/ums/order";
$(function() {
	load();
});

function load() {
	var result = "";
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
                        showFooter:true,  //开启底部
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 20, // 如果设置了分页，每页数据条数
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
                                payStatus:$('#payStatus').val(),
                                orderStatus:$('#orderStatus').val(),
                                refundStatus:$('#refundStatus').val(),
                                startTime:$('#startTime').val(),
                                endTime:$('#endTime').val(),
                                productNo:$('#productNo').val(),
                                applicationNo:$('#app').val(),
					           // username:$('#searchName').val()
							};
						},
                        responseHandler:function(res) {
                            result = res.pageTotal;
                            return res;
                        },
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									field : 'orderNo',
									title : '订单编号',
                                    footerFormatter : function(){
                                        return '总计：';
                                    }
								},
								{
										field : 'customerName',
										title : '客户名称'
									},
								{
										field : 'customerPhone',
										title : '客户电话',visible:false
									},
								{
									field : 'customerUserId', 
									title : '客户身份证' ,visible:false
								},
																{
									field : 'electronicTicket', 
									title : '电子票' 
								},
																{
									field : 'productNo', 
									title : '产品编号',visible:false
								},
																{
									field : 'productName', 
									title : '产品名称' 
								},
																{
									field : 'orderQuantity', 
									title : '数量',
									footerFormatter : function(){
                                        if(result){
                                            return result.totalNum;
                                        }
										return "";
									}
								},
																{
									field : 'payPrice', 
									title : '售价' 
								},
																{
									field : 'totalAmount', 
									title : '总金额',
									footerFormatter : function(){
                                        if(result){
                                            return result.totalAmount;
                                        }
                                        return "";
									}
								},
																{
									field : 'refundAmount', 
									title : '退票金额',
									footerFormatter : function(){
                                        if(result){
                                            return result.refundAmount;
                                        }
                                        return "";
									}
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
                                    }else {
                                        return '<span class="label label-warning">'+value+'</span>';
                                    }
                                }
                            },
																{
									field : 'purchaseTime', 
									title : '购买时间' 
								},
																{
									field : 'playTime', 
									title : '游玩时间' 
								},
																{
									field : 'orderVoucherno', 
									title : '取票凭证码',visible:false
								},
																{
									field : 'refundTime', 
									title : '退票时间' ,visible:false
								},
																{
									field : 'refundMoneyTime', 
									title : '退款时间' ,visible:false
								},
																{
									field : 'outRefundNo', 
									title : '退款单号' ,visible:false
								},
																{
									field : 'openId', 
									title : '用户唯一id',visible:false
                                                                },
																{
									field : 'applicationNo', 
									title : '来源应用'
								},
																{
									field : 'omsResult', 
									title : '到供应商下单返回结果',visible:false,
									formatter : function(value, row, index) {
										var e = '<a  href="javascript:void(0)" id="reqParam'+row.id+'" onclick="copyTitle('+"'reqParam"+row.id+"'"+');" mce_href="#" title="'+value+'"' +
											'data-clipboard-text="'+value+'"'
											+'>'+value.substr(0,10)+'</a> ';
										return e ;
									}
                                                                },
																{
									field : 'checkTime', 
									title : '入园时间'
								},
												]

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

//点击复制
function copyTitle(obj){
    var clipboard = new ClipboardJS("#"+obj);//实例化
    //复制成功执行的回调，可选
    clipboard.on('success', function(e) {
        parent.layer.alert("复制成功!");
    });
}