/**
 *   DateFormat
 */
Date.prototype.format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "H+" : this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

// 生产随机数
function generateMixed(n) {
     var res = "";
     var chars = ['0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
     for(var i = 0; i < n ; i ++) {
         var id = Math.ceil(Math.random()*35);
         res += chars[id];
     }
     return res;
}

String.prototype.replaceAll = function(s1, s2){   
    return this.replace(new RegExp(s1,"gm"), s2);   
};
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};
Array.prototype.remove = function(dx) {
	if(isNaN(dx)||dx>this.length){return false;}
	this.splice(dx,1);
};
String.prototype.startWith=function(str){     
  var reg=new RegExp("^"+str);     
  return reg.test(this);        
};

String.prototype.endWith=function(str){     
  var reg=new RegExp(str+"$");     
  return reg.test(this);        
};

function formatDate(date, fmt) {
	try {
		if(typeof(date) == "string" || typeof(date) == "number") {
			date = new Date(date);
		}
		date = date.format(fmt);
	} catch (e) {
	}
	return date;
}

/**
 * Title提示信息
 */
this.tooltip = function(){	
	var xOffset = 25;
	var yOffset = 4;
	var body = $("body");
	body.on("mouseover mouseout", ".tooltip", function(e) {
		if(event.type == "mouseover"){
			//鼠标悬浮
			this.t = this.title;
			this.title = "";									  
			body.append("<p id='tooltip'>"+ this.t +"</p>");
			moveTip(e);
		} else if(event.type == "mouseout"){
			//鼠标离开
			this.title = this.t;		
			$("#tooltip").remove();
		}
    });
	body.on("mousemove", ".tooltip", function(e){
		moveTip(e);
	});
	function moveTip(e) {
		var width = $("#tooltip").width();
		var height = $("#tooltip").height();
		var x = e.pageX;
		var y = e.pageY;
		if((x - $("#tooltip").width() - xOffset) < 0) {
			x = x + xOffset;
		} else {
			x = x - $("#tooltip").width() - xOffset;
		}
		var pageHeight = window.innerHeight;
		if(document.documentElement.scrollHeight > pageHeight) {
			pageHeight = document.documentElement.scrollHeight;
		}
		if((pageHeight - 8) < (y + height + yOffset)) {
			y = y - height - yOffset;
		} else {
			y += yOffset;
		}
		$("#tooltip")
		.css("top",y + "px")
		.css("left",x + "px").fadeIn("fast");
	}
};

function copyText(text){
	workbench.platform.clipboard.setData(0,text);
	layer.msg('已复制到剪贴板',1,1);
}

var regex = {
	    /* "mobile" : /^0?(13[0-9]|15[012356789]|18[0236789]|14[57])[0-9]{8}$/,*/
	    /*"phone" : /^(([0\+]\d{2,3}-)?(0\d{2,3})-)?(\d{7,8})(-(\d{3,}))?$/,*/
	    "mobile" : /^\d{6,20}$/,
	    "phone" : /^\d+-\d+(?:-\d+)?$/,
	    "email" : /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/,
	    "float": /^\d+(\.\d+)?$/,
	    "int" : /^-?[0-9]\d*$/, // 匹配正整数和负整数
	    "post" : /^[\da-zA-Z\-]{3,10}$/,
	    "addressDetail" : /^.{5,120}$/,
	    "name" : /^.{2,25}$/,
	    "tid" : /^\d{16,}$/
};

function checkMobile(mobile) {
	if(mobile) {
		return regex.mobile.test(mobile);
	}
	return false;
}
function checkPhone(phone) {
	if(phone) {
		return regex.phone.test(phone);
	}
	return false;
}
function checkEmail(email) {
	if(email) {
		return regex.email.test(email);
	}
	return false;
}
function isFloat(oNum) {
	if (!oNum)
		return false;
	if (!regex.float.test(oNum))
		return false;
	try {
		if (parseFloat(oNum) != oNum)
			return false;
	} catch (ex) {
		return false;
	}
	return true;
}

function isInt(oNum) {
	if (!oNum)
		return false;
	if (!regex.int.test(oNum))
		return false;
	try {
		if (parseInt(oNum) != oNum)
			return false;
	} catch (ex) {
		return false;
	}
	return true;
}

function checkFloat(_this) {
	if(_this) {
		var value = _this.value.trim();
		if(!isFloat(value)) {
			if(_this.getAttribute("tip")) {
				alert(_this.getAttribute("tip"));
			}
			_this.value = "";
			return false;
		} else {
			return true;
		}
	}
	return false;
}

function checkInt(_this) {
	if(_this) {
		var value = _this.value.trim();
		if(!isInt(value)) {
			if(_this.getAttribute("tip")) {
				alert(_this.getAttribute("tip"));
			}
			_this.value = "";
			return false;
		} else {
			return true;
		}
	}
	return false;
}

// 获取屏幕像素
function getDPI() {
    var dpi = {};
    if (window.screen.deviceXDPI != undefined) {
    	dpi.px = window.screen.deviceXDPI;
    	dpi.py = window.screen.deviceYDPI;
    } else {
        var tmpNode = document.createElement("DIV");
        tmpNode.style.cssText = "width:1in;height:1in;position:absolute;left:0px;top:0px;z-index:99;visibility:hidden";
        document.body.appendChild(tmpNode);
        dpi.px = parseInt(tmpNode.offsetWidth);
        dpi.py = parseInt(tmpNode.offsetHeight);
        tmpNode.parentNode.removeChild(tmpNode);    
    }
    return dpi;
}

function getHashMap() {
	var hash = window.location.hash.replace("#", "");
	var params = {};
	if(hash) {
		var tempArray = hash.split("&");
		for(var i = 0; i < tempArray.length; i ++) {
			var temp = tempArray[i];
			if(temp) {
				var keyAndValue = temp.split("=");
				if(keyAndValue.length >= 2) {
					params[keyAndValue[0]] = keyAndValue[1];
				}
			}
		}
	}
	return params;
}

function isEmpty(str) {
	if(str == undefined || str == null || str == "") {
		return true;
	}
	return false;
}

function mm2px(value) {
	if(value) {
		value = parseFloat(value)*96*10/254;
	}
	return value;
}

function px2mm(value) {
	if(value) {
		value = parseFloat(width)*254/(96*10);
	}
	return value;
}

function setCaret(textObj) {
	if (textObj.createTextRange) {
		textObj.caretPos = document.selection.createRange().duplicate();
	}
}
function insertAtCaret(textObj, textFeildValue) {
	if (document.all) {
		if (textObj.createTextRange && textObj.caretPos) {
			var caretPos = textObj.caretPos;
			caretPos.text = caretPos.text.charAt(caretPos.text.length - 1) == '   ' ? textFeildValue
					+ '   '
					: textFeildValue;
		} else {
			textObj.value = textFeildValue;
		}
	} else {
		if (textObj.setSelectionRange) {
			var rangeStart = textObj.selectionStart;
			var rangeEnd = textObj.selectionEnd;
			var tempStr1 = textObj.value.substring(0, rangeStart);
			var tempStr2 = textObj.value.substring(rangeEnd);
			textObj.value = tempStr1 + textFeildValue + tempStr2;
		} else {
			textObj.value = textObj.value + textFeildValue;
		}
	}
}

// 图片预览
$.fn.preview = function(imgId) {
	if($(this).attr("type") != "file") {
		return false;
	}
	$(this).change(function(){
        var fileImg = $(imgId);
        var explorer = navigator.userAgent;
        var imgSrc = $(this)[0].value;
        if (explorer.indexOf('MSIE') >= 0) {
        	fileImg.attr("src",imgSrc);
        }else{
        	var file = $(this)[0].files[0];
            var url = URL.createObjectURL(file);
            fileImg.attr("src",url);
        }
    });
};

$.fn.closeModal = function(){
	$(this).find(".sui-close").trigger("click");
};

$.fn.setSelectVal = function (value, isTrigger) {
	var $target = $(this), 
		$container = $target.parents(".sui-dropdown, .sui-dropup"),
		$a = $container.find((value == undefined || value == null)? ".sui-dropdown-menu a:first" : "a[value='" + value + "']"),
		$li = $a.parent(),
		$menu = $container.find("[role='menu']"),
		toggleSelector = '[data-toggle=dropdown]';
	if ($li.is(".disabled, :disabled"))
		return;
	if ($container.is('.disabled, :disabled'))
		return;
	$target.val($a.attr("value") || "");
	if(isTrigger) {
		$target.val($a.attr("value") || "").trigger("change");
	} else {
		$target.val($a.attr("value") || "");
	}
	$container.find(toggleSelector + ' span').html($a.html());
	$menu.find(".active").removeClass("active");
	$li.addClass("active");
	return $target;
};
var loading;
function openTipModal(msg, status, closeCallback) {
	try {
		var now = new Date();
        speak(msg, function() {
            console.log("speak time:" + (new Date().getTime() - now.getTime()));
		});
	} catch (e) {
		console.log(e.message);
	}
    layer.close(loading);
    loading = layer.open({
        type: 1,
        title: false,
        closeBtn: 0,
        shadeClose: status === 2 ? true : false,
        skin: '',
        content: '<div class="layui-layer-tip layui-layer-danger">' + (status === 1 ? '<span class="tip-close-btn">×</span>' : '') + msg + '</div>'
    });
    $(".layui-layer-tip .tip-close-btn").click(function() {
    	layer.close(loading);
    	if(closeCallback) {
            closeCallback();
		}
	});
    if(status >= 500) {
        setTimeout(function() {
            layer.close(loading);
            if(closeCallback) {
                closeCallback();
            }
        }, status)
    }
}

function speak(msg, callback) {
    if(typeof(speakUtil) != "undefined") {
        playerUtil.setVolume(0).then(function() {
            speakUtil.speak(msg).then(function(){
                if(callback) {
                    callback();
                }
            });
        }).catch(function(error){
            openTipModal(JSON.stringify(error), 1000);
        });
    }
}

