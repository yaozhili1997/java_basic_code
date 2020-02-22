var product;
var selectedPlayTime;
var now;
var isNeedIdCardVerify;
var priceStockMap = {};
$(function() {
    if (shoppingCarId) {
        // 获取购物车信息
        getShoppingCartList({
            id: shoppingCarId,
            openId: openId,
        }, function (result) {
            if (result.status == 'success') {
                console.log(JSON.stringify(result.data));
                if (result.data.length > 0) {
                    var shoppingCar = result.data[0];
                    getProduct(shoppingCar.productNo, function(result) {
                        console.log(result);
                        product = result.data;
                        if (wcProductType == product.productType) {
                            $('#productName').html(product.productName);
                            $('#price').html(product.payPrice);
                            $('#imgUrl').attr('src', product.imgUrl);
                            $('[name="num"]').val(shoppingCar.productNum);
                            calculatePayment();
                            initAddress(shoppingCar);
                            getNow();
                        } else {
                            product = result.data;
                            isNeedIdCardVerify = product.whetherRealName == 1 ? true : false;
                            $('#productName').html(product.productName);
                            initDateSelector(product, shoppingCar);
                            initUserInfo(shoppingCar);
                        }
                    });
                } else {
                    document.location = '/index';
                }
            }
        });
    } else {
        getProduct(productNo, function(result) {
            console.log(result);
            product = result.data;
            if (wcProductType == product.productType) {
                $('#productName').html(product.productName);
                $('#price').html(product.payPrice);
                $('#imgUrl').attr('src', product.imgUrl);
                calculatePayment();
                initAddress();
                getNow();
            } else {
                $('#productName').html(product.productName);
                initDateSelector(product);
                isNeedIdCardVerify = product.whetherRealName == 1 ? true : false;
                initUserInfo();
            }
        });
    }
    // 	日期选择
    $(".date-box .item-date:not(.choice-date)").click(function(){
        var hasdateChose = $(this).hasClass("date-chose");
        var thirdDiv = $(".date-box").find(".date-chose").eq(2);

        if(hasdateChose == true){
            $(this).addClass("active").siblings().removeClass("active");
        }else{
            thirdDiv.addClass("active").siblings().removeClass("active");
        }
        selectedPlayTime = $(this).find('[name="playTime"]').val();
        calculatePayment();
    });

    $(".date-box .choice-date").click(function() {
        $('.date-select').show();
        if ($('.date-select').children().length == 0) {
            initCalendar();
        } else {
            var data = $('.date-select').calendarGetActive();
            if (data && data.date && selectedPlayTime) {
                if (parseDate(data.date).getTime() != parseDate(selectedPlayTime).getTime()) {
                    initCalendar();
                }
            }
        }
        function initCalendar() {
            var data = [];
            for (var i = 0; i < 60; i++) {
                var date = now.getTime() + i * 24 * 3600 * 1000;
                var dateStr = parseDate(date).format('yyyy-MM-dd');
                if (priceStockMap[dateStr]) {
                    data.push({date: dateStr, data : priceStockMap[dateStr].salePrice, check: 'false'});
                } else {
                    data.push({date: dateStr, data : product.payPrice, check: 'false'});
                }
            }

            $('.date-select').calendar({
                ele : '.date-chosebox', //依附
                title : '游玩日期',
                /*beginDate : '2019-01-01',
                endDate : '2019-02-01',*/
                selectedDate : selectedPlayTime,
                data : data,
                callback : function(data) {
                    var selectedTime = parseDate(data.date + ' 00:00:00').getTime();
                    var findSelectedTime = false;
                    $('.date-box .item-date:not(.choice-date)').each(function() {
                        var playTime = $(this).find('[name="playTime"]').val();
                        if (playTime) {
                            if (parseDate(playTime + ' 00:00:00').getTime() == selectedTime) {
                                $(this).trigger('click');
                                findSelectedTime = true;
                            }
                        }
                    });
                    if (!findSelectedTime) {
                        var dayAfterTwo = parseDate(selectedTime);
                        var priceStock = priceStockMap[dayAfterTwo.format('yyyy-MM-dd')];
                        $('.arbitrarily-date').find('.date').html(getDayName(dayAfterTwo.getDay()) + ' <small style="font-size: 14px;display: inline-block;">' + dayAfterTwo.format('MM-dd') + '</small>');
                        $('.arbitrarily-date').find('.price').html(priceStock ? priceStock.salePrice : product.payPrice);
                        $('.arbitrarily-date').find('.stock').html(priceStock ? getRemainNum(priceStock) : '不限');
                        if (priceStock) {
                            $('.arbitrarily-date').find('.stock').parent().show();
                        } else {
                            $('.arbitrarily-date').find('.stock').parent().hide();
                        }
                        $('.arbitrarily-date').find('[name="playTime"]').val(dayAfterTwo.format('yyyy-MM-dd'));
                        $('.arbitrarily-date').trigger('click');
                    }
                    $('.date-select').closeCalendar();
                }
            });
        }
    });
    $('.mui-input-numbox[name="num"]').blur(function() {
        var num = parseInt($(this).val());
        if (num > 999) {
            num = 999;
        }
        $(this).val(num);
        calculatePayment();
    });
    $('#buyerName,#buyerIdCard,#buyerMobile').blur(function() {
        var value = $.trim($(this).val());
        var id =$(this).attr('id');
        var tip = $('#' + id +'Tip');
        if (!value) {
            tip.html('必须填');
        } else {
            tip.html('');
        }
    });
    var todayDateWidth = $(".today-date").width();
    $(".stock-box").width(todayDateWidth - 10);
    showShopCarTotalCount();
});

function getNow(callback) {
    $.post('/getServerTime', {}, function(r) {
        now = parseDate(r.now);
        if (callback) {
            callback(now);
        }
    });
}

function initDateSelector(product, shoppingCar) {
    $.post('/getServerTime', {}, function(r) {
        var priceStocks = product.priceStocks;
        if (priceStocks) {
            for (var i = 0; i < priceStocks.length; i++) {
                var priceStock = priceStocks[i];
                priceStockMap[priceStock.date] = priceStock;
            }
        }
        now = parseDate(r.now);
        // 判断是否可以订购当日的票
        if (product.stopSellingTicketsTime) {
            if (parseDate(now.format('yyyy-MM-dd') + ' ' + (product.stopSellingTicketsTime)).getTime() <= now.getTime()) {
                now = new Date(now.getTime() + 24 * 3600 * 1000);
            }
        }
        var priceStock = priceStockMap[now.format('yyyy-MM-dd')];
        $('.today-date').find('.date').html(now.format('MM-dd'));
        $('.today-date').find('.price').html(priceStock ? priceStock.salePrice : product.payPrice);
        if (priceStock) {
            $('.today-date').find('.stock').html(priceStock ? getRemainNum(priceStock) : '').parent().show();
        }
        $('.today-date').find('[name="playTime"]').val(now.format('yyyy-MM-dd'));

        var dayAfterOne = parseDate(now.getTime() + 1 * 24 * 3600 * 1000);
        priceStock = priceStockMap[dayAfterOne.format('yyyy-MM-dd')];
        $('.tomorrow-date').find('.date').html(dayAfterOne.format('MM-dd'));
        $('.tomorrow-date').find('.price').html(priceStock ? priceStock.salePrice : product.payPrice);
        if (priceStock) {
            $('.tomorrow-date').find('.stock').html(priceStock ? getRemainNum(priceStock) : '').parent().show();
        }
        $('.tomorrow-date').find('[name="playTime"]').val(dayAfterOne.format('yyyy-MM-dd'));
        var dayAfterTwo = parseDate(now.getTime() + 2 * 24 * 3600 * 1000);
        // 如果有购物车信息，判断购物车游玩时间
        if (shoppingCar) {
            selectedPlayTime = shoppingCar.playTime;
            var playTime = new Date(selectedPlayTime + ' 00:00:00');
            if (dayAfterTwo.getTime() < playTime.getTime()) {
                dayAfterTwo = playTime;
            }
        }
        priceStock = priceStockMap[dayAfterTwo.format('yyyy-MM-dd')];
        $('.arbitrarily-date').find('.date').html(getDayName(dayAfterTwo.getDay()) + ' <small style="font-size: 14px;display: inline-block;">' + dayAfterTwo.format('MM-dd') + '</small>');
        $('.arbitrarily-date').find('.price').html(priceStock ? priceStock.salePrice : product.payPrice);
        if (priceStock) {
            $('.arbitrarily-date').find('.stock').html(priceStock ? getRemainNum(priceStock) : '').parent().show();
        }
        $('.arbitrarily-date').find('[name="playTime"]').val(dayAfterTwo.format('yyyy-MM-dd'));

        if (!selectedPlayTime) {
            $(".date-box .item-date:first").trigger('click');
        } else {
            $(".date-box .item-date").each(function() {
                if($(this).find('[name="playTime"]').val() == selectedPlayTime) {
                    $(this).trigger('click');
                }
            });
        }
    }, 'json');
}

function getDayName(day) {
    switch (day) {
        case 0: return '周日';
        case 1: return '周一';
        case 2: return '周二';
        case 3: return '周三';
        case 4: return '周四';
        case 5: return '周五';
        case 6: return '周六';
    }
}

function modifyBuyNum(s, _this) {
    var numInput = $(_this).parent().find('[name="num"]');
    var num = parseInt(numInput.val());
    if (!num) {
        num = 1;
    }
    if (s == '-') {
        if (num > 1) {
            num -= 1;
        }
    } else if (s == '+') {
        num += 1;
    }
    if (num > 999) {
        num = 999;
    }
    numInput.val(num);
    calculatePayment();
}

function calculatePayment() {
    var price = '';
    if (wcProductType == product.productType) {
        price = $('#price').html();
    } else {
        price = $('.item-date.active').find('.price').html();
    }
    if (!price) {
        price = product.payPrice
    }
    var num = parseInt($('input[name="num"]').val());
    if (isNeedIdCardVerify) {
        num = $('.customer-info-item').length;
    }
    var payment = parseFloat(price) * num;
    $('#payment').html(payment.toFixed(2));
}

function submitOrder(_this) {
    checkCustomerInfo(function(infos) {
        if (!selectedPlayTime) {
            if (!now) {
                now = new Date();
            }
            selectedPlayTime = now.format('yyyy-MM-dd');
        }
        $(_this).prop('disabled', true);
        var num = $('input[name="num"]').val();
        $.each(infos, function() {
            // 微信支付 006001 支付宝 006002
            // info.payType = '006001';
            this.playTime = selectedPlayTime;
            this.productNo = product.productNo;
            this.nums = num;
        });
        if (!checkStock(selectedPlayTime, isNeedIdCardVerify ? infos.length : num)) {
            $(_this).prop('disabled', false);
            return;
        }
        var params = {};
        params.data = JSON.stringify(infos);
        var loading = $.openLoading();
        createOrder(params, function(result) {
            $.closeLoading(loading);
            if (result.code !== 0) {
                $(_this).prop('disabled', false);
                mui.alert(result.msg);
            } else {
                payRequest(result.data.data, result.orderNo);
                if (shoppingCarId) {
                    var param = {};
                    param.id = shoppingCarId;
                    param.openId = openId;
                    shopCarDelete(param, function(result) {
                        console.log(result);
                    });
                }
            }
        });
    });
}

// 添加购物车
function addShoppingCart() {
    checkCustomerInfo(function(customerInfos) {
        var num = $('input[name="num"]').val();
        if (!selectedPlayTime) {
            if (!now) {
                now = new Date();
            }
            selectedPlayTime = now.format('yyyy-MM-dd');
        }
        if (shoppingCarId) {
            var params = {};
            params.openId = openId;
            params.id = shoppingCarId;
            params.playTime = selectedPlayTime;
            params.users = [];
            $.each(customerInfos, function() {
                var userInfo = {
                    idCard: this.customerUserId,
                    phoneNum: this.customerPhone,
                    customerName: this.customerName,
                };
                var address = this.address;
                if (address) {
                    Object.assign(userInfo, address);
                }
                params.users.push(userInfo);
            });
            if (isNeedIdCardVerify) {
                params.productNum = params.users.length;
            } else {
                params.productNum = num;
            }
            if (!checkStock(selectedPlayTime, params.productNum)) {
                return;
            }
            var loading = $.openLoading();
            shopCarUpdate(params, function(result) {
                $.closeLoading(loading);
                if (result.status == 'success') {
                    console.log(result);
                    mui.toast('购物车已更新')
                } else {
                    mui.alert(result.errorMsg);
                }
            });
        } else {
            var params = {};
            var data = [];
            var info = {};
            info.productNo = product.productNo;
            info.playTime = selectedPlayTime;
            info.users = [];
            $.each(customerInfos, function() {
                var userInfo = {
                    idCard: this.customerUserId,
                    phoneNum: this.customerPhone,
                    customerName: this.customerName,
                };
                var address = this.address;
                if (address) {
                    Object.assign(userInfo, address);
                }
                info.users.push(userInfo);
            });
            if (isNeedIdCardVerify) {
                info.productNum = 1;
            } else {
                info.productNum = num;
            }
            if (!checkStock(selectedPlayTime, info.productNum)) {
                return;
            }
            data.push(info);
            params.data = data;
            params.openId = openId;
            var loading = $.openLoading();
            shopCarSave(params, function(result) {
                $.closeLoading(loading);
                if (result.status == 'success') {
                    console.log(result);
                    shoppingCarId = result.data;
                    mui.toast('已加入购物车');
                    showShopCarTotalCount();
                } else {
                    mui.alert(result.errorMsg);
                }
            });
        }
    });
}

function checkCustomerInfo(callback) {
    var customerInfoItems = $('.customer-info-item');
    var addressInfo = $('#addressInfo');
    if (addressInfo.length == 1) {
        var consigneeName = addressInfo.find('[name="name"]').val().trim();
        var consigneePhone = addressInfo.find('[name="mobile"]').val().trim();
        var area = addressInfo.find('[name="area"]').val().trim();
        var detailAddress = addressInfo.find('[name="address"]').val().trim();
        if (!consigneeName) {
            mui.alert('收件人姓名不能为空');
            return false;
        }
        if (!consigneePhone) {
            mui.alert('收件人手机不能为空');
            return false;
        }
        if (!area) {
            mui.alert('请选择收件人所在地区');
            return false;
        }
        if (!detailAddress) {
            mui.alert('收件人详细地址不能为空');
            return false;
        }
        area = area.split(' ');
        var province = area[0];
        var city = area[1];
        var region = area[2];
        if (callback) {
            callback([{
                customerName: consigneeName,
                customerPhone: consigneePhone,
                address: {
                    country: '',
                    province: province,
                    city: city,
                    region: region,
                    detailAddress: detailAddress,
                },
            }]);
        }
        return true;
    } else if (customerInfoItems.length > 0) {
        var allPass = true;
        var infos = [];
        $.each(customerInfoItems, function() {
            var nameInput = $(this).find('[name="name"]');
            var idCardInput = $(this).find('[name="idcardNo"]');
            var mobileInput = $(this).find('[name="mobile"]');
            var buyerName =  $.trim(nameInput.val());
            var buyerIdCard = $.trim(idCardInput.val());
            var buyerMobile = $.trim(mobileInput.val());
            if (!buyerName) {
                mui.alert('姓名不能为空');
                allPass = false;
                return false;
            } else if (/[0-9]/.test(buyerName)) {
                mui.alert('姓名中不能包含数字');
                nameInput.addClass('error');
                allPass = false;
                return false;
            } else {
                nameInput.removeClass('error');
            }
            if (!buyerIdCard) {
                if (product.whetherUserId === '1') {
                    mui.alert('身份证号不能为空');
                    allPass = false;
                    return false;
                }
            } else if (!identityCodeValid(buyerIdCard)) {
                mui.alert('身份证号输入有误');
                idCardInput.addClass('error');
                allPass = false;
                return false;
            } else {
                idCardInput.removeClass('error');
            }
            if (!buyerMobile) {
                mui.alert('手机号不能为空');
                allPass = false;
                return false;
            } else if (!checkMobile(buyerMobile)) {
                mui.alert('手机号输入有误');
                mobileInput.addClass('error');
                allPass = false;
                return false;
            } else {
                mobileInput.removeClass('error');
            }
            infos.push({
                customerName: buyerName,
                customerPhone: buyerMobile,
                customerUserId: buyerIdCard,
            });
        });
        var idCardCountMap = {};
        var hasSameIdCard = false;
        $.each(infos, function() {
            if (idCardCountMap[this.customerUserId]) {
                idCardCountMap[this.customerUserId]++;
                hasSameIdCard = true;
            } else {
                idCardCountMap[this.customerUserId] = 1;
            }
        });
        if (hasSameIdCard) {
            allPass = false;
            mui.alert('游客身份证信息不能相同，请检查');
        }
        if (allPass) {
            if (callback) {
                callback(infos);
            }
        }
        return allPass;
    } else {
        var buyerName = $.trim($('#buyerName').val());
        var buyerIdCard = $.trim($('#buyerIdCard').val());
        var buyerMobile = $.trim($('#buyerMobile').val());
        var allPass = true;
        if (!buyerName) {
            mui.alert('姓名不能为空');
            allPass = false;
            return false;
        } else {
            $('#buyerNameTip').html('');
            if (/[0-9]/.test(buyerName)) {
                mui.alert('姓名中不能包含数字');
                allPass = false;
                return false;
            }
        }
        if (!buyerIdCard) {
            if (product.whetherUserId === '1') {
                mui.alert('身份证号不能为空');
                allPass = false;
                return false;
            }
        } else if (!identityCodeValid(buyerIdCard)) {
            mui.alert('身份证号输入有误');
            allPass = false;
            return false;
        }
        if (!buyerMobile) {
            mui.alert('手机号不能为空');
            allPass = false;
            return false;
        } else if (!checkMobile(buyerMobile)) {
            mui.alert('手机号输入有误');
            allPass = false;
            return false;
        }
        if (allPass) {
            if (callback) {
                callback([{
                    customerName: buyerName,
                    customerPhone: buyerMobile,
                    customerUserId: buyerIdCard,
                }]);
            }
        }
        return allPass;
    }
}

// 检查库存
function checkStock(date, num) {
   var priceStock = priceStockMap[date];
   if (priceStock) {
        if (getRemainNum(priceStock) >= num) {
            return true;
        } else {
            mui.alert('选择日期库存不足，请选择其他日期');
            return false;
        }
   } else {
       return true;
   }
}

function getRemainNum(priceStock) {
    if (priceStock) {
        var remainNum = priceStock.stockNum - priceStock.saleNum;
        return remainNum >= 0 ? remainNum : 0;
    } else {
        return 10000;
    }
}

function payRequest(data, orderNo) {
    if (loginPlatform == 'wx') {
        function onBridgeReady(){
            WeixinJSBridge.invoke(
                'getBrandWCPayRequest', data,
                function(res){
                    if(res.err_msg == "get_brand_wcpay_request:ok"){
                        // 使用以上方式判断前端返回,微信团队郑重提示：
                        //res.err_msg将在用户支付成功后返回ok，但并不保证它绝对可靠。
                        document.location = '/order/payResult?orderNo=' + orderNo;
                    } else if(res.err_msg == "get_brand_wcpay_request:cancel") {
                        $('#submitBtn').prop('disabled', false);
                    } else {
                        mui.alert(JSON.stringify(res));
                        $('#submitBtn').prop('disabled', false);
                    }
                });
        }
        if (typeof WeixinJSBridge == "undefined"){
            if( document.addEventListener ){
                document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
            }else if (document.attachEvent){
                document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
                document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
            }
        } else {
            onBridgeReady();
        }
    } else if (loginPlatform == 'alipay') {
        var form = $(data);
        $("body").append(form);
        form.submit();
    }
}

function initUserInfo(shoppingCar) {
    if (!isNeedIdCardVerify) {
        $('[name="num"]').parents('.mui-card-footer').show();
        if (shoppingCar) {
            $('[name="num"]').val(shoppingCar.productNum);
        }
    } else {
        $('.add-btn-box').show();
    }
    if (shoppingCar) {
        console.log(shoppingCar);
        var html = '';
        $.each(shoppingCar.users, function() {
            html += doT.template($('#template-customer-info').text())({
                idcardNo: this.idCard,
                name: this.customerName,
                mobile: this.phoneNum,
            });
        });
        $('#customer-info-list').append(html);
    } else {
        var customerInfoHtml = doT.template($('#template-customer-info').text())();
        $('#customer-info-list').append(customerInfoHtml);
        $.post('/order/getOneCustomerIdCard', {}, function(result) {
            if (result.code === 0) {
                var data = result.data;
                if (data) {
                    if (isNeedIdCardVerify) {
                        var firstChild = $('#customer-info-list').children().first();
                        firstChild.find('[name="name"]').val(data.name);
                        firstChild.find('[name="mobile"]').val(data.mobile);
                        firstChild.find('[name="idcardNo"]').val(data.idcardNo);
                    } else {
                        $('#buyerName,#buyerIdCard,#buyerMobile').each(function() {
                            var id =$(this).attr('id');
                            var value = '';
                            switch (id) {
                                case 'buyerName' : {value = data.name;break;}
                                case 'buyerIdCard' : {value = data.idcardNo;break;}
                                case 'buyerMobile' : {value = data.mobile;break;}
                            }
                            $(this).val(value);
                            var tip = $('#' + id +'Tip');
                            if (!value) {
                                tip.html('必须填');
                            } else {
                                tip.html('');
                            }
                        });
                    }
                }
            }
        }, 'json');
    }
    /*getOrderUserInfo({openId : openId}, function(result) {
        if (result.status == 'success') {
            var data = result.data;
            $('#buyerName,#buyerIdCard,#buyerMobile').each(function() {
                var id =$(this).attr('id');
                var value = '';
                switch (id) {
                    case 'buyerName' : {value = data.customerName;break;}
                    case 'buyerIdCard' : {value = data.customerUserId;break;}
                    case 'buyerMobile' : {value = data.customerPhone;break;}
                }
                $(this).val(value);
                var tip = $('#' + id +'Tip');
                if (!value) {
                    tip.html('必须填');
                } else {
                    tip.html('');
                }
            });
        }
    });*/
}
var customerIdCardMap;
function chooseCustomer() {
    if (!customerIdCardMap) {
        $.post('/order/getCustomerIdCardList', {}, function(result) {
            if (result.code === 0) {
                if (result.list.length == 0) {
                    mui.alert('暂无可选游客，请输入');
                    return;
                }
                $('#chooseCustomerMask').show();
                customerIdCardMap = {};
                $.each(result.list, function() {
                    customerIdCardMap[this.idcardNo] = this;
                });
                var html = doT.template($('#template-customer-info-select').html())(result.list);
                var form = $('#chooseCustomerMask').find('form');
                form.html(html);
                setCustomerSelected();
            }
        }, 'json');
    } else {
        if (Object.keys(customerIdCardMap).length > 0) {
            $('#chooseCustomerMask').show();
            setCustomerSelected();
        } else {
            mui.alert('暂无可选游客，请输入');
        }
    }

    function setCustomerSelected() {
        var form = $('#chooseCustomerMask').find('form');
        $('#chooseCustomerMask').find('[name="checkbox"]').prop('checked', false);
        $('#customer-info-list').children().find('[name="idcardNo"]').each(function() {
            var idcardNo = $(this).val();
            form.find('[name="checkbox"][value="' + idcardNo  + '"]').prop('checked', true);
        });
    }
}

function addCustomer() {
    $('#customer-info-list').append(doT.template($('#template-customer-info').text())());
    calculatePayment();
}

function removeCustomer(_this) {
    if($('#customer-info-list').children().length > 1) {
        $(_this).parent().parent().remove();
        calculatePayment();
    }
}

function addOrRemoveCustomer(_this) {
    var idcardNo = $(_this).val();
    if ($(_this).is(':checked')) {
        var isExist = false;
        $('#customer-info-list').find('.customer-info-item').each(function() {
            if ($.trim($(this).find('[name="idcardNo"]').val()) == idcardNo) {
                isExist = true;
            }
        });
        if (!isExist) {
            var data = customerIdCardMap[idcardNo];
            var customerInfoHtml = doT.template($('#template-customer-info').text())(data);
            $('#customer-info-list').append(customerInfoHtml);
        }
    } else {
        var items = $('#customer-info-list').find('.customer-info-item');
        if (items.length > 1) {
            $('#customer-info-list').find('.customer-info-item').each(function() {
                if ($.trim($(this).find('[name="idcardNo"]').val()) == idcardNo) {
                    $(this).remove();
                }
            });
        }
    }
    calculatePayment();
}

function initAddress(shoppingCar) {
    if (shoppingCar) {
        // alert(JSON.stringify(shoppingCar));
        inputAddress(shoppingCar.users[0]);
    } else {
        var params = {};
        params.openId = openId;
        getMyAddressList(params, function(result) {
            var addressList = result.data;
            if (addressList && addressList.length > 0) {
                var defaultAddress;
                $.each(addressList, function() {
                    if (this.isDefault === '1') {
                        defaultAddress = this;
                        return false;
                    }
                });
                if (!defaultAddress) {
                    defaultAddress = addressList[0];
                }
                inputAddress(defaultAddress);
            } else {
                inputAddress();
            }
        });
    }
}

var addressEditing = false;
var addressMap = {};
var selectedAddressNo;
function openAddressSelectorModal() {
    addressEditing = false;
    var params = {};
    params.openId = openId;
    getMyAddressList(params, function (result) {
        if (result.status == 'success') {
            var data = result.data;
            var html = doT.template($('#template-address-select').text())(data);
            $('#addressSelectList').html(html);
            $.each(data, function() {
                addressMap[this.addressNo] = this;
            });
        }
    });
    $('#addressChooseMask').show();
    $('.address-confirm-select').show();
    $('.save-address').hide();
}
// 添加或者编辑地址
function addOrEditAddress(addressNo) {
    addressEditing = true;
    $('.address-confirm-select').hide();
    $('.save-address').show();

    var mask = $('#addressChooseMask');
    var html = doT.template($('#template-add-address-form').html())();
    mask.find('#addressSelectList').html(html);

    var $target = mask.find('[name="area"]');
    $target.on('click', function (event) {
        event.stopPropagation();
        $target.citySelect('open');
    });
    $target.on('done.ydui.cityselect', function (ret) {
        $(this).val(ret.provance + ' ' + ret.city + ' ' + ret.area);
    });
    if (addressNo) {
        var params = {};
        params.openId = openId;
        params.addressNo = addressNo;
        getMyAddress(params, function(result) {
            var address = result.data;
            if (address) {
                mask.find('[name="addressNo"]').val(address.addressNo);
                mask.find('[name="consigneeName"]').val(address.consigneeName);
                mask.find('[name="consigneePhone"]').val(address.consigneePhone);
                mask.find('[name="area"]').val(address.province + ' ' + address.city + ' ' + address.region);
                mask.find('[name="detailAddress"]').val(address.detailAddress);
                mask.find('[name="postalCode"]').val(address.postalCode);
            }
            $target.citySelect({
                provance: address.province,
                city: address.city,
                area: address.region
            });
        });
    } else {
        $target.citySelect();
    }
}

function saveAddress(_this) {
    var mask = $('#addressChooseMask');
    var addressNo = mask.find('[name="addressNo"]').val();
    var name = mask.find('[name="consigneeName"]').val();
    var mobile = mask.find('[name="consigneePhone"]').val();
    var area = mask.find('[name="area"]').val();
    var details = mask.find('[name="detailAddress"]').val();
    var zipCode = mask.find('[name="postalCode"]').val();

    if (!name) {
        mui.toast('请输入姓名');
        return;
    } else if (name.length < 2) {
        mui.toast('姓名至少两个字');
        return;
    }

    if (!mobile) {
        mui.toast('请输入手机号');
        return;
    }

    if (!area) {
        mui.toast('请选择所在地区');
        return;
    }

    if (!details) {
        mui.toast('请输入详细地址');
        return;
    }
    $(_this).prop('disabled', true);
    var areas = area.split(' ');
    var params = {};
    params.openId = openId;
    params.addressNo = addressNo;
    params.province = areas[0];
    params.city = areas[1];
    params.region = areas[2];
    params.consigneeName = name;
    params.consigneePhone = mobile;
    params.detailAddress = details;
    params.postalCode = zipCode;
    saveMyAddress(params, function(result) {
        if (result.status == 'success') {
            openAddressSelectorModal();
            mui.toast('保存成功');
        } else {
            mui.alert(result.errorMsg);
        }
        $(_this).prop('disabled', false);
    });
}

function addressChooseBack() {
    if (addressEditing) {
        openAddressSelectorModal();
    } else {
        $('#addressChooseMask').hide();
    }
}

function confirmAddressChoose() {
    var mask = $('#addressChooseMask');
    selectedAddressNo = mask.find('[name="addressRadio"]:checked').val();
    if (selectedAddressNo) {
        var selectedAddress = addressMap[selectedAddressNo];
        inputAddress(selectedAddress);
        mask.hide();
    } else {
        mui.alert('请选择一个收件地址');
    }
}

function inputAddress(address) {
    var addressInfo = $('#addressInfo');
    // 替换掉老的input
    addressInfo.find('[name="area"]').parent().html('<input type="text" placeholder="请选择所在地区" name="area" style="width: 70%; border: none; margin-bottom: 0px;padding-bottom: 0px;padding-top: 0px;font-size: 14px;height: 30px" id="area" readonly="readonly"/>');
    var $target = addressInfo.find('[name="area"]');
    $target.on('click', function (event) {
        event.stopPropagation();
        $target.citySelect('open');
    });
    $target.on('done.ydui.cityselect', function (ret) {
        $(this).val(ret.provance + ' ' + ret.city + ' ' + ret.area);
    });
    if (address) {
        addressInfo.find('[name="name"]').val(address.consigneeName ? address.consigneeName : address.customerName);
        addressInfo.find('[name="mobile"]').val(address.consigneePhone ? address.consigneePhone : address.phoneNum);
        addressInfo.find('[name="area"]').val(address.province + ' ' + address.city + ' ' + address.region);
        addressInfo.find('[name="address"]').val(address.detailAddress);
        $target.citySelect({
            provance: address.province,
            city: address.city,
            area: address.region
        });
    } else  {
        $target.citySelect();
    }
}

function confirmChooseCustomer() {
    $('#chooseCustomerMask').hide();
}

function toShoppingCartList() {
    window.document.location = '/shoppingCart';
}

function showShopCarTotalCount() {
    shopCarTotalCount({openId: openId}, function(result) {
        if (result.status == 'success') {
            if (result.data > 0) {
                $('#shoppingCarNum').html(result.data).show();
            } else {
                $('#shoppingCarNum').hide();
            }
        }
    });
}