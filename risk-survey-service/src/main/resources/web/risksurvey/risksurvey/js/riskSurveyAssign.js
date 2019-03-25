cola(function(model){

    model.set("levelList",[{
        key : "0",
        value : "一级"
    },{
        key : "1",
        value : "二级"
    },{
        key : "2",
        value : "三级"
    },{
        key : "3",
        value : "四级"
    }
    ]);
    model.set("queryCondition",{});
    var firstStructure = [];
    var secondStructure = [];
    var thirdStructure = [];
    var risksurveyer = [];
    
    cola.ready(function() {
    	findUserByAssignmentList();
    });

    model.action({
        confirmAssign : function(userlogin){
        	var params = cola.util.queryParams();
        	var taskId = params.taskId;
        	var userLoginName = userlogin;
        	console.log("指派....." + userLoginName);
        	//var taskIds= "107583";
        	//var  userLoginName = "小黄";
        	$.ajax({
				url: "controller/risksurvey/surveytask/surveyAssignTask?taskIds="+taskId+"&userLoginName="+userLoginName,
				type: "GET",
				contentType: "application/json",
				/* data: JSON.stringify({
					 "taskId":taskId,
					 "userLoginName":userLoginName
						 }),*/
				success: function (data) {
					App.alert("指派成功");
					setTimeout(function() {
                        contractEntity.closeIframePage();
                    }, 3000);
				},
				error: function () {
					App.alert("指派失败");
				}
			});
        },
        cancelAssign : function(){
            console.log("click cancel reassign btn..");
        }
    })
    
    function findUserByAssignmentList(){
    	$.ajax({
    		url: "service/rbac/domainRbacUser/findUserByAssignmentList",
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify({
				"roleKind" : "100101",
				"loginStructurePath" : "Underwriting:00000000/44030000/44039900/44038000"
			}),
			success: function (data) {
				var strucArr = [];
				var surveyerArr = [];
			    for (var i=0; i<data.length; i++){
			    	console.log("ownedStructurePath : ", data[i].ownedStructurePath);
			    	var loginName= data[i].loginName;
			    	var structureId = data[i].ownedStructureId;
			    	var structureName = data[i].ownedStructureName;
			    	strucArr.push({
                        key: structureId,
                        value: structureId + "-" + structureName
                    });
			    	surveyerArr.push({
			    		key: loginName,
			    		value: data[i].name
			    	});
			    } 
				model.set("firstStructure", strucArr);
				model.set("risksurveyer", surveyerArr);
			}
    	})
    }

})