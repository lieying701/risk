cola(function(model){
	model.set("taskNum", "20181023");
	var applicantArr = [];
	var insurantArr = [];
	var surveyId = cola.util.queryParams().surveyId;
	model.set("surveyId", surveyId);
	
	model.describe("getData", {
        provider: {
            url: "./risksurvey/data/risksurvey.json",
            response:function(self,arg){
            	model.set("fieldsObj", JSON.parse(arg.result));
            },
            async: false
        }
    });
	
    model.action({
        
        
		
		submitReport: function(){
			getDataFromFile();
			var surveyObj = {};
			//get all fields from json file
			var fieldsObj = model.get("fieldsObj").current._data; 
			//loop vo
			for(var vo in fieldsObj){
				//get all vo fields
				var obj = fieldsObj[vo]; 
				var eoObj = {};
				var customerArr = [];
				//var basicArr = [];
				// loop eo.get all eo fields 
				for (var eo in obj){
					//according to eo field. get specified subview.
					var fields = obj[eo];
					var eoName;
					var eoType;
					if (fields.indexOf(",") != -1){
						eoName = fields.split(",")[0];
						eoType = fields.split(",")[1];
					}
					
					var subview = cola.widget(eoName);
					if(subview != null ){
						var modelName = subview.get("contentModel");
						var currentModel = modelName.get(eoName);
						if (currentModel != undefined){
							if (currentModel.entityCount > 1){
								var arr = [];
								currentModel.each(function(subModel){
									if (JSON.stringify(subModel._data) != "{}"){
										var subviewDataObj = subModel._data;
										for (var key in subviewDataObj){
											if (key == "0"){
												delete subviewDataObj[key];
											}
										}
									    arr.push(subviewDataObj);
									}
								});
								if (arr.length > 0){
									if (eoName == "plcApplicant" || eoName == "plcInsurant"){
										eoObj["surveyCustomer"] = arr; // 投保人和被保人在同一个subview 里面，需要特殊处理
									}
//									else if(fields == "riskPolicy" || fields == "plcRiskEvaluate"){
//										eoObj["surveyBasic"] = arr; 
//									}
									else{
										eoObj[eoName] = arr;
									}
								}
							}else{
								var getData = currentModel._data == undefined ? currentModel.current._data : currentModel._data;
								var arr = [];
								if (JSON.stringify(getData) != "{}"){
									if (eoName == "plcApplicant" || eoName == "plcInsurant"){
										customerArr.push(getData);// 投保人和被保人在同一个subview 里面，需要特殊处理
									}else if(eoName == "riskPolicy"){  // || fields == "plcRiskEvaluate"
										//basicArr.push(getData);
										if (eoType == "single"){
											eoObj["surveyBasic"] = getData;
										}else{
											 arr.push(getData);
											 eoObj[eoName] = arr;
										}
									}else{
										if (eoType == "single"){
											//eoObj["surveyBasic"] = getData;
											eoObj[eoName] = getData;
										}else{
											 arr.push(getData);
											 eoObj[eoName] = arr;
										}
									}
								}
							}
						}
					}
				}	
				if (vo == "originatingTaskCommitVo" && customerArr.length > 0 ){
					eoObj["surveyCustomer"] = customerArr;
				}
				/*if (vo == "riskSurveyVo" && basicArr.length > 0){
					eoObj["surveyBasic"] = basicArr;
				}*/
				//console.log("eoObj is :", $.isEmptyObject(eoObj));
				if (JSON.stringify(eoObj) != "{}"){
					surveyObj[vo] = eoObj;
				}
			}
			//console.log("pass data is : ", JSON.stringify(surveyObj));
			$.ajax({
				url: "controller/risksurvey/WindProspectingInput/windProspectingInput",
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify(surveyObj),
				success: function (data) {
					console.log("return data is :", data);
					App.alert("风勘录入成功!");
				},
				error: function () {
					console.log("failed.");
				}
			});
		},
		 
		temporarySave: function(){
			console.log("temporary save risksurvey");
		},
		
		uploadImage: function(){
			console.log("upload image");
		}
		
    });
    
    cola.ready(function () {
    	
    	getMain();
//    	var content = "surveyClimate,surveyGeology,surveyWorksite,surveyBuildconstruct,surveyPiping,surveyRailway,surveyBridge,"
//    		 +"surveyTunnel,surveyStation,surveyPiping,surveyInstall,surveySecurity,surveyThirdduty,surveyInstallequip,surveyInstalllift,surveyInstalltech";
    	var content = model.get("surveyContents");
    	if (content != undefined && content != ""){
    		if (content.indexOf(",") != -1){
    			var contentArr = content.split(",");
            	//console.log("get survey content is : ", contentArr);
            	for (var i=0; i< contentArr.length; i++){
            		$("#"+contentArr[i]).parent().removeClass("display-none");
            		$("#"+contentArr[i]).removeClass("display-none");
            		//cola.widget(contentArr[i]).show();
            	}
    		}else{
    			$("#"+content).parent().removeClass("display-none");
        		$("#"+content).removeClass("display-none");
    		}
    	}
    	setTimeout(function(){
    		var subview = model.get('subviews');
        	var subviews = model._childScopes;
        	for(var i=0; i<subviews.length; i++){
        		//console.log(subviews[i].name);
        		if (subviews[i].name == "plcApplicant"){
        			subviews[i].set("plcApplicant", applicantArr);
        			//App.setFieldVisible($(".selfCustomerApplicant").eq(i), true, false);
        			//App.setFieldVisible($(".selfCustomerApplicant"), true, false);
        			$(".selfCustomerApplicant").removeClass("display-none");
        		}else if(subviews[i].name == "plcInsurant"){
        			subviews[i].set("plcInsurant", insurantArr);
        			$(".selfCustomer").removeClass("display-none");
        		}
        	}
    	}, 3000);
    });
    
    
    function getDataFromFile(){
    	$.ajax({
			url: "./risksurvey/data/risksurvey.json",
			type:"GET",
			async: false,
			success: function(data){
				model.set("fieldsObj", JSON.parse(data));
			}
		})
    }
    function getMain(){
    	var surveyId = model.get("surveyId");
    	$.ajax({
			url: "controller/risksurvey/WindProspectingInput/getWindReport",
	    	contentType: "application/json;charset=UTF-8",
	        type:"POST",
	        dataType : "json",
	        async: false,
	        data:JSON.stringify({surveyId:surveyId,status:'2'}),
			success: function(data){
				
				//获取要显示的风堪项
				model.set("surveyContents", data.modelUrl.modelUrl);
				
				var result = data.main;
				var pkId = data.pkid;
				model.set("surveyMain", result.surveyMain);
				var customerList = result.surveyCustomer;
				for (var i =0; i < customerList.length; i++){
					if (customerList[i].customerFlag == "1"){//被保人
						applicantArr.push(customerList[i]);
					}else{
						insurantArr.push(customerList[i]);
					}
				}
				//cola.tag("plcApplicant").set("plcApplicant", applicantArr);
				//model.set("plcApplicant", applicantArr);
				model.set("plcInsurant", insurantArr);
				model.set("relBusinessId", result.surveyRelBusiness);
				
				model.set("riskPolicy", {});//投保信息 TODO
				model.set("plcRiskEvaluate", {});//风险评价
				model.set("surveyConstructbasic", {});//工程基本信息
				model.set("surveyConstructparty", {});//工程相关方
				model.set("surveyGeology", {});//地质地貌
				model.set("surveyWorksite", {});//工程概况
				model.set("surveyBuildconstruct", {});//楼宇工程风险
				model.set("surveyThirdduty", {});//第三者责任险
				model.set("surveyBridge", {});//桥梁施工风险
				model.set("surveyClimate", {});//气候水文
				model.set("surveyInstall", {});//安装试车风险
				model.set("surveyInstallequip", {}); //主要设备生产线情况
				model.set("surveyInstalllift", {});//吊装工程情况
				model.set("surveyInstalltech", {});//工艺流程
				model.set("surveyPiping", {});//管道施工风险
				model.set("surveyRailway", {}); //公路铁路工程风险
				model.set("surveyRoad", {});//道路施工风险
				model.set("surveySecurity", {});//保安状况
				model.set("surveyStation", {});//车站施工风险
				model.set("surveyTunnel", {});//隧道施工风险
			}
		})
    }
    
})