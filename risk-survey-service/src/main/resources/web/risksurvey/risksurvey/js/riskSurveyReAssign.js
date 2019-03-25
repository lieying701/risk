cola(function(model){
	
	var taskId = cola.util.queryParams().taskId;
	model.set("taskId", taskId);
	getSurveyer();

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
    ])
    
    cola.ready(function() {
    	findUserByAssignmentList();
    });

    model.action({
        confirmReassign : function(){
            console.log("click confirm reassign btn..");
        },
        cancelReassign : function(){
            console.log("click cancel reassign btn..");
        },
        confirmReAssign : function(userlogin){
        	var params = cola.util.queryParams();
        	var taskId = params.taskId;
        	var userLoginName = userlogin;
        	console.log("转派....." + userLoginName);
        	$.ajax({
				url: "controller/risksurvey/surveytask/surveyAssignTask?taskIds="+taskId+"&userLoginName="+userLoginName,
				type: "GET",
				contentType: "application/json",
				success: function (data) {
					App.alert("转派成功");
					setTimeout(function() {
                        contractEntity.closeIframePage();
                    }, 3000);
				},
				error: function () {
					App.alert("转派失败");
				}
			});
        },
    })
    
     function getSurveyer(){
    	console.log("get surveyer");
    	var taskId = model.get("taskId");
    	debugger;
    	$.ajax({
			url: "controller/risksurvey/surveytask/surveyerByTaskId",
	    	contentType: "application/json;charset=UTF-8",
	        type:"POST",
	        dataType : "json",
	        async: false,
	        data:JSON.stringify({taskId:taskId}),
			success: function(data){
				console.log(data);
				model.set("assigneeName", data.assigneeName);
			}
    	})
    }
    
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