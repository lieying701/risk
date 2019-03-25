cola( function(model) {
    
    model.set("SexType", [{
        'key': '0',
        'value': '男'
    },{
        'key': '1',
        'value': '女'
    }]);

    model.set("isWithinForeign", [{
        'key': '0',
        'value': '境内'
    },{
        'key': '1',
        'value': '境外'
	}]);
	
	model.set("riskSurveyContent", [{
        "key": "surveyClimate",
        "value": "气候水文"
    },{
        "key": "surveyGeology",
        "value": "地质地貌"
    },{
        "key": "surveyWorksite",
        "value": "工地概况"
    },{
        "key": "surveyBuildconstruct",
        "value": "楼宇工程风险"
    },{
        "key": "surveyPiping",
        "value": "道路施工风险"
    },{
        "key": "surveyRailway",
        "value": "公路铁路工程风险"
    },{
        "key": "surveyBridge",
        "value": "桥梁施工风险"
    },{
        "key": "surveyTunnel",
        "value": "隧道施工风险"
    },{
        "key": "surveyStation",
        "value": "车站施工风险"
    },{
        "key": "surveyPiping",
        "value": "管道施工风险"
    },{
        "key": "surveyInstall",
        "value": "安装工程/试车风险"
    },{
        "key": "surveySecurity",
        "value": "保安状况"
    },{
        "key": "surveyThirdduty",
        "value": "第三者责任风险"
    },{
        "key": "surveyInstallequip",
        "value": "主要设备生产线情况"
    },{
        "key": "surveyInstalllift",
        "value": "吊装工程情况"
    },{
        "key": "surveyInstalltech",
        "value": "工艺流程"
    }]);

	var surveyContent = [];
	
    model.action({
    	
    	chooseContent: function(self, arg){
    		var key = arg.model.data._itemData._data.key;
    		if (self._value){
    			surveyContent.push(key);
    		}else {
    			for (var i = 0; i < surveyContent.length; i++){
    				if(surveyContent[i] == key){
    					surveyContent.splice(i, 1);
    				}
    			}
    		}
    		//console.log("surveyContent is : ", surveyContent);
    	},
        
        //点击查询按钮展示相对应的个人或单位字段
        applicantInfoDialog: function (applicant, $index, targetType) {
            activeIndex = $index - 1;
            model.set('imgVip',activeIndex)
            contractEntity.initGropDate(applicant);
			model.set("searchApplicant", applicant);
			//targetType：1：投保人 2：被保人
            contractEntity.portInquire(model,applicant,activeIndex,targetType);
            contractEntity.getIdentifyInfor(applicant);
        },

		submitTask: function(){
			var operationType = "1";
			saveSurvey(operationType);
		},
		saveTask: function(){
			var operationType = "0";
			saveSurvey(operationType);
		},
		
	})
	
	cola.ready(function () {
		//getCurrentUser();
    });
    
	function saveSurvey(operationType){
    	//获取页面数据
		var obj = {};
		
		//surveyMain
		var surveyMainObj = {};
		//投保信息数据
		var productModel = cola.model("productModel");
		surveyMainObj.product = productModel.get("product");
		surveyMainObj.amount = productModel.get("amount");
		surveyMainObj.productCode = productModel.get("productCode");
		
		var surveyInfoModel = cola.model("surveyInfoModel");
		surveyMainObj.applyDeptSec = surveyInfoModel.get("applyDeptSec");
		surveyMainObj.applyDeptThr = surveyInfoModel.get("applyDeptThr");
		surveyMainObj.applyDept = surveyInfoModel.get("applyDept");
		surveyMainObj.reportDeptSec = surveyInfoModel.get("reportDeptSec");
		surveyMainObj.reportDeptThr = surveyInfoModel.get("reportDeptThr");
		surveyMainObj.reportDept = surveyInfoModel.get("reportDept");
		surveyMainObj.surveyerDate = surveyInfoModel.get("surveyerDate");
		surveyMainObj.surveyer = surveyInfoModel.get("surveyer");
		surveyMainObj.surveyerType = surveyInfoModel.get("surveyerType");
		surveyMainObj.surveyerDivision = surveyInfoModel.get("surveyerDivision");
		surveyMainObj.reportProducer = surveyInfoModel.get("reportProducer");
		surveyMainObj.reportProduceDate = surveyInfoModel.get("reportProduceDate");
		
		//surveyCustomer
		//投保人信息
		var applicantModel = cola.model("applicantModel");
		var applicantArr = getCustomerInfo(applicantModel, "2");
		//被保人信息
		var insurantModel = cola.model("insurantModel");
		var insurantArr = getCustomerInfo(insurantModel, "1");
		var customerArr = applicantArr.concat(insurantArr);
		
		//surveyRelBusiness
		var surveyRelBusObj = {};
		surveyRelBusObj.surveyTimes = surveyInfoModel.get("surveyTimes");
		
		obj.surveyCustomer = customerArr;
		obj.surveyMain = surveyMainObj;
		obj.surveyRelBusiness = surveyRelBusObj;
		obj.operation_type = operationType;// 0:暂存;1:提交 
		
		var content = {};
		content.modelUrl = surveyContent.join();
		obj.surveyItemlist = content;//风勘项
		
		$.ajax({
			url: "controller/risksurvey/originating/originatingTaskSave",
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(obj),
			success: function (data) {
				console.log("return data is :", data);
				if (data.status == "success"){
					if (operationType == "0") {
						App.alert("暂存成功");
					}else if (operationType == "1"){
						App.alert("任务发起成功,任务编号为:" + data.surveyId);//+data.surveyId
					}
				}
			},
			error: function () {
				console.log("save survey task failed.");
			}
		});
		//return obj;
    }
	
	function getCustomerInfo(customerModel, customerFlag){
		var result = [];
		var customer;
		if(customerFlag == "2"){
			customer = customerModel.get("plcApplicant");
		}else{
			customer = customerModel.get("plcInsurant");
		}
		if(customer && customer.entityCount > 0){
			customer.each(function(applicant, index){
				debugger;
				var applicantObj = {};
				applicantObj.serialNo = index;
				applicantObj.customerType = applicant.get("customerType");
				applicantObj.customerFlag = customerFlag;//1:被保人;2:投保人
				applicantObj.customerFlagName = "投保人";
				applicantObj.customerCode = applicant.get("customerCode");//关系人代码
				applicantObj.customerName = applicant.get("customerName");
				applicantObj.customereName = applicant.get("customerEName");
				applicantObj.identifyType = applicant.get("identifyType");
				applicantObj.identifyName = applicant.get("identifyName");
				applicantObj.identifyNumber = applicant.get("identifyNumber");
				applicantObj.identifyEffectiveStartDate = applicant.get("identifyEffectiveStartDate");
				applicantObj.identifyEffectiveEndDate = applicant.get("identifyEffectiveEndDate");
				applicantObj.longtermEffectiveFlag = applicant.get("longtermEffectiveFlag");//页面需添加
				applicantObj.age = applicant.get("age");
				applicantObj.sex = applicant.get("sex");
				applicantObj.sexName = applicant.get("sexName");
				applicantObj.birthdate = applicant.get("birthDate");
				applicantObj.citizenship = applicant.get("registeredPlaceCode");//国籍
				applicantObj.citizenshipName = applicant.get("registeredPlace");
				applicantObj.address = applicant.get("address");
				applicantObj.linkerPhoneNo = applicant.get("linkerPhoneNo");
				applicantObj.linkerMobile = applicant.get("linkerMobile");
				applicantObj.linkereMail = applicant.get("linkereMail");
				applicantObj.linkerPost = applicant.get("linkerPost");
				applicantObj.iswithinForeign = applicant.get("iswithinForeign");
				applicantObj.despositBankName = applicant.get("despositBankName");
				applicantObj.accountNo = applicant.get("accountNo");
				applicantObj.accountName = applicant.get("accountName");
				applicantObj.createUserID = applicant.get("createUserID");//创建员代码
				applicantObj.updateUserID = applicant.get("updateUserID");//修改员代码
				applicantObj.createDate = applicant.get("createDate");//创建时间
				applicantObj.updateDate = applicant.get("updateDate");//修改时间

				result.push(applicantObj);
			});
		}
		return result;
	}
	
	function getCurrentUser(){
		$.ajax({
			url: "controller/risksurvey/salesmanagement/getCurrentUser",
			type: "POST",
			contentType: "application/json",
			success: function (data) {
				var ownedStructureId = data.ownedStructureId;
				getSalesManagement(ownedStructureId);
			},
			error: function () {
				console.log("get current user info failed.");
			}
		});
	}
	
	function getSalesManagement(structureId){
		$.ajax({
			url: "controller/risksurvey/salesmanagement/findByPartyId?parentId="+structureId,
			type: "POST",
			contentType: "application/json",
			success: function (data) {
				var partyId = data.partyId;
				var name = data.name;
				model.set("reportDeptSec", partyId+"-"+name);
			},
			error: function () {
			}
		});
	}

})