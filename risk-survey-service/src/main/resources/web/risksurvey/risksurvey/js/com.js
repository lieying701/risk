cola(function (model) {
	model.set("policyCode1", [
        {"serialNo":"1","taskNo":"20193094","risksurveyDep":"风控部","startTime":"2018-09-09","status":"未提交","applicant":"小李","product":"0101","businessNo":"20392032"},
        {"serialNo":"2","taskNo":"20193094","risksurveyDep":"风控部","startTime":"2018-09-09","status":"已提交","applicant":"小wq","product":"0101","businessNo":"20392032"},
        {"serialNo":"3","taskNo":"20193094","risksurveyDep":"风控部","startTime":"2018-09-09","status":"创建中","applicant":"小ew","product":"0101","businessNo":"20392032"},
        {"serialNo":"4","taskNo":"20193094","risksurveyDep":"风控部","startTime":"2018-09-09","status":"未分派","applicant":"小fre","product":"0101","businessNo":"20392032"},
        {"serialNo":"5","taskNo":"20193094","risksurveyDep":"风控部","startTime":"2018-09-02","status":"下发修改","applicant":"小vf","product":"0101","businessNo":"20392032"},
        {"serialNo":"6","taskNo":"20193094","risksurveyDep":"风控部","startTime":"2018-09-04","status":"未提交","applicant":"小vfd","product":"0101","businessNo":"20392032"},
        {"serialNo":"7","taskNo":"20193094","risksurveyDep":"风控部","startTime":"2018-09-01","status":"未提交","applicant":"小vfd","product":"0101","businessNo":"20392032"},
        {"serialNo":"8","taskNo":"20193094","risksurveyDep":"风控部","startTime":"2018-09-06","status":"未提交","applicant":"小vvvvvvfd","product":"0101","businessNo":"20392032"}
    ])
    //查询域数据类型
    model.dataType({
        name: "QueryCondition",
        properties: {
        	surveyId: {
                caption: "[(#{surveyId})]",
                dataType: "string"
            },
            taskType: {
                caption: "[(#{taskType})]",
                dataType: "string"
            },
            product: {
                caption: "[(#{product})]",
                dataType: "string"
            },
            productName: {
                caption: "[(#{productName})]",
                dataType: "string"
            },
            surveyer: {
                caption: "[(#{surveyer})]",
                dataType: "string"
            },
            status: {
                caption: "[(#{status})]",
                dataType: "string"
            },
            surveyerDivision: {
                caption: "[(#{surveyerDivision})]",
                dataType: "string"
            },
            businessNo: {
                caption: "[(#{businessNo})]",
                dataType: "string"
            },
            plateNo: {
                caption: "[(#{plateNo})]",
                dataType: "string"
            },
            customerName: {
                caption: "[(#{customerName})]",
                dataType: "string"
            },
            surveyerDate: {
                caption: "[(#{surveyerDate})]",
                dataType: "date"
            },
            reportProduceDate: {
                caption: "[(#{reportProduceDate})]",
                dataType: "date"
            },
            customerName: {
                caption: "[(#{customerName})]",
                dataType: "string"
            },
            taskStarterDate: {
                caption: "[(#{taskStarterDate})]",
                dataType: "date"
            }

        }
    });

    //查询域数据设置
    model.describe("queryCondition", "QueryCondition");
    model.set("queryCondition", {

    });
    //数据展示列表数据设置
    model.describe("policyCode", {
        dataType: "QueryCondition",
        provider: {
            url: "controller/risksurvey/query/comprehensive?from={{$from}}&limit={{$limit}}",
            pageSize: 10,
            sendJson: true,
            parameter: "{{queryCondition}}",
            response:function (self,arg) {
            	debugger;
                var result=arg.result;
                console.log(result);
                if(result.data$){
                    for(var i=0;i<result.data$.length;i++){
                        //result.data$[i].businessStatus=changeStatus(result.data$[i].businessStatus);
                        arg.result=result;
                    }
                }
            }
        }
    });

    //监控enter键按下弹起事件
    $(document).keyup(function(e) {
        // 回车键事件
        if(e.which == 13) {
            model.action("query")();
        }
    });

    model.action({

    	queryTask: function () {

            //var proposalNo = model.get("queryCondition.proposalNo");
            //check();
            model.flush("policyCode");
        },
        reset: function () {//重置
            model.set("queryCondition", {});
            model.flush("policyCode");
        },
        goToDetail:function(item){//打开对应的详情页
            debugger;
            var specId = item.get("specId");
            var actualId = item.get("actualId");
            var productCode = item.get("productCode");
            var viewFlag = "true";//从保单中心-保单查询进入的标志
            var isGroup = item.get("groupPolicyFlag");
            var anonymousFlag = item.get("anonymousFlag");
            var url1 = "policycenter/base/comprehensiveDetail.html?specId="+specId+"&actualId="+actualId+"&productCode="+productCode+"&viewInquiryFlag="+viewFlag+"&isInsuranceGroup="+isGroup+"&anonymousFlag="+anonymousFlag;
            contractEntity.openIframePage("综合查询详情",url1);
        },
        batchPrint:function(){
            cola.alert("please choose one");
            var obj=model.get("policyCode").current;
            var flag = obj.get("blockTypeSelect");
            if(!flag){
                cola.alert("please choose one");
                return false;
            }
        }


    });
    //将对应业务状态转成中文
    function changeStatus(status){
        switch(status){
        case "01":
            return "初始";
            break;
        case "02":
            return "录入中";
            break;
        case "03":
            return "退回修改";
            break;
        case "04":
            return "审核中";
            break;
        case "05":
            return "审核通过";
            break;
        case "06":
            return "已签发";
            break;
        case "10":
            return "撤单";
            break;
        case "11":
            return "拒保";
            break;
        case "12":
            return "全单退保";
            break;
        case "13":
            return "保单注销";
            break;
        default:
            break;
        }
    };
    function check(proposalNo){

        alert(model.get("queryCondition"));

        cola.alert("[(#{proposalNo})]", {
            level: cola.MessageBox.level.INFO
        });
    }

    //综合查询接受刷新标识
    $(window).on("message",function(evt){
        if(evt.originalEvent.data=="freshen"){
            model.flush("policyCode");
        }
    })

});



