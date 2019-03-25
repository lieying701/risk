function ContractEntity() {

}
//投保人和被保人调ECIF接口查询按钮
ContractEntity.prototype.portInquire = function (model, applicant, activeIndex, targetType) {
    var identityNum = applicant.get("identifyNumber");//证件号码
    var identityType = applicant.get("identifyType");//证件类型
    var customerType = applicant.get("customerType");//关系人类型
    var customerName = applicant.get("customerName");//证件名称
    // if(customerType=="1"){
    //     var customerName = "";
    // }else{
        //var customerName = applicant.get("customerName");//证件名称
    //}
    debugger;
    
    if(customerType==="2"){
        //临时计算判断使用
        var rCnt= 0; //人民币超过10000的个数
        var fCnt= 0; //外币超过1000美元的个数

        var exchangeList = [];
        var premiumToUSDArr =[];
        //key:外币币种 value:兑换美元的率
        var signCurrencyCodeObj = {};

        // model.get("actuals").each(function(actual,index){

        //     var signCurrencyCode = actual.get("signCurrencyCode");//币种
        //     var premium = actual.get("premium");//签单币总保费

        //     if(signCurrencyCode == 'CNY'){

        //         if(premium > 10000){
        //             rCnt++;
        //         }

        //     }else{

        //         //兑换率预先设置为无意义0
        //         signCurrencyCodeObj[signCurrencyCode] = 0;
        //         premiumToUSDArr.push({premium: premium, signCurrencyCode: signCurrencyCode});

        //     }

        // });
        //如果人民币保费超过一万的没有，再判断外币
        if(rCnt == 0 ){
            
            //避免传入重复的外币币种
            for( key in signCurrencyCodeObj){
                exchangeList.push({exchCurrency: key, baseCurrency: 'USD'});
            }

            if(exchangeList.length > 0){

                var exchangeobj = {};
                exchangeobj.rateFlag = 1;
                exchangeobj.exchangeList = exchangeList;

                $.ajax({
                    url: "controller/exchange/findExchange",
                    type: "POST",
                    async: false,
                    contentType: "application/json",
                    data: JSON.stringify(exchangeobj),
                    success: function (data) {

                        //将兑换率赋值给外币币种的key
                        for(var i = 0; i < data.length; i++){
                            signCurrencyCodeObj[data[i].exchCurrency]=data[i].exchRate;
                        }

                        //遍历所有外币保费的产品，转换为美元，超过1000美元弹出用户身份识别提示
                        premiumToUSDArr.forEach(function (premiumToUSD) {
                            if(premiumToUSD.premium * signCurrencyCodeObj[premiumToUSD.signCurrencyCode] > 1000 ){

                                fCnt++;
                            }
                        });

                    }
                });
            }
        }
    }
    debugger;
    
    $.ajax({
        url: "controller/risksurvey/ecifClient/getCustomer?sysId=B102&interruptFlag=1&customerType=" + customerType,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify({
            partyRegistrationKeyInfo: {
                idNo: identityNum,
                idType: identityType,
                idName: customerName
            }
        }),
        success: function (data) {
        	debugger;
            var customerDetailObj = {}, customerDetailArr = [];
            if (data.responseCode != 1) {//没有数据时显示模块
                cola.NotifyTipManager.warning({
                    message: "",
                    description: "未查询到相关数据",
                    showDuration: 3000
                });
                debugger;
                if (customerType == "1") {
                    debugger
                    //投保人代码
                    if (applicant.dataType && (applicant.dataType.get("name") == "PlcApplicant" || applicant.dataType.get("name") == "PageInsurance")) {//投保个人显示
                        App.setFieldVisible($(".grpCustomerApplicant").eq(activeIndex), false, true);
                        App.setFieldVisible($(".selfCustomerApplicant").eq(activeIndex), true, false);
                        $('.checkboxApp').eq(activeIndex).removeClass('checked').children('input').removeAttr('checked');
                        $('.imgVip').eq(activeIndex).addClass('display-none');
                        $('.card').eq(activeIndex).addClass('display-none');
                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcInsurant") {//被保个人显示
                        $('.imgVipbbr').eq(activeIndex).addClass('display-none');
                        $('.cardbbr').eq(activeIndex).addClass('display-none');
                        $('.checkboxinsurant').eq(activeIndex).removeClass('checked').children('input').removeAttr('checked');
                        App.setFieldVisible($(".grpCustomer").eq(activeIndex), false, true);
                        App.setFieldVisible($(".selfCustomer").eq(activeIndex), true, false);
                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".workTypeSmallClass"),false);
                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".thirdOperationCode"),false);
                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategoryName"),true);
                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".businessSort"),true);
                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcCarowners") {
                        App.setFieldVisible($(".selfplcCarowners").eq(activeIndex), true, false);
                        App.setFieldVisible($(".grpplcCarowners").eq(activeIndex), false, true)
                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcGuardian") {
                        App.setFieldVisible($(".selfplcGuardian").eq(activeIndex), true, false);
                        App.setFieldVisible($(".grpplcGuardian").eq(activeIndex), false, true)
                    }
                    applicant.set("customerCode", null);
                    applicant.set("registId", null);
                    applicant.set("citizenship", "CHN");
                    applicant.set("citizenshipName", "中国");
                    applicant.set("isWithinForeign", "1");
                    //applicant.set("address", null);
                    applicant.set("email", null);
                    applicant.set("post", null);
                    applicant.set("mobile", null);
                    applicant.set("phoneNumber", null);
                    //applicant.set("identifyEffectiveEndDate", null);
                } else {
                    applicant.set("registyAddress", null);
                    applicant.set("linkerMobile", null);
                    applicant.set("linkerPhoneNo", null);
                    applicant.set("linkerName", null);
                    applicant.set("customerCode", null);
                    if (applicant.dataType && (applicant.dataType.get("name") == "PlcApplicant" || applicant.dataType.get("name") == "PageInsurance")) {
                        $('.imgVip').eq(activeIndex).addClass('display-none');
                        $('.card').eq(activeIndex).addClass('display-none');
                        App.setFieldVisible($(".grpCustomerApplicant").eq(activeIndex), true, false);
                        App.setFieldVisible($(".selfCustomerApplicant").eq(activeIndex), false, true)
                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcInsurant") {
                        $('.imgVipbbr').eq(activeIndex).addClass('display-none');
                        $('.cardbbr').eq(activeIndex).addClass('display-none');
                        App.setFieldVisible($(".grpCustomer").eq(activeIndex), true, false);
                        App.setFieldVisible($(".selfCustomer").eq(activeIndex), false, true)
                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".workTypeSmallClass"),true);
                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".thirdOperationCode"),true);
                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategoryName"),false);
                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".businessSort"),false);
                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcCarowners") {
                        App.setFieldVisible($(".grpplcCarowners").eq(activeIndex), true, false);
                        App.setFieldVisible($(".selfplcCarowners").eq(activeIndex), false, true)
                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcGuardian") {
                        App.setFieldVisible($(".grpplcGuardian").eq(activeIndex), true, false);
                        App.setFieldVisible($(".selfplcGuardian").eq(activeIndex), false, true)
                    }
                }
            } else {
                if (data.ifMulti == "1") { //多条数据的时候
                    if (customerType == "1") {
                        for (var i = 0; i < data.individualListResponses.length; i++) {
                            customerDetailObj = {};
                            customerDetailObj.idno = data.individualListResponses[i].idno ? data.individualListResponses[i].idno : "";
                            customerDetailObj.partyId = data.individualListResponses[i].partyId ? data.individualListResponses[i].partyId : "";
                            customerDetailObj.partyTypeCode = data.individualListResponses[i].partyTypeCode ? data.individualListResponses[i].partyTypeCode : "";
                            customerDetailObj.idname = data.individualListResponses[i].idname ? data.individualListResponses[i].idname : "";
                            customerDetailObj.idtypeCode = data.individualListResponses[i].idtypeCode ? data.individualListResponses[i].idtypeCode : "";
                            customerDetailObj.customerGender = data.individualListResponses[i].customerGender ? data.individualListResponses[i].customerGender : "";
                            if (data.individualListResponses[i].customerStatus) {
                                if (data.individualListResponses[i].customerStatus == '1') {
                                    customerDetailObj.customerStatus = '准客户';
                                    customerDetailObj.customerTypes = 1;
                                } else if (data.individualListResponses[i].customerStatus == '2') {
                                    customerDetailObj.customerStatus = '在司客户';
                                    customerDetailObj.customerTypes = 2;
                                } else if (data.individualListResponses[i].customerStatus == '3') {
                                    customerDetailObj.customerStatus = '流失客户';
                                    customerDetailObj.customerTypes = 3;
                                }
                            }
                            //customerDetailObj.customerStatus = data.individualListResponses[i].customerStatus ? data.individualListResponses[i].customerStatus:"";
                            customerDetailArr.identityType = identityType;
                            customerDetailArr.push(customerDetailObj);
                        }
                        //console.log(customerDetailArr)
                        model.set("customerDetailArr", customerDetailArr);
                        if (targetType == 1) {
                            cola.widget("dialog1").show();
                            model.$("#dialog1 table").find("th").eq(6).show();
                        } else if (targetType == 2) {
                            cola.widget('dialog2').show();
                            model.$("#dialog2 table").find("th").eq(6).show();
                        } 
                    } else {
                        if(rCnt > 0 || fCnt > 0){
                            applicant.set("organizationName","企业");
                            applicant.set("organizationType","3")
                        }
                        for (var i = 0; i < data.orgnizationListResponses.length; i++) {
                            customerDetailObj = {};
                            customerDetailObj.partyId = data.orgnizationListResponses[i].partyId ? data.orgnizationListResponses[i].partyId : "";
                            customerDetailObj.idname = data.orgnizationListResponses[i].idname ? data.orgnizationListResponses[i].idname : "";
                            customerDetailObj.idno = data.orgnizationListResponses[i].idno ? data.orgnizationListResponses[i].idno : "";
                            customerDetailObj.customerGender = data.orgnizationListResponses[i].customerGender ? data.orgnizationListResponses[i].customerGender : "";
                            if (data.orgnizationListResponses[i].customerStatus) {
                                if (data.orgnizationListResponses[i].customerStatus == '1') {
                                    customerDetailObj.customerStatus = '准客户';
                                    customerDetailObj.customerTypes = 1;
                                } else if (data.orgnizationListResponses[i].customerStatus == '2') {
                                    customerDetailObj.customerStatus = '在司客户';
                                    customerDetailObj.customerTypes = 2;
                                } else if (data.orgnizationListResponses[i].customerStatus == '3') {
                                    customerDetailObj.customerStatus = '流失客户';
                                    customerDetailObj.customerTypes = 3;
                                }
                            }
                            //customerDetailObj.customerStatus = data.orgnizationListResponses[i].customerStatus ? data.orgnizationListResponses[i].customerStatus:"";
                            customerDetailArr.identityType = identityType;
                            customerDetailArr.push(customerDetailObj);
                        }
                        model.set("customerDetailArr", customerDetailArr);
                        if (applicant.dataType && (applicant.dataType.get("name") == "PlcApplicant" || applicant.dataType.get("name") == "PageInsurance")) {
                            cola.widget("dialog1").show()
                            model.$("#dialog1 table").find("th").eq(6).hide();
                            
                        } else if (applicant.dataType && applicant.dataType.get("name") == "PlcInsurant") {
                            cola.widget("dialog2").show();
                            model.$("#dialog2 table").find("th").eq(6).hide();
                            contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".workTypeSmallClass"),true);
                            contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".thirdOperationCode"),true);
                            contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategoryName"),false);
                        } else if (applicant.dataType && applicant.dataType.get("name") == "PlcCarowners") {
                            cola.widget("dialog3").show();
                            model.$("#dialog3 table").find("th").eq(6).hide();
                        } else if (applicant.dataType && applicant.dataType.get("name") == "PlcGuardian") {
                            cola.widget("dialog4").show();
                            model.$("#dialog4 table").find("th").eq(6).hide();
                        }
                        //cola.widget("dialog1").show()
                    }
                } else {   //单条数据的时候


                    if (customerType == "1") {
                        applicant.set("customerTypeName","个人");
                        //出生日期
                        applicant.set("birthDate", data.individualResponse.birthDate ? data.individualResponse.birthDate : "");
                        //年龄
                        applicant.set("age", data.individualResponse.age ? data.individualResponse.age : "")

                        //性别
                        applicant.set("sex", data.individualResponse.sex ? data.individualResponse.sex : "");
                        //投保人代码
                        applicant.set("customerCode", data.individualResponse.customerCode ? data.individualResponse.customerCode : null)

                        //客户姓名
                        applicant.set("customerName", data.individualResponse.idname ? data.individualResponse.idname : "")
                        //证件号码
                        applicant.set("identifyNumber", data.individualResponse.idno ? data.individualResponse.idno : "")
                        //证件截止日期
                        applicant.set("identifyEffectiveEndDate", data.individualResponse.identityEffetiveEndDate ? data.individualResponse.identityEffetiveEndDate : "");

                        //邮编
                        applicant.set("post", data.individualResponse.post ? data.individualResponse.post : "")
                        //获取国家和地区
                        applicant.set("address", data.individualResponse.address ? data.individualResponse.address : "")
                        applicant.set("citizenship", data.individualResponse.countryCode ? data.individualResponse.countryCode : "CHN")
                        //境外标识
                        applicant.set("isWithinForeign", data.individualResponse.isWithinForeign ? data.individualResponse.isWithinForeign : "1")

                        //手机号码
                        applicant.set("mobile", data.individualResponse.mobile ? data.individualResponse.mobile : "");
                        //座机
                        applicant.set("phoneNumber", data.individualResponse.phoneNumber ? data.individualResponse.phoneNumber : "");
                        if(data.individualResponse.mobileRepeatNo){
                            if(data.individualResponse.mobileRepeatNo>1){
                                App.alert("系统中已存在"+data.individualResponse.mobileRepeatNo+"个相同的手机号码"+data.individualResponse.mobile+"!");
                            }
                        }
                        if(data.individualResponse.phoneNumberRepeatNo){
                            if(data.individualResponse.phoneNumberRepeatNo>1){
                                App.alert("系统中已存在"+data.individualResponse.phoneNumberRepeatNo+"个相同的号码"+data.individualResponse.phoneNumber+"!");
                            }
                        }
                        //客户等级
                        applicant.set("customerGrade", data.individualResponse.customerGrade ? data.individualResponse.customerGrade : "")
                        //客户风险等级
                        //applicant.set("customerRiskGrade", data.individualResponse.autoRiskLevelCode ? data.individualResponse.autoRiskLevelCode : "");
                        var riskgred='';
                        if(data.individualResponse.manualRiskLevelCode && data.individualResponse.autoRiskLevelCode){
                            if(data.individualResponse.manualRiskLevelCode == "4"){
                                riskgred = data.individualResponse.manualRiskLevelCode;
                            } else if(data.individualResponse.autoRiskLevelCode == "4"){
                                riskgred = data.individualResponse.autoRiskLevelCode;
                            } else {
                                riskgred = data.individualResponse.manualRiskLevelCode*1 < data.individualResponse.autoRiskLevelCode*1 ?
                                    data.individualResponse.manualRiskLevelCode : data.individualResponse.autoRiskLevelCode
                            }
                            applicant.set("customerRiskGrade", riskgred);
                        }else if(data.individualResponse.manualRiskLevelCode){
                            riskgred = data.individualResponse.manualRiskLevelCode;
                            applicant.set("customerRiskGrade", data.individualResponse.manualRiskLevelCode ? data.individualResponse.manualRiskLevelCode : null);
                        }else if(data.individualResponse.autoRiskLevelCode){
                            riskgred = data.individualResponse.autoRiskLevelCode;
                            applicant.set("customerRiskGrade", data.individualResponse.autoRiskLevelCode ? data.individualResponse.autoRiskLevelCode : null);
                        }
                        if(riskgred){
                            switch(riskgred){
                                case "1":
                                    applicant.set("customerRiskGradeName", "高");
                                    break;
                                case "2":
                                    applicant.set("customerRiskGradeName", "中");
                                    break;
                                case "3":
                                    applicant.set("customerRiskGradeName", "低");
                                    break;
                                case "4":
                                    applicant.set("customerRiskGradeName", "禁止");
                                    App.alert("客户风险等级为禁止，不能承保");
                                    break;
                                default:
                                    applicant.set("customerRiskGradeName", "");
                                    break;
                            }
                        }
                        //证件识别Id
                        applicant.set("registId", data.individualResponse.registId ? data.individualResponse.registId : null);
                        //邮箱
                        applicant.set("email", data.individualResponse.email ? data.individualResponse.email : "")
                        if (targetType == 1) {
                            App.setFieldVisible($(".grpCustomerApplicant").eq(activeIndex), false, true);
                            App.setFieldVisible($(".selfCustomerApplicant").eq(activeIndex), true, false);
                            var dataa = data.individualResponse.identityEffetiveEndDate;
                            if(dataa){
                                var indexa = activeIndex+1;
                                if(dataa.indexOf("2999")!=-1){
                                    $('.dateOne'+indexa).css('pointerEvents','none').children('input').attr('readonly',true).css('background-color','#fbfbfb');
                                    //$('.checkboxApp').eq(activeIndex).addClass('checked').children('input').attr('checked',true);
                                    model.$(".checkboxApp").addClass('checked').children('input').attr('checked',true);
                                    applicant.set("longtermEffectiveFlag", "1");
                                }else{
                                    $('.dateOne'+indexa).css('pointerEvents','').children('input').removeAttr('readonly').css('background-color','');
                                    //$('.checkboxApp').eq(activeIndex).removeClass('checked').children('input').removeAttr('checked');
                                    model.$(".checkboxApp").removeClass('checked').children('input').removeAttr('checked');
                                    applicant.set("longtermEffectiveFlag", "0");
                                }
                            }
                            if(data.individualResponse.customerGrade){
                                switch(data.individualResponse.customerGrade){
                                    case "1":
                                        $('.card').eq(activeIndex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
                                        applicant.set("customerGradeName", "钻石卡");
                                        break;
                                    case "2":
                                        $('.card').eq(activeIndex).attr('src','resources/images/gold_card.png').removeClass('display-none');
                                        applicant.set("customerGradeName", "金卡");
                                        break;
                                    case "3":
                                        $('.card').eq(activeIndex).attr('src','resources/images/silver_card.png').removeClass('display-none');
                                        applicant.set("customerGradeName", "银卡");
                                        break;
                                    case "4":
                                        $('.card').eq(activeIndex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
                                        applicant.set("customerGradeName", "贵宾卡");
                                        break;
                                    default:
                                        $('.card').eq(activeIndex).addClass('display-none');
                                        applicant.set("customerGradeName", "普通客户");
                                        break;
                                }
                            }

                        } else if (targetType == 2) {
                            var dataa = data.individualResponse.identityEffetiveEndDate;
                            if(dataa){
                                var indexa = activeIndex+1;
                                if(dataa.indexOf("2999")!=-1){
                                    $('.dateTwo'+indexa).css('pointerEvents','none').children('input').attr('readonly',true).css('background-color','#fbfbfb');
                                    //$('.checkboxApp').eq(activeIndex).addClass('checked').children('input').attr('checked',true);
                                    model.$(".checkboxinsurant").addClass('checked').children('input').attr('checked',true);
                                    applicant.set("longtermEffectiveFlag", "1");
                                }else{
                                    $('.dateTwo'+indexa).css('pointerEvents','').children('input').removeAttr('readonly').css('background-color','');
                                    //$('.checkboxApp').eq(activeIndex).removeClass('checked').children('input').removeAttr('checked');
                                    model.$(".checkboxinsurant").removeClass('checked').children('input').removeAttr('checked');
                                    applicant.set("longtermEffectiveFlag", "0");
                                }
                            }

                            if(data.individualResponse.customerGrade){
                                switch(data.individualResponse.customerGrade){
                                    case "1":
                                        $('.cardbbr').eq(activeIndex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
                                        applicant.set("customerGradeName", "钻石卡");
                                        break;
                                    case "2":
                                        $('.cardbbr').eq(activeIndex).attr('src','resources/images/gold_card.png').removeClass('display-none');
                                        applicant.set("customerGradeName", "金卡");
                                        break;
                                    case "3":
                                        $('.cardbbr').eq(activeIndex).attr('src','resources/images/silver_card.png').removeClass('display-none');
                                        applicant.set("customerGradeName", "银卡");
                                        break;
                                    case "4":
                                        $('.cardbbr').eq(activeIndex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
                                        applicant.set("customerGradeName", "贵宾卡");
                                        break;
                                    default:
                                        $('.cardbbr').eq(activeIndex).addClass('display-none');
                                        applicant.set("customerGradeName", "普通客户");
                                        break;
                                }
                            }
                            App.setFieldVisible($(".grpCustomer").eq(activeIndex), false, true);
                            App.setFieldVisible($(".selfCustomer").eq(activeIndex), true, false)
                            contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".workTypeSmallClass"),false);
                            contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".thirdOperationCode"),false);
                            contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategoryName"),true);
                            contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".businessSort"),true);
                        } else if (applicant.dataType && applicant.dataType.get("name") == "PlcCarowners") {
                            App.setFieldVisible($(".selfplcCarowners").eq(activeIndex), true, false);
                            App.setFieldVisible($(".grpplcCarowners").eq(activeIndex), false, true)
                        } else if (applicant.dataType && applicant.dataType.get("name") == "PlcGuardian") {
                            App.setFieldVisible($(".selfplcGuardian").eq(activeIndex), true, false);
                            App.setFieldVisible($(".grpplcGuardian").eq(activeIndex), false, true)
                        }


                    } else { //组织单条
                        applicant.set("customerTypeName","组织");
                        if(rCnt > 0 || fCnt > 0){
                            applicant.set("organizationName","企业");
                            applicant.set("organizationType","3")
                        }
                        //客户ID
                        applicant.set("customerCode", data.orgnizationResponse.customerCode ? data.orgnizationResponse.customerCode : null)

                        //客户姓名
                        applicant.set("customerName", data.orgnizationResponse.customerName ? data.orgnizationResponse.customerName : "")
                        //联系人名称
                        applicant.set("linkerName", data.orgnizationResponse.linkerName ? data.orgnizationResponse.linkerName : "")
                        //联系人手机
                        applicant.set("linkerMobile", data.orgnizationResponse.linkerMobile ? data.orgnizationResponse.linkerMobile : "")
                        //联系人固话
                        applicant.set("linkerPhoneNo", data.orgnizationResponse.linkerPhoneNo ? data.orgnizationResponse.linkerPhoneNo : "");

                       /*后续联系方式使用下方三个字段，需要打印修改，数据清洗
                       //地址
                        applicant.set("linkerAddress", data.orgnizationResponse.mailAddress ? data.orgnizationResponse.mailAddress : "");
                        //邮政编码
                        applicant.set("linkerPost", data.orgnizationResponse.mailAddressPost ? data.orgnizationResponse.mailAddressPost : "");
                        //邮箱
                        applicant.set("linkerEmail", data.orgnizationResponse.email ? data.orgnizationResponse.email : "");*/

                        //注册地址
                        applicant.set("registyAddress", data.orgnizationResponse.registyAddress ? data.orgnizationResponse.registyAddress : "")
                        //邮编后续需要更换
                        applicant.set("mailAddressPost", data.orgnizationResponse.mailAddressPost ? data.orgnizationResponse.mailAddressPost : "")
                        //客户等级
                        applicant.set("customerGrade", data.orgnizationResponse.customerGrade ? data.orgnizationResponse.customerGrade : "");
                        //证件识别Id
                        applicant.set("registId", data.orgnizationResponse.registId ? data.orgnizationResponse.registId : null);

                        /*从plcapplicant中移植过来缺少的字段start*/

                        applicant.set("customerEName", data.orgnizationResponse.customerEName ? data.orgnizationResponse.customerEName : null);
                        applicant.set("organizationType", data.orgnizationResponse.organizationType ? data.orgnizationResponse.organizationType : null);
                        if(rCnt > 0 || fCnt > 0){
                            applicant.set("organizationType","3")
                        }
                        //映射value
                        var organizationList=cola.util.dictionary("OrgnizationType(FXQ)");
                        organizationList.forEach(function(_item){
                            if(_item.key==data.orgnizationResponse.organizationType){
                                applicant.set("organizationName", _item.value);
                            }
                        });
                        applicant.set("organizationSecondType", data.orgnizationResponse.economicTypeCode ? data.orgnizationResponse.economicTypeCode : null);
                        applicant.set("identifyEffectiveStartDate", data.orgnizationResponse.identityEffetiveStartDate ? data.orgnizationResponse.identityEffetiveStartDate : null);
                        applicant.set("identifyEffectiveEndDate", data.orgnizationResponse.identityEffetiveEndDate ? data.orgnizationResponse.identityEffetiveEndDate : null);
                        applicant.set("isLink", data.orgnizationResponse.isLink ? data.orgnizationResponse.isLink : null);
                        applicant.set("industryCategory", data.orgnizationResponse.industryCategory ? data.orgnizationResponse.industryCategory : null);
                        //映射value
                        var industryList=cola.util.dictionary("IndustryBigClass");
                        industryList.forEach(function(_item){
                            if(_item.key==data.orgnizationResponse.industryCategory){
                                applicant.set("industryCategoryName", _item.value);
                            }
                        });
                        applicant.set("mainBussiness", data.orgnizationResponse.mainBusiness ? data.orgnizationResponse.mainBusiness : null);
                        applicant.set("registeredPlaceCode", data.orgnizationResponse.registeredPlaceCode ? data.orgnizationResponse.registeredPlaceCode : null);
                        applicant.set("busiLicense", data.orgnizationResponse.busilicense ? data.orgnizationResponse.busilicense : null);
                        applicant.set("busiLicenseStartDate", data.orgnizationResponse.busiLicenseStartDate ? data.orgnizationResponse.busiLicenseStartDate : null);
                        applicant.set("busiLicenseEndDate", data.orgnizationResponse.busiLicenseEndDate ? data.orgnizationResponse.busiLicenseEndDate : null);
                        applicant.set("taxRegistrationNo", data.orgnizationResponse.taxregistrationNo ? data.orgnizationResponse.taxregistrationNo : null);
                        //后续需要更换
                        applicant.set("email", data.orgnizationResponse.email ? data.orgnizationResponse.email : null);
                        applicant.set("facsimile", data.orgnizationResponse.facsimile ? data.orgnizationResponse.facsimile : null);
                        //后续需要更换
                        applicant.set("mailAddress", data.orgnizationResponse.mailAddress ? data.orgnizationResponse.mailAddress : null);

                        /*从plcapplicant中移植过来缺少的字段end*/
                        var riskgred='';
                        if(data.orgnizationResponse.manualRiskLevelCode && data.orgnizationResponse.autoRiskLevelCode){
                            if(data.orgnizationResponse.manualRiskLevelCode == "4"){
                                riskgred = data.orgnizationResponse.manualRiskLevelCode;
                            } else if(data.orgnizationResponse.autoRiskLevelCode == "4"){
                                riskgred = data.orgnizationResponse.autoRiskLevelCode;
                            } else {
                                riskgred = data.orgnizationResponse.manualRiskLevelCode*1 < data.orgnizationResponse.autoRiskLevelCode*1 ?
                                    data.orgnizationResponse.manualRiskLevelCode : data.orgnizationResponse.autoRiskLevelCode
                            }
                            applicant.set("customerRiskGrade", riskgred);
                        }else if(data.orgnizationResponse.manualRiskLevelCode){
                            riskgred = data.orgnizationResponse.manualRiskLevelCode;
                            applicant.set("customerRiskGrade", data.orgnizationResponse.manualRiskLevelCode ? data.orgnizationResponse.manualRiskLevelCode : null);
                        }else if(data.orgnizationResponse.autoRiskLevelCode){
                            riskgred = data.orgnizationResponse.autoRiskLevelCode;
                            applicant.set("customerRiskGrade", data.orgnizationResponse.autoRiskLevelCode ? data.orgnizationResponse.autoRiskLevelCode : null);
                        }
                        if(riskgred){
                            switch(riskgred){
                                case "1":
                                    applicant.set("customerRiskGradeName", "高");
                                    break;
                                case "2":
                                    applicant.set("customerRiskGradeName", "中");
                                    break;
                                case "3":
                                    applicant.set("customerRiskGradeName", "低");
                                    break;
                                case "4":
                                    applicant.set("customerRiskGradeName", "禁止");
                                    App.alert("客户风险等级为禁止，不能承保");
                                    break;
                                default:
                                    applicant.set("customerRiskGradeName", "");
                                    break;
                            }
                        }
                        if (targetType == 1) {
                            // $('.imgVip').eq(activeIndex).attr("src", "resources/images/VIP3.png").removeClass('display-none')
                            // $('.card').eq(activeIndex).removeClass('display-none')
                            if(data.orgnizationResponse.customerGrade){
                                switch(data.orgnizationResponse.customerGrade){
                                    case "1":
                                        $('.card').eq(activeIndex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
                                        applicant.set("customerGradeName", "钻石卡");
                                        break;
                                    case "2":
                                        $('.card').eq(activeIndex).attr('src','resources/images/gold_card.png').removeClass('display-none');
                                        applicant.set("customerGradeName", "金卡");
                                        break;
                                    case "3":
                                        $('.card').eq(activeIndex).attr('src','resources/images/silver_card.png').removeClass('display-none');
                                        applicant.set("customerGradeName", "银卡");
                                        break;
                                    case "4":
                                        $('.card').eq(activeIndex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
                                        applicant.set("customerGradeName", "贵宾卡");
                                        break;
                                    default:
                                        $('.card').eq(activeIndex).addClass('display-none');
                                        applicant.set("customerGradeName", "普通客户");
                                        break;
                                }
                            }
                            var ImgNums;
                            if(data.orgnizationResponse.manualVIPLevelCode){
                                ImgNums = data.orgnizationResponse.manualVIPLevelCode;
                                //重客等级
                                applicant.set("mainCustomerGrade", data.orgnizationResponse.manualVIPLevelCode ? data.orgnizationResponse.manualVIPLevelCode : null)
                            }else if(data.orgnizationResponse.autoVIPLevelCode){
                                ImgNums =data.orgnizationResponse.autoVIPLevelCode;
                                //重客等级
                                applicant.set("mainCustomerGrade", data.orgnizationResponse.autoVIPLevelCode ? data.orgnizationResponse.autoVIPLevelCode : null)
                            }
                            if(ImgNums){
                                switch(ImgNums){
                                    case "1":
                                        $('.imgVip').eq(activeIndex).attr('src','resources/images/VIP1.png').removeClass('display-none');
                                        break;
                                    case "2":
                                        $('.imgVip').eq(activeIndex).attr('src','resources/images/VIP2.png').removeClass('display-none');
                                        break;
                                    case "3":
                                        $('.imgVip').eq(activeIndex).attr('src','resources/images/VIP3.png').removeClass('display-none');
                                        break;
                                    default:
                                        $('.imgVip').eq(activeIndex).addClass('display-none');
                                        break;
                                }
                            }

                            App.setFieldVisible($(".grpCustomerApplicant").eq(activeIndex), true, false);
                            App.setFieldVisible($(".selfCustomerApplicant").eq(activeIndex), false, true)
                        } else if (targetType == 2) {
                            // $('.imgVipbbr').eq(activeIndex).attr("src", "resources/images/VIP3.png").removeClass('display-none')
                            // $('.cardbbr').eq(activeIndex).removeClass('display-none')
                            if(data.orgnizationResponse.customerGrade){
                                switch(data.orgnizationResponse.customerGrade){
                                    case "1":
                                        $('.cardbbr').eq(activeIndex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
                                        applicant.set("customerGradeName", "钻石卡");
                                        break;
                                    case "2":
                                        $('.cardbbr').eq(activeIndex).attr('src','resources/images/gold_card.png').removeClass('display-none');
                                        applicant.set("customerGradeName", "金卡");
                                        break;
                                    case "3":
                                        $('.cardbbr').eq(activeIndex).attr('src','resources/images/silver_card.png').removeClass('display-none');
                                        applicant.set("customerGradeName", "银卡");
                                        break;
                                    case "4":
                                        $('.cardbbr').eq(activeIndex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
                                        applicant.set("customerGradeName", "贵宾卡");
                                        break;
                                    default:
                                        $('.cardbbr').eq(activeIndex).addClass('display-none');
                                        applicant.set("customerGradeName", "普通客户");
                                        break;
                                }
                            }
                            var ImgNums;
                            if(data.orgnizationResponse.manualVIPLevelCode){
                                ImgNums = data.orgnizationResponse.manualVIPLevelCode;
                                //重客等级
                                applicant.set("mainCustomerGrade", data.orgnizationResponse.manualVIPLevelCode ? data.orgnizationResponse.manualVIPLevelCode : null)
                            }else if(data.orgnizationResponse.autoVIPLevelCode){
                                ImgNums =data.orgnizationResponse.autoVIPLevelCode;
                                //重客等级
                                applicant.set("mainCustomerGrade", data.orgnizationResponse.autoVIPLevelCode ? data.orgnizationResponse.autoVIPLevelCode : null)
                            }
                            if(ImgNums){
                                switch(ImgNums){
                                    case "1":
                                        $('.imgVipbbr').eq(activeIndex).attr('src','resources/images/VIP1.png').removeClass('display-none');
                                        break;
                                    case "2":
                                        $('.imgVipbbr').eq(activeIndex).attr('src','resources/images/VIP2.png').removeClass('display-none');
                                        break;
                                    case "3":
                                        $('.imgVipbbr').eq(activeIndex).attr('src','resources/images/VIP3.png').removeClass('display-none');
                                        break;
                                    default:
                                        $('.imgVipbbr').eq(activeIndex).addClass('display-none');
                                        break;
                                }
                            }
                            console.log("applicant is :", applicant);
                            App.setFieldVisible($(".grpCustomer").eq(activeIndex), true, false);
                            App.setFieldVisible($(".selfCustomer").eq(activeIndex), false, true)
                            contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".workTypeSmallClass"),true);
                            contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".thirdOperationCode"),true);
                            contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategoryName"),false);
                            contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industrySCategory"),false);
                            contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industrySCategoryName"),false);
                            contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryTCategory"),false);
                            contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryTCategoryName"),false);
                            contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategory"),false);
                            contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".businessSort"),false);
                        } else if (applicant.dataType && applicant.dataType.get("name") == "PlcCarowners") {
                            App.setFieldVisible($(".selfplcCarowners").eq(activeIndex), false, true);
                            App.setFieldVisible($(".grpplcCarowners").eq(activeIndex), true, false)
                        } else if (applicant.dataType && applicant.dataType.get("name") == "PlcGuardian") {
                            App.setFieldVisible($(".selfplcGuardian").eq(activeIndex), false, true);
                            App.setFieldVisible($(".grpplcGuardian").eq(activeIndex), true, false)
                        }

                    }
                }
            }
            if (customerType == "1"){
                if(identityType === "10" || identityType === "19" || identityType === "23" ){
                    applicant.set("isWithinForeign", "0");
                } else {
                    applicant.set("isWithinForeign", "1");
                }
            }

        },
        error: function (e) {
            console.log(e)
        }
    })
};

ContractEntity.prototype.portInsurant = function (model, applicant, activeIndex) {
	var identityNum = applicant.get("identifyNumber");//证件号码
	var identityType = applicant.get("identifyType");//证件类型
	var customerType = applicant.get("customerType");//关系人类型
	var customerName = applicant.get("customerName");//证件名称
	// if(customerType=="1"){
	//     var customerName = "";
	// }else{
	    //var customerName = applicant.get("customerName");//证件名称
	//}
	debugger;
	
	if(customerType==="2"){
	    //临时计算判断使用
	    var rCnt= 0; //人民币超过10000的个数
	    var fCnt= 0; //外币超过1000美元的个数
	
	    var exchangeList = [];
	    var premiumToUSDArr =[];
	    //key:外币币种 value:兑换美元的率
	    var signCurrencyCodeObj = {};
	
	    model.get("actuals").each(function(actual,index){
	
	        var signCurrencyCode = actual.get("signCurrencyCode");//币种
	        var premium = actual.get("premium");//签单币总保费
	
	        if(signCurrencyCode == 'CNY'){
	
	            if(premium > 10000){
	                rCnt++;
	            }
	
	        }else{
	
	            //兑换率预先设置为无意义0
	            signCurrencyCodeObj[signCurrencyCode] = 0;
	            premiumToUSDArr.push({premium: premium, signCurrencyCode: signCurrencyCode});
	
	        }
	
	    });
	    //如果人民币保费超过一万的没有，再判断外币
	    if(rCnt == 0 ){
	        
	        //避免传入重复的外币币种
	        for( key in signCurrencyCodeObj){
	            exchangeList.push({exchCurrency: key, baseCurrency: 'USD'});
	        }
	
	        if(exchangeList.length > 0){
	
	            var exchangeobj = {};
	            exchangeobj.rateFlag = 1;
	            exchangeobj.exchangeList = exchangeList;
	
	            $.ajax({
	                url: "controller/exchange/findExchange",
	                type: "POST",
	                async: false,
	                contentType: "application/json",
	                data: JSON.stringify(exchangeobj),
	                success: function (data) {
	
	                    //将兑换率赋值给外币币种的key
	                    for(var i = 0; i < data.length; i++){
	                        signCurrencyCodeObj[data[i].exchCurrency]=data[i].exchRate;
	                    }
	
	                    //遍历所有外币保费的产品，转换为美元，超过1000美元弹出用户身份识别提示
	                    premiumToUSDArr.forEach(function (premiumToUSD) {
	                        if(premiumToUSD.premium * signCurrencyCodeObj[premiumToUSD.signCurrencyCode] > 1000 ){
	
	                            fCnt++;
	                        }
	                    });
	
	                }
	            });
	        }
	    }
	}
	debugger;
	
	$.ajax({
	    url: "controller/risksurvey/ecifClient/getCustomer?sysId=B102&interruptFlag=1&customerType=" + customerType,
	    type: "POST",
	    contentType: "application/json",
	    data: JSON.stringify({
	        partyRegistrationKeyInfo: {
	            idNo: identityNum,
	            idType: identityType,
	            idName: customerName
	        }
	    }),
	    success: function (data) {
	    	debugger;
	        var customerDetailObj = {}, customerDetailArr = [];
	        if (data.responseCode != 1) {//没有数据时显示模块
	            cola.NotifyTipManager.warning({
	                message: "",
	                description: "未查询到相关数据",
	                showDuration: 3000
	            });
	            debugger;
	            if (customerType == "1") {
	                //投保人代码
	              if (applicant.dataType && applicant.dataType.get("name") == "PlcInsurant") {//被保个人显示
	                    /*$('.imgVipbbr').eq(activeIndex).addClass('display-none');
	                    $('.cardbbr').eq(activeIndex).addClass('display-none');*/
	                    $('.checkboxinsurant').eq(activeIndex).removeClass('checked').children('input').removeAttr('checked');
	                    App.setFieldVisible($(".grpCustomer").eq(activeIndex), false, true);
	                    App.setFieldVisible($(".selfCustomer").eq(activeIndex), true, false);
	                    contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".workTypeSmallClass"),false);
	                    contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".thirdOperationCode"),false);
	                    contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategoryName"),true);
	                    contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".businessSort"),true);
	                } 
	                applicant.set("customerCode", null);
	                applicant.set("registId", null);
	                applicant.set("citizenship", "CHN");
	                applicant.set("citizenshipName", "中国");
	                applicant.set("isWithinForeign", "1");
	                //applicant.set("address", null);
	                applicant.set("email", null);
	                applicant.set("post", null);
	                applicant.set("mobile", null);
	                applicant.set("phoneNumber", null);
	                //applicant.set("identifyEffectiveEndDate", null);
	            } else {
	                applicant.set("registyAddress", null);
	                applicant.set("linkerMobile", null);
	                applicant.set("linkerPhoneNo", null);
	                applicant.set("linkerName", null);
	                applicant.set("customerCode", null);
	                if (applicant.dataType && (applicant.dataType.get("name") == "PlcApplicant" || applicant.dataType.get("name") == "PageInsurance")) {
	                    $('.imgVip').eq(activeIndex).addClass('display-none');
	                    $('.card').eq(activeIndex).addClass('display-none');
	                    App.setFieldVisible($(".grpCustomerApplicant").eq(activeIndex), true, false);
	                    App.setFieldVisible($(".selfCustomerApplicant").eq(activeIndex), false, true)
	                } else if (applicant.dataType && applicant.dataType.get("name") == "PlcInsurant") {
	                    $('.imgVipbbr').eq(activeIndex).addClass('display-none');
	                    $('.cardbbr').eq(activeIndex).addClass('display-none');
	                    App.setFieldVisible($(".grpCustomer").eq(activeIndex), true, false);
	                    App.setFieldVisible($(".selfCustomer").eq(activeIndex), false, true)
	                    contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".workTypeSmallClass"),true);
	                    contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".thirdOperationCode"),true);
	                    contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategoryName"),false);
	                    contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".businessSort"),false);
	                } else if (applicant.dataType && applicant.dataType.get("name") == "PlcCarowners") {
	                    App.setFieldVisible($(".grpplcCarowners").eq(activeIndex), true, false);
	                    App.setFieldVisible($(".selfplcCarowners").eq(activeIndex), false, true)
	                } else if (applicant.dataType && applicant.dataType.get("name") == "PlcGuardian") {
	                    App.setFieldVisible($(".grpplcGuardian").eq(activeIndex), true, false);
	                    App.setFieldVisible($(".selfplcGuardian").eq(activeIndex), false, true)
	                }
	            }
	        } else {
	            if (data.ifMulti == "1") { //多条数据的时候
	                if (customerType == "1") {
	                    for (var i = 0; i < data.individualListResponses.length; i++) {
	                        customerDetailObj = {};
	                        customerDetailObj.idno = data.individualListResponses[i].idno ? data.individualListResponses[i].idno : "";
	                        customerDetailObj.partyId = data.individualListResponses[i].partyId ? data.individualListResponses[i].partyId : "";
	                        customerDetailObj.partyTypeCode = data.individualListResponses[i].partyTypeCode ? data.individualListResponses[i].partyTypeCode : "";
	                        customerDetailObj.idname = data.individualListResponses[i].idname ? data.individualListResponses[i].idname : "";
	                        customerDetailObj.idtypeCode = data.individualListResponses[i].idtypeCode ? data.individualListResponses[i].idtypeCode : "";
	                        customerDetailObj.customerGender = data.individualListResponses[i].customerGender ? data.individualListResponses[i].customerGender : "";
	                        if (data.individualListResponses[i].customerStatus) {
	                            if (data.individualListResponses[i].customerStatus == '1') {
	                                customerDetailObj.customerStatus = '准客户';
	                                customerDetailObj.customerTypes = 1;
	                            } else if (data.individualListResponses[i].customerStatus == '2') {
	                                customerDetailObj.customerStatus = '在司客户';
	                                customerDetailObj.customerTypes = 2;
	                            } else if (data.individualListResponses[i].customerStatus == '3') {
	                                customerDetailObj.customerStatus = '流失客户';
	                                customerDetailObj.customerTypes = 3;
	                            }
	                        }
	                        //customerDetailObj.customerStatus = data.individualListResponses[i].customerStatus ? data.individualListResponses[i].customerStatus:"";
	                        customerDetailArr.identityType = identityType;
	                        customerDetailArr.push(customerDetailObj);
	                    }
	                    //console.log(customerDetailArr)
	                    model.set("customerDetailArr", customerDetailArr);
	                  if (applicant.dataType && applicant.dataType.get("name") == "PlcInsurant") {
	                        var actualId  = model.get("actual.actualId");
	                        cola.widget('dialogInsurant').show();
	                        
	                        //model.$("#dialogInsurant table").find("th").eq(6).show();
	                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".workTypeSmallClass"),false);
	                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".thirdOperationCode"),false);
	                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategoryName"),true);
	                    } 
	                    //cola.widget("dialog1").show()
	                } else {
	                    if(rCnt > 0 || fCnt > 0){
	                        applicant.set("organizationName","企业");
	                        applicant.set("organizationType","3")
	                    }
	                    for (var i = 0; i < data.orgnizationListResponses.length; i++) {
	                        customerDetailObj = {};
	                        customerDetailObj.partyId = data.orgnizationListResponses[i].partyId ? data.orgnizationListResponses[i].partyId : "";
	                        customerDetailObj.idname = data.orgnizationListResponses[i].idname ? data.orgnizationListResponses[i].idname : "";
	                        customerDetailObj.idno = data.orgnizationListResponses[i].idno ? data.orgnizationListResponses[i].idno : "";
	                        customerDetailObj.customerGender = data.orgnizationListResponses[i].customerGender ? data.orgnizationListResponses[i].customerGender : "";
	                        if (data.orgnizationListResponses[i].customerStatus) {
	                            if (data.orgnizationListResponses[i].customerStatus == '1') {
	                                customerDetailObj.customerStatus = '准客户';
	                                customerDetailObj.customerTypes = 1;
	                            } else if (data.orgnizationListResponses[i].customerStatus == '2') {
	                                customerDetailObj.customerStatus = '在司客户';
	                                customerDetailObj.customerTypes = 2;
	                            } else if (data.orgnizationListResponses[i].customerStatus == '3') {
	                                customerDetailObj.customerStatus = '流失客户';
	                                customerDetailObj.customerTypes = 3;
	                            }
	                        }
	                        //customerDetailObj.customerStatus = data.orgnizationListResponses[i].customerStatus ? data.orgnizationListResponses[i].customerStatus:"";
	                        customerDetailArr.identityType = identityType;
	                        customerDetailArr.push(customerDetailObj);
	                    }
	                    model.set("customerDetailArr", customerDetailArr);
	                    if (applicant.dataType && (applicant.dataType.get("name") == "PlcApplicant" || applicant.dataType.get("name") == "PageInsurance")) {
	                        cola.widget("dialog1").show()
	                        model.$("#dialog1 table").find("th").eq(6).hide();
	                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcInsurant") {
	                        cola.widget("dialog2").show();
	                        model.$("#dialog2 table").find("th").eq(6).hide();
	                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".workTypeSmallClass"),true);
	                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".thirdOperationCode"),true);
	                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategoryName"),false);
	                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcCarowners") {
	                        cola.widget("dialog3").show();
	                        model.$("#dialog3 table").find("th").eq(6).hide();
	                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcGuardian") {
	                        cola.widget("dialog4").show();
	                        model.$("#dialog4 table").find("th").eq(6).hide();
	                    }
	                    //cola.widget("dialog1").show()
	                }
	            } else {   //单条数据的时候
	
	
	                if (customerType == "1") {
	                    applicant.set("customerTypeName","个人");
	                    //出生日期
	                    applicant.set("birthDate", data.individualResponse.birthDate ? data.individualResponse.birthDate : "");
	                    //年龄
	                    applicant.set("age", data.individualResponse.age ? data.individualResponse.age : "")
	
	                    //性别
	                    applicant.set("sex", data.individualResponse.sex ? data.individualResponse.sex : "");
	                    //投保人代码
	                    applicant.set("customerCode", data.individualResponse.customerCode ? data.individualResponse.customerCode : null)
	
	                    //客户姓名
	                    applicant.set("customerName", data.individualResponse.idname ? data.individualResponse.idname : "")
	                    //证件号码
	                    applicant.set("identifyNumber", data.individualResponse.idno ? data.individualResponse.idno : "")
	                    //证件截止日期
	                    applicant.set("identifyEffectiveEndDate", data.individualResponse.identityEffetiveEndDate ? data.individualResponse.identityEffetiveEndDate : "");
	
	                    //邮编
	                    applicant.set("post", data.individualResponse.post ? data.individualResponse.post : "")
	                    //获取国家和地区
	                    applicant.set("address", data.individualResponse.address ? data.individualResponse.address : "")
	                    applicant.set("citizenship", data.individualResponse.countryCode ? data.individualResponse.countryCode : "CHN")
	                    //境外标识
	                    applicant.set("isWithinForeign", data.individualResponse.isWithinForeign ? data.individualResponse.isWithinForeign : "1")
	
	                    //手机号码
	                    applicant.set("mobile", data.individualResponse.mobile ? data.individualResponse.mobile : "");
	                    //座机
	                    applicant.set("phoneNumber", data.individualResponse.phoneNumber ? data.individualResponse.phoneNumber : "");
	                    if(data.individualResponse.mobileRepeatNo){
	                        if(data.individualResponse.mobileRepeatNo>1){
	                            App.alert("系统中已存在"+data.individualResponse.mobileRepeatNo+"个相同的手机号码"+data.individualResponse.mobile+"!");
	                        }
	                    }
	                    if(data.individualResponse.phoneNumberRepeatNo){
	                        if(data.individualResponse.phoneNumberRepeatNo>1){
	                            App.alert("系统中已存在"+data.individualResponse.phoneNumberRepeatNo+"个相同的号码"+data.individualResponse.phoneNumber+"!");
	                        }
	                    }
	                    //客户等级
	                    applicant.set("customerGrade", data.individualResponse.customerGrade ? data.individualResponse.customerGrade : "")
	                    //客户风险等级
	                    //applicant.set("customerRiskGrade", data.individualResponse.autoRiskLevelCode ? data.individualResponse.autoRiskLevelCode : "");
	                    var riskgred='';
	                    if(data.individualResponse.manualRiskLevelCode && data.individualResponse.autoRiskLevelCode){
	                        if(data.individualResponse.manualRiskLevelCode == "4"){
	                            riskgred = data.individualResponse.manualRiskLevelCode;
	                        } else if(data.individualResponse.autoRiskLevelCode == "4"){
	                            riskgred = data.individualResponse.autoRiskLevelCode;
	                        } else {
	                            riskgred = data.individualResponse.manualRiskLevelCode*1 < data.individualResponse.autoRiskLevelCode*1 ?
	                                data.individualResponse.manualRiskLevelCode : data.individualResponse.autoRiskLevelCode
	                        }
	                        applicant.set("customerRiskGrade", riskgred);
	                    }else if(data.individualResponse.manualRiskLevelCode){
	                        riskgred = data.individualResponse.manualRiskLevelCode;
	                        applicant.set("customerRiskGrade", data.individualResponse.manualRiskLevelCode ? data.individualResponse.manualRiskLevelCode : null);
	                    }else if(data.individualResponse.autoRiskLevelCode){
	                        riskgred = data.individualResponse.autoRiskLevelCode;
	                        applicant.set("customerRiskGrade", data.individualResponse.autoRiskLevelCode ? data.individualResponse.autoRiskLevelCode : null);
	                    }
	                    if(riskgred){
	                        switch(riskgred){
	                            case "1":
	                                applicant.set("customerRiskGradeName", "高");
	                                break;
	                            case "2":
	                                applicant.set("customerRiskGradeName", "中");
	                                break;
	                            case "3":
	                                applicant.set("customerRiskGradeName", "低");
	                                break;
	                            case "4":
	                                applicant.set("customerRiskGradeName", "禁止");
	                                App.alert("客户风险等级为禁止，不能承保");
	                                break;
	                            default:
	                                applicant.set("customerRiskGradeName", "");
	                                break;
	                        }
	                    }
	                    //证件识别Id
	                    applicant.set("registId", data.individualResponse.registId ? data.individualResponse.registId : null);
	                    //邮箱
	                    applicant.set("email", data.individualResponse.email ? data.individualResponse.email : "")
	                    if (applicant.dataType && (applicant.dataType.get("name") == "PlcApplicant" || applicant.dataType.get("name") == "PageInsurance")) {
	                        App.setFieldVisible($(".grpCustomerApplicant").eq(activeIndex), false, true);
	                        App.setFieldVisible($(".selfCustomerApplicant").eq(activeIndex), true, false);
	                        var dataa = data.individualResponse.identityEffetiveEndDate;
	                        if(dataa){
	                            var indexa = activeIndex+1;
	                            if(dataa.indexOf("2999")!=-1){
	                                $('.dateOne'+indexa).css('pointerEvents','none').children('input').attr('readonly',true).css('background-color','#fbfbfb');
	                                //$('.checkboxApp').eq(activeIndex).addClass('checked').children('input').attr('checked',true);
	                                model.$(".checkboxApp").addClass('checked').children('input').attr('checked',true);
	                                applicant.set("longtermEffectiveFlag", "1");
	                            }else{
	                                $('.dateOne'+indexa).css('pointerEvents','').children('input').removeAttr('readonly').css('background-color','');
	                                //$('.checkboxApp').eq(activeIndex).removeClass('checked').children('input').removeAttr('checked');
	                                model.$(".checkboxApp").removeClass('checked').children('input').removeAttr('checked');
	                                applicant.set("longtermEffectiveFlag", "0");
	                            }
	                        }
	                        if(data.individualResponse.customerGrade){
	                            switch(data.individualResponse.customerGrade){
	                                case "1":
	                                    $('.card').eq(activeIndex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
	                                    applicant.set("customerGradeName", "钻石卡");
	                                    break;
	                                case "2":
	                                    $('.card').eq(activeIndex).attr('src','resources/images/gold_card.png').removeClass('display-none');
	                                    applicant.set("customerGradeName", "金卡");
	                                    break;
	                                case "3":
	                                    $('.card').eq(activeIndex).attr('src','resources/images/silver_card.png').removeClass('display-none');
	                                    applicant.set("customerGradeName", "银卡");
	                                    break;
	                                case "4":
	                                    $('.card').eq(activeIndex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
	                                    applicant.set("customerGradeName", "贵宾卡");
	                                    break;
	                                default:
	                                    $('.card').eq(activeIndex).addClass('display-none');
	                                    applicant.set("customerGradeName", "普通客户");
	                                    break;
	                            }
	                        }
	
	                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcInsurant") {
	                        var dataa = data.individualResponse.identityEffetiveEndDate;
	                        if(dataa){
	                            var indexa = activeIndex+1;
	                            if(dataa.indexOf("2999")!=-1){
	                                $('.dateTwo'+indexa).css('pointerEvents','none').children('input').attr('readonly',true).css('background-color','#fbfbfb');
	                                //$('.checkboxApp').eq(activeIndex).addClass('checked').children('input').attr('checked',true);
	                                model.$(".checkboxinsurant").addClass('checked').children('input').attr('checked',true);
	                                applicant.set("longtermEffectiveFlag", "1");
	                            }else{
	                                $('.dateTwo'+indexa).css('pointerEvents','').children('input').removeAttr('readonly').css('background-color','');
	                                //$('.checkboxApp').eq(activeIndex).removeClass('checked').children('input').removeAttr('checked');
	                                model.$(".checkboxinsurant").removeClass('checked').children('input').removeAttr('checked');
	                                applicant.set("longtermEffectiveFlag", "0");
	                            }
	                        }
	
	                        if(data.individualResponse.customerGrade){
	                            switch(data.individualResponse.customerGrade){
	                                case "1":
	                                    $('.cardbbr').eq(activeIndex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
	                                    applicant.set("customerGradeName", "钻石卡");
	                                    break;
	                                case "2":
	                                    $('.cardbbr').eq(activeIndex).attr('src','resources/images/gold_card.png').removeClass('display-none');
	                                    applicant.set("customerGradeName", "金卡");
	                                    break;
	                                case "3":
	                                    $('.cardbbr').eq(activeIndex).attr('src','resources/images/silver_card.png').removeClass('display-none');
	                                    applicant.set("customerGradeName", "银卡");
	                                    break;
	                                case "4":
	                                    $('.cardbbr').eq(activeIndex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
	                                    applicant.set("customerGradeName", "贵宾卡");
	                                    break;
	                                default:
	                                    $('.cardbbr').eq(activeIndex).addClass('display-none');
	                                    applicant.set("customerGradeName", "普通客户");
	                                    break;
	                            }
	                        }
	                        App.setFieldVisible($(".grpCustomer").eq(activeIndex), false, true);
	                        App.setFieldVisible($(".selfCustomer").eq(activeIndex), true, false)
	                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".workTypeSmallClass"),false);
	                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".thirdOperationCode"),false);
	                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategoryName"),true);
	                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".businessSort"),true);
	                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcCarowners") {
	                        App.setFieldVisible($(".selfplcCarowners").eq(activeIndex), true, false);
	                        App.setFieldVisible($(".grpplcCarowners").eq(activeIndex), false, true)
	                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcGuardian") {
	                        App.setFieldVisible($(".selfplcGuardian").eq(activeIndex), true, false);
	                        App.setFieldVisible($(".grpplcGuardian").eq(activeIndex), false, true)
	                    }
	
	
	                } else { //组织单条
	                    applicant.set("customerTypeName","组织");
	                    if(rCnt > 0 || fCnt > 0){
	                        applicant.set("organizationName","企业");
	                        applicant.set("organizationType","3")
	                    }
	                    //客户ID
	                    applicant.set("customerCode", data.orgnizationResponse.customerCode ? data.orgnizationResponse.customerCode : null)
	
	                    //客户姓名
	                    applicant.set("customerName", data.orgnizationResponse.customerName ? data.orgnizationResponse.customerName : "")
	                    //联系人名称
	                    applicant.set("linkerName", data.orgnizationResponse.linkerName ? data.orgnizationResponse.linkerName : "")
	                    //联系人手机
	                    applicant.set("linkerMobile", data.orgnizationResponse.linkerMobile ? data.orgnizationResponse.linkerMobile : "")
	                    //联系人固话
	                    applicant.set("linkerPhoneNo", data.orgnizationResponse.linkerPhoneNo ? data.orgnizationResponse.linkerPhoneNo : "");
	
	                   /*后续联系方式使用下方三个字段，需要打印修改，数据清洗
	                   //地址
	                    applicant.set("linkerAddress", data.orgnizationResponse.mailAddress ? data.orgnizationResponse.mailAddress : "");
	                    //邮政编码
	                    applicant.set("linkerPost", data.orgnizationResponse.mailAddressPost ? data.orgnizationResponse.mailAddressPost : "");
	                    //邮箱
	                    applicant.set("linkerEmail", data.orgnizationResponse.email ? data.orgnizationResponse.email : "");*/
	
	                    //注册地址
	                    applicant.set("registyAddress", data.orgnizationResponse.registyAddress ? data.orgnizationResponse.registyAddress : "")
	                    //邮编后续需要更换
	                    applicant.set("mailAddressPost", data.orgnizationResponse.mailAddressPost ? data.orgnizationResponse.mailAddressPost : "")
	                    //客户等级
	                    applicant.set("customerGrade", data.orgnizationResponse.customerGrade ? data.orgnizationResponse.customerGrade : "");
	                    //证件识别Id
	                    applicant.set("registId", data.orgnizationResponse.registId ? data.orgnizationResponse.registId : null);
	
	                    /*从plcapplicant中移植过来缺少的字段start*/
	
	                    applicant.set("customerEName", data.orgnizationResponse.customerEName ? data.orgnizationResponse.customerEName : null);
	                    applicant.set("organizationType", data.orgnizationResponse.organizationType ? data.orgnizationResponse.organizationType : null);
	                    if(rCnt > 0 || fCnt > 0){
	                        applicant.set("organizationType","3")
	                    }
	                    //映射value
	                    var organizationList=cola.util.dictionary("OrgnizationType(FXQ)");
	                    organizationList.forEach(function(_item){
	                        if(_item.key==data.orgnizationResponse.organizationType){
	                            applicant.set("organizationName", _item.value);
	                        }
	                    });
	                    applicant.set("organizationSecondType", data.orgnizationResponse.economicTypeCode ? data.orgnizationResponse.economicTypeCode : null);
	                    applicant.set("identifyEffectiveStartDate", data.orgnizationResponse.identityEffetiveStartDate ? data.orgnizationResponse.identityEffetiveStartDate : null);
	                    applicant.set("identifyEffectiveEndDate", data.orgnizationResponse.identityEffetiveEndDate ? data.orgnizationResponse.identityEffetiveEndDate : null);
	                    applicant.set("isLink", data.orgnizationResponse.isLink ? data.orgnizationResponse.isLink : null);
	                    applicant.set("industryCategory", data.orgnizationResponse.industryCategory ? data.orgnizationResponse.industryCategory : null);
	                    //映射value
	                    var industryList=cola.util.dictionary("IndustryBigClass");
	                    industryList.forEach(function(_item){
	                        if(_item.key==data.orgnizationResponse.industryCategory){
	                            applicant.set("industryCategoryName", _item.value);
	                        }
	                    });
	                    applicant.set("mainBussiness", data.orgnizationResponse.mainBusiness ? data.orgnizationResponse.mainBusiness : null);
	                    applicant.set("registeredPlaceCode", data.orgnizationResponse.registeredPlaceCode ? data.orgnizationResponse.registeredPlaceCode : null);
	                    applicant.set("busiLicense", data.orgnizationResponse.busilicense ? data.orgnizationResponse.busilicense : null);
	                    applicant.set("busiLicenseStartDate", data.orgnizationResponse.busiLicenseStartDate ? data.orgnizationResponse.busiLicenseStartDate : null);
	                    applicant.set("busiLicenseEndDate", data.orgnizationResponse.busiLicenseEndDate ? data.orgnizationResponse.busiLicenseEndDate : null);
	                    applicant.set("taxRegistrationNo", data.orgnizationResponse.taxregistrationNo ? data.orgnizationResponse.taxregistrationNo : null);
	                    //后续需要更换
	                    applicant.set("email", data.orgnizationResponse.email ? data.orgnizationResponse.email : null);
	                    applicant.set("facsimile", data.orgnizationResponse.facsimile ? data.orgnizationResponse.facsimile : null);
	                    //后续需要更换
	                    applicant.set("mailAddress", data.orgnizationResponse.mailAddress ? data.orgnizationResponse.mailAddress : null);
	
	                    /*从plcapplicant中移植过来缺少的字段end*/
	                    var riskgred='';
	                    if(data.orgnizationResponse.manualRiskLevelCode && data.orgnizationResponse.autoRiskLevelCode){
	                        if(data.orgnizationResponse.manualRiskLevelCode == "4"){
	                            riskgred = data.orgnizationResponse.manualRiskLevelCode;
	                        } else if(data.orgnizationResponse.autoRiskLevelCode == "4"){
	                            riskgred = data.orgnizationResponse.autoRiskLevelCode;
	                        } else {
	                            riskgred = data.orgnizationResponse.manualRiskLevelCode*1 < data.orgnizationResponse.autoRiskLevelCode*1 ?
	                                data.orgnizationResponse.manualRiskLevelCode : data.orgnizationResponse.autoRiskLevelCode
	                        }
	                        applicant.set("customerRiskGrade", riskgred);
	                    }else if(data.orgnizationResponse.manualRiskLevelCode){
	                        riskgred = data.orgnizationResponse.manualRiskLevelCode;
	                        applicant.set("customerRiskGrade", data.orgnizationResponse.manualRiskLevelCode ? data.orgnizationResponse.manualRiskLevelCode : null);
	                    }else if(data.orgnizationResponse.autoRiskLevelCode){
	                        riskgred = data.orgnizationResponse.autoRiskLevelCode;
	                        applicant.set("customerRiskGrade", data.orgnizationResponse.autoRiskLevelCode ? data.orgnizationResponse.autoRiskLevelCode : null);
	                    }
	                    if(riskgred){
	                        switch(riskgred){
	                            case "1":
	                                applicant.set("customerRiskGradeName", "高");
	                                break;
	                            case "2":
	                                applicant.set("customerRiskGradeName", "中");
	                                break;
	                            case "3":
	                                applicant.set("customerRiskGradeName", "低");
	                                break;
	                            case "4":
	                                applicant.set("customerRiskGradeName", "禁止");
	                                App.alert("客户风险等级为禁止，不能承保");
	                                break;
	                            default:
	                                applicant.set("customerRiskGradeName", "");
	                                break;
	                        }
	                    }
	                    if (applicant.dataType && (applicant.dataType.get("name") == "PlcApplicant" || applicant.dataType.get("name") == "PageInsurance")) {
	                        // $('.imgVip').eq(activeIndex).attr("src", "resources/images/VIP3.png").removeClass('display-none')
	                        // $('.card').eq(activeIndex).removeClass('display-none')
	                        if(data.orgnizationResponse.customerGrade){
	                            switch(data.orgnizationResponse.customerGrade){
	                                case "1":
	                                    $('.card').eq(activeIndex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
	                                    applicant.set("customerGradeName", "钻石卡");
	                                    break;
	                                case "2":
	                                    $('.card').eq(activeIndex).attr('src','resources/images/gold_card.png').removeClass('display-none');
	                                    applicant.set("customerGradeName", "金卡");
	                                    break;
	                                case "3":
	                                    $('.card').eq(activeIndex).attr('src','resources/images/silver_card.png').removeClass('display-none');
	                                    applicant.set("customerGradeName", "银卡");
	                                    break;
	                                case "4":
	                                    $('.card').eq(activeIndex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
	                                    applicant.set("customerGradeName", "贵宾卡");
	                                    break;
	                                default:
	                                    $('.card').eq(activeIndex).addClass('display-none');
	                                    applicant.set("customerGradeName", "普通客户");
	                                    break;
	                            }
	                        }
	                        var ImgNums;
	                        if(data.orgnizationResponse.manualVIPLevelCode){
	                            ImgNums = data.orgnizationResponse.manualVIPLevelCode;
	                            //重客等级
	                            applicant.set("mainCustomerGrade", data.orgnizationResponse.manualVIPLevelCode ? data.orgnizationResponse.manualVIPLevelCode : null)
	                        }else if(data.orgnizationResponse.autoVIPLevelCode){
	                            ImgNums =data.orgnizationResponse.autoVIPLevelCode;
	                            //重客等级
	                            applicant.set("mainCustomerGrade", data.orgnizationResponse.autoVIPLevelCode ? data.orgnizationResponse.autoVIPLevelCode : null)
	                        }
	                        if(ImgNums){
	                            switch(ImgNums){
	                                case "1":
	                                    $('.imgVip').eq(activeIndex).attr('src','resources/images/VIP1.png').removeClass('display-none');
	                                    break;
	                                case "2":
	                                    $('.imgVip').eq(activeIndex).attr('src','resources/images/VIP2.png').removeClass('display-none');
	                                    break;
	                                case "3":
	                                    $('.imgVip').eq(activeIndex).attr('src','resources/images/VIP3.png').removeClass('display-none');
	                                    break;
	                                default:
	                                    $('.imgVip').eq(activeIndex).addClass('display-none');
	                                    break;
	                            }
	                        }
	
	                        App.setFieldVisible($(".grpCustomerApplicant").eq(activeIndex), true, false);
	                        App.setFieldVisible($(".selfCustomerApplicant").eq(activeIndex), false, true)
	                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcInsurant") {
	                        // $('.imgVipbbr').eq(activeIndex).attr("src", "resources/images/VIP3.png").removeClass('display-none')
	                        // $('.cardbbr').eq(activeIndex).removeClass('display-none')
	                        if(data.orgnizationResponse.customerGrade){
	                            switch(data.orgnizationResponse.customerGrade){
	                                case "1":
	                                    $('.cardbbr').eq(activeIndex).attr('src','resources/images/IMG_0192.JPG').removeClass('display-none');
	                                    applicant.set("customerGradeName", "钻石卡");
	                                    break;
	                                case "2":
	                                    $('.cardbbr').eq(activeIndex).attr('src','resources/images/gold_card.png').removeClass('display-none');
	                                    applicant.set("customerGradeName", "金卡");
	                                    break;
	                                case "3":
	                                    $('.cardbbr').eq(activeIndex).attr('src','resources/images/silver_card.png').removeClass('display-none');
	                                    applicant.set("customerGradeName", "银卡");
	                                    break;
	                                case "4":
	                                    $('.cardbbr').eq(activeIndex).attr('src','resources/images/IMG_0193.JPG').removeClass('display-none');
	                                    applicant.set("customerGradeName", "贵宾卡");
	                                    break;
	                                default:
	                                    $('.cardbbr').eq(activeIndex).addClass('display-none');
	                                    applicant.set("customerGradeName", "普通客户");
	                                    break;
	                            }
	                        }
	                        var ImgNums;
	                        if(data.orgnizationResponse.manualVIPLevelCode){
	                            ImgNums = data.orgnizationResponse.manualVIPLevelCode;
	                            //重客等级
	                            applicant.set("mainCustomerGrade", data.orgnizationResponse.manualVIPLevelCode ? data.orgnizationResponse.manualVIPLevelCode : null)
	                        }else if(data.orgnizationResponse.autoVIPLevelCode){
	                            ImgNums =data.orgnizationResponse.autoVIPLevelCode;
	                            //重客等级
	                            applicant.set("mainCustomerGrade", data.orgnizationResponse.autoVIPLevelCode ? data.orgnizationResponse.autoVIPLevelCode : null)
	                        }
	                        if(ImgNums){
	                            switch(ImgNums){
	                                case "1":
	                                    $('.imgVipbbr').eq(activeIndex).attr('src','resources/images/VIP1.png').removeClass('display-none');
	                                    break;
	                                case "2":
	                                    $('.imgVipbbr').eq(activeIndex).attr('src','resources/images/VIP2.png').removeClass('display-none');
	                                    break;
	                                case "3":
	                                    $('.imgVipbbr').eq(activeIndex).attr('src','resources/images/VIP3.png').removeClass('display-none');
	                                    break;
	                                default:
	                                    $('.imgVipbbr').eq(activeIndex).addClass('display-none');
	                                    break;
	                            }
	                        }
	
	                        App.setFieldVisible($(".grpCustomer").eq(activeIndex), true, false);
	                        App.setFieldVisible($(".selfCustomer").eq(activeIndex), false, true)
	                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".workTypeSmallClass"),true);
	                        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(activeIndex).find(".thirdOperationCode"),true);
	                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategoryName"),false);
	                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industrySCategory"),false);
	                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industrySCategoryName"),false);
	                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryTCategory"),false);
	                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryTCategoryName"),false);
	                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".industryCategory"),false);
	                        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(activeIndex).find(".businessSort"),false);
	                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcCarowners") {
	                        App.setFieldVisible($(".selfplcCarowners").eq(activeIndex), false, true);
	                        App.setFieldVisible($(".grpplcCarowners").eq(activeIndex), true, false)
	                    } else if (applicant.dataType && applicant.dataType.get("name") == "PlcGuardian") {
	                        App.setFieldVisible($(".selfplcGuardian").eq(activeIndex), false, true);
	                        App.setFieldVisible($(".grpplcGuardian").eq(activeIndex), true, false)
	                    }
	
	                }
	            }
	        }
	        if (customerType == "1"){
	            if(identityType === "10" || identityType === "19" || identityType === "23" ){
	                applicant.set("isWithinForeign", "0");
	            } else {
	                applicant.set("isWithinForeign", "1");
	            }
	        }
	    },
	    error: function (e) {
	        console.log(e)
	    }
	})
	
} 

ContractEntity.prototype.initGropDate = function (applicant) {
    applicant.set("registyAddress", "");
    applicant.set("mailAddressPost", "");
    applicant.set("linkerName", "");
    applicant.set("linkerMobile", "");
    applicant.set("linkerPhoneNo", "");
    applicant.set("despositBankName", "");
    applicant.set("accountName", "");
    applicant.set("accountNo", "");
    applicant.set("customerGrade", "");
    applicant.set("customerGradeName", "");
    applicant.set("customerRiskGrade", "");
    applicant.set("customerRiskGradeName", "");
}

//通过身份证号带出生日年龄国籍性别境内外默认值
ContractEntity.prototype.getIdentifyInfor = function (applicant) {
    debugger;
    var identifyValue = applicant.get("identifyNumber");//证件号码
    var identifyType = applicant.get("identifyType");//证件类型
    var reg = /^(\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
    var regSFZ = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    //判断当前是投保人还是被保人
    if (applicant.dataType && (applicant.dataType.get("name") == "PlcApplicant" || applicant.dataType.get("name") == "PageInsurance")) {
        applicant.set("plcCustomer", {})//如果不声明plcCustomer是个对象,下面给plcCustomer下面的属性赋值时会报错
    }
    applicant.set("isWithinForeign", 1);

    //健康险，投/被保人的实际周岁按起保日计算
   /* var actual = cola.model().get("actuals").current;
    if(actual){
        var proCode = actual.get("productCode").substring(0, 2);
        if( proCode == "28"){
            var startTime = actual.get("actual.startTime");
                startTime = new Date(startTime); 
        }
    
    }*/

    if (identifyType == "01" && regSFZ.test(identifyValue)) { //.length==18||identifyValue.length==15
        if (reg.test(identifyValue) && identifyValue.length == "18" && applicant.get("identifyType") == '01') {
            applicant.set("citizenship", "CHN");
            applicant.set("citizenshipName", "中国");
            if (parseInt(identifyValue.substr(16, 1)) % 2 == 1) {
                applicant.set("sex", "1");
                applicant.set("sexName", "男性");
//是男则执行代码 ...
            } else {
                applicant.set("sex", "2");
                applicant.set("sexName", "女性");
//是女则执行代码 ...
            }
            //获取年龄
           /* if(actual){
                if( proCode == "28"){
                    var myDate = startTime;
                }else{
                    var myDate = new Date();
                }

            }else{
                var myDate = new Date();
            }*/

            var myDate = new Date();
            var birthY = identifyValue.substring(6, 10),
                birthM = identifyValue.substring(10, 12),
                birthD = identifyValue.substring(12, 14),
                birthDate = new Date(birthY+"/"+ birthM+"/"+birthD);
             var newDate = myDate.getTime() - birthDate.getTime();
             var age = Math.floor(newDate / 1000 / 60 / 60 / 24 / 365);

             applicant.set("age", age);

            // 获取生日
            var birth = identifyValue.substring(6, 10) + "-" + identifyValue.substring(10, 12) + "-" + identifyValue.substring(12, 14);
            applicant.set("birthDate", birthDate)
        } else if (identifyValue.length == "15" && applicant.get("identifyType") == '01') {//420881 199212 13 8
            applicant.set("citizenship", "CHN");
            applicant.set("citizenshipName", "中国");
            applicant.set("isWithinForeign", 1);
            if (parseInt(identifyValue.substr(14)) % 2 == 1) {
                applicant.set("sex", "1");
                applicant.set("sexName", "男性");
//是男则执行代码 ...
            } else {
                applicant.set("sex", "2");
                applicant.set("sexName", "女性");
//是女则执行代码 ...
            }
            //获取年龄
            if(actual){
                if( proCode == "28"){
                    var myDate = startTime;
                }else{
                    var myDate = new Date();
                }

            }else{
                var myDate = new Date();
            }

            var birthY = identifyValue.substring(6, 10),
                birthM = identifyValue.substring(10, 12),
                birthD = identifyValue.substring(12, 14),
                birthDate = new Date(birthY+"/"+ birthM+"/"+birthD);
             var newDate = myDate.getTime() - birthDate.getTime();
             var age = Math.floor(newDate / 1000 / 60 / 60 / 24 / 365);

             applicant.set("age", age);

            // 获取生日
            var birth = 19 + identifyValue.substring(6, 8) + "-" + identifyValue.substring(8, 10) + "-" + identifyValue.substring(10, 12);
            applicant.set("birthDate", birthDate);
        } else {
            contractEntity.initSelfDate(applicant, true);
        }
    }
}

function OperationPage() {
    var contextPath = window.location.href.substr(0, window.location.toString().indexOf("/", window.location.origin.length + 1) + 1);
    this.openPage = function(name, url,unassignedTask) {
        //console.log("contextPath ",contextPath);
        if (window.frames.length != parent.frames.length) {
            this.cmd("open", name, contextPath + url,unassignedTask);
        } else {
            window.open(contextPath + url,unassignedTask);
        }
    }
    this.openNewPage = function(name, url) {
        //console.log("contextPath ",contextPath);
        if (window.frames.length != parent.frames.length) {
            this.cmd("open", name, url);
        } else {
            window.open(url);
        }
    }
    this.closePage = function() {
        if (window.frames.length != parent.frames.length) {
            this.cmd("close");
        } else {
            window.location.href = "about:blank";
            window.close();
        }
    }
    this.cmd = function(status, name, url, kind, widgetElementId, id, $dom) {
        if (window.frames.length != parent.frames.length) {
            window.parent.postMessage({
                status: status,
                name: name,
                url: url
            }, "*")
        } else {
            window.location.href = "about:blank";
            window.close();
        }
    };
}
var operationPage = new OperationPage();
ContractEntity.prototype.openIframePageTest = function(name, url,unassignedTask) {
      operationPage.openPage(name, url,unassignedTask);
}

ContractEntity.prototype.openIframePage = function (name, url,unassignedTask) {
   
    operationPage.openPage(name, url,unassignedTask);
    
    
}
ContractEntity.prototype.closeIframePage = function() {
    operationPage.closePage();
}
/**获取BLock*/
ContractEntity.prototype.getBlock = function (specId, templateType) {
    var url
    if (!templateType) {
        url = "controller/uw/blockRole/getPageBlocks?specIds=" + specId + "&templateType=";
    } else {
        url = "controller/uw/blockRole/getPageBlocks?specIds=" + specId + "&templateType=" + templateType;
    }

    return $.get(url);
}

//处理setfieldvisible无法处理的一个field下有多个绑定的校验开关问题
ContractEntity.prototype.setFieldValidatorsDisabled = function($field,disableValidators){
    if($field&&$field.data("property")){
    var propertyArr = $field.data("property").split(',');
    }else{
        return;
    }
    if ($field[0].nodeName === "FIELD") {
       var field = cola.widget($field[0]);
       var _dataType= field._form._dataType;
        propertyArr.forEach(function(item){
            _dataType.getProperty(item).set("disableValidators",disableValidators);
        });

    }
}

//判断被保险人是不是标的
ContractEntity.prototype.judgeInsurant = function(productCode){
    if(productCode){
      var thisProductCode = productCode.substring(0, 2);
      //个人账户资金安全保险相关三款产品和意外险
      if(productCode=='02990006'||productCode=='02020001'||productCode=='0307'||thisProductCode == "27"||thisProductCode=="28"){
        return true;
      }else {
        return false;
      }
    }
  }

  //证件类型过滤
ContractEntity.prototype.voucherFilter = function (items, num) {
    if (num == 1) {
        return [
            {key: "01", value: "居民身份证"},
            {key: "02", value: "居民户口簿"},
            {key: "03", value: "中国因公护照"},
            {key: "04", value: "军官证/警官证"},
            {key: "05", value: "驾驶证"},
            {key: "06", value: "台湾居民来往大陆通行证"},
            {key: "08", value: "士兵证"},
            {key: "09", value: "警官证"},
            {key: "10", value: "外国人永久居留证"},
            {key: "11", value: "临时身份证"},
            {key: "12", value: "香港身份证"},
            {key: "14", value: "往来港澳通行证"},
            {key: "15", value: "大陆居民往来台湾通行证"},
            {key: "16", value: "军官离退休证"},
            {key: "17", value: "港澳居民来往内地通行证"},
            {key: "18", value: "中国因私护照"},
            {key: "19", value: "外国护照"},
            {key: "20", value: "澳门身份证"},
            {key: "23", value: "外国人永久居留身份证"},
            {key: "99", value: "其他个人证件"},
            {key: "99X", value: "学生证"}
        ]
    } else if (num == 2) {
        return [
            {key: "07", value: "组织机构代码证"},
            {key: "22", value: "统一社会信用代码"},
            {key: "24", value: "境外组织机构证件"}
        ]
    }
}
var contractEntity = new ContractEntity();
 
 