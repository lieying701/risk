cola(function (model) {
    window.enterReinsurancePage = true;
    var params = cola.util.queryParams();
    var actualId = cola.util.queryParams().actualId;
    var productCode = params.productCode;
    model.set("productCode",productCode);
    var startDate = model.get("actuals.startDate");
    var sum = 0;
    var oriAmountSum = 0;
    var rate = 100;
    var url = window.location.href;
    var showPMLList = ["27010001","27020001","27020002","27020003","27020004","27030001","27030002","27040001","27050001","27060001","27070001","27070002","27070003","27080001","27080002","27090002","27100006","27110001","27110002","27110003","27110004","27110005","27110006","27140004"];// 需要显示PML的产品代码
    model.set("uwEndorsementFlag",url.indexOf("uwEndorsement.html"));

    model.set("zhcpbz",'0');// 组合产品标志->现没字段,默认为否0

    model.set("FLAG","");// 是否成功发起过临分意向 -> 如果成功发起过,值为success;

    var nextDangerNo = 1;

    // 加载原始标的信息表格
    // cola.ready(function () {
    //     if(location.href.indexOf("uwDetailGroup")>0 || location.href.indexOf("uwEndorsementGroup")>0){
    //         cola.widget('riskTableGroupSubview').loadIfNecessary();
    //     }else{
    //         cola.widget('riskTableSubview').loadIfNecessary();
    //     }
    // })


    // 设置是否显示PML意健险的标识
    for(var i=0;i<showPMLList.length;i++){
        if(productCode == showPMLList[i]){
            model.set("showPMLFlag",true);
            break;
        }
    }

    // 意外险部分产品去掉地址、标的地址字段
    if(productCode.substring(2,0) == "27"){
        if(productCode != "2706" && productCode != "27030002"){
            $(".protectTable").addClass("objectAddress");
            $(".productAddress").css("display","none");
        }
    }

    // 业务类型下拉框
    model.set("businessTypeList",[
        {
            key: "61",
            value: "报价"
        },{
            key: "62",
            value: "投保"
        },{
            key: "67",
            value: "批单申请"
        },{
            key: "66",
            value: "保单"
        },{
            key: "60",
            value: "协议"
        },{
            key: "69",
            value: "方案"
        },{
            key: "68",
            value: "批单"
        },
    ]);


    // 业务号 -> 临分意向发起中用到

    if(model.get("actuals").entityCount > 0){
        model.set("businessNo",model.get("actuals").current.get("businessNo"));
    }


    // 设置产品下拉框
    $.ajax({
        url: "service/product/insuranceProduct/getCachedObjects",
        success: function (data) {
            $.each(data, function (index, obj){
                obj.name = obj.productCode + "-" + obj.name;
            });
            model.set("productCodeList",data);
        }
    });

    // 主条款
    model.set("mainClauseDropList", []);
    $.ajax({
        url: "controller/insurance/businessEntity/getMainProductClause?productCode=" + productCode,
        async: false,
        success: function (data) {
            model.set("mainClauseDropList", data);
        }
    });

    // 附加条款
    var mainClauseDropList = model.get("mainClauseDropList").toJSON();
    $.each(mainClauseDropList,function (index,item) {
        $.ajax({
            url: "controller/insurance/businessEntity/getAdditonProductClause?productCode=" + productCode + "&clauseCode=" + item.productCode,
            async: false,
            success: function (data) {
                for (var i = 0, len = data.length; i < len; i++) {
                    model.get("mainClauseDropList").insert(data[i]);
                }
            }
        })
    })

    // 查询责任|标的类别
    model.set("clauseDeductDropList", []);
    model.get("mainClauseDropList").each(function (item) {
        $.ajax({
            url: "controller/insurance/businessEntity/getProductLiability?productCode=" + productCode + "&clauseCode=" + item.get("productCode"),
            success: function (data) {
                $.each(data,function (index,value) {
                    model.get("clauseDeductDropList").insert(value);
                });
            }
        });
    });

    //一期风险类别信息从危险单位取，企财、工程险才需要手工选择
    // 查询风险类别下拉框
    // var classCode = model.get("actuals.classCode");
//    $.ajax({
//        url: "controller/reinsurance/riskinfo/findOneByActualId?actualId=" + actualId,
//        type: "GET",
//        async: false,
//        contentType: "application/json",
//        success: function (data) {
//            model.set("riskClassList",[data]);
//        }
//    });

    // 查询进预约合约,应该是在页面手工选择时候才调用，不是页面加载时候就要查询
    function queryTreatyInfo(){
        var startDate =XDate(model.get("actuals.startTime")).toString("yyyy-MM-dd");
        $.ajax({
            url: "controller/insurance/reinsurance/treatyInfo?riskCode=" + productCode + "&startDate=" + startDate,
            type: "POST",
            contentType: "application/json",
            success: function (data) {
                if(data){
                    model.set("orderContractList",data.treatyInfoList);
                }
            }
        })
    }
    queryTreatyInfo();

    var originalDangerUnit = {
        "actualId": 12345,
        "description": "",// 描述
        "serialNo": 1,
        "name": "",// 产品名称
        "address": "",// 地址
        "orderContractCode": "",
        "orderContractName": "",
        "multRecordsRetention": "0",// 多票累计自留
        "chinaBusiness": "0",// 中国利益海外业务

        "riskLevel": "",
        "riskLevelDesc": "",
        "retCurrency": "CNY",// 币别
        "retentionValue": "",// 自留额

        "riskClass": "",// 风险类别
        "riskClassDesc": "",// 风险名称
        "dangerClauseEOList": [],
        "rate": 100,// 占比
        "dangerExcludingItemEOList": [],

        "pmlCurrency": "CNY",// pml币别
        "pmlAmount": "0",// pml金额
        "pmlRate": "",// pml占比
    };
    model.set("currency",model.get("actuals.signCurrencyCode"));


    // 再保确认状态数据list
    model.set("verifyFlagList", [
        {
            key: "0",
            value: "暂存"
        }, {
            key: "1",
            value: "待确认"
        }, {
            key: "2",
            value: "待通过"
        }, {
            key: "3",
            value: "确认通过"
        }, {
            key: "4",
            value: "确认不通过"
        }, {
            key: "5",
            value: "非临分"
        }, {
            key: "9",
            value: "注销"
        }
    ]);

    var getNewDangerUnit = function () {// 保存原始数据
        var newDangerUnit = {};
        for (var prop in originalDangerUnit) {
            newDangerUnit[prop] = originalDangerUnit[prop];
        }
        newDangerUnit.serialNo = nextDangerNo++;
        if (originalDangerUnit.dangerClauseEOList) {
            var newDangerClauseEOList = [];
            originalDangerUnit.dangerClauseEOList.forEach(function (originalDangerClause) {
                var newDangerClause = {};
                for (var prop in originalDangerClause) {
                    newDangerClause[prop] = originalDangerClause[prop];
                }
                newDangerClauseEOList.push(newDangerClause);
            })
            newDangerUnit.dangerClauseEOList = newDangerClauseEOList;
        }
        if (originalDangerUnit.dangerExcludingItemEOList) {
            var newDangerExcludingItemArray = [];
            originalDangerUnit.dangerExcludingItemEOList.forEach(function (originalDangerExcludingItem) {
                var newDangerExcludingItem = {};
                for (var prop in originalDangerExcludingItem) {
                    newDangerExcludingItem[prop] = originalDangerExcludingItem[prop];
                    newDangerExcludingItem.excludingItemOption = [{"itemKind": "Z99","itemKindDesc": "其它（非除外责任和非申报业务）"}];
                }
                newDangerExcludingItemArray.push(newDangerExcludingItem);
            })
            newDangerUnit.dangerExcludingItemEOList = newDangerExcludingItemArray;
        }

        return newDangerUnit;
    }


    // 获取原始标的信息
    $.ajax({
        url: "controller/insurance/reinsurance/findAllClauseItems?schema=&actualId=" + actualId,
        type: "GET",
        async: false,
        contentType: "application/json",
        success: function (data) {
            if (data) {

                // 请求币别转换率
                var exchangeobj = {
                    rateFlag: "1",
                    exchangeList: []
                };
                var signCurrencyCode = model.get("currency");
                $.each(data,function (index,item) {
                    exchangeobj.exchangeList.push({
                        exchCurrency: item.currency,
                        baseCurrency: signCurrencyCode
                    });
                });
                $.ajax({
                    url: "controller/exchange/findExchange",
                    type: "POST",
                    async: false,
                    contentType: "application/json",
                    data: JSON.stringify(exchangeobj),
                    success: function (data) {

                        var exchRateList = [];
                        $.each(data,function (index,item) {
                            exchRateList.push(item.exchRate);
                        })
                        model.set("exchRateList",exchRateList);
                    }
                });

                // 下面开始处理原始标的信息数据
                var exchRateList = model.get("exchRateList");
                var originalClauseItemArray = [];
                var sumPremium = 0;
                var sumAmount = 0;
                model.set("address",data[0].address);
                data.forEach(function (clauseItem,index) {
                    clauseItem.checked = true;

                    // 请求过来的数据小数点后有多位 -> 保留两位,不然计算会出错
                    clauseItem.premium = contractEntity.formatToTwoPrecision(clauseItem.premium*1);
                    clauseItem.amount = contractEntity.formatToTwoPrecision(clauseItem.amount*1);

                    // 计算原始标的信息的总保额

                    sum = contractEntity.formatToTwoPrecision(sum + contractEntity.formatToTwoPrecision(clauseItem.premium * exchRateList[index]));
                    sumPremium = contractEntity.formatToTwoPrecision(sumPremium + contractEntity.formatToTwoPrecision(clauseItem.premium * exchRateList[index]));
                    if(clauseItem.calculateFlag == "1"||clauseItem.calculateFlag == "Y"){
                        sumAmount = contractEntity.formatToTwoPrecision(sumAmount + contractEntity.formatToTwoPrecision(clauseItem.amount * exchRateList[index]));
                        oriAmountSum = contractEntity.formatToTwoPrecision(oriAmountSum + contractEntity.formatToTwoPrecision(clauseItem.amount * exchRateList[index]));
                    }

                    originalClauseItemArray.push(clauseItem);
                });
                originalDangerUnit.amount = sumAmount;
                originalDangerUnit.premium = sumPremium;
                if(data.length>0){
                    originalDangerUnit.address = data[0].address;
                }

                // 请求保额变化值 保费变化值
                if(location.href.indexOf("uwEndorsement")>0 || location.href.indexOf("uwEndorsementGroup")>0){
                    $.ajax({
                        url: "controller/insurance/reinsurance/findEndorseCommission?schema=&actualId=" + actualId,
                        type: "GET",
                        async: false,
                        contentType: "application/json",
                        success: function (data) {
                            if(data && originalClauseItemArray){

                                $.each(originalClauseItemArray,function (index,item) {

                                    // item.excAmount = (data[item.clauseCode])&&(data[item.clauseCode]["coverageCode"]==item.coverageCode)?data[item.clauseCode].amountVariation:0;
                                    // item.excPremium = (data[item.clauseCode])&&(data[item.clauseCode]["coverageCode"]==item.coverageCode)?data[item.clauseCode].premiumVariation:0;

                                    if ((data[item.itemSerialNo]) && (data[item.itemSerialNo].serialNo == item.itemSerialNo)) {
                                        item.excAmount = data[item.itemSerialNo].amountVariation ? data[item.itemSerialNo].amountVariation : 0;
                                    }else{
                                        item.excAmount = 0;
                                    }

                                    if ((data[item.itemSerialNo]) && (data[item.itemSerialNo].serialNo == item.itemSerialNo)) {
                                        item.excPremium = data[item.itemSerialNo].premiumVariation ? data[item.itemSerialNo].premiumVariation : 0;
                                    }else{
                                        item.excPremium = 0;
                                    }
                                })
                            }
                        }
                    });
                }else{
                    $.each(originalClauseItemArray,function (index,item) {
                        item.excAmount = 0;
                        item.excPremium = 0;
                    })
                }


                originalDangerUnit.dangerClauseEOList = originalClauseItemArray;

            }
        },
        error: function () {
            cola.NotifyTipManager.warning({
                message:"",
                description:"获取原始标的信息失败！",
                showDuration:3000
            });
        }
    });

    // 获取危险单位除外责任，是生成默认危险单位信息时候需要查询并持久化到数据库中，不是页面加载时候使用
//    $.ajax({
//        url: "controller/reinsurance/treatyInfo/findExItemKind?schema=&actualId=" + actualId,
//        type: "GET",
//        async: false,
//        contentType: "application/json",
//        success: function (data) {
//            if (data) {
//
//                var dangerExcludingItemEoList = [];
//                data.forEach(function (treatyInfo) {
//                    var exItemKind = {
//                        "actualId": treatyInfo.actualId,
//                        "itemKind": treatyInfo.itemKind,
//                        "itemKindDesc": treatyInfo.itemKindDesc,
//                        "treatyNo": treatyInfo.treatyNo,
//                        "secTionNo": treatyInfo.sectionNo
//                    };
//                    dangerExcludingItemEoList.push(exItemKind);
//
//                    model.set("dangerExItemKind", treatyInfo);
//                })
//                originalDangerUnit.dangerExcludingItemEOList = dangerExcludingItemEoList;
//            }
//        },
//        error: function () {
//            cola.NotifyTipManager.warning({
//                message:"",
//                description:"获取危险单位除外责任失败！",
//                showDuration:3000
//            });
//        }
//    });

    // 获取危险单位数据
    $.ajax({
        url: "controller/insurance/reinsurance/getDangerUnit?actualId=" + actualId,
        type: "GET",
        contentType: "application/json",
        success: function (response) {
            if (response && response.length > 0) {
                var data = response;
                var exchRateList = model.get("exchRateList");

                oriAmountSum = 0;
                var exchRateList = model.get("exchRateList");
                originalDangerUnit.dangerClauseEOList.forEach(function (item,index) {
                    for(var i=0,len=data[0].dangerClauseEOList.length;i<len;i++){
                        if(item.itemSerialNo == data[0].dangerClauseEOList[i].itemSerialNo){
                            item.calculateFlag = data[0].dangerClauseEOList[i].calculateFlag;
                        }
                    }

                    if(item.calculateFlag == "1"||item.calculateFlag == "Y"){
                        oriAmountSum = contractEntity.formatToTwoPrecision(oriAmountSum + contractEntity.formatToTwoPrecision(item.amount * exchRateList[index]));
                    }
                });

                data.forEach(function (dangerUnit) {

                    var amountSum = 0;
                    var premiumSum = 0;
                    var changeNumAmount = 0;
                    var changeNumPremium = 0;
                    var oriDangerClauseEOList = JSON.parse(JSON.stringify(originalDangerUnit.dangerClauseEOList));
                    for(var i=0;i<oriDangerClauseEOList.length;i++){
                        oriDangerClauseEOList[i].checked = false;
                    }

                    // 设置原始标的信息
                    oriDangerClauseEOList.forEach(function (originalDangerClause,index1) {
                        console.log(data)

                        // 循环当前危险单位中的所有标的
                        dangerUnit.dangerClauseEOList.forEach(function (dangerClause,index2) {

                            if ((originalDangerClause.itemSerialNo) == (dangerClause.itemSerialNo)) {

                                originalDangerClause.checked = true;

                                originalDangerClause.amount = dangerClause.amount*1;
                                originalDangerClause.premium = dangerClause.premium*1;

                                if(dangerClause.calculateFlag == "1"||dangerClause.calculateFlag == "Y"){
                                    amountSum = contractEntity.formatToTwoPrecision(amountSum + contractEntity.formatToTwoPrecision(dangerClause.amount * exchRateList[index1]));
                                    if(model.get("isUwEndorsement")){
                                        changeNumAmount = contractEntity.formatToTwoPrecision(changeNumAmount + contractEntity.formatToTwoPrecision(originalDangerClause.excAmount * exchRateList[index1]));
                                    }
                                }
                                premiumSum = contractEntity.formatToTwoPrecision(premiumSum + contractEntity.formatToTwoPrecision(dangerClause.premium * exchRateList[index1]));
                                if(model.get("isUwEndorsement")){
                                    changeNumPremium = contractEntity.formatToTwoPrecision(changeNumPremium + contractEntity.formatToTwoPrecision(originalDangerClause.excPremium * exchRateList[index1]));
                                }


                            }
                        });


                    });
                    dangerUnit.dangerClauseEOList = JSON.parse(JSON.stringify(oriDangerClauseEOList));
                    dangerUnit.pmlCurrency = "CNY";

                    // 计算风险评估信息: 保额/保费/占比
                    dangerUnit.amount = amountSum+changeNumAmount;
                    dangerUnit.premium = premiumSum+changeNumPremium;

                    dangerUnit.changeNumAmount = changeNumAmount;
                    dangerUnit.changeNumPremium = changeNumPremium;

                    if (model.get("actuals").current.get("amount") && oriAmountSum != 0) {

                        dangerUnit.rate = contractEntity.formatToTwoPrecision(amountSum / oriAmountSum * 100);
                    } else {
                        dangerUnit.rate = "100";
                    }

                    // 赋值风险等级,风险类别
                    dangerUnit.riskLevel = model.get("riskLevel") || dangerUnit.riskLevel;
                    dangerUnit.riskClass = model.get("riskClass") || dangerUnit.riskClass;

                    dangerUnit.chinaBusiness = dangerUnit.chinaBusiness || '0';

                    dangerUnit.dangerExcludingItemEOList.forEach(function (t) {
                        t.excludingItemOption = [{"itemKind": "Z99","itemKindDesc": "其它（非除外责任和非申报业务）"}];
                    });

                });
                model.set("riskUnits", data);
            } else {
                model.set("riskUnits", [getNewDangerUnit()]);
            }
            if (params.taskType == "04") {
                cola.tag("reinsuranceStatus").set("disabled", true);
                model.set("FLAG","success");
                cola.tag("reinsuranceInput").set("readOnly", true);
                cola.tag("input").set("readonly","true");
                $("#riskTable .checkbox").parent().addClass("pointer");
            }

        },
        error: function () {
            cola.NotifyTipManager.warning({
                message:"",
                description:"获取危险单位失败！",
                showDuration:3000
            });
        }
    });

    // 临分意向初始化
    model.set("enquiryInfo", {
        productCode: model.get("actuals").current.get("productCode"),
        actualId: model.get("actuals").current.get("actualId"),
        // businessNo: model.get("actuals").current.get("businessNo"),
        businessType: model.get("actuals").current.get("businessType"),
        remarks: "",
        specialFacFlag: "0",
        specialFacShare: "0",
        facFlag: "0",
        facShare: "0",
        enquiryReceiveList: []
    });
    // 查询临分意向数据,页面加载就开始查询是由于临分意向在红的沟通历史需要显示在页面中
    function findEnquiryInfo (){
        $.ajax({
            url: "controller/insurance/enquiry/findEnquiryInfoByActualId?actualId=" + actualId,
            type: "GET",
            contentType: "application/json",
            // dataType: "json",
            async: false,
            success: function (data) {
                // 隐藏等待动画
                $(".waittingBox").css("display","none");

                // 如果没有数据或verifyFlag不为3时 则调用再保接口查询

                if (data) {
                    var data = showEnquiryInfo(data);
                    model.set("FLAG", "success");
                    model.set("enquiryInfo", data);
                    cola.tag("input").set("readonly","true");

                    //设置沟通历史数据
                    model.set("enquiryVerifyList",data.enquiryVerifyList);
                }
            },
            error: function () {
                // 隐藏等待动画
                $(".waittingBox").css("display","none");
            }
        });
    }
    findEnquiryInfo();


    function showEnquiryInfo(data){
        if (data) {
            // 由于数据中存的是0(否)和1(是), 所以拿到数据需要转化成checkbox识别的true和false
            if(data.enquiryReceiveList){
                for(var i= 0,len=data.enquiryReceiveList.length;i<len;i++){
                    data.enquiryReceiveList[i].facFlag = data.enquiryReceiveList[i].facFlag=="1"?true:false;
                    data.enquiryReceiveList[i].currencyFlag = data.enquiryReceiveList[i].currencyFlag=="1"?true:false;
                    data.enquiryReceiveList[i].reinsType = data.enquiryReceiveList[i].reinsType=="0"?true:false;

                    data.enquiryReceiveList[i].othRate = data.enquiryReceiveList[i].othRate?data.enquiryReceiveList[i].othRate:0;//没值就设置假数据0
                }
            }
            data.actualId = model.get("actuals").current.get("actualId");
            data.businessType = model.get("actuals").current.get("businessType");
        }
        return data;
    }


    // 危险单位累计查询结果list
    model.set("cumulativeQueryList", []);

    // 再保意见
    model.set("reInsuranceSuggest", "");

    if (params.actualId) {
        model.set("schemaName", params.schemaName);
        model.set("actualId", params.actualId);
        var BusinessEntity = model.definition("BusinessEntity");

        // 风险等级评估 -> 评估结果
        model.set("riskPrompts", []);
    }


    function findTreatyInfoItemKindByDanger (dangerItemKind) {// 点击获取除外责任下拉框

        $.ajax({
            url: "controller/insurance/reinsurance/treatyExItemKind?riskCode="+productCode+"&treatyNo="+dangerItemKind.get("treatyNo")+"&sectionNo="+dangerItemKind.get("secTionNo"),
            type: "POST",
            contentType: "application/json",
            async: false,
            success: function (data) {
                var treatyExItemKindList
                if(data.treatyExItemKindOutList[0]){
                    treatyExItemKindList = data.treatyExItemKindOutList[0].treatyExItemKindList;
                }

                for(var i=0;i<treatyExItemKindList.length;i++){
                    dangerItemKind.get("excludingItemOption").insert(treatyExItemKindList[i]);
                }


            }
        });
    };

    model.action({
        // 自定义下拉框转换
        translate: function (listName,code,key,value) {
            // listName 下拉框list
            // code 要查找的码值
            // key 码值
            // value 值

            var list = model.get(listName);
            var showText = "";

            if( list ){
                list.each(function (item) {
                    if(item.get(key) == code){
                        showText = item.get(key) + "-" + item.get(value);
                        return showText;
                    }
                })
            };
            return showText;
        },
        changeRiskClass: function (riskUnit) {

            // 由于是级联关系,所以上面层级的值变化要清空与之有关的数据以便重新赋值
            riskUnit.set("riskClassDesc","");
            riskUnit.set("riskLevel","");
            riskUnit.set("retCurrency","");
            riskUnit.set("retentionValue","");
            riskUnit.set("riskLevelDesc","");

            model.get("riskClassList").each(function (item) {
                if(item.get("riskTypeCode") == riskUnit.get("riskClass")){
                    // 设置页面中的riskClassDesc
                    riskUnit.set("riskClassDesc",item.get("riskTypeName"));

                    // 设置riskCategoryId -> 查询风险等级用
                    model.set("riskCategoryId",item.get("riskCategoryId"));
                }
            });

            if( model.get("riskCategoryId") ){
                // 查询风险等级
                $.ajax({
                    url: "controller/reinsurance/riskinfo/findAvailableRetention?riskCategoryId=" + model.get("riskCategoryId"),
                    type: "GET",
                    contentType: "application/json",
                    success: function (data) {
                        model.set("riskLevelList",data);
                        // cola.tag("riskLevel").set("disabled",false);
                    }
                });
            }
        },
        changeRiskLevel: function (riskUnit) {
            riskUnit.set("retCurrency","");
            riskUnit.set("retentionValue","");

            model.get("riskLevelList").each(function (item) {
                if(item.get("riskLevel") == riskUnit.get("riskLevel")){
                    riskUnit.set("riskLevelDesc",item.get("riskLevelName"));

                    riskUnit.set("retCurrency",item.get("currency"));
                    riskUnit.set("retentionValue",item.get("retention"));
                }
            })

        },
        findTreatyInfoItemKind: function (dangerItemKind) {// 点击获取除外责任
            if(dangerItemKind.get("excludingItemOption").toJSON().length == 1){
                findTreatyInfoItemKindByDanger(dangerItemKind);
            }

        },
        filterDate:function(date){
            if(date){
                date=new Date(date)
            }else{
                date="";
            }
            return date;
        },
        beforeChange: function (self,arg) {


            var numStr = "" + arg.value;
            if(numStr.split(".")[1] && numStr.split(".")[1].length>3){
                cola.NotifyTipManager.warning({
                    message:"",
                    description:"警告: 请输入有效位数内的数字！",
                    showDuration:3000
                });
                return false;
            }

            // 计算该标的的值改变后的总保额/费
            var key = self["_bindInfo"].property;
            var sum = 0;
            var serialNo = arg.model.parent.items.current["_data"].serialNo;
            var current = arg.model.parent.items.current["_data"].itemSerialNo;
            model.get("riskUnits").each(function (riskUnit) {
                riskUnit.get("dangerClauseEOList").each(function (item) {
                    if (item.get("itemSerialNo") == current && item.get("checked") == true) {
                        sum = contractEntity.formatToTwoPrecision(sum + item.get(key)*1);
                    }
                });
            });
            if( arg.model.parent.items.current["_data"].checked ){
                sum = contractEntity.formatToTwoPrecision(sum - arg.oldValue + arg.value*1);
            }

            for(var i=0;i<originalDangerUnit.dangerClauseEOList.length;i++){
                var currentUnit = originalDangerUnit.dangerClauseEOList[i];
                if ((currentUnit.itemSerialNo) == current) {
                    if(sum>currentUnit[key] ){
                        cola.NotifyTipManager.warning({
                            message:"",
                            description:"警告: 该值已超过该标的下的总值, 请重新输入！",
                            showDuration:3000
                        });
                        return false;
                    }
                }

            }

        },
        amountChange: function (riskUnit) {
            // 占比/保额/保费变更
            var rate = 0;
            var sum = 0;
            var sumAmount = 0;
            var exchRateList = model.get("exchRateList");

            var changeAmount = [];
            var changePremium = [];
            var changeNumAmount = 0;
            var changeNumPremium = 0;

            var dangerClauseEOList = riskUnit.get("dangerClauseEOList");
            if (dangerClauseEOList) {
                dangerClauseEOList.each(function (dangerClauseItem,index) {

                    if (dangerClauseItem.get("checked")) {
                        sum = contractEntity.formatToTwoPrecision(sum + contractEntity.formatToTwoPrecision(dangerClauseItem.get("premium") * exchRateList[index]));
                        changePremium.push(Number(contractEntity.formatToTwoPrecision(dangerClauseItem.get("excPremium") * exchRateList[index])));
                        if(dangerClauseItem.get("calculateFlag") == "1"||dangerClauseItem.get("calculateFlag") == "Y"){
                            sumAmount = contractEntity.formatToTwoPrecision(sumAmount + Number(contractEntity.formatToTwoPrecision(dangerClauseItem.get("amount") * exchRateList[index])));
                            changeAmount.push(Number(contractEntity.formatToTwoPrecision(dangerClauseItem.get("excAmount") * exchRateList[index])));
                        }
                    }
                })
            }

            for (var i = 0; i < changeAmount.length; i++) {
                changeNumAmount = contractEntity.formatToTwoPrecision(changeNumAmount + changeAmount[i]*1);
            }
            for (var i = 0; i < changePremium.length; i++) {
                changeNumPremium = contractEntity.formatToTwoPrecision(changeNumPremium + changePremium[i]*1);
            }

            if (model.get("actuals").current.get("amount") && model.get("actuals").current.get("amount") != 0) {
                rate = sumAmount / oriAmountSum * 100;

            } else {
                rate = 100;
            }
            riskUnit.set("rate", contractEntity.formatToTwoPrecision(rate));
            riskUnit.set("premium", contractEntity.formatToTwoPrecision(sum+changeNumPremium));
            riskUnit.set("amount", contractEntity.formatToTwoPrecision(sumAmount+changeNumAmount));
        },
        selectAddAmount: function (self, arg) {
            debugger

            // 如果选中的原始标的在其他危险单位中已经选中 -> 要弹出提示,并且要把checked反写为false
            if( arg.item.toJSON().checked ){// 如果是由false变为true执行
                // var currentNo = arg.item.toJSON().serialNo;// 记录下改变的serialNo序号
                var current = arg.item.toJSON().itemSerialNo;
                var amountOri;
                var premiumOri;
                var amountSum = 0;
                var premiumSum = 0;

                // 计算当前操作勾选的标的在所有危险单位中的保额/保费之和 -> 如果超出原始标的的保额/保费要提示信息并且取消当前勾选操作
                model.get("riskUnits").each(function (riskUnit) {
                    riskUnit.get("dangerClauseEOList").each(function (item) {
                        if (item.get("itemSerialNo") == current) {
                            if( item.get("checked") ){

                                amountSum = contractEntity.formatToTwoPrecision(amountSum + Math.floor( item.get("amount")*100 )/100);
                                premiumSum = contractEntity.formatToTwoPrecision(premiumSum + Math.floor( item.get("premium")*100 )/100);
                            }
                        }
                    });
                });

                for(var i=0;i<originalDangerUnit.dangerClauseEOList.length;i++){
                    var currentUnit = originalDangerUnit.dangerClauseEOList[i];
                    if (currentUnit.itemSerialNo == current) {
                        amountOri = originalDangerUnit.dangerClauseEOList[i].amount;
                        premiumOri = originalDangerUnit.dangerClauseEOList[i].premium;
                    }
                }

                if( contractEntity.formatToTwoPrecision(amountSum) > contractEntity.formatToTwoPrecision(amountOri) ){
                    cola.NotifyTipManager.warning({
                        message:"",
                        description:"警告: 该标的在各危险单位下的保额之和, 已超过该标的下的保额！",
                        showDuration:3000
                    });

                    arg.item.set("checked",false);
                    return false;
                }else if( contractEntity.formatToTwoPrecision(premiumSum) > contractEntity.formatToTwoPrecision(premiumOri) ){
                    cola.NotifyTipManager.warning({
                        message:"",
                        description:"警告: 该标的在各危险单位下的保费之和, 已超过该标的下的保费！",
                        showDuration:3000
                    });

                    arg.item.set("checked",false);
                    return false;
                }
            }


            // 重新计算当前危险单位保额保费占比
            var selectSum = [];
            var selectSumAmount = [];
            var selectNum = 0;
            var selectNumAmount = 0;
            var changeRate = 0;
            var arr = arg.item.parent.toJSON();
            var exchRateList = model.get("exchRateList");// 存放每一个原始标的中转换成签单币别的转换率

            var changeAmount = [];
            var changePremium = [];
            var changeNumAmount = 0;
            var changeNumPremium = 0;

            for (var i = 0; i < arr.length; i++) {
                if (arr[i].checked) {
                    selectSum.push(Number(contractEntity.formatToTwoPrecision(arr[i].premium * exchRateList[i])));
                    changePremium.push(Number(contractEntity.formatToTwoPrecision(arr[i].excPremium * exchRateList[i])));
                    if(arr[i].calculateFlag == '1'||arr[i].calculateFlag == 'Y'){
                        selectSumAmount.push(Number(contractEntity.formatToTwoPrecision(arr[i].amount * exchRateList[i])));
                        changeAmount.push(Number(contractEntity.formatToTwoPrecision(arr[i].excAmount * exchRateList[i])));
                    }
                }
            }
            for (var i = 0; i < selectSum.length; i++) {
                selectNum = contractEntity.formatToTwoPrecision(selectNum + selectSum[i]*1);
            }
            for (var i = 0; i < selectSumAmount.length; i++) {
                selectNumAmount = contractEntity.formatToTwoPrecision(selectNumAmount + selectSumAmount[i]*1);
            }
            for (var i = 0; i < changeAmount.length; i++) {
                changeNumAmount = contractEntity.formatToTwoPrecision(changeNumAmount + changeAmount[i]*1);
            }
            for (var i = 0; i < changePremium.length; i++) {
                changeNumPremium = contractEntity.formatToTwoPrecision(changeNumPremium + changePremium[i]*1);
            }
            if (sum != 0) {
                changeRate = selectNumAmount / oriAmountSum * 100;
            } else {
                changeRate = 100;
            }

            arg.item.parent.parent.set("rate", contractEntity.formatToTwoPrecision(changeRate));
            arg.item.parent.parent.set("premium", contractEntity.formatToTwoPrecision(selectNum+changeNumPremium));
            arg.item.parent.parent.set("amount", contractEntity.formatToTwoPrecision(selectNumAmount+changeNumAmount));
            arg.item.parent.parent.set("changeNumAmount", contractEntity.formatToTwoPrecision(changeNumAmount));
            arg.item.parent.parent.set("changeNumPremium", contractEntity.formatToTwoPrecision(changeNumPremium));
        },
        // 分保试算，需要加判断，核保通过之前，调分保试算。核保通过之后，调查询分保试算。
        insuranceTrail: function () {

            // 分保试算之前先校验 -> 再保存
            if(params.taskType != "04"){
                var passFlag = saveAll();

                if(!window.saveSuccessFlag){
                    // 隐藏等待动画
                    $(".waittingBox").css("display","none");
                    return;
                }
            }



            $.ajax({
                url: "controller/insurance/reinsurance/reinsTrial?actualId=" + actualId,
                type: "POST",
                contentType: "application/json",
                // dataType: "json",
                success: function (data) {
                    // 隐藏等待动画
                    $(".waittingBox").css("display","none");

                    if (data && data.reinsTrialDangerViewDtoList.length>0) {
                        if(data.responseCode=="0000"){
                            window.hasDangerUnitFlag = true;
                        }

                        var reinsTrialDangerViewDtoList = [];
                        data.reinsTrialDangerViewDtoList.forEach(function (dangerViewDto) {
                            if (dangerViewDto.reinsTrialViewDtoList) {
                                if (dangerViewDto.dangerNo == 0) {
                                    return;
                                }
                                var summary = {
                                    refNo: "合计",
                                    shareRate: 0,
                                    amount: 0,
                                    premium: 0,
                                    commission: 0,
                                    noTaxPremium: 0,
                                    taxFee: 0,
                                    chgAmount: 0,
                                    chgCommission: 0,
                                    chgNoTaxPremium: 0,
                                    chgPremium: 0,
                                    chgTaxFee: 0
                                };
                                dangerViewDto.reinsTrialViewDtoList.forEach(function (reinsTrialViewDto) {
                                    summary.amount += reinsTrialViewDto.amount*1;
                                    summary.shareRate += reinsTrialViewDto.shareRate*1;
                                    summary.premium += reinsTrialViewDto.premium*1;
                                    summary.commission += reinsTrialViewDto.commission*1;
                                    summary.noTaxPremium += reinsTrialViewDto.noTaxPremium*1;
                                    summary.taxFee += reinsTrialViewDto.taxFee*1;
                                    if( model.get("uwEndorsementFlag") != -1 ){
                                        // 只有核批中才有这里面的字段
                                        summary.chgAmount += reinsTrialViewDto.chgAmount*1;
                                        summary.chgCommission += reinsTrialViewDto.chgCommission*1;
                                        summary.chgNoTaxPremium += reinsTrialViewDto.chgNoTaxPremium*1;
                                        summary.chgPremium += reinsTrialViewDto.chgPremium*1;
                                        summary.chgTaxFee += reinsTrialViewDto.chgTaxFee*1;
                                    }
                                });
                                dangerViewDto.reinsTrialViewDtoList.push(summary);
                            }
                            reinsTrialDangerViewDtoList.push(dangerViewDto);
                        });
                        model.set("reinsShareDtoList", reinsTrialDangerViewDtoList);
                        window.hasDangerUnitFlag = true;
                        cola.tag("reinsuranceStatus").set("disabled",false);
                    }else{
                        cola.NotifyTipManager.warning({
                            message:"",
                            description:"警告: 分保试算失败！",
                            showDuration:3000
                        });
                    }
                },
                error: function () {
                    // 隐藏等待动画
                    $(".waittingBox").css("display","none");
                }
            });

            // 显示弹框
            cola.widget("insuranceTrail").show();
        },
        // 临分意向发起
        commitInquiry: function () {


            // 临分之前先校验 -> 再保存
            var passFlag = saveAll(null,true);
            if(!window.saveSuccessFlag){
                return;
            }
            findEnquiryInfo();
            cola.widget("commitInquiry").show();
        },
        // 临分意向提交再保按钮
        confirmCommitInquiry: function () {
            // saveAll();

            if(model.get("FLAG") != "success"){
                // 传输到后台的数据需要提前把checkbox绑定的对应字段进行转化: true转成1,false转成0
                var enquiryInfo = model.get("enquiryInfo").toJSON();
                for(var i= 0,len=enquiryInfo.enquiryReceiveList.length;i<len;i++){
                    enquiryInfo.enquiryReceiveList[i].facFlag = enquiryInfo.enquiryReceiveList[i].facFlag==true?"1":"0";
                    enquiryInfo.enquiryReceiveList[i].currencyFlag = enquiryInfo.enquiryReceiveList[i].currencyFlag==true?"1":"0";
                    enquiryInfo.enquiryReceiveList[i].reinsType = enquiryInfo.enquiryReceiveList[i].reinsType==true?"1":"0";
                }

                // 显示等待动画
                $(".waittingBox").css("display","block");
                $.ajax({
                    url: "controller/insurance/enquiry/enquiryVerify?actualId=" + actualId,// 该接口保存临分询价信息&发起临分询价
                    type: "POST",
                    contentType: "application/json",
                    // dataType: "json",
                    data: JSON.stringify(enquiryInfo),
                    // 成功则调用再保系统接口
                    success: function (data) {
                        if (data) {
                            var data = showEnquiryInfo(data);
                            model.set("FLAG", "success");
                            model.set("enquiryInfo", data);

                            //设置沟通历史数据
                            model.set("enquiryVerifyList",data.enquiryVerifyList);

                            // 隐藏等待动画
                            $(".waittingBox").css("display","none");
                            cola.widget("enquiryVerifyDialog").toggle();
                        }
                    },
                    error: function () {
                        // 隐藏等待动画
                        $(".waittingBox").css("display","none");

                        cola.NotifyTipManager.warning({
                            message:"",
                            description:"调用再保系统接口失败！",
                            showDuration:3000
                        });
                    }
                });
            }else{
                cola.widget("commitInquiry").hide();
            }

        },
        closeEnquiryVerifyDialog: function(){
// cola.widget("commitInquiry").hide();
            cola.widget("enquiryVerifyDialog").toggle();
        },
        // 危险单位累计查询
        cumulativeQuery: function () {

            cola.widget("cumulativeQuery").show();
        },
        hide: function (dom) {
            cola.widget(dom).hide();
        },
        commitInquiryDelete: function (item) {
            item.remove()
        },
        commitInquiryAdd: function () {
            var len = model.get("enquiryInfo.enquiryReceiveList").toJSON().length;
            var max = len>0?model.get("enquiryInfo.enquiryReceiveList").toJSON()[len-1].serialNo:0;
            model.get("enquiryInfo.enquiryReceiveList").insert({
                serialNo: max*1 + 1
            });
        },
        // 添加危险单位
        addSegregation: function () {

            // 备份的原始数据
            var newList = getNewDangerUnit();
            for(var i=0;i<newList.dangerClauseEOList.length;i++){
                newList.dangerClauseEOList[i].checked = false;
            }

            // 循环之前每一项危险单位中的标的 -> 找到之前已经checked过的标的,在新的数据中取消选择
            var riskUnits = model.get("riskUnits");
            var hasNotChecked;
            riskUnits.each(function (riskUnit) {

                hasNotChecked = true;

                riskUnit.get("dangerClauseEOList").each(function (item,index) {
                    if(item.get("checked")){
                        // 设置标的的选中与否
                        // newList.dangerClauseEOList[index].checked = false;

                        hasNotChecked = false;
                    }
                });

                // 如果能进这个判断代表当前危险单位中的标的全部没有选中
                if( hasNotChecked ){
                    cola.NotifyTipManager.warning({
                        message:"",
                        description:"警告: 存在未选择任何标的的危险单位！",
                        showDuration:3000
                    });

                    return false;
                }
            });
            if( hasNotChecked ){
                return false;
            }


            var count = model.get("riskUnits").entityCount;
            newList.serialNo = count+1;
            // 把新数据插入到危险单位数组中
            model.get("riskUnits").insert(newList);
            // 重新计算保额/保费占比
            model.action("amountChange")(model.get("riskUnits").last());

        },
        reset: function () {// 重置
            model.set("riskUnits", [getNewDangerUnit()]);
        },
        // 删除当前危险单位
        delRiskUnit: function (riskUnit) {
            var len = model.get("riskUnits").toJSON().length;
            if (len > 1) {
                cola.confirm("确认删除当前危险单位吗?", function () {
                    riskUnit.remove();
                })
            } else {
                cola.NotifyTipManager.warning({
                    message:"",
                    description:"请至少保留一条危险单位！",
                    showDuration:3000
                });
            }
        },
        // 校验PML金额
        checkPmlAmount: function (riskUnit) {
            var PmlAmount = riskUnit.get("pmlAmount")*1;
            var amount = riskUnit.get("amount")*1;

            if(!PmlAmount){
                cola.NotifyTipManager.warning({
                    message:"",
                    description:"请输入合法的PML值！",
                    showDuration:3000
                });
                riskUnit.set("pmlAmount",0);
                return;
            }

            if( PmlAmount > amount ){
                cola.NotifyTipManager.warning({
                    message:"",
                    description:"PML金额值应小于等于保额且大于0, 请重新输入！",
                    showDuration:3000
                });
                riskUnit.set("pmlAmount",0);
            }else if(PmlAmount < 0 || PmlAmount == 0){
                cola.NotifyTipManager.warning({
                    message:"",
                    description:"请输入合法的PML值！",
                    showDuration:3000
                });
                riskUnit.set("pmlAmount",0);
            }
        }

    });

    function saveAll (ev,onlyCheck) {
        debugger
        // 调用接口前校验危险单位占比总和以及该险位是否已做风险等级评估(目前风险等级评估未校验)
        var rateSum = 0;
        var entityList = model.get("riskUnits");
        var pmlFlag = false;
        var riskFlag = false;
        var premiumSum = 0;
        var exchRateList = model.get("exchRateList");


        entityList.each(function (riskUnit) {
            rateSum = contractEntity.formatToTwoPrecision(rateSum + riskUnit.get("rate") * 1);

            // 校验PML
            if(model.get("showPMLFlag")){
                if(!riskUnit.get("pmlCurrency")||!riskUnit.get("pmlAmount")||riskUnit.get("pmlCurrency")==""||riskUnit.get("pmlAmount")==""){
                    pmlFlag = true;
                }
            }

            // 校验风险类别/风险等级
            if(!riskUnit.get("riskClass")){
                riskFlag = "风险类别";
            }else if(!riskUnit.get("riskLevel")){
                riskFlag = "风险等级";
            }

            // 校验保费是否等于总保费
            riskUnit.get("dangerClauseEOList").each(function (item,index) {
                if(item.get("checked")){
                    premiumSum = contractEntity.formatToTwoPrecision(premiumSum + item.get("premium")*exchRateList[index]);
                }
            })
        });

        pmlFlag = false;//目前不校验PML,如果后续校验,删除本行代码
        if(pmlFlag){
            cola.NotifyTipManager.warning({
                message:"",
                description:"警告: 请先录入PML值再进行该操作！",
                showDuration:3000
            });
            return false;
        }
        if(rateSum != 100){
            cola.NotifyTipManager.warning({
                message:"",
                description:"警告: 各危险单位占比之和不为100%, 请修正后再进行该操作！",
                showDuration:3000
            });
            return false;
        }
        if(riskFlag){
            cola.NotifyTipManager.warning({
                message:"",
                description:"警告: "+riskFlag+"不能为空, 请修改后再进行该操作! ",
                showDuration:3000
            });
            return false;
        }

        if(contractEntity.formatToTwoPrecision(premiumSum) != contractEntity.formatToTwoPrecision(sum)){

            cola.NotifyTipManager.warning({
                message:"",
                description:"警告: 危险单位中保费之和与各标的总保费不符 ( 相差"+contractEntity.formatToTwoPrecision(contractEntity.formatToTwoPrecision(premiumSum)-contractEntity.formatToTwoPrecision(sum))+" ) , 请修改后再进行该操作! ",
                showDuration:3000
            });
            return false;
        }

        window.passCheckFlag = true;
        if(!onlyCheck){
            var entityListOld = model.get("riskUnits");
            model.set("copyRiskUnits", entityListOld.toJSON());
            var entityList = model.get("copyRiskUnits");

            entityList.each(function (entity) {
                var dangerClauseEOList = entity.get("dangerClauseEOList");// 原始标的信息

                // var serialNo = 1;
                dangerClauseEOList.each(function (entity) {
                    if (entity.get("checked") == false) {
                        entity.remove();
                    } else {
                        // entity.set("serialNo", serialNo);
                        // serialNo++;
                    }
                });
            });
            var data = entityList.toJSON();

            // 显示等待动画
            $(".waittingBox").css("display","block");
            $.ajax({
                url: "controller/insurance/reinsurance/createDangerUnit?actualId=" + actualId,
                type: "POST",
                data: JSON.stringify(data),
                async: false,
                contentType: "application/json",
                success: function (data) {
                    model.set("dangerNo", data[0].dangerUnitId);
                    window.saveSuccessFlag = true;
                },
                error: function () {
                    window.saveSuccessFlag = false;
                    cola.NotifyTipManager.warning({
                        message:"",
                        description:"保存失败！",
                        showDuration:3000
                    });
                }
            });
        }

    };

    $(window).on("saveDangerUnits", saveAll);


});