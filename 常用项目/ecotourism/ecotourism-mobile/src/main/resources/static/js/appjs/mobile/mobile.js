//下侧按钮
$(function() {
    //首页
    mui('#bottom_nav').on('tap', '#bottom_nav_index', function() {
        var url = $(this).attr('href');
        mui.openWindow({
            url: '/index',
            id: 'ticket'
        });
    });
    //发现
    mui('#bottom_nav').on('tap', '#bottom_nav_find', function() {
        var url = $(this).attr('href');
        mui.openWindow({
            url: '/find',
            id: 'ticket'
        });
    });
    //购物车
    mui('#bottom_nav').on('tap', '#bottom_nav_shopping_cart', function() {
        var url = $(this).attr('href');
        mui.openWindow({
            url: '/shoppingCart',
            id: 'ticket'
        });
    });
    //订单列表
    mui('#bottom_nav').on('tap', '#bottom_nav_order_list', function() {
        var url = $(this).attr('href');
        mui.openWindow({
            url: '/order/list',
            id: 'booking'
        });
    });
    //我的
    mui('#bottom_nav').on('tap', '#bottom_nav_user_center', function() {
        var url = $(this).attr('href');
        mui.openWindow({
            url: '/my/center',
            id: 'mycenter'
        });
    });
});

function getOrderStatusName(orderStatus) {
    switch (orderStatus) {
        case '005001': return '<small style="font-size: 12px;color:red;">已支付</small>';
        case '005002': return '<small style="font-size: 12px;color:red;">未支付</small>';
        case '004001': return '<small style="font-size: 12px;color:#02ac85;">未消费</small>';
        case '004002': return '<small style="font-size: 12px;color:red;">已消费</small>';
        case '004003': return '<small style="font-size: 12px;color:red;">已取消</small>';
        case '004004': return '<small style="font-size: 12px;color:#dd524d;">已退票</small>';
        case '004005': return '<small style="font-size: 12px;color:#02ac85;">已结算</small>';
        case '004006': return '<small style="font-size: 12px;color:#02ac85;">已取票</small>';
        case '004007': return '<small style="font-size: 12px;color:orangered;">出票中</small>';
        case '004008': return '<small style="font-size: 12px;color:orangered;">出票失败</small>';
        case '004777': return '<small style="font-size: 12px;color:orangered;">下单失败</small>';
        case '004009': return '<small style="font-size: 12px;color:orangered;">退票失败</small>';
        case '002777': return '<small style="font-size: 12px;color:orangered;">退款失败</small>';
        default : return orderStatus;
    }
}

function createOrder(params, callback) {
    $.post('/order/createOrder', params, function(data) {
        if (callback) {
            callback(data);
        }
    }, 'json');
}

function getProducts(productType, spotNo, searchValue, pageSize, pageNumber, callback) {
    var params = {productType : productType, spotNo : spotNo, productName : searchValue, pageSize : pageSize, pageNumber : pageNumber};
    var url = orderServerBasePath + 'app/clientHelper/listProducts?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function getProduct(productNo, callback) {
    var params = {productNo : productNo};
    var url = orderServerBasePath + 'app/clientHelper/getProduct?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function getOrderList(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/listOrders?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function getOrder(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/getOrder?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function shopCarSave(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/shopCarSave?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function shopCarUpdate(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/shopCarUpdate?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function shopCarDelete(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/shopCarDelete?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function getShoppingCartList(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/shopCarList?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function shopCarTotalCount(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/shopCarTotalCount?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function saveMyAddress(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/addressSave?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function getMyAddressList(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/addressList?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function getMyAddress(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/addressGet?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function deleteMyAddress(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/addressDelete?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function setMyDefaultAddress(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/addressSetDefault?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function refundOrder(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/refundOrder?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function getUserInfo(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/getUserInfo?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function productMonthSell(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/productMonthSell?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function getIndexImgs(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/getIndexImgs?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}


function getIndexImgs(params, callback) {
    var url = orderServerBasePath + 'app/clientHelper/getIndexImgs?applicationNo=' + applicationNo;
    postJSON(url, params, callback);
}

function postJSON(url, params, callback) {
    $.ajax({
        url: url,
        type: 'post',
        contentType: "application/json;charset=utf-8",
        dataType: 'json',
        data : JSON.stringify(params),
        success: function (data, status) {
            if (status == 'success') {
                if (callback)  {
                    callback(data);
                }
            }
        },
        fail: function (err, status) {
            console.log(JSON.stringify(err))
        }
    });
}

function geHome() {
    window.location = '/index';
}

function itemList() {
    window.location = '/item/list';
}

function itemDetails(productNo) {
    document.location='/item/details/' + productNo;
}

function checkCanRefund(orderStatus, payStatus) {
    if ((orderStatus == '004001'|| orderStatus == '004009' || orderStatus == '004008'|| orderStatus == '004777' || orderStatus == '002777') && payStatus == '005001') {
        return true;
    } else {
        return false;
    }
}

function checkCanShowQr(orderStatus, payStatus, electronicTicket) {
    if ((orderStatus == '004001'|| orderStatus == '004002' || orderStatus == '004006') && payStatus == '005001' && electronicTicket) {
        return true;
    } else {
        return false;
    }
}

function refund(orderNo, productNo, subOrderNo) {
    mui.confirm('确定要退款？', function(result) {
        if (result.index === 1) {
            var loading = $.openLoading();
            var params = {};
            params.orderNo = orderNo;
            params.productNo = productNo;
            params.subOrderNo = subOrderNo;
            params.openId = openId;
            refundOrder(params, function(result) {
                $.closeLoading(loading);
                if (result.status == 'success') {
                    mui.toast('退款成功');
                    setTimeout(function() {
                        window.location.reload();
                    }, 500);
                } else {
                    mui.alert(result.errorMsg ? result.errorMsg : JSON.stringify(result));
                }
            });
        }
    });
}


function addCollection(productNo, callback) {
    $.post('/item/addCollection', {productNo : productNo}, function(result) {
        console.log(result);
        if (callback) {
            callback(result);
        }
    }, 'json');
}

function deleteCollection(productNo, callback) {
    $.post('/item/deleteCollection', {productNo : productNo}, function(result) {
        console.log(result);
        if (callback) {
            callback(result);
        }
    }, 'json');
}