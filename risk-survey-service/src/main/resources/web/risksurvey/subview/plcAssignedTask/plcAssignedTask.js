cola(function(model){
    model.set("queryCondition", {
    	surveyId: null,
    	businessNo: null,
    	product:"",
    	productCode:"",
    	customerName:"",
    	makeCom:"",
    	taskStarter:"",
    	applyDept:"",
    	taskStarterDate:""
    });
    
    model.action({
    	queryAssignedTask: function(){
    		console.log("query assigned task");
    		model.flush("policyCode");
    	},
    	assignedTask: function(item){
    		debugger;
    		    var surveyId = item.get("surveyId");
        		var url="risksurvey/risksurvey/riskSurvey.html?surveyId=" + surveyId;
        		contractEntity.openIframePage("风勘录入",url);
    	},
    	reset: function(){
    		model.set("queryCondition", {
    	    	surveyId: null,
    	    	businessNo:null,
    	    	product:"",
    	    	productCode:"",
    	    	customerName:"",
    	    	makeCom:"",
    	    	taskStarter:"",
    	    	applyDept:"",
    	    	taskStarterDate:""
    	    });
    	},
    	reAssignedTask:function(item){
    		debugger;
    		var url = "risksurvey/risksurvey/riskSurveyReAssign.html?taskId=" + item.get("taskId");
    		contractEntity.openIframePage("转派任务",url);
    	},
    	displayFormateDate: function(date){
            var date = new Date(date);
            if( date ){
                if( date.getHours()==0 && date.getMinutes()==0 && date.getSeconds()==0 ){
                    date.setDate(date.getDate()-1);
                    cola.tag("formatDate").set("displayFormat","yyyy-MM-dd 24:00:00");
                    cola.tag("formatDate").set("readOnly", true);
                }
            }
            return date;
         }    	
    });
    
    model.describe("assignedTaskList", {
		provider: {
			url: "controller/risksurvey/surveytaskqueryall/findTaskPages?from={{$from}}&limit={{$limit}}",
			sendJson: true,
			pageSize: 10,
			method: "POST",
			parameter: "{{queryCondition}}",
			beforeSend:function(self,arg) {
				debugger;
				var surveyId = self._parameter.get("surveyId");
				var businessNo = self._parameter.get("businessNo");
				var product = self._parameter.get("product");
				var productCode = self._parameter.get("productCode");
				var customerName = self._parameter.get("customerName");
				var makeCom = self._parameter.get("makeCom");
				var taskStarter = self._parameter.get("taskStarter");
				var applyDept = self._parameter.get("applyDept");
				var taskStarterDate = self._parameter.get("taskStarterDate");
				
				if (surveyId == null || surveyId == undefined) {
					surveyId = null;
				}
				if (businessNo == null || businessNo == undefined) {
					businessNo = null;
				}
				if (product == null || product == undefined) {
					product = "";
				}
				if (productCode == null || productCode == undefined) {
					productCode = "";
				}
				if (customerName == null || customerName == undefined) {
					customerName = "";
				}
				if (makeCom == null || makeCom == undefined) {
					makeCom = "";
				}
				if (taskStarter == null || taskStarter == undefined) {
					taskStarter = "";
				}
				if (applyDept == null || applyDept == undefined) {
					applyDept = "";
				}
				if (taskStarterDate == null || taskStarterDate == undefined) {
					taskStarterDate = "";
				}
				 
				/*var params = "&surveyId=" + surveyId + "&businessNo=" + businessNo + "&product=" + product + "&productCode=" + productCode
				        + "&customerName=" + customerName + "&makeCom=" + makeCom + "&taskStarter=" + taskStarter + "&applyDept=" + applyDept
				        + "&plateNo=" + plateNo + "&taskStarterDate=" + taskStarterDate;*/
				var params = {};
				params.surveyId = surveyId;
				//params.businessNo = businessNo;
				//params.product = product;
				//params.productCode = productCode;
				//params.customerName = customerName;
				/*params.makeCom = makeCom;
				params.taskStarter = taskStarter;
				params.applyDept = applyDept;
				params.plateNo = plateNo;
				params.taskStarterDate = taskStarterDate;*/
				arg.options.url = arg.options.url;
				arg.options.data = JSON.stringify(params);
				
			},
			response: function (self, arg) {
				if (arg.result) console.log("query result ",arg.result);
				if (arg.result != undefined){
					if(arg.result.data$){
	                    for(var i=0;i<arg.result.data$.length;i++){
	                    	arg.result.data$[i].surveyStatus=changeStatus(arg.result.data$[i].surveyStatus);
	                    }
					}
				}
			}
		}
	});
    
    function changeStatus(status){
   	    switch(status){
   	       case "00": return "初始化"; break;
   	       case "01": return "保存"; break;
   	       case "02": return "任务创建中"; break;
   	       case "03": return "未分派"; break;
   	       case "04": return "已分派";break;
   	       case "05": return "未提交";break;
   	       case "06": return "已提交";break;
   	       case "07": return "任务创建中(补充)";break;
   	       case "08": return "下发修改";break;
   	       case "09": return "已完成";break;
   	       case "10": return "注销";break;
   	    }
    }
})