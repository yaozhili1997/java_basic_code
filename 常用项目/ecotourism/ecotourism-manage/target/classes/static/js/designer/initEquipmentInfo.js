function getEquipmentParams(callback) {
    if(typeof(equipmentUtil) != "undefined") {
        equipmentUtil.getTradeParams().then(function(data) {
			if(callback) {
                callback(data);
			}
        });
    } else {
        if(callback) {
            callback();
        }
	}
}

function buildRequestParams(data) {
    console.log(data);
	if(!data) {
		openTipModal("获取设备信息失败", 1000);
        data = {};
        data.cid = "cdusc";
        data.appId = "8686813462136744";
        data.appSecret = "777830141156964720686120";
        data.equipmentNo = "test";
	} else {
        data = $.parseJSON(data);
	}
    document.deviceInfo = {};
    document.deviceInfo.cid = data.cid;
    document.deviceInfo.appkey = data.appId;
    document.deviceInfo.secret = data.appSecret;
    document.deviceInfo.deviceNo = data.equipmentNo;
    document.deviceInfo.templateNo = data.templateNo;
    document.deviceInfo.distributionNo = data.distributionNo;
    document.deviceInfo.spotNo = data.spotNo;
}

function initRequestParams(callback) {
    getEquipmentParams(callback);
}

function getRequestParams(params, callback) {
	if(!document.deviceInfo) {
        initRequestParams(function(data) {
            buildRequestParams(data);
            if(!params) {
                params = {};
            }
            if(document.deviceInfo) {
                params = $.extend(params, document.deviceInfo);
            }
            if(callback) {
                callback(params);
			}
		});
	} else {
        if(!params) {
            params = {};
        }
        if(document.deviceInfo) {
            params = $.extend(params, document.deviceInfo);
        }
        if(callback) {
            callback(params);
        }
        return params;
	}
}

