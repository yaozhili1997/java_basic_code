
var prefix = "/cooperation/distribution";
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
                                type:$('#type').val(),
                                saleChannelCode:$('#saleChannelCode').val(),
                                payType:$('#payType').val(),
                                apiIsOpen:$('#apiIsOpen').val(),
                                whetherSendSms:$('#whetherSendSms').val(),
                                whetherCheckIp:$('#whetherCheckIp').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								/*{
									checkbox : true
								},*/
																{
									field : 'distributionNo', 
									title : '合作商编号',
									align : 'center',
									valign : 'center'
								},
																{
									field : 'name', 
									title : '名称',
									align : 'center',
									valign : 'center'
								},
																{
									field : 'typeName',
									title : '合作商类型',
									visible:false,
									align : 'center',
									valign : 'center'
								},
																{
									field : 'contactAddress', 
									title : '联系地址',
									visible:false,
									align : 'center',
									valign : 'center'
								},
																{
									field : 'contactName', 
									title : '联系人',
									visible:false,
									align : 'center',
									valign : 'center'
								},
																{
									field : 'contactMobile', 
									title : '联系方式',
									visible:false,
									align : 'center',
									valign : 'center'
								},
													/*			{
									field : 'customerServicePhone', 
									title : '客服电话',
									visible:false,
									align : 'center',
									valign : 'center'
								},*/
																{
									field : 'contactQq', 
									title : 'QQ',
									visible:false,
									align : 'center',
									valign : 'center'
								},
																{
									field : 'bank', 
									title : '开户行',
									visible:false,
									align : 'center',
									valign : 'center'
								},
																{
									field : 'bankAccount', 
									title : '开户账号',
									visible:false,
									align : 'center',
									valign : 'center'
								},
								{
									field : 'appId',
									title : '商户id',
                                    align : 'center',
                                    valign : 'center'
								},						{
									field : 'appSecret', 
									title : '商户密钥',
									align : 'center',
									valign : 'center'
								},
																{
									field : 'saleChannelCodeName',
									title : '销售渠道',
									align : 'center',
									valign : 'center'
								},
																{
									field : 'payTypeName',
									title : '支付方式',
									align : 'center',
									valign : 'center'
								},
										/*						{
									field : 'allowMaxUserNum', 
									title : '允许最大用户数',
									visible:false,
									align : 'center',
									valign : 'center'
								},
																{
									field : 'delayEntryTime', 
									title : '订单推迟入园时间(小时)' ,
									visible:false,
									align : 'center',
									valign : 'center'
								},*/
																{
									field : 'startDate', 
									title : '签约开始日期',
									visible:false,
									align : 'center',
									valign : 'center'
								},
																{
									field : 'endDate', 
									title : '签约结束日期',
									align : 'center',
									valign : 'center'
								},
										/*{
                                field : 'expiredTake',
                                title : '过期取票',
                                visible:false,
                                align : 'center',
                                valign : 'center',
                                formatter : function(value, row, index) {
                                    if (row.expiredTake == '0') {
                                        return '<span class="label label-danger">不支持</span>';
                                    } else if (row.expiredTake == '1') {
                                        return '<span class="label label-primary">支持</span>';
                                    }
                                }
                            },
                            {
                                field : 'partTake',
                                title : '部分取票',
                                visible:false,
                                align : 'center',
                                valign : 'center',
                                formatter : function(value, row, index) {
                                    if (row.partTake == '0') {
                                        return '<span class="label label-danger">不支持</span>';
                                    } else if (row.partTake == '1') {
                                        return '<span class="label label-primary">支持</span>';
                                    }
                                }
                            },*/
                            {
                                field : 'expiredRefund',
                                title : '过期退票',
                                visible:false,
                                align : 'center',
                                valign : 'center',
                                formatter : function(value, row, index) {
                                    if (row.expiredRefund == '0') {
                                        return '<span class="label label-danger">不支持</span>';
                                    } else if (row.expiredRefund == '1') {
                                        return '<span class="label label-primary">支持</span>';
                                    }
                                }
                            },
                            {
                                field : 'bookToday',
                                title : '预定当天票',
                                visible:false,
                                align : 'center',
                                valign : 'center',
                                formatter : function(value, row, index) {
                                    if (row.bookToday == '0') {
                                        return '<span class="label label-danger">不可以</span>';
                                    } else if (row.bookToday == '1') {
                                        return '<span class="label label-primary">可以</span>';
                                    }
                                }
                            },
                            {
                                field : 'afterTakeSceneRefund',
                                title : '取票后退票',
                                visible:false,
                                align : 'center',
                                valign : 'center',
                                formatter : function(value, row, index) {
                                    if (row.afterTakeSceneRefund == '0') {
                                        return '<span class="label label-danger">不支持</span>';
                                    } else if (row.afterTakeSceneRefund == '1') {
                                        return '<span class="label label-primary">支持</span>';
                                    }
                                }
                            },
																{
									field : 'createTime', 
									title : '创建时间',
									visible:false,
									align : 'center',
									valign : 'center'
								},
																{
									field : 'updateTime', 
									title : '修改时间',
									visible:false,
									align : 'center',
									valign : 'center'
								},
																{
									field : 'createUser', 
									title : '创建人',
									visible:false,
									align : 'center',
									valign : 'center'
								},
																{
									field : 'updateUser', 
									title : '修改人',
									visible:false,
									align : 'center',
									valign : 'center'
								},
												/*				{
									field : 'whetherPrint', 
									title : '打印',
									visible:false,
									align : 'center',
									valign : 'center',
									formatter : function(value, row, index) {
										if (row.afterTakeSceneRefund == '0') {
											return '<span class="label label-danger">不支持</span>';
										} else if (row.afterTakeSceneRefund == '1') {
											return '<span class="label label-primary">支持</span>';
										}
									}
								},*/
																{
									field : 'whetherSendSms', 
									title : '短信',
									align : 'center',
									valign : 'center',
									formatter : function(value, row, index) {
										if (row.whetherSendSms == '0') {
											return '<span class="label label-danger">不发送</span>';
										} else if (row.whetherSendSms == '1') {
											return '<span class="label label-primary">发送</span>';
										}
									}
								},
												/*				{
									field : 'noticeUrl', 
									title : '通知URL',
									visible:false,
									align : 'center',
									valign : 'center'
								},
																{
									field : 'whetherRefund', 
									title : '立即退款',
									visible:false,
									align : 'center',
									valign : 'center',
									formatter : function(value, row, index) {
										if (row.whetherRefund == '0') {
											return '<span class="label label-danger">关闭</span>';
										} else if (row.whetherRefund == '1') {
											return '<span class="label label-primary">开启</span>';
										}
									}
								},
																{
									field : 'whetherAutoRefundOutTime',
									title : '自动过期退票',
									visible:false,
									align : 'center',
									valign : 'center',
									formatter : function(value, row, index) {
										if (row.whetherAutoRefundOutTime == '0') {
											return '<span class="label label-danger">关闭</span>';
										} else if (row.whetherAutoRefundOutTime == '1') {
											return '<span class="label label-primary">开启</span>';
										}
									}
								},
																{
									field : 'whetherUseCar',
									title : '使用车辆',
									visible:false,
									align : 'center',
									valign : 'center',
									formatter : function(value, row, index) {
										if (row.whetherUseCar == '0') {
											return '<span class="label label-danger">不使用</span>';
										} else if (row.whetherUseCar == '1') {
											return '<span class="label label-primary">使用</span>';
										}
									}
								},
																{
									field : 'carPrice',
									title : '车费',
									visible:false,
									align : 'center',
									valign : 'center'
								},*/
																{
									field : 'whetherCheckIp', 
									title : '验证ip',
									align : 'center',
									valign : 'center',
									formatter : function(value, row, index) {
										if (row.whetherCheckIp == '0') {
											return '<span class="label label-danger">不验证</span>';
										} else if (row.whetherCheckIp == '1') {
											return '<span class="label label-primary">验证</span>';
										}
									}
								},
																{
									field : 'ips', 
									title : 'ip白名单',
									visible:false,
									align : 'center',
									valign : 'center'
								},
													/*		{
								field : 'authorizedAddress',
								title : '支付授权地址',
								visible:false,
								align : 'center',
								valign : 'center'
							},
																{
								field : 'whetherMoreEncode',
								title : '高级加密',
								visible:false,
								align : 'center',
								valign : 'center',
								formatter : function(value, row, index) {
									if (row.whetherMoreEncode == '0') {
										return '<span class="label label-danger">关闭</span>';
									} else if (row.whetherMoreEncode == '1') {
										return '<span class="label label-primary">开启</span>';
									}
								}
							},					{
							field : 'enable',
							title : '是否启用',
							align : 'center',
							valign : 'center',
							formatter : function(value, row, index) {
								if (row.enable == '0') {
									return '<span class="label label-danger">禁用</span>';
								} else if (row.enable == '1') {
									return '<span class="label label-primary">启用</span>';
								}
							}
							},*/
                            {
                                field : 'apiIsOpen',
                                title : '接口',
                                align : 'center',
                                valign : 'center',
                                formatter : function(value, row, index) {
                                    if (row.apiIsOpen == '0') {
                                        return '<span class="label label-danger">关闭</span>';
                                    } else if (row.apiIsOpen == '1') {
                                        return '<span class="label label-primary">开通</span>';
                                    }
                                }
                            },
                            {
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.id
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e;
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