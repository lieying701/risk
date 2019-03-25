cola(function(model){

    model.set("applicantTypeItems", [{
        'key': '1',
        'value': '个人'
    }, {
        'key': '2',
        'value': '单位'
    }]);


    var plcApplicantModle = [{
		//个人
		customerType: "1",
		customerFlag:"2",
		customerFlagName:"投保人",
		customerTypeName:"个人",
		customerName: null,
		identifyType: '01',
		identifyName:'居民身份证',
		identifyNumber: null,
		customerCode: null,
		identifyEffectiveEndDate: null,
		identifyEffectiveStartDate:null,
		longtermEffectiveFlag:"0",
		despositBankName: null,
		accountName: null,
		accountNo: null,
		customerGrade: null,
		customerGradeName:null,
		customerRiskGrade: null,
		customerRiskGradeName:null,
		businessSphere:null,
		businessSphereCode:null,
		registId:null,
		serialNo:"1",
		customerEName:null,
        isLink:"0",
        
        age: null,
        sex: null,
        sexName: null,
        birthDate: null,
        citizenship: "CHN",
        citizenshipName:"中国",
        address: null,
        phoneNumber: null,
        mobile: null,
        email: null,
        post: null,
        isWithinForeign: "1",		
		//单位
		linkerName: null,
		linkerMobile: null,
		linkerPhoneNo: null,
		registyAddress: null,
        taxRegistrationNo:null,
        mailAddressPost: null,
        mainCustomerGrade:null,
        industryCategory:null,
        industryCategoryName:null,
        mainBussiness:null,
        registeredPlaceCode:"CHN",
        registeredPlace:"中国",
        busiLicense:null,
        busiLicenseStartDate:null,
        busiLicenseEndDate:null,
        organizationType:null,
        organizationName:null,
        organizationSecondType:null,
        organizationSecondTypeName: null,
        mailAddress:null,
        mailAddressPost:null,
        facsimile:null,
        shareholdersName:null,
        shareholdersCerType:null,
        shareholdersCerTypeName:null,
        shareholdersCerNo:null,
        shareholdersCerStartDate:null,
        shareholdersCerEndDate:null,
        applialeaderName:null,
        applialeaderType:null,
        applialeaderTypeName:null,
        applialeaderId:null,
        applialeaderCerStartDate:null,
        applialeaderCerEndDate:null,
        responsibleName:null,
        responsibleCerType:null,
        responsibleCerTypeName:null,
        responsibleCerNo:null,
        responsibleCerStartDate:null,
        responsibleCerEndDate:null,
        industryCategoryName:null,
        industryCategory:null,
        industrySCategory:null,
        industrySCategoryName:null,
        industryTCategory:null,
        industryTCategoryName:null,
        businessAddress:null			
    }];
    
    model.set("plcApplicant", plcApplicantModle);

    var delFlag = false;

    model.action({

        changeidentifyType: function (applicant) {
			if (applicant.get("customerType") == "1") {
				applicant.set("identifyType", "01")
				applicant.set("customerTypeName", "个人")
				applicant.set("identifyName", "居民身份证")
			} else if (applicant.get("customerType") == "2") {
				applicant.set("identifyType", "07");
				applicant.set("customerTypeName", "组织")
				applicant.set("identifyName", "组织机构代码证")
			}
		},

        //添加投保人
		addApplicant: function (kind) {
			var plcApplicant = model.get("plcApplicant");

			if (model.get("plcApplicant.customerType") == "1") {
				plcApplicantModle.customerType = "1";
				plcApplicantModle.identifyType = "01";
				plcApplicantModle.customerTypeName = "个人";
				plcApplicantModle.identifyName = "居民身份证";
			} else if (model.get("plcApplicant.customerType") == "2") {
				plcApplicantModle.customerType = "2";
				plcApplicantModle.customerTypeName = "组织";
				plcApplicantModle.identifyType = "07";
				plcApplicantModle.identifyName = "组织机构代码证";
			}

			plcApplicant.insert(plcApplicantModle);
			plcApplicant.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        
        //删除投保人
		delApplicant: function (obj, index) {
			delFlag = true;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条客户信息",
					showDuration: 3000
				});
				return false
			}
			var params = cola.util.queryParams();
			if (params.actualId) {
				delApplicant(index - 1);//触发 -> 从actual删除不存在的投保人 的事件
				contractEntity.syncApplicantForInsurantRadio(model, index);
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "投保人删除成功",
				showDuration: 3000
			});

			delFlag = false;
        },
        
        //证件类型过滤
		filter: function (items, num) {
			return contractEntity.voucherFilter(items, num)
		},
		//根据个人和集体的多条信息获取的客户id带出详细信息
        applicantDetailInfo: function (applicant) {
			cola.widget("dialog1").hide();
			var imgindex = model.get('imgVip')
			var partyId = model.get("customerDetailArr").current.get("partyId");
			var tabImg = model.get("customerDetailArr").current.get("customerTypes");
			var customerTypeid = model.get("searchApplicant").get("customerType");
			var identityType = model.get("searchApplicant").get("identifyType");//证件类型
			var numimg=0;
			//个人的客户id获取详细数据
			$.ajax({
				url: "controller/risksurvey/ecifClient/getCustomer?sysId=B102&interruptFlag=1&customerType=" + customerTypeid,
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify({
					partyIdObj: {
						partyId: partyId
					}

				}),
				success: function (data) {
					var individualResponse = data.individualResponse;//个人
					var orgnizationResponse = data.orgnizationResponse;//组织
					if (individualResponse) {//customerTypeid=="1"
						var birthInfo = individualResponse.birthDate ? individualResponse.birthDate : null;
						var genderInfo = individualResponse.sex ? individualResponse.sex : null;
						var customerName = individualResponse.idname ? individualResponse.idname : null;
						var customerCode = individualResponse.customerCode ? individualResponse.customerCode : null;
						model.get("searchApplicant").set("customerTypeName", "个人");
						if(individualResponse.customerGrade){
							switch(individualResponse.customerGrade){
								case "1":
									$('.card').eq(imgindex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
									model.get("searchApplicant").set("customerGradeName", "钻石卡");
									break;
								case "2":
									$('.card').eq(imgindex).attr('src','resources/images/gold_card.png').removeClass('display-none');
									model.get("searchApplicant").set("customerGradeName", "金卡");
									break;
								case "3":
									$('.card').eq(imgindex).attr('src','resources/images/silver_card.png').removeClass('display-none');
									model.get("searchApplicant").set("customerGradeName", "银卡");
									break;
								case "4":
									$('.card').eq(imgindex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
									model.get("searchApplicant").set("customerGradeName", "贵宾卡");
									break;
								default:
									$('.card').eq(imgindex).addClass('display-none');
									model.get("searchApplicant").set("customerGradeName", "普通客户");
									break;
							}
						}
						model.get("searchApplicant").set("birthDate", birthInfo)
						model.get("searchApplicant").set("sex", genderInfo);
						model.get("searchApplicant").set("customerCode", customerCode);
						model.get("searchApplicant").set("customerName", customerName);
						//证件识别Id
						model.get("searchApplicant").set("registId", individualResponse.registId ? individualResponse.registId : null);
						//邮箱
						model.get("searchApplicant").set("email", individualResponse.email ? individualResponse.email : null)
						//地址
						model.get("searchApplicant").set("address", individualResponse.address ? individualResponse.address : null)
						//国家
						model.get("searchApplicant").set("citizenship", individualResponse.countryCode ? individualResponse.countryCode : "CHN")
						//境内外标识
						model.get("searchApplicant").set("isWithinForeign", individualResponse.isWithinForeign ? individualResponse.isWithinForeign : 1)
						//邮政编码
						model.get("searchApplicant").set("post", individualResponse.post ? individualResponse.post : null)
						//身份证有效日期
						model.get("searchApplicant").set("identifyEffectiveEndDate", individualResponse.identityEffetiveEndDate ? individualResponse.identityEffetiveEndDate : null);
						var dataa = individualResponse.identityEffetiveEndDate;
						if(dataa){
							var indexa = activeIndex+1;
							if(dataa.indexOf("2999")!=-1){
								$('.dateOne'+indexa).css('pointerEvents','none').children('input').attr('readonly',true).css('background-color','#fbfbfb');
								model.$(".checkboxApp").addClass('checked').children('input').attr('checked',true);
								model.get("searchApplicant").set("longtermEffectiveFlag", "1");
							}else{
								$('.dateOne'+indexa).css('pointerEvents','').children('input').removeAttr('readonly').css('background-color','');
								model.$(".checkboxApp").removeClass('checked').children('input').removeAttr('checked');
								model.get("searchApplicant").set("longtermEffectiveFlag", "0");
							}
						}
						//手机
						model.get("searchApplicant").set("mobile", individualResponse.mobile ? individualResponse.mobile : null);
						model.get("searchApplicant").validate('phoneNumber')
						//固定电话
						model.get("searchApplicant").set("phoneNumber", individualResponse.phoneNumber ? individualResponse.phoneNumber : null);
						if(individualResponse.mobileRepeatNo){
							if(individualResponse.mobileRepeatNo>1){
								App.alert("系统中已存在"+individualResponse.mobileRepeatNo+"个相同的手机号码"+individualResponse.mobile+"!");
							}
						}
						if(individualResponse.phoneNumberRepeatNo){
							if(individualResponse.phoneNumberRepeatNo>1){
								App.alert("系统中已存在"+individualResponse.phoneNumberRepeatNo+"个相同的号码"+individualResponse.phoneNumber+"!");
							}
						}
						model.get("searchApplicant").validate('mobile')
						model.get("searchApplicant").set("customerGrade", individualResponse.customerGrade ? individualResponse.customerGrade : null)
						var riskgred='';
                        if(individualResponse.manualRiskLevelCode && individualResponse.autoRiskLevelCode){
                            if(individualResponse.manualRiskLevelCode == "4"){
                                riskgred = individualResponse.manualRiskLevelCode;
                            } else if(individualResponse.autoRiskLevelCode == "4"){
                                riskgred = individualResponse.autoRiskLevelCode;
                            } else {
                                riskgred = individualResponse.manualRiskLevelCode*1 < individualResponse.autoRiskLevelCode*1 ?
                                    individualResponse.manualRiskLevelCode : individualResponse.autoRiskLevelCode
                            }
                            model.get("searchApplicant").set("customerRiskGrade", riskgred);
                        }else if(individualResponse.manualRiskLevelCode){
							riskgred = individualResponse.manualRiskLevelCode;
							model.get("searchApplicant").set("customerRiskGrade", individualResponse.manualRiskLevelCode ? individualResponse.manualRiskLevelCode : null);
						}else if(individualResponse.autoRiskLevelCode){
							riskgred = individualResponse.autoRiskLevelCode;
							model.get("searchApplicant").set("customerRiskGrade", individualResponse.autoRiskLevelCode ? individualResponse.autoRiskLevelCode : null);
						}
						if(riskgred){
							switch(riskgred){
								case "1":
									model.get("searchApplicant").set("customerRiskGradeName", "高");
									break;
								case "2":
									model.get("searchApplicant").set("customerRiskGradeName", "中");
									break;
								case "3":
									model.get("searchApplicant").set("customerRiskGradeName", "低");
									break;
								case "4":
									model.get("searchApplicant").set("customerRiskGradeName", "禁止");
                                    App.alert("客户风险等级为禁止，不能承保");
									break;
								default:
									model.get("searchApplicant").set("customerRiskGradeName", "");
									break;
							}
						}
						App.setFieldVisible($(".grpCustomerApplicant").eq(activeIndex), false,true);
						App.setFieldVisible($(".selfCustomerApplicant").eq(activeIndex), true,false);
						if(identityType === "10" || identityType === "19" || identityType === "23" ){
							model.get("searchApplicant").set("isWithinForeign", "0");
						} else {
							model.get("searchApplicant").set("isWithinForeign", "1");
						}
					} else if (orgnizationResponse) {//customerTypeid=="2"
						model.get("searchApplicant").set("customerTypeName", "组织");
						if(orgnizationResponse.customerGrade){
							switch(orgnizationResponse.customerGrade){
								case "1":
									$('.card').eq(imgindex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
									model.get("searchApplicant").set("customerGradeName", "钻石卡");
									break;
								case "2":
									$('.card').eq(imgindex).attr('src','resources/images/gold_card.png').removeClass('display-none');
									model.get("searchApplicant").set("customerGradeName", "金卡");
									break;
								case "3":
									$('.card').eq(imgindex).attr('src','resources/images/silver_card.png').removeClass('display-none');
									model.get("searchApplicant").set("customerGradeName", "银卡");
									break;
								case "4":
									$('.card').eq(imgindex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
									model.get("searchApplicant").set("customerGradeName", "贵宾卡");
									break;
								default:
									$('.card').eq(imgindex).addClass('display-none');
									model.get("searchApplicant").set("customerGradeName", "普通客户");
									break;
							}
						}
						var ImgNums;
						if(orgnizationResponse.manualVIPLevelCode){
							ImgNums = orgnizationResponse.manualVIPLevelCode;
							//重客等级
							model.get("searchApplicant").set("mainCustomerGrade", orgnizationResponse.manualVIPLevelCode ? orgnizationResponse.manualVIPLevelCode : null)
						}else if(orgnizationResponse.autoVIPLevelCode){
							ImgNums =orgnizationResponse.autoVIPLevelCode;
							//重客等级
							model.get("searchApplicant").set("mainCustomerGrade", orgnizationResponse.autoVIPLevelCode ? orgnizationResponse.autoVIPLevelCode : null)
						}
						if(ImgNums){
							switch(ImgNums){
								case "1":
									$('.imgVip').eq(imgindex).attr('src','resources/images/VIP1.png').removeClass('display-none');
									break;
								case "2":
									$('.imgVip').eq(imgindex).attr('src','resources/images/VIP2.png').removeClass('display-none');
									break;
								case "3":
									$('.imgVip').eq(imgindex).attr('src','resources/images/VIP3.png').removeClass('display-none');
									break;
								default:
									$('.imgVip').eq(imgindex).addClass('display-none');
									break;
							}
						}

						//注册地址
						model.get("searchApplicant").set("registyAddress", orgnizationResponse.registyAddress ? orgnizationResponse.registyAddress : null)
						//证件识别Id
						model.get("searchApplicant").set("registId", orgnizationResponse.registId ? orgnizationResponse.registId : null);
						//联系人手机
						model.get("searchApplicant").set("linkerMobile", orgnizationResponse.linkerMobile ? orgnizationResponse.linkerMobile : null);
						//联系人固话
						model.get("searchApplicant").set("linkerPhoneNo", orgnizationResponse.linkerPhoneNo ? orgnizationResponse.linkerPhoneNo : null);
						//联系人名称
						model.get("searchApplicant").set("linkerName", orgnizationResponse.linkerName ? orgnizationResponse.linkerName : null);
						/*后续联系方式使用下方三个字段，需要打印修改，数据清洗
						//地址
						model.get("searchApplicant").set("linkerAddress", orgnizationResponse.mailAddress ? orgnizationResponse.mailAddress : null);
						//邮政编码
						model.get("searchApplicant").set("linkerPost", orgnizationResponse.mailAddressPost ? orgnizationResponse.mailAddressPost : null);
						//邮箱
						model.get("searchApplicant").set("linkerEmail", orgnizationResponse.email ? orgnizationResponse.email : null);*/
						//客户代码
						model.get("searchApplicant").set("customerCode", orgnizationResponse.customerCode ? orgnizationResponse.customerCode : null);
						//客户名称
						model.get("searchApplicant").set("customerName", orgnizationResponse.customerName ? orgnizationResponse.customerName : null);
						model.get("searchApplicant").set("customerEName", orgnizationResponse.customerEName ? orgnizationResponse.customerEName : null);
						model.get("searchApplicant").set("organizationType", orgnizationResponse.organizationType ? orgnizationResponse.organizationType : null);
						//映射value
						var organizationList=cola.util.dictionary("OrgnizationType(FXQ)");
						organizationList.forEach(function(_item){
							if(_item.key==orgnizationResponse.organizationType){
								model.get("searchApplicant").set("organizationName", _item.value);
							}
						});
						model.get("searchApplicant").set("organizationSecondType", orgnizationResponse.economicTypeCode ? orgnizationResponse.economicTypeCode : null);
						model.get("searchApplicant").set("identifyEffectiveStartDate", orgnizationResponse.identityEffetiveStartDate ? orgnizationResponse.identityEffetiveStartDate : null);//注意接口返回字段名拼写有问题
						model.get("searchApplicant").set("identifyEffectiveEndDate", orgnizationResponse.identityEffetiveEndDate ? orgnizationResponse.identityEffetiveEndDate : null);
						model.get("searchApplicant").set("isLink", orgnizationResponse.isLink ? orgnizationResponse.isLink : null);
						model.get("searchApplicant").set("industryCategory", orgnizationResponse.industryCategory ? orgnizationResponse.industryCategory : null);
						//映射value
						var industryList=cola.util.dictionary("IndustryBigClass");
						industryList.forEach(function(_item){
							if(_item.key==orgnizationResponse.industryCategory){
								model.get("searchApplicant").set("industryCategoryName", _item.value);
							}
						});
						model.get("searchApplicant").set("mainBussiness", orgnizationResponse.mainBusiness ? orgnizationResponse.mainBussiness : null);
						model.get("searchApplicant").set("registeredPlaceCode", orgnizationResponse.registeredPlaceCode ? orgnizationResponse.registeredPlaceCode : null);
						model.get("searchApplicant").set("registyAddress", orgnizationResponse.registyAddress ? orgnizationResponse.registyAddress : null);
						model.get("searchApplicant").set("busiLicense", orgnizationResponse.busilicense ? orgnizationResponse.busilicense : null);
						model.get("searchApplicant").set("busiLicenseStartDate", orgnizationResponse.busiLicenseStartDate ? orgnizationResponse.busiLicenseStartDate : null);
						model.get("searchApplicant").set("busiLicenseEndDate", orgnizationResponse.busiLicenseEndDate ? orgnizationResponse.busiLicenseEndDate : null);



						model.get("searchApplicant").set("taxRegistrationNo", orgnizationResponse.taxregistrationNo  ? orgnizationResponse.taxregistrationNo : null);
						//后续需要更换
						model.get("searchApplicant").set("email", orgnizationResponse.email ? orgnizationResponse.email : null);
						//后续需要更换
						model.get("searchApplicant").set("mailAddressPost", orgnizationResponse.mailAddressPost ? orgnizationResponse.mailAddressPost : null);
						model.get("searchApplicant").set("facsimile", orgnizationResponse.facsimile ? orgnizationResponse.facsimile : null);
						//后续需要更换
						model.get("searchApplicant").set("mailAddress", orgnizationResponse.mailAddress ? orgnizationResponse.mailAddress : null);
						var riskgred='';
                        if(orgnizationResponse.manualRiskLevelCode && orgnizationResponse.autoRiskLevelCode){
                            if(orgnizationResponse.manualRiskLevelCode == "4"){
                                riskgred = orgnizationResponse.manualRiskLevelCode;
                            } else if(orgnizationResponse.autoRiskLevelCode == "4"){
                                riskgred = orgnizationResponse.autoRiskLevelCode;
                            } else {
                                riskgred = orgnizationResponse.manualRiskLevelCode*1 < orgnizationResponse.autoRiskLevelCode*1 ?
                                    orgnizationResponse.manualRiskLevelCode : orgnizationResponse.autoRiskLevelCode
                            }
                            model.get("searchApplicant").set("customerRiskGrade", riskgred);
                        }else if(orgnizationResponse.manualRiskLevelCode){
							riskgred = orgnizationResponse.manualRiskLevelCode;
							model.get("searchApplicant").set("customerRiskGrade", orgnizationResponse.manualRiskLevelCode ? orgnizationResponse.manualRiskLevelCode : null);
						}else if(orgnizationResponse.autoRiskLevelCode){
							riskgred = orgnizationResponse.autoRiskLevelCode;
							model.get("searchApplicant").set("customerRiskGrade", orgnizationResponse.autoRiskLevelCode ? orgnizationResponse.autoRiskLevelCode : null);
						}
						if(riskgred){
							switch(riskgred){
								case "1":
									model.get("searchApplicant").set("customerRiskGradeName", "高");
									break;
								case "2":
									model.get("searchApplicant").set("customerRiskGradeName", "中");
									break;
								case "3":
									model.get("searchApplicant").set("customerRiskGradeName", "低");
									break;
								case "4":
									model.get("searchApplicant").set("customerRiskGradeName", "禁止");
                                    App.alert("客户风险等级为禁止，不能承保");
									break;
								default:
									model.get("searchApplicant").set("customerRiskGradeName", "");
									break;
							}
						}

						App.setFieldVisible($(".grpCustomerApplicant").eq(activeIndex), true,false);
						App.setFieldVisible($(".selfCustomerApplicant").eq(activeIndex), false,true);
					}
				}
			})
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

		//投保人切换类型控制
		applicantchangecustypes: function(self,arg){
			debugger
			console.log("change customer type ");
			var datanums = model.get("plcApplicant").toJSON();
			if(datanums.length>1){
				if(arg.model.get("applicant").get("customerType")!=arg.value){
					App.alert("关系人类型必须为一致，如:个人/组织")
					return false;
				}
			}else{
				//arg.model.set("applicant.customerName","");
				arg.model.set("applicant.identifyNumber","");
				arg.model.set("applicant.customerCode","");
				var index = $(".applicantCustypes").index($(self.getDom()));
				if($(".applicantBtncxs").eq(index).hasClass("disabled")){
					App.setFieldVisible($(".selfCustomerApplicant").eq(index), false, true);
					App.setFieldVisible($(".grpCustomerApplicant").eq(index), false, true);
				}else{
					debugger;
					if(arg.value=="1"){
						App.setFieldVisible($(".selfCustomerApplicant").eq(index), false, true);
						App.setFieldVisible($(".grpCustomerApplicant").eq(index), true, false);
					}else{
						App.setFieldVisible($(".selfCustomerApplicant").eq(index), true, false);
						App.setFieldVisible($(".grpCustomerApplicant").eq(index), false, true);
					}
				}

			}
		},
    })
})