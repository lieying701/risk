cola(function (model) {
	
	
	 var typeCooperations = []; // 第三方分类
		cola.ready(function () {
			// 获取第三方分类
			$.ajax({
	            url: "service/basecode/codeDetail/findCachedCodeDetails?baseCodeId=ThirdPartyType",
	            type: "GET",
	            contentType: "application/json",
	            success: function (data) {
	                $.each(data, function (index, obj) {
	                	typeCooperations.push({
	                        key: obj.kind,
	                        name: obj.name
	                    });
	                })
	                model.set("typeCooperations1", typeCooperations);
	            }
	        });
	    });
	model.set("assessmentContexts",[]);
		
   model.action({
	   thirdsTypeChange:function(){
		 var  thirdType = model.get("thirdType1");
		 if(thirdType == undefined){
			 return false;
		 }else{
			 //调用查询方法
			 model.action("assessmentQuery")();
		 }
	   },
	   assessmentEdit:function(assessmentContext){   //编辑   修改  更新
		   debugger;
		   model.set("feildName1","");
		   var evaInfoId = assessmentContext._data.evaInfoId;
		   var feildName = assessmentContext._data.feildName;
		   cola.widget("addEdit").show();
		   
           model.set("feildId",evaInfoId);
           model.set("feildName1",feildName);
	   },
	   assessmentHide:function(assessmentContext){   //  元素隐藏     显示“1”  隐藏“0”
		   debugger;
		   var infoId = assessmentContext._data.evaInfoId;
		   var displayFlag = assessmentContext._data.state;
		   $.ajax({
	              url: "thirdparty/controller/thirdEvaluate/processDisplayThirdEvaluateInfo?infoId="+infoId+"&displayFlag="+displayFlag,
	              type: "Get",
	              async: false,
	              success: function (data) {
	            	  debugger;
	            	  model.action("assessmentQuery")();
	              },
	              error:function(){
	            	  App.alert("隐藏失败！");
	              }
		   });
		   
		   
	   },
	   assessmentShow:function(assessmentContext){   //   元素展示
		   debugger;
		   var infoId = assessmentContext._data.evaInfoId;
		   var displayFlag = assessmentContext._data.state;
		   $.ajax({
	              url: "thirdparty/controller/thirdEvaluate/processDisplayThirdEvaluateInfo?infoId="+infoId+"&displayFlag="+displayFlag,
	              type: "Get",
	              async: false,
	              success: function (data) {
	            	  debugger;
	            	  model.action("assessmentQuery")();
	              },
	              error:function(){
	            	  App.alert("展示失败！");
	              }
		   });
		   
	   },
	   addFields:function(){
		   var thirdType = model.get("thirdType1");
		   if(thirdType == undefined || thirdType == ""){
			   cola.alert("请选择第三方分类");
			   return false;
		   }
		   cola.widget("addElement").show();
		   model.set("feildName","");//清空填写框
	   },
	   confirm:function(){   //确认添加
		   debugger;
		   var feildName = model.get("feildName");//要素名称
		   var thirdType = model.get("thirdType1");//第三方分类
		   var parameter = {
				   "feildName":feildName,
				   "thirdType":thirdType
		   }
		   $.ajax({
	              url: "thirdparty/controller/thirdEvaluate/insertThirdEvaluateInfoEO",
	              type: "POST",
	              contentType: "application/json",
	              async: false,
	              data: JSON.stringify(parameter),
	              success: function (data) {
	            	  debugger;
	            	  if(data.status == "500"){
	            		  App.alert("添加失败,失败原因:["+data.errorMsg+"]");
	            	  }
	            	  cola.widget("addElement").hide(); 
	            	  model.action("assessmentQuery")();
	              },
	              error:function(){
	            	  App.alert("添加失败");
	              }
		   });
		   
	   },
	   confirm1:function(){   //编辑确认
		   debugger;
		   var thirdType = model.get("thirdType1");//第三方分类
		   var feildName = model.get("feildName1");
		   var evaInfoId = model.get("feildId");
		   var state = "1";   //能编辑的状态都为 “1”
		   var parameter = {
				   "feildName":feildName,
				   "thirdType":thirdType,
				   "evaInfoId":evaInfoId,
				   "state":state
		   }
		   $.ajax({
	              url: "thirdparty/controller/thirdEvaluate/updateThirdEvaluateInfoEO",
	              type: "POST",
	              contentType: "application/json",
	              async: false,
	              data: JSON.stringify(parameter),
	              success: function (data) {
	            	  var data = data;
	            	  debugger;
	            	  model.action("assessmentQuery")();
	              }
		   });
		   
		   cola.widget("addEdit").hide();
		   
	   },
	   cancel:function(){
		   cola.widget("addElement").hide();
		   cola.widget("addEdit").hide();
	   },
	   assessmentQuery:function(){  //根据类型 查询
		   debugger;
		   
		   var thirdType = model.get("thirdType1");//第三方分类
		   if(thirdType == undefined || thirdType == ""){
			   cola.alert("请选择第三方分类");
			   return false;
		   }
		   var parameter = {
				   "thirdType":thirdType
		   }
		   $.ajax({
	              url: "thirdparty/controller/thirdEvaluate/findThirdEvaluateInfoByNoPage",
	              type: "POST",
	              contentType: "application/json",
	              async: false,
	              data: JSON.stringify(parameter),
	              success: function (data) {
	            	  debugger;
	            	  model.set("assessmentContexts",[]);
	            	  if(data.length>0){
	            		  for(var i=0;i<data.length;i++){
	            			  var feildName = data[i].feildName;
	            			  var state = data[i].state;
	            			  var evaInfoId = data[i].evaInfoId;
	            			  model.get("assessmentContexts").insert({
	    	        			  "feildName":feildName,
	    	        			  "state":state,
	    	        			  "evaInfoId":evaInfoId
	    	        		  });
		            	  } 
	            		  
	            	  }
	              }
		   });
		   App.setFieldVisible($(".showOrHideAdd"), true,false);
	   }
   });
});