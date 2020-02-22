/**初始化页面*/
//获取浏览器信息
		var winWidth = $(window).width();
		var winHeight = $(window).height(); 
		
//表格序号动态添加
	
		function addTr(){
			var len = $('tbody tr').length;
				for(var i = 0;i<len;i++){
					$('tbody tr:eq('+i+') td:first').text(parseInt(i)+1);
				}
			}
			
		
		
		
//页面是否显示
		
		function isShow(){
			$(".small-check").each(function () {
                if ($(this).is(":checked")) 
                {
                    $(this).attr("show","true");
                }else{
                	$(this).attr("show","false");
                }
            });
		}
		isShow();
		$(".small-check").click(function(){
				isShow();
		});

//上移
		var otableBody = $("#storesku_tabletow tbody");
		$(document).on("click",".upbtn",function(){
			var tr = $(this).parent().parent();
			var trPrev = tr.prev();
			if(trPrev){
					tr.insertBefore(trPrev);
			}
			addTr();
		});

//下移
        $(document).on("click",".downbtn",function(){
			var tr = $(this).parent().parent();
			var trNext = tr.next();
			if(trNext){
					tr.insertAfter(trNext);
			}
			addTr();
		});
        var keys = "";
        function getKey(obj){
        	 var e = event || window.event;
        	 var keyCode = e.keyCode || e.which;
        	 var nowIndex = $(obj).attr("index");
        	 $('#storesku_tabletow tbody tr').each(function(){
  				var keychose = $(this).find("td").eq(6).find("input").attr("keyCode");
  				var index = $(this).find("td").eq(6).find("input").attr("index");
  				if(nowIndex !=index){
  					if(keys==""){
  						keys =keychose;
  					}else{
  						keys +=","+keychose
  					}
  				}
  			});
        	 if(keys.indexOf(keyCode) !=-1 && keyCode !=8){
        		 $(obj).val("");
        		 $(obj).attr("keyCode","");
        		 layerMsg("亲，快捷键已存在！",6);
        		 return;
        	 }
        	 keys = "";
    		 $(obj).val("");
    		 $(obj).attr("keyCode",keyCode);
        }
		
        function checkKey(obj){
        	 var e = event || window.event;
        	 var keyCode = e.keyCode || e.which;
        	 if((keyCode<65 || keyCode>90) && keyCode !=8){
        		 $(obj).val("");
        		 $(obj).attr("keyCode","");
        		 layerMsg("请使用a~z的快捷键！",6);
        		 return;
        	 }
        	 var nowIndex = $(obj).attr("index");
        	 $('#storesku_tabletow tbody tr').each(function(){
  				var keychose = $(this).find("td").eq(6).find("input").attr("keyCode");
  				var index = $(this).find("td").eq(6).find("input").attr("index");
  				if(nowIndex !=index){
  					if(keys==""){
  						keys =keychose;
  					}else{
  						keys +=","+keychose
  					}
  				}
  			});
        	 if(keys.indexOf(keyCode) !=-1){
        		 $(obj).val("");
        		 $(obj).attr("keyCode","");

        	 }
        }
        
//售票列表的数据
	    function oTableData(){
	    	var order = "";
	    	var productchose = "";
	    	//var keychoses = "";
	    	//var keys = "";
	    	var flag = true;
			$('#storesku_tabletow tbody tr').each(function(){
				var productNo = $(this).find("td").eq(2).text();
				var oproductchose = $(this).find("td").eq(5).find("input").attr("show");
				var keychose = $(this).find("td").eq(6).find("input").attr("keyCode");
				var keyValue = $(this).find("td").eq(6).find("input").val();
				if(order==""){
					order =productNo;
				}else{
					order +=","+productNo
				}
				if(oproductchose=='true'){
					if(productchose==""){
						productchose =productNo;
					}else{
						productchose +=","+productNo
					}
				}
				/*if(keys.indexOf(keychose) !=-1 && keychose !=""){
					flag = false;
				}
				if(keys==""){
					keys =keychose;
				}else{
					keys +=","+keychose
				}
				if(keychose !=""){
					if(keychoses==""){
						keychoses = productNo+":"+keychose+":"+keyValue;
					}else{
						keychoses +=";"+productNo+":"+keychose+":"+keyValue;
					}
				}*/
			});
			var json = {
					"order": order,
					"productchose": productchose,
					"DISTRIBUTION_NO":$("#DISTRIBUTION_NO").val()
					//"keychoses": keychoses
			};
			if(!flag){
				return "";
			}else{
				return json;
			}
		}
		
		$(".submitbtn").click(function(){
			var json = oTableData();
			/*if(json==""){
				layerMsg("快捷键重复！",6);
				return;
			}*/
			$.ajax({
		        url:"cooperation/distribution/configProduct",
		        type:'post',
		        data:json,
		        dataType:'json',
		        success: function(data){
		            if("SUCCESS" == data.return_code){
		            	layerMsg("操作成功！",6);
		            }else{
		            	layerMsg(data.return_msg,6);
		            }
		        }
		    });
		});
		
      
