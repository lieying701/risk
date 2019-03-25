cola(function(model){

    model.set("applicantTypeItems", [{
        'key': '1',
        'value': '个人'
    }, {
        'key': '2',
        'value': '单位'
    }]);

    var plcInsurantModle = [{
		//个人
		customerType: "1",
		customerFlag:"2",
		customerFlagName:"被保人",
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

    model.set("plcInsurant", plcInsurantModle);

    var productCode = "0901";

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

         //添加被保人
        addassured: function (entity) {
            var plcInsurant = model.get("plcInsurant");
        	if (model.get('plcInsurant')) {
        		if (model.get('actual') && model.get('plcInsurant')) {
        			var itemNo = model.get('plcInsurant').first().get('serialNo')
        			if (!itemNo) {
        				model.get('plcInsurant').first().set('serialNo', '1')
        			}
        		}
        		var newItemNo=null;
        		if(productCode && contractEntity.judgeInsurant(productCode)){
        			newItemNo = Number(window.getObjectNo()) + 1 + "";
        		}else{
        			newItemNo=Number(model.get('plcInsurant').last().get('serialNo'))+1;
        		}
                var customerTypes='',identifyTypes='',identifyNames='',customerTypeName='';
                debugger;
        		if(model.get('plcInsurant').first().get('customerType')=="1"){
        			plcInsurantModle.customerType = "1";
                    plcInsurantModle.identifyType = "01";
                    plcInsurantModle.customerTypeName = "个人";
                    plcInsurantModle.identifyName = "居民身份证";
        		}else if(model.get('plcInsurant').first().get('customerType')=="2"){
                    plcInsurantModle.customerType = "2";
                    plcInsurantModle.identifyType = "07";
                    plcInsurantModle.customerTypeName = "组织";
                    plcInsurantModle.identifyName = "组织机构代码证";
                }
                
                model.get("plcInsurant").insert(plcInsurantModle);
                plcInsurant.each(function (data, index) {
                    data.set("serialNo", index + 1)
                })
        		 
        	}
        },

        //删除被保人
        assuredDel: function (obj, index) {

            if (obj.parent.entityCount <= 1) {
                cola.alert('被保人至少保留一条！');
                return false;
            }
            if (productCode && contractEntity.judgeInsurant(productCode)) {
                //需要判断条款标的没有选中后再删除
                var isChecked = false;
                model.get("plcSolution").each(function (solution) {
                    var plcPackage = solution.get("plcPackage").current;
                    if (plcPackage.get("plcMainClause")) {
                        plcPackage.get("plcMainClause").each(function (mainclause) {
                            if (mainclause.get("plcClauseItem")) {
                                mainclause.get("plcClauseItem").each(function (mainClauseItem) {
                                    if (mainClauseItem.get("itemNo") == obj.get("serialNo")) {
                                        isChecked = true;
                                        return false;
                                    }
                                })
                            }

                            if (mainclause.get("plcAccessoryClause")) {
                                mainclause.get("plcAccessoryClause").each(function (addClause) {
                                    if (addClause.get("plcClauseItem")) {
                                        addClause.get("plcClauseItem").each(function (addClauseItem) {
                                            if (addClauseItem.get("itemNo") == obj.get("serialNo")) {
                                                isChecked = true;
                                                return false;
                                            }
                                        })
                                    }
                                })
                            }
                        })
                    }

                })
                //判断该被保险人在受益人中是否被选中
                var isChoose = false;
                if (model.get("plcBeneficiary")) {
                    model.get("plcBeneficiary").each(function (beneficiary) {
                        if (beneficiary.get('plcCustomer.linkNo') == obj.get("serialNo")) {
                            isChoose = true;
                            return false;
                        }
                    })
                }

                if (isChecked && isChoose) {
                    cola.alert("该被保险人在受益人、条款中已被选中，不能删除！");

                } else if (isChecked) {
                    cola.alert("该被保险人在条款中已被选中，不能删除！");

                } else if (isChoose) {
                    cola.alert("该被保险人在受益人中已被选中，不能删除！");

                } else {
                    model.get("objectNoDropList").each(function (index) {
                        if (index.get('itemNo') == obj.get('serialNo')) {
                            index.remove();
                        }
                    });
                    obj.clearMessages();
                    //删除被保人
                    // $.ajax({
        			// 	url:"controller/insurance/businessEntity/deleteSmallRole?kind=plcInsurant",
        			// 	type:"POST",
        			// 	data: JSON.stringify([obj.get("actualId")]),
        			// 	contentType: "application/json;charset=UTF-8",
        			// 	success:function(data){
        			// 		obj.remove();
        			// 	}
                    // })
                    obj.remove();
                }
            } else {
            	//删除被保人
            	// $.ajax({
    			// 	url:"controller/insurance/businessEntity/deleteSmallRole?kind=plcInsurant",
    			// 	type:"POST",
    			// 	data: JSON.stringify([obj.get("actualId")]),
    			// 	contentType: "application/json;charset=UTF-8",
    			// 	success:function(data){
    			// 		obj.remove();
    			// 	}
                // })
                obj.remove();
            }
        },

        //证件类型过滤
		filter: function (items, num) {
			return contractEntity.voucherFilter(items, num)
		},
		
		//点击查询按钮展示相对应的个人或单位字段
		insurantInfoDialog: function (insurant, $index, targetType) {
            activeIndex = $index - 1;
            model.set('imgVip',activeIndex)
            contractEntity.initGropDate(insurant);
			model.set("searchInsurant", insurant);
			//targetType：1：投保人 2：被保人
            contractEntity.portInquire(model,insurant,activeIndex,targetType);
            contractEntity.getIdentifyInfor(insurant);
        },
		insurantDetailInfo: function(){
			cola.widget("dialog2").hide();
			var imgindex = model.get('imgVip')
			var partyId = model.get("customerDetailArr").current.get("partyId");
			var tabImg = model.get("customerDetailArr").current.get("customerTypes");
			var customerTypeid = model.get("searchInsurant").get("customerType");
			var identityType = model.get("searchInsurant").get("identifyType");//证件类型
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
						model.get("searchInsurant").set("customerTypeName", "个人");
						if(individualResponse.customerGrade){
							switch(individualResponse.customerGrade){
								case "1":
									$('.card').eq(imgindex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
									model.get("searchInsurant").set("customerGradeName", "钻石卡");
									break;
								case "2":
									$('.card').eq(imgindex).attr('src','resources/images/gold_card.png').removeClass('display-none');
									model.get("searchInsurant").set("customerGradeName", "金卡");
									break;
								case "3":
									$('.card').eq(imgindex).attr('src','resources/images/silver_card.png').removeClass('display-none');
									model.get("searchInsurant").set("customerGradeName", "银卡");
									break;
								case "4":
									$('.card').eq(imgindex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
									model.get("searchInsurant").set("customerGradeName", "贵宾卡");
									break;
								default:
									$('.card').eq(imgindex).addClass('display-none');
									model.get("searchInsurant").set("customerGradeName", "普通客户");
									break;
							}
						}
						model.get("searchInsurant").set("birthDate", birthInfo)
						model.get("searchInsurant").set("sex", genderInfo);
						model.get("searchInsurant").set("customerCode", customerCode);
						model.get("searchInsurant").set("customerName", customerName);
						//证件识别Id
						model.get("searchInsurant").set("registId", individualResponse.registId ? individualResponse.registId : null);
						//邮箱
						model.get("searchInsurant").set("email", individualResponse.email ? individualResponse.email : null)
						//地址
						model.get("searchInsurant").set("address", individualResponse.address ? individualResponse.address : null)
						//国家
						model.get("searchInsurant").set("citizenship", individualResponse.countryCode ? individualResponse.countryCode : "CHN")
						//境内外标识
						model.get("searchInsurant").set("isWithinForeign", individualResponse.isWithinForeign ? individualResponse.isWithinForeign : 1)
						//邮政编码
						model.get("searchInsurant").set("post", individualResponse.post ? individualResponse.post : null)
						//身份证有效日期
						model.get("searchInsurant").set("identifyEffectiveEndDate", individualResponse.identityEffetiveEndDate ? individualResponse.identityEffetiveEndDate : null);
						var dataa = individualResponse.identityEffetiveEndDate;
						if(dataa){
							var indexa = activeIndex+1;
							if(dataa.indexOf("2999")!=-1){
								$('.dateOne'+indexa).css('pointerEvents','none').children('input').attr('readonly',true).css('background-color','#fbfbfb');
								model.$(".checkboxApp").addClass('checked').children('input').attr('checked',true);
								model.get("searchInsurant").set("longtermEffectiveFlag", "1");
							}else{
								$('.dateOne'+indexa).css('pointerEvents','').children('input').removeAttr('readonly').css('background-color','');
								model.$(".checkboxApp").removeClass('checked').children('input').removeAttr('checked');
								model.get("searchInsurant").set("longtermEffectiveFlag", "0");
							}
						}
						//手机
						model.get("searchInsurant").set("mobile", individualResponse.mobile ? individualResponse.mobile : null);
						model.get("searchInsurant").validate('phoneNumber')
						//固定电话
						model.get("searchInsurant").set("phoneNumber", individualResponse.phoneNumber ? individualResponse.phoneNumber : null);
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
						model.get("searchInsurant").validate('mobile')
						model.get("searchInsurant").set("customerGrade", individualResponse.customerGrade ? individualResponse.customerGrade : null)
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
                            model.get("searchInsurant").set("customerRiskGrade", riskgred);
                        }else if(individualResponse.manualRiskLevelCode){
							riskgred = individualResponse.manualRiskLevelCode;
							model.get("searchInsurant").set("customerRiskGrade", individualResponse.manualRiskLevelCode ? individualResponse.manualRiskLevelCode : null);
						}else if(individualResponse.autoRiskLevelCode){
							riskgred = individualResponse.autoRiskLevelCode;
							model.get("searchInsurant").set("customerRiskGrade", individualResponse.autoRiskLevelCode ? individualResponse.autoRiskLevelCode : null);
						}
						if(riskgred){
							switch(riskgred){
								case "1":
									model.get("searchInsurant").set("customerRiskGradeName", "高");
									break;
								case "2":
									model.get("searchInsurant").set("customerRiskGradeName", "中");
									break;
								case "3":
									model.get("searchInsurant").set("customerRiskGradeName", "低");
									break;
								case "4":
									model.get("searchInsurant").set("customerRiskGradeName", "禁止");
                                    App.alert("客户风险等级为禁止，不能承保");
									break;
								default:
									model.get("searchInsurant").set("customerRiskGradeName", "");
									break;
							}
						}
						App.setFieldVisible($(".grpCustomer").eq(activeIndex), false,true);
						App.setFieldVisible($(".selfCustomer").eq(activeIndex), true,false);
						if(identityType === "10" || identityType === "19" || identityType === "23" ){
							model.get("searchInsurant").set("isWithinForeign", "0");
						} else {
							model.get("searchInsurant").set("isWithinForeign", "1");
						}
					} else if (orgnizationResponse) {//customerTypeid=="2"
						model.get("searchInsurant").set("customerTypeName", "组织");
						if(orgnizationResponse.customerGrade){
							switch(orgnizationResponse.customerGrade){
								case "1":
									$('.card').eq(imgindex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
									model.get("searchInsurant").set("customerGradeName", "钻石卡");
									break;
								case "2":
									$('.card').eq(imgindex).attr('src','resources/images/gold_card.png').removeClass('display-none');
									model.get("searchInsurant").set("customerGradeName", "金卡");
									break;
								case "3":
									$('.card').eq(imgindex).attr('src','resources/images/silver_card.png').removeClass('display-none');
									model.get("searchInsurant").set("customerGradeName", "银卡");
									break;
								case "4":
									$('.card').eq(imgindex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
									model.get("searchInsurant").set("customerGradeName", "贵宾卡");
									break;
								default:
									$('.card').eq(imgindex).addClass('display-none');
									model.get("searchInsurant").set("customerGradeName", "普通客户");
									break;
							}
						}
						var ImgNums;
						if(orgnizationResponse.manualVIPLevelCode){
							ImgNums = orgnizationResponse.manualVIPLevelCode;
							//重客等级
							model.get("searchInsurant").set("mainCustomerGrade", orgnizationResponse.manualVIPLevelCode ? orgnizationResponse.manualVIPLevelCode : null)
						}else if(orgnizationResponse.autoVIPLevelCode){
							ImgNums =orgnizationResponse.autoVIPLevelCode;
							//重客等级
							model.get("searchInsurant").set("mainCustomerGrade", orgnizationResponse.autoVIPLevelCode ? orgnizationResponse.autoVIPLevelCode : null)
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
						model.get("searchInsurant").set("registyAddress", orgnizationResponse.registyAddress ? orgnizationResponse.registyAddress : null)
						//证件识别Id
						model.get("searchInsurant").set("registId", orgnizationResponse.registId ? orgnizationResponse.registId : null);
						//联系人手机
						model.get("searchInsurant").set("linkerMobile", orgnizationResponse.linkerMobile ? orgnizationResponse.linkerMobile : null);
						//联系人固话
						model.get("searchInsurant").set("linkerPhoneNo", orgnizationResponse.linkerPhoneNo ? orgnizationResponse.linkerPhoneNo : null);
						//联系人名称
						model.get("searchInsurant").set("linkerName", orgnizationResponse.linkerName ? orgnizationResponse.linkerName : null);
						/*后续联系方式使用下方三个字段，需要打印修改，数据清洗
						//地址
						model.get("searchInsurant").set("linkerAddress", orgnizationResponse.mailAddress ? orgnizationResponse.mailAddress : null);
						//邮政编码
						model.get("searchInsurant").set("linkerPost", orgnizationResponse.mailAddressPost ? orgnizationResponse.mailAddressPost : null);
						//邮箱
						model.get("searchInsurant").set("linkerEmail", orgnizationResponse.email ? orgnizationResponse.email : null);*/
						//客户代码
						model.get("searchInsurant").set("customerCode", orgnizationResponse.customerCode ? orgnizationResponse.customerCode : null);
						//客户名称
						model.get("searchInsurant").set("customerName", orgnizationResponse.customerName ? orgnizationResponse.customerName : null);
						model.get("searchInsurant").set("customerEName", orgnizationResponse.customerEName ? orgnizationResponse.customerEName : null);
						model.get("searchInsurant").set("organizationType", orgnizationResponse.organizationType ? orgnizationResponse.organizationType : null);
						//映射value
						var organizationList=cola.util.dictionary("OrgnizationType(FXQ)");
						organizationList.forEach(function(_item){
							if(_item.key==orgnizationResponse.organizationType){
								model.get("searchInsurant").set("organizationName", _item.value);
							}
						});
						model.get("searchInsurant").set("organizationSecondType", orgnizationResponse.economicTypeCode ? orgnizationResponse.economicTypeCode : null);
						model.get("searchInsurant").set("identifyEffectiveStartDate", orgnizationResponse.identityEffetiveStartDate ? orgnizationResponse.identityEffetiveStartDate : null);//注意接口返回字段名拼写有问题
						model.get("searchInsurant").set("identifyEffectiveEndDate", orgnizationResponse.identityEffetiveEndDate ? orgnizationResponse.identityEffetiveEndDate : null);
						model.get("searchInsurant").set("isLink", orgnizationResponse.isLink ? orgnizationResponse.isLink : null);
						model.get("searchInsurant").set("industryCategory", orgnizationResponse.industryCategory ? orgnizationResponse.industryCategory : null);
						//映射value
						var industryList=cola.util.dictionary("IndustryBigClass");
						industryList.forEach(function(_item){
							if(_item.key==orgnizationResponse.industryCategory){
								model.get("searchInsurant").set("industryCategoryName", _item.value);
							}
						});
						model.get("searchInsurant").set("mainBussiness", orgnizationResponse.mainBusiness ? orgnizationResponse.mainBussiness : null);
						model.get("searchInsurant").set("registeredPlaceCode", orgnizationResponse.registeredPlaceCode ? orgnizationResponse.registeredPlaceCode : null);
						model.get("searchInsurant").set("registyAddress", orgnizationResponse.registyAddress ? orgnizationResponse.registyAddress : null);
						model.get("searchInsurant").set("busiLicense", orgnizationResponse.busilicense ? orgnizationResponse.busilicense : null);
						model.get("searchInsurant").set("busiLicenseStartDate", orgnizationResponse.busiLicenseStartDate ? orgnizationResponse.busiLicenseStartDate : null);
						model.get("searchInsurant").set("busiLicenseEndDate", orgnizationResponse.busiLicenseEndDate ? orgnizationResponse.busiLicenseEndDate : null);



						model.get("searchInsurant").set("taxRegistrationNo", orgnizationResponse.taxregistrationNo  ? orgnizationResponse.taxregistrationNo : null);
						//后续需要更换
						model.get("searchInsurant").set("email", orgnizationResponse.email ? orgnizationResponse.email : null);
						//后续需要更换
						model.get("searchInsurant").set("mailAddressPost", orgnizationResponse.mailAddressPost ? orgnizationResponse.mailAddressPost : null);
						model.get("searchInsurant").set("facsimile", orgnizationResponse.facsimile ? orgnizationResponse.facsimile : null);
						//后续需要更换
						model.get("searchInsurant").set("mailAddress", orgnizationResponse.mailAddress ? orgnizationResponse.mailAddress : null);
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
                            model.get("searchInsurant").set("customerRiskGrade", riskgred);
                        }else if(orgnizationResponse.manualRiskLevelCode){
							riskgred = orgnizationResponse.manualRiskLevelCode;
							model.get("searchInsurant").set("customerRiskGrade", orgnizationResponse.manualRiskLevelCode ? orgnizationResponse.manualRiskLevelCode : null);
						}else if(orgnizationResponse.autoRiskLevelCode){
							riskgred = orgnizationResponse.autoRiskLevelCode;
							model.get("searchInsurant").set("customerRiskGrade", orgnizationResponse.autoRiskLevelCode ? orgnizationResponse.autoRiskLevelCode : null);
						}
						if(riskgred){
							switch(riskgred){
								case "1":
									model.get("searchInsurant").set("customerRiskGradeName", "高");
									break;
								case "2":
									model.get("searchInsurant").set("customerRiskGradeName", "中");
									break;
								case "3":
									model.get("searchInsurant").set("customerRiskGradeName", "低");
									break;
								case "4":
									model.get("searchInsurant").set("customerRiskGradeName", "禁止");
                                    App.alert("客户风险等级为禁止，不能承保");
									break;
								default:
									model.get("searchInsurant").set("customerRiskGradeName", "");
									break;
							}
						}

						App.setFieldVisible($(".grpCustomer").eq(activeIndex), true,false);
						App.setFieldVisible($(".selfCustomer").eq(activeIndex), false,true);
					}
				}
			})
		},
    })

})