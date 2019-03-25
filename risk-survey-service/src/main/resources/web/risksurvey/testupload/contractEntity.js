/**用于JS中操作保单或者报价的实体*/
function ContractEntity() {
    this.initInsuranceObjects = [];
    this.addressEntityList;
    this.addressSerialsKey = "addressSerials";
    this.actualSpecIds = {};
    this.specIdProductCode = {};
    this.taskId = null;
    this.systemType="";
    this.proParams = [];//条款下限额免赔接口参数
    this.productLimitObj;//存放通过条款code查到的对应的限额免赔
    this.systemType="";
    this.actualsSerialNo = {};//存放所有产品的下一次要添加的条责标的序号（最大）
    this.plcEngageMap = {
        T0012:{
            especialCode:"T0012",
            especialName:"汇率约定",
            especialClauses:"",
            especialFlag:"true"
        },
        T1001:{
            especialCode:"T1001",
            especialName:"48小时报案",
            especialClauses:"根据条款约定，投保人、被保险人或者保险金受益人知道保险事故发生后，应当在48小时内或经保险人书面同意延长的期限内通知保险人（24小时服务电话95519）。故意或者因重大过失未及时通知，致使保险事故的性质、原因、损失程度等难以确定的，保险人对无法确定的部分，不承担给付保险金责任。",
            especialFlag:"true"
        },
        T1003:{
            especialCode:"T1003",
            especialName:"伤残等级赔付比例标准调整",
            especialClauses:"在保险期间内，保险人依照主险条款约定应承担伤残保险金给付责任的，对应伤残程度鉴定标准以《人身保险伤残评定标准及代码》（保监发[2014]6号，标准编号为JR/T 0083-2013）规定的为准，其中其赔付比例分别是1级100%、2级75%、3级50%、4级30%、5级20%、6级15%、7级10%、8级7.5％、9级5％、10级2.5％。",
            especialFlag:"true"
        },
        T1004:{
            especialCode:"T1004",
            especialName:"伤残等级鉴定",
            especialClauses:"被保险人发生意外伤害事故，如需评定伤残等级，应到国家认可的合法司法鉴定机构（深圳市伤残鉴定机构约定为深圳市第二人民医院），鉴定标准以《人身保险伤残评定标准及代码》（保监发[2014]6号，标准编号为JR/T 0083-2013）规定的为准伤残鉴定，但鉴定前应由本保险公司出具伤残鉴定委托函，否则，本保险公司不予认可。",
            especialFlag:"true"
        },
        T1005:{
            especialCode:"T1005",
            especialName:"通用特约条款",
            especialClauses:"具体的保险责任、范围与条件以本保险单的约定为准；本保险单未尽事宜，以本保险单所附条款的规定为准。",
            especialFlag:"true"
        },
        T1006:{
            especialCode:"T1006",
            especialName:"每人保险金额约定",
            especialClauses:"本保险单项下每人A责任保险金额为人民币XXX元；每人B责任保险金额为人民币XXX元。",
            especialFlag:"true"
        },
        T1007:{
            especialCode:"T1007",
            especialName:"医疗约定",
            especialClauses:"附加意外伤害医疗费用保险出险索赔时，须提供医疗费用收据原件及诊断证明、处方、药费明细单、病历等医疗相关单据原件。出险治疗必须至二级及以上公立医院，如急诊至二级以下医院（需医保医院）治疗，只限出险当日 300 元以下紧急治疗，不含手术费及超一日量开药。",
            especialFlag:"true"
        },
        T1008:{
            especialCode:"T1008",
            especialName:"告知被保险人",
            especialClauses:"根据北京保监局（京保监发〔2014〕213号）要求，请贵单位将查询、打印保险凭证的网址以书面形式告知被保险人，网址：www.chinalife-p.com.cn；同时您可到北京人身意外伤害保险信息平台查询相关保单信息，查询网址：www.biabii.org.cn。",
            especialFlag:"true"
        },
        T1009:{
            especialCode:"T1009",
            especialName:"一次性缴费约定",
            especialClauses:" 兹经双方同意，本保险合同项下的保险费人民币xxxx元，由投保人于xxxx年xx月xx日前一次性交付。投保人未按约定支付保险费，经催告后仍未履行付费义务的，自催告通知书送达满三十日起保险合同即行解除。保险人对保险合同解除前发生的保险事故不承担赔偿保险金的责任。",
            especialFlag:"true"
        },
        T1010:{
            especialCode:"T1010",
            especialName:"48小时报案",
            especialClauses:"投保人、被保险人或受益人应在出险后48小时内及时报案，积极履行出险后的通知义务。否则，因投保人、被保险人或受益人拖延报案致使保险事故的性质、原因、损失程度难以确定的，保险人对无法确定的部分，不承担赔偿或者给付保险金的责任",
            especialFlag:"true"
        },
        T1011:{
            especialCode:"T1011",
            especialName:"免赔特约（附加险）",
            especialClauses:"每人附加意外伤害住院生活津贴免赔天数：天；附加意外伤害医疗费用保险免赔：对被保险人所支出的必要合理的、符合当地基本医疗保险主管部门规定可报销的医疗费用，保险人扣除人民币   元免赔额后，在保险金额范围内，按   ％比例给付医疗保险金。",
            especialFlag:"true"
        },
        T1012:{
            especialCode:"T1012",
            especialName:"个单特约",
            especialClauses:"人身意外伤害保险金额为  万元；附加意外伤害医疗费用保险金额为  万元；",
            especialFlag:"true"
        },
        T1013:{
            especialCode:"T1013",
            especialName:"团单特约（主险）",
            especialClauses:"每人人身意外伤害保险金额为  万元；每人附加意外伤害医疗费用保险金额为  万元；每人附加意外伤害住院生活津贴为  元/天。",
            especialFlag:"true"
        },
        T1014:{
            especialCode:"T1014",
            especialName:"免赔特约（附加险）",
            especialClauses:"每人附加意外伤害住院生活津贴免赔天数：天；附加意外伤害医疗费用保险免赔：对被保险人所支出的必要合理的、符合当地基本医疗保险主管部门规定可报销的医疗费用，保险人扣除人民币   元免赔额后，在保险金额范围内，按   ％比例给付医疗保险金。",
            especialFlag:"true"
        },
        T1015:{
            especialCode:"T1015",
            especialName:"第一受益人信息",
            especialClauses:"第一受益人：XX银行股份有限公司XX支行",
            especialFlag:"true"
        },
        T1016:{
            especialCode:"T1016",
            especialName:"每次事故绝对免赔约定",
            especialClauses:"每次事故绝对免赔额：XXX元RMB",
            especialFlag:"true"
        },
        T1017:{
            especialCode:"T1017",
            especialName:"投保房屋结构约定",
            especialClauses:"投保房屋结构仅限钢结构、钢筋混凝土、砖木结构",
            especialFlag:"true"
        },
        T1018:{
            especialCode:"T1018",
            especialName:"第三者医疗费用约定",
            especialClauses:"涉及第三者医疗费用的，每次事故每人医疗费用赔偿限额均为5000元",
            especialFlag:"true"
        },
        T1019:{
            especialCode:"T1019",
            especialName:"意外搬迁、临时住宿、清除残骸的费用约定",
            especialClauses:"意外搬迁、临时住宿、清除残骸的费用每次事故赔偿限额3000元",
            especialFlag:"true"
        },
        T1020:{
            especialCode:"T1020",
            especialName:"48小时报案",
            especialClauses:"根据条款约定，投保人、被保险人或者保险金受益人知道保险事故发生后，应当在48小时内或经保险人书面同意延长的期限内通知保险人（24小时服务电话95519）。故意或者因重大过失未及时通知，致使保险事故的性质、原因、损失程度等难以确定的，保险人对无法确定的部分，不承担给付保险金责任",
            especialFlag:"true"
        },
        T1021:{
            especialCode:"T1021",
            especialName:"付费约定",
            especialClauses:"兹经双方同意，本保险合同项下的保险费人民币XXX元，由投保人于XXXX年XX月XX日前一次性交付。投保人未按约定支付保险费，经催告后仍未履行付费义务的，自催告通知书送达满三十日起保险合同即行解除。保险人对保险合同解除前发生的保险事故不承担赔偿保险金的责任。本约定与主险条款内容相悖之处，以本约定为准；未尽之处，以主险条款为准。",
            especialFlag:"true"
        },
        T1022:{
            especialCode:"T1022",
            especialName:"第一受益人信息",
            especialClauses:"第一受益人：XX银行股份有限公司XX支行",
            especialFlag:"true"
        },
        T1023:{
            especialCode:"T1023",
            especialName:"每次事故绝对免赔约定",
            especialClauses:"每次事故绝对免赔额：XXX元RMB",
            especialFlag:"true"
        },
        T1024:{
            especialCode:"T1024",
            especialName:"投保房屋结构约定",
            especialClauses:"投保房屋结构仅限钢结构、钢筋混凝土、砖木结构",
            especialFlag:"true"
        },
    };
    this.isCumulativeOriCurAmount = {//存放是否累计保额的标志，条责标上是否累计到条款
        "9701317-1056":true, "9901671-1082":true, "9001382-1007":true, "9001397-1025":true,
        "9999999-1078":true, "9902193-1008":true, "9901861-1009":true, "9901782-1009":true,
        "9002091-1003":true, "9002093-1005":true, "9001382-1007":true, "9001397-1025":true,
        "9001565-1078":true, "9999999-1003":true, "9999999-1005":true, "9999999-1007":true,
        "9999999-1008":true, "9999999-1009":true, "9999999-1025":true, "9999999-1041":true,
        "9999999-1058":true, "9999999-1078":true
    };
    this.noTaxRateList={};//税优的条款代码(数组里的税率为0)
}

//遍历block
function getJson(arr, arr_result) {
    arr_result = arr_result || [];
    for (var j in arr) {
        var obj = {};
        for (var i in arr[j]) {
            if (Array.isArray(arr[j][i])) {
                arguments.callee(arr[j][i], arr_result);  //callee相当于一个函数名，避免函数修改问题;
            } else {
                obj[i] = arr[j][i]
            }
        }
        arr_result.push(obj)
    }
    return arr_result;
}

//截取路径的最后一个值
function getIndexOfLast(str, fuhao) {
    var _index = str.indexOf(fuhao);
    var _str;
    if (_index > 0) {//有值
        _str = str.substring(_index + 1);
    } else {
        _str = str;//不需要分割
    }
    return _str;
}

//判断地址是不是标的
ContractEntity.prototype.judgeAddress = function(productCode){
  var arr=["01010001","01010002","01010003","01010004","01010005","01010006",
    "01050002","01050004","02020002","01980001","01980002","01980003","01060002",
    "01060004","01060003","01110001","01060001","01050003","01050001","01090001",
    "01070001","01020001","01020002","01020003","01030001","01030002","01030003",
    "01030004","01040001","01040002","01040003","01040004","01080001","01980004",
    "01080002","01110003","01080003","01100001","01110002","01100002","31110001",
    "05010001","05010002","05010003","05020001","05020002","05020003","05030001",
    "05040001"];
  
  if(productCode){
    if(arr.indexOf(productCode)!=-1){
      return true;
    }else{
      return false;
    }
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
//判断受益比例
ContractEntity.prototype.checkBeneficiaryBenefitRate = function(model){
  var actualList = model.get('actuals');
     var flagBeneficiary=true,Beneflags=true;
     actualList.each(function(actual,index){
       var beneficiaryArray=[];
       var beneficiaryList=actual.get('plcBeneficiary');
        var PlcInsurants = actual.get("plcInsurant");
       if(beneficiaryList && beneficiaryList.entityCount>0){
         var benef=[];
         beneficiaryList.each(function(beneficiary,index){
         var customerType=beneficiary.get('customerType');
         var thisLinkNo="";
             var relationToMainInsured ="";
             if(customerType=='1'){
              thisLinkNo=beneficiary.get("plcCustomer.linkNo")
              relationToMainInsured=beneficiary.get("plcCustomer.relationToMainInsured")
             }else if(customerType=='2'){
              thisLinkNo=beneficiary.get("plcGrpCustomer.linkNo")
              relationToMainInsured=beneficiary.get("plcGrpCustomer.relationToMainInsured")
             }
                if(relationToMainInsured=="01"){
                    if(PlcInsurants){
                        PlcInsurants.each(function(insurt,index){
                            if(thisLinkNo==insurt.get("serialNo")){
                                if(beneficiary.get("customerType")!=insurt.get("customerType")){
                                    App.alert("受益人与被保险人/本人-关系人类型不一致");
                                    Beneflags=false;
                                }else if(beneficiary.get("customerName")!=insurt.get("customerName")){
                                    App.alert("受益人与被保险人/本人-关系人名称不一致");
                                    Beneflags=false;
                                }else if(beneficiary.get("identifyType")!=insurt.get("identifyType")){
                                    App.alert("受益人与被保险人/本人-证件类型不一致");
                                    Beneflags=false;
                                }else if(beneficiary.get("identifyNumber")!=insurt.get("identifyNumber")){
                                    App.alert("受益人与被保险人/本人-证件号码不一致");
                                    Beneflags=false;
                                }
                                if(customerType=="1"){
                                    if(beneficiary.get("plcCustomer.sex")!=insurt.get("plcCustomer.sex")){
                                        App.alert("受益人与被保险人/本人-性别不一致");
                                        Beneflags=false;
                                    }else if(beneficiary.get("plcCustomer.birthDate")&&insurt.get("plcCustomer.birthDate")&&(beneficiary.get("plcCustomer.birthDate").getTime()!=insurt.get("plcCustomer.birthDate").getTime())){
                                        App.alert("受益人与被保险人/本人-出生年月不一致");
                                        Beneflags=false;
                                    }
                                }

                            }
                        })
                    }
                }
                var linkNo="";
             if(customerType=='1'){
               linkNo=beneficiary.get("plcCustomer.linkNo");
             }else if(customerType=='2'){
               linkNo=beneficiary.get("plcGrpCustomer.linkNo");
             }
                if(beneficiaryArray.length==0 || benef.length==0){
                 benef.push({linkNo:linkNo})
                 benef.push([]);
                 benef[1].push(beneficiary)
                 beneficiaryArray.push(benef);
                }else{
                 var flag=true;
                 for(var i=0;i<beneficiaryArray.length;i++){
                   if(beneficiaryArray[i][0].linkNo==linkNo){
                     beneficiaryArray[i][1].push(beneficiary)
                     flag=false;
                   }
                 }
                 if(flag){
                   benef=[];
                 benef.push({linkNo:linkNo})
                     benef.push([]);
                     benef[1].push(beneficiary)
                     beneficiaryArray.push(benef);
                 }
                }
          });
            for(var i=0;i<beneficiaryArray.length;i++){
             var benefitRate1=0;
             var flag1=false;
             var benefitRate2=0;
             var flag2=false;
             var benefitRate3=0;
             var flag3=false;
             var linkNo=beneficiaryArray[i][0].linkNo;
             var entitylist=beneficiaryArray[i][1]
             for(var j=0;j<entitylist.length;j++){
               var customerTypeFlag=entitylist[j].get('customerType');
               if(customerTypeFlag=='1'){
                     if(entitylist[j].get('plcCustomer.benefitSerialNo')=='1'){
                       benefitRate1+=entitylist[j].get('plcCustomer.benefitRate')
                       flag1=true;
                     }else if(entitylist[j].get('plcCustomer.benefitSerialNo')=='2'){
                       benefitRate2+=entitylist[j].get('plcCustomer.benefitRate')
                       flag2=true;
                     }else if(entitylist[j].get('plcCustomer.benefitSerialNo')=='3'){
                       benefitRate3+=entitylist[j].get('plcCustomer.benefitRate')
                       flag3=true;
                     }
                    }else if(customerTypeFlag=='2'){
                     if(entitylist[j].get('plcGrpCustomer.benefitSerialNo')=='1'){
                       benefitRate1+=entitylist[j].get('plcGrpCustomer.benefitRate')
                       flag1=true;
                     }else if(entitylist[j].get('plcGrpCustomer.benefitSerialNo')=='2'){
                       benefitRate2+=entitylist[j].get('plcGrpCustomer.benefitRate')
                       flag2=true;
                     }else if(entitylist[j].get('plcGrpCustomer.benefitSerialNo')=='3'){
                       benefitRate3+=entitylist[j].get('plcGrpCustomer.benefitRate')
                       flag3=true;
                     }
                    }
             }
             if(flag1 && benefitRate1!=100){
             App.alert("产品"+(index+1)+"-关联被保人"+linkNo+"—受益顺序1—受益比例之和("+benefitRate1+"%)不为100%，请修改！")
            flagBeneficiary=false;
           }
          if(flag2 && benefitRate2!=100){
             App.alert("产品"+(index+1)+"-关联被保人"+linkNo+"—受益顺序2—受益比例之和("+benefitRate2+"%)不为100%，请修改！")
             flagBeneficiary=false;
          }
          if(flag3 && benefitRate3!=100){
             App.alert("产品"+(index+1)+"-关联被保人"+linkNo+"—受益顺序3—受益比例之和("+benefitRate3+"%)不为100%，请修改！")
             flagBeneficiary=false;
          }
            }
        }
     });
     if(!Beneflags | !flagBeneficiary){
       return true;
     }else {
       return false;
     }
}
/**
 * 初始化区块右侧菜单顺序
 */
ContractEntity.prototype.initRightMenu = function (model) {
    var objnum = 0;
    model.set("rightGuideMenu", []);
    var d = model.get("rightGuideMenu");
    model.get("subviews").each(function (subviewItem, index) {
        var obj = subviewItem.get("pageBlocks");
        if (obj) {
            obj.each(function (pageBlocks) {
                d.insert({id: "00", name: "产品" + (objnum + 1), fontWeight: "bold"});
                pageBlocks.get("childrens").each(function (child) {
                    if(contractEntity.getSystemType()=="policy"&&child.get("kind")=="plcSolution"){
                        child.get("childrens").each(function(solutionChild){
                            if(!(subviewItem.get("isHideCoinsRightMenu")&&(solutionChild.get("kind")=="plcCoins"))){
                                d.insert({
                                    id: solutionChild.get("uuid"),
                                    name: solutionChild.get("blockName"),
                                    specId: solutionChild.get("specId"),
                                    kind: solutionChild.get("kind")
                                });
                            }
                        });
                    }
                    else{
                    d.insert({id: child.get("uuid"), name: child.get("blockName"),specId:child.get("specId"),kind:child.get("kind")});
                    }
                })
            })
        }
        objnum++;
    });
}
/***
 * 增加一个ROLE
 * @param entity
 * @param model
 */
ContractEntity.prototype.addRole = function (entity, model, callback) {
    var kind = entity._parentProperty;
    var parent = entity.parent;
    App.addBusinessChild(model, parent, kind, function (newEntity, responseData) {
        callback && callback(newEntity, responseData);
    }).done(function (newEntity) {

    }).fail(function (data) {
    });
}
/**
 *
 * @param parentEntity 父节点实体
 * @param model   保单跟根节点
 * @param kind  标识
 * @param dataParamArray  参数集合
 * @param callback  回调
 * @returns {*}
 */
ContractEntity.prototype.addRoles = function (parentEntity, model, kind, dataParamArray, callback, async) {
    var _selfAsync = true;
    if (async != undefined && !async) {
        _selfAsync = false;
    }
    var parentId = parentEntity.get("actualId");
    var schemaName = model.get("schemaName");
    var actualId = model.get("actual.actualId");
    var url = "controller/insurance/businessEntity/addRoles?actualId=" + actualId + "&parentId=" + parentId + "&kind=" + kind + "&count=" + dataParamArray.length;
    return $.ajax({
        url: url,
        type: "POST",
        async: _selfAsync,
        contentType: "application/json",
        data: JSON.stringify(dataParamArray),
        success: function (responseData) {
            var responseList = [];
            $.each(responseData, function (index, item) {
                var newEntity = parentEntity.createChild(kind, item.actual);
                newEntity.setState(cola.Entity.STATE_NONE);
                responseList.push(newEntity);
            })
            callback && callback(responseList, responseData);
            return responseList;
        },
        error: function () {
            cola.alert("[(#{saveFailed})]");
        }
    });
}
/**
 *
 * @param parentEntity  父节点实体
 * @param model  保单实体
 * @param kind  本身Role标识
 * @param dataParams   Role的默认值
 * @param callback  回调方法
 * @returns {*}
 */
ContractEntity.prototype.addRole = function (parentEntity, model, kind, dataParams, callback, async) {
    var _selfAsync = true;
    if (async != undefined && !async) {
        _selfAsync = false;
    }
    var parentId = parentEntity.get("actualId");
    var schemaName = model.get("schemaName");
    var actualId = model.get("actual.actualId");
    var url = "controller/insurance/businessEntity/addRole?actualId=" + actualId + "&parentId=" + parentId + "&kind=" + kind;
    return $.ajax({
        url: url,
        type: "POST",
        async: _selfAsync,
        contentType: "application/json",
        data: JSON.stringify(dataParams),
        success: function (responseData) {
            var newEntity = parentEntity.createChild(kind, responseData.actual);
            newEntity.setState(cola.Entity.STATE_NONE);
            callback && callback(newEntity, responseData);
            return newEntity;
        },
        error: function () {
            cola.alert("[(#{saveFailed})]");
        }
    });
}

/**
 * 初始化地址序号集合
 * @param model
 */
ContractEntity.prototype.setAdressSerials = function (model) {
    model.set(this.addressSerialsKey, []);
}

/***
 * 获取新的地址序号
 */
ContractEntity.prototype.getNewAddressIndex = function (model) {
    var max = 0;
    var entityList = model.get(this.addressSerialsKey);
    if (entityList) {
        entityList.each(function (entity) {
            if (entity.get("value") > max) {
                max = entity.get("value");
            }
        });
    }
    return max + 1;
}
/**
 * 复制新地址实体集合
 * @param entityList
 */
ContractEntity.prototype.setAddressEntityList = function (entityList, model) {
    var entities = model.get(this.addressSerialsKey);
    var entityMap = {};
    if (entityList) {
        entityList.each(function (entity) {
            entityMap[entity.get("adressNo")] = {value: entity.get("adressNo"), text: entity.get("adressNo")};
        });
    }
    for (var k in entityMap) {
        var flag = false;
        entities.each(function (obj) {
            if (obj.get("value") == k) {
                flag = true;
            }
        });
        if (!flag && (k != null && k != undefined && k != "undefined")) {
            entities.insert(entityMap[k]);
        }
    }

};
/**
 * 增加一个地址索引
 * @param addressIndex
 */
ContractEntity.prototype.addAddressIndex = function (addressIndex, model) {
    var entityList = model.get(this.addressSerialsKey);
    if (entityList) {
        entityList.insert({value: addressIndex, text: addressIndex});
    }
}
/**
 *移除一个地址索引
 */
ContractEntity.prototype.removeAddressIndex = function (addressIndex, model) {
    var entityList = model.get(this.addressSerialsKey);
    if (entityList) {
        entityList.each(function (entity) {
            if (entity.get("value") == addressIndex) {
                entityList.remove(entity);
                // break;
            }
        });
    }
}
/**
 * 获取所有的地址索引
 * @returns {Array}
 */
ContractEntity.prototype.getAllAddressIndex = function () {
    return this.addressIndex;
}


/**
 * 增加个标的
 * @param insuranceObject
 */
ContractEntity.prototype.addInsuranceObject = function (insuranceObject) {
    this.initInsuranceObjects.push(insuranceObject);
}
/**
 * 标的集合大小
 * @returns {string|Number|number|string|*}
 */
ContractEntity.prototype.getInsuranceObjectSize = function () {
    return this.initInsuranceObjects.length;
}

/**
 * 动态增加多个Role
 * @returns {*}
 */
ContractEntity.prototype.addMutiSameRole = function (model, parentEntity, kind, num) {
    return $.post("controller/insurance/businessEntity/addMutiSameRole",
        {
            schemaName: model.get("schemaName"),
            actualId: model.get("actualId"),
            parentId: parentEntity.get("actualId"),
            kind: kind,
            num: num
        }
    ).done(function (responseData) {
        var newEntities = [];
        for (var i = 0; i < responseData.length; i++) {
            var newEntity = parentEntity.createChild(property, responseData[i].actual);
            newEntity.setState(cola.Entity.STATE_NONE);
            newEntities.push(newEntity);
        }
        callback && callback(newEntities, responseData);
        return newEntities;
    });
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

ContractEntity.prototype.blockBindMenu = function (model) {
    //菜单与block双向滑动绑定
    var blockDomList = [];
    blockDomList.push("#custominfo");
    blockDomList.push("#baseinfo");
    model.get("rightGuideMenu").each(function (item) {
        if (item.get("id")) {
            blockDomList.push("#" + item.get("id"));
        }
    });
    blockDomList.reverse();
    window.scrollFlag = false;//解决点击触发滑动问题
    $(window).scroll(function () {
        if (window.scrollFlag) {
            setTimeout(function(){
                window.scrollFlag = false;
            },300);//处理点击菜单滚动页面后重复触发滚动条事件
            return;
        }
        $.each(blockDomList, function (index, item) {
            if ($(item).offset() && ($(item).offset().top - $(window).scrollTop()+1 < 0)) {
                var ind = blockDomList.length - 1 - index;
                $('#navRight ul li').removeClass("currentNav");
                $('#navRight ul li').eq(ind).addClass("currentNav");
                return false;
            }
        });
    });
}

ContractEntity.prototype.errorBlockNav = function (model) {
    if (!model.get("rightGuideMenu")) {
        return;
    }
    var selfNum = 0;
    var hasError=false;
    if ($("#custominfo").find(".error").length > 0) {
        hasError=true;
        $("#navRight ul li").eq(0).addClass("rightError");
    } else {
        $("#navRight ul li").eq(0).removeClass("rightError");
    }
    if ($("#baseinfo").find(".error").length > 0) {
        hasError=true;
        $("#navRight ul li").eq(1).addClass("rightError");
    } else {
        $("#navRight ul li").eq(1).removeClass("rightError");
    }
    model.get("rightGuideMenu").each(function (rightNavItem) {
        var itemUuid = rightNavItem.get("id");
        if ($("#" + itemUuid).find(".error").length > 0) {
            hasError=true;
            $("#navRight ul li").eq(selfNum + 2).addClass("rightError");
        } else {
            $("#navRight ul li").eq(selfNum + 2).removeClass("rightError");
        }
        selfNum++;
    });

if(hasError){
    //小屏收起菜单标志标红
    $('.error').eq(1).find('input').focus();//eq0为菜单中的标红
    $(window).scrollTop($('.error').eq(1).offset().top-80);
    $('.menus message').removeClass("display-none");
    //尝试自动定位并且焦点到错误位置
}else{
    $('.menus message').addClass("display-none");
}


}
/**获取URL中的actualIds*/
ContractEntity.prototype.getQueryParams = function (model) {

    var actuals = model.get("actuals");
    var actualIds = "actualId=";
    var specIds = "specId=";
    var productCodes = "productCode=";
    var isInsuranceGroups="isInsuranceGroup=";//是否团单
    var anonymousFlags="anonymousFlag=";//是否记名
    var $obj = this;
    var specIdArray = [];
    var actualIdArray = [];
    var productCodeArray = [];
    var isInsuranceGroupArray=[];
    var anonymousFlagArray=[];
    actuals.each(function (actual) {
        var actualId = actual.get("actualId");
        var specId = actual.get("specId");
        var productCode = actual.get("productCode");
        var isInsuranceGroup=actual.get("groupPolicyFlag");
        var anonymousFlag=actual.get("anonymousFlag");
        actualIdArray.push(actualId);
        specIdArray.push(specId);
        productCodeArray.push(productCode);
        isInsuranceGroupArray.push(isInsuranceGroup);
        anonymousFlagArray.push(anonymousFlag);
        $obj.actualSpecIds[actualId] = specId;

    });
    var newParam = "";
    var urlParmas = cola.util.queryParams();
    for (var key in urlParmas) {
        if (key == "actualId" || key == "specId" || key == "productCode" || key == "isInsuranceGroup" || key == "anonymousFlag") {

        }
        else {
            newParam += "&" + key + "=" + urlParmas[key];
        }
    }
    this.filterOldSpecIdProductCode(specIdArray);
    if (actualIdArray.length > 0) actualIds = actualIds + actualIdArray.join(",");
    if (specIdArray.length > 0) specIds = specIds + specIdArray.join(",");
    if (productCodeArray.length > 0) productCodes = productCodes + productCodeArray.join(",");
    if (isInsuranceGroupArray.length > 0) isInsuranceGroups = isInsuranceGroups + isInsuranceGroupArray.join(",");
    if (anonymousFlagArray.length > 0) anonymousFlags = anonymousFlags + anonymousFlagArray.join(",");
    return actualIds + "&" + specIds + "&" + productCodes + "&"+ isInsuranceGroups+"&"+ anonymousFlags+ newParam;
}
/**根据actualId移除actual*/
ContractEntity.prototype.removeActualByActualId = function (model, actualId) {
    if (!actualId) return;
    var actuals = model.get("actuals");
    if (!actuals) return;
    actuals.each(function (actual) {
        var aId = actual.get("actualId");
        if (aId == actualId) actual.remove();
    });
}
/**塞入Specid对应的ProductCode*/
ContractEntity.prototype.putSpecIdProductCode = function (specId, productCode) {
    this.specIdProductCode[specId] = productCode;
}
/**根据SpecId删除元素*/
ContractEntity.prototype.removeSpecIdProductCode = function (specId) {
    delete this.specIdProductCode[specId];
}
/**根据SpecId获取产品代码*/
ContractEntity.prototype.getSpecIdProductCode = function (specId) {
    return this.specIdProductCode[specId];
}
/**过滤掉旧的产品编码*/
ContractEntity.prototype.filterOldSpecIdProductCode = function (specIdArray) {
    var newSpecIdProductCode = {};
    var l = 0;
    for (var a in this.specIdProductCode) {
        l = l + 1;
    }
    for (var a in specIdArray) {
        if (this.specIdProductCode[specIdArray[a]]) {
            newSpecIdProductCode[specIdArray[a]] = this.specIdProductCode[specIdArray[a]];
        }
    }
    if (l > 1) {
        this.specIdProductCode = newSpecIdProductCode;
    }
}
/**启动流程*/
ContractEntity.prototype.startProcess = function (schemaName, model, processDefinitionKey, taskType, parameters) {
    var actuals = model.get("actuals");
    var cap = model.get("cap");
    var actualIdArray = [];
    var specIdArray = [];
    var productCodeArray = [];
    actuals.each(function (actual, index) {
        actualIdArray.push(actual.get("actualId"));
        specIdArray.push(actual.get("specId"));
        productCodeArray.push(actual.get("productCode"));
    });
    var appHeadId;
    if (cap && cap.get("conbineHead")) {
        appHeadId = cap.get("conbineHead").get("appHeadId");
    }
    return $.ajax({
        url: "controller/insurance/process/startProcessByKey",
        type: "POST",
        async: false,
        contentType: "application/json",
        data: JSON.stringify({
            taskType: taskType,
            schemaName: schemaName,
            processDefinitionKey: processDefinitionKey,
            taskType: taskType,
            actualIds: actualIdArray.join(","),
            specIds: specIdArray.join(","),
            productCodes: productCodeArray.join(","),
            appHeadId: appHeadId,
            parameters: parameters
        }),
        success: function (data) {
            return data;
        }
    });
}
ContractEntity.prototype.getProductClass = function (callback) {
    $.ajax({
        url: "service/product/productClass/getCachedProductClasses",
        async: true,
        success: function (data) {
            if (callback) callback(data);
        }
    })
}

/**taskId*/
ContractEntity.prototype.setTaskId = function (taskId) {
    this.taskId = taskId;
}
ContractEntity.prototype.getTaskId = function () {
    return this.taskId;
}

ContractEntity.prototype.insertBasicInformation = function (currentActual) {
    //车牌号码？产品组合号？合同号码？车主？VIN码？发动机号？暂未添加
    if (currentActual.get("plcApplicant").entityCount > 0) {
        var applicantCode = currentActual.get("plcApplicant").first().get("customerCode");//投保人代码
        var applicantName = currentActual.get("plcApplicant").first().get("customerName");//投保人姓名
        var applicantType = currentActual.get("plcApplicant").first().get("customerType");//关系人类型（投保人）
        var applicantGrade = currentActual.get("plcApplicant").first().get("customerGradeName");//投保人等级（投保人）customerGradeName
        var applicantGradeCode = currentActual.get("plcApplicant").first().get("customerGrade");//投保人等级代码（投保人）
        currentActual.set("plcBasic.applicantCode", applicantCode);
        currentActual.set("plcBasic.applicantName", applicantName);
        currentActual.set("plcBasic.customerType", applicantType);
        currentActual.set("plcBasic.applicantGrade", applicantGrade);
        currentActual.set("plcBasic.applicantGradeCode", applicantGradeCode);
    }

    // 被保人
    if (currentActual.get("plcInsurant") && currentActual.get("plcInsurant").entityCount > 0) {
        var insurantCode = currentActual.get("plcInsurant").first().get("customerCode");//被投保人代码
        var insurantName = currentActual.get("plcInsurant").first().get("customerName");//被保人姓名
        currentActual.set("plcBasic.insurantCode", insurantCode);
        currentActual.set("plcBasic.insurantName", insurantName);
        var insurantGrade = currentActual.get("plcInsurant").first().get("customerGradeName");//被投保人等级
        currentActual.set("plcBasic.insurantGrade", insurantGrade);
        var insurantIdentifyType = currentActual.get("plcInsurant").first().get("identifyType");//被保险人证件类型代码
        currentActual.set("plcBasic.insurantIdentifyType", insurantIdentifyType);
        var insurantIdentifyNumber = currentActual.get("plcInsurant").first().get("identifyNumber");//被保险人证件号码
        currentActual.set("plcBasic.insurantIdentifyNumber", insurantIdentifyNumber);
        var insurantIdentifyName = currentActual.get("plcInsurant").first().get("identifyName");//被保险人证件类型
        currentActual.set("plcBasic.insurantIdentifyName", insurantIdentifyName);
        var insurantGradeCode = currentActual.get("plcInsurant").first().get("customerGrade");//被保人等级代码
        currentActual.set("plcBasic.insurantGradeCode", insurantGradeCode);
    }
    // 打印信息
    if (currentActual.get("plcPrintInformation") && currentActual.get("plcPrintInformation").entityCount > 0) {
        var visaPrintType = currentActual.get("plcPrintInformation").first().get("visaPrintType");//打印类型
        var visaSerialNo = currentActual.get("plcPrintInformation").first().get("visaSerialNo");//单证流水号
        currentActual.set("plcBasic.visaPrintType", visaPrintType);
        currentActual.set("plcBasic.visaSerialNo", visaSerialNo);
        var visaCode = currentActual.get("plcPrintInformation").first().get("visaCode");//单证类型代码
        currentActual.set("plcBasic.visaCode", visaCode);
        var visaName = currentActual.get("plcPrintInformation").first().get("visaName");//单证类型名称
        currentActual.set("plcBasic.visaName", visaName);
    }
    
// 续保标志
    //var transrenewFlag = currentActual.get("transrenewFlag") ? currentActual.get("transrenewFlag") : "";
    //currentActual.set("actual.transrenewFlag", transrenewFlag);


}
//接口调用获取理赔金额和理赔次数
ContractEntity.prototype.getClaimTimeFee = function (actualItem) {
    var productCode = actualItem.get("productCode");
    var ristItemName = "plcRisk" + productCode + ".plcRiskFeatureInfo" + productCode;
    var riskItemclaimTimes = ristItemName + ".claimTimes";
    var riskItemclaimFee = ristItemName + ".claimFee";
    var arrNum = ["1", "2"];
    if (actualItem.get(ristItemName)) {
        /*
         $.ajax({
            url: "controller/insurance/proposaltask/findClaimTime",
            type:"POST",
            contentType: "application/json",
            data:JSON.stringify(arrNum),
            success:function(data){
                if(!data) return;
                var arrData=data.claimTimesList[0];
                actualItem.set(riskItemclaimTimes,arrData.damageCount);//理赔次数
                actualItem.set(riskItemclaimFee,arrData.sumDutyPaid)//理赔金额(已决赔款金额)
            }
        })*/

    }

}

/**
 * 判断当前的条款是不是在批改中删除的
 * @param {any} clause 
 */
function isDeleteClause(clause){
    var flag = true;
    if(clause.get("plcClauseItem") && clause.get("plcClauseItem").entityCount > 0){
        clause.get("plcClauseItem").each(function (item) {
            if( item.get("statusFlag")!=="3" ){
                flag = false;
            }
        });
    }else{
        flag = false;
    }

    return flag;
}

//保费计算按钮的事件
ContractEntity.prototype.calcPremium = function (model) {
    // 保费计算
    //原币 oriCurCode
    //原币保额 oriCurAmount
    //原币保费  oriCurPremium
    //人民币 001
    //保费计算需要自动带出特约，所以需要先判断是否已添加业务归属
    //判断是否添加归属机构    暂时隐藏保费计算自动带出特约
   /* var isAddBusinessOffice =true;
    model.get("actuals").each(function(actualItem){
        if(!actualItem.get("businessOffice")){
            isAddBusinessOffice=false;
        }
    });
    if(!isAddBusinessOffice){
        App.alert("请添加归属机构");
        return;
    }*/
    //判断是否添加归属机构结束
    var coinMessageArr = [];//币别信息汇总数据
    var solutionEntity;//当前报价方案entity
    var isSolution = false;// 是否是报价方案
    if(model.get("solution")){
        solutionEntity = model.get("solution");//当前报价方案entity
        isSolution = true;
    }else{
        solutionEntity=model.get("actual.plcSolution").current;
    }
    var signCurrencyCode = model.get("actual.signCurrencyCode");//签单币
    var staCurCode = model.get("actual.staCurCode");//本位币
    var mainPerm = solutionEntity.get("plcPackage").current.get("plcMainClause");
    var sigCurAmountTotleList = [];//签单币别保额
    var sigCurAmountTotle = 0;
    var sigCurPremiumTotleList = [];//签单币别保费
    var sigCurNetPremiumTotleList=[];//签单币不含税总保费
    var sigCurNetPremiumTotle=0;
    var sigCurPremiumTotle = 0;
    var applicantDateTime = model.get("actual.applicantDate");
    var startTime = model.get("actual.startTime");
    var endTime = model.get("actual.endTime");
    var taxFee = 0;//总税额
    var type=contractEntity.getSystemType();
    var exchangeDataObj=contractEntity.getExchangeRateTotal(model);//获取兑换率
    if(type!="quotation" && !window.isUwQuote){
        if (!(startTime && endTime && startTime != "Invalid Date" && endTime != "Invalid Date")) {
            cola.NotifyTipManager.warning({
                message: "",
                description: "请选择保险日期",
                showDuration: 3000
            });
            cola.tag("getCalcP").set("disabled", false);
            return false;
        }

        if (!mainPerm) {
            cola.NotifyTipManager.warning({
                message: "",
                description: "请选择条款",
                showDuration: 3000
            });
            cola.tag("getCalcP").set("disabled", false);
            return false;
        }

        var isCaclCorrect=true;
        solutionEntity.get("plcPackage").each(function(package){
            package.get("plcMainClause").each(function(mainClause){ // 主条款循环
                var mainOriCurAmount=Number(mainClause.get("$oriCurAmount"));
                var mainOriCurPremium=Number(mainClause.get("$oriCurPremium"));
                var mhasUpdate=mainClause.get("$isNotGather");//说明条款上修改过，需要校验汇总值是否相等
                if(mainClause.get("plcClauseItem") && mhasUpdate){
                    var morca=0 , morcp=0;
                    var params = cola.util.queryParams();
                    /*if(params.endorseType){ //综批触发
                        var endorseTime = new Date(model.get("actual.endorseTime")); //批改生效日
                        mainClause.get("plcClauseItem").each(function(mainClauseItem){
                            var itemEndTime = new Date(mainClauseItem.get("endTime")); //当前条款止期
                            if(itemEndTime >= endorseTime){
                                morca = morca + mainClauseItem.get("oriCurAmount");
                            }
                            morcp = morcp + mainClauseItem.get("oriCurPremium");
                        })
                    }else{ */
                    mainClause.get("plcClauseItem").each(function(mainClauseItem){
                        morca = morca + mainClauseItem.get("oriCurAmount");
                        morcp = morcp + mainClauseItem.get("oriCurPremium");
                    })
                    //}
                    if(morca != mainOriCurAmount || morcp != mainOriCurPremium){
                        isCaclCorrect = false ;
                        return false;
                    }
                }
                if(mainClause.get("plcAccessoryClause")){// 附加条款循环
                    mainClause.get("plcAccessoryClause").each(function(addClause){
                        var addOriCurAmount=addClause.get("$oriCurAmount");
                        var addOriCurPremium=addClause.get("$oriCurPremium");
                        var ahasUpdate=addClause.get("$isNotGather");//说明条款上修改过，需要校验汇总值是否相等
                        if(addClause.get("plcClauseItem") && ahasUpdate){
                            var aorca=0 , aorcp=0;
                            var params = cola.util.queryParams();
                            /*if(params.endorseType){ //综批触发
                                var endorseTime = new Date(model.get("actual.endorseTime")); //批改生效日
                                addClause.get("plcClauseItem").each(function(addClauseItem){
                                    var itemEndTime = new Date(mainClauseItem.get("endTime")); //当前条款止期
                                    if(itemEndTime >= endorseTime){
                                        aorca = aorca + addClauseItem.get("oriCurAmount");
                                    }
                                    aorcp = aorcp + addClauseItem.get("oriCurPremium");
                                })
                            }else{*/
                            addClause.get("plcClauseItem").each(function(addClauseItem){
                                aorca = aorca + addClauseItem.get("oriCurAmount");
                                aorcp = aorcp + addClauseItem.get("oriCurPremium");
                            })
                            //}
                            if(aorca != addOriCurAmount || aorcp != addOriCurPremium){
                                isCaclCorrect = false ;
                                return false;
                            }
                        }
                    })
                }
            })
        })
        if(!isCaclCorrect){
            App.alert("条款上保额，保费与条责标汇总值不等，请重新修改！");
            cola.tag("getCalcP").set("disabled", false);
            return false;
        }
    }else{

        cola.tag("getCalcP").set("disabled", false);


    }
    var flg = false;//addRole
    var aflag = true;//校验条责标数据是否完整
    if (signCurrencyCode && staCurCode) {
        //签单币和本位币
        var flag = true;//币别信息增加
        //获取到报价方案地下的承保方案地下的主条款地下的原币
        solutionEntity.get("plcPackage").each(function(packageEntity){
            if (packageEntity.get("plcMainClause")) {
                packageEntity.get("plcMainClause").each(function (entity) {
                    if(!aflag){
                        return false;
                    }
                    if(!solutionEntity.get("solutionTemplateCode")){//定额方案不校验
                        if(!entity.get("plcClauseItem")||entity.get("plcClauseItem").entityCount<=0||entity.get("plcClauseItem").entityCount==undefined||entity.get("plcClauseItem").entityCount==null){
                            App.alert("请完善主条款条责标信息");
                            cola.tag("getCalcP").set("disabled", false);
                            flg=false;
                            aflag=false;
                            return false;
                        }
                        if(entity.get("plcClauseItem")){
                            entity.get("plcClauseItem").each(function(ett){
                                if(!ett.get("oriCurAmount")||!ett.get("rate")||!ett.get("oriCurPremium")){
                                    App.alert("请完善主条款条责标信息");
                                    cola.tag("getCalcP").set("disabled", false);
                                    flg=false;
                                    aflag=false;
                                    return false;
                                }
                            })
                        }
                    }
                    var oriCurCode = entity.get("$oriCurName");//原币名称
                    var oriCur = entity.get("$oriCurCode");//原币名称
                    //var clauseAmount = Number(entity.get("$oriCurAmount"));//zhu条款原币保额
                    var clauseAmount =0;//zhu条款原币保额
                    var oriCurPremium = Number(entity.get("$oriCurPremium"));//主条款原币保费
                    var mainOriCurNetPremium=Number(entity.get("$oriCurNetPremium"));//原币不含税保费
                    var mainOriCurTaxFee=Number(entity.get("$oriCurTaxFee"));//原币税额
                    var totalclauseAmount = 0;//zhu条款总原币保额
                    var totaloriCurPremium = Number(entity.get("$oriCurPremium"));//主条款总原币保费
                    if (entity.get("$amountInvolveFlag") == 'Y'||entity.get("$amountInvolveFlag") == '1') {
                        totalclauseAmount = Number(entity.get("$oriCurAmount"));
                        clauseAmount = Number(entity.get("$oriCurAmount"));
                        // totaloriCurPremium = Number(entity.get("$oriCurPremium"));
                    }
                    //taxFee += entity.get("$oriCurTaxFee");//税额
                    //var oriAndSigExchangeRate = "1.00";//签单币与本位币兑换率
                    if ((clauseAmount||clauseAmount==0) && (oriCurPremium||oriCurPremium==0)) {
                        flg = true;
                        for (var i = 0; i < coinMessageArr.length; i++) {
                            if (coinMessageArr[i].oriCurCode == oriCur) {
                                //coinMessageArr[i].oriCurAmount = contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurAmount + clauseAmount);
                                coinMessageArr[i].oriCurPremium =contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurPremium + oriCurPremium);
                                if (entity.get("$amountInvolveFlag") == 'Y'||entity.get("$amountInvolveFlag") == '1') {
                                    coinMessageArr[i].totalSigCurAmount =contractEntity.formatToTwoPrecision(coinMessageArr[i].totalSigCurAmount + totalclauseAmount);
                                    coinMessageArr[i].oriCurAmount = contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurAmount + clauseAmount);
                                }
                                coinMessageArr[i].totalSigCurPremium =contractEntity.formatToTwoPrecision(coinMessageArr[i].totalSigCurPremium + totaloriCurPremium);
                                coinMessageArr[i].oriCurNetPremium =contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurNetPremium +mainOriCurNetPremium);//不含税保费
                                coinMessageArr[i].oriCurTaxFee =contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurTaxFee+mainOriCurTaxFee);//税额
                                flag = false;
                            }
                        }
                        //var sigCurAmount = clauseAmount * oriAndSigExchangeRate//签单币别保额
                        //var sigCurPremium = oriCurPremium * oriAndSigExchangeRate//签单必备保费
                        if (flag) {
                            coinMessageArr.push({
                                oriCurCode: oriCur,
                                oriCurName: oriCurCode,
                                oriCurAmount: clauseAmount,
                                oriCurPremium: oriCurPremium,
                                totalSigCurAmount: totalclauseAmount,
                                totalSigCurPremium: totaloriCurPremium,
                                oriCurNetPremium:mainOriCurNetPremium,
                                oriCurTaxFee:mainOriCurTaxFee
                                //oriAndSigExchangeRate: oriAndSigExchangeRate,
                                //sigCurAmount: sigCurAmount,
                                //sigCurPremium: sigCurPremium

                        });
                    }
                    flag = true;
                }
                else {
                    if(type!="quotation" && !window.isUwQuote) {
                        if(!solutionEntity.get("solutionTemplateCode")){
                            cola.NotifyTipManager.warning({
                                message: "",
                                description: "请完善条款下的条责标内容！",
                                showDuration: 3000
                            });
                            cola.tag("getCalcP").set("disabled", false);
                            flg = false;
                            return false;
                        }

                    }else{
                        cola.NotifyTipManager.warning({
                            message: "",
                            description: "没有可计算的保费！",
                            showDuration: 3000
                        });
                        cola.tag("getCalcP").set("disabled", false);
                        flg = false;
                        $(".savePolicy").removeClass("disabledSave");
                        $(".submitPolicy").removeClass("disabledSave");
                        $(".savePolicy").removeClass("disabledBtn");
                        $(".submitPolicy").removeClass("disabledBtn");
                        $("#qqSubBtn").removeAttr("disabled");
                        $("#qqSaveBtn").removeAttr("disabled");
                        $("#qqSubBtn").removeAttr("title");
                        $("#qqSaveBtn").removeAttr("title");
                        return false;
                    }
                }
                if (entity.get("plcAccessoryClause")) {
                    //主条款地下的附加条款的原币
                    entity.get("plcAccessoryClause").each(function (enty) {
                        if(!aflag){
                            return false;//跳出循环
                        }
                        if(!solutionEntity.get("solutionTemplateCode")){//定额方案不校验
                            if(!enty.get("plcClauseItem")||enty.get("plcClauseItem").entityCount<=0||enty.get("plcClauseItem").entityCount==undefined||enty.get("plcClauseItem").entityCount==null){
                                App.alert("请完善附加条款条责标信息");
                                cola.tag("getCalcP").set("disabled", false);
                                flg=false;
                                aflag = false;
                                return false;
                            }
                            if(enty.get("plcClauseItem")){
                                enty.get("plcClauseItem").each(function(etts){
                                    if(etts.get("statusFlag") !=="3" && (!etts.get("oriCurAmount")||!etts.get("rate")||!etts.get("oriCurPremium"))){
                                        App.alert("请完善附加条款条责标信息");
                                        cola.tag("getCalcP").set("disabled", false);
                                        flg=false;
                                        aflag = false;
                                        return false;
                                    }
                                })
                            }
                        }

                        var addoriCurCode = enty.get("$oriCurName");//原币
                        var addoriCur = enty.get("$oriCurCode");//原币
                        var addclauseAmount = 0;//附加条款原币保额
                        //var addclauseAmount = Number(enty.get("$oriCurAmount"));//附加条款原币保额
                        var addoriCurPremium = Number(enty.get("$oriCurPremium"));//附加条款原币保费
                        var accessOriCurNetPremium=Number(enty.get("$oriCurNetPremium"));//原币不含税保费
                        var accessOriCurTaxFee=Number(enty.get("$oriCurTaxFee"));//原币税额
                        var totaladdclauseAmount = 0;//附加条款原币总保额
                        var totaladdoriCurPremium = Number(enty.get("$oriCurPremium"));//附加条款原币保费
                        if (enty.get("$amountInvolveFlag") == 'Y'||enty.get("$amountInvolveFlag") == '1') {
                            totaladdclauseAmount = Number(enty.get("$oriCurAmount"));
                            addclauseAmount = Number(enty.get("$oriCurAmount"));
                            // totaladdoriCurPremium = Number(enty.get("$oriCurPremium"));
                        }
                        //var oriAndSigExchangeRate = "1.00";//签单币与本位币兑换率
                       // taxFee += enty.get("$oriCurTaxFee");
                        if ((addclauseAmount||addclauseAmount==0) 
                                && (addoriCurPremium||addoriCurPremium) || isDeleteClause(enty) ) {
                            flg = true;
                            for (var i = 0; i < coinMessageArr.length; i++) {
                                if (coinMessageArr[i].oriCurCode == addoriCur) {
                                    //coinMessageArr[i].oriCurAmount =contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurAmount + addclauseAmount);
                                    coinMessageArr[i].oriCurPremium =contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurPremium + addoriCurPremium);
                                    if (enty.get("$amountInvolveFlag") == 'Y'||enty.get("$amountInvolveFlag") == '1') {
                                        coinMessageArr[i].totalSigCurAmount =contractEntity.formatToTwoPrecision(coinMessageArr[i].totalSigCurAmount + totaladdclauseAmount);
                                        // coinMessageArr[i].totalSigCurPremium = Number(coinMessageArr[i].totalSigCurPremium + totaladdoriCurPremium);
                                        coinMessageArr[i].oriCurAmount =contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurAmount + addclauseAmount);
                                    }
                                    coinMessageArr[i].totalSigCurPremium =contractEntity.formatToTwoPrecision(coinMessageArr[i].totalSigCurPremium + totaladdoriCurPremium);
                                    coinMessageArr[i].oriCurNetPremium =contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurNetPremium + accessOriCurNetPremium);
                                    coinMessageArr[i].oriCurTaxFee =contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurTaxFee + accessOriCurTaxFee);
                                    flag = false;
                                }
                            }
                            //var sigCurAmount = addclauseAmount * oriAndSigExchangeRate//签单币别保额
                            //var sigCurPremium = addoriCurPremium * oriAndSigExchangeRate//签单必备保费
                            if (flag) {
                                coinMessageArr.push({
                                    oriCurCode: addoriCur,
                                    oriCurName: addoriCurCode,
                                    oriCurAmount: addclauseAmount,
                                    oriCurPremium: addoriCurPremium,
                                    totalSigCurAmount: totaladdclauseAmount,
                                    totalSigCurPremium: totaladdoriCurPremium,
                                    oriCurNetPremium:accessOriCurNetPremium,
                                    oriCurTaxFee:accessOriCurTaxFee
                                    // oriAndSigExchangeRate: oriAndSigExchangeRate,
                                    //sigCurAmount: sigCurAmount,
                                    //sigCurPremium: sigCurPremium

                                });
                            }
                            flag = true;
                        } else {
                            if((type!="quotation" && !window.isUwQuote)){
                                if(isSolution == true && !solutionEntity.get("solutionTemplateCode") && enty.get("statusFlag")!=="3"){
                                    cola.NotifyTipManager.warning({
                                        message: "",
                                        description: "请选择附加条款的原币保额和原币保费",
                                        showDuration: 3000
                                    });
                                    cola.tag("getCalcP").set("disabled", false);
                                    flg = false;
                                    return false;
                                }

                            }else{
                                cola.NotifyTipManager.warning({
                                    message: "",
                                    description: "没有可计算的保费",
                                    showDuration: 3000
                                });
                                cola.tag("getCalcP").set("disabled", false);
                                flg = false;
                                $(".savePolicy").removeClass("disabledSave");
                                $(".submitPolicy").removeClass("disabledSave");
                                $(".savePolicy").removeClass("disabledBtn");
                                $(".submitPolicy").removeClass("disabledBtn");
                                $("#qqSubBtn").removeAttr("disabled");
                                $("#qqSaveBtn").removeAttr("disabled");
                                $("#qqSubBtn").removeAttr("title");
                                $("#qqSaveBtn").removeAttr("title");
                                return false;
                            }

                            }
                        })
                    }
                });
            }
        })
        for(var i=0;i<coinMessageArr.length;i++){
            var oriAndSigExchangeRate=exchangeDataObj[coinMessageArr[i].oriCurCode+signCurrencyCode];//原币与签单笔兑换率
            var oriAndStaExchangeRate=exchangeDataObj[coinMessageArr[i].oriCurCode+staCurCode];//原币与本位币兑换率
            coinMessageArr[i].oriAndSigExchangeRate=oriAndSigExchangeRate;
            coinMessageArr[i].oriAndStaExchangeRate=oriAndStaExchangeRate;
            //coinMessageArr[i].oriCurAmount=coinMessageArr[i].totalSigCurAmount;//偷懒临时方法，TODO
            if(oriAndSigExchangeRate){//有原币和签单币兑换率
              //coinMessageArr[i].sigCurAmount=contractEntity.formatToTwoPrecision(coinMessageArr[i].totalSigCurAmount *oriAndSigExchangeRate);////偷懒临时方法，TODO
                coinMessageArr[i].sigCurAmount=contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurAmount*oriAndSigExchangeRate);//签单币保额=原币保额*原币与签单币兑换率
                coinMessageArr[i].sigCurPremium=contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurPremium*oriAndSigExchangeRate);//签单币含税保费=原币含税保费*原币与签单币兑换率
                coinMessageArr[i].sigCurNetPremium=contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurNetPremium*oriAndSigExchangeRate);//签单币不含税保费=原币不含税保费*兑换率
                coinMessageArr[i].sigCurTaxFee=contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurTaxFee*oriAndSigExchangeRate);//签单币税额=原币税额*兑换率
                coinMessageArr[i].totalSigCurAmount=contractEntity.formatToTwoPrecision(coinMessageArr[i].totalSigCurAmount*oriAndSigExchangeRate);
                coinMessageArr[i].totalSigCurPremium=contractEntity.formatToTwoPrecision(coinMessageArr[i].totalSigCurPremium*oriAndSigExchangeRate);
            }else{
                coinMessageArr[i].sigCurAmount=null;//签单币保额=原币保额*原币与签单币兑换率
                coinMessageArr[i].sigCurPremium=null;//签单币含税保费=原币含税保费*原币与签单币兑换率
                coinMessageArr[i].sigCurNetPremium=null;//签单币不含税保费=原币不含税保费*兑换率
                coinMessageArr[i].sigCurTaxFee=null;//签单币税额=原币税额*兑换率
                coinMessageArr[i].totalSigCurAmount=null;
                coinMessageArr[i].totalSigCurPremium=null;
            }
            if(oriAndStaExchangeRate){//原币与本位币兑换率
              // 
              //coinMessageArr[i].staCurAmount=contractEntity.formatToTwoPrecision(coinMessageArr[i].totalSigCurAmount *oriAndSigExchangeRate);////偷懒临时方法，TODO
                coinMessageArr[i].staCurAmount=contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurAmount*oriAndSigExchangeRate);//本位币保额=原币保额*原币与本位币兑换率
                coinMessageArr[i].staCurPremium=contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurPremium*oriAndSigExchangeRate);//本位币含税保费=原币含税保费*原币与本位币兑换率
                coinMessageArr[i].staCurNetPremium=contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurNetPremium*oriAndSigExchangeRate);//本位币不含税保费=原币不含税保费*原币与本位币兑换率
                coinMessageArr[i].staCurTaxFee=contractEntity.formatToTwoPrecision(coinMessageArr[i].oriCurTaxFee*oriAndSigExchangeRate);//本位币税额=原币税额*原币与本位币兑换率
            }else{
                coinMessageArr[i].staCurAmount=null;//本位币保额=原币保额*原币与本位币兑换率
                coinMessageArr[i].staCurPremium=null;//本位币含税保费=原币含税保费*原币与本位币兑换率
                coinMessageArr[i].staCurNetPremium=null;//本位币不含税保费=原币不含税保费*原币与本位币兑换率
                coinMessageArr[i].staCurTaxFee=null;//本位币税额=原币税额*原币与本位币兑换率
            }
        }
        console.log(coinMessageArr);
        //model.set("actual.taxFee", taxFee);//设置总税额
        //console.log("总税额"+'----'+ model.get("actual.taxFee"));
        if (solutionEntity.get("plcFee")) {
            var plcFeeArr=[];
            solutionEntity.get("plcFee").each(function (obj) {
                // contractEntity.removeRole(model, obj,function(obj){
                //
                // });
                plcFeeArr.push(obj.get("actualId"))
            })
            contractEntity.removeRoles(model, plcFeeArr,function () {
                solutionEntity.get("plcFee").each(function (obj) {
                    obj.remove();
                    })
                if(!aflag){
                    return false
                }
                    if (flg) {
                        contractEntity.addRoles(solutionEntity, model, "plcFee", coinMessageArr, function (newEntity) {
                            if (model.get("solution.plcFee")) {
                                model.get("solution.plcFee").each(function (entity, index) {
                                    entity.set("$totalSigCurAmount", coinMessageArr[index].totalSigCurAmount);
                                    entity.set("$totalSigCurPremium", coinMessageArr[index].totalSigCurPremium);
                                })
                            }


                        }).done(function (newEntity) {
                           // contractEntity.getExchangeRateTotal(model);//调用兑换率计算币别信息汇总信息
                            //设置缴费计划，需要区分默认增加条数和只是修改数据两种情况
                            if (startTime && endTime) {
                                // var clauseAmount = model.get("actual.plcSolution.clauseAmount");
                                //总批不触发
                                var params = cola.util.queryParams();
                                if(!params.endorseType){
                                    if (!solutionEntity.get("payNo") || solutionEntity.get("payNo")< 0) {
                                        // model.set("actual.payNo", "1");
                                        solutionEntity.set("payNo","1");
                                        var payPlanCount = solutionEntity.get("payNo");

                                        var tempEntityList = [];
                                        var fee = 0,netfee=0;
                                        solutionEntity.get("plcFee").each(function (item, index) {
                                            fee=contractEntity.formatToTwoPrecision(fee+item.get("sigCurPremium"));
                                            netfee=contractEntity.formatToTwoPrecision(netfee+item.get("sigCurNetPremium"));
                                        })
                                        var oriCurCode = solutionEntity.get("plcFee").first().get("oriCurCode");
                                        var averageFee = fee / payPlanCount;
                                        var payNetFee=netfee/payPlanCount;
                                        averageFee = parseInt(averageFee*100)/100;
                                        payNetFee = parseInt(payNetFee*100)/100;
                                        var lastFee = fee-averageFee*(payPlanCount-1);
                                        var lastpayNetFee=netfee - payNetFee * (payPlanCount - 1);
                                        lastFee=contractEntity.formatToTwoPrecision(lastFee);
                                        lastpayNetFee = contractEntity.formatToTwoPrecision(lastpayNetFee);
                                        var starEndPlus = (endTime.getTime() - startTime.getTime()) / 86400000 + 1;
                                        var intervalDay = Math.floor(starEndPlus / payPlanCount);//每一期缴费时间间隔
                                        for (var i = 0; i < payPlanCount; i++) {
                                            var tempEntity = {};
                                            tempEntity.startPayDate = new Date();
                                            tempEntity.endPayDate = new Date();
                                            var plcApplicant = model.get("actual.plcApplicant").first();
                                            tempEntity.accountNo = plcApplicant.get("accountNo");
                                            tempEntity.despositBankName = plcApplicant.get("despositBankName");
                                            tempEntity.ownerName = plcApplicant.get("accountName");
                                            tempEntity.certificateCode = plcApplicant.get("identifyNumber");
                                            tempEntity.currency = model.get("actual.signCurrencyCode");
                                            tempEntity.paySerialNo = i + 1;
                                            tempEntity.taxRate =model.get("actual.agentTaxRate");
                                            if (i < payPlanCount - 1) {
                                                tempEntity.planFee = averageFee;
                                                tempEntity.payNetFee = payNetFee;
                                                tempEntity.payFee = 0;
                                            } else {
                                                tempEntity.planFee = lastFee;
                                                tempEntity.payNetFee = lastpayNetFee;
                                                tempEntity.payFee = 0;
                                            }
                                            tempEntity.taxFee =contractEntity.formatToTwoPrecision(tempEntity.planFee-tempEntity.payNetFee);
                                            contractEntity.plcPlanDate(applicantDateTime,startTime,endTime,tempEntity,tempEntityList,payPlanCount,i);
                                            tempEntityList.push(tempEntity);
                                        }
                                        contractEntity.addRoles(solutionEntity, model, "plcPlan", tempEntityList, function (newEntity, responseData) {
                                        }).done(function (newEntity) {
                                            model.get("solution.plcPlan").last().set("$lastPlanfee", true);
                                        }).fail(function (data) {
                                        });

                                    } else {
                                        var tempEntityList = [];
                                        var fee = 0,netfee=0;
                                        var payPlanCount = solutionEntity.get("payNo");
                                        solutionEntity.get("plcFee").each(function (item, index) {
                                            fee=contractEntity.formatToTwoPrecision(fee+item.get("sigCurPremium"));
                                            netfee=contractEntity.formatToTwoPrecision(netfee+item.get("sigCurNetPremium"));
                                        })
                                        var averageFee = fee / payPlanCount;
                                        var payNetFee=netfee/payPlanCount;
                                        averageFee = parseInt(averageFee*100)/100;
                                        payNetFee = parseInt(payNetFee*100)/100;
                                        var lastFee = fee-averageFee*(payPlanCount-1);
                                        var lastpayNetFee=netfee - payNetFee * (payPlanCount - 1);
                                        lastFee=contractEntity.formatToTwoPrecision(lastFee);
                                        lastpayNetFee = contractEntity.formatToTwoPrecision(lastpayNetFee);
                                        var tempEntityList = [];
                                        for (var i = 0; i < payPlanCount; i++) {
                                            var tempEntity = {};
                                            tempEntity.startPayDate = new Date();
                                            tempEntity.endPayDate = new Date();
                                            tempEntity.paySerialNo = i + 1;
                                            tempEntity.currency = solutionEntity.get("plcFee").first().get("oriCurCode");
                                            tempEntity.taxRate =model.get("actual.agentTaxRate");
                                            if (i < payPlanCount - 1) {
                                                tempEntity.planFee = averageFee;
                                                tempEntity.payNetFee = payNetFee;
                                            } else {
                                                tempEntity.planFee = lastFee;
                                                tempEntity.payNetFee = lastpayNetFee;
                                            }
                                            tempEntity.taxFee =contractEntity.formatToTwoPrecision(tempEntity.planFee-tempEntity.payNetFee);
                                            contractEntity.plcPlanDate(applicantDateTime,startTime,endTime,tempEntity,tempEntityList,payPlanCount,i);
                                            tempEntityList.push(tempEntity);
                                        }
                                        if(solutionEntity.get("plcPlan")){
                                            solutionEntity.get("plcPlan").each(function (plcPlanItem, index) {
                                                plcPlanItem.set(tempEntityList[index]);
                                            });
                                        }

                                    }
                                }
                            }
                            // 设置总保额以及含税总保费的值
                            if (solutionEntity.get("plcFee")) {
                                solutionEntity.get("plcFee").each(function (entity) {
                                    sigCurAmountTotleList.push(entity.get("$totalSigCurAmount"));
                                    sigCurPremiumTotleList.push(entity.get("$totalSigCurPremium"));
                                    sigCurNetPremiumTotleList.push(entity.get("sigCurNetPremium"));
                                    taxFee=contractEntity.formatToTwoPrecision(taxFee+contractEntity.formatToTwoPrecision(entity.get("sigCurTaxFee")));
                                });
                                for (var i = 0; i < sigCurAmountTotleList.length; i++) {
                                    sigCurAmountTotle=contractEntity.formatToTwoPrecision(sigCurAmountTotle+contractEntity.formatToTwoPrecision(sigCurAmountTotleList[i]));
                                }
                                for (var i = 0; i < sigCurPremiumTotleList.length; i++) {
                                    sigCurPremiumTotle=contractEntity.formatToTwoPrecision(sigCurPremiumTotle+contractEntity.formatToTwoPrecision(sigCurPremiumTotleList[i]))
                                }
                                for(var i = 0;i<sigCurNetPremiumTotleList.length;i++){
                                    sigCurNetPremiumTotle=contractEntity.formatToTwoPrecision(sigCurNetPremiumTotle+contractEntity.formatToTwoPrecision(sigCurNetPremiumTotleList[i]));
                                }
                                model.set("actual.amount", contractEntity.formatToTwoPrecision(sigCurAmountTotle));
                                model.set("actual.premium", contractEntity.formatToTwoPrecision(sigCurPremiumTotle));
                                model.set("actual.netPremium", contractEntity.formatToTwoPrecision(sigCurNetPremiumTotle));
                                model.set("actual.taxFee", contractEntity.formatToTwoPrecision(taxFee));//税额
                                console.log(model.get("actual.amount")+"----总保额");
                                console.log(model.get("actual.premium")+'----总保费');
                                console.log(model.get("actual.netPremium")+'不含税总保费');
                                console.log(model.get("actual.taxFee")+"----总税额");
                                solutionEntity.set("solutionSumAmount", contractEntity.formatToTwoPrecision(sigCurAmountTotle));
                                solutionEntity.set("solutionPremium", contractEntity.formatToTwoPrecision(sigCurPremiumTotle));
                                console.log(model.get("solution.solutionSumAmount")+'---报价方案总保额');
                                console.log(model.get("solution.solutionPremium")+'---报价方案总保费');
                            }
                            // 含税手续费=保单总保费*手续费比例
                            // 手续费税率由代理协议查询接口返回
                            // 不含税手续费=含税手续费/(1+手续费税率%)
                            // 手续费税额= 含税手续费-不含税手续费
                            // 获取业务归属的方案
                            var plcDetailRole = [];
                            var oriExchangeRate = 0;
                            if (model.get("costDate") && model.get("costDate").entityCount>0) {

                                model.get("costDate").each(function (entity, index) {
                                    var handingaRate = entity.get("agentTaxRate");//模拟一个手续费税率；目前是销管系统带出，已根据当前代理人分别带出
                                   // var agentFee = Number(((model.get("actual.netPremium").toFixed(2)) * entity.get("agentRate") / 100).toFixed(2));//手续费含税金额---- 手续费比例＊不含税总保费20180120改                
                                    var agentFee = contractEntity.formatToTwoPrecision((contractEntity.formatToTwoPrecision(model.get("actual.netPremium"))* entity.get("agentRate") / 100)) ;
                                    var agentNetFee = contractEntity.formatToTwoPrecision(agentFee / (1 + handingaRate / 100));//不含税手续费
                                    var agentTaxFee = contractEntity.formatToTwoPrecision((agentFee - agentNetFee));
                                    // if(plcDetailRole.length==2){
                                    //     return false;
                                    // }
                                    plcDetailRole.push({
                                        serialNo: index + 1,
                                        agencyName: entity.get("agentName"),//代理人名称
                                        agencyCode: entity.get("agentCode"),//代理人代码
                                        agentRate: entity.get("agentRate"),//手续费比例
                                        agentFee: agentFee,//手续费含税金额
                                        agentTaxRate: handingaRate, //手续费税率
                                        agentTaxFee: agentTaxFee,//税额
                                        agentNetFee: agentNetFee,//不含税手续费
                                        agentReason:entity.get("agentReason"),
                                        feePayObjectType:entity.get("feePayObjectType"),
                                        feePayObjectName:entity.get("feePayObjectName")
                                    });
                                })
                            }
                            //增加手续费role
                            var plcDetail = solutionEntity.get("plcCommissionDetail");
                            if (plcDetail) {
                                plcDetail.each(function (obj) {
                                    contractEntity.removeRole(model, obj);
                                    // entity.remove()
                                })
                            }
                            contractEntity.addRoles(solutionEntity, model, "plcCommissionDetail", plcDetailRole, function (newEntity, responseData) {
                            }).done(function (newEntity) {
                                // var rateArr=[];
                                var rateObj = {};
                                var plcComDetail = model.get("solution.plcCommissionDetail");
                                if (plcComDetail) {
                                    plcComDetail.each(function (enty) {
                                        rateObj = {};
                                        rateObj.actualId = enty.get("actualId");
                                        rateObj.agentRate = enty.get("agentRate");
                                        model.get("detailRateArr").insert(rateObj);
                                        // rateArr.push(rateObj);
                                    });
                                    // model.set("detailRateArr",rateArr);
                                }
                            }).fail(function (data) {
                            });
                            contractEntity.getCostAmount(model,true);
                            contractEntity.rateGetAmount(model);//费用信息模块根据手续费算出手续费金额
                            contractEntity.getCoinRateFee(model);//共保保额保费计算
                            contractEntity.getCoinLinkRateFee(model);//联保保额保费计算
                            contractEntity.getPlcCoinsCommissionData(model);//调用联共保手续费计算
                            cola.tag("getCalcP").set("disabled", false);
                            //可以正确走完保费计算流程
                            window.isClickCalcPremiumFlag=true;
                            $(".savePolicy").removeClass("disabledSave");
                            $(".submitPolicy").removeClass("disabledSave");
                            $(".savePolicy").removeClass("disabledBtn");
                            $(".submitPolicy").removeClass("disabledBtn");
                            $("#qqSubBtn").removeAttr("disabled");
                            $("#qqSaveBtn").removeAttr("disabled");
                            $("#qqSubBtn").removeAttr("title");
                            $("#qqSaveBtn").removeAttr("title");
                        }).fail(function (data) {
                        });

                    } else {
                        return false;
                    }
            });
        }else{
            if(!aflag){
                return false
            }
            if (flg) {
                contractEntity.addRoles(solutionEntity, model, "plcFee", coinMessageArr, function (newEntity) {
                    if (model.get("solution.plcFee")) {
                        model.get("solution.plcFee").each(function (entity, index) {
                            entity.set("$totalSigCurAmount", coinMessageArr[index].totalSigCurAmount);
                            entity.set("$totalSigCurPremium", coinMessageArr[index].totalSigCurPremium);
                        })
                    }


                }).done(function (newEntity) {
                   // contractEntity.getExchangeRateTotal(model);//调用兑换率计算币别信息汇总信息
                    //设置缴费计划，需要区分默认增加条数和只是修改数据两种情况
                    if (startTime && endTime) {
                        // var clauseAmount = model.get("actual.plcSolution.clauseAmount");
                        var params = cola.util.queryParams();
                        if (!params.endorseType) {//宗批不出发
                        if (!solutionEntity.get("payNo") || solutionEntity.get("payNo") < 0) {
                            // model.set("actual.payNo", "1");
                            solutionEntity.set("payNo", "1");
                            var payPlanCount = solutionEntity.get("payNo");

                            var tempEntityList = [];
                            var fee = 0,netfee=0;
                            solutionEntity.get("plcFee").each(function (item, index) {
                                fee=contractEntity.formatToTwoPrecision(fee+item.get("sigCurPremium"));
                                netfee=contractEntity.formatToTwoPrecision(netfee+item.get("sigCurNetPremium"));
                            })
                            var oriCurCode = solutionEntity.get("plcFee").first().get("oriCurCode");
                            var averageFee = fee / payPlanCount;
                            var payNetFee=netfee/payPlanCount;
                            averageFee = parseInt(averageFee * 100) / 100;
                            payNetFee = parseInt(payNetFee*100)/100;
                            var lastFee = fee - averageFee * (payPlanCount - 1);
                            var lastpayNetFee=netfee - payNetFee * (payPlanCount - 1);
                            lastFee = contractEntity.formatToTwoPrecision(lastFee);
                            lastpayNetFee = contractEntity.formatToTwoPrecision(lastpayNetFee);
                            var starEndPlus = (endTime.getTime() - startTime.getTime()) / 86400000 + 1;
                            var intervalDay = Math.floor(starEndPlus / payPlanCount);//每一期缴费时间间隔
                            for (var i = 0; i < payPlanCount; i++) {

                                var tempEntity = {};
                                tempEntity.startPayDate = new Date();
                                tempEntity.endPayDate = new Date();
                                var plcApplicant = model.get("actual.plcApplicant").first();
                                tempEntity.accountNo = plcApplicant.get("accountNo");
                                tempEntity.despositBankName = plcApplicant.get("despositBankName");
                                tempEntity.ownerName = plcApplicant.get("accountName");
                                tempEntity.certificateCode = plcApplicant.get("identifyNumber");
                                tempEntity.currency = model.get("actual.signCurrencyCode");
                                tempEntity.paySerialNo = i + 1;
                                tempEntity.taxRate =model.get("actual.agentTaxRate");
                                if (i < payPlanCount - 1) {
                                    tempEntity.planFee = averageFee;
                                    tempEntity.payNetFee = payNetFee;
                                    tempEntity.payFee = 0;
                                } else {
                                    tempEntity.planFee = lastFee;
                                    tempEntity.payNetFee = lastpayNetFee;
                                    tempEntity.payFee = 0;
                                }
                                tempEntity.taxFee =contractEntity.formatToTwoPrecision(tempEntity.planFee-tempEntity.payNetFee);
                                contractEntity.plcPlanDate(applicantDateTime,startTime,endTime,tempEntity,tempEntityList,payPlanCount,i);
                                tempEntityList.push(tempEntity);
                            }
                            contractEntity.addRoles(solutionEntity, model, "plcPlan", tempEntityList, function (newEntity, responseData) {
                            }).done(function (newEntity) {
                                solutionEntity.get("plcPlan").last().set("$lastPlanfee", true);
                            }).fail(function (data) {
                            });

                        } else {
                            var tempEntityList = [];
                            var fee = 0,netfee=0;
                            var payPlanCount = solutionEntity.get("payNo");
                            solutionEntity.get("plcFee").each(function (item, index) {
                              fee=contractEntity.formatToTwoPrecision(fee+item.get("sigCurPremium"));
                                netfee=contractEntity.formatToTwoPrecision(netfee+item.get("sigCurNetPremium"));
                            })
                            var averageFee = fee / payPlanCount;
                            var payNetFee=netfee/payPlanCount;
                            averageFee = parseInt(averageFee * 100) / 100;
                            payNetFee = parseInt(payNetFee*100)/100;
                            var lastFee = fee - averageFee * (payPlanCount - 1);
                            var lastpayNetFee=netfee - payNetFee * (payPlanCount - 1);
                            lastFee = contractEntity.formatToTwoPrecision(lastFee);
                            lastpayNetFee = contractEntity.formatToTwoPrecision(lastpayNetFee);
                            var tempEntityList = [];
                            for (var i = 0; i < payPlanCount; i++) {
                                var tempEntity = {};
                                tempEntity.startPayDate = new Date();
                                tempEntity.endPayDate = new Date();
                                tempEntity.paySerialNo = i + 1;
                                tempEntity.currency = solutionEntity.get("plcFee").first().get("oriCurCode");
                                tempEntity.taxRate =model.get("actual.agentTaxRate");
                                if (i < payPlanCount - 1) {
                                    tempEntity.planFee = averageFee;
                                    tempEntity.payNetFee = payNetFee;
                                } else {
                                    tempEntity.planFee = lastFee;
                                    tempEntity.payNetFee = lastpayNetFee;
                                }
                                tempEntity.taxFee =contractEntity.formatToTwoPrecision(tempEntity.planFee-tempEntity.payNetFee);
                                contractEntity.plcPlanDate(applicantDateTime,startTime,endTime,tempEntity,tempEntityList,payPlanCount,i);
                                tempEntityList.push(tempEntity);
                            }
                            if(solutionEntity.get("plcPlan")){
                                solutionEntity.get("plcPlan").each(function (plcPlanItem, index) {
                                    plcPlanItem.set(tempEntityList[index]);
                                });
                            }

                        }
                    }
                    }

                    // 设置总保额以及含税总保费的值
                    if (solutionEntity.get("plcFee")) {
                        solutionEntity.get("plcFee").each(function (entity) {
                            sigCurAmountTotleList.push(entity.get("$totalSigCurAmount"));
                            sigCurPremiumTotleList.push(entity.get("$totalSigCurPremium"));
                            sigCurNetPremiumTotleList.push(entity.get("sigCurNetPremium"));//签单币不含税总保费
                            taxFee=contractEntity.formatToTwoPrecision(taxFee+contractEntity.formatToTwoPrecision(entity.get("sigCurTaxFee")));
                        });
                        for (var i = 0; i < sigCurAmountTotleList.length; i++) {
                            sigCurAmountTotle=contractEntity.formatToTwoPrecision(sigCurAmountTotle+contractEntity.formatToTwoPrecision(sigCurAmountTotleList[i]));
                        }
                        for (var i = 0; i < sigCurPremiumTotleList.length; i++) {
                            sigCurPremiumTotle=contractEntity.formatToTwoPrecision(sigCurPremiumTotle+contractEntity.formatToTwoPrecision(sigCurPremiumTotleList[i]));
                        }
                        for(var i=0;i<sigCurNetPremiumTotleList.length;i++){
                            sigCurNetPremiumTotle=contractEntity.formatToTwoPrecision(sigCurNetPremiumTotle+contractEntity.formatToTwoPrecision(sigCurNetPremiumTotleList[i]));
                        }
                        // solutionEntity.get("plcFee").each(function (entity) {
                        //     sigCurAmountTotle +=entity.get("$totalSigCurAmount");
                        //     sigCurPremiumTotle +=entity.get("$totalSigCurPremium");
                        //     sigCurNetPremiumTotle +=entity.get("sigCurNetPremium");//签单币不含税总保费
                        // });
        
                        model.set("actual.amount", contractEntity.formatToTwoPrecision(sigCurAmountTotle));
                        model.set("actual.premium", contractEntity.formatToTwoPrecision(sigCurPremiumTotle));
                        model.set("actual.netPremium", contractEntity.formatToTwoPrecision(sigCurNetPremiumTotle));//不含税保费
                        model.set("actual.taxFee", contractEntity.formatToTwoPrecision(taxFee));//不含税保费
                        console.log(model.get("actual.amount")+"----总保额");
                        console.log(model.get("actual.premium")+'----总保费');
                        console.log(model.get("actual.netPremium")+'不含税总保费');
                        console.log(model.get("actual.taxFee")+"----总税额");
                        solutionEntity.set("solutionSumAmount", contractEntity.formatToTwoPrecision(sigCurAmountTotle));
                        solutionEntity.set("solutionPremium", contractEntity.formatToTwoPrecision(sigCurPremiumTotle));
                    }
                    // 含税手续费=保单总保费*手续费比例
                    // 手续费税率由代理协议查询接口返回
                    // 不含税手续费=含税手续费/(1+手续费税率%)
                    // 手续费税额= 含税手续费-不含税手续费
                    // 获取业务归属的方案
                    var plcDetailRole = [];
                    var oriExchangeRate = 0;
                    if (model.get("costDate") && model.get("costDate").entityCount>0) {
                        model.get("costDate").each(function (entity, index) {
                            var handingaRate = entity.get("agentTaxRate");//模拟一个手续费税率；目前是销管系统带出，已根据当前代理人分别带出
                           // var agentFee = Number(((model.get("actual.netPremium").toFixed(2)) * entity.get("agentRate") / 100).toFixed(2));//手续费含税金额---- 手续费比例＊不含税总保费20180120改
                            var agentFee = contractEntity.formatToTwoPrecision((contractEntity.formatToTwoPrecision(model.get("actual.netPremium"))* entity.get("agentRate") / 100)) ;
                            
                            var agentNetFee = contractEntity.formatToTwoPrecision(agentFee / (1 + handingaRate/ 100));//不含税手续费
                            var agentTaxFee = contractEntity.formatToTwoPrecision((agentFee - agentNetFee));
                            // if(plcDetailRole.length==2){
                            //     return false;
                            // }
                            plcDetailRole.push({
                                serialNo: index + 1,
                                agencyName: entity.get("agentName"),//代理人名称
                                agencyCode: entity.get("agentCode"),//代理人代码
                                agentRate: entity.get("agentRate"),//手续费比例
                                agentFee: agentFee,//手续费含税金额
                                agentTaxRate: handingaRate, //手续费税率
                                agentTaxFee: agentTaxFee,//税额
                                agentNetFee: agentNetFee,//不含税手续费
                                agentReason:entity.get("agentReason"),
                                feePayObjectType:entity.get("feePayObjectType"),
                                feePayObjectName:entity.get("feePayObjectName")
                            });
                        })
                    }
                    //增加手续费role
                    var plcDetail = solutionEntity.get("plcCommissionDetail");
                    if (plcDetail) {
                        plcDetail.each(function (obj) {
                            contractEntity.removeRole(model, obj);
                            // entity.remove()
                        })
                    }
                    contractEntity.addRoles(solutionEntity, model, "plcCommissionDetail", plcDetailRole, function (newEntity, responseData) {
                    }).done(function (newEntity) {
                        // var rateArr=[];
                        var rateObj = {};
                        var plcComDetail = model.get("solution.plcCommissionDetail");
                        if (plcComDetail) {
                            plcComDetail.each(function (enty) {
                                rateObj = {};
                                rateObj.actualId = enty.get("actualId");
                                rateObj.agentRate = enty.get("agentRate");
                                model.get("detailRateArr").insert(rateObj);
                                // rateArr.push(rateObj);
                            });
                            // model.set("detailRateArr",rateArr);
                        }
                    }).fail(function (data) {
                    });
                    contractEntity.getCostAmount(model,true);
                    contractEntity.rateGetAmount(model);//费用信息模块根据手续费算出手续费金额
                    contractEntity.getCoinRateFee(model);//共保保额保费计算
                    contractEntity.getCoinLinkRateFee(model);//联保保额保费计算
                    contractEntity.getPlcCoinsCommissionData(model);//调用联共保手续费计算
                    cola.tag("getCalcP").set("disabled", false);
                    //可以正确走完保费计算流程
                    window.isClickCalcPremiumFlag=true;
                    $(".savePolicy").removeClass("disabledSave");
                    $(".submitPolicy").removeClass("disabledSave");
                    $(".savePolicy").removeClass("disabledBtn");
                    $(".submitPolicy").removeClass("disabledBtn");
                    $("#qqSubBtn").removeAttr("disabled");
                    $("#qqSaveBtn").removeAttr("disabled");
                    $("#qqSubBtn").removeAttr("title");
                    $("#qqSaveBtn").removeAttr("title");
                }).fail(function (data) {
                });

            } else {
                return false;
            }
        }

        //if(type=="policy")执行自动带出特约
       /* if(type=="policy"){
            setTimeout(function(){
                cola.model().action("savePausePolicy")(true,true);
            },1000);
        }*/
    }
    else {
        cola.NotifyTipManager.warning({
            message: "",
            description: "请选择签单币别",
            showDuration: 3000
        });
        cola.tag("getCalcP").set("disabled", false);
        return false;
    }

}
//团单保费计算变化相关
ContractEntity.prototype.groupCalcPremium = function (model) {
    // 保费计算
    //原币 oriCurCode
    //原币保额 oriCurAmount
    //原币保费  oriCurPremium
    //人民币 001
    var coinMessageArr = [];
    var solutionEntity = model.get("solution");//当前报价方案entity
    var signCurrencyCode = model.get("actual.signCurrencyCode");//签单币
    var staCurCode = model.get("actual.staCurCode");//本位币
    var mainPerm = solutionEntity.get("plcPackage").current.get("plcMainClause");
    var sigCurAmountTotleList = [];//签单币别保额
    var sigCurAmountTotle = 0;
    var sigCurPremiumTotleList = [];//签单币别保费
    var sigCurPremiumTotle = 0;
    var startTime = model.get("actual.startTime");
    var endTime = model.get("actual.endTime");
    var taxFee = 0;//总税额


    var flg = false;
    if (signCurrencyCode && staCurCode) {//签单币和本位币
        var flag = true;
        model.set("actual.taxFee", taxFee);//设置总税额
        //if(solutionEntity.get("plcFee")){
        //    solutionEntity.get("plcFee").each(function(obj){
        //        contractEntity.removeRole(model,obj,false);
        //    })
        //}
        //if(flg){
        //contractEntity.addRoles(solutionEntity, model, "plcFee", coinMessageArr, function (newEntity) {
        //}).done(function (newEntity) {
        contractEntity.getExchangeRateTotal(model);//调用兑换率计算币别信息汇总信息

        //设置缴费计划，需要区分默认增加条数和只是修改数据两种情况
        if (startTime && endTime) {
            // var clauseAmount = model.get("actual.plcSolution.clauseAmount");
            if (!solutionEntity.get("payNo") || solutionEntity.get("payNo") < 0) {
                // model.set("actual.payNo", "1");
                solutionEntity.set("payNo","1");
                var payPlanCount = solutionEntity.get("payNo");

                var tempEntityList = [];
                var fee = 0;
                solutionEntity.get("plcFee").each(function (item, index) {
                    fee += item.get("sigCurPremium");
                })
                var oriCurCode = solutionEntity.get("plcFee").first().get("oriCurCode");
                var averageFee = Math.floor(fee / payPlanCount);
                var lastFee = averageFee + fee % payPlanCount;
                var starEndPlus = (endTime.getTime() - startTime.getTime()) / 86400000 + 1;
                var intervalDay = Math.floor(starEndPlus / payPlanCount);//每一期缴费时间间隔
                for (var i = 0; i < payPlanCount; i++) {
                    var tempEntity = {};
                    tempEntity.startPayDate = new Date();
                    tempEntity.endPayDate = new Date();
                    var plcApplicant = model.get("actual.plcApplicant").first();
                    tempEntity.accountNo = plcApplicant.get("accountNo");
                    tempEntity.despositBankName = plcApplicant.get("despositBankName");
                    tempEntity.ownerName = plcApplicant.get("accountName");
                    tempEntity.certificateCode = plcApplicant.get("identifyNumber");
                    tempEntity.currency = solutionEntity.get("plcFee").first().get("oriCurCode");
                    tempEntity.paySerialNo = i + 1;
                    if (i < payPlanCount - 1) {
                        tempEntity.planFee = averageFee;
                        tempEntity.payFee = 0;
                    } else {
                        tempEntity.planFee = lastFee;
                        tempEntity.payFee = 0;
                    }
                    if (i == 0) {
                        tempEntity.startPayDate=new Date(startTime);
                        tempEntity.endPayDate.setMonth(tempEntity.startPayDate.getMonth());
                        tempEntity.endPayDate.setFullYear(tempEntity.startPayDate.getFullYear());
                        tempEntity.endPayDate.setDate(tempEntity.startPayDate.getDate() + 15);
                    } else {
                        tempEntity.startPayDate.setMonth(tempEntityList[i - 1].endPayDate.getMonth());
                        tempEntity.startPayDate.setFullYear(tempEntityList[i - 1].endPayDate.getFullYear());
                        tempEntity.startPayDate.setDate(tempEntityList[i - 1].endPayDate.getDate() + intervalDay - 15);
                        tempEntity.endPayDate.setMonth(tempEntity.startPayDate.getMonth());
                        tempEntity.endPayDate.setFullYear(tempEntity.startPayDate.getFullYear());
                        tempEntity.endPayDate.setDate(tempEntity.startPayDate.getDate() + 15);
                    }
                    tempEntityList.push(tempEntity);
                }
                if(model.get("solution.plcPlan")&&model.get("solution.plcPlan").entityCount>0){
                    model.get("solution.plcPlan").each(function (objItem) {
                        $.ajax({
                            url: "controller/insurance/businessEntity/removeRole",
                            type: "POST",
                            data: {actualId: model.get("actual.actualId"),roleId:objItem.get("actualId")},
                            success: function (data) {
                                objItem.remove();
                            }
                        });
                    });
                }

                contractEntity.addRoles(solutionEntity, model, "plcPlan", tempEntityList, function (newEntity, responseData) {
                }).done(function (newEntity) {
                    model.get("solution.plcPlan").last().set("$lastPlanfee", true);
                }).fail(function (data) {
                });

            } else {
                var tempEntityList = [];
                var fee = 0;
                var payPlanCount =solutionEntity.get("payNo");
                solutionEntity.get("plcFee").each(function (item, index) {
                    fee += item.get("sigCurPremium");
                })
                var averageFee = Math.floor(fee / payPlanCount);
                var lastFee = averageFee + fee % payPlanCount;

                var tempEntityList = [];
                for (var i = 0; i < payPlanCount; i++) {
                    var tempEntity = {};
                    tempEntity.startPayDate = new Date();
                    tempEntity.endPayDate = new Date();
                    tempEntity.paySerialNo = i + 1;
                    tempEntity.currency = solutionEntity.get("plcFee").first().get("oriCurCode");
                    if (i < payPlanCount - 1) {
                        tempEntity.planFee = averageFee;
                    } else {
                        tempEntity.planFee = lastFee;
                    }
                    if (i == 0) {
                        tempEntity.startPayDate=new Date(startTime);
                        tempEntity.startPayDate.setDate(tempEntity.startPayDate.getDate() + 1);
                        tempEntity.endPayDate.setMonth(tempEntity.startPayDate.getMonth());
                        tempEntity.endPayDate.setFullYear(tempEntity.startPayDate.getFullYear());
                        tempEntity.endPayDate.setDate(tempEntity.startPayDate.getDate() + 15);
                    } else {
                        tempEntity.startPayDate.setMonth(tempEntityList[i - 1].endPayDate.getMonth());
                        tempEntity.startPayDate.setFullYear(tempEntityList[i - 1].endPayDate.getFullYear());
                        tempEntity.startPayDate.setDate(tempEntityList[i - 1].endPayDate.getDate() + 15);
                        tempEntity.endPayDate.setMonth(tempEntity.startPayDate.getMonth());
                        tempEntity.endPayDate.setFullYear(tempEntity.startPayDate.getFullYear());
                        tempEntity.endPayDate.setDate(tempEntity.startPayDate.getDate() + 15);
                    }
                    tempEntityList.push(tempEntity);
                }
                solutionEntity.get("plcPlan").each(function (plcPlanItem, index) {
                    plcPlanItem.set(tempEntityList[index]);
                });
            }

        }

        // 设置总保额以及含税总保费的值
        if (solutionEntity.get("plcFee")) {
            solutionEntity.get("plcFee").each(function (entity) {
                sigCurAmountTotleList.push(entity.get("sigCurAmount"));
                sigCurPremiumTotleList.push(entity.get("sigCurPremium"));
            });
            for (var i = 0; i < sigCurAmountTotleList.length; i++) {
                sigCurAmountTotle += sigCurAmountTotleList[i];
            }
            for (var i = 0; i < sigCurPremiumTotleList.length; i++) {
                sigCurPremiumTotle += sigCurPremiumTotleList[i]
            }
            model.set("actual.amount", sigCurAmountTotle);
            model.set("actual.premium", sigCurPremiumTotle);
            console.log(model.get("actual.premium"));
            model.get("solution").set("solutionSumAmount", sigCurAmountTotle);
            model.get("solution").set("solutionPremium", sigCurPremiumTotle);
        }
        // 含税手续费=保单总保费*手续费比例
        // 手续费税率由代理协议查询接口返回
        // 不含税手续费=含税手续费/(1+手续费税率%)
        // 手续费税额= 含税手续费-不含税手续费
        // 获取业务归属的方案
        var plcDetailRole = [];
        var oriExchangeRate = 0;
        if (model.get("costDate")) {

            model.get("costDate").each(function (entity, index) {
                var handingaRate = entity.get("agentTaxRate");//模拟一个手续费税率；目前是销管系统带出，已根据当前代理人分别带出
                //var agentFee = Number(((model.get("actual.netPremium").toFixed(2)) * entity.get("agentRate") / 100).toFixed(2));//手续费含税金额
                var agentFee = contractEntity.formatToTwoPrecision((contractEntity.formatToTwoPrecision(model.get("actual.netPremium"))* entity.get("agentRate") / 100)) ;
                var agentNetFee =contractEntity.formatToTwoPrecision(agentFee / (1 + handingaRate / 100));//不含税手续费
                var agentTaxFee = contractEntity.formatToTwoPrecision(agentFee - agentNetFee);
                // if(plcDetailRole.length==2){
                //     return false;
                // }
                plcDetailRole.push({
                    serialNo: index + 1,
                    agencyName: entity.get("agentName"),//代理人名称
                    agencyCode: entity.get("agentCode"),//代理人代码
                    agentRate: entity.get("agentRate"),//手续费比例
                    agentFee: agentFee,//手续费含税金额
                    agentTaxRate:handingaRate, //手续费税率
                    agentTaxFee: agentTaxFee,//税额
                    agentNetFee: agentNetFee,//不含税手续费
                    feePayObjectType:entity.get("feePayObjectType"),
                    feePayObjectName:entity.get("feePayObjectName")
                });
            })
        }
        //增加手续费role
        var plcDetail = solutionEntity.get("plcCommissionDetail");
        if (plcDetail) {
            plcDetail.each(function (obj) {
                contractEntity.removeRole(model, obj);
                // entity.remove()
            })
        }
        contractEntity.addRoles(solutionEntity, model, "plcCommissionDetail", plcDetailRole, function (newEntity, responseData) {
        }).done(function (newEntity) {
            // var rateArr=[];
            var rateObj = {};
            var plcComDetail = model.get("solution.plcCommissionDetail");
            if (plcComDetail) {
                plcComDetail.each(function (enty) {
                    rateObj = {};
                    rateObj.actualId = enty.get("actualId");
                    rateObj.agentRate = enty.get("agentRate");
                    model.get("detailRateArr").insert(rateObj);
                    // rateArr.push(rateObj);
                });
                // model.set("detailRateArr",rateArr);
            }
        }).fail(function (data) {
        });
        contractEntity.getCostAmount(model,true);
        contractEntity.rateGetAmount(model);//费用信息模块根据手续费算出手续费金额
        contractEntity.getCoinRateFee(model);//共保保额保费计算
        contractEntity.getCoinLinkRateFee(model);//联保保额保费计算
        contractEntity.getPlcCoinsCommissionData(model);//调用联共保手续费计算
        cola.tag("getCalcP").set("disabled", false);

    }
    //else {
    //    cola.NotifyTipManager.warning({
    //        message:"",
    //        description:"请选择签单币别",
    //        showDuration:3000
    //    });
    //    cola.tag("getCalcP").set("disabled",false);
    //    return false;
    //}

}
//投保人和被保人调ECIF接口查询按钮
ContractEntity.prototype.portInquire = function (model, applicant, activeIndex) {
    var identityNum = applicant.get("identifyNumber");//证件号码
    var identityType = applicant.get("identifyType");//证件类型
    var customerType = applicant.get("customerType");//关系人类型
    var customerName = applicant.get("customerName");//证件名称
    // if(customerType=="1"){
    //     var customerName = "";
    // }else{
        //var customerName = applicant.get("customerName");//证件名称
    //}
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
            var customerDetailObj = {}, customerDetailArr = [];
            if (data.responseCode != 1) {//没有数据时显示模块
                cola.NotifyTipManager.warning({
                    message: "",
                    description: "未查询到相关数据",
                    showDuration: 3000
                });

                if (customerType == "1") {
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
                    applicant.set("plcCustomer.citizenship", "CHN");
                    applicant.set("plcCustomer.citizenshipName", "中国");
                    applicant.set("plcCustomer.isWithinForeign", "1");
                    //applicant.set("plcCustomer.address", null);
                    applicant.set("plcCustomer.email", null);
                    applicant.set("plcCustomer.post", null);
                    applicant.set("plcCustomer.mobile", null);
                    applicant.set("plcCustomer.phoneNumber", null);
                    //applicant.set("identifyEffectiveEndDate", null);
                } else {
                    applicant.set("plcGrpCustomer.registyAddress", null);
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
                        if (applicant.dataType && (applicant.dataType.get("name") == "PlcApplicant" || applicant.dataType.get("name") == "PageInsurance")) {
                            cola.widget("dialog1").show();
                            model.$("#dialog1 table").find("th").eq(6).show();
                        } else if (applicant.dataType && applicant.dataType.get("name") == "PlcInsurant") {
                            var actualId  = model.get("actual.actualId");
                            cola.tag('dialog2'+actualId)[0].show();
                            model.$("#dialog2 table").find("th").eq(6).show();
                        } else if (applicant.dataType && applicant.dataType.get("name") == "PlcCarowners") {
                            //cola.widget("dialog3").show();
                            var actualId  = model.get("actual.actualId");
                            cola.tag('dialog3'+actualId)[0].show();
                            model.$("#dialog3 table").find("th").eq(6).show();
                        } else if (applicant.dataType && applicant.dataType.get("name") == "PlcGuardian") {
                            //cola.widget("dialog4").show();
                            var actualId  = model.get("actual.actualId");
                            cola.tag('dialog4'+actualId)[0].show();
                            model.$("#dialog4 table").find("th").eq(6).show();
                        }
                        //cola.widget("dialog1").show()
                    } else {
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
                        applicant.set("plcCustomer.birthDate", data.individualResponse.birthDate ? data.individualResponse.birthDate : "");
                        //年龄
                        applicant.set("plcCustomer.age", data.individualResponse.age ? data.individualResponse.age : "")

                        //性别
                        applicant.set("plcCustomer.sex", data.individualResponse.sex ? data.individualResponse.sex : "");
                        //投保人代码
                        applicant.set("customerCode", data.individualResponse.customerCode ? data.individualResponse.customerCode : null)

                        //客户姓名
                        applicant.set("customerName", data.individualResponse.idname ? data.individualResponse.idname : "")
                        //证件号码
                        applicant.set("identifyNumber", data.individualResponse.idno ? data.individualResponse.idno : "")
                        //证件截止日期
                        applicant.set("identifyEffectiveEndDate", data.individualResponse.identityEffetiveEndDate ? data.individualResponse.identityEffetiveEndDate : "");

                        //邮编
                        applicant.set("plcCustomer.post", data.individualResponse.post ? data.individualResponse.post : "")
                        //获取国家和地区
                        applicant.set("plcCustomer.address", data.individualResponse.address ? data.individualResponse.address : "")
                        applicant.set("plcCustomer.citizenship", data.individualResponse.countryCode ? data.individualResponse.countryCode : "CHN")
                        //境外标识
                        applicant.set("plcCustomer.isWithinForeign", data.individualResponse.isWithinForeign ? data.individualResponse.isWithinForeign : "1")

                        //手机号码
                        applicant.set("plcCustomer.mobile", data.individualResponse.mobile ? data.individualResponse.mobile : "");
                        //座机
                        applicant.set("plcCustomer.phoneNumber", data.individualResponse.phoneNumber ? data.individualResponse.phoneNumber : "");
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
                        if(data.individualResponse.manualRiskLevelCode){
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
                                    break;
                                default:
                                    applicant.set("customerRiskGradeName", "");
                                    break;
                            }
                        }
                        //证件识别Id
                        applicant.set("registId", data.individualResponse.registId ? data.individualResponse.registId : null);
                        //邮箱
                        applicant.set("plcCustomer.email", data.individualResponse.email ? data.individualResponse.email : "")
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
                        applicant.set("plcGrpCustomer.registyAddress", data.orgnizationResponse.registyAddress ? data.orgnizationResponse.registyAddress : "")
                        //邮编后续需要更换
                        applicant.set("plcGrpCustomer.mailAddressPost", data.orgnizationResponse.mailAddressPost ? data.orgnizationResponse.mailAddressPost : "")
                        //客户等级
                        applicant.set("customerGrade", data.orgnizationResponse.customerGrade ? data.orgnizationResponse.customerGrade : "");
                        //证件识别Id
                        applicant.set("registId", data.orgnizationResponse.registId ? data.orgnizationResponse.registId : null);

                        /*从plcapplicant中移植过来缺少的字段start*/

                        applicant.set("customerEName", data.orgnizationResponse.customerEName ? data.orgnizationResponse.customerEName : null);
                        applicant.set("plcGrpCustomer.organizationType", data.orgnizationResponse.organizationType ? data.orgnizationResponse.organizationType : null);
                        //映射value
                        var organizationList=cola.util.dictionary("OrgnizationType(FXQ)");
                        organizationList.forEach(function(_item){
                            if(_item.key==data.orgnizationResponse.organizationType){
                                applicant.set("plcGrpCustomer.organizationName", _item.value);
                            }
                        });
                        applicant.set("plcGrpCustomer.organizationSecondType", data.orgnizationResponse.economicTypeCode ? data.orgnizationResponse.economicTypeCode : null);
                        applicant.set("identifyEffectiveStartDate", data.orgnizationResponse.identityEffetiveStartDate ? data.orgnizationResponse.identityEffetiveStartDate : null);
                        applicant.set("identifyEffectiveEndDate", data.orgnizationResponse.identityEffetiveEndDate ? data.orgnizationResponse.identityEffetiveEndDate : null);
                        applicant.set("isLink", data.orgnizationResponse.isLink ? data.orgnizationResponse.isLink : null);
                        applicant.set("plcGrpCustomer.industryCategory", data.orgnizationResponse.industryCategory ? data.orgnizationResponse.industryCategory : null);
                        //映射value
                        var industryList=cola.util.dictionary("IndustryBigClass");
                        industryList.forEach(function(_item){
                            if(_item.key==data.orgnizationResponse.industryCategory){
                                applicant.set("plcGrpCustomer.industryCategoryName", _item.value);
                            }
                        });
                        applicant.set("plcGrpCustomer.mainBussiness", data.orgnizationResponse.mainBusiness ? data.orgnizationResponse.mainBusiness : null);
                        applicant.set("plcGrpCustomer.registeredPlaceCode", data.orgnizationResponse.registeredPlaceCode ? data.orgnizationResponse.registeredPlaceCode : null);
                        applicant.set("plcGrpCustomer.busiLicense", data.orgnizationResponse.busilicense ? data.orgnizationResponse.busilicense : null);
                        applicant.set("plcGrpCustomer.busiLicenseStartDate", data.orgnizationResponse.busiLicenseStartDate ? data.orgnizationResponse.busiLicenseStartDate : null);
                        applicant.set("plcGrpCustomer.busiLicenseEndDate", data.orgnizationResponse.busiLicenseEndDate ? data.orgnizationResponse.busiLicenseEndDate : null);
                        applicant.set("plcGrpCustomer.taxRegistrationNo", data.orgnizationResponse.taxregistrationNo ? data.orgnizationResponse.taxregistrationNo : null);
                        //后续需要更换
                        applicant.set("plcGrpCustomer.email", data.orgnizationResponse.email ? data.orgnizationResponse.email : null);
                        applicant.set("plcGrpCustomer.facsimile", data.orgnizationResponse.facsimile ? data.orgnizationResponse.facsimile : null);
                        //后续需要更换
                        applicant.set("plcGrpCustomer.mailAddress", data.orgnizationResponse.mailAddress ? data.orgnizationResponse.mailAddress : null);

                        /*从plcapplicant中移植过来缺少的字段end*/
                        var riskgred='';
                        if(data.orgnizationResponse.manualRiskLevelCode){
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
                                applicant.set("plcGrpCustomer.mainCustomerGrade", data.orgnizationResponse.manualVIPLevelCode ? data.orgnizationResponse.manualVIPLevelCode : null)
                            }else if(data.orgnizationResponse.autoVIPLevelCode){
                                ImgNums =data.orgnizationResponse.autoVIPLevelCode;
                                //重客等级
                                applicant.set("plcGrpCustomer.mainCustomerGrade", data.orgnizationResponse.autoVIPLevelCode ? data.orgnizationResponse.autoVIPLevelCode : null)
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
                                applicant.set("plcGrpCustomer.mainCustomerGrade", data.orgnizationResponse.manualVIPLevelCode ? data.orgnizationResponse.manualVIPLevelCode : null)
                            }else if(data.orgnizationResponse.autoVIPLevelCode){
                                ImgNums =data.orgnizationResponse.autoVIPLevelCode;
                                //重客等级
                                applicant.set("plcGrpCustomer.mainCustomerGrade", data.orgnizationResponse.autoVIPLevelCode ? data.orgnizationResponse.autoVIPLevelCode : null)
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
        },
        error: function (e) {
            console.log(e)
        }
    })
};
ContractEntity.prototype.initSelfDate = function (applicant, flag) {
    if (flag) {
        applicant.set("customerCode", "");
        applicant.set("identifyEffectiveEndDate", "");
        applicant.set("longtermEffectiveFlag", "0");
        if (applicant.get("plcCustomer")) {
            applicant.set("plcCustomer.age", "");
            applicant.set("plcCustomer.sex", "");
            applicant.set("plcCustomer.birthDate", "");
            applicant.set("plcCustomer.citizenship", "CHN");
            applicant.set("plcCustomer.address", "");
            applicant.set("plcCustomer.phoneNumber", "");
            applicant.set("plcCustomer.mobile", "");
            applicant.set("plcCustomer.email", "");
            applicant.set("plcCustomer.post", "");
            applicant.set("plcCustomer.isWithinForeign", "1");
        }
        applicant.set("despositBankName", "");
        applicant.set("accountName", "");
        applicant.set("accountNo", "")
        applicant.set("customerGrade", "");
        applicant.set("customerGradeName", "");
        applicant.set("customerRiskGrade", "");
        applicant.set("customerRiskGradeName", "");
    } else {
        applicant.set("customerCode", "");
        applicant.set("identifyEffectiveEndDate", "");
        applicant.set("longtermEffectiveFlag", "0");
        if (applicant.get("plcCustomer")) {
            applicant.set("plcCustomer.address", "");
            applicant.set("plcCustomer.phoneNumber", "");
            applicant.set("plcCustomer.mobile", "");
            applicant.set("plcCustomer.email", "");
            applicant.set("plcCustomer.post", "");
        }
        applicant.set("despositBankName", "");
        applicant.set("accountName", "");
        applicant.set("accountNo", "")
        applicant.set("customerGrade", "");
        applicant.set("customerGradeName", "");
        applicant.set("customerRiskGrade", "");
        applicant.set("customerRiskGradeName", "");
    }
}
ContractEntity.prototype.initGropDate = function (applicant) {
    if (applicant.get("plcGrpCustomer")) {
        applicant.set("plcGrpCustomer.registyAddress", "");
        applicant.set("plcGrpCustomer.mailAddressPost", "");
    }
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
            {key: "10", value: "外国人永久居留证"},
            {key: "14", value: "往来港澳通行证"},
            {key: "15", value: "大陆居民往来台湾通行证"},
            {key: "16", value: "军官离退休证"},
            {key: "17", value: "港澳居民来往内地通行证"},
            {key: "18", value: "中国因私护照"},
            {key: "19", value: "外国护照"},
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

//占用性质过滤
ContractEntity.prototype.sortFilter = function (items){
  return [
    {key: "0001",value:"一级工业"},
    {key: "0002",value:"二级工业"},
    {key: "0003",value:"三级工业"},
    {key: "0004",value:"四级工业"},
    {key: "0005",value:"五级工业"},
    {key: "0006",value:"六级工业"},
    {key: "0009",value:"半导体芯片厂"}
  ]
}

//通过身份证号带出生日年龄国籍性别境内外默认值
ContractEntity.prototype.getIdentifyInfor = function (applicant) {
    var identifyValue = applicant.get("identifyNumber");//证件号码
    var identifyType = applicant.get("identifyType");//证件类型
    var reg = /^(\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
    var regSFZ = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
    //判断当前是投保人还是被保人
    if (applicant.dataType && (applicant.dataType.get("name") == "PlcApplicant" || applicant.dataType.get("name") == "PageInsurance")) {
        applicant.set("plcCustomer", {})//如果不声明plcCustomer是个对象,下面给plcCustomer下面的属性赋值时会报错
    }
    applicant.set("plcCustomer.isWithinForeign", 1)
    if (identifyType == "01" && regSFZ.test(identifyValue)) { //.length==18||identifyValue.length==15
        if (reg.test(identifyValue) && identifyValue.length == "18" && applicant.get("identifyType") == '01') {
            applicant.set("plcCustomer.citizenship", "CHN");
            applicant.set("plcCustomer.citizenshipName", "中国");
            if (parseInt(identifyValue.substr(16, 1)) % 2 == 1) {
                applicant.set("plcCustomer.sex", "1");
                applicant.set("plcCustomer.sexName", "男性");
//是男则执行代码 ...
            } else {
                applicant.set("plcCustomer.sex", "2");
                applicant.set("plcCustomer.sexName", "女性");
//是女则执行代码 ...
            }
            //获取年龄
            var myDate = new Date();
            var month = myDate.getMonth() + 1;
            var day = myDate.getDate();
            var age = myDate.getFullYear() - identifyValue.substring(6, 10) - 1;//420881 1992 12 13 5427

            if (identifyValue.substring(10, 12) < month || identifyValue.substring(10, 12) == month && identifyValue.substring(12, 14) <= day) {
                age++;
            }
            applicant.set("plcCustomer.age", age)
            // 获取生日
            var birth = identifyValue.substring(6, 10) + "-" + identifyValue.substring(10, 12) + "-" + identifyValue.substring(12, 14);
            applicant.set("plcCustomer.birthDate", birth)
        } else if (identifyValue.length == "15" && applicant.get("identifyType") == '01') {//420881 199212 13 8
            applicant.set("plcCustomer.citizenship", "CHN");
            applicant.set("plcCustomer.citizenshipName", "中国");
            applicant.set("plcCustomer.isWithinForeign", 1);
            if (parseInt(identifyValue.substr(14)) % 2 == 1) {
                applicant.set("plcCustomer.sex", "1");
                applicant.set("plcCustomer.sexName", "男性");
//是男则执行代码 ...
            } else {
                applicant.set("plcCustomer.sex", "2");
                applicant.set("plcCustomer.sexName", "女性");
//是女则执行代码 ...
            }
            //获取年龄
            var myDate = new Date();
            var month = myDate.getMonth() + 1;
            var day = myDate.getDate();
            var age = myDate.getFullYear() - ("19" + identifyValue.substring(6, 8)) - 1;//420881 92 12 13 54 6
            if (identifyValue.substring(8, 10) < month || identifyValue.substring(8, 10) == month && identifyValue.substring(10, 12) <= day) {
                age++;
            }
            applicant.set("plcCustomer.age", age);
            // 获取生日
            var birth = 19 + identifyValue.substring(6, 8) + "-" + identifyValue.substring(8, 10) + "-" + identifyValue.substring(10, 12);
            applicant.set("plcCustomer.birthDate", birth);
        } else {
            contractEntity.initSelfDate(applicant, true);
        }
    }
}
//校验投保人和被保人输入的年龄
ContractEntity.prototype.judgeAge = function (model) {
    var identifyType = model.get("identifyType");//证件类型
    var startDate = model.get("plcCustomer.birthDate");
    var nowAge = contractEntity.getAge(startDate);
    var age = model.get("plcCustomer.age");
    if (startDate != "Invalid Date" && startDate != "" && age != nowAge && identifyType == "01") {
        model.set("plcCustomer.age", nowAge);
        cola.NotifyTipManager.warning({
            message: "",
            description: "输入的年龄与实际年龄不符",
            showDuration: 3000
        });
    }
}

//出生日期计算年龄
ContractEntity.prototype.getAge = function (startDate) {
    var date = new Date();
    startDate = new Date(startDate);
    var newDate = date.getTime() - startDate.getTime();
    var applicantNowAge = Math.floor(newDate / 1000 / 60 / 60 / 24 / 365);
    return applicantNowAge;
}

//判断境内和境外
ContractEntity.prototype.churchyardOutbound = function (applicant) {
    if (!applicant.get("plcCustomer.citizenship")) {
        applicant.set("plcCustomer.isWithinForeign", null)
    } else if (applicant.get("plcCustomer.citizenship") == "CHN") {
        applicant.set("plcCustomer.isWithinForeign", 1)
    } else {
        applicant.set("plcCustomer.isWithinForeign", 0)
    }
}

//投保人和被保人证件有限期限
ContractEntity.prototype.papersDeadline = function (applicant) {
    var identityEndDate = applicant.get("identifyEffectiveEndDate").toJSON().split("T")[0].replace(/-/g, "")
    var time = new Date();
    var nowTime = time.toJSON().split("T")[0].replace(/-/g, "");
    if (identityEndDate && Number(identityEndDate) - Number(nowTime) <= 0) {
        cola.NotifyTipManager.warning({
            message: "",
            description: "证件过期不可投保，请修改证件有效止期",
            showDuration: 3000
        });
        applicant.set("identifyEffectiveEndDate", "");
        applicant.set("longtermEffectiveFlag", "0");
    }
}

//投保人和被保人为个人时电话和手机号不能同时为空
ContractEntity.prototype.personageMobilePhone = function (applicant) {
    var phoneNum = applicant.get("plcCustomer.phoneNumber");
    var mobileNum = applicant.get("plcCustomer.mobile");
    if (!phoneNum && !mobileNum) {
        cola.NotifyTipManager.warning({
            message: "",
            description: "联系人电话和手机号不能同时为空",
            showDuration: 3000
        });
    }
}

//投保人和被保人为单位时电话和手机号不能同时为空
ContractEntity.prototype.monadMobilePhone = function (applicant) {
    var phoneNum = applicant.get("linkerPhoneNo");
    var mobileNum = applicant.get("linkerMobile");
    if (!phoneNum && !mobileNum) {
        cola.NotifyTipManager.warning({
            message: "",
            description: "联系人电话和手机号不能同时为空",
            showDuration: 3000
        });
    }
}
ContractEntity.prototype.getCostAmount = function (model,notAlert) {//支出费用模块获取费用金额
    var allAmount = model.get("actual.premium");//总保费
    var CostRateAll = model.get("solution.plcCost");
    if (CostRateAll) {
        CostRateAll.each(function (entity) {
            var CostRate = entity.get("costRate");//手续费比例
            if(CostRate){
                if (CostRate || CostRate == 0 && allAmount || allAmount == 0) {
                    var CostFee =contractEntity.formatToTwoPrecision(CostRate * allAmount / 100);
                    entity.set("costFee", CostFee);
                } else {
                    if(!notAlert){
                        App.alert("请计算总保费");
                    }
                }
            }
        })
    }
};
//费用信息模块根据手续费算出手续费金额
ContractEntity.prototype.rateGetAmount = function (model) {
    // 手续费金额＝不含税总保费＊手续费比例－－－20180120改
    var allAmount = model.get("actual.netPremium");//不含税总保费
    var agentTaxRate=model.get("actual.agentTaxRate");//手续费税率
    var agentRates = model.get("actual.agentRate");//手续费比例
    //不含税手续费金额=含税手续费金额/(1+税率/100)
    if ((allAmount || allAmount == 0) && (agentRates || agentRates == 0)) {
        //var agentAmounts = Number((allAmount * agentRates / 100).toFixed(2));
      //var agentAmounts =  Math.round((allAmount * agentRates / 100)*100)/100;//手续费取四舍五入取两位
      var agentAmounts = contractEntity.formatToTwoPrecision(allAmount * agentRates / 100);//手续费取四舍五入取两位
        model.set("actual.agentFee", agentAmounts);//手续费含税金额
        if(agentTaxRate||agentTaxRate==0){
            var agentNetFee=contractEntity.formatToTwoPrecision(model.get("actual.agentFee")/(1+agentTaxRate/100));
            model.set("actual.agentNetFee", agentNetFee);//手续费不含税金额
            console.log(model.get("actual.agentNetFee")+"-----手续费不含税金额");
            var agentTaxFee=contractEntity.formatToTwoPrecision(model.get("actual.agentFee")-model.get("actual.agentNetFee"));
            model.set("actual.agentTaxFee", agentTaxFee);//手续费税额
            console.log(model.get("actual.agentTaxFee")+"-----手续费税额");
        }

    }
};
//关系人名称校验
ContractEntity.prototype.checkCustomerName = function (entity) {
  var customerType = entity.get('customerType');
  var customerName = entity.get('customerName');
  if(customerName){
    var newCustomerName = customerName.trim();
    if(customerType == '1'){
        var eregChinses  = /^([\u4E00-\u9FA5a-z0-9·。.])*$/gi;
        var eregEnglish = /^([a-z]|[0-9]|[,.()& ])*$/i;
        var eregNumbers = /^([0-9]|[ ])*$/g;
        if(newCustomerName!=''){
          if(/[\u4e00-\u9fa5]/.test(newCustomerName)){//汉字
            if(!/[\u4e00-\u9fa5]{2,}/.test(newCustomerName)){
              return "个人客户中文姓名长度至少为2个汉字！";
            }
          if(!eregChinses.test(newCustomerName) ){
              return "个人客户姓名不能包含除汉字、英文、数字或中间点(·)以外的特殊字符，也不能包含空格！";
            }else{
              entity.set('customerName',newCustomerName.replace(/[.]|[。]/g,"·"))
            }

          }else{
            if(!/[a-z]{2,}/i.test(newCustomerName)){
              return "非汉字个人客户姓名长度至少为2个英文字母！";
            }else if(eregNumbers.test(newCustomerName)){
              return "个人客户姓名不能全是数字！";
            }else if(!eregEnglish.test(newCustomerName)){
              return "非汉字个人客户姓名不能包含除英文、数字、“,”、“.”、“(”、“)”、“&”以外的任何特殊字符！";
            }
            entity.set('customerName',newCustomerName.replace(/[ ]{1,}/g," "))
          }
        }

    }else if(customerType == '2'){
        var name=newCustomerName.replace(/\s+/g, "");        //除去客户名称中所有空格后的值
        var eregChinses  = /^([\u4E00-\u9FA5]|[a-z0-9]|[.。·])*$/i;
        var eregEnglish = /^([a-z0-9]|[,.()&-;\"\/ ])*$/i;
        var bracketsZn=/^([\u4E00-\u9FA5]|[\ue863]|[a-z0-9]|[·.-\/——-”“‘’《》（）()])*$/i; //中文验证规则
        var eregNumbers = /^([0-9]|[ ])*$/g;
        if(name.length>0){
          if(/[\u4e00-\u9fa5]/.test(newCustomerName)){
            if((/\s+/g).test(newCustomerName)){
              return "组织客户中文名称不能包含空格！"
            }
            if(newCustomerName.length<4){
              return "组织客户中文名称长度在4~60个汉字之间！"
            }
            if(!bracketsZn.test(newCustomerName)){
              return "组织客户中文名称中允许的特殊字符包括：中文单双引号、中英文括号、中文书名号、“·”、“.”、“-”、“\/”、“——”、“-”！";
            }
            //entity.set('customerName',name)
          }else{
            if(eregNumbers.test(newCustomerName)){
              return "组织客户英文名称不能全是数字!"
            }
            if(!/[a-z]{2,}/i.test(newCustomerName)){
              return "非汉字组织客户姓名至少为2个英文字母！";
            }
            if(!eregEnglish.test(newCustomerName)){
              return "组织客户英文名称中允许的字符包括：英文、数字、半角括号、英文双引号、分号、“,”、“.”、“-”、“\/”！";
            }
            entity.set('customerName',newCustomerName.replace(/[ ]{1,}/g," "))
          }
        }
        /*  if (!(/[\u4e00-\u9fa5]{4,30}|^[A-Za-z0-9().,《》“”]+$/.test(customerName))) {
              return "组织中文名称至少四个汉字！英文名称只能包含大小写英文、数字和().,《》“”字符";
          }*/
    }
  }
}



//判断连续字符
var checkRepetition = function (value) {
    var flag = 0;
    for (var i = 0; i < value.length - 1; i++) {
        if (value.charAt(i) == value.charAt(i + 1)) {
            flag += 1;
        }
    }
    if (flag == value.length - 1) {
        return false;
    } else {
        return true;
    }
}

//小数限制位数
//参数（value，小数点前位数，小数点后位数，entity）
ContractEntity.prototype.checkNumberConfine = function(number1,number2,arg){
  var value=arg.inputValue;
  if(value && ((/^\d+(\.\d+)*$/).test(value)||(/^(\.\d+)*$/).test(value))){
    if(!number1){
      if(value.toString().indexOf('.')>-1){
        var num=value.toString().substring(value.toString().indexOf('.')+1)
        if(num && num.length==number2){
          App.alert('最多'+number2+"小数位！");
          return false;
        }
      }
    }else{
      if(value.toString().indexOf('.')<0&&value.toString().length==number1 &&arg.keyCode!='46'){
        App.alert('整数最多'+number1+"位！");
        return false;
      }else if(value.toString().indexOf('.')>-1){
        var num=value.toString().substring(value.toString().indexOf('.')+1)
        if(num && num.length==number2){
          App.alert('最多'+number2+"小数位！");
          return false;
        }
      }
    }
  }
},
//受益比例校验
ContractEntity.prototype.checkBenefitRate = function(value,entity){
  if(value!=0 && !value){
    return "不能为空！"
  }
}

ContractEntity.prototype.checkNotNull = function(value,entity){
  if(value!=0 && !value){
    return "不能为空！"
  }
}


//携式无线通讯类与便携式影音娱乐数码产品的关系两者二选一必填
ContractEntity.prototype.checkWirComToolClass = function(value,entity,property){
  if(!entity.get(property)&& !value){
    return "携式无线通讯类和便携式影音娱乐数码产品不能同时为空！"
  }
}

//校验IMEI，SN 不能同时为空
ContractEntity.prototype.checkIMEIAndSN = function(value,entity,property){
  if(!entity.get(property)&& !value){
    return "移动设备识别码和产品编号不能同时为空！"
  }
}
//大于0，校验
ContractEntity.prototype.checkSmallNumber = function(value,property,entity){
  if(value &&(!(/^\d+(\.\d+)*$/).test(value)|| value<0)){
    entity.set(property,0);
    App.alert("只能输入大于0的数！");
    return "只能输入大于0的数！";
  }
}
//大于0，小于number的校验公共方法（number传参）
ContractEntity.prototype.checkNumber = function(value,property,number,entity){
  if(value && (!(/^\d+(\.\d+)*$/).test(value)|| value<0 || value>number)){
    entity.set(property,0);
    App.alert("只能输入0~"+number+"之间的数！");
    return "只能输入0~"+number+"之间的数！";

  }
}

//电话号码校验
ContractEntity.prototype.checkPhoneNumber=function(phoneNumber,entity,property){
  if(phoneNumber && !(/^[0123456789-]*$/.test(phoneNumber))){
    return "请输入正确格式的电话号码！"
  }
  if(!entity.get(property)&& !phoneNumber){
    return "联系电话和手机不能同时为空！"
  }
}
//手机号校验
ContractEntity.prototype.checkModelNumber=function(mobile,entity,property){

  if(mobile && !(/^1[123456789]\d{9}$/.test(mobile))){
    return "请输入正确格式的手机号码！"
  }
  if(!entity.get(property)&& !mobile){
    return "联系电话和手机不能同时为空！"
  }
}

//车架号校验
ContractEntity.prototype.checkFrameNo = function (value) {
    if (value && (!(/^[A-Z0-9]{17}$/.test(value)) || (/[IOQ]+/.test(value)) || !checkRepetition(value))) {
        return "车架号只能录入17位除I O Q之外的大写英文或数字！"
    }
}
//证件号码校验
ContractEntity.prototype.checkIdentifyNumber = function (identifyType, identifyNumber) {
    if (identifyNumber) {
        if (identifyType == '01') {// 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
            var re = /(^\d{15}$)|(^\d{17}(\d|X|x)$)/;
            if (!re.test(identifyNumber)) {
                return "请输入有效的身份证号码！"
            }
            /*  } else if (identifyType == '02') {// 居民户口簿
            var re=/^[a-zA-Z0-9]{3,21}$/;
            if(!re.test(identifyNumber)){
                return "请输入有效的居民户口簿号码！"
            }*/
            /*  } else if (identifyType == '11') {// 临时身份证 (和身份证号码规则相同 )
            var re=/^(\d{15})|(\d{17}(\d|X|x))$/;
            if(!re.test(identifyNumber)){
                return "请输入有效的临时身份证号码！"
            }*/

        } else if (identifyType == '22') {//统一社会信用代码 (15或18位字母或者数字组成的字符串)

            var re1 = /^[A-Z0-9]{18}$/;
            var re2 = /^[A-Z0-9]{15}$/;
            if (!re1.test(identifyNumber) && !re2.test(identifyNumber)) {
                return "请输入有效的统一社会信用代码！"
            }

            /*}else if (identifyType == '12') {// 香港身份证 身份证号码由 1 或 2 个英文字母及 6 个数字组成
            var re=/^([A-Za-z]{1,2}\d{6})$/;
            if(!re.test(identifyNumber)){
                return "请输入有效的香港身份证号码！"
            }

        } else if (identifyType == '14') {// 往来港澳通行证
            var re=/^[HMhm]{1}([0-9]{10}|[0-9]{8})$/;
            if(!re.test(identifyNumber)){
                return "请输入有效的往来港澳通行证号码！"
            }

        } else if (identifyType == '03') {// 中国因公护照 P开头,7位数字
            var re=/^(P\d{7})$/;
            if(!re.test(identifyNumber)){
                return "请输入有效的中国因公护照号码！"
            }
        } else if (identifyType == '15') {// 大陆居民往来台湾通行证
            var re=/^([0-9]{8}|[0-9]{10})$/;
            if(!re.test(identifyNumber)){
                return "请输入有效的大陆居民往来台湾通行证号码！"
            }

        }else if(identifyType == '04'){//军官证/警官证
            var re= /^[a-zA-Z0-9]{7,21}$/;
            if(!re.test(identifyNumber)){
                return "请输入有效的军官证/警官证号码！"
            }

        } else if (identifyType == '16') {//军官离退休证
            var re= /^[a-zA-Z0-9]{7,21}$/;
            if(!re.test(identifyNumber)){
                return "请输入有效的军官离退休证号码！"
            }

        } else if (identifyType == '05') {// 驾驶证

        } else if (identifyType == '17') {// 港澳居民来往内地通行证,11位,第1位“H”字头签发给香港居民，“M”字头签发给澳门居民；第2位至第11位为数字
            var re=/^(H|M)\d{10}$/;
            if(!re.test(identifyNumber)){
                return "请输入有效的港澳居民来往内地通行证号！"
            }

        } else if (identifyType == '06') {// 台湾居民来往大陆通行证

        } else if (identifyType == '18') {// 中国因私护照 (G开头,8位数字)
            var re=/^G\d{8}$/;
            if(!re.test(identifyNumber)){
                return "请输入有效的中国因私护照号码！"
            }*/

        } else if (identifyType == '07') {// 组织机构代码证

            var re = /^[A-Za-z0-9-]{1,20}$/;
            if (!re.test(identifyNumber)) {
                return "请输入有效的组织机构代码证！"
            }
            /* } else if (identifyType == '19') {// 外国护照

        } else if (identifyType == '08') {// 士兵证

        } else if (identifyType == '09') {// 警官证

        } else if (identifyType == '99X') {// 学生证



        } else if (identifyType == '20') {
            // 澳门身份证身份证号码由8个拉丁数字组成格式为"X/NNNNNN/Y"
            //在“/”符号前加上一个拉丁数字1、5或7以代表其取证时代，而在“/”符号后加上的拉丁数字则为查核用数码
            var re=/^(1|5|7)\/\d{6}\/\d{1}$/;
            if (!re.test(identifyNumber)){
                return "请输入有效的澳门身份证号"
            }

        } else if (identifyType == '20') {// 台湾身份证,第一位由26位英文字母组成，第二位性别1为男2为女，后8位为随机数字
            var re=/^[A-Z]{1}(1|2)\d{8}$/;
            if(!re.test(identifyNumber)){
                return "请输入有效的台湾身份证号码！"
            }

        } else if (identifyType == '10') {//外国人永久居留证

        }*/
        }
    }

}

//保费计算前对联共保数据进行校验
ContractEntity.prototype.checkCommLinkSaveFun = function(model){
    //校验保存时联保和共保为空Role -- 联共保模块校验
    var coinsCode = model.get("actual.coinsCode");
    var coinsLinkCode = model.get("actual.coinsLinkCode");
    var coinLinkPart = model.get("actual.plcSolution.plcCoins");
    var saveFlag = true;   //&& (coinsLinkCode == '3')
    if ((coinsCode == '1' || coinsCode == '2') && saveFlag) {
        var coinRoles = coinLinkPart.get("plcCoinsBasicInformation");
        var coinsDetail = coinLinkPart.get("plcCoinsCommission");
        if (!coinRoles || coinRoles.entityCount < 2) {
            cola.NotifyTipManager.warning({
                message: "",
                description: "请添加共保方信息",
                showDuration: 3000
            });
            saveFlag = false;
            return false;
        }else{
            saveFlag = validateCoinRoles(model);
        }
        if (coinsDetail && coinsDetail.entityCount > 0 && saveFlag) {
            if(coinRoles.entityCount != coinsDetail.entityCount){
                cola.NotifyTipManager.warning({
                    message: "",
                    description: "已经存在共保手续费，请先点击共保手续费计算",
                    showDuration: 3000
                });
                saveFlag = false;
                return false;
            }
            // 校验手续费比例之和
            var totalRate = 0;
            coinsDetail.each(function(enty){
                totalRate += Number(enty.get("coinsCostRate"));
            });
            if(totalRate != 100 && saveFlag){
                cola.NotifyTipManager.warning({
                    message: "",
                    description: "共保手续费比例之和需等于100",
                    showDuration: 3000
                });
                saveFlag = false;
                return false;
            }
        }
        //校验我方身份
        if(coinsCode == '1' && saveFlag){//我司身份是主共
            var tempSaveFlag = true;
            coinRoles.each(function(enty){
                if(enty.get("coinsIdentity") == "1" && enty.get("chiefFlag") != "1"){
                    tempSaveFlag = false;
                }
            });
            if(!tempSaveFlag){
                cola.NotifyTipManager.warning({
                    message: "",
                    description: "此单我方身份是主共，我方首席标识应选择“是”",
                    showDuration: 4000
                });
                saveFlag = false;
                return false
            }
        }else if(coinsCode == '2'　&&　saveFlag){//我司身份是从共
            var tempSaveFlag = true;
            var chiefFlagSize = 0;
            coinRoles.each(function(enty){
                if(enty.get("coinsIdentity") == "1" && enty.get("chiefFlag") == "1"){
                    tempSaveFlag = false;
                }
                if(enty.get("chiefFlag") == "1"){
                    chiefFlagSize++;
                }
            });
            if(!tempSaveFlag){
                cola.NotifyTipManager.warning({
                    message: "",
                    description: "此单我方身份是从共，我方首席标识应选择“否”",
                    showDuration: 4000
                });
                saveFlag = false;
                return false;
            }
            if(chiefFlagSize == 0){
                cola.NotifyTipManager.warning({
                    message: "",
                    description: "至少有一个共保方是首席",
                    showDuration: 4000
                });
                saveFlag = false;
                return false;
            }
        }
    } 
    if (coinsLinkCode == '3' && saveFlag) {
        var plcCoinsSaleList = coinLinkPart.get("plcCoinsSale");//联保销售信息
        var linkRoles = coinLinkPart.get("plcLinkBasicInformat");//联保
        var plcLinkCommission = coinLinkPart.get("plcLinkCommission");
        if (!linkRoles || linkRoles.entityCount < 2) {
            cola.NotifyTipManager.warning({
                message: "",
                description: "请添加联保方信息",
                showDuration: 3000
            });
            saveFlag = false;
            return false;
        }else{
            saveFlag = validateLinkAndSale(model,linkRoles,plcCoinsSaleList);
        }
        if (plcLinkCommission && plcLinkCommission.entityCount > 0 && saveFlag) {
            if(linkRoles.entityCount != plcLinkCommission.entityCount){
                cola.NotifyTipManager.warning({
                    message: "",
                    description: "已经存在共保手续费，请先点击共保手续费计算",
                    showDuration: 3000
                });
                saveFlag = false;
                return false;
            }
            // 校验手续费比例之和
            var totalRate = 0;
            plcLinkCommission.each(function(enty){
                totalRate += Number(enty.get("coinsCostRate"));
            });
            if(totalRate != 100){
                cola.NotifyTipManager.warning({
                    message: "",
                    description: "联保手续费比例之和需等于100",
                    showDuration: 3000
                });
                saveFlag = false;
                return false;
            }
        }
    }
    return saveFlag;
}

//删除联保role
ContractEntity.prototype.linkRoleRemove = function (model) {
    var link = model.get("actuals").current.get("plcSolution").current.get("plcCoins.plcLinkBasicInformat");//联保
    if (link && link.entityCount > 0) {
        var linkArr = [];
        link.each(function (ent) {
            linkArr.push(ent.get("actualId"));
        })
        contractEntity.removeRoles(model, linkArr, function () {
            link.each(function (obj) {
                obj.remove();
            })
        });
    }

}
//删除共保role
ContractEntity.prototype.unitRoleRemove = function (model) {
    var unit = model.get("actuals").current.get("plcSolution").current.get("plcCoins.plcCoinsBasicInformation");//共保
    if (unit && unit.entityCount > 0) {
        var unitArr = [];
        unit.each(function (ent) {
            unitArr.push(ent.get("actualId"));
        })
        contractEntity.removeRoles(model, unitArr, function () {
            unit.each(function (obj) {
                obj.remove();

            })
        });
    }
}
//删除共保手续费role
ContractEntity.prototype.unitCommRemove = function (model) {
    var unit = model.get("actuals").current.get("plcSolution").current.get("plcCoins.plcCoinsCommission");//共保手续费
    if (unit && unit.entityCount > 0) {
        var unitArr = [];
        unit.each(function (ent) {
            unitArr.push(ent.get("actualId"));
        })
        contractEntity.removeRoles(model, unitArr, function () {
            unit.each(function (obj) {
                obj.remove();

            })
        });
    }
}
//删除联保手续费role
ContractEntity.prototype.unitLinkRemove = function (model) {
    var unit = model.get("actuals").current.get("plcSolution").current.get("plcCoins.plcLinkCommission");//联保手续费
    if (unit && unit.entityCount > 0) {
        var unitArr = [];
        unit.each(function (ent) {
            unitArr.push(ent.get("actualId"));
        })
        contractEntity.removeRoles(model, unitArr, function () {
            unit.each(function (obj) {
                obj.remove();

            })
        });
    }
}
//删除联保销售信息role
ContractEntity.prototype.unitLinkSaleRemove = function (model) {
    var unit = model.get("actuals").current.get("plcSolution").current.get("plcCoins.plcCoinsSale");//联保销售信息
    if (unit && unit.entityCount > 0) {
        var unitArr = [];
        unit.each(function (ent) {
            unitArr.push(ent.get("actualId"));
        })
        contractEntity.removeRoles(model, unitArr, function () {
            unit.each(function (obj) {
                obj.remove();

            })
        });
    }
}
function coInsuranceInfoFn(model) {
    //共保校验函数
    if (model.get("actual.$mainCoinsIdentityNum") == 0) {
        cola.NotifyTipManager.warning({
            message: "",
            description: "请至少有一条主共方信息",
            showDuration: 3000
        });
        // linkFlag=false;
        model.set("actual.$linkFlag", false);
        cola.tag("commClick").set("disabled", false);
        return false;
    }
    if (model.get("actual.$uniFlagList") == 0) {
        cola.NotifyTipManager.warning({
            message: "",
            description: "必须有一个共保主首席标志",
            showDuration: 3000
        });
        model.set("actual.$linkFlag", false);
        cola.tag("commClick").set("disabled", false);
        return false
    }
    if (model.get("actual.$coinsIdentityNum") == 0) {
        cola.NotifyTipManager.warning({
            message: "",
            description: "请至少有一条从共方信息",
            showDuration: 3000
        });
        model.set("actual.$linkFlag", false);
        cola.tag("commClick").set("disabled", false);
        return false;
    }
    ;
    if (model.get("actual.$coinRate") != 100) {
        cola.NotifyTipManager.warning({
            message: "",
            description: "共保比例之和必须等于100",
            showDuration: 3000
        });
        model.set("actual.$linkFlag", false);
        cola.tag("commClick").set("disabled", false);
        return false;
    }
    var commObjLists=model.get("solution.plcCoins.plcCoinsBasicInformation");//共保
    if(commObjLists){
        commObjLists.each(function(entity){
            if(entity.get("chiefFlag")==null){
                cola.NotifyTipManager.warning({
                    message:"",
                    description:"首席标志不能为空",
                    showDuration:3000
                });
                model.set("actual.$linkFlag",false);
                cola.tag("commClick").set("disabled",false);
                return false;
            }
        })
    }
    
}

//共保方信息校验
function validateCoinRoles(model){
    var saveFlag = true;
    var handingEntity = model.get("actual.plcSolution.plcCoins");//父级
    var uniobjList = handingEntity.get("plcCoinsBasicInformation");//共保
    //共方校验
    if (!uniobjList || uniobjList.entityCount < 2) {
        cola.NotifyTipManager.warning({message: "",description: "至少要有两条共保方信息",showDuration: 3000});
        saveFlag = false;
        cola.tag("commClick").set("disabled", false);
        return false;
    }
    var chiefFlagNum = 0;//首席个数
    var coinsRateTotal = 0;//共保比例总和
    uniobjList.each(function(entity){
        if(!entity.get("coinsComCode") || entity.get("coinsComCode") == ""){
            cola.NotifyTipManager.warning({message:"",description:"请选择共保人",showDuration:3000});
            saveFlag = false;
            cola.tag("commClick").set("disabled", false);
            return false;
        }
        //共保首席个数校验
        if(entity.get("chiefFlag")==null){
            cola.NotifyTipManager.warning({message:"",description:"首席标志不能为空",showDuration:3000});
            saveFlag = false;
            cola.tag("commClick").set("disabled", false);
            return false;
        }else if(entity.get("chiefFlag")=="1"){
            chiefFlagNum++;
        }
        coinsRateTotal += Number(entity.get("coinsRate"));
    });
    if (chiefFlagNum == 0) {
        cola.NotifyTipManager.warning({message: "",description: "必须有一个共保主首席标志",showDuration: 3000});
        saveFlag = false;
        cola.tag("commClick").set("disabled", false);
        return false;
    }
    if (coinsRateTotal != 100) {
        cola.NotifyTipManager.warning({message: "",description: "共保比例之和必须等于100",showDuration: 3000});
        saveFlag = false;
        cola.tag("commClick").set("disabled", false);
        return false;
    }
    return saveFlag;
}

//联保校验函数
function validateLinkAndSale(model, linkObjList, plcCoinsSaleList){
    var saveFlag = true;
    //联共方校验
    if (!linkObjList || linkObjList.entityCount < 2) {
        cola.NotifyTipManager.warning({message: "",description: "至少要有两条联共方信息",showDuration: 3000});
        saveFlag = false;
        cola.tag("linkClick").set("disabled", false);
        return false;
    }
    var chiefFlagNum = 0;//首席个数
    var coinsRateTotal = 0;//联保比例总和
    linkObjList.each(function(entity){
        if(!entity.get("coinsComCode") || entity.get("coinsComCode") == ""){
            cola.NotifyTipManager.warning({message:"",description:"请选择联保人",showDuration:3000});
            saveFlag = false;
            cola.tag("linkClick").set("disabled", false);
            return false;
        }
        //联保首席个数校验
        if(entity.get("chiefFlag")==null){
            cola.NotifyTipManager.warning({message:"",description:"首席标志不能为空",showDuration:3000});
            saveFlag = false;
            cola.tag("linkClick").set("disabled", false);
            return false;
        }else if(entity.get("chiefFlag")=="1"){
            chiefFlagNum++;
        }
        coinsRateTotal += Number(entity.get("coinsRate"));
    });
    if (chiefFlagNum == 0) {
        cola.NotifyTipManager.warning({message: "",description: "必须有一个联保主首席标志",showDuration: 3000});
        saveFlag = false;
        cola.tag("linkClick").set("disabled", false);
        return false;
    }
    if (coinsRateTotal != 100) {
        cola.NotifyTipManager.warning({message: "",description: "联保比例之和必须等于100",showDuration: 3000});
        saveFlag = false;
        cola.tag("linkClick").set("disabled", false);
        return false;
    }
    //联共方销售信息校验
    if (!plcCoinsSaleList || plcCoinsSaleList.entityCount < 1) {
        cola.NotifyTipManager.warning({message: "",description: "请完善联共方销售信息",showDuration: 3000});
        saveFlag = false;
        cola.tag("linkClick").set("disabled", false);
        return false;
    }
    plcCoinsSaleList.each(function(entity,idx0){
        var idx = idx0 + 2;
        if(!entity.get("salesmanCode") || entity.get("salesmanCode") == ""){
            cola.NotifyTipManager.warning({message: "",description: "第"+ idx +"条联保销售信息-业务员不能为空",showDuration: 3000});
            saveFlag = false;
            cola.tag("linkClick").set("disabled", false);
            return false;
        }
        if(!entity.get("channelType") || entity.get("channelType") == ""){
            cola.NotifyTipManager.warning({message: "",description: "第"+ idx +"条联保销售信息-销售渠道不能为空",showDuration: 3000});
            saveFlag = false;
            cola.tag("linkClick").set("disabled", false);
            return false;
        }
        if(!entity.get("businessOffice") || entity.get("businessOffice") == ""){
            cola.NotifyTipManager.warning({message: "",description: "第"+ idx +"条联保销售信息-归属部门不能为空",showDuration: 3000});
            saveFlag = false;
            cola.tag("linkClick").set("disabled", false);
            return false;
        }
        var sameMainSellFlag = entity.get("sameMainSellFlag");//是否同主业务
        if(sameMainSellFlag != "1" && (!entity.get("businessNatureCode") || entity.get("businessNatureCode") == "")) {
            cola.NotifyTipManager.warning({message: "",description: "第"+ idx +"条联保销售信息-业务来源不能为空",showDuration: 3000});
            saveFlag = false;
            cola.tag("linkClick").set("disabled", false);
            return false;
        }
        if(sameMainSellFlag != "1" && entity.get("businessNatureCode") != '0'){
            if(!entity.get("saleaman") || entity.get("saleaman") == ""){
                cola.NotifyTipManager.warning({message: "",description: "第"+ idx +"条联保销售信息-代理人/经纪人/寿险人员机构不能为空",showDuration: 3000});
                saveFlag = false;
                cola.tag("linkClick").set("disabled", false);
                return false;
            }
            if(!entity.get("saleAgreementNo") || entity.get("saleAgreementNo") == ""){
                cola.NotifyTipManager.warning({message: "",description: "第"+ idx +"条联保销售信息-代理协议号不能为空",showDuration: 3000});
                saveFlag = false;
                cola.tag("linkClick").set("disabled", false);
                return false;
            }
        }
    });
    return saveFlag;
}

//共保手续费计算
ContractEntity.prototype.calcUnitCommFee = function (model) {
    contractEntity.unitCommRemove(model);//先删除共保手续费role
    model.set("actual.$uniFlagList", 0);
    model.set("actual.$coinsIdentityNum", 0);
    model.set("actual.$mainCoinsIdentityNum", 0);
    model.set("actual.$mainLinkIdenityNum", 0);
    model.set("actual.$coinRate", 0);
    // model.set("actual.$coinflg",true);
    var handingEntity = model.get("actual.plcSolution.plcCoins");//父级
    var uniobjList = handingEntity.get("plcCoinsBasicInformation");//共保
    var unitCommPersonArr = [];
    var coinsIncludeWay = handingEntity.get("coinsIncludeWay");// 共保手续费计费方式
    var agentFeeTotal = model.get("actual.agentFee"); //整单含税手续费
    var agentNetFeeTotal = model.get("actual.agentNetFee"); //整单不含税手续费
    var agentTaxFeeTotal = model.get("actual.agentTaxFee"); //整单税额
    // 份额计入 、全额计入：手续费比例自动等于共保份额/联保份额
    // 含税共保手续费/含税联保手续费=整单含税手续费*手续费比例
    // 不含税共保手续费/不含税联保手续费=整单含税手续费/(1+手续费税率)*手续费比例

    // 全额承担：我方手续费比例等于100%，他方手续费比例为0。
    // 我方含税共保手续费/我方含税联保手续费=整单含税手续费
    // 我方不含税共保手续费/我方不含税联保手续费=整单不含税手续费
    // 他方手续费为0
    if (uniobjList) {
        var agentFeeTemp = 0;//共保保额
        var agentNetFeeTemp = 0;//不含税手续费
        var agentTaxFeeTemp = 0;//手续费税额=含税手续费-不含税手续费）
        uniobjList.each(function (entity, idx) {
            var agentTaxRate = entity.get("agentTaxRate");
            if(!agentTaxRate || agentTaxRate == ""){
                agentTaxRate = model.get("actual.agentTaxRate");//给税率一个默认值6 
            }
            var coinsCostRate = 0;// 手续费比例
            if(coinsIncludeWay == "0" || coinsIncludeWay == "1"){
                coinsCostRate = entity.get("coinsRate");
            }else if(coinsIncludeWay == "2"){
                if(entity.get("coinsIdentity") == '1'){
                    coinsCostRate = 100;
                }else{
                    coinsCostRate = 0;
                }
            }
            var agentFee = 0;//手续费含税金额
            var agentNetFee = 0;//不含税手续费=含税手续费-税额(含税手续费/(1+税率))
            var agentTaxFee = 0;//手续费税额=含税手续费-不含税手续费）
            if((idx < uniobjList.entityCount - 1)){
                agentFee = contractEntity.formatToTwoPrecision(agentFeeTotal * coinsCostRate / 100);//手续费含税金额
                agentNetFee = contractEntity.formatToTwoPrecision(agentFee / (1 + agentTaxRate / 100));//不含税手续费=含税手续费-税额(含税手续费/(1+税率))
                agentTaxFee = contractEntity.formatToTwoPrecision(agentFee - agentNetFee);//手续费税额=含税手续费-不含税手续费）
                agentFeeTemp += agentFee;//手续费含税金额
                agentNetFeeTemp += agentNetFee;//不含税手续费
                agentTaxFeeTemp += agentTaxFee;//手续费税额=含税手续费-不含税手续费）
            }else{
                agentFee = contractEntity.formatToTwoPrecision(agentFeeTotal - agentFeeTemp);//手续费含税金额
                agentNetFee = contractEntity.formatToTwoPrecision(agentNetFeeTotal - agentNetFeeTemp);//不含税手续费=含税手续费-税额(含税手续费/(1+税率))
                agentTaxFee = contractEntity.formatToTwoPrecision(agentTaxFeeTotal - agentTaxFeeTemp);//手续费税额=含税手续费-不含税手续费）
            }
            var linkNo = entity.get("linkNo");
            //从共保--07
            if (entity.get("chiefFlag") == '1') {
                var uniFlagList = model.get("actual.$uniFlagList");
                uniFlagList = uniFlagList + 1;
                model.set("actual.$uniFlagList", uniFlagList);
            }
            if (entity.get("coinsIdentity") == '2' || entity.get("coinsIdentity") == '3') {
                var coinsIdentityNum = model.get("actual.$coinsIdentityNum");
                coinsIdentityNum = coinsIdentityNum + 1;
                model.set("actual.$coinsIdentityNum", coinsIdentityNum);
            }
            var coinRate = model.get("actual.$coinRate");
            coinRate += entity.get("coinsRate");
            model.set("actual.$coinRate", coinRate);
            unitCommPersonArr.push({
                coinsCostRate: coinsCostRate,
                linkNo: linkNo,
                coinsCode: entity.get("coinsCode"),
                agentFee: agentFee,
                agentTaxRate: agentTaxRate,
                agentTaxFee: agentTaxFee,
                agentNetFee: agentNetFee,
                operateTaxFeeRate: 6
            });
        });
    }
    var coinsCode = model.get("actual.coinsCode");// 共保标识
    var feeRateFlag = false;
    if (coinsCode == '2' || coinsCode == '1') {
        //共保显示
        var has1 = contractEntity.changeUnit(model) == false ? false : true;
        if (has1) {
            coInsuranceInfoFn(model);
        }
        // 投保单录入时，出单费录入增加如下校验：
        // 1) 主共主联：不允许我方录入，允许系统外他方和系统内他方录入；
        // 2) 主共无联：不允许我方录入，允许系统外他方录入；
        // 3) 从共主联：允许我方和系统内他方录入，不允许系统外他方录入；
        // 4) 从共无联：允许我方录入，不允许系统外他方录入；
        // 5) 纯主联：不允许我方录入，允许系统内他方录入；
        if(coinsCode != '2'){
            feeRateFlag = true;
        }
    }
    //含税手续费=保费*手续费比例
    //手续费税率-------------调销管
    //出单费=保费*出单费比例
     if (model.get("actual.$linkFlag")) {
        contractEntity.addRoles(handingEntity, model, "plcCoinsCommission", unitCommPersonArr, function (newEntity, responseData) {
        }).done(function (newEntity) {
            cola.tag("commClick").set("disabled", false);
            var commissionDetail = model.get("actual.plcSolution.plcCoins.plcCoinsCommission");
            var coinArr = model.get("actual.plcSolution.plcCoins.plcCoinsBasicInformation");
            commissionDetail.each(function (entity) {
                coinArr.each(function (ent) {
                    if (ent.get("coinsIdentity") == '1' && entity.get("linkNo") == ent.get("linkNo")) {
                        entity.set("coinsIdentity", "1");
                        entity.set("$coinLinkname", ent.get("coinsComName"));
                        entity.set("$feeRateFlag", feeRateFlag);
                    } else if (ent.get("coinsIdentity") == '3' && entity.get("linkNo") == ent.get("linkNo")) {//系统外他方
                        entity.set("coinsIdentity", "3");
                        entity.set("$coinLinkname", ent.get("coinsComName"));
                        entity.set("$feeRateFlag", feeRateFlag ? false : true);
                    }
                });
            })
        });
    } else {
        model.set("actual.$linkFlag", true);
    }
}
// 校验共保手续费是否计算
function calcAgentFeeLinkTotal(model){
    var plcCoinsCommission = model.get("actual.plcSolution.plcCoins.plcCoinsCommission");//共保手续费
    if(!plcCoinsCommission || plcCoinsCommission.entityCount == 0){
        cola.tag("linkClick").set("disabled", false);
        return { "msg": "请先计算共保手续费"};
    }
    var agentFee = 0;
    plcCoinsCommission.each(function(entity){
        if(entity.get("coinsIdentity") == '1'){
            agentFee = entity.get("agentFee");
        }
    });
    return {"msg": '' ,"agentFeeLinkTotal": agentFee};
}
//联保手续费计算
ContractEntity.prototype.calcLinkCommFee = function (model,productCode) {
    var handingEntity = model.get("actual.plcSolution.plcCoins");//父级
    var linkObjList = handingEntity.get("plcLinkBasicInformat");//联保
    var plcCoinsSaleList = handingEntity.get("plcCoinsSale");//联保销售信息

    if(!productCode){
        productCode = model.get("actual.productCode");
    }
    contractEntity.unitLinkRemove(model);//先删除联保手续费role
    //联保、联保销售信息校验
    var saveFlag = validateLinkAndSale(model,linkObjList,plcCoinsSaleList);
    var coinsCode = model.get("actual.coinsCode");// 共保标识
    // 投保单录入时，出单费录入增加如下校验：
    // 1) 主共主联：不允许我方录入，允许系统外他方和系统内他方录入；
    // 3) 从共主联：允许我方和系统内他方录入，不允许系统外他方录入；
    // 5) 纯主联：不允许我方录入，允许系统内他方录入；
    var feeRateFlag = false;
    var otherRateFlag = false;
    var agentFeeTotal = model.get("actual.agentFee"); //整单含税手续费
    var agentFeeLinkTotal = 0; //联保需要分摊的手续费
    if (coinsCode == '0') {//无共保
        feeRateFlag = true;
        agentFeeLinkTotal = agentFeeTotal;
    }else if(coinsCode == '1'){//我方主共、
        feeRateFlag = true;
        var res = calcAgentFeeLinkTotal(model);
        if(res.msg != ''){
            App.alert(res.msg);
            return false;
        }else{
            agentFeeLinkTotal = res.agentFeeLinkTotal;
        }
    } else {//我方从共
        otherRateFlag = true;
        var res = calcAgentFeeLinkTotal(model);
        if(res.msg != ''){
            App.alert(res.msg);
            return false;
        }else{
            agentFeeLinkTotal = res.agentFeeLinkTotal;
        }
    }
    if (saveFlag && model.get("actual.$linkFlag")) {
        var linkIncludeWay = handingEntity.get("linkIncludeWay");// 联保手续费计费方式
        //计算联保手续费
        $.ajax({
            url: "controller/contract/coinsLink/calcLinkCommFee?productCode="+productCode+"&mainAgentTaxRate="+model.get("actual.agentTaxRate")+"&mainCoinsCostRate="+model.get("actual.agentRate"),
            type: "POST",
            data: JSON.stringify({
                "plcCoinsSale": plcCoinsSaleList,//联保销售信息
                "linkObjList": linkObjList,//联保信息
                "linkIncludeWay": linkIncludeWay,//联保手续费计费方式
                "agentFeeTotal": agentFeeLinkTotal//联保手续费总额
            }),
            datatype: "json",
            contentType: "application/json",
            success: function (data) {
                if(JSON.stringify(data)!="{}"){
                    contractEntity.addRoles(handingEntity, model, "plcLinkCommission", data, function (newEntity, responseData) {
                    }).done(function (newEntity) {
                        cola.tag("linkClick").set("disabled", false);
                        var commissionDetail = model.get("actual.plcSolution.plcCoins.plcLinkCommission");
                        var LinkArr = model.get("actual.plcSolution.plcCoins.plcLinkBasicInformat");
                        commissionDetail.each(function (entity) {
                            if (LinkArr && LinkArr.entityCount > 0) {
                                LinkArr.each(function (enti) {
                                    if (enti.get("coinsIdentity") == '1' && entity.get("linkNo") == enti.get("linkNo")) {
                                        entity.set("coinsIdentity", "1");
                                        entity.set("coinsLinkCode", enti.get("coinsLinkCode"));
                                        entity.set("$coinLinkname", enti.get("coinsComName"));
                                        entity.set("$feeRateFlag", feeRateFlag);
                                    } else if (enti.get("coinsIdentity") == '2' && entity.get("linkNo") == enti.get("linkNo")) {//系统内他方
                                        entity.set("coinsIdentity", "2");
                                        entity.set("coinsLinkCode", enti.get("coinsLinkCode"));
                                        entity.set("$coinLinkname", enti.get("coinsComName"));
                                        entity.set("$feeRateFlag", feeRateFlag || otherRateFlag ? false : true);
                                    }
                                })
                            }
                        })
                    });
                }else{
                    cola.tag("linkClick").set("disabled", false);
                }
            },
            error:function(){
                cola.tag("linkClick").set("disabled", false);
            }
        });
    }
}
//修改共保身份dropdown
// 我方--------------1
// 系统内其他方-------2
// 系统外其他方-------3
ContractEntity.prototype.changeUnit = function (model) {
    model.get("actual.$coinflg", true);
    model.set("actual.$mainCoinsIdentityNum", 0);
    //选择主共是首席标志设为是

    var CoinsBasicList = model.get("actual.plcSolution.plcCoins.plcCoinsBasicInformation");
    //mainCoinsIdentityNum=0;//主共
    if (CoinsBasicList) {
        CoinsBasicList.each(function (entity) {
            if (entity.get("coinsIdentity") == "1") {
                var mainCoinsIdentityNum = model.get("actual.$mainCoinsIdentityNum");
                mainCoinsIdentityNum = mainCoinsIdentityNum + 1;
                model.set("actual.$mainCoinsIdentityNum", mainCoinsIdentityNum)
            }
        });
        if (model.get("actual.$coinflg") && model.get("actual.$mainCoinsIdentityNum") <= 1) {
            (CoinsBasicList.current.get("coinsIdentity") == '1') ? (CoinsBasicList.current.set("chiefFlag", '1')) : (CoinsBasicList.current.set("chiefFlag", '0'));
        }

        if (model.get("actual.$mainCoinsIdentityNum") > 1) {
            setTimeout(function () {
                model.set("solution.plcCoins.plcCoinsBasicInformation#.coinsIdentity", "");
                model.set("solution.plcCoins.plcCoinsBasicInformation#.chiefFlag", "")
            }, 0);
            cola.NotifyTipManager.warning({
                message: "",
                description: "只允许有一条主共方信息",
                showDuration: 3000
            });
            // linkFlag=false;
            model.set("actual.$linkFlag", false);
            return false;
        }
    }

}
//修改联保身份dropdown
ContractEntity.prototype.changeLink = function (model) {
    model.set("actual.$mainLinkIdenityNum", 0);

    var linkFlagList = model.get("actual.plcSolution.plcCoins.plcLinkBasicInformat");
    if (linkFlagList) {
        linkFlagList.each(function (entity) {
            if (entity.get("coinsIdentity") == "1") {
                var mainLinkIdenityNum = model.get("actual.$mainLinkIdenityNum");
                mainLinkIdenityNum = mainLinkIdenityNum + 1;
                model.set("actual.$mainLinkIdenityNum", mainLinkIdenityNum);
            }
        });
        if (model.get("actual.$coinflg") && model.get("actual.$mainLinkIdenityNum") <= 1) {
            // if(linkFlagList.current.get("coinsIdentity")=='1'&&model.get("actual.coinsLinkCode")=='3'){
            //     linkFlagList.current.set("chiefFlag",'1');
            //     cola.tag("mainCoinLink").set("disabled",true);
            // }else if(linkFlagList.current.get("coinsIdentity")=='2'&&model.get("actual.coinsLinkCode")=='3'){
            //     linkFlagList.current.set("chiefFlag",'0');
            //     cola.tag("mainCoinLink").set("disabled",true);
            // }
            linkFlagList.current.get("coinsIdentity") == '1' ? (linkFlagList.current.set("chiefFlag", '1')) : (linkFlagList.current.set("chiefFlag", '0'));
        }

        if (model.get("actual.$mainLinkIdenityNum") > 1) {
            setTimeout(function () {
                model.set("solution.plcCoins.plcLinkBasicInformat#.coinsIdentity", "");
                model.set("solution.plcCoins.plcLinkBasicInformat#.chiefFlag", "")
            }, 0);
            cola.NotifyTipManager.warning({
                message: "",
                description: "只允许有一条主联方信息",
                showDuration: 3000
            });
            // linkFlag=false;
            model.set("actual.$linkFlag", false);
            return false;
        }
    }
}
//联共保手续费计算公共方法
ContractEntity.prototype.getPlcCoinsCommissionData = function (model) {
    var commBasicFlag = false;//共保状态
    var linkBasicFlag = false;//联保状态
    if(model.get('actual.coinsCode') != '0') {
        commBasicFlag = true;
    }
    if(model.get('actual.coinsLinkCode') != '0') {
        linkBasicFlag = true;
    }
    if(linkBasicFlag && commBasicFlag){//共保加联保
        contractEntity.caleCoinLinkRateFee(model);
    }else if(commBasicFlag){//单共保
        contractEntity.caleCoinsCommissionFee(model);
    }else if(linkBasicFlag){//单联保
        contractEntity.caleLinkCommissionFee(model);
    }
}
//如果是单纯的共保。计算各自手续费 xxdeng
ContractEntity.prototype.caleCoinsCommissionFee = function (model) {
    var plcCoinsCommissionData = model.get("actual.plcSolution.plcCoins.plcCoinsCommission");//共保手续费
    var commObjLists = model.get("actual.plcSolution.plcCoins.plcCoinsBasicInformation");//共保
    // var agentFeeTotal = model.get("actual.agentFee"); //整单含税手续费
    if(plcCoinsCommissionData && commObjLists){
        plcCoinsCommissionData.each(function(entity){
            commObjLists.each(function (enty) {
                if ((entity.get("linkNo") == enty.get("linkNo"))) {
                    entity.set("coinsIdentity", enty.get("coinsIdentity"));
                    entity.set("$coinLinkname", enty.get("coinsComName"));
                    //出单费
                    if (entity.get("operateFeeRate") || entity.get("operateFeeRate") != 0) {
                        var operateTaxFeeRate = entity.get("operateTaxFeeRate");//出单费税率
                        if(!operateTaxFeeRate || operateTaxFeeRate == ""){
                            operateTaxFeeRate = 6;
                        }
                        var operateFee = contractEntity.formatToTwoPrecision(entity.get("operateFeeRate") * enty.get("coinsPremium") / 100);
                        var operateNetFee = contractEntity.formatToTwoPrecision(operateFee / (1 + operateTaxFeeRate / 100));
                        var operateTaxFee = contractEntity.formatToTwoPrecision(operateFee - operateNetFee);
                        entity.set("operateNetFee", operateNetFee);//不含税联共保出单费
                        entity.set("operateFee", operateFee);//含税联共保出单费
                        entity.set("operateTaxFeeRate", operateTaxFeeRate);//联共保出单税率
                        entity.set("operateTaxFee", operateTaxFee);//联共保出单税额
                    } else {
                        entity.set("operateFee", null);
                        entity.set("operateNetFee", null);//不含税联共保出单费
                        entity.set("operateTaxFee", null);//联共保出单税额
                    }
                }
            })
        });
    }
}
//如果是单纯的联保。计算各自手续费 xxdeng
ContractEntity.prototype.caleLinkCommissionFee = function (model) {
    var plcLinkCommissionData = model.get("actual.plcSolution.plcCoins.plcLinkCommission");//联保手续费
    var plcLinkObjLists = model.get("actual.plcSolution.plcCoins.plcLinkBasicInformat");//联保
    // var agentFeeTotal = model.get("actual.agentFee"); //整单含税手续费
    if(plcLinkCommissionData && plcLinkObjLists){
        plcLinkCommissionData.each(function(entity){
            plcLinkObjLists.each(function (enty) {
                if (entity.get("linkNo") == enty.get("linkNo")) {
                    entity.set("coinsIdentity", enty.get("coinsIdentity"));
                    entity.set("$coinLinkname", enty.get("coinsComName"));
                    //出单费
                    if (entity.get("operateFeeRate") || entity.get("operateFeeRate") != 0) {
                        var operateTaxFeeRate = entity.get("operateTaxFeeRate");//出单费税率
                        if(!operateTaxFeeRate || operateTaxFeeRate == ""){
                            operateTaxFeeRate = 6;
                        }
                        var operateFee = contractEntity.formatToTwoPrecision(entity.get("operateFeeRate") * enty.get("coinsPremium") / 100);
                        var operateNetFee = contractEntity.formatToTwoPrecision(operateFee / (1 + operateTaxFeeRate / 100));
                        var operateTaxFee = contractEntity.formatToTwoPrecision(operateFee - operateNetFee);
                        entity.set("operateNetFee", operateNetFee);//不含税联共保出单费
                        entity.set("operateFee", operateFee);//含税联共保出单费
                        entity.set("operateTaxFeeRate", operateTaxFeeRate);//联共保出单税率
                        entity.set("operateTaxFee", operateTaxFee);//联共保出单税额
                    } else {
                        entity.set("operateFee", null);
                        entity.set("operateNetFee", null);//不含税联共保出单费
                        entity.set("operateTaxFee", null);//联共保出单税额
                    }
                }
            });
        });
    }
}
//如果是共保 + 联保。计算手续费 xxdeng
ContractEntity.prototype.caleCoinLinkRateFee = function (model) {
    var plcCoinsCommissionData = model.get("actual.plcSolution.plcCoins.plcCoinsCommission");//共保手续费
    var plcLinkCommissionData = model.get("actual.plcSolution.plcCoins.plcLinkCommission");//联保手续费
    var commObjLists = model.get("actual.plcSolution.plcCoins.plcCoinsBasicInformation");//共保
    var plcLinkObjLists = model.get("actual.plcSolution.plcCoins.plcLinkBasicInformat");//联保
    var CostRate = model.get("actual.agentRate");//手续费比例
    // var agentFeeTotal = model.get("actual.agentFee"); //整单含税手续费
    var flg=true;//只读标志
    if (plcCoinsCommissionData) {
        contractEntity.caleCoinsCommissionFee(model);
        if(plcLinkCommissionData && plcLinkObjLists){
            plcLinkCommissionData.each(function(entity){
                plcLinkObjLists.each(function (enty) {
                    if (entity.get("linkNo") == enty.get("linkNo")) {
                        entity.set("coinsIdentity", enty.get("coinsIdentity"));
                        entity.set("$coinLinkname", enty.get("coinsComName"));
                        //出单费
                        if (entity.get("operateFeeRate") || entity.get("operateFeeRate") != 0) {
                            var operateTaxFeeRate = entity.get("operateTaxFeeRate");//出单费税率
                            if(!operateTaxFeeRate || operateTaxFeeRate == ""){
                                operateTaxFeeRate = 6;
                            }
                            var operateFee = contractEntity.formatToTwoPrecision(entity.get("operateFeeRate") * enty.get("coinsPremium") / 100);
                            var operateNetFee = contractEntity.formatToTwoPrecision(operateFee / (1 + operateTaxFeeRate));
                            var operateTaxFee = contractEntity.formatToTwoPrecision(operateFee - operateNetFee);
                            entity.set("operateNetFee", operateNetFee);//不含税联共保出单费
                            entity.set("operateFee", operateFee);//含税联共保出单费
                            entity.set("operateTaxFeeRate", operateTaxFeeRate);//联共保出单税率
                            entity.set("operateTaxFee", operateTaxFee);//联共保出单税额
                        } else {
                            entity.set("operateFee", null);
                            entity.set("operateNetFee", null);//不含税联共保出单费
                            entity.set("operateTaxFee", null);//联共保出单税额
                        }
                    }
                });
            });
        }
    }
}
//获取共保保额保费
ContractEntity.prototype.getCoinRateFee = function (model, item) {
    var plcCoinsBasicInfo = model.get("actual.plcSolution.plcCoins.plcCoinsBasicInformation");
    if (plcCoinsBasicInfo) {
        var totleCoinsAmount = model.get("actual.amount");//共保保额
        var totalCoinsPremium = model.get("actual.premium");//共保保费
        if (!totleCoinsAmount || !totalCoinsPremium) {
            cola.NotifyTipManager.warning({
                message: "",
                description: "请先计算总保额和总保费",
                showDuration: 3000
            });
            return false;
        }
        var netPremium = model.get("actual.netPremium");//不含税保费
        var taxFee = model.get("actual.taxFee");//总税额
        var totleCoinsAmountTemp = 0;//共保保额
        var totalCoinsPremiumTemp = 0;//共保保费
        var netPremiumTemp = 0;//不含税保费
        var taxFeeTemp = 0;//总税额
        var coinNum = 0; //共保比例
        plcCoinsBasicInfo.each(function (entity,idx) {
            var coinsRate = Number(entity.get("coinsRate"));
            if (!coinsRate || coinsRate >= 100 || coinsRate <= 0) {
                entity.set("coinsRate", null);
                entity.set("coinsAmount", null);
                entity.set("coinsPremium", null);
                entity.set("coinsNetPremium", null);
                entity.set("coinsTaxFee", null);
                cola.NotifyTipManager.warning({
                    message: "",
                    description: "请输入有效范围内的共保份额",
                    showDuration: 3000
                });
                return false;
            }else{
                coinNum += coinsRate * 1;
            }
        });
        var rateFlag = false;
        if (coinNum > 100 &&　item) {
            item.set("coinsRate", null);
            item.set("coinsAmount", null);
            item.set("coinsNetPremium", null);
            item.set("coinsTaxFee", null);
            item.set("coinsPremium", null);
            cola.NotifyTipManager.warning({
                message: "",
                description: "共保份额已超过100%",
                showDuration: 3000
            });
            return false;
        }else if(coinNum == 100){
            rateFlag = true; //比例等于100 的时候做去尾操作
        }
        plcCoinsBasicInfo.each(function (entity,idx) {
            var coinsRate = Number(entity.get("coinsRate") / 100);
            if((idx < plcCoinsBasicInfo.entityCount - 1) || !rateFlag){
                var coinsAmount = contractEntity.formatToTwoPrecision(totleCoinsAmount * coinsRate);
                var coinsPremium = contractEntity.formatToTwoPrecision(totalCoinsPremium * coinsRate);
                var coinsNetPremium = contractEntity.formatToTwoPrecision(netPremium * coinsRate);
                var coinsTaxFee = contractEntity.formatToTwoPrecision(taxFee * coinsRate);
                entity.set("coinsAmount", coinsAmount);//保额
                entity.set("coinsPremium", coinsPremium);//保费
                entity.set("coinsNetPremium", coinsNetPremium);//不含税保费
                entity.set("coinsTaxFee", coinsTaxFee);//税额
                entity.set("$coinsBeforePremium",coinsPremium);
                totleCoinsAmountTemp += coinsAmount;//共保保额
                totalCoinsPremiumTemp += coinsPremium;//共保保费
                netPremiumTemp += coinsNetPremium;//不含税保费
                taxFeeTemp += coinsTaxFee;//税额
            }else if(rateFlag){
                entity.set("coinsAmount", contractEntity.formatToTwoPrecision(totleCoinsAmount - totleCoinsAmountTemp));//保额
                entity.set("coinsPremium",  contractEntity.formatToTwoPrecision(totalCoinsPremium - totalCoinsPremiumTemp));//保费
                entity.set("coinsNetPremium",  contractEntity.formatToTwoPrecision(netPremium - netPremiumTemp));//不含税保费
                entity.set("coinsTaxFee",  contractEntity.formatToTwoPrecision(taxFee - taxFeeTemp));//税额
                entity.set("$coinsBeforePremium",coinsPremium);
            }
        });
    }
}
//获取联保保额保费
ContractEntity.prototype.getCoinLinkRateFee = function (model) {
    var totleLinkAmount = model.get("actual.amount"); //总保额
    var totleLinkPremium = model.get("actual.premium"); //总保费
    if (!totleLinkAmount || !totleLinkPremium) {
        cola.NotifyTipManager.warning({
            message: "",
            description: "请先计算总保额和总保费",
            showDuration: 3000
        });
        return false;
    }
    var netPremium = model.get("actual.netPremium");//不含税保费
    var taxFee = model.get("actual.taxFee");//总税额
    var plcLinkBasicInfo = model.get("actual.plcSolution.plcCoins.plcLinkBasicInformat");//联保
    var plcCoinBasicInfo = model.get("actual.plcSolution.plcCoins.plcCoinsBasicInformation");//共保
    var coinLinkNum = 0;
    if (plcLinkBasicInfo && plcLinkBasicInfo.entityCount > 0) {
        plcLinkBasicInfo.each(function (entity) {
            if (plcLinkBasicInfo.current.get("coinsRate") >= 100 || plcLinkBasicInfo.current.get("coinsRate") <= 0) {
                plcLinkBasicInfo.current.set("coinsRate", null);
                plcLinkBasicInfo.current.set("coinsAmount", null);
                plcLinkBasicInfo.current.set("coinsPremium", null);
                plcLinkBasicInfo.current.set("coinsNetPremium", null);//不含税保费
                plcLinkBasicInfo.current.set("coinsTaxFee", null);//税额
                cola.NotifyTipManager.warning({
                    message: "",
                    description: "请输入有效范围内的联保份额",
                    showDuration: 3000
                });
                return false
            }
            coinLinkNum += Number(entity.get("coinsRate"));
        });
        var rateFlag = false;
        if (coinLinkNum > 100) {
            plcLinkBasicInfo.current.set("coinsRate", null);
            plcLinkBasicInfo.current.set("coinsAmount", null);
            plcLinkBasicInfo.current.set("coinsPremium", null);
            plcLinkBasicInfo.current.set("coinsNetPremium", null);//不含税保费
            plcLinkBasicInfo.current.set("coinsTaxFee", null);//税额
            cola.NotifyTipManager.warning({
                message: "",
                description: "联保比例已超过100%",
                showDuration: 3000
            });
            return false;
        }else if(coinLinkNum == 100){
            rateFlag = true;
        }
        var tempTotalAmount = 0;
        var tempTotalPremium = 0;
        var tempTotalNetPremium = 0;
        var tempTotalTaxFee = 0;
        var totleCoinsAmountTemp = 0;//共保保额
        var totalCoinsPremiumTemp = 0;//共保保费
        var netPremiumTemp = 0;//不含税保费
        var taxFeeTemp = 0;//总税额
        if (plcCoinBasicInfo && plcCoinBasicInfo.entityCount > 0) { //有共保
            plcCoinBasicInfo.each(function (enty) {
                if (enty.get("coinsIdentity") == "1") {
                    tempTotalAmount = enty.get("coinsAmount");//共保保额
                    tempTotalPremium = enty.get("coinsPremium");//共保保费
                    tempTotalNetPremium = enty.get("coinsNetPremium");//不含税保费
                    tempTotalTaxFee = enty.get("coinsTaxFee");//税额
                }
            })
        } else { //单联保
            tempTotalAmount = totleLinkAmount;//共保保额
            tempTotalPremium = totleLinkPremium;//共保保费
            tempTotalNetPremium = netPremium;//不含税保费
            tempTotalTaxFee = taxFee;//税额
        }
        plcLinkBasicInfo.each(function (entity,idx) {
            var coinsRate = Number(entity.get("coinsRate")) / 100;
            if((idx < plcLinkBasicInfo.entityCount - 1) || !rateFlag){
                var coinsAmount = contractEntity.formatToTwoPrecision(tempTotalAmount * coinsRate);
                var coinsPremium = contractEntity.formatToTwoPrecision(tempTotalPremium * coinsRate);
                var coinsNetPremium = contractEntity.formatToTwoPrecision(tempTotalNetPremium * coinsRate);
                var coinsTaxFee = contractEntity.formatToTwoPrecision(tempTotalTaxFee * coinsRate);
                entity.set("coinsAmount", coinsAmount);//保额
                entity.set("coinsPremium", coinsPremium);//保费
                entity.set("coinsNetPremium", coinsNetPremium);//不含税保费
                entity.set("coinsTaxFee", coinsTaxFee);//税额
                totleCoinsAmountTemp += coinsAmount;//共保保额
                totalCoinsPremiumTemp += coinsPremium;//共保保费
                netPremiumTemp += coinsNetPremium;//不含税保费
                taxFeeTemp += coinsTaxFee;//税额
            }else if(rateFlag){
                entity.set("coinsAmount", contractEntity.formatToTwoPrecision(tempTotalAmount - totleCoinsAmountTemp));//保额
                entity.set("coinsPremium",  contractEntity.formatToTwoPrecision(tempTotalPremium - totalCoinsPremiumTemp));//保费
                entity.set("coinsNetPremium",  contractEntity.formatToTwoPrecision(tempTotalNetPremium - netPremiumTemp));//不含税保费
                entity.set("coinsTaxFee",  contractEntity.formatToTwoPrecision(tempTotalTaxFee - taxFeeTemp));//税额
            }
        })
    }
}

//计算短期费率系数
function dateDiff(dateStart, dateEnd, MD, effFlag) {
    if( typeof dateStart ==="string"){
        dateStart=new Date(dateStart);
    }
    if( typeof dateEnd ==="string"){
        dateEnd=new Date(dateEnd);
    }
    var i;
    if (MD == "D") //按天计算差
    {
        var endTm = dateEnd.getTime();
        var startTm = dateStart.getTime();
        var diffDay = (endTm - startTm ) / 86400000 ;

        return diffDay;
    } else if (MD == "H") {
        var endTm = dateEnd.getTime();
        var startTm = dateStart.getTime();
        var diffHour = (endTm - startTm) / 3600000 ;
        return diffHour;
    }
    else //按月计算差  M
    {
        var endD = dateEnd.getDate();
        var endM = dateEnd.getMonth();
        var endY = dateEnd.getFullYear();
        var startD = dateStart.getDate();
        var startM = dateStart.getMonth();
        var startY = dateStart.getFullYear();

        if (endD > startD) //跟终端版fcalc_month函数统一，endD>startD时才加1
        {
            return (endY - startY) * 12 + (endM - startM) + 1;
        }
//        else if((endD == startD) && !effFlag)
//        {
//            return (endY - startY) * 12 + (endM - startM) + 1;
//        }
        else {
            return (endY - startY) * 12 + (endM - startM);
        }
    }
}

//按短期费率表方式计算短期系数
function getShortRateTable(strStartDate, strStartHour, strEndDate, strEndHour, strRiskCode ,effFlag) {
  
    var arrayTableShortRate;
    var intDays = dateDiff(strStartDate, strEndDate, "D");
    var intMonthCount = dateDiff(strStartDate, strEndDate, "M" , effFlag);
    var dbTableShortRate = 0;
    // strStartDate = strStartDate.getDate();
    // strEndDate = strEndDate.getDate();
    // if (strStartDate == strEndDate && parseInt(strStartHour, 10) < parseInt(strEndHour, 10))
    //     intMonthCount = intMonthCount + 1;
    if (strRiskCode == '27') {
        arrayTableShortRate = new Array(0, 25, 35, 45, 55, 65, 70, 75, 80, 85, 90, 95, 100);//产品代码已27开头
    }
    else if (strRiskCode == '0204' || strRiskCode == '0305') {
        arrayTableShortRate = new Array(0, 30, 30, 30, 40, 50, 60, 70, 80, 85, 90, 95, 100);//产品代码02040001,02040002,0305
    }
    else {
        arrayTableShortRate = new Array(0, 10, 20, 30, 40, 50, 60, 70, 80, 85, 90, 95, 100);//产品代码已其他开头用次费率表
    }
    dbTableShortRate = Math.floor(intMonthCount / 12) * 100 + arrayTableShortRate[intMonthCount % 12];
    return dbTableShortRate;
}

//计算短期费率系数
ContractEntity.prototype.changeDateClacShortRate = function (model, curEntity, wayCode, sTime, eTime) {
    //wayCode-->短期费率方式Code  rate--->年费率
    // var startTimes=model.get("actual.startTime");
    // var endTimes=model.get("actual.endTime");
    // var strStartHour=model.get("actual.endTime").getHours();
    // var strEndHour=model.get("actual.endTime").getHours();
    var startTimes, endTimes;
    if (curEntity) {
        startTimes = curEntity.get("startTime");
        endTimes = curEntity.get("endTime");
    } else {
        startTimes = sTime;
        endTimes = eTime;
    }
    var strStartHour = startTimes.getHours();
    var strEndHour = endTimes.getHours();
    var effFlag = model.get("actual.effectiveImmediatelyFlag");//是否即使起保
    var shortRateCoeff;//短期费率系数
    var flag = true;//是否即使起保
    if (!effFlag || effFlag == '0') {//未选中即使起保时
        flag = false;
    }
    if (wayCode == '3') {//不计
        shortRateCoeff = 100;
    }
    else if (wayCode == '2') {
        //按日计算  （终保日期-起保日期）/365(355)
        // 一天毫秒数86400000
        var D = 'D';
        var newDate = new Date();
        var startfullYearY = startTimes.getFullYear() + 1;
        var startfullYearM = startTimes.getMonth() + 1;
        var startfullYearD = startTimes.getDate();
        var startfullYearH = startTimes.getHours();
        var startfullYearMi = startTimes.getMinutes();
        var startfullYearS = startTimes.getSeconds();
        var startFullYear;
        var startEndDays;
        if (!effFlag || effFlag == '0') {//非即使起保时
//            var newS = new Date(startTimes.toLocaleDateString().toString() + " 00:00:00");
//            var newE = new Date(endTimes.toLocaleDateString().toString() + " 23:59:59");
            startEndDays = Math.floor(dateDiff(startTimes, endTimes, D));//开始日期与结束日期的天数差
            //旧规则开始日期加一年减一天
            //新规则开始日期加一年
            startFullYear=new Date(startTimes);
            startFullYear.setFullYear(startTimes.getFullYear()+1);
//            startFullYear.setDate(startTimes.getDate()-1);
//            startFullYear.setHours(23);startFullYear.setMinutes(59);startFullYear.setSeconds(59);
            flag = false;
        } else {
            //暂定乡下取整
            startEndDays = Math.floor(dateDiff(startTimes, endTimes, D));//开始日期与结束日期的天数差
            // startFullYear = new Date(newDate.setFullYear(startfullYearY + 1, startfullYearM, startfullYearD - 1));
            startFullYear = new Date(startfullYearY+"-"+startfullYearM+"-"+startfullYearD+" "+startfullYearH+":"+startfullYearMi+":"+startfullYearS);
        }
        // 判断一年是365还是366天
        var allYearDays = Math.floor(dateDiff(startTimes, startFullYear, D));
        shortRateCoeff = startEndDays / allYearDays * 100;
    }
    else if (wayCode == '4') {//按月平均
        var startEndMonth;
        startEndMonth  = dateDiff(startTimes, endTimes, 'M',flag);//按月计算差
        shortRateCoeff = startEndMonth / 12 * 100;
    }
    else if (wayCode == '1') {//按短期费率系数表计算短期费率系数
        var strRiskCode = model.get("actual.productCode").substring(0, 2);
        if (strRiskCode != "27") {
            strRiskCode = model.get("actual.productCode").substring(0, 4);
        }
        shortRateCoeff = getShortRateTable(startTimes, strStartHour, endTimes, strEndHour, strRiskCode ,flag);
    }
    else if (wayCode == '5'){//按约定收取
        //按约定收取，根据录入的保额保费反算费率，那短期系数是置为灰色不可修改吗？
        // ---非工程险，填写保额保费费率，反算短期费率系数  // ---工程险，填写保额保费，反算费率，无短期费率系数
        // 一期上线都是非工程险
        var oriCurAmount = curEntity.get("oriCurAmount");
        var rate = curEntity.get("rate");
        var oriCurPremium = curEntity.get("oriCurPremium");
        if(oriCurAmount!=null && oriCurAmount!=undefined && oriCurAmount!=="" && rate && oriCurPremium){
            shortRateCoeff = oriCurPremium / (rate/1000) / oriCurAmount *100;
        }else{
            App.alert("请先填写保额，费率，保费！");
            return false;
        }
    }
    if (shortRateCoeff) {
        shortRateCoeff = Math.round(shortRateCoeff*1000000)/1000000;
    }
    return shortRateCoeff;
}

// 按趸交系数费率表方式计算趸交系数
ContractEntity.prototype.getSingleFactorTable=function (model,entity) {
    var arrayTableSingleFactor;
    var dbTableShortRateFlag=false;
    var deductCode=entity.get("coverageCode");
    var startTime=entity.get("startTime");
    var endTime=entity.get("endTime");
    var effFlag = model.get("actual.effectiveImmediatelyFlag");//是否即使起保
    var flag = true;//是否即使起保
    if(!deductCode){
        return "0";
    }
    if (!effFlag || effFlag == '0') {//未选中即使起保时
        flag = false;
    }
    if(deductCode=="2050"){//还贷保证
        arrayTableSingleFactor = new Array(
            0, 1.00, 1.49, 1.97,
            2.44, 2.90, 3.36, 3.81,
            4.25, 4.69, 5.12, 5.54,
            5.95, 6.36, 6.76, 7.16,
            7.55, 7.93, 8.31, 8.68,
            9.04, 9.40, 9.76, 10.10,
            10.45, 10.78, 11.12, 11.44,
            11.77, 12.08, 12.40
        );
        dbTableShortRateFlag=true;
    }else if(deductCode=="2048"){//财产损失
        //财产损失险趸交保费系数表
        arrayTableSingleFactor =new Array(
            0, 1.00, 1.98, 2.93,
            3.86, 4.76, 5.65, 6.51,
            7.35, 8.17, 8.97, 9.75,
            10.51, 11.26, 11.98, 12.69,
            13.38, 14.06, 14.71, 15.35,
            15.98, 16.59, 17.18, 17.77,
            18.33, 18.88, 19.42, 19.95,
            20.46, 20.96, 21.45
        );
        dbTableShortRateFlag=true;
    }else{

    }
    var intMonthCount = dateDiff(startTime, endTime, "M" , flag);

    var dbTableShortRate = 0;
    // 趸交保费系数=“n”年趸交保费系数+[（“n+1”）年趸交保费系数-“n”年趸交保费系数]*m/12
    var intYear = Math.floor(intMonthCount / 12);
    var restMonth = Math.floor(intMonthCount % 12);
    if(dbTableShortRateFlag){
    	if(intYear >= 30){ //大于30年按30年计算
            dbTableShortRate = arrayTableSingleFactor[30];
        }else{
            dbTableShortRate = arrayTableSingleFactor[intYear] + (arrayTableSingleFactor[intYear+1] - arrayTableSingleFactor[intYear])*(restMonth/12);
        }
        dbTableShortRate = Math.round(dbTableShortRate*1000000)/1000000;
    }
    return dbTableShortRate;
}

//计算条责标上保费，汇总条款
ContractEntity.prototype.premiumCalculation = function (model, entity ,property,operation) { //property当前修改的元素名称
    var params = cola.util.queryParams();
    if(params.endorseType){
      var endorseTime = new Date(model.get("actual.endorseTime")); //批改生效日
    }
    var relaMap=this.isCumulativeOriCurAmount;
    var shortRateWay=entity.get("shortRateWay");
    var parentClause=entity.parent.parent;//该条责标对应的条款
    var isNotGather=parentClause.get("$isNotGather");
    var proCode=model.get("actual.productCode");
    var oriCurAmount = entity.get("oriCurAmount") ? contractEntity.formatToTwoPrecision(entity.get("oriCurAmount")) : entity.get("oriCurAmount");//保额
    if(oriCurAmount){
        entity.set("oriCurAmount",oriCurAmount);
    }
    var rate = entity.get("rate") ? Math.round(entity.get("rate")*1000)/1000 : entity.get("rate");//费率
    if(rate){
        entity.set("rate",rate);
    }
    var oriCurPremium = entity.get("oriCurPremium") ? contractEntity.formatToTwoPrecision(entity.get("oriCurPremium")) : entity.get("oriCurPremium");//保费
    if(oriCurPremium){
        entity.set("oriCurPremium",oriCurPremium);
    }

    //农险保费计算参数
    var itemNumber = entity.get("itemNumber") ? contractEntity.formatToTwoPrecision(entity.get("itemNumber")) : entity.get("itemNumber");//承保数量
    if(itemNumber){
        entity.set("itemNumber",itemNumber);
    }
    var unitPremium = entity.get("unitPremium") ? contractEntity.formatToTwoPrecision(entity.get("unitPremium")) : entity.get("unitPremium");//单位保费
    if(unitPremium){
        entity.set("unitPremium",unitPremium);
    }

    var shortRateCoefficient = entity.get("shortRateCoefficient") ? Math.round(entity.get("shortRateCoefficient")*1000000)/1000000 : entity.get("shortRateCoefficient");//短期费率系数
    var taxRate = entity.get("taxRate");//税率
    var discountRate = entity.get("discountRate");//保费优惠比例
    var singleFactor = entity.get("singleFactor") ? Math.round(entity.get("singleFactor")*1000000)/1000000 : entity.get("singleFactor");//趸交系数
    var clauseCode=parentClause.get("clauseCode");
    var clauseType=parentClause.get("clauseType");
    if(proCode=="02030002"){
        if(discountRate < 70 || discountRate > 100){
            App.alert("保费优惠比例70%~100%之间");
            return false;
        }
        if(!singleFactor && clauseCode == "9902684" && !operation){//如果条款选择了"个人贷款抵押房屋综合保险"，计算趸交系数
            App.alert("请先选择责任！");
            entity.set(property,0);
            return false;
        }
    }
    var oriCurTaxFee = 0;//税额
    var oriCurNetPremium = 0;//不含税保费,保费/(1+税率)
    var allOriCurAmount = 0;//总保额
    var allOriCurPremium = 0;//总保费
    var allOriCurTaxFee = 0;//总税额
    var allOriCurNetPremium = 0;//总保额
    var allRate = 0;

    if(shortRateWay=="5"){//按约定收取的套路
        if(oriCurPremium!=="" && oriCurPremium!=null && oriCurPremium!=undefined && rate && oriCurAmount){
            shortRateCoefficient = oriCurPremium / (rate/1000) / oriCurAmount ;
            if(proCode=="02030002"){
                shortRateCoefficient = shortRateCoefficient / (discountRate / 100);
            }
            if(clauseCode == "9902684"  || clauseCode == "0400700" || clauseCode == "0400600" || clauseCode == "9001821" || clauseCode == "9001835"){//个人贷款抵押房屋综合保险
                shortRateCoefficient = shortRateCoefficient / singleFactor;
            }
            oriCurNetPremium = contractEntity.formatToTwoPrecision(oriCurPremium / (1 + taxRate / 100));
            oriCurTaxFee = contractEntity.formatToTwoPrecision(oriCurPremium - oriCurNetPremium);
            shortRateCoefficient = Math.round(shortRateCoefficient*1000000) / 1000000 * 100;
            entity.set("oriCurTaxFee", contractEntity.formatToTwoPrecision(oriCurTaxFee));//税额
            entity.set("oriCurNetPremium", contractEntity.formatToTwoPrecision(oriCurNetPremium));//不含税保费
            entity.set("shortRateCoefficient", shortRateCoefficient);//短期费率系数
            
            entity.set({
              oriCurTaxFee:contractEntity.formatToTwoPrecision(oriCurTaxFee),
              oriCurNetPremium:contractEntity.formatToTwoPrecision(oriCurNetPremium),
              shortRateCoefficient: shortRateCoefficient
            });
        }
    }else{
        //oriCurAmount  rate  oriCurPremium  三者反算
        //1.当前修改的是保额，拿费率算保费
        //2.当前修改的是费率，拿保额算保费
        //3.当前修改的是保费，拿保额算费率
        if (property == "oriCurPremium" && oriCurAmount && oriCurPremium!=undefined && oriCurPremium!=null && oriCurPremium!=="") {
            //保额不能为0
        	if ( shortRateCoefficient && proCode!="02030001" && proCode!="02030002"
        		&& (clauseType!="main" || params.endorseType) ) {//02030002的产品: 保费计算不乘以短期费率系数(综批除外)
                rate = oriCurPremium / oriCurAmount / (shortRateCoefficient / 100);
            } else {
                rate = oriCurPremium / oriCurAmount;
            }
        	if(proCode=="02030002" || proCode=="02030001"){
                rate = rate / (discountRate / 100);
            }
            if(clauseCode == "9902684" || clauseCode == "0400700" || clauseCode == "0400600" || clauseCode == "9001821" || clauseCode == "9001835"){//个人贷款抵押房屋综合保险
                rate = rate / singleFactor;
            }
            rate = rate * 1000;
            oriCurNetPremium = contractEntity.formatToTwoPrecision(oriCurPremium / (1 + taxRate / 100));
            oriCurTaxFee = contractEntity.formatToTwoPrecision(oriCurPremium - oriCurNetPremium);
//            entity.set("rate",Math.round(rate*1000000)/1000000);//费率
//            entity.set("oriCurTaxFee", contractEntity.formatToTwoPrecision(oriCurTaxFee));//税额
//            entity.set("oriCurNetPremium", contractEntity.formatToTwoPrecision(oriCurNetPremium));//不含税保费
            
            entity.set({
              rate:Math.round(rate*1000000)/1000000,
              oriCurTaxFee:contractEntity.formatToTwoPrecision(oriCurTaxFee),
              oriCurNetPremium: contractEntity.formatToTwoPrecision(oriCurNetPremium)
            });


        }
        else if(oriCurAmount && rate){
            if ( (shortRateCoefficient || shortRateCoefficient==0) && (proCode!="02030002" || clauseType!="main" || params.endorseType) ) {//02030002的产品: 保费计算不乘以短期费率系数(综批除外)
                oriCurPremium = oriCurAmount * (rate / 1000) * (shortRateCoefficient / 100);
            } else {
                oriCurPremium = oriCurAmount * (rate / 1000);
            }
            if(proCode=="02030002"){
                oriCurPremium = oriCurPremium * (discountRate / 100);
            }
            if(clauseCode == "9902684" || clauseCode == "0400700" || clauseCode == "0400600" || clauseCode == "9001821" || clauseCode == "9001835"){//个人贷款抵押房屋综合保险   
                oriCurPremium = oriCurAmount * (rate / 1000) * singleFactor;
            }
            oriCurNetPremium = contractEntity.formatToTwoPrecision(oriCurPremium / (1 + taxRate / 100));
            oriCurTaxFee = contractEntity.formatToTwoPrecision(oriCurPremium - oriCurNetPremium);
//            entity.set("oriCurPremium", contractEntity.formatToTwoPrecision(oriCurPremium));//保费
//            entity.set("oriCurTaxFee", contractEntity.formatToTwoPrecision(oriCurTaxFee));//税额
//            entity.set("oriCurNetPremium", contractEntity.formatToTwoPrecision(oriCurNetPremium));//不含税保费
            entity.set({
              oriCurPremium:contractEntity.formatToTwoPrecision(oriCurPremium),
              oriCurTaxFee:contractEntity.formatToTwoPrecision(oriCurTaxFee),
              oriCurNetPremium:contractEntity.formatToTwoPrecision(oriCurNetPremium)
            });
        }else if(itemNumber || unitPremium){
            oriCurPremium = itemNumber * unitPremium;
            entity.set({
                oriCurPremium:contractEntity.formatToTwoPrecision(oriCurPremium),
                oriCurAmount:contractEntity.formatToTwoPrecision(oriCurAmount)
            });

        }else {
//            entity.set("oriCurPremium", 0);//保费
//            entity.set("oriCurTaxFee", 0);//税额
//            entity.set("oriCurNetPremium", 0);//不含税保费
            entity.set({
              oriCurPremium:0,
              oriCurTaxFee:0,
              oriCurNetPremium:0
            });
        }
    }
//    entity.set("unitAmount", contractEntity.formatToTwoPrecision(oriCurAmount));//单位保险金额
//    entity.set("everyoneAmount", contractEntity.formatToTwoPrecision(oriCurAmount));//每人保险金额
//    entity.set("unitPremium", contractEntity.formatToTwoPrecision(oriCurPremium));//每人保费
    if(proCode != "31110001"){
        entity.set({
            unitAmount:contractEntity.formatToTwoPrecision(oriCurAmount),
            everyoneAmount:contractEntity.formatToTwoPrecision(oriCurAmount),
            unitPremium:contractEntity.formatToTwoPrecision(oriCurPremium)
        });
    }
    if(!isNotGather){//如果这个标志不存在，就汇总条款上的保额费率    
        entity.parent.each(function (clauseItem) {
            // 批改下，被删除的条标不参与计算
            if(params.endorseType && clauseItem.get("statusFlag")==="3"){
                return ;
            }
          if(params.endorseType && new Date(clauseItem.get("endTime")) < endorseTime ){
              return ;
            }
            var calcuOriStr = clauseCode + "-" + clauseItem.get("coverageCode");
            if (clauseItem.get("oriCurPremium")) {
                allOriCurPremium = contractEntity.formatToTwoPrecision(allOriCurPremium + contractEntity.formatToTwoPrecision(clauseItem.get("oriCurPremium")));
            }
            if (clauseItem.get("oriCurTaxFee")) {
                allOriCurTaxFee = contractEntity.formatToTwoPrecision(allOriCurTaxFee + contractEntity.formatToTwoPrecision(clauseItem.get("oriCurTaxFee")));
            }
            if (clauseItem.get("oriCurNetPremium")) {
                allOriCurNetPremium = contractEntity.formatToTwoPrecision(allOriCurNetPremium + contractEntity.formatToTwoPrecision(clauseItem.get("oriCurNetPremium")));
            }
            if(!relaMap[calcuOriStr]){//不累计
                if (clauseItem.get("oriCurAmount")) {
                    allOriCurAmount = contractEntity.formatToTwoPrecision(allOriCurAmount + contractEntity.formatToTwoPrecision(clauseItem.get("oriCurAmount")));
                }
            }
        });      
        if (allOriCurAmount != 0 && allOriCurPremium != 0) {
            allRate = allOriCurPremium / allOriCurAmount * 1000;
        }      
//        parentClause.set("$oriCurAmount", allOriCurAmount);//总保额
//        parentClause.set("$oriCurPremium", allOriCurPremium);//总保费
//        parentClause.set("$rate", Math.round(allRate*1000000)/1000000);//总费率
//        parentClause.set("$oriCurTaxFee", allOriCurTaxFee);//总税额
//        parentClause.set("$oriCurNetPremium", allOriCurNetPremium);//不含税总保费   
        parentClause.set({
          $oriCurAmount:allOriCurAmount,
          $oriCurPremium:allOriCurPremium,
          $rate:Math.round(allRate*1000000)/1000000,
          $oriCurTaxFee:allOriCurTaxFee,
          $oriCurNetPremium:allOriCurNetPremium
        });
    }
}
//团单条责标层级保费计算
ContractEntity.prototype.GrouppremiumCalculation = function (model, entity ,property,operation) {   //property当前修改的元素名称
    var params = cola.util.queryParams();
    if(params.endorseType){
        var endorseTime = new Date(model.get("actual.endorseTime")); //批改生效日
    }
    var relaMap=this.isCumulativeOriCurAmount;
    var shortRateWay=entity.get("shortRateWay");
    var isNotGather=entity.parent.parent.get("$isNotGather");
    var proCode=model.get("actual.productCode");
    var oriCurAmount = entity.get("unitAmount") ? contractEntity.formatToTwoPrecision(entity.get("unitAmount")) : entity.get("unitAmount");//保额
    if(oriCurAmount){
        entity.set("unitAmount",oriCurAmount);
    }
    var rate = entity.get("rate") ? Math.round(entity.get("rate")*1000)/1000 : entity.get("rate");//费率
    if(rate){
        entity.set("rate",rate);
    }
    var oriCurPremium = entity.get("unitPremium") ? contractEntity.formatToTwoPrecision(entity.get("unitPremium")) : entity.get("unitPremium");//保费
    if(oriCurPremium){
        entity.set("unitPremium",oriCurPremium);
    }
    if(oriCurAmount=="0" && rate=="0"){
        entity.set("unitPremium","0");
        return false;
    }
    var shortRateCoefficient = entity.get("shortRateCoefficient") ? Math.round(entity.get("shortRateCoefficient")*1000000)/1000000 : entity.get("shortRateCoefficient");//短期费率系数
    var taxRate = entity.get("taxRate");//税率
    var discountRate = entity.get("discountRate");//保费优惠比例
    var singleFactor = entity.get("singleFactor") ? Math.round(entity.get("singleFactor")*1000000)/1000000 : entity.get("singleFactor");//趸交系数
    var clauseCode=entity.parent.parent.get("clauseCode");
    var clauseType=entity.parent.parent.get("clauseType");
    if(proCode=="02030002"){
        if(discountRate < 70 || discountRate > 100){
            App.alert("保费优惠比例70%~100%之间");
            return false;
        }
        if(!singleFactor && clauseCode == "9902684" && !operation){//如果条款选择了"个人贷款抵押房屋综合保险"，计算趸交系数
            App.alert("请先选择责任！");
            entity.set(property,0);
            return false;
        }
    }
    var oriCurTaxFee = 0;//税额
    var oriCurNetPremium = 0;//不含税保费,保费/(1+税率)
    var allOriCurAmount = 0;//总保额
    var allOriCurPremium = 0;//总保费
    var allOriCurTaxFee = 0;//总税额
    var allOriCurNetPremium = 0;//总保额
    var allRate = 0;

    if(shortRateWay=="5"){//按约定收取的套路
        if(oriCurPremium!=="" && oriCurPremium!=null && oriCurPremium!=undefined && rate && oriCurAmount){
            shortRateCoefficient = oriCurPremium / (rate/1000) / oriCurAmount ;
            if(proCode=="02030002"){
                shortRateCoefficient = shortRateCoefficient / (discountRate / 100);
            }
            if(clauseCode == "9902684"  || clauseCode == "0400700" || clauseCode == "0400600" || clauseCode == "9001821" || clauseCode == "9001835"){//个人贷款抵押房屋综合保险
                shortRateCoefficient = shortRateCoefficient / singleFactor;
            }
            oriCurNetPremium = contractEntity.formatToTwoPrecision(oriCurPremium / (1 + taxRate / 100));
            oriCurTaxFee = contractEntity.formatToTwoPrecision(oriCurPremium - oriCurNetPremium);
            shortRateCoefficient = Math.round(shortRateCoefficient*1000000) / 1000000 * 100;
//          entity.set("oriCurTaxFee", contractEntity.formatToTwoPrecision(oriCurTaxFee));//税额
//          entity.set("oriCurNetPremium", contractEntity.formatToTwoPrecision(oriCurNetPremium));//不含税保费
            entity.set("shortRateCoefficient", shortRateCoefficient);//短期费率系数
        }
    }else{
        //oriCurAmount  rate  oriCurPremium  三者反算
        //1.当前修改的是保额，拿费率算保费
        //2.当前修改的是费率，拿保额算保费
        //3.当前修改的是保费，拿保额算费率
        if (property == "unitPremium" && oriCurAmount && oriCurPremium!=undefined && oriCurPremium!=null && oriCurPremium!=="") {
            //保额不能为0
            if ( shortRateCoefficient && proCode!="02030001" && proCode!="02030002"
            		&& (clauseType!="main" || params.endorseType) ) {//02030002的产品: 保费计算不乘以短期费率系数(综批除外)
                rate = oriCurPremium / oriCurAmount / (shortRateCoefficient / 100);
            } else {
                rate = oriCurPremium / oriCurAmount;
            }
            if(proCode=="02030002" || proCode=="02030001"){
                rate = rate / (discountRate / 100);
            }
            if(clauseCode == "9902684" || clauseCode == "0400700" || clauseCode == "0400600" || clauseCode == "9001821" || clauseCode == "9001835"){//个人贷款抵押房屋综合保险
                rate = rate / singleFactor;
            }
            rate = rate * 1000;
            oriCurNetPremium = contractEntity.formatToTwoPrecision(oriCurPremium / (1 + taxRate / 100));
            oriCurTaxFee = contractEntity.formatToTwoPrecision(oriCurPremium - oriCurNetPremium);


            entity.set("rate",Math.round(rate*1000)/1000);//费率
//          entity.set("oriCurTaxFee", contractEntity.formatToTwoPrecision(oriCurTaxFee));//税额
//          entity.set("oriCurNetPremium", contractEntity.formatToTwoPrecision(oriCurNetPremium));//不含税保费

        }
        else if(oriCurAmount && rate){
            if ( (shortRateCoefficient || shortRateCoefficient==0) && (proCode!="02030002" || clauseType!="main" || params.endorseType) ) {//02030002的产品: 保费计算不乘以短期费率系数(综批除外)
                oriCurPremium = oriCurAmount * (rate / 1000) * (shortRateCoefficient / 100);
            } else {
                oriCurPremium = oriCurAmount * (rate / 1000);
            }
            if(proCode=="02030002"){
                oriCurPremium = oriCurPremium * (discountRate / 100);
            }
            if(clauseCode == "9902684" || clauseCode == "0400700" || clauseCode == "0400600" || clauseCode == "9001821" || clauseCode == "9001835"){//个人贷款抵押房屋综合保险
                oriCurPremium = oriCurPremium * singleFactor;
            }
            oriCurNetPremium = contractEntity.formatToTwoPrecision(oriCurPremium / (1 + taxRate / 100));
            oriCurTaxFee = contractEntity.formatToTwoPrecision(oriCurPremium - oriCurNetPremium);
            entity.set("unitPremium", contractEntity.formatToTwoPrecision(oriCurPremium));//保费
//          entity.set("oriCurTaxFee", contractEntity.formatToTwoPrecision(oriCurTaxFee));//税额
//          entity.set("oriCurNetPremium", contractEntity.formatToTwoPrecision(oriCurNetPremium));//不含税保费
            entity.set({
                //oriCurPremium:contractEntity.formatToTwoPrecision(oriCurPremium),
                unitPremium:contractEntity.formatToTwoPrecision(oriCurPremium),
                oriCurTaxFee:contractEntity.formatToTwoPrecision(oriCurTaxFee),
                oriCurNetPremium:contractEntity.formatToTwoPrecision(oriCurNetPremium)
            });
        }else{
            entity.set({
                //oriCurPremium:0,
                unitPremium:0,//保费
                oriCurTaxFee:0,//税额
                oriCurNetPremium:0//不含税保费
            });
        }
    }
    entity.set({
        unitAmount:contractEntity.formatToTwoPrecision(oriCurAmount),
        everyoneAmount:contractEntity.formatToTwoPrecision(oriCurAmount),
        unitPremium:contractEntity.formatToTwoPrecision(oriCurPremium)
    });
    if(!isNotGather){//如果这个标志不存在，就汇总条款上的保额费率
        entity.parent.each(function (clauseItem) {
            if(params.endorseType && new Date(clauseItem.get("endTime")) < endorseTime ){
                return ;
            }
            var calcuOriStr = clauseCode + "-" + clauseItem.get("coverageCode");
            if (clauseItem.get("unitPremium")) {
                allOriCurPremium = contractEntity.formatToTwoPrecision(allOriCurPremium + contractEntity.formatToTwoPrecision(clauseItem.get("unitPremium")));
            }
            if (clauseItem.get("oriCurTaxFee")) {
                allOriCurTaxFee = contractEntity.formatToTwoPrecision(allOriCurTaxFee + contractEntity.formatToTwoPrecision(clauseItem.get("oriCurTaxFee")));
            }
            if (clauseItem.get("oriCurNetPremium")) {
                allOriCurNetPremium = contractEntity.formatToTwoPrecision(allOriCurNetPremium + contractEntity.formatToTwoPrecision(clauseItem.get("oriCurNetPremium")));
            }
            if(!relaMap[calcuOriStr]){//不累计
                if (clauseItem.get("unitAmount")) {
                    allOriCurAmount = contractEntity.formatToTwoPrecision(allOriCurAmount + contractEntity.formatToTwoPrecision(clauseItem.get("unitAmount")));
                }
            }
        });
        if (allOriCurAmount != 0 && allOriCurPremium != 0) {
            allRate = allOriCurPremium / allOriCurAmount * 1000;
        }
        entity.parent.parent.set("$oriCurAmount", allOriCurAmount);//总保额
        entity.parent.parent.set("$oriCurPremium", allOriCurPremium);//总保费
        entity.parent.parent.set("$rate", Math.round(allRate*1000)/1000);//总费率
        entity.parent.parent.set("$oriCurTaxFee", allOriCurTaxFee);//总税额
        entity.parent.parent.set("$oriCurNetPremium", allOriCurNetPremium);//不含税总保费
    }
}

//条款上保额，保费，费率三者互算
ContractEntity.prototype.clauseCalculation = function (model, entity ,property) {

    var oriCurAmount, rate ,oriCurPremium , oriCurNetPremium=0 ,oriCurTaxFee=0 ,taxRate;
    taxRate = Number(entity.get("$taxRate"));//税率
    oriCurAmount = Number(entity.get("$oriCurAmount"));
    oriCurAmount = oriCurAmount ? contractEntity.formatToTwoPrecision(oriCurAmount) : oriCurAmount;
    if(oriCurAmount){
      entity.set("$oriCurAmount",oriCurAmount);
    }
    rate = Number(entity.get("$rate"));
    rate = rate ? Math.round(rate*1000)/1000 : rate;
    if(rate){
      entity.set("$rate",rate);
    }
    oriCurPremium = Number(entity.get("$oriCurPremium"));
    oriCurPremium = oriCurPremium ? contractEntity.formatToTwoPrecision(oriCurPremium) : oriCurPremium;
    if(oriCurPremium){
      entity.set("$oriCurPremium",oriCurPremium);
    }
    if(oriCurPremium == 0 && rate == 0 && oriCurAmount == 0){
        entity.set("$isNotGather",false);
    }
    if(property == "$oriCurPremium" && oriCurAmount && oriCurPremium!=undefined && oriCurPremium!=null && oriCurPremium!==""){//修改保费时，反算费率
        rate = oriCurPremium / oriCurAmount * 1000;
        oriCurNetPremium = contractEntity.formatToTwoPrecision(oriCurPremium / (1 + taxRate / 100));
        oriCurTaxFee = contractEntity.formatToTwoPrecision(oriCurPremium - oriCurNetPremium);
        entity.set("$rate", Math.round(rate*1000)/1000);//费率
        entity.set("$oriCurTaxFee", contractEntity.formatToTwoPrecision(oriCurTaxFee));//税额
        entity.set("$oriCurNetPremium", contractEntity.formatToTwoPrecision(oriCurNetPremium));//不含税保费
    }
    else if(oriCurAmount && rate){
        oriCurPremium = contractEntity.formatToTwoPrecision(oriCurAmount * (rate / 1000));
        oriCurNetPremium = contractEntity.formatToTwoPrecision(oriCurPremium / (1 + taxRate / 100));
        oriCurTaxFee = contractEntity.formatToTwoPrecision(oriCurPremium- oriCurNetPremium);
        entity.set("$oriCurPremium", contractEntity.formatToTwoPrecision(oriCurPremium));//保费
        entity.set("$oriCurTaxFee", contractEntity.formatToTwoPrecision(oriCurTaxFee));//税额
        entity.set("$oriCurNetPremium", contractEntity.formatToTwoPrecision(oriCurNetPremium));//不含税保费
    }
    else{
        entity.set("$oriCurPremium", 0);//保费
        entity.set("$oriCurTaxFee", 0);//税额
        entity.set("$oriCurNetPremium", 0);//不含税保费
    }
}
ContractEntity.prototype.startEndPlus = function (model, curEntity, sTime, eTime) {//计算起止保日期差范围
    var startTime, endTime;
    if (curEntity) {
        startTime = curEntity.get("startTime");
        endTime = curEntity.get("endTime");
    } else {
        startTime = sTime;
        endTime = eTime;
    }
//    var effFlag = model.get("actual.effectiveImmediatelyFlag");//是否即使起保

//    if (!effFlag || effFlag == '0') {//未选中即使起保时
//        startTime = new Date(startTime.toLocaleDateString().toString() + " 00:00:00");
//        endTime = new Date(endTime.toLocaleDateString().toString() + " 23:59:59");
//    }
    var endTm = endTime.getTime();
    var startTm = startTime.getTime();
    var diffDay = Math.floor((endTm - startTm) / 86400000);//即使起保天数差
    if (diffDay > 0 && diffDay <= 7) {
        return "7";
    } else if (diffDay >= 8 && diffDay <= 15) {
        return "15";
    } else {
        return "";
    }
}
//获取兑换率计算币别信息汇总
ContractEntity.prototype.getExchangeRateTotal = function (model) {
    var sigRateFee=6;//模拟一个税率
    var soulationList=model.get("actual.plcSolution");
    var plcFeeList = model.get("solution.plcFee");//获取币别信息role
    var signCurrencyCode = model.get("actual.signCurrencyCode");//签单币
    var staCurCode = model.get("actual.staCurCode");//本位币
    var rateFlag = '1';//签单币与原币兑换率确认方式
    var exchangeobj = {};
    var exchangeList = [];
    var staexchObj = {};
    var exchangeDateObj={};//原币与签单币
    exchangeList.push({exchCurrency: signCurrencyCode, baseCurrency: staCurCode});
    soulationList.each(function(entity){
        var exchObj = {};
        var plcFeeList = entity.get("plcFee");
        if(plcFeeList){
            plcFeeList.each(function (enty) {
                exchObj = {};
                // 原币与签单币被兑换
                exchObj.exchCurrency = enty.get("oriCurCode");//原币
                exchObj.baseCurrency = signCurrencyCode;//签单币
                exchangeList.push(exchObj);
            });
        }
        entity.get("plcPackage").each(function(packageList){//承包方案
            if(packageList.get("plcMainClause")){//主条款
                packageList.get("plcMainClause").each(function(MainClauseList){
                    if(MainClauseList.get("plcClauseItem")){//主条款条责标
                        MainClauseList.get("plcClauseItem").each(function(mainClauseItemList){
                            exchObj = {};
                            staexchObj={};
                            exchObj.exchCurrency = mainClauseItemList.get("oriCurCode");//原币
                            exchObj.baseCurrency = signCurrencyCode;//签单币
                            exchangeList.push(exchObj);
                            staexchObj.exchCurrency = mainClauseItemList.get("oriCurCode");//原币
                            staexchObj.baseCurrency = staCurCode;//本位
                            exchangeList.push(staexchObj);
                        })
                    }
                   if(MainClauseList.get("plcAccessoryClause")){//附加条款
                       MainClauseList.get("plcAccessoryClause").each(function(AccessoryClauseList){
                           if(AccessoryClauseList.get("plcClauseItem")){//附加条款条责标
                               AccessoryClauseList.get("plcClauseItem").each(function(AccClauseItemList){
                                   exchObj = {};
                                   staexchObj={};
                                   exchObj.exchCurrency = AccClauseItemList.get("oriCurCode");//原币
                                   exchObj.baseCurrency = signCurrencyCode;//签单币
                                   exchangeList.push(exchObj);
                                   staexchObj.exchCurrency = AccClauseItemList.get("oriCurCode");//原币
                                   staexchObj.baseCurrency = staCurCode;//本位
                                   exchangeList.push(staexchObj);
                               })
                           }
                       })
                   }
                })
            }
        })
        //设置币别信息本位币保额保费
        exchangeobj.rateFlag = rateFlag;
        exchangeobj.exchangeList = exchangeList;
        // var exchangeDateArr=[];
        
        $.ajax({
            url: "controller/exchange/findExchange",
            type: "POST",
            async: false,
            contentType: "application/json",
            data: JSON.stringify(exchangeobj),
            success: function (data) {
                for(var i = 0;i<data.length;i++){
                    exchangeDateObj[data[i].exchCurrency+data[i].baseCurrency]=data[i].exchRate;
                }
                var exchRate = data[0].exchRate;
                if (signCurrencyCode == staCurCode) {
                    model.set("actual.sigAndStaExchangeRate", 1);
                } else {
                    model.set("actual.sigAndStaExchangeRate", exchRate);
                }
                //签单币与本位币兑换率
                var exchange = model.get("actual.sigAndStaExchangeRate");
                if(plcFeeList){
                    plcFeeList.each(function (enty, index) {
                        if (enty.get("oriCurCode") == signCurrencyCode) {
                            enty.set("oriAndSigExchangeRate", 1)
                        } else {
                            enty.set("oriAndSigExchangeRate", data[index + 1].exchRate);//原币与签单币别兑换率
                        };
                        if(enty.get("oriCurCode") == staCurCode){
                            enty.set("oriAndStaExchangeRate",1);
                        }else{
                            enty.set("oriAndStaExchangeRate", exchangeDateObj[enty.get("oriCurCode")+staCurCode]);//原币与本位币别兑换率
                        }
                    });
                }

                entity.get("plcPackage").each(function(packageList){//承包方案
                    if(packageList.get("plcMainClause")){//主条款
                        // var mainEntityCount=MainClauseList.get("plcClauseItem").entityCount
                        packageList.get("plcMainClause").each(function(MainClauseList){
                            if(MainClauseList.get("plcClauseItem")){//主条款条责标
                                MainClauseList.get("plcClauseItem").each(function(mainClauseItemList,index){
                                    if(mainClauseItemList.get("oriCurCode")==signCurrencyCode){
                                        mainClauseItemList.set("oriAndSigExchangeRate", 1);
                                    }else{
                                        mainClauseItemList.set("oriAndSigExchangeRate", exchangeDateObj[mainClauseItemList.get("oriCurCode")+signCurrencyCode]);//原币与签单币别兑换率
                                    }
                                    if(mainClauseItemList.get("oriCurCode")==staCurCode){
                                        mainClauseItemList.set("oriAndStaExchangeRate", 1);
                                    }else{
                                        mainClauseItemList.set("oriAndStaExchangeRate", exchangeDateObj[mainClauseItemList.get("oriCurCode")+staCurCode]);//原币与本位币别兑换率
                                    }
                                    //主条款条责标
                                    //签单币保额=原币保额*原币与签单币兑换率---sigCurAmount
                                    //签单币含税保费=原币保费*原币与签单币兑换率----sigCurPremium
                                    //签单币不含税保费=原币不含税保费*原币与签单币兑换率-----sigCurNetPremium
                                    //签单币税额=原币税额*原币与签单币兑换率---sigCurTaxFee
                                    mainClauseItemList.set("sigCurAmount",contractEntity.formatToTwoPrecision(mainClauseItemList.get("oriCurAmount")*mainClauseItemList.get("oriAndSigExchangeRate")));//签单币保额
                                    mainClauseItemList.set("sigCurPremium",contractEntity.formatToTwoPrecision(mainClauseItemList.get("oriCurPremium")*mainClauseItemList.get("oriAndSigExchangeRate")));//签单币含税保费
                                    mainClauseItemList.set("sigCurNetPremium",contractEntity.formatToTwoPrecision(mainClauseItemList.get("oriCurNetPremium")*mainClauseItemList.get("oriAndSigExchangeRate")));//签单币不含税保费
                                    mainClauseItemList.set("sigCurTaxFee",contractEntity.formatToTwoPrecision(mainClauseItemList.get("oriCurTaxFee")*mainClauseItemList.get("oriAndSigExchangeRate")));//签单币税额
                                    //本位币保额=原币保额*原币与本位币兑换率-----staCurAmount
                                    //本位币含税保费=原币含税保费*原币与本位币兑换率
                                    //本位币不含税保费=原币原币不含税保费*原币与本位币兑换率
                                    //本位币税额 =原币税额*原币与本位币兑换率
                                    mainClauseItemList.set("staCurAmount",contractEntity.formatToTwoPrecision(mainClauseItemList.get("oriCurAmount")*mainClauseItemList.get("oriAndStaExchangeRate")));//本位币保额
                                    mainClauseItemList.set("staCurPremium",contractEntity.formatToTwoPrecision(mainClauseItemList.get("oriCurPremium")*mainClauseItemList.get("oriAndStaExchangeRate")));//本位币含税保费
                                    mainClauseItemList.set("staCurNetPremium",contractEntity.formatToTwoPrecision(mainClauseItemList.get("oriCurNetPremium")*mainClauseItemList.get("oriAndStaExchangeRate")));//本位币不含税保费
                                    mainClauseItemList.set("staCurTaxFee",contractEntity.formatToTwoPrecision(mainClauseItemList.get("oriCurTaxFee")*mainClauseItemList.get("oriAndStaExchangeRate")));//本位币税额
                                })
                            }
                            if(MainClauseList.get("plcAccessoryClause")){//附加条款
                                MainClauseList.get("plcAccessoryClause").each(function(AccessoryClauseList){
                                    if(AccessoryClauseList.get("plcClauseItem")){//附加条款条责标
                                        AccessoryClauseList.get("plcClauseItem").each(function(AccClauseItemList,idx){
                                            if(AccClauseItemList.get("oriCurCode")==signCurrencyCode){
                                                AccClauseItemList.set("oriAndSigExchangeRate", 1);
                                            }else{
                                                AccClauseItemList.set("oriAndSigExchangeRate", exchangeDateObj[AccClauseItemList.get("oriCurCode")+signCurrencyCode]);//原币与签单币别兑换率
                                            }
                                            if(AccClauseItemList.get("oriCurCode")==staCurCode){
                                                AccClauseItemList.set("oriAndStaExchangeRate",1);//原币与本位币别兑换率
                                            }else{
                                                AccClauseItemList.set("oriAndStaExchangeRate", exchangeDateObj[AccClauseItemList.get("oriCurCode")+staCurCode]);//原币与本位币别兑换率
                                            }
                                            // 签单币----------------------------------------------
                                            AccClauseItemList.set("sigCurAmount",contractEntity.formatToTwoPrecision(AccClauseItemList.get("oriCurAmount")*AccClauseItemList.get("oriAndSigExchangeRate")));//签单币保额
                                            AccClauseItemList.set("sigCurPremium",contractEntity.formatToTwoPrecision(AccClauseItemList.get("oriCurPremium")*AccClauseItemList.get("oriAndSigExchangeRate")));//签单币含税保费
                                            AccClauseItemList.set("sigCurNetPremium",contractEntity.formatToTwoPrecision(AccClauseItemList.get("oriCurNetPremium")*AccClauseItemList.get("oriAndSigExchangeRate")));//签单币不含税保费
                                            AccClauseItemList.set("sigCurTaxFee",contractEntity.formatToTwoPrecision(AccClauseItemList.get("oriCurTaxFee")*AccClauseItemList.get("oriAndSigExchangeRate")));//签单币税额
                                            // 本位币----------------------------------------------
                                            AccClauseItemList.set("staCurAmount",contractEntity.formatToTwoPrecision(AccClauseItemList.get("oriCurAmount")*AccClauseItemList.get("oriAndStaExchangeRate")));//本位币保额
                                            AccClauseItemList.set("staCurPremium",contractEntity.formatToTwoPrecision(AccClauseItemList.get("oriCurPremium")*AccClauseItemList.get("oriAndStaExchangeRate")));//本位币含税保费
                                            AccClauseItemList.set("staCurNetPremium",contractEntity.formatToTwoPrecision(AccClauseItemList.get("oriCurNetPremium")*AccClauseItemList.get("oriAndStaExchangeRate")));//本位币不含税保费
                                            AccClauseItemList.set("staCurTaxFee",contractEntity.formatToTwoPrecision(AccClauseItemList.get("oriCurTaxFee")*AccClauseItemList.get("oriAndStaExchangeRate")));//本位币税额
                                        })
                                    }
                                })
                            }
                        })
                    }
                })
                
                // if (plcFeeList) {
                //     plcFeeList.each(function (ent) {
                //         var oriCurAmount = ent.get("oriCurAmount");//原币保额
                //         var oriCurPremium = ent.get("oriCurPremium");//原币保费
                //         var sigAndStaExchangeRate = model.get("actual.sigAndStaExchangeRate");//签单币与本位币兑换率
                //         var oriAndStaExchangeRate=ent.get("oriAndStaExchangeRate");//原币与本位币兑换率
                //
                //         var oriAndSigExchangeRate = ent.get("oriAndSigExchangeRate");//原币与签单币别兑换率
                //         if (oriAndSigExchangeRate) {
                //             ent.set("sigCurAmount", Number((oriCurAmount * oriAndSigExchangeRate).toFixed(6)));//签单币保额=原币保额*原币与签单币兑换率
                //             ent.set("sigCurPremium", Number((oriCurPremium * oriAndSigExchangeRate).toFixed(6)));//签单币保费
                //             //本位币保额=签单币别保额*签单币与本位币兑换率
                //             ent.set("staCurAmount", Number((ent.get("sigCurAmount") * sigAndStaExchangeRate).toFixed(6)));
                //             //本位币保费=签单币保费*签单币与本位币兑换率
                //             ent.set("staCurPremium", Number((ent.get("sigCurPremium") * sigAndStaExchangeRate).toFixed(6)));
                //             ent.set("$totalSigCurAmount", Number((ent.get("$totalSigCurAmount") * oriAndSigExchangeRate).toFixed(6)));//签单币保额=原币保额*原币与签单币兑换率
                //             ent.set("$totalSigCurPremium", Number((ent.get("$totalSigCurPremium") * oriAndSigExchangeRate).toFixed(6)));//签单币保费
                //             ent.set("sigCurNetPremium", Number((ent.get("oriCurNetPremium") * oriAndSigExchangeRate).toFixed(6)));//签单币不含税保费=原币不含税保费*原币与签单币兑换率
                //             ent.set("sigCurTaxFee", Number((ent.get("oriCurTaxFee") * oriAndSigExchangeRate).toFixed(6)));//签单币税额=原币税额*原币与签单币兑换率
                //             ent.set("staCurNetPremium", Number((ent.get("oriCurNetPremium") * oriAndStaExchangeRate).toFixed(6)));//本位币不含税保费=原币不含税保费*原币与本位币兑换率
                //             ent.set("staCurTaxFee", Number((ent.get("oriCurTaxFee") * oriAndStaExchangeRate).toFixed(6)));//本位币税额=原币税额*原币与本位币兑换率
                //             //可以正确走完保费计算流程
                //             // window.isClickCalcPremiumFlag=true;
                //             $(".savePolicy").removeClass("disabledSave");
                //             $(".submitPolicy").removeClass("disabledSave");
                //             $(".savePolicy").removeClass("disabledBtn");
                //             $(".submitPolicy").removeClass("disabledBtn");
                //             $("#qqSubBtn").removeAttr("disabled");
                //             $("#qqSaveBtn").removeAttr("disabled");
                //             $("#qqSubBtn").removeAttr("title");
                //             $("#qqSaveBtn").removeAttr("title");
                //
                //
                //
                //         } else if (oriAndSigExchangeRate == null || !oriAndSigExchangeRate) {
                //             ent.set("sigCurAmount", null);//签单币保额=原币保额*原币与签单币兑换率
                //             ent.set("sigCurPremium", null);//签单币保费
                //             //本位币保额=签单币别保额*签单币与本位币兑换率
                //             ent.set("staCurAmount", null);
                //             //本位币保费=签单币保费*签单币与本位币兑换率
                //             ent.set("staCurPremium", null);
                //             App.alert("原币，签单币请选择人民币！");
                //         }
                //
                //     })
                // }
            }
        })
    })
        return exchangeDateObj;
}
//修改保费计算币别信息的签单币与原币兑换率
ContractEntity.prototype.getExchangeRate=function(model){
    var plcFeeRole=model.get("solution.plcFee");
    if(plcFeeRole){
        console.log(plcFeeRole.entityCount);
        plcFeeRole.each(function(ent){
            var oriCurAmount=ent.get("oriCurAmount");//原币保额
            var oriCurPremium=ent.get("oriCurPremium");//原币保费
            var sigAndStaExchangeRate=model.get("actual.sigAndStaExchangeRate");//签单币与本位币兑换率

            var oriAndSigExchangeRate=ent.get("oriAndSigExchangeRate");//原币与签单币别兑换率
            if(oriAndSigExchangeRate){
                ent.set("sigCurAmount",contractEntity.formatToTwoPrecision(oriCurAmount*oriAndSigExchangeRate));//签单币保额=原币保额*原币与签单币兑换率
                ent.set("sigCurPremium",contractEntity.formatToTwoPrecision(oriCurPremium*oriAndSigExchangeRate));//签单币保费
                //本位币保额=签单币别保额*签单币与本位币兑换率
                ent.set("staCurAmount",contractEntity.formatToTwoPrecision(ent.get("sigCurAmount")*sigAndStaExchangeRate));
                //本位币保费=签单币保费*签单币与本位币兑换率
                ent.set("staCurPremium",contractEntity.formatToTwoPrecision(ent.get("sigCurPremium")*sigAndStaExchangeRate));

                //可以正确走完保费计算流程
                // window.isClickCalcPremiumFlag=true;
                $(".savePolicy").removeClass("disabledSave");
                $(".submitPolicy").removeClass("disabledSave");
                $("#qqSubBtn").removeAttr("disabled");
                $("#qqSaveBtn").removeAttr("disabled");
                $("#qqSubBtn").removeAttr("title");
                $("#qqSaveBtn").removeAttr("title");

            }else if(oriAndSigExchangeRate==null||!oriAndSigExchangeRate){
                ent.set("sigCurAmount",null);//签单币保额=原币保额*原币与签单币兑换率
                ent.set("sigCurPremium",null);//签单币保费
                //本位币保额=签单币别保额*签单币与本位币兑换率
                ent.set("staCurAmount",null);
                //本位币保费=签单币保费*签单币与本位币兑换率
                ent.set("staCurPremium",null);
                App.alert("原币，签单币请选择人民币！");
            }

        })
    }
}
// 删除单条
ContractEntity.prototype.removeRole = function (model, obj, async, callback) {
    var _selfAsync = true;
    if (async != undefined && !async) {
        _selfAsync = false;
    }
    $.ajax({
        url: "controller/insurance/businessEntity/removeRole",
        type: "POST",
        async: _selfAsync,
        data: {actualId: model.get("actual.actualId"), roleId: obj.get("actualId")},
        success: function (data) {
            obj.remove();
            if (typeof callback == "function") {
                callback();
            }
        }
    });
}
//删除多条
ContractEntity.prototype.removeRoles = function (model, objActualIdArr,callback,async) {
    var _selfAsync = true;
    if (async != undefined && !async) {
        _selfAsync = false;
    }
    $.ajax({
        url: "controller/insurance/businessEntity/removeRoles",
        type: "POST",
        async: _selfAsync,
        data: {actualId: model.get("actual.actualId"), roleIds: objActualIdArr.toString()},
        success: function (data) {
            if (typeof callback == "function") {
                callback();
            }
        }
    });
}

function OperationPage() {
    var contextPath = window.location.href.substr(0, window.location.toString().indexOf("/", window.location.origin.length + 1) + 1);
    this.openPage = function (name, url) {
        //console.log("contextPath ",contextPath);
        if (window.frames.length != parent.frames.length) {
            this.cmd("open", name, contextPath + url);
        } else {
            window.open(contextPath + url);
        }
    }
    this.closePage = function () {
        if (window.frames.length != parent.frames.length) {
            this.cmd("close");
        } else {
            window.location.href = "about:blank";
            window.close();
        }
    }
    this.cmd = function (status, name, url, kind, widgetElementId, id, $dom) {
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
ContractEntity.prototype.openIframePage = function (name, url) {
    operationPage.openPage(name, url);
}
ContractEntity.prototype.closeIframePage = function () {
    operationPage.closePage();
}
//录入人员意见
ContractEntity.prototype.suggestArea = function (model) {
    var actualId = model.get("actuals").current.get("actualId");
    var textValue = cola.tag("suggestArea")[0].get("value");
    if(textValue==undefined){
        textValue=" ";
    }
    var suggessId=window.suggessIds;
    var dataObj={};
    if(!suggessId||suggessId==undefined||suggessId==null){
        dataObj={
            actualId: actualId,
            suggestComment: textValue
        }
    }else{
        dataObj={
            actualId: actualId,
            suggestComment: textValue,
            suggesTionId:suggessId
        }
    }
    if (model.get("actuals").entityCount > 0 && (textValue||textValue=='')) {
        $.ajax({
            // url: "controller/uw/SuggesTion/saveSuggestEo",
            url:"controller/uw/SuggesTion/updateUWSuggesEo",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(dataObj),
            success: function (data) {
                /*model.set("suggessId",data.suggesTionId);*/
            }
        });
    }
}
//共保和联保设置序号
ContractEntity.prototype.setNewIndex = function (model) {
    var coinNum = 1000;
    var linkNum = 2000;
    var coinRoles = model.get("actual.plcSolution.plcCoins.plcCoinsBasicInformation");
    var linkRoles = model.get("actual.plcSolution.plcCoins.plcLinkBasicInformat");
    var saleRoles = model.get("actual.plcSolution.plcCoins.plcCoinsSale");
    if (coinRoles && coinRoles.entityCount > 0) {
        coinRoles.each(function (entity, index) {
            entity.set("linkNo", coinNum + index + 1);
        });
    }
    if (linkRoles && linkRoles.entityCount > 0) {
        linkRoles.each(function (entity, index) {
            entity.set("linkNo", linkNum + index + 1);
        });
    }
    if (saleRoles && saleRoles.entityCount > 0) {
        saleRoles.each(function (entity, index) {
            entity.set("linkNo", linkNum + index + 2);
        });
    }
    var mainSalesRole = model.get("actual.plcSales");
    if(mainSalesRole && mainSalesRole.current){
        mainSalesRole.current.set("linkNo", linkNum + 1);
    }
}
//投保人发生变化时被保人同投保人单选列表重绘，sameflag重置
ContractEntity.prototype.syncApplicantForInsurantRadio = function (model, state) {
    var num = 0;
    //获取被保人在页面中的索引,因不确保页面载入被保人和保单中一致，所以页面隐藏域与保单顺序做比较进行判断
    model.get("actuals").each(function (actual, _index) {
        if(actual.get("plcInsurant")){
            actual.get("plcInsurant").each(function (selfItem, _ind) {
                selfItem.set("$insurantTotalIndex", num);
                num++;

            })
        }

    });

    //获取投保人list
    model.get("applicantList").empty();
    model.get("applicantList").insert({name: "不同投保人", value: 0});
    var applicantEntityList = model.get("actuals").first().get("plcApplicant");
    if (!applicantEntityList) return;
    applicantEntityList.each(function (item, index) {
        var applicantItem;
        var plcApplicantLength = applicantEntityList.entityCount;
        if (plcApplicantLength == 1) {
            applicantItem = {
                name: "同投保人",
                value: index + 1
            };
        } else {
            $(".radisJ,.radioS").remove();
            applicantItem = {
                name: index == "0" ? "同投保人" : "同投保人" + Number(index + 1),
                value: index + 1
            };
        }
        model.get("applicantList").insert(applicantItem);
    });

    var insurantTotalCount = 0;//被保人数量统计，包含多产品

    model.get("actuals").each(function (actual, _index) {
        if(!actual.get("plcInsurant")){
            return;
        }
        actual.get("plcInsurant").each(function (selfItem, _ind) {
            $.each($('.insuranceindex'), function (insuranceindex, hiddenInputItem) {
                if ($(hiddenInputItem).val() != "" && (selfItem.get("$insurantTotalIndex") == $(hiddenInputItem).val())) {
                    insurantTotalCount = insuranceindex;
                }
            });
            if (state && state == selfItem.get("sameFlag")) {
                selfItem.set("sameFlag", 0);
            } else if (state && Number(state) < Number(selfItem.get("sameFlag"))) {
                selfItem.set("sameFlag", Number(selfItem.get("sameFlag") - 1));
            }
            if (!selfItem.get("sameFlag") || selfItem.get("sameFlag") == 0) {
                //表单不禁用

                if (cola.tag("buttonBan")[insurantTotalCount]) {
                    cola.tag("buttonBan")[insurantTotalCount].set("disabled", true);
                    cola.tag("btndqsfzBtns")[insurantTotalCount].set("disabled", false);
                    //cola.tag("datepickerBan")[insurantTotalCount * 2].set("readOnly", false);
                    //cola.tag("datepickerBan")[insurantTotalCount * 2 + 1].set("readOnly", false);//每个被保人有两个
                    cola.tag("radioBan")[0].set("readOnly", false);
                }
                $(".allForbidden").eq(insurantTotalCount).find("input").prop("readOnly", false);
                $(".allselfCustomer").eq(insurantTotalCount).find("input").prop("readOnly", false);
                $(".allselfCustomer").eq(insurantTotalCount).children(".field").css('pointerEvents', '');
                $(".allgrpCustomer").eq(insurantTotalCount).find("input").prop("readOnly", false);
                $(".select-applicant").eq(insurantTotalCount).find("input").eq(0).prop("checked", true);
                //$(".allselfCustomer").eq(insurantTotalCount - 1).find(".accident").find("input").prop("disabled", false);
                $(".allForbidden").eq(insurantTotalCount).find(".input").css("pointerEvents", "");
                //保存后添加被保人隐藏字段有影响
                selfItem.set("sameFlag", 0);
            } else {
                //表单禁用
                if (cola.tag("buttonBan")[insurantTotalCount]) {
                    cola.tag("buttonBan")[insurantTotalCount].set("disabled", true);
                    cola.tag("btndqsfzBtns")[insurantTotalCount].set("disabled", true);
                    cola.tag("datepickerBan")[insurantTotalCount * 2].set("readOnly", true);
                    //cola.tag("datepickerBan")[insurantTotalCount * 2 + 1].set("readOnly", true);
                    cola.tag("radioBan")[insurantTotalCount].set("readOnly", true);
                }
                //setTimeout(function(){
                $(".select-applicant").eq(insurantTotalCount).find("input").eq(selfItem.get("sameFlag")).prop("checked", true);
                $(".allForbidden").eq(insurantTotalCount).find("input").prop("readOnly", true);
                $(".allselfCustomer").eq(insurantTotalCount).find("input").prop("readOnly", true);
                $(".allselfCustomer").eq(insurantTotalCount).children(".field").css('pointerEvents', 'none');
                $(".allselfCustomer").eq(insurantTotalCount).children(".accident").css('pointerEvents', '');
                $(".allgrpCustomer").eq(insurantTotalCount).find("input").prop("readOnly", true);
                //$(".allselfCustomer").eq(insurantTotalCount - 1).find(".accident").find("input").prop("disabled", false);
                $(".allForbidden").eq(insurantTotalCount).find(".input").css("pointerEvents", "none");
                // },5000);//原来的延时是0秒的时候,在核保中设不上,现在设为5秒

                var ind = selfItem.get("sameFlag");
                var applicantItem;

                applicantEntityList.each(function (_selfitem, index) {
                    if (index + 1 == ind) {
                        applicantItem = _selfitem;
                    }
                });
                if (applicantItem) {
                    contractEntity.setInsurantFromApplicant(applicantItem, selfItem);
                }


            }
            if (selfItem.get("sameFlag") == '0') {
                if (selfItem.get("identifyType") != null && selfItem.get("identifyNumber") != null) {
                    cola.tag("buttonBan")[insurantTotalCount].set("disabled", false);
                } else {
                    cola.tag("buttonBan")[insurantTotalCount].set("disabled", true);
                }
            }

        });

    });


}
//同步单个投保人到被保人
ContractEntity.prototype.setInsurantFromApplicant = function (plcApplicant, plcInsurant) {
    var sameFlag = plcInsurant.get("sameFlag");
    if (plcApplicant.get("customerType") == "1") {
        if (plcApplicant.get("identifyEffectiveEndDate")) {
            if (plcApplicant.get("identifyEffectiveEndDate").getFullYear() == 2999) {
                $('.checkboxinsurant').eq(sameFlag - 1).addClass('checked').children('input').attr('checked', true);
                plcInsurant.set("longtermEffectiveFlag", "1");
            } else {
                $('.checkboxinsurant').eq(sameFlag - 1).removeClass('checked').children('input').removeAttr('checked');
                plcInsurant.set("longtermEffectiveFlag", "0");
            }
        }else if(plcApplicant.get("identifyEffectiveEndDate")==null){
            plcInsurant.set("longtermEffectiveFlag", "0");
            if($('.checkboxinsurant').hasClass("checked")){
                $('.checkboxinsurant').eq(sameFlag - 1).removeClass('checked').children('input').removeAttr('checked');
            }

        }
        //投保人
        var regu = "^[a-zA-Z\u4e00-\u9fa5]+$";
        var re = new RegExp(regu);
        if (re.test(plcApplicant.get("customerName"))) {
            plcInsurant.set("customerName", plcApplicant.get("customerName"));//判断是否合规
        } else {
            plcInsurant.set("customerName", null);
        }
        App.setFieldVisible($(".selfCustomer").eq(sameFlag-1), true, false);
        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(sameFlag-1).find(".workTypeSmallClass"),false);
        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(sameFlag-1).find(".thirdOperationCode"),false);
        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(sameFlag-1).find(".industryCategoryName"),true);
        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(sameFlag-1).find(".businessSort"),true);
        App.setFieldVisible($(".grpCustomer").eq(sameFlag-1), false, true);
    }else{
      
        // var reguzz = "^[0-9a-zA-Z\u4e00-\u9fa5]+$";
        // var ress = new RegExp(reguzz);
        // if (ress.test(plcApplicant.get("customerName"))) {
            plcInsurant.set("customerName", plcApplicant.get("customerName"));//判断是否合规
        // } else {
        //     plcInsurant.set("customerName", null);
        // }
        //组织复制
            
       plcInsurant.set("plcGrpCustomer.industryCategoryName",plcApplicant.get("plcGrpCustomer.industryCategoryName"));
       plcInsurant.set("plcGrpCustomer.industryCategory",plcApplicant.get("plcGrpCustomer.industryCategory"));
       plcInsurant.set("plcGrpCustomer.industrySCategory",plcApplicant.get("plcGrpCustomer.industrySCategory"));
       plcInsurant.set("plcGrpCustomer.industrySCategoryName",plcApplicant.get("plcGrpCustomer.industrySCategoryName"));
       plcInsurant.set("plcGrpCustomer.industryTCategoryName",plcApplicant.get("plcGrpCustomer.industryTCategoryName"));
       plcInsurant.set("plcGrpCustomer.industryTCategory",plcApplicant.get("plcGrpCustomer.industryTCategory"));
       plcInsurant.set("plcGrpCustomer.businessSortName",plcApplicant.get("plcGrpCustomer.businessSortName"));
       plcInsurant.set("plcGrpCustomer.businessSort",plcApplicant.get("plcGrpCustomer.businessSort"));
        
       
       App.setFieldVisible($(".selfCustomer").eq(sameFlag-1), false, true);
        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(sameFlag-1).find(".workTypeSmallClass"),true);
        contractEntity.setFieldValidatorsDisabled($(".selfCustomer").eq(sameFlag-1).find(".thirdOperationCode"),true);
        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(sameFlag-1).find(".industryCategoryName"),false);
        contractEntity.setFieldValidatorsDisabled($(".grpCustomer").eq(sameFlag-1).find(".businessSort"),false);
        App.setFieldVisible($(".grpCustomer").eq(sameFlag-1), true, false);
    }
    //修改对应字段值
    //投保人类型
    plcInsurant.set("customerType", plcApplicant.get("customerType"));
    plcInsurant.set("customerTypeName", plcApplicant.get("customerTypeName"));
    plcInsurant.set("registId", plcApplicant.get("registId"));
    plcInsurant.set("plcGrpCustomer.mainCustomerGrade", plcApplicant.get("plcGrpCustomer.mainCustomerGrade"));

    //投保人证件类型
    plcInsurant.set("identifyType", plcApplicant.get("identifyType"));
    plcInsurant.set("identifyName", plcApplicant.get("identifyName"));
    //投保人证件号码
    plcInsurant.set("identifyNumber", plcApplicant.get("identifyNumber"));

    //投保人代码
    plcInsurant.set("customerCode", plcApplicant.get("customerCode"));

    //投保人证件有效期
    plcInsurant.set("identifyEffectiveEndDate", plcApplicant.get("identifyEffectiveEndDate"));
    plcInsurant.set("longtermEffectiveFlag", plcApplicant.get("longtermEffectiveFlag"));
    //投保人年龄

    if (plcApplicant.get("plcCustomer.age") >= 0 && plcApplicant.get("plcCustomer.age") < 100) {
        plcInsurant.set("plcCustomer.age", plcApplicant.get("plcCustomer.age"));
    }
    //投保人性别
    plcInsurant.set("plcCustomer.sex", plcApplicant.get("plcCustomer.sex"));
    plcInsurant.set("plcCustomer.sexName", plcApplicant.get("plcCustomer.sexName"));
    //投保人出生日期
    var birthDate = plcApplicant.get("plcCustomer.birthDate");
    var date = new Date();
    var birthDateTemp=new Date(birthDate);
    if (birthDate && birthDateTemp <= date) {
        plcInsurant.set("plcCustomer.birthDate", plcApplicant.get("plcCustomer.birthDate"));
    }
    //投保人国籍
    plcInsurant.set("plcCustomer.citizenship", plcApplicant.get("plcCustomer.citizenship"));
    plcInsurant.set("plcCustomer.citizenshipName", plcApplicant.get("plcCustomer.citizenshipName"));
    //投保人地址
    plcInsurant.set("plcCustomer.address", plcApplicant.get("plcCustomer.address"));
    //投保人联系电话
    //var phoneNumber = /^\d{11}$/;
    //if (phoneNumber.test(plcApplicant.get("plcCustomer.phoneNumber"))) {
        plcInsurant.set("plcCustomer.phoneNumber", plcApplicant.get("plcCustomer.phoneNumber"));
        plcInsurant.get('plcCustomer').validate('mobile')
    //} else {
       // plcInsurant.set("plcCustomer.phoneNumber", null);
   //}
    //投保人联系手机
    var mo = /^1[123456789]\d{9}$/;
    if (mo.test(plcApplicant.get("plcCustomer.mobile"))) {
        plcInsurant.set("plcCustomer.mobile", plcApplicant.get("plcCustomer.mobile"));
        plcInsurant.get('plcCustomer').validate('phoneNumber')
    } else {
        plcInsurant.set("plcCustomer.mobile", null);
    }
    plcInsurant.get('plcCustomer').validate('phoneNumber')
    //投保人联系邮箱
    var email = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if (email.test(plcApplicant.get("plcCustomer.email"))) {
        plcInsurant.set("plcCustomer.email", plcApplicant.get("plcCustomer.email"));
    } else {
        plcInsurant.set("plcCustomer.email", null);
    }
    //投保人邮政编码
    var regx = /^\d{6}$/;
    if (regx.test(plcApplicant.get("plcCustomer.post"))) {
        plcInsurant.set("plcCustomer.post", plcApplicant.get("plcCustomer.post"));
    } else {
        plcInsurant.set("plcCustomer.post", null);
    }
    //投保人境内境外标志
    plcInsurant.set("plcCustomer.isWithinForeign", plcApplicant.get("plcCustomer.isWithinForeign"));
    //开户银行名称
    plcInsurant.set("despositBankName", plcApplicant.get("despositBankName"));
    //银行账户名称
    plcInsurant.set("accountName", plcApplicant.get("accountName"));
    //银行账号
    var accNo = /^\d*$/;
    if (accNo.test(plcApplicant.get("accountNo"))) {
        plcInsurant.set("accountNo", plcApplicant.get("accountNo"));
    } else {
        plcInsurant.set("accountNo", null);
    }
    // 团体字段
    //注册地址
    plcInsurant.set("plcGrpCustomer.registyAddress", plcApplicant.get("plcGrpCustomer.registyAddress"));
    //主营业务
    plcInsurant.set("plcGrpCustomer.mainBussiness", plcApplicant.get("plcGrpCustomer.mainBussiness"));
    //法定代表人证件号码
    plcInsurant.set("plcGrpCustomer.applialeaderId", plcApplicant.get("plcGrpCustomer.applialeaderId"));
    //国民经济类型行业代码
    plcInsurant.set("plcGrpCustomer.nationalEconomyType", plcApplicant.get("plcGrpCustomer.nationalEconomyType"));
    //参加社会统筹标志
    plcInsurant.set("plcGrpCustomer.societyStatFlag", plcApplicant.get("plcGrpCustomer.societyStatFlag"));
    //行业
    plcInsurant.set("plcGrpCustomer.industryCategory", plcApplicant.get("plcGrpCustomer.industryCategory"));
    plcInsurant.set("plcGrpCustomer.industryCategoryName", plcApplicant.get("plcGrpCustomer.industryCategoryName"));
    //组织类型
    plcInsurant.set("plcGrpCustomer.organizationName", plcApplicant.get("plcGrpCustomer.organizationName"));
    plcInsurant.set("plcGrpCustomer.organizationType", plcApplicant.get("plcGrpCustomer.organizationType"));
    // 注册地址
    plcInsurant.set("plcGrpCustomer.registeredPlace", plcApplicant.get("plcGrpCustomer.registeredPlace"));
    plcInsurant.set("plcGrpCustomer.registeredPlaceCode", plcApplicant.get("plcGrpCustomer.registeredPlaceCode"));
    plcInsurant.set("plcGrpCustomer.registyAddress", plcApplicant.get("plcGrpCustomer.registyAddress"));
    //通信地址所属邮编
    var reg = /^\d{6}$/;
    if (reg.test(plcApplicant.get("plcGrpCustomer.mailAddressPost"))) {
        plcInsurant.set("plcGrpCustomer.mailAddressPost", plcApplicant.get("plcGrpCustomer.mailAddressPost"))
    } else {
        plcInsurant.set("plcGrpCustomer.mailAddressPost", null);
    }
    //联系人
    if (/^[a-zA-Z\u4e00-\u9fa5]+$/.test(plcApplicant.get("linkerName"))) {
        plcInsurant.set("linkerName", plcApplicant.get("linkerName"))
    } else {
        plcInsurant.set("linkerName", null);
    }

    //办公室电话/联系人电话
    var li = /^1[123456789]\d{9}$/;
    if (li.test(plcApplicant.get("linkerMobile"))) {
        plcInsurant.set("linkerMobile", plcApplicant.get("linkerMobile"))
    } else {
        plcInsurant.set("linkerMobile", null);
    }
    //联系人电话
    var insurant = /^\d{11}$/;
    if (plcApplicant.get("linkerPhoneNo")) {
        plcInsurant.set("linkerPhoneNo", plcApplicant.get("linkerPhoneNo"))
    } else {
        plcInsurant.set("linkerPhoneNo", null);
    }
    //客户等级
    plcInsurant.set("customerGrade", plcApplicant.get("customerGrade"))
    plcInsurant.set("customerGradeName", plcApplicant.get("customerGradeName"))
    //客户风险等级
    plcInsurant.set("customerRiskGrade", plcApplicant.get("customerRiskGrade"));
    plcInsurant.set("customerRiskGradeName", plcApplicant.get("customerRiskGradeName"))
    //银行账号名称
    plcInsurant.set("accountName", plcApplicant.get("accountName"))

}
//是否开启暂存
ContractEntity.prototype.isTempSave=function(model){
    setTimeout(function(){
        //启动暂存
        if(!window.savePausePolicyIntval) {
            window.savePausePolicyIntval = setInterval(function () {
                model.action("savePausePolicy")(true);
            }, 300000);

            //如果引用投保视图,清除掉自动保存 -> 该方法在productView.js中
            $(window).trigger("clearSavePausePolicyIntval");
        }
    }, 5000);
}
ContractEntity.prototype.isQuotationEnter=function(){
    var quoArr = location.href.split("/");
    var isQuotationFlag = false;
    for (var quo = 0; quo < quoArr.length; quo++) {
        if (quoArr[quo] == "quotationcenter") {
            isQuotationFlag = true;
            break;
        }
    }
    return isQuotationFlag;
};
ContractEntity.prototype.removeRiskInformation=function(blockArr,productCode)
{
    var blockIndex,blockIndex2;//风险信息，风险查勘
    $.each( blockArr,function(index,selfItem){
        if((selfItem.kind.indexOf("plcRisk")>-1)&&(selfItem.kind!="plcRiskSurvey")){
            blockIndex = index;
        }else if(selfItem.kind=="plcRiskSurvey"){
            blockIndex2 = index;
        }
    });
    if(blockIndex2!=undefined){
        blockArr.splice(blockIndex2,1);
    }
    if(blockIndex!=undefined){
        blockArr.splice(blockIndex,1);
    }

    return blockArr;
};
ContractEntity.prototype.setSystemType=function(systemType){
this.systemType = systemType;
}
ContractEntity.prototype.getSystemType=function(){
    return this.systemType;
}
ContractEntity.prototype.setProductLimitObj = function (productLimitObj) {
    this.productLimitObj = productLimitObj;
}
ContractEntity.prototype.getProductLimitObj = function () {
    return this.productLimitObj;
}
ContractEntity.prototype.setNoTaxRateList = function (noTaxRateList) {
    this.noTaxRateList = noTaxRateList;
}
ContractEntity.prototype.getNoTaxRateList = function () {
    return this.noTaxRateList;
}
ContractEntity.prototype.setActualsSerialNo = function (actualId ,max) {
    // var numLarge=max?max:1;
    // if (this.actualsSerialNo[actualId]) {
    //     this.actualsSerialNo[actualId]=max;
    // } else {
        this.actualsSerialNo[actualId] = max;
    // }
}
ContractEntity.prototype.getActualsSerialNo = function (actualId) {
    return this.actualsSerialNo[actualId];
}
ContractEntity.prototype.getCumulativeOriCurAmount=function(){
    return this.isCumulativeOriCurAmount;
}
//拿到atual后，
ContractEntity.prototype.getSaveActual = function (model) {
    var proParams = this.proParams;
    var maxIndex = 0;
    model.get("actuals").each(function (actual) {
        actual.get("plcSolution").each(function (solution) {
            //旧规则，页面加载进来根据plcFee是否有签单币保额，签单币保费判断之前是否计算过保费，让保存，提交按钮亮起，或禁用
            /*if (solution.get("plcFee")) {
                solution.get("plcFee").each(function (entity) {
                    if (entity.get("sigCurAmount") && entity.get("sigCurAmount") != 0) {
                        $(".savePolicy").removeClass("disabledSave");
                        $(".submitPolicy").removeClass("disabledSave");
                        $(".savePolicy").removeClass("disabledBtn");
                        $(".submitPolicy").removeClass("disabledBtn");
                        $(".image").removeClass("disabledSave");
                        $("#qqSubBtn").removeAttr("disabled");
                        $("#qqSaveBtn").removeAttr("disabled");
                        $("#qqSubBtn").removeAttr("title");
                        $("#qqSaveBtn").removeAttr("title");
                        $(".images").removeClass("disabledSave");
                        $(".image").removeClass("disabledSave");
                        $(".image").removeAttr("disabled");
                        $(".image").removeAttr("title");
                    }
                })
            }*/
          
            //汇总页面已选择条款code到proParams，作为请求限额免赔接口参数
            solution.get("plcPackage").each(function (pag) {
                if (pag.get("plcMainClause")) {
                    pag.get("plcMainClause").each(function (mainClause) {
                        var mainobj = {};
                        mainobj.productType = "Clause";
                        if (mainClause.get("clauseCode")) {
                            mainobj.productCode = mainClause.get("clauseCode");
                            proParams.push(mainobj);
                        }
                        if (mainClause.get("plcClauseItem")){
                            mainClause.get("plcClauseItem").each(function(mainClauseItem){
                                var sno=mainClauseItem.get("serialNo");
                                if(sno && Number(mainClauseItem.get("serialNo"))>maxIndex){
                                    maxIndex = Number(mainClauseItem.get("serialNo"));
                                }
                            })
                        }
                        if (mainClause.get("plcAccessoryClause")) {
                            mainClause.get("plcAccessoryClause").each(function (addClause) {
                                var addobj = {};
                                addobj.productType = "Clause";
                                if (addClause.get("clauseCode")) {
                                    addobj.productCode = addClause.get("clauseCode");
                                    proParams.push(addobj);
                                }
                                if(addClause.get("plcClauseItem")){
                                    addClause.get("plcClauseItem").each(function(addClauseItem){
                                        var ano=addClauseItem.get("serialNo");
                                        if(ano && Number(addClauseItem.get("serialNo"))>maxIndex){
                                            maxIndex = Number(addClauseItem.get("serialNo"));
                                        }
                                    })
                                }
                            })
                        }
                    })
                }
            })
        })
        contractEntity.setActualsSerialNo(actual.get("actualId"),maxIndex);
    })
    if (proParams.length > 0) {
        $.ajax({
            url: "controller/contract/querylimitrlship/getCachedProductLimitRlships",
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(proParams),
            success: function (data) {
                contractEntity.setProductLimitObj(data);
                // $(window).trigger("getProductLimit");
            }
        })
    }
}
//判断日期是否大于一年
ContractEntity.prototype.isDateOverYear = function (model) {
  var effFlag = model.get("actual.effectiveImmediatelyFlag");//是否即使起保
  var startTimes=model.get("actual.startTime");
  var endTimes=model.get("actual.endTime");
    if( typeof startTimes ==="string"){
        startTimes=new Date(startTimes);
    }
    if( typeof endTimes ==="string"){
        endTimes=new Date(endTimes);
    }
    var startFullYear;
    var startEndDays;
  startEndDays = Math.floor(dateDiff(startTimes, endTimes, 'D'));//开始日期与结束日期的天数差
  if (!effFlag || effFlag == '0') {//非即使起保时
        //旧规则开始日开始日期期加一年减一天
    //新规则开始日期加一年
        startFullYear=new Date(startTimes);
        startFullYear.setFullYear(startTimes.getFullYear()+1);
//        startFullYear.setDate(startTimes.getDate()-1);
//        startFullYear.setHours(23);startFullYear.setMinutes(59);startFullYear.setSeconds(59);
    } else {
        var startfullYearY = startTimes.getFullYear() + 1;
        var startfullYearM = startTimes.getMonth() + 1;
        var startfullYearD = startTimes.getDate();
        var startfullYearH = startTimes.getHours();
        var startfullYearMi = startTimes.getMinutes();
        var startfullYearS = startTimes.getSeconds();
        startFullYear = new Date(startfullYearY+"-"+startfullYearM+"-"+startfullYearD+" "+startfullYearH+":"+startfullYearMi+":"+startfullYearS);
    }
    // 判断一年是365还是366天
    var allYearDays = Math.floor(dateDiff(startTimes, startFullYear, 'D'));
    if(startEndDays>=allYearDays){
      return true;
    }else{
      return false;
    }
}
//判断是否是税优
ContractEntity.prototype.getTaxRate = function (code,model) {
  var taxRateNum;
  var flag=ContractEntity.prototype.isDateOverYear(model);
    if(flag &&　this.noTaxRateList[code]!=null && this.noTaxRateList[code]!=undefined && this.noTaxRateList[code]!=="" ){//大于等于一年并且是税优条款
      taxRateNum=this.noTaxRateList[code];
      taxRateNum=taxRateNum*100;
    }else{
      taxRateNum = 6;
    }
    return taxRateNum;
}
//特别约定自动添加一条
ContractEntity.prototype.addPlcEngageRoles=function(productCode,province,model){
    //27------意外险  02/03/04----家财险
    // 32000000-----江苏
    //11000000------北京
    //44030000------深圳
    return;
    var plcEngageMap=this.plcEngageMap;
    var productBeforeTwo=productCode.substring(0,2);
    var engageRole=[];
    var engageRemoveRoleArr=[];
    if(model.get("actuals")){
        model.get("actuals").each(function(enttit){
            model.set("actual",enttit);
            var parKind=enttit.get("plcSolution").current;
            var plcEngageRole=enttit.get("plcSolution").current.get("_pageEngage");
            var solutionEnt=enttit.get("plcSolution").current;
            //当选择约定汇率是，默认添加一条特约信息
            if(model.get("actual.exchangeWayCode")=='2'){
                engageRole.push(plcEngageMap["T0012"]);
            }else if(model.get("actual.exchangeWayCode")=='1'){
                if(plcEngageRole){
                    plcEngageRole.each(function(entity){
                        if(entity.get("especialCode")=='T0012'){
                            entity.remove();
                                // contractEntity.engageIndex(model);
                        }
                    })
                }
            }
            //意外险+深圳+每张保单默认带出+自动带出
            if(productBeforeTwo=='27' && province=='44030000'){
                for(var i in plcEngageMap){
                    if(i=='T1001'||i=='T1003'||i=='T1004'||i=='T1005'){
                        engageRole.push(plcEngageMap[i]);
                    }
                }
            }
            // 北京+意外险+默认自动带出
            if(productBeforeTwo=='27' && province=='11000000'){
                var plcAccNum=0;//记录9001546附加险
                var plcDeduti=0//记录标的免赔额
                console.log(model.get("provinces.province"));
                for(var i in plcEngageMap){
                    if(i=='T1008'||i=='T1010'){
                        engageRole.push(plcEngageMap[i]);
                    }
                }
                if(solutionEnt){
                    var mainClau=solutionEnt.get("plcPackage").current.get("plcMainClause");
                    if(mainClau){
                        var straightDeductible,deductible,claimRate,oriCurName;
                        mainClau.each(function(entity){
                            if(entity.get("plcAccessoryClause")){
                                entity.get("plcAccessoryClause").each(function(ent){
                                    if(ent.get("clauseCode")=="9001546"){//附加险不会重复
                                        plcAccNum++;
                                        if(ent.get("plcClauseItem")){
                                            ent.get("plcClauseItem").each(function(clauseItemList){
                                                if(clauseItemList.get("deductible")||clauseItemList.get("claimRate")){
                                                    straightDeductible=clauseItemList.get("straightDeductible");
                                                    deductible=clauseItemList.get("deductible");
                                                    claimRate=clauseItemList.get("claimRate");
                                                    oriCurName=clauseItemList.get("oriCurName");
                                                    plcDeduti++;
                                                }
                                            })
                                        }


                                    }
                                })
                            }
                        })
                        var straightDeductibleStr="每人附加意外伤害住院生活津贴免赔天数："+straightDeductible+"天;";
                        var deductibleStr="附加意外伤害医疗费用保险免赔：对被保险人所支出的必要合理的、符合当地基本医疗保险主管部门规定可报销的医疗费用，保险人扣除"+oriCurName+deductible+"元免赔额后，在保险金额范围内，按"+claimRate+"％比例给付医疗保险金。";//每次事故免赔天数，免赔额。给付比例
                        if(plcAccNum>0){//附加险添加特约
                            engageRole.push(plcEngageMap['T1007'])
                        }else{
                            if(plcEngageRole){
                                plcEngageRole.each(function(entity){
                                    if(entity.get("especialCode")=='T1007'){
                                        contractEntity.removeRole(model, entity, true, function () {
                                            // contractEntity.engageIndex(model);
                                        });
                                    }
                                })
                            }
                        }
                        var allStr='';
                        if(plcDeduti>0){
                            if(straightDeductible){//标的免赔天数增加特约
                                allStr=straightDeductibleStr;

                            }
                            if((deductible||deductible==0||claimRate||claimRate==0)){
                                allStr=allStr+deductibleStr;//免赔额。给付比例
                            }
                            plcEngageMap['T1011']={
                                especialCode:"T1011",
                                especialName:"免赔特约（附加险）",
                                especialClauses:allStr
                            }
                            engageRole.push(plcEngageMap['T1011'])
                        }
                        else{
                            if(plcEngageRole){
                                plcEngageRole.each(function(entity){
                                    if(entity.get("especialCode")=='T1011'){
                                        contractEntity.removeRole(model, entity, true, function () {
                                            // contractEntity.engageIndex(model);
                                        });
                                    }
                                })
                            }
                        }
                    }
                }
            }
            // 江苏+意外险
            if(productBeforeTwo=='27' && province=='32000000'){
                var jsPlcAccNum=0;
                if(solutionEnt){
                    var mainClau=solutionEnt.get("plcPackage").current.get("plcMainClause");
                    if(mainClau){
                        var straightDeductible,deductible,claimRate,oriCurName;
                        mainClau.each(function(entity,idex){
                            var mainClauseAmount=entity.get("$oriCurAmount");//主险保额
                            var mainClausename=entity.get("plcClauseItem");//附加险
                            if(mainClausename){
                                // mainClausename.each(function(entti,index){//主险责任
                                    plcEngageMap["T1111"+idex]={
                                        especialCode:"T1111"+idex,
                                        especialName:entity.get("clauseName"),
                                        especialClauses:"人身意外伤害保险金额为"+mainClauseAmount+"元"
                                    };
                                    engageRole.push(plcEngageMap["T1111"+idex]);
                                // })
                            }

                            if(entity.get("plcAccessoryClause")){
                                entity.get("plcAccessoryClause").each(function(ent,dex){
                                    if(ent.get("clauseCode")=="9001546"){//附加条款上的免赔额和给付比例
                                        jsPlcAccNum++;
                                        if(ent.get("plcClauseItem")){//附加条款条责标上的免赔额和给付比例
                                            ent.get("plcClauseItem").each(function(clauseItemList){
                                                if(clauseItemList.get("deductible")||clauseItemList.get("claimRate")){
                                                    straightDeductible=clauseItemList.get("straightDeductible");
                                                    deductible=clauseItemList.get("deductible");
                                                    claimRate=clauseItemList.get("claimRate");
                                                    oriCurName=clauseItemList.get("oriCurName");
                                                    plcDeduti++;
                                                }
                                            })
                                        }
                                    }
                                    var plcAccessAmount=ent.get("$oriCurAmount");//附加险保额
                                    var plcAccessName=ent.get("plcClauseItem");//附加险
                                    // if(plcAccessName){
                                        // plcAccessName.each(function(entt,index){
                                            plcEngageMap["T2222"+dex]={
                                                especialCode:"T2222"+dex,
                                                especialName:ent.get("clauseName"),
                                                especialClauses:"附加意外伤害医疗费用保险金额为"+plcAccessAmount+"元"
                                            };//附加险责任
                                            engageRole.push(plcEngageMap["T2222"+dex]);
                                        // })
                                    // }
                                })
                            }
                        })
                        var straightDeductibleStr="每人附加意外伤害住院生活津贴免赔天数："+straightDeductible+"天;";
                        var deductibleStr="附加意外伤害医疗费用保险免赔：对被保险人所支出的必要合理的、符合当地基本医疗保险主管部门规定可报销的医疗费用，保险人扣除"+oriCurName+deductible+"元免赔额后，在保险金额范围内，按"+claimRate+"％比例给付医疗保险金。";//每次事故免赔天数，免赔额。给付比例
                        var allStr='';
                        if(jsPlcAccNum>0){
                            if(straightDeductible){//标的免赔天数增加特约
                                allStr=straightDeductibleStr;

                            }
                            if((deductible||deductible==0||claimRate||claimRate==0)){
                                allStr=allStr+deductibleStr;//免赔额。给付比例
                            }
                            plcEngageMap['T1014']={
                                especialCode:"T1014",
                                especialName:"免赔特约（附加险）",
                                especialClauses:allStr
                            }
                            engageRole.push(plcEngageMap['T1014'])
                        }
                        else{
                            if(plcEngageRole){
                                plcEngageRole.each(function(entity){
                                    if(entity.get("especialCode")=='T1014'){
                                        contractEntity.removeRole(model, entity, true, function () {
                                            // contractEntity.engageIndex(model);
                                        });
                                    }
                                })
                            }
                        }
                    }
                }

            }
            // 02---03---04---------------家财险
            if(productBeforeTwo=='02'||productBeforeTwo=='03'||productBeforeTwo=='04'){
                var TNum=0;
                if(enttit.get("plcHouse")){
                    enttit.get("plcHouse").each(function(enti){
                        // 钢结构、钢筋混凝土、砖木结构
                        if(enti.get("structureCode")=='0'||enti.get("structureCode")=='2'||enti.get("structureCode")=='8'){
                            TNum++;
                        }
                    })
                    if(TNum>0){//附加险添加特约
                        engageRole.push(plcEngageMap['T1024'])
                    }else{
                        if(plcEngageRole){
                            plcEngageRole.each(function(entity){
                                if(entity.get("especialCode")=='T1024'){
                                    // contractEntity.removeRole(model, entity, true, function () {
                                        // contractEntity.engageIndex(model);
                                    // });
                                    entity.remove();
                                }
                            })
                        }
                    }
                }

            }
            contractEntity.differentEngage(engageRole,model);
            if(engageRole.length>0){
                for(var i =0;i<engageRole.length;i++){
                    engageRole[i].$oldArr=[];
                    parKind.get("_pageEngage").insert(engageRole[i]);
                }
            }
        })
    }
}
//重新刷新特别约定序号
ContractEntity.prototype.engageIndex=function(model) {
    if(model.get("actuals")){
        model.get("actuals").each(function(entit){
            var engage = entit.get("plcSolution").current.get("plcEngage");
            if (engage) {
                engage.each(function (entity, index) {
                    entity.set("serialNo", index + 1);
                })
            }
        })
    }
}
//判断不能添加相同的特约信息
ContractEntity.prototype.differentEngage=function(engageRole,model){
    var engageCodeObj={};
    var indexArr=[];
    if(model.get("actuals")){
        model.get("actuals").each(function(entt){
            var engage = entt.get("plcSolution").current.get("_pageEngage");
            if(model.get("actuals")){
                model.get("actuals").each(function(entt){
                    var engage = entt.get("plcSolution").current.get("_pageEngage");
                    if(engage){
                        engageCodeObj={};
                        engage.each(function(entity){
                            engageCodeObj[entity.get("especialCode")]=entity.toJSON();
                            //engageCodeObj[especialName]=entity.get("especialClauses");
                        })
                    }
                    //判断不可添加重复的
                    if(engageCodeObj){
                        for(var i=0;i<engageRole.length;i++){
                            if(engageCodeObj[engageRole[i].especialCode]){
                                engage.each(function(entity){
                                    if(entity.get("especialCode")==engageRole[i].especialCode){
                                        entity.set("especialClauses",engageRole[i].especialClauses);
                                    }
                                })

                                indexArr.push(i);
                            }

                        }

                        for(var k = indexArr.length-1;k>=0;k--){
                            engageRole.splice(indexArr[k],1);
                        }
                    }
                })
            }
            //------------------------------------------------------------------
            //判断不可添加重复的
            // if(engageCodeObj){
            //     for(var i=0;i<engageRole.length;i++){
            //         if(engageCodeObj[engageRole[i].especialCode]==true){
            //             indexArr.push(i);
            //         }
            //     }
            //     for(var k = indexArr.length-1;k>=0;k--){
            //         engageRole.splice(indexArr[k],1);
            //     }
            // }
        })
    }

}
//归属部门所在省接口请求
ContractEntity.prototype.superiorInstitution=function (model,async,just) {
    var provienceCode;
    if (model.get("actual.businessOffice")) {
        if (",2102,3302,3502,3702,4403,".indexOf(model.get("actual.businessOffice").substring(0, 4)) > -1) {
            provienceCode = model.get("actual.businessOffice").substring(0, 4) + "0000";
        } else {
            provienceCode = model.get("actual.businessOffice").substring(0, 2) + "000000";
        }
        $.ajax({
            url: "controller/contract/salesmanagement/findByPartyId?parentId=" + provienceCode,
            async:async,
            success: function (data) {
                var key = data.structurePath.split("/")[1];
                if ((key == 32000000 || key == 35000000 || key == 44000000 || key == 37069900 || key == 37109900)&&just) {
                    App.setFieldVisible(model.$(".docSalePracticeNo"), true, false);
                } else {
                    App.setFieldVisible(model.$(".docSalePracticeNo"), false, true);
                }
                model.set("provinces.province", key);
            }
        })
    }
}
//代理人/经纪人/寿险人员机构规则判断
ContractEntity.prototype.saleamanRule=function (model,perstatdate,perenddate,agentname,ctfsign,permitno) {
    var newDate=new Date().getTime();
    var perstatdates=new Date(perstatdate).getTime();
    var perenddates=new Date(perenddate).getTime();
    var fastExpire;
    var chooseBusinessNatureCode = ["1","t","v"];
    if(perstatdates>newDate&&chooseBusinessNatureCode.indexOf(model.get("businessNatureCode"))<0){
        fastExpire=(perenddates-newDate)/1000/60/60/24;
        App.alert(agentname+"的代理许可证还未生效");
        model.set("actual.saleaman",null);
        model.set("saleamanList",null);
    }
    if(perenddates<newDate&&chooseBusinessNatureCode.indexOf(model.get("businessNatureCode"))<0){
        App.alert(agentname+"的代理许可证已于"+perenddate+"到期，需相关人员更新代理许可证方可继续出单");
        var url = window.location.pathname.split("/");
        var endorseFlag = url[url.length-1].split(".")[0];
        if(endorseFlag != "endorseSpecial"){//批改录入页面设置无代理协议时agentRate为0
            model.set("actual.saleaman",null);
            model.set("saleamanList",null);
        }else{
            model.set("actual.$newAgentRate", "newAgentRate");//设置代理到期标志newAgentRate
        }
    }else if(fastExpire<=15&&chooseBusinessNatureCode.indexOf(model.get("businessNatureCode"))<0){
        App.alert(agentname+"的代理许可证有效期将于"+perenddate+"到期，请通知相关人员及时更新代理许可证");
    }
    if(ctfsign==0&&!permitno){
        App.alert("代理人"+agentname+"两证不齐全，并且该代理没有老资格证，不能出单，请联系相关人员进行处理")
    }
};
//协议号规则判断
ContractEntity.prototype.saleAgreementRule=function (model,startdate,enddate,agentname,upagentname) {
    var newDate=new Date().getTime();
    var startdates=new Date(startdate).getTime();
    var enddates=new Date(enddate).getTime();
    var fastExpire;
    var url = window.location.pathname.split("/");
    var endorseFlag = url[url.length-1].split(".")[0];
    if(startdates>newDate){
        fastExpire=(enddates-newDate)/1000/60/60/24;
        App.alert(agentname+"的代理协议还未生效");
        if(endorseFlag != "endorseSpecial"){//非批改录入页面设置
            model.set("actual.saleAgreementNo",null)
        }else{
            model.set("actual.$newAgentRate","0");
        }
    }
    if(enddates<newDate){
        if(upagentname){
            App.alert(upagentname+"的代理协议已于"+enddate+"到期，需相关人员更新代理协议方可继续出单");
        }else {
            App.alert(agentname+"的代理协议已于"+enddate+"到期，需相关人员更新代理协议方可继续出单");
        }

        if(endorseFlag != "endorseSpecial"){//非批改录入页面设置
            model.set("actual.saleAgreementNo",null);
        }else{
            model.set("actual.$newAgentRate","newAgentRate");//设置批改录入代理到期标志newAgentRate
        }
    }else if(fastExpire<=15){
        if(upagentname){
            App.alert(upagentname+"的代理协议有效期将于"+enddate+"到期，请通知相关人员及时更新代理协议");
        }else {
            App.alert(agentname+"的代理协议有效期将于"+enddate+"到期，请通知相关人员及时更新代理协议");
        }

    }
};
//协议号、代理方案获取
ContractEntity.prototype.saleAgreementNoAndScheme=function (model,productCode) {
    //获取协议号
    $.ajax({
        url: "controller/contract/salesmanagement/agreementOut",
        type: "POST",
        data: JSON.stringify({
            classcode: productCode,
            agentcode: model.get("actual.saleaman"),
            businessnature: model.get("actual.businessNatureCode"),
            tid: model.get("actual.businessOffice")
        }),
        datatype: "json",
        contentType: "application/json",
        success: function (data) {
            if(JSON.stringify(data)!="{}"){
                var saleAgreementNoList=[];
                var agreementOutListBean = data.agreementOutListBean;
                if (agreementOutListBean.length==1) {
                    totleCostRate = "";
                    var url = window.location.pathname.split("/");
                    var endorseFlag = url[url.length-1].split(".")[0];
                    if(endorseFlag != "endorseSpecial") {//非批改录入页面agentRate为null
                        model.set("actual.agentRate", "");
                        model.set("actual.agentFee", "");
                        model.set("actual.agentNetFee","");
                        model.set("actual.agentTaxFee","");
                        model.set("actual.agentTaxRate","");
                    }
                    for (var i = 0; i < agreementOutListBean.length; i++) {
                        if(agreementOutListBean[i].isvalid=="2"){
                            App.alert("该协议正在修改后的待审核期，请联系相关人员尽快审核！")
                        }else {
                            model.set("actual.saleAgreementNo", agreementOutListBean[i].agreementno);
                            var a=/^[1tv]$/;
                            if(!a.test(model.get("actual.businessNatureCode"))){
                                contractEntity.saleAgreementRule(model,agreementOutListBean[i].startdate,agreementOutListBean[i].enddate,model.get("actual.saleamanName"),agreementOutListBean[i].upagentname);
                            }
                            //设置手续费整单税率
                            model.set("actual.agentTaxRate",(agreementOutListBean[i].pfee) * 100);
                            console.log(model.get("actual.agentTaxRate"));
                            if (agreementOutListBean[i].topcommission) {
                                //代理人和投保人是同一个人，或代理人和被保险人是同一个人时，手续费比例必须是0（即不给手续费）
                                var policeManArr=[];
                                var plcApplicantMan=model.get("actual.plcApplicant");//投保人
                                var plcInsureMan=model.get("actual.plcInsurant");//被保人
                                 plcApplicantMan.each(function(entity){
                                     policeManArr.push(entity.get("customerName"))
                                 });
                                 if(plcInsureMan && plcInsureMan.entityCount>0){
                                  plcInsureMan.each(function(entity){
                                      policeManArr.push(entity.get("customerName"))
                                  });
                                 }
                                
                                var salemanname=model.get("actual.saleamanName");
                                if(policeManArr.indexOf(salemanname)!=-1){
                                    model.set("actual.agentRate",0);
                                    totleCostRate=agreementOutListBean[i].topcommission;;
                                    cola.tag("agentClick").set("readonly", true);
                                }else{
                                    totleCostRate = agreementOutListBean[i].topcommission;

                                    var url = window.location.pathname.split("/");
                                    var endorseFlag = url[url.length-1].split(".")[0];
                                    if(endorseFlag == "endorseSpecial"){//批改录入页面设置代理协议agentRate，新值$newAgentRate
                                        if(model.get("actual.$newAgentRate")!="newAgentRate"){
                                            model.set("actual.$newAgentRate",agreementOutListBean[i].topcommission);
                                            model.set("actual.agentRate",model.get("actual.$rate"));
                                        }
                                    }
                                    else{
                                        model.set("actual.agentRate", agreementOutListBean[i].topcommission);
                                    }
                                    cola.tag("agentClick").set("readonly", false);
                                }
                                // //设置手续费比例为归属信息的比例之和
                                // handleRate = (agreementOutListBean[i].pfee) * 100;
                            }
                            contractEntity.rateGetAmount(model)
                        }
                    }
                   
                }else if(agreementOutListBean.length>1){
                    for(var i=0;i<agreementOutListBean.length;i++){
                        saleAgreementNoList.push(agreementOutListBean[i].agreementno);
                    }
                    model.set("saleAgreementNoList", saleAgreementNoList);
                    App.alert("此代理人有多条代理协议，请联系相关人员！");
                    cola.tag("agentClick").set("readonly", false);
                }else {
                    App.alert("此代理人无代理协议，请联系相关人员！");
                    cola.tag("agentClick").set("readonly", true);

                    var url = window.location.pathname.split("/");
                    var endorseFlag = url[url.length-1].split(".")[0];
                    if(endorseFlag != "endorseSpecial"){//批改录入页面设置无代理协议时agentRate
                        model.set("actual.agentRate",'');
                        model.set("actual.agentFee",'');
                        model.set("actual.agentNetFee",'');
                        model.set("actual.agentTaxFee",'');
                        model.set("actual.agentTaxRate","");
                    }else{
                        model.set("actual.$newAgentRate","0");
                    }

                }
            }
        }
    });
    //获取代理方案
    $.ajax({
        url: "controller/contract/salesmanagement/assignOut",
        type: "POST",
        data: JSON.stringify({
            riskcode: productCode,//险种代码
            agentcode: model.get("actual.saleaman"),//代理人代码
            depttype: model.get("actual.channelType"),//渠道类型
            bid: model.get("actual.businessOffice"),//归属部门
            businessnature: model.get("actual.businessNatureCode")//业务来源
        }),
        datatype: "json",
        contentType: "application/json",
        success: function (data) {
            if(JSON.stringify(data)!="{}"){
                var assignOutListBean=data.assignOutListBean;
                if(assignOutListBean.length>0){
                    model.set("schemeList", assignOutListBean);
                }
                //if(assignOutListBean.length==0&&model.get("actual.channelType")=="03"){
                //    var url = window.location.pathname.split("/");
                //    var endorseFlag = url[url.length-1].split(".")[0];
                //    //if(endorseFlag != "endorseSpecial"){//批改录入页面设置无代理协议时agentRate
                //    //    model.set("actual.agentRate",'');
                //    //    model.set("actual.agentFee",'');
                //    //}
                //}
            }
        }
    });
};
//读取身份证信息
ContractEntity.prototype.readyIdentypes = function(model,applicant){
    var CVR_IDCard = document.getElementById("CVR_IDCard");
    if(!CVR_IDCard.GetState){
        App.alert('无设备或设备连接异常');
        return;
    }else{
        var strReadResult = CVR_IDCard.GetState();
    }


    if(strReadResult != "0")
    {
        App.alert('无设备或设备连接异常');
        return;
    }
    var CVR_IDCard = document.getElementById("CVR_IDCard");
    var strReadResult = CVR_IDCard.ReadCardGPIC();
    var statusa = strReadResult.indexOf("<CardState>");
    var statusb = strReadResult.indexOf("</CardState>");
    var CardState = strReadResult.substring(parseInt(statusa)+11,parseInt(statusb))
    if(CardState=="-1"){
        App.alert('无设备或设备读取异常');
        return;
    }

    //身份证号
    var IdentifyNoStart = strReadResult.indexOf("<CardNo>");
    var IdentifyNoEnd = strReadResult.indexOf("</CardNo>");
    var IdentifyNo = strReadResult.substring(parseInt(IdentifyNoStart)+8,parseInt(IdentifyNoEnd));
    applicant.set("identifyNumber",IdentifyNo);
    if(applicant.get("customerFlag")=="1"){
        var nums = 0;
        $.each($('.insuranceindex'), function (insuranceindex, hiddenInputItem) {
            if ($(hiddenInputItem).val() != "" && (applicant.get("$insurantTotalIndex") == $(hiddenInputItem).val())) {
                nums = insuranceindex;
            }
        });
        if (applicant.get("identifyType") != null && applicant.get("identifyNumber") != null) {
            cola.tag("buttonBan")[nums].set("disabled", false);
        } else {
            cola.tag("buttonBan")[nums].set("disabled", true);
        }
    }


    //姓名
    var NameStart = strReadResult.indexOf("<Name>");
    var NameEnd = strReadResult.indexOf("</Name>");
    var Name = strReadResult.substring(parseInt(NameStart)+6,parseInt(NameEnd));
    applicant.set("customerName",Name);

    //证件有效期限
    var Date1Start = strReadResult.indexOf("<UserLifeStart>");
    var Date1End = strReadResult.indexOf("</UserLifeStart>");
    var Date1 = strReadResult.substring(parseInt(Date1Start)+15,parseInt(Date1End));


    var Date2Start = strReadResult.indexOf("<UserLifeEnd>");
    var Date2End = strReadResult.indexOf("</UserLifeEnd>");
    var Date2 = strReadResult.substring(parseInt(Date2Start)+13,parseInt(Date2End));
    applicant.set("identifyEffectiveEndDate",Date2);

    //性别
    var SexStart = strReadResult.indexOf("<Sex>");
    var SexEnd = strReadResult.indexOf("</Sex>");
    var Sex = strReadResult.substring(parseInt(SexStart)+5,parseInt(SexEnd));
    applicant.set("plcCustomer.sex",Sex);
    if (Sex=='1') {
        applicant.set("plcCustomer.sexName","男性");
    }else if(Sex=='2'){
        applicant.set("plcCustomer.sexName","女性");
    }



    //出生日期
    var BirthDateStart = strReadResult.indexOf("<Born>");
    var BirthDateEnd = strReadResult.indexOf("</Born>");
    var BirthDate = strReadResult.substring(parseInt(BirthDateStart)+6,parseInt(BirthDateEnd));
    applicant.set("plcCustomer.birthDate",BirthDate);

    //家庭地址
    var AddressStart = strReadResult.indexOf("<Address>");
    var AddressEnd = strReadResult.indexOf("</Address>");
    var Address = strReadResult.substring(parseInt(AddressStart)+9,parseInt(AddressEnd));
    applicant.set("plcCustomer.address",Address);
}

ContractEntity.prototype.submitFunctionSuccess = function(model){
    var modeldata = model.get("actuals").toJSON(),arr = [],sendFlags=0,successflag=true;
    $.each(modeldata,function(i,v){
        if(modeldata[i].plcApplicant){
            $.each(modeldata[i].plcApplicant,function(j,m){
                arr.push(m)
            })
        }
        if(modeldata[i].plcInsurant){
            $.each(modeldata[i].plcInsurant,function(c,n){
                if (n.sameFlag == 0 && n.identifyType && n.identifyNumber) {
                    arr.push(n)
                }
            })
        }
    })
    $.ajax({
        url:"controller/risksurvey/ecifClient/saveCustomer?sysId=B102&interruptFlag=1",
        async:false,
        type:"post",
        contentType:"application/json",
        data:JSON.stringify(arr),
        success:function(data){
            if(data){
                $.each(data,function(i,v){
                    if(data[i].responseCode!=1){
                        if(data[i].ecifInfo.indexOf("REGIST_ID")!=-1){
                            App.alert(data[i].customerKey+"-请点击客户信息查询按钮");
                        }else if(data[i].ecifInfo.indexOf("该证件已被其他当事方占用或该源系统当事方已存在")!=-1){
                            App.alert(data[i].customerKey+"-该证件已被其他当事方占用或该源系统当事方已存在,请点击客户信息查询按钮");
                        }else{
                            App.alert(data[i].ecifInfo+":"+data[i].customerKey);
                        }
                        sendFlags = 0;
                        return true;
                    }else{
                        model.get("actuals").each(function(actual){
                            actual.get("plcApplicant").each(function(applicant){
                                if(applicant.get("customerName")+"_"+applicant.get("identifyType")+"_"+applicant.get("identifyNumber")==data[i].customerKey){
                                    if(data[i].customerCode){
                                        applicant.set("customerCode",data[i].customerCode);
                                    }
                                    if(data[i].registId){
                                        applicant.set("registId",data[i].registId);
                                    }

                                }
                            })
                            if(actual.get("plcInsurant")){
                                actual.get("plcInsurant").each(function(applicant){
                                    if(applicant.get("customerName")+"_"+applicant.get("identifyType")+"_"+applicant.get("identifyNumber")==data[i].customerKey){
                                        if(data[i].customerCode){
                                            applicant.set("customerCode",data[i].customerCode);
                                        }
                                        if(data[i].registId){
                                            applicant.set("registId",data[i].registId);
                                        }

                                    }
                                })
                            }
                        });
                        sendFlags++;
                    }
                })
                if(sendFlags==data.length){
                    successflag= true;
                }else{
                    successflag=false;
                }
            }
        },
        error:function(msg){
            successflag=false;
            return false;
        }
    });

    return successflag;
}

//特约拆分
ContractEntity.prototype.syncEngageFromPage=function(model){
    model.get("actuals").each(function(actualItem){
        model.set("actual",actualItem);
        if(actualItem.get("plcSolution")&&actualItem.get("plcSolution").entityCount>0){
            actualItem.get("plcSolution").each(function(solutionEntity){
                _syncEngageFromPageItem(model,solutionEntity);
                if(solutionEntity.get("_pageEngage")){
                    solutionEntity.get("_pageEngage").each(function(_pageEngageItem){
                        _pageEngageItem.state = "NONE";
                    });
                }
            });
        }
    });
}

function _syncEngageFromPageItem(model,solutionEntity){
        var pageEngage= solutionEntity.get("_pageEngage");
        if(pageEngage&&pageEngage.entityCount>0){
            pageEngage.each(function(pageEngageItem){
                //状态为state不进行变更
                if(pageEngageItem.state=="NONE"){
                    return;
                }
                var pageEngageItemCode = pageEngageItem.get("especialCode");
                var pageEngageItemName = pageEngageItem.get("especialName");
                var isAutogeneRateType = pageEngageItem.get("isAutogeneRateType");
                var isAutoGenerate = pageEngageItem.get("isAutoGenerate");
                var pageEngageContentArr = _substringArr(pageEngageItem.get("especialClauses"));
                if(!pageEngageItem.get("$oldArr")){
                    pageEngageItem.set("$oldArr",[]);
                }
                var plcEngageArr = pageEngageItem.get("$oldArr");

                //字符减少需要removeRoll
                if(plcEngageArr.length>pageEngageContentArr.length){
                    var objActualIdArr =[];
                    var needRemoveEntityArr=[];
                    $.each(plcEngageArr,function(index,item){
                        if(Number(index+1)>pageEngageContentArr.length){
                            objActualIdArr.push(item.get("actualId"));
                            needRemoveEntityArr.push(item);
                        }
                    });
                    contractEntity.removeRoles(model,objActualIdArr,function(){
                        //plcEngage删除
                        $.each(needRemoveEntityArr,function(index,entity){
                            entity.remove();
                        })
                        _syncEngageEntityItem(model,solutionEntity,pageEngageContentArr,plcEngageArr,pageEngageItemCode,pageEngageItemName,isAutogeneRateType,isAutoGenerate);
                    },false);
                }else{
                    _syncEngageEntityItem(model,solutionEntity,pageEngageContentArr,plcEngageArr,pageEngageItemCode,pageEngageItemName,isAutogeneRateType,isAutoGenerate);
                }
            });
    }
}
function _syncEngageEntityItem(model,solutionEntity,pageEngageContentArr,plcEngageArr,especialCode,especialName,isAutogeneRateType,isAutoGenerate){
    var addRollArr=[];
    $.each(pageEngageContentArr,function(index,pageEngageContentItem){
        if(plcEngageArr.length>=Number(index+1)){//替换数据
            //如果数据不一致，进行替换
            if(plcEngageArr[index].get("especialClauses")!=pageEngageContentItem||plcEngageArr[index].get("especialCode")!=especialCode||plcEngageArr[index].get("especialName")!=especialName)
            {
                plcEngageArr[index].set("especialClauses",pageEngageContentItem);
                plcEngageArr[index].set("especialCode",especialCode);
                plcEngageArr[index].set("especialName",especialName);
                if(isAutogeneRateType) {plcEngageArr[index].set("isAutogeneRateType",isAutogeneRateType);}
                plcEngageArr[index].set("isAutoGenerate",isAutoGenerate);
            }
        }
        else//addRoll
        {
            var tempObj={
                especialClauses:pageEngageContentItem,
                especialCode:especialCode,
                especialName:especialName,
                isAutoGenerate:isAutoGenerate
            }
            if(isAutogeneRateType){tempObj.isAutogeneRateType=isAutogeneRateType;}
            addRollArr.push(tempObj);
        }
    });
    if(addRollArr.length>0){
        contractEntity.addRoles(solutionEntity, model,"plcEngage",addRollArr,function (newEntity, responseData) {
        },false).done(function(){
            var engage=solutionEntity.get("plcEngage");
            if(engage){
                var _engageMapping={};
                engage.each(function(entity,index){
                    //处理内容序号especialClausesSerialNo，同一个特约编码的特约条目内容序号递增
                    if(_engageMapping[entity.get("especialCode")]){
                        var _ind=_engageMapping[entity.get("especialCode")].length+1;
                        _engageMapping[entity.get("especialCode")].push(_ind);
                        entity.set("especialClausesSerialNo",_ind);
                    }else{
                        _engageMapping[entity.get("especialCode")]=[1];
                        entity.set("especialClausesSerialNo",1);
                    }
                    entity.set("serialNo",index+1);
                })
            }
            //重新构建$oldArr
            _createOldEngageArr(solutionEntity);
        });
    }else{
        //重新构建$oldArr
        _createOldEngageArr(solutionEntity);
    }
}
//根据字符串长度截取数组拆分roll
function _substringArr(value){
    var arr=[];
    if(!value)return "";
    var splitLen=400;
    while(value.length>splitLen){
        arr.push(value.substring(0,splitLen));//放到数组里
        value=value.substring(splitLen);
    }
    if(value.length>0){
        arr.push(value.substring(0,splitLen));
    }
    return arr;
}
//重构$oldArr
function _createOldEngageArr(solutionEntity){
    var _plcEngageMap={};
    solutionEntity.get("plcEngage").each(function(engageItem,index){
        if(!_plcEngageMap[engageItem.get("especialCode")]) {
            _plcEngageMap[engageItem.get("especialCode")]=[engageItem];
        }else{
            _plcEngageMap[engageItem.get("especialCode")].push(engageItem);
        }
    });
    solutionEntity.get("_pageEngage").each(function(engageItem){
        engageItem.set("$oldArr", _plcEngageMap[engageItem.get("especialCode")]);
    });
}

/**
 * 转换GTM+8
 * @param timestmp
 * @returns {Date}
 */
ContractEntity.prototype.toBeiJingDate = function(timestmp){
    var d = new Date(timestmp);
    utc = timestmp + d.getTimezoneOffset() * 60000,   //获得当地时间偏移的毫秒数计算UTC时间
        beiJingTime = utc + (3600000 * 8);  // (60m * 60s * 1000 ms )* 8  根据UTC计算北京时间
    // console.log("当前时间：" + d);
    // console.log("北京时间：" + new Date(beiJingTime));
    return new Date(beiJingTime);
}

//根据归属部门请求税优接口
ContractEntity.prototype.getNoTaxRateClause=function(businessOffice,classCode,productCode,model,isInsuranceGroup){
	$.ajax({
    	url:"controller/contract/cfgStructureClauseController/getCfgStructureClauseList?businessOffice="+businessOffice+"&classCode="+classCode+"&productCode="+productCode,
    	type:"post",
    	async:false,
    	success:function(data){
    		if(data && data.length>=0){
    			var dataObj={};
    			for(var i=0;i<data.length;i++){
    				dataObj[data[i].clauseCode]=data[i].taxRate;
    			}
    			contractEntity.setNoTaxRateList(dataObj);
    			// 是否是选择定额方案
                var solutionEntity = model.get("actual.plcSolution").current;
    			//如果存在可税优的条款并且，当前保单存在条款的时候，需要去修改条款及条责标的税优
    			var plcPackage=model.get("actual.plcSolution").current.get("plcPackage").current;
    			if(dataObj && plcPackage.get("plcMainClause") && plcPackage.get("plcMainClause").entityCount>0){
    				plcPackage.get("plcMainClause").each(function(mainClause){
    					var mainTaxRate=contractEntity.getTaxRate(mainClause.get("clauseCode"),model);
    					mainClause.set("$taxRate",mainTaxRate);
    					if(mainClause.get("plcClauseItem") && mainClause.get("plcClauseItem").entityCount>0){
    						mainClause.get("plcClauseItem").each(function(mainClauseItem){
    							mainClauseItem.set("taxRate",mainTaxRate);
    							// 定额方案的不触发汇率反算
                                if(!solutionEntity.get("solutionTemplateCode")){//定额方案
                                    if(isInsuranceGroup==="1"){
                                        contractEntity.GrouppremiumCalculation(model,mainClauseItem);
                                    }else{
                                        contractEntity.premiumCalculation(model,mainClauseItem);
                                    }
                                }
    						})
    					}
    					if(mainClause.get("plcAccessoryClause") && mainClause.get("plcAccessoryClause").entityCount>0){
    						mainClause.get("plcAccessoryClause").each(function(addClause){
    							var addTaxRate=contractEntity.getTaxRate(addClause.get("clauseCode"),model);
    							addClause.set("$taxRate",addTaxRate);
    							if(addClause.get("plcClauseItem") && addClause.get("plcClauseItem").entityCount>0){
    								addClause.get("plcClauseItem").each(function(addClauseItem){
    									addClauseItem.set("taxRate",addTaxRate);
    									// 定额方案的不触发汇率反算
                                        if(!solutionEntity.get("solutionTemplateCode")){//定额方案不校验
                                            if(isInsuranceGroup==="1"){
                                                contractEntity.GrouppremiumCalculation(model,addClauseItem);
                                            }else{
                                                contractEntity.premiumCalculation(model,addClauseItem);
                                            }
                                        }
            						})
            					}
    						})
    					}
    				})
    				if(isInsuranceGroup!="1"){
	    				$(".savePolicy").addClass("disabledSave");
	                    $(".submitPolicy").addClass("disabledSave");
	                    $("#qqSubBtn").attr("disabled",true);
	                    $("#qqSaveBtn").attr("disabled",true);
	                    $("#qqSubBtn").attr("title","请先计算保费");
	                    $("#qqSaveBtn").attr("title","请先计算保费");
                   }
          }
        }
      }
    })
}
//校验投保人与被保人有无点击查询展开
ContractEntity.prototype.plcinstshowhideflagfunction = function(){
    var plcinstshowhideflag = true;
    if($("#navMain").find(".grpCustomerApplicant").hasClass("display-none")==true&&$("#navMain").find(".selfCustomerApplicant").hasClass("display-none")==true){
        App.alert("请点击投保人客户信息查询");
        plcinstshowhideflag =false;
        return false;
    }
    $("#navMain").find(".selfCustomer").each(function(i,v){
        if($(this).hasClass("display-none")==true&&$("#navMain").find(".grpCustomer").eq(i).hasClass("display-none")==true){
            App.alert("请点击被保人"+(i+1)+"客户信息查询");
            plcinstshowhideflag =false;
            return false;
        }
    });
    return  plcinstshowhideflag;
}
/**
 * 两位精度运算
 */
ContractEntity.prototype.formatToTwoPrecision=function(num){
    var result;
    if(num == null || num == "" || num == "null"){
        return 0.00;
    }
    var floatNum=num.toString().split('.')[1];
    if(floatNum&&floatNum.length==3&&floatNum.substring(2,3)=='5'){
        num=num+'01';//处理“xx.925四舍五入错误的问题”
    }
    result=Math.round(num*100)/100;
  return result;
}


/**
 * 缴费计划起止时间
 * @param {any} applicantDateTime  投保日期
 * @param {any} startTime 起保日期
 * @param {any} endTime 终保日期
 * @param {any} tempEntity 当前缴费期次对象
 * @param {any} tempEntityList  缴费期次 list
 * @param {any} payPlanCount 缴费期次数量
 * @param {any} i 
 */
ContractEntity.prototype.plcPlanDate=function(applicantDateTime,startTime,endTime,tempEntity,tempEntityList,payPlanCount,i){
  var nowTime=new Date();
  var starEndPlus = (endTime.getTime() - startTime.getTime()) / 86400000 + 1;
    var intervalDay = Math.floor(starEndPlus / payPlanCount);//每一期缴费时间间隔
  if (i == 0) {// 第一期缴费计划
        // 起保日期等于当前日期 或者 起保日期小于当前日期时
    if((startTime.getFullYear()==nowTime.getFullYear()&&startTime.getMonth()==nowTime.getMonth()&&startTime.getDate()==nowTime.getDate())||startTime<nowTime){
      tempEntity.startPayDate=new Date(applicantDateTime);
          tempEntity.endPayDate=new Date(applicantDateTime);
    }else{
      tempEntity.startPayDate=new Date(applicantDateTime);
      tempEntity.endPayDate.setMonth(startTime.getMonth());
          tempEntity.endPayDate.setFullYear(startTime.getFullYear());
          tempEntity.endPayDate.setDate(startTime.getDate() - 1);
        }
        
        // 设置 止期 23:59:59
        tempEntity.endPayDate.setHours(23);
        tempEntity.endPayDate.setMinutes(59);
        tempEntity.endPayDate.setSeconds(59);
    } else {// 第二期之后的缴费计划
        if(intervalDay>15){
            tempEntity.startPayDate.setMonth(tempEntityList[i - 1].endPayDate.getMonth());
            tempEntity.startPayDate.setFullYear(tempEntityList[i - 1].endPayDate.getFullYear());
            tempEntity.startPayDate.setDate(tempEntityList[i - 1].endPayDate.getDate() + intervalDay - 15);
            tempEntity.endPayDate.setMonth(tempEntity.startPayDate.getMonth());
            tempEntity.endPayDate.setFullYear(tempEntity.startPayDate.getFullYear());
            tempEntity.endPayDate.setDate(tempEntity.startPayDate.getDate() + 15);
        }else{
            tempEntity.startPayDate.setMonth(tempEntityList[i - 1].endPayDate.getMonth());
            tempEntity.startPayDate.setFullYear(tempEntityList[i - 1].endPayDate.getFullYear());
            tempEntity.startPayDate.setDate(tempEntityList[i - 1].endPayDate.getDate());
            tempEntity.endPayDate.setMonth(tempEntity.startPayDate.getMonth());
            tempEntity.endPayDate.setFullYear(tempEntity.startPayDate.getFullYear());
            tempEntity.endPayDate.setDate(tempEntity.startPayDate.getDate() + intervalDay);
        }
        // 设置起期固定为0：0:0 止期 23:59:59
        tempEntity.startPayDate.setHours(0);
        tempEntity.startPayDate.setMinutes(0);
        tempEntity.startPayDate.setSeconds(0);
        tempEntity.endPayDate.setHours(23);
        tempEntity.endPayDate.setMinutes(59);
        tempEntity.endPayDate.setSeconds(59);
    }
}
//当被保人和代理人为同一人时，手续费比例必须是0
ContractEntity.prototype.salemanAndInsurantAgent=function(model){
    // boole----true为被保人    false为投保人
    // var policeManArr=[];
    // var salemanname=model.get("actual.saleamanName");
    // if(!salemanname){
    //     salemanname=model.get("actuals").current.get("saleamanName");
    // }
    // var plcApplicantMan=model.get("actuals").current.get("plcApplicant");//投保人
    // var plcInsureMan=model.get("actual.plcInsurant");//被保人
    // if(!plcInsureMan){
    //     plcInsureMan=model.get("actuals").current.get("plcInsurant")
    // }
    // if(plcApplicantMan){
    //     plcApplicantMan.each(function(entity){
    //         policeManArr.push(entity.get("customerName"));
    //     });
    // }
    // if(plcInsureMan){
    //     plcInsureMan.each(function(entity){
    //         policeManArr.push(entity.get("customerName"));
    //     });
    // }
    //
    // if(salemanname && salemanname!= undefined && salemanname!=null && salemanname!=''){
    //     if(policeManArr.indexOf(salemanname)!=-1){
    //         if(!boole){
    //             model.get("actuals").current.set("agentRate",0);
    //         }else{
    //             model.set("actual.agentRate",0);
    //         }
    //         contractEntity.rateGetAmountEachPro(model);
    //         cola.tag("agentClick").set("readonly", true);
    //     }else{
    //         if(!boole){
    //             model.get("actuals").current.set("agentRate",totleCostRate);
    //             contractEntity.rateGetAmountEachPro(model);
    //         }else{
    //             model.set("actual.agentRate",totleCostRate);
    //         }
    //         contractEntity.rateGetAmount(model);
    //         cola.tag("agentClick").set("readonly", false);
    //     }
    // }
    if(model.get("actuals")){
        model.get("actuals").each(function(actual){
            var policeManArr=[];
            var salemanname=actual.get("saleamanName");
            var plcApplicantMan=actual.get("plcApplicant");//投保人
            var plcInsureMan=actual.get("plcInsurant");//被保人
            if(plcApplicantMan){
                plcApplicantMan.each(function(entity){
                    policeManArr.push(entity.get("customerName"));
                });
            }
            if(plcInsureMan){
                plcInsureMan.each(function(entity){
                    policeManArr.push(entity.get("customerName"));
                });
            }
            if(salemanname && salemanname!= undefined && salemanname!=null && salemanname!=''){
                if(policeManArr.indexOf(salemanname)!=-1){
                    actual.set("agentRate",0);
                    contractEntity.rateGetAmountEachPro(model);
                    cola.tag("agentClick").set("readonly", true);
                }else{
                  var agentRate=actual.get("agentRate");
                    if(agentRate||agentRate==0){
                        actual.set("agentRate",agentRate );
                    }else{
                        actual.set("agentRate",totleCostRate );
                    }
                    contractEntity.rateGetAmountEachPro(model);
                    cola.tag("agentClick").set("readonly", false);
                }
            }
        })
    }


}
ContractEntity.prototype.rateGetAmountEachPro = function (model) {
    if(model.get("actuals")){
        model.get("actuals").each(function(actual){
            // 手续费金额＝不含税总保费＊手续费比例
            var allAmount = actual.get("netPremium");//不含税总保费
            var agentTaxRate=actual.get("agentTaxRate");//手续费税率
            var agentRates = actual.get("agentRate");//手续费比例
            //不含税手续费金额=含税手续费金额/(1+税率/100)
            if ((allAmount || allAmount == 0) && (agentRates || agentRates == 0)) {
                //var agentAmounts = Number((allAmount * agentRates / 100).toFixed(2));
                //var agentAmounts =  Math.round((allAmount * agentRates / 100)*100)/100;//手续费取四舍五入取两位
                var agentAmounts = contractEntity.formatToTwoPrecision(allAmount * agentRates / 100);//手续费取四舍五入取两位
                actual.set("agentFee", agentAmounts);//手续费含税金额
                if(agentTaxRate||agentTaxRate==0){
                    var agentNetFee=contractEntity.formatToTwoPrecision(actual.get("agentFee")/(1+agentTaxRate/100));
                    actual.set("agentNetFee", agentNetFee);//手续费不含税金额
                    console.log(actual.get("agentNetFee")+"-----手续费不含税金额");
                    var agentTaxFee=contractEntity.formatToTwoPrecision(actual.get("agentFee")-actual.get("agentNetFee"));
                    actual.set("agentTaxFee", agentTaxFee);//手续费税额
                    console.log(actual.get("agentTaxFee")+"-----手续费税额");
                }


            }
        })
    }


};
//业务归属必填项显示隐藏校验
ContractEntity.prototype.businessChecjks=function (model,lifrReplace,justMelt) {
    //归属部门所在省接口请求
    contractEntity.superiorInstitution(model,true,!justMelt.test(model.get("actual.businessNatureCode")));
    //业务来源为寿代产
    if (lifrReplace.test(model.get("actual.businessNatureCode"))) {
        App.setFieldVisible(model.$(".handlerNameCode"), true, false);
    } else {
        App.setFieldVisible(model.$(".handlerNameCode"), false, true);
    }
    //业务来源为销售代产
    if (model.get("actual.businessNatureCode") == "m") {
        App.setFieldVisible(model.$(".identificationCode"), true, false);
    } else {
        App.setFieldVisible(model.$(".identificationCode"), false, true);
    }
    //业务来源为直销业务
    if (justMelt.test(model.get("actual.businessNatureCode"))) {
        App.setFieldVisible(model.$(".justMelt"),false,true);
    } else {
        App.setFieldVisible(model.$(".justMelt"),true,false);
    }
};

//获取基础代码转化格式方法
ContractEntity.prototype.getFindcodesfunctions = function(data){
    if(data!=""||data!=undefined){
        var str = JSON.parse(data.split(/[;=]/)[1]);
        return str;
    }
}

//检测手续费结余是否足够
ContractEntity.prototype.validateCostPlanFee = function(model,callback){
    $.ajax({
        url:"controller/contract/cost/costPlan/applyPlyValidate?actualId="+model.get("actuals.actualId"),
        type:"post",
        async: true,
        contentType:"application/json",
        success:function(data){
            if(!data.flag){
                App.alert(data.message);
            }else if(callback){
                callback();
            }else{
            	return data;
            }
        },
        error:function(msg){
            App.alert(msg);
        }
    });
}

//设置条责标级别的endTime和startTime -> （为了复制的单子保费计算）
ContractEntity.prototype.setClauseTime = function(model){
    if( model && model.get("actuals") ){
        model.get("actuals").each(function(actual){
            var startTime = actual.get("startTime");
            var endTime = actual.get("endTime");
    
            if( actual.get("plcSolution") ){//方案
                actual.get("plcSolution").each(function(solution){
                    if( solution.get("plcPackage") ){//package
                        solution.get("plcPackage").each(function(package){
                            if( package.get("plcMainClause") ){//主条款
                                package.get("plcMainClause").each(function(main){
                                    if( main.get("plcClauseItem") ){//主条款条责标
                                        main.get("plcClauseItem").each(function(clause){
                                            if( !clause.get("startTime") ){
                                                clause.set("startTime",startTime);
                                            }
                                            if( !clause.get("endTime") ){
                                                clause.set("endTime",endTime);
                                            }
                                        })
                                    }
                                    if( main.get("plcAccessoryClause") ){//附加条款
                                        main.get("plcAccessoryClause").each(function(accessory){
                                            if( accessory.get("plcClauseItem") ){//附加条款条责标
                                                accessory.get("plcClauseItem").each(function(clause){
                                                    if( !clause.get("startTime") ){
                                                        clause.set("startTime",startTime);
                                                    }
                                                    if( !clause.get("endTime") ){
                                                        clause.set("endTime",endTime);
                                                    }
                                                })
                                            }
                                        })
                                    }
                                })
                            }
                        })
                    }
                })
            }
        })
    }
    
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
//根据保单数据自动生成特约，在保费计算时调用，因为要先执行暂存保存数据，所以在保费计算后执行暂存中调用
//controller/productspecial/specialRule/getAutoGenerateSpecials?actualId=XX
    ContractEntity.prototype.autoCreatePlcEngage=function(model){
        model.get("actuals").each(function(actual){
            $.ajax({
                url:"controller/productspecial/specialRule/getAutoGenerateSpecials?actualId="+actual.get("actualId"),
                type:"post",
                contentType:"application/json",
                success:function(data){
                    if(!data)return;
                    data.forEach(function(autoItem){
                        var isCreate=false;
                        actual.get("plcSolution._pageEngage").each(function(_pageEngageItem){
                            if(_pageEngageItem.get("especialCode")==autoItem.productCode){//已有该特约
                                isCreate=true;
                                if(autoItem.editType!="C"){//可编辑类型的自动生成的特约不需要覆盖
                                    _pageEngageItem.set("especialClauses",autoItem.content);//覆盖原特约内容
                                }
                            }
                        });
                        if(!isCreate){
                            actual.get("plcSolution._pageEngage").insert({
                                especialCode:autoItem.productCode,
                                especialName:autoItem.name,
                                especialClauses:autoItem.content,
                                $oldArr:[],
                                isAutogeneRateType:autoItem.editType,//自动生成的特约类型
                                isAutoGenerate:"1"//是否自动生成的特约
                            });
                        }
                    });
                },
                error:function(msg){
                }
            });

        });



    };

//高亮显示
ContractEntity.prototype.compareAddMessage=function(model,changeList){
    if(changeList){
        for(var key in changeList){
            if(key=="changeStatus")break;
            var stringValueArr=key.split('.');
            var propName=stringValueArr.pop();
            var currentEntity;
            var pageApplicant =cola.widget("applicantSub").get("contentModel").get("pageApplicant").current;
            var pageBasicInfo =cola.widget("basInfoSub").get("contentModel").get("pageBasicInfo");
            if(stringValueArr.length==1&&pageBasicInfo.get(propName)!==undefined){//需要额外处理脱离模型的基本信息的页面entity
                currentEntity = pageBasicInfo;
            }else{
                $.each(stringValueArr,function(index,pathItem){
                    if(index==0){
                        //需要额外处理脱离模型的投保人页面entity
                        if(stringValueArr[1]=="plcApplicant"){
                            currentEntity = pageApplicant;
                        }
                        else{
                            currentEntity = model.get(pathItem);
                        }

                        return;
                    }else if(index==1&&pathItem=="plcApplicant"){//投保人时过滤掉plcApplicant这一级
                        return;
                    }
                    if(pathItem.indexOf(']')>-1){//有下标
                        //正则可能会造成发布时jade编译报错,先使用split处理
                        var pathItemArr=pathItem.split('[');
                        pathItem = pathItemArr[0];
                        var pathItemIndex=pathItemArr[1].split(']')[0];
                        var entityList = currentEntity.get(pathItem);
                        entityList.each(function(entityItem,index){
                            if (index == pathItemIndex) {
                                currentEntity=entityItem;
                                return false;
                            }
                        });
                    }else{//无下标
                        if(currentEntity.get(pathItem) instanceof cola.Entity)	{
                            currentEntity=currentEntity.get(pathItem);
                        }else{
                            currentEntity=currentEntity.get(pathItem).first();
                        }
                    }
                })
            }

            currentEntity.addMessage(propName,{type:"warn",text:"原值:"+changeList[key],sticky:true});


        }
    }
//需要处理field下c-input额外bind导致warn样式无法附加到input的情况，例如手机号中间四位变星号，以及下拉框显示text与原值显示的code
};

var contractEntity = new ContractEntity();





