var oneDayTime = 24 * 3600 * 1000;
var selectedDate = new Date();
var priceStockCache = {};
$(function() {
    setCurrMonth();
    $('.month-change-last').click(function() {
        selectedDate.setMonth(selectedDate.getMonth() - 1);
        setCurrMonth();
        $('#checkAll,.date-calendar-week-line input[type="checkbox"]').prop('checked', false);
    });
    $('.month-change-next').click(function() {
        selectedDate.setMonth(selectedDate.getMonth() + 1);
        setCurrMonth();
        $('#checkAll,.date-calendar-week-line input[type="checkbox"]').prop('checked', false);
    });
    $('.date-calendar-body').on('click', '.date-calendar-day:not(.last)', function() {
        if ($(this).is('.selected')) {
            $(this).removeClass('selected');
            setInputValue();
        } else {
            $(this).addClass('selected');
            setInputValue($(this).attr('date'));
        }
        setCheckboxState();
    });
    $('.date-calendar-week-line input[type="checkbox"]').click(function() {
        var arr = $('.date-calendar-day[day="' + $(this).val() + '"]:not(.last)');
        if (arr.length > 0) {
            if ($(this).is(':checked')) {
                arr.addClass('selected');
            } else {
                arr.removeClass('selected');
            }
            setCheckboxState();
        } else {
            $(this).prop('checked', false);
        }
        setInputValue();
    });
    $('#checkAll').click(function() {
        var that = this;
        var allCanNotSelected = true;
        $('.date-calendar-week-line input[type="checkbox"]').each(function() {
            var value = $(this).val();
            var allSize = $('.date-calendar-day[day="' + value + '"]:not(.last)').length;
            if (allSize > 0) {
                $(this).prop('checked', $(that).is(':checked'));
                allCanNotSelected = false;
            }
        });
        if (!allCanNotSelected) {
            if ($(that).is(':checked')) {
                $('.date-calendar-day:not(.last)').addClass('selected');
            } else {
                $('.date-calendar-day:not(.last)').removeClass('selected');
            }
        } else {
            $(that).prop('checked', false);
        }
        setInputValue();
    });
    $('[name="stockType"]').click(function() {
        if(parseInt($(this).val()) === 1) {
            $(this).parents('.stock-type-select').addClass('show-total-stock-num');
        } else {
            $(this).parents('.stock-type-select').removeClass('show-total-stock-num');
        }
    });
});

function setInputValue(date) {
    var info;
    if (!date) {
        $('.date-calendar-day.selected').each(function() {
            info = priceStockCache[$(this).attr('date')];
            if (info) {
                return false;
            }
        });
    } else {
        info = priceStockCache[date];
    }
    if (info) {
        $('#salePrice').val(info.salePrice);
        $('#settlementPrice').val(info.settlementPrice);
        $('#stockNum').val(info.stockNum);
    } else if ($('.date-calendar-day.selected').length == 0) {
        $('#salePrice').val($('#payPrice').val());
        $('#settlementPrice').val($('#payPrice').val());
        $('#stockNum').val(0);
    }
}

function setCheckboxState() {
    var allSelected = true;
    $('.date-calendar-week-line input[type="checkbox"]').each(function() {
        var value = $(this).val();
        var allSize = $('.date-calendar-day[day="' + value + '"]:not(.last)').length;
        var selectedSize = $('.date-calendar-day.selected[day="' + value + '"]:not(.last)').length;
        if (allSize > 0) {
            if (allSize == selectedSize) {
                $(this).prop('checked', true);
            } else {
                $(this).prop('checked', false);
                allSelected = false;
            }
        } else {
            $(this).prop('checked', false);
        }
    });
    $('#checkAll').prop('checked', allSelected);
}

function setCurrMonth() {
    var currMonth = selectedDate.getMonth() + 1;
    initCalendar(selectedDate.getFullYear(), currMonth);
    $('.selected-month-text').html(selectedDate.format('yyyy年MM月'));
    var lastMonth = currMonth - 1;
    var nextMonth = currMonth + 1;
    if (lastMonth == 0) {
        lastMonth = 12;
    }
    if (nextMonth == 13) {
        nextMonth = 1;
    }
    $('.month-change-last').find('.month-text').html(lastMonth);
    $('.month-change-next').find('.month-text').html(nextMonth);

}

function initCalendar(year, month) {
    var monthStartDate = new Date(year, month - 1, 1, 0, 0, 0);
    var monthStartDay = monthStartDate.getDay();
    var dataList = [];
    var oneWeek = [];
    if (monthStartDay != 1) {
        var i = monthStartDay;
        if (i == 0) {
            i = 7;
        }
        for ( ; i > 1; i--) {
            var date = new Date(monthStartDate.getTime() - oneDayTime * (i - 1));
            oneWeek.push(date);
        }
    }
    for (var i = 1; i <= 31; i++) {
        var date = new Date(monthStartDate.getTime() + oneDayTime * (i - 1));
        console.log(date.getDate() + ' ' + (date.getMonth() + 1));
        if ((date.getMonth() + 1) > month) {
            break;
        }
        oneWeek.push(date);
        if (date.getDay() == 0) {
            dataList.push([].concat(oneWeek));
            oneWeek = [];
        }
    }
    // 下一个月
    if (oneWeek.length > 0) {
        var monthLastDay = oneWeek[oneWeek.length - 1];
        var num = 7 - oneWeek.length;
        for (var i = 1; i <= num; i++) {
            var date = new Date(monthLastDay.getTime() + oneDayTime * i);
            oneWeek.push(date);
        }
        dataList.push(oneWeek);
    }
    var html = '';
    var today = parseDate(new Date().format('yyyy-MM-dd'));
    $.each(dataList, function() {
        html += '<div class="date-calendar-line flex">';
        $.each(this, function() {
            var date = this;
            var isToday = false;
            var isLast = false;
            if (date.format('yyyy-MM-dd') === today.format('yyyy-MM-dd')) {
                isToday = true;
            }
            if (today.getTime() > date.getTime()) {
                isLast = true;
            }
            console.log(isLast);
            html += '<div day="' + date.getDay() + '" class="date-calendar-day ' + (isLast ? 'last' : '') + '" date="' + date.format('yyyy-MM-dd') + '"><div class="day-text ' + (isToday ? 'today' : '') + '">' + (isToday ? '今' : date.getDate()) + '日</div><div class="day-info"></div></div>';
        });
        html += '</div>';
    });
    $('.date-calendar-body').html(html);
    showProductPriceStock();
}

function showProductPriceStock() {
    var dates = [];
    $('.date-calendar-body').find('.date-calendar-day').each(function() {
        dates.push($(this).attr('date'));
    });
    $.post('/product/productPriceStock/getProductPriceStockByDates', {dates : dates.join(','), productNo: $('#productNo').val()}, function(result) {
        $.each(result.list, function() {
            console.log(this.date);
            $('.date-calendar-body').find('[date="' + this.date + '"] .day-info').html(getDayInfoHtml(this));
            priceStockCache[this.date] = this;
        });
    }, 'json');
}

function getDayInfoHtml(info) {
    return '<ul style="font-size: 12px;">' +
    '<li>' + '销售价：' + info.salePrice + '</li>' +
    '<li>' + '结算价：' + info.settlementPrice + '</li>' +
    '<li>' + '已售/库存：' + info.saleNum + '/' + info.stockNum + '</li>' +
    '</ul>';
}

function save() {
    var salePrice = parseFloat($('#salePrice').val());
    var settlementPrice = parseFloat($('#settlementPrice').val());
    var stockNum = parseInt($('#stockNum').val());
    var stockType = parseInt($('[name="stockType"]:checked').val());
    var totalStockNum = parseInt($('#totalStockNum').val());
    var params = {};
    if (stockType === 1) {
        if (!totalStockNum || totalStockNum < 0) {
            layer.alert('请输入正确的总库存数');
            return;
        }
        params.stockType = stockType;
        params.totalStockNum = totalStockNum;
    } else if (stockType === 2) {
        var selectedDates = $('.date-calendar-day.selected');
        if (selectedDates.length <= 0) {
            layer.alert('请至少选择一个日期');
            return;
        }
        if (!salePrice || salePrice <= 0) {
            layer.alert('请输入正确的销售价');
            return;
        }
        if (!settlementPrice || settlementPrice <= 0) {
            layer.alert('请输入正确的结算价');
            return;
        }
        if (!stockNum || stockNum < 0) {
            layer.alert('请输入正确的库存数');
            return;
        }
        params.stockType = stockType;
        params.salePrice = salePrice;
        params.settlementPrice = settlementPrice;
        params.stockNum = stockNum;
        var dates = [];
        $.each(selectedDates, function() {
            dates.push($(this).attr('date'));
        });
        params.dates = dates.join(',');
    } else {
        params.stockType = stockType;
    }
    params.productNo = $('#productNo').val();
    $.post('/product/productPriceStock/save', params, function(result) {
        if (result.code === 0) {
            layer.msg('保存成功', {icon : 1});
            showProductPriceStock();
        } else {
            layer.alert(result.msg);
        }
    }, 'json');
}

function deletePriceStock() {
    if ($('.date-calendar-day.selected').length <= 0) {
        layer.alert('请至少选择一个日期');
        return;
    }
    layer.confirm('您是如何看待前端开发？', {
        btn: ['确定','关闭']
    }, function(){
        var selectedDates = $('.date-calendar-day.selected');
        var dates = [];
        $.each(selectedDates, function() {
            dates.push($(this).attr('date'));
        });
        var params = {};
        params.productNo = $('#productNo').val();
        params.dates = dates.join(',');
        $.post('/product/productPriceStock/deleteProductPriceStock', params, function(result) {
            if (result.code === 0) {
                layer.msg('删除成功', {icon : 1});
                $.each(dates, function() {
                    $('.date-calendar-body').find('[date="' + this + '"]').html('');
                    delete priceStockCache[this.date];
                });
            } else {
                layer.alert(result.msg);
            }
        }, 'json');
    }, function() {
    });
}