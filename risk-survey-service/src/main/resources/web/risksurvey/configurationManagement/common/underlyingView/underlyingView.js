cola(function(model){
    model.describe("riskPrompt",{
        provider:{
            url:"policycenter/uw/data/riskPrompt.json"
        }
    })
    model.describe("findUWRiskAccumulationByObjectNo",{
        provider:{
            url:"controller/uw/subject/findUWRiskAccumulationByObjectNo?objectNo=666666",
            loadMode: "manual",
            method:"GET",
            response:function(self,arg) {
                var result=arg.result;
                for(var i=0;i<result.length;i++){

                }
                arg.result=result;
            }
        }
    });
    model.flush("findUWRiskAccumulationByObjectNo");

    model.describe("findUWObjectByObjectNo",{
        provider:{
            url:"controller/uw/subject/findUWObjectByObjectNo?objectNo=666666",
            loadMode: "manual",
            method:"GET",
            response:function(self,arg) {
                var result=arg.result;
                console.log(result[0])
                model.set("blacklist",result[0].blacklist)
                model.set("cheatSign",result[0].cheatSign)
                model.set("countRisk",result[0].countRisk)
                model.set("grade",result[0].grade)
                model.set("graylist",result[0].graylist)
                model.set("historyCompensateTime",result[0].historyCompensateTime)
                model.set("lookRiskTime",result[0].lookRiskTime)
                model.set("objectName",result[0].objectName)
                model.set("objectNumber",result[0].objectNumber)
                model.set("objectType",result[0].objectType)
                model.set("queryDate",result[0].queryDate)
                model.set("surveyOpinion",result[0].surveyOpinion)
                model.set("totalCompensate",result[0].totalCompensate)

            }
        }
    });
    model.flush("findUWObjectByObjectNo");

    model.action({
        //风勘任务查询
        search: function () {

        }
    })
});