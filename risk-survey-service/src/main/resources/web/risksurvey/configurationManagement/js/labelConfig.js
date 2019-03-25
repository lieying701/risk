cola(function (model) {
	model.set("labels",[]);
	model.set("modifyLabels",[]);
	
	
	model.set("labelContexts",[]);
//	model.set("labelContexts",[
//	  	 {"labelType":"黑名单",
//	  		 "labelValue":[
//	  			 {"labelName":"chang"},{"labelName":"wni"},{"labelName":"woni"}
//	  	     ]
//	  	 },
//	  	 {"labelType":"白名单"},
//	  	 {"labelType":"分类"},
//	  	 {"labelType":"技术类"},
//	  	 ]);
	
	
	model.set("attributionBusinesss1", []);
	
   model.action({
	   attributionBusinesssChange:function(){
		   var attributionBusiness = model.get("attributionBusiness1");
		   if(attributionBusiness == undefined){
			   return false;
		   }else{
			   //调用 查询方法
			   model.action("labelQuery")();
		   }
	   },
	   labelQuery:function(){   //查询
		   debugger;
		   var attributionBusiness = model.get("attributionBusiness1");
		   if(attributionBusiness == undefined){
			   cola.alert("请先选择归属业务条线");
			   return false;
		   }
		   var parament = {
				   "businessLine":attributionBusiness
		   }
		   $.ajax({
	              url: "thirdparty/controller/thirdLabelVariety/listByBusinseeLine",
	              type: "POST",
	              data: JSON.stringify(parament),
	              contentType: "application/json",
	              success: function (data) {
	            	  debugger;
	            	  var data = data;
	            	  var labelContexts = [];
	            	  for(var i=0;i<data.length;i++){
	            		  var labelType = data[i].labelVarietyName;
	            		  var labelValues = data[i].labelSet;
	            		  var labelVarietyId = data[i].labelVarietyId; 
	            		  var labelContext = {};
	            		  labelContext["labelVarietyId"]=labelVarietyId;
	            		  labelContext["labelType"]=labelType;
	            		  labelContext["labelValue"]=labelValues;
	            		  labelContexts.push(labelContext);
	            	  }
	            	  model.set("labelContexts",labelContexts);  
	            	  
//	            	  var labelContexts = [];
//	            	  for(var i=0;i<data.labelVarietyEOs.length;i++){
//	            		  var labelContext = {};
//	            		  var labelValues = [];
//	            		  var labelName = {};
//	            		  var labelType = data.labelVarietyEOs[i].labelVarietyName;
//	            		  
//	            		  for(var j=0;j<data.labelLists[i].length;j++){
//	            			  var label = data.labelLists[i][j].labelName;
//	            			  labelName["labelName"]=label;
//	            			  labelValues.push(labelName);
//	            		  }
//	            		  labelContext["labelType"]=labelType;
//	            		  labelContext["labelValue"]=labelValues;
//	            		  labelContexts.push(labelContext);
//	            	  }
//	            	  model.set("labelContexts",labelContexts);  
	              },
	              error:function(){
	            	  App.alert("查询失败");
	              }
	          })
	          App.setFieldVisible($(".addToSorH"), true,false);
		   
	   },
	  editLable:function(labelContext){    //修改标签
		  debugger;
		  cola.widget("addLabels").show();
		  model.set("modifylabelTtype",labelContext._data.labelType);
		  model.set("labelVarietyId",labelContext._data.labelVarietyId);
		  var modifyLabels = [];
		  for(var i =0;i<labelContext._data.labelValue._first.length;i++){
			  modifyLabels.push({text:labelContext._data.labelValue._first[i]._data.labelName,id:labelContext._data.labelValue._first[i]._data.labelId});
		  }
		  model.set("modifyLabels",modifyLabels);
	  },
	  addFieldss:function(){// 添加标签
		 model.get("labels").insert();
	  },
	  modifyAddLabels:function(modifyLabel){   // 修改添加
		  debugger;
		  model.get("modifyLabels").insert();
	  },
      delete:function(label){    // 删除分类
		  debugger;
		  label.remove();
 	  },
 	modifyDeleteLabel:function(modifyLabel){    //修改中删除标签
 		debugger;
 		var thridLabelId = modifyLabel._data.id;
 		if(thridLabelId == undefined || thridLabelId == ""){
 			modifyLabel.remove();
 		}else{
 			$.ajax({
 	            url: "thirdparty/controller/thirdLabelVariety/deleteThirdLabelById?id="+thridLabelId,
 	            type: "GET",
 	            contentType: "application/json",
 	            success: function (data) {
 	            	modifyLabel.remove();
 	            },
 	            error:function(){
 	            	App.alert("删除标签失败");
 	            }
 	        });
 		}
 	},
	  labelDel:function(){ // 删除标签
		  var labelId=123123;
		  var labelVarietyId = 123123;
		  var parament={
				  labelId:labelId,
				  labelName:labelName,
				  labelVarietyId:labelVarietyId
		  };
		  
		  $.ajax({
              url: "thirdparty/controller/ConfigManagementController/deleteLabel",
              type: "POST",
              data: JSON.stringify(parament),
              contentType: "application/json",
              success: function (data) {
                  App.alert("添加成功！");
              },
              error:function(){
            	  App.alert("删除失败");
              }
          })
	  },
	  addFields:function(labels){    //   最下面的添加
		  var attributionBusiness = model.get("attributionBusiness1");
		  if(attributionBusiness==undefined || attributionBusiness==""){
			  cola.alert("先选择业务归属条线");
			  return false;
		  }
		  cola.widget("addFields1").show();
		  model.set("labelType","");
//		  labels.remove();
	  },
	  deleteLabelType:function(labelContext){// 删除此分类
		debugger;
		var labelVarietyName = labelContext._data.labelType;
		var businessLine = model.get("attributionBusiness1");
		var labelVarietyId = labelContext._data.labelVarietyId;
		$.ajax({
            url: "thirdparty/controller/thirdLabelVariety/deleteThirdLabelVarie?id="+labelVarietyId,
            type: "GET",
            contentType: "application/json",
            success: function (data) {
            	labelContext.remove();
            },
            error:function(){
            	App.alert("删除失败");
            }
        });
	  },
	  cancel:function(){  // 取消
		  cola.widget("addFields1").hide();
		  model.set("labels",[]);
	  },
	  modifyCancel:function(){   // 修改取消
		  cola.widget("addLabels").hide();
		  model.action("labelQuery")();
	  },
	  confirm2:function(){ // 确定 添加标签
		  debugger;
		  if(model.get("labelType")=="" || model.get("labelType") == undefined ){
				 cola.alert("标签分类不能为空！");
				 return false;
		  } 
		  var businessLine = model.get("attributionBusiness1");//业务归属条线
		  var labelname = model.get("labels");       //  标签集合
		  var labelType = model.get("labelType");   //标签分类
		  var labelEOs = [];
		  for(var i=0;i<labelname.entityCount;i++){
			  var title = labelname._currentPage[i]._data.title;
			  var ThirdLabelEO = {};
			  ThirdLabelEO["labelName"] = title;
			  labelEOs.push(ThirdLabelEO);
		  }
		  var parameter = {
				  "labelVarietyName" : labelType,
				  "businessLine":businessLine,
				  "labelSet":labelEOs,
					}
//		  var parameter = {
//				  "labelVarietyEO" : {
//					    "labelVarietyName" : labelType,
//					    "businessLine":businessLine,
//					  },
//					  "labelEOs" : labelEOs
//					}
			 $.ajax({
				 url: "thirdparty/controller/thirdLabelVariety/insertLabelVarie",
				 type: "POST",
				 contentType: "application/json",
				 async: false,
				 data: JSON.stringify(parameter),
				 success: function (data) {
					 debugger;
					 var data = data;
					 model.get("labelContexts").insert({
						  "labelType":labelType,
						  "labelValue":labelEOs
					  });
					 cola.widget("addFields1").hide();
					 model.action("labelQuery")();
					 model.set("labels",[]);
				 },
				 error:function(){
				 App.alert("添加失败");
				 }
			 });
		  
// model.set("labelContexts",[
// {
// "labelType":labelType,
// }
// ])
//		  model.get("labelContexts").insert({
//			  "labelType":labelType,
//			  "labelValue":labelValue
//		  });
	  },
	  modifyConfirm:function(modifyLabel){   //修改标签点击确定
		  debugger;
		  var modifylabelTtype = model.get("modifylabelTtype");
		  var modifyLabels = model.get("modifyLabels");
		  var labelVarietyId = model.get("labelVarietyId");
		  var businessLine = model.get("attributionBusiness1");
		  var labelSet = [];
		  for(var i=0;i<modifyLabels._currentPage.length;i++){
			  var ThirdLabelEO = {};
			  if(modifyLabels._currentPage[i].state == "DELETED"){
				  continue;
			  }
			  if(modifyLabels._currentPage[i].state == "NONE"){
				  continue;
			  }
			  if(modifyLabels._currentPage[i].state == "MODIFIED"){
				  
				  var labelName = modifyLabels._currentPage[i]._data.text;
				  var labelId = modifyLabels._currentPage[i]._data.id;
				  ThirdLabelEO["labelName"]=labelName;
				  ThirdLabelEO["labelId"]=labelId;
				  labelSet.push(ThirdLabelEO);
			  }
              if(modifyLabels._currentPage[i].state == "NEW"){
            	  var labelName = modifyLabels._currentPage[i]._data.text;
            	  ThirdLabelEO["labelName"]=labelName;
            	  labelSet.push(ThirdLabelEO);
			  }
		  }
		  var parameter = {
				  "businessLine":businessLine,
				"labelVarietyId":labelVarietyId, 
				"labelVarietyName":modifylabelTtype,
				"labelSet":labelSet
		  }
		  $.ajax({
				 url: "thirdparty/controller/thirdLabelVariety/updateThirdLabelVarie",
				 type: "POST",
				 contentType: "application/json",
				 async: false,
				 data: JSON.stringify(parameter),
				 success: function (data) {
					 debugger;
//					 var data = data;
//					 model.get("labelContexts").insert({
//						  "labelType":labelType,
//						  "labelValue":labelEOs
//					  });
					 cola.widget("addLabels").hide();
					 model.action("labelQuery")();
				 },
				 error:function(){
				 App.alert("修改标签失败");
				 }
			 });
		  
	  }
   });

   var businessLines = [];
	cola.ready(function() {
		$.ajax({
			url:"service/basecode/codeDetail/findCachedCodeDetails?baseCodeId=DepartmentCode",
			type:'GET',
			contentType:'application/json',
			success:function(data){
				$.each(data, function(index, obj) {
					businessLines.push({
						key : obj.kind,
						name : obj.name
					});
				})
				model.set("attributionBusinesss1", businessLines);
			}
		});
	});
});