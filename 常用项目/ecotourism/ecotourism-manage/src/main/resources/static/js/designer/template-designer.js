var m = false;
var resize_s = false;
var resize_e = false;
var resize_se = false;
var _x = 0;
var _y = 0;
var fieldMinWidth = 50;
var fieldMinHeight = 20;
var actionField;
var selectedField;
var keydownEvent;
var keydowning = false;
var keydownMoving = false;
var leftCode = 37;
var upCode = 38;
var rightCode = 39;
var downCode = 40;
$(function() {
	$(window).keyup(function(event) {
		keydowning = false;
		var yMove = 0;
		var xMove = 0;
		if(!keydownMoving) {
			if(actionField) {
				if(event.keyCode == leftCode) {
					xMove = -1;
				}
				if(event.keyCode == rightCode) {
					xMove = 1;
				}
				if(event.keyCode == upCode) {
					yMove = -1;
				}
				if(event.keyCode == downCode) {
					yMove = 1;
				}
				var x = parseInt(actionField.css("left")) + xMove;
				var y = parseInt(actionField.css("top")) + yMove;
				actionField.css("left", x + "px");
				actionField.css("top", y + "px")
			}
		}
	}).keydown(function(event) {
		keydownEvent = event;
		if(actionField) {
			keydowning = true;
			setTimeout(function() {
				if(keydowning) {
					keydownMoving = true;
					var keydownHandler = setInterval(function() {
						var yMove = 0;
						var xMove = 0;
						if(keydownEvent.keyCode == leftCode) {
							xMove = -1;
						}
						if(keydownEvent.keyCode == rightCode) {
							xMove = 1;
						}
						if(keydownEvent.keyCode == upCode) {
							yMove = -1;
						}
						if(keydownEvent.keyCode == downCode) {
							yMove = 1;
						}
						var x = parseInt(actionField.css("left")) + xMove;
						var y = parseInt(actionField.css("top")) + yMove;
						
						if(x < 0) {
							x = 0;
						}
						if(x + actionField.width() > actionField.parent().width() - 2) {
							x = actionField.parent().width() - actionField.width() - 2;
						}
						if(y < 0) {
							y = 0;
						}
						if(y + actionField.height() > actionField.parent().height() - 2) {
							y = actionField.parent().height() - actionField.height() - 2;
						}
						actionField.css("left", x + "px");
						actionField.css("top", y + "px");
						if(!keydowning) {
							clearInterval(keydownHandler);
							keydownMoving = false;
						}
					}, 100);
				}
			}, 1000)
		}
	});
	if($("#express_template").size() > 0) {
		initField();
		initExpressTemplateColumnEvent();
		$("#express_template").click(function() {
			$(".field").css("background", "#FFFFFF");
			$(".express-template-column").prop("checked", false);
			selectedField = null;
		});
		var left = $("#express_template").offset().left + $("#express_template").width() + 10;
		$("#designer_toolcontainer_print_items").css("left", left).show();
	    $(".print_item").hover(function() {
	    	$(this).addClass("print_item_hover");
	    }, function() {
	    	$(this).removeClass("print_item_hover");
	    });
	    $("#btn_toggle_print_items").click(function() {
	    	if($("#designer_print_items").css("display") == "none") {
	    		$(this).removeClass("btn-white-mini-more").html("收起");
	    		$("#designer_print_items").show();
	    	} else {
	    		$(this).addClass("btn-white-mini-more").html("展开");
	    		$("#designer_print_items").hide();
	    	}
	    });
	}
}).mousemove(function(e) {
	if(m) {
		var x=e.pageX-_x;
		var y=e.pageY-_y;
		if (actionField) {
			actionField.css("opacity", "0.5");
			actionField.css("filter", "Alpha(Opacity=50)");
			if(x < 0) {
				x = 0;
			}
			if(x + actionField.width() > actionField.parent().width() - 2) {
				x = actionField.parent().width() - actionField.width() - 2;
			}
			if(y < 0) {
				y = 0;
			}
			if(y + actionField.height() > actionField.parent().height() - 2) {
				y = actionField.parent().height() - actionField.height() - 2;
			}
			actionField.css({left:x});
			actionField.css({top:y});
		}
	} else if(resize_se) {
		if (actionField) {
			actionField.css("opacity", "0.5");
			actionField.css("filter", "Alpha(Opacity=50)");
			var x=e.pageX - _x;
			var y=e.pageY - _y;
			if(x < fieldMinWidth) {
				x = fieldMinWidth;
			}
			if(x + parseInt(actionField.css('left')) > actionField.parent().width() - 2) {
				x = actionField.parent().width() - parseInt(actionField.css('left')) - 2;
			}
			if(y < fieldMinHeight) {
				y = fieldMinHeight;
			}
			if(y + parseInt(actionField.css('top')) > actionField.parent().height()- 2 ) {
				y = actionField.parent().height()-  parseInt(actionField.css('top')) - 2;
			}
			actionField.css({width:x});
			actionField.css({height:y});
		}
	} else if(resize_e) {
		if (actionField) {
			actionField.css("opacity", "0.5");
			actionField.css("filter", "Alpha(Opacity=50)");
			var x = e.pageX - _x;
			if(x < fieldMinWidth) {
				x = fieldMinWidth;
			}
			if(x + parseInt(actionField.css('left')) > actionField.parent().width() - 2) {
				x = actionField.parent().width() - parseInt(actionField.css('left')) - 2;
			}
			actionField.css({width:x});
		}
	} else if(resize_s) {
		if (actionField) {
			actionField.css("opacity", "0.5");
			actionField.css("filter", "Alpha(Opacity=50)");
			var y=e.pageY - _y;
			if(y < fieldMinHeight) {
				y = fieldMinHeight;
			}
			if(y + parseInt(actionField.css('top')) > actionField.parent().height()- 2 ) {
				y = actionField.parent().height() -  parseInt(actionField.css('top')) - 2;
			}
			actionField.css({height:y});
		}
    }
}).mouseup(function(){
	m = false;
	resize_s = false;
	resize_e = false;
	resize_se = false;
	if(actionField) {
		actionField.css("opacity", "1");
		actionField.css("filter", "Alpha(Opacity=100)");
	}
});

function initField() {
	var template = $("#express_template");
	template.on("mousedown", ".field", function(e){
		if(e.which){
			m=true;
			_x=e.pageX-parseInt($(this).css('left'));
			_y=e.pageY-parseInt($(this).css('top'));
			actionField = $(this);
			selectedField = $(this);
			selectExpressTemplateColumnEvent();
			$(".field").css("background", "#FFFFFF");
			actionField.css("background", "#FFF500");
		}
		return false;
	});
	
	template.on("click", ".field", function() {
		return false;
	});
	
	template.on("mousedown", ".resize-handle-s", function(e){
		if(e.which){
			resize_s = true;
			actionField = $(this).parent();
			_y=e.pageY - actionField.height();
		}
		return false;
	});

	template.on("mousedown", ".resize-handle-e", function(e){
		if(e.which){
			resize_e = true;
			actionField = $(this).parent();
			_x=e.pageX - actionField.width();
		}
		return false;
	});

	template.on("mousedown", ".resize-handle-se", function(e){
		if(e.which){
			resize_se = true;
			actionField = $(this).parent();
			_x=e.pageX - actionField.width();
			_y=e.pageY - actionField.height();
		}
		return false;
	});
	
	template.on("click", ".handle-close", function() {
		$(this).parent().remove();
		$(".express-template-column").prop("checked", false);
		var code = $(this).parent().find("[name='code']").val();
		$("#checkbox_" + code).checkbox().checkbox("uncheck");
		selectedField = null;
		return false;
	});	
}

function selectExpressTemplateColumnEvent() {
/*	$(".express-template-column").prop("checked", false);
	if (selectedField.children("input").val() != "") {
		var array = selectedField.children("input").val().split("|");
		for(var i = 0; i < array.length; i ++) {
			$("#" + array[i]).prop("checked", true);
		}
	}*/
}

function initExpressTemplateColumnEvent() {
	$(".express-template-column").change(function() {
		var curSelectedField;
		if(selectedField) {
			curSelectedField = selectedField;
		} else {
			if($(this).prop("checked")) {
				$(".express-template-column").prop("checked", false);
				$(this).prop("checked",true);
				curSelectedField = addField();
			} else {
				return;
			}
		}
		var valueObj = curSelectedField.children("input");
		var filedNameObj = curSelectedField.children(".field-name");
		var valueArray;
		var nameArray;
		if (valueObj.val() != "") {
			valueArray = valueObj.val().split("|");
			nameArray = filedNameObj.html().split("\\");
		} else {
			valueArray = [];
			nameArray = [];
		}
		if($(this).prop("checked")) {
			valueArray.push($(this).val());
			nameArray.push($(this).next().html());
		} else {
			valueArray.removeValue($(this).val());
			nameArray.removeValue($(this).next().html());
		}
		valueObj.val(valueArray.join("|"));
		filedNameObj.html(nameArray.join("\\"));
	});
}

function addPrintItem(arg1, arg2, arg3, arg4, fieldColumn, columnName) {
	var field = $(".field-fb").clone();
	field.appendTo("#express_template");
	field.attr("class", "field").show();
	var valueObj = field.children("input");
	var filedNameObj = field.children(".field-name");
	filedNameObj.html(columnName);
	valueObj.val(fieldColumn);
	initField(field);
}

function addPrintItem4CustomText(arg1, arg2, arg3, arg4, fieldColumn, columnName, isNew) {
	var content = '';
	if (isNew == false) {
		content = selectedField.find(".field-name").html();
	}
	$.webox({
		height:82,
		width:350,
		bgvisibel:true,
		title:'自定义文字',
		html:'<div style="padding:10px;"><span class="nui-input-label">自定义文字内容：</span><input class="nui-input" value="' + content + '" id="customTextContent" /></div>',
		top: true,
	    button: [{
	    		name:"取消",key:"cancel"
	    	},
	        {
			name:"确定",
	    	key:"ok",
	    	event:function() {
	    		var content = $("#customTextContent").val().trim();
		    	if(content) {
		    		if (isNew == false) {
		    			selectedField.find(".field-name").html(content);
		    		} else {
		    			addPrintItem(arg1, arg2, arg3, arg4, fieldColumn, content);
		    		}
		    	} else {
		    		$("#customTextContent").focus();
		    		alert("请输入自定义文字内容");
		    		return false;
		    	}
			}
		}]
	});
}

function addField() {
	var field = $(".field-fb").clone();
	field.appendTo("#express_template");
	field.attr("class", "field").show();
	initField();
	return field;
}

function saveField() {
	fieldToJSON();
	document.form.submit();
}

function fieldToJSON() {
	var array = [];
	$(".field").each(function(){
		var field = {};
		field.code = $(this).children("input").val();
		field.height = $(this).height();
		field.width = $(this).width();
		field.top = parseInt($(this).css("top"));
		field.left = parseInt($(this).css("left"));
		var style = $(this).find(".field-name").attr("style");
		var html = $(this).find(".field-name").html();
		field.style = style ? style : '';
		field.text = html ? html : '';
		array.push(field);
	});
	var jsonString = JSON.stringify(array);
	return jsonString;
}

function getRealRate(templateWith, templateHeight, showWidth, showHeight) {
	var dpi = getDPI();
	var templateWithPx = templateWith * dpi.px * 10 /254;
	var templateHeightPx = templateHeight * dpi.py * 10 /254;
	
	var rate = {};
	rate.rx = templateWithPx / showWidth;
	rate.ry = templateHeightPx / showHeight;
	return rate;
}

//模板另存为
function saveAs(action) {
	var newTemplateName = "";
	if($("#logisticsCompanys").size() > 0) {
		newTemplateName = $("#logisticsCompanys").children(":selected").html();
	} else if($("#templateName").size() > 0) {
		newTemplateName = $("#templateName").val();
	}
	$.webox({
		height:100,
		width:300,
		bgvisibel:true,
		title:'另存为新模板',
		html:"<div style='padding:10px 0;'><span class='nui-input-label'>新模版名称：</span><input id='new_template_name' class='nui-input' type='text' value='" + newTemplateName + "'></div>",
		top: true,
		button: [{
			name:"取消",key:"cancel"
			},
			{
			name:"确定",
			key:"ok",
			event:function() {
				var form = $("form[name='form']");
				form.attr("action", action);
				if(!$("#new_template_name").val().trim()) {
					alert("请填写模板名称");
					return false;
				}
				form.find("#templateName").val($("#new_template_name").val());
				fieldToJSON();
				form.submit();
			}
		}]
	});
}

/**
 * 方法:Array.remove(dx) 功能:根据元素值删除数组元素. 参数:元素值 返回:在原数组上修改数组
 */  
Array.prototype.indexOf = function (val) {  
   for (var i = 0; i < this.length; i++) {  
        if (this[i] == val) {
            return i;  
        }  
    }  
    return -1;  
}; 

Array.prototype.removeValue = function (val) {  
    var index = this.indexOf(val);  
    if (index > -1) {  
        this.splice(index, 1);  
    }  
};  

/**
 * 方法:Array.remove(dx) 功能:根据元素位置值删除数组元素. 参数:元素值 返回:在原数组上修改数组
 */  
Array.prototype.remove = function (dx) {  
    if (isNaN(dx) || dx > this.length) {  
        return false;  
    }  
    for (var i = 0, n = 0; i < this.length; i++) {  
        if (this[i] != this[dx]) {  
            this[n++] = this[i];  
        }  
    }  
    this.length -= 1;  
};
function modifyPic(title,id) {
	$.webox({
		height:400,
		width:600,
		bgvisibel:true,
		title:'修改快递模板底图',
		iframe:"user/LogisticsAction!modifyExpressTemplatePic.action?companyCode=" + "${expressTemplate.logisticsCompany.code}",
		top: true,
	    button: [{
	    	name:"取消",key:"cancel"
	    	},
	        {
			name:"确定",
	    	key:"ok",
		    call:function(retData) {
		    	 if(retData.fid) {
		    		 $("#background").attr("src", "user/ImageAction!templateBackground.action?filename=" + retData.fid);
		    		 $("#fid").val(retData.fid);
		    		 $("#tempFileId").val("");
		    	 } else if(retData.tempFid) {
			    	 $("#background").attr("src", "user/ImageAction!tempImage.action?filename=" + retData.tempFid);
			    	 $("#tempFileId").val(retData.tempFid);
			    	 $("#fid").val("");
				 }
			}
		}]
	});
}

$(function() {
	$("#template_width").change(function() {
		if(!$(this).isFloat()) {
			$(this).val("");
		} else {
			var value = $.trim($(this).val());
			if(value) {
				var width = parseInt(value);
				$(this).val(width);
				$("#expressTemplate_width").val(width);
				$("#express_template").css("width", width + "mm");
				$("#background").css("width", width + "mm");
			}
		}
	});
	$("#template_height").change(function() {
		if(!$(this).isFloat()) {
			$(this).val("");
		} else {
			var value = $.trim($(this).val());
			if(value) {
				var height = parseInt(value);
				$(this).val(height);
				$("#expressTemplate_height").val(height);
				$("#express_template").css("height", height + "mm");
				$("#background").css("height", height + "mm");
			}
		}
	});
	/*$("#template_fixLeft").change(function() {
		if(!$(this).isFloat()) {
			$(this).val("");
		} else {
			var value = $.trim($(this).val());
			if(value) {
				var fixLeft = parseInt(value);
				$(this).val(fixLeft);
				$("#expressTemplate_fixLeft").val(fixLeft);
			}
		}
	});
	$("#template_fixTop").change(function() {
		if(!$(this).isFloat()) {
			$(this).val("");
		} else {
			var value = $.trim($(this).val());
			if(value) {
				var fixTop = parseInt(value);
				$(this).val(fixTop);
				$("#expressTemplate_fixTop").val(fixTop);
			}
		}
	});*/
	$("#logisticsCompanys").change(function() {
		var companyName = $(this).children(":selected").html();
		$("#templateName").val(companyName);
	});
	if ($.trim($("#templateName").val()) == "") {
		$("#logisticsCompanys").trigger("change");
	}
});
function deleteTemplate(id) {
	if(confirm("确定要删除该快递模板？")) {
		document.location = "user/LogisticsAction!deleteExpressTemplate.action?idx=" + id;
	}
}
$(function() {
	// 显示隐藏调色板
	$(".editor-arrow,.editor-forecolor-btn").click(function() {
		if ($(".edui-for-forecolor").css("display") == "none") {
			$(".edui-popup").hide();
			var btn = $(this).parent().find(".editor-forecolor-btn");
			$(".edui-for-forecolor").css("left", btn.offset().left);
			$(".edui-for-forecolor").css("top", btn.offset().top + btn.height() + 2);
			$(".edui-for-forecolor").show();
		} else {
			$(".edui-for-forecolor").hide();
		}
	});
	// 选择颜色
	$(".edui-colorpicker-colorcell").click(function() {
		var dataColor = $(this).attr("data-color");
		$(".editor-colorlump").css("background", dataColor);
		if(selectedField) {
			selectedField.find(".field-name").css("color", dataColor);
		}
		$(".edui-for-forecolor").hide();
	}).mouseover(function() {
		var dataColor = $(this).attr("data-color");
		$(".edui-colorpicker-preview").css("background", dataColor);
	});
	$(".edui-colorpicker-nocolor").click(function() {
		$(".edui-colorpicker-preview").css("background", "");
	});
	// 字体加粗
	$(".editor-for-bold").click(function() {
		if(selectedField) {
			if(selectedField.find(".field-name").css("font-weight") < 800) {
				selectedField.find(".field-name").css("font-weight", 800);
			} else {
				selectedField.find(".field-name").css("font-weight", 400);
			}
		}
	});
	// 斜体
	$(".editor-for-italic").click(function() {
		if(selectedField) {
			if(selectedField.find(".field-name").css("font-style") == "italic") {
				selectedField.find(".field-name").css("font-style", "normal");
			} else {
				selectedField.find(".field-name").css("font-style", "italic");
			}
		}
	});
	// 下划线
	$(".editor-for-underline").click(function() {
		if(selectedField) {
			if(selectedField.find(".field-name").css("text-decoration").indexOf("none") != -1) {
				selectedField.find(".field-name").css("text-decoration", "underline");
			} else {
				selectedField.find(".field-name").css("text-decoration", "none");
			}
		}
	});
	
	// 字体居左
	$(".editor-for-justifyleft").click(function() {
		if (selectedField) {
			selectedField.find(".field-name").css("text-align", "left");
		}
	});
	
	// 字体居中
	$(".editor-for-justifycenter").click(function() {
		if (selectedField) {
			selectedField.find(".field-name").css("text-align", "center");
		}
	});
	
	// 字体居右
	$(".editor-for-justifyright").click(function() {
		if (selectedField) {
			selectedField.find(".field-name").css("text-align", "right");
		}
	});
	
	// 两端对齐
	$(".editor-for-justifyjustify").click(function() {
		if (selectedField) {
			selectedField.find(".field-name").css("text-align", "justify");
		}
	});
	// 显示字体
	$(".editor-for-fontfamily").click(function() {
		if($(".edui-for-fontfamily").css("display") == "none") {
			$(".edui-popup").hide();
			$(".edui-for-fontfamily").css("left", $(this).offset().left).css("top", $(this).offset().top + $(this).height() + 2);
			$(".edui-for-fontfamily").show();
		} else {
			$(".edui-for-fontfamily").hide();
		}
	});
	// 显示字体大小
	$(".editor-for-fontsize").click(function() {
		if($(".edui-for-fontsize").css("display") == "none") {
			$(".edui-popup").hide();
			$(".edui-for-fontsize").css("left", $(this).offset().left).css("top", $(this).offset().top + $(this).height() + 2);
			$(".edui-for-fontsize").show();
		} else {
			$(".edui-for-fontsize").hide();
		}
	});
	// 选择字体
	$(".edui-for-fontfamily .edui-listitem-label").click(function() {
		if (selectedField) {
			selectedField.find(".field-name").css("font-family", $(this).css("font-family"));
		}
		$(".edui-for-fontfamily").hide();
	});
	// 选择字体大小
	$(".edui-for-fontsize .edui-listitem-label").click(function() {
		if (selectedField) {
			var fontSize = $(this).html();
			selectedField.find(".field-name").css("font-size", fontSize);
			if (parseInt(fontSize) < 23) {
				selectedField.find(".field-name").css("line-height", "23px");
			} else {
				selectedField.find(".field-name").css("line-height", fontSize);
			}
		}
		$(".edui-for-fontsize").hide();
	});
	// 自定义字体大小
	$(".edui-for-fontsize .custom-font-size-btn").click(function() {
		if (selectedField) {
			var fontSize = $(this).parent().find("[name='customFontSize']").val().trim();
			if(!fontSize) {
				layer.alert("请填写字体大小");
				return;
			}
			fontSize = parseFloat(fontSize) + "px";
			selectedField.find(".field-name").css("font-size", fontSize);
			if (parseInt(fontSize) < 23) {
				selectedField.find(".field-name").css("line-height", "23px");
			} else {
				selectedField.find(".field-name").css("line-height", fontSize);
			}
		}
		$(".edui-for-fontsize").hide();
	});
	// 点击其他地方，隐藏弹出框
	$(document).bind("click", function(e) {
		var target = $(e.target);
		if (target.closest(".edui-popup").length == 0 
				&& target.closest(".editor-for-fontsize").length == 0
				&& target.closest(".editor-for-fontfamily").length == 0
				&& target.closest(".editor-for-forecolor").length == 0) {
			$(".edui-popup").hide();
		}
	});
});
// 删除印项目
function deleteSelectedItem() {
	if(selectedField) {
		selectedField.remove();
	}
}
// 默认布局
function defaultLayout() {
	var companyCode = $("#logisticsCompanys").val();
	$.post("user/LogisticsAction!getDefaultLayout.action", {companyCode : companyCode}, function(template) {
		if(template) {
			$("#template_width,#expressTemplate_width").val(template.width).trigger("change");
			$("#template_height,#expressTemplate_height").val(template.height).trigger("change");
			$("#template_fixLeft,#expressTemplate_fixLeft").val(template.fixLeft);
			$("#template_fixTop,#expressTemplate_fixTop").val(template.fixTop);
			if (template.fieldList) {
				var fields = [];
				for(var i = 0; i < template.fieldList.length; i ++) {
					var fieldData = template.fieldList[i];
					var fieldObj = $(".field-fb").clone();
					fieldObj.attr("class", "field");
					fieldObj.css("left", fieldData.left).css("top", fieldData.top);
					fieldObj.css("width", fieldData.width).css("height", fieldData.height);
					fieldObj.find(".field-name").attr("style", fieldData.style ? fieldData.style : "").html(fieldData.showText);
					fieldObj.find(".field-column").val(fieldData.showColumn);
					fields.push(fieldObj);
				}
				$("#express_template .field").remove();
				for(var i = 0; i < fields.length; i ++) {
					$("#express_template").append(fields[i]);
				}
				initField();
			}
		}
	}, "json");
}
//修改偏移量
$(function() {
	$(".arrow").click(function() {
		var className = $(this).attr("class");
		if (className.indexOf("arrow-up") != -1) {
			var value = $("#template_fixTop").val();
			$("#template_fixTop").val(parseInt(value ? value : '0') - 1);
		} else if(className.indexOf("arrow-down") != -1) {
			var value = $("#template_fixTop").val();
			$("#template_fixTop").val(parseInt(value ? value : '0') + 1);
		} else if(className.indexOf("arrow-left") != -1) {
			var value = $("#template_fixLeft").val();
			$("#template_fixLeft").val(parseInt(value ? value : '0') - 1);
		} else if(className.indexOf("arrow-right") != -1) {
			var value = $("#template_fixLeft").val();
			$("#template_fixLeft").val(parseInt(value ? value : '0') + 1);
		}
	});
});
function editSelectedItem() {
	if (selectedField) {
		var column = selectedField.find(".field-column").val();
		if (column == "custom_text") {
			addPrintItem4CustomText(0, 0, 0, 0, "", "", false); 
		} else  {
			alert("该打印项目不能编辑，由系统自动填充");
		}
	} else {
		alert("请选择一个需要编辑的打印项目");
	}
}

$(function() {
	$("#field-content-nav li").click(function() {
		$(this).parent().find(".active").removeClass("active");
		$(this).addClass("active");
		$(".field-content").hide();
		$("#" + $(this).attr("for")).show();
	});
});
