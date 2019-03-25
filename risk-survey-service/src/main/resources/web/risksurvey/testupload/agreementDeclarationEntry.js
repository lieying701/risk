cola(function (model) {
    //查询域数据类型
    model.dataType({
        name: "AgreementBatchApplyVO",
        properties: {
            policyNo: {
                caption: "[(#{agreementNo})]",
                dataType: "string"
            },
            agreementName: {
                caption: "[(#{agreementName})]",
                dataType: "string"
            },
            batchNo: {
                caption: "[(#{batchNo})]",
                dataType: "string"
            },
            startTime: {
                caption: "[(#{startTime})]",
                dataType: "date"
            },
            endTime: {
                caption: "[(#{endTime})]",
                dataType: "date"
            },
            applyTime: {
                caption: "[(#{applyTime})]",
                dataType: "date"
            },
            recordClerkCode: {
                caption: "[(#{recordClerkCode})]",
                dataType: "string"
            },
            recordClerkName: {
                caption: "[(#{recordClerkName})]",
                dataType: "string"
            }            
        }
    }); 
    //查询域数据设置
    model.describe("agreementBatchApply", "AgreementBatchApplyVO");
    model.set("agreementBatchApply", {});
    
    $("#posRight").show();
	cola.ready(function () {
		var failuretable = cola.widget("failureRecord");
		failuretable.set("columns",[]);
		failuretable.set("items",[]);
		var remindtable = cola.widget("remindRecord");
		remindtable.set("columns",[]);
		remindtable.set("items",[]);
//		getremindRecord();
		var params = cola.util.queryParams();
		var agreementNo = params.agreementNo;
		if(agreementNo) {
			model.action("createAgreementChildPolicy")(agreementNo);
			var agrStartTime = model.get("agrStartTime");
			var agrEndTime = model.get("agrEndTime");
			if(agrEndTime && agrEndTime) {
				cola.widget("agrStartTime").on("change",function(self,arg){
					var d1 = arg.value;
					var d2 = new Date(agrStartTime);
					if(d2.getTime() > d1.getTime()){
						App.alert("保单的起保时间不能大于协议的有效开始时间！");
						model.set("agreementBatchApply.startTime",d2);
						return false;
					}
				});
				cola.widget("agrEndTime").on("change",function(self,arg){
					var d1 = arg.value;
					var d2 = new Date(agrEndTime);
					if(d2.getTime() < d1.getTime()){
						App.alert("保单的终保时间不能大于协议的有效结束时间！");
						model.set("agreementBatchApply.endTime",d2);
						return false;
					}
				});
			}
		}
	})

	$(".groupWaitBox").css("display","none");
	model.action({
		createAgreementChildPolicy:function(policyNo){
			if(!policyNo) {
				policyNo = model.get("agreementBatchApply.policyNo");
			}
			if(!policyNo){
				App.alert("请输入协议号！");
				return false;
			}
			$.ajax({
				url: "controller/agreement/agreementTemplate/findLastEffectiveAgreement",
				type: "GET",
				data:{policyNo:policyNo},
				contentType: "application/json",
				async:false,
				success: function (data) {
					if(!data) {
						App.alert("协议不存在，请重新输入协议号！");
						return false;
					}
					if(data.status == '404') {
						App.alert(data.message);
						return false;
					}
					
                    model.set("agrStartTime", new Date(data.message.startTime))
                    model.set("agrEndTime", new Date(data.message.endTime))
					
					model.set("agreementBatchApply",{
						policyNo: policyNo,
						agreementName: data.message.agreementName,
						actualId: data.message.actualId,
						startTime: data.message.startTime,
						endTime: data.message.endTime
					})
					$.get("controller/agreement/businessEntity/getAgreementApplyInfo",{},function(data){
						model.set("agreementBatchApply.batchNo",data.batchNo);
						model.set("agreementBatchApply.applyTime",data.applyTime);  
						if(data.currentUser){
							model.set("agreementBatchApply.recordClerkCode",data.currentUser.userId); 
							model.set("agreementBatchApply.recordClerkName",data.currentUser.name); 
						}	                	
					});
				}
			});
		},
		goToDetail:function(item){//进入协议录入只读视图 详情页面
			var Params=cola.util.queryParams();
        	var specId = Params.specId;
        	var actualId = Params.actualId;
        	 var viewFlag = "true";//协议查询进入的标志
            var url1 =  "contractcenter/agreement/agreementView.html?specId="+specId+"&actualId="+actualId+"&viewFlag="+viewFlag;
            contractEntity.openIframePage("团单视图",url1);

        },
        //清单上传
        beforeSend: function (self, arg) {
            model.set("fileName", arg.file.name);
            var uploadFlag=false;//增量
            var agreementBatchApply=model.get("agreementBatchApply");
            var parameters=agreementBatchApply.toJSON();
			parameters["uploadFlag"]=uploadFlag;
			arg.data.parameter = parameters;
        },
        //上传成功
        uploadSuccess: function (self, arg) {
        	debugger
        	var failuretable = cola.widget("failureRecord");
    		failuretable.set("columns",[]);
    		failuretable.set("items",[]);
    		
    		var remindtable = cola.widget("remindRecord");
    		remindtable.set("columns",[]);
    		remindtable.set("items",[]);
    		
        	model.set("uploadFlag", "1")
            var batchEO = arg.response.batchEO;
        	if(batchEO && batchEO.batchObjectType) {
        		model.set("agreementBatchApply.batchNo", batchEO.batchObjectType)
        	}
        	if(batchEO && batchEO.batchFailure == "0") {
				cola.widget("uploadSideBar").hide();
				cola.alert("文件已经上传过，可以使用对应的批次信息查询。批次号为："+batchEO.batchObjectType+"，批次序列为："+batchEO.batchNo+"。");
				return;
			}else{
				debugger
				$(".groupWaitBox").css("display","block");
				cola.widget("uploadSideBar").hide();
				getGroupStatus();
				$("#posRight").show();
				$(".showUpLoad").show();
				cola.tag("getCalcP").set("disabled", false);
				//自动刷新
				var autoFlush = setInterval(function () {
					if (model.get("batchStatus") == "Completed" || model.get("batchStatus") == "02") {
						clearInterval(autoFlush);
						$(".groupWaitBox").css("display","none");
						if(model.get("batchFailure") > 0) {
							getfailureRecord();
						}
						getremindRecord();
					}
					else{
						//显示等待动画
						$(".groupWaitBox").css("display","none");
						model.action.flushInfo();
					}
					if(model.get("batchStatus") == "01"){//显示等待动画
						$(".groupWaitBox").css("display","block");
					}
					if(!model.get("batchStatus")){
						$(".groupWaitBox").css("display","none");
					}
				}, 3000);
			}
        },
        uploadError:function(self, reason){
        	cola.alert("请上传该产品对应模板！");
            //cola.alert(reason.reason);
            cola.widget("uploadSideBar").hide();
            return false;
        },
		//上传
		showAllUploadSideBar: function () {
			var uploadSideBar = cola.widget("uploadSideBar");
			uploadSideBar.show();
/*			var batchNo = model.get("agreementBatchApply.batchNo");
			var uploadSideBar = cola.widget("uploadSideBar");
			if(batchNo) {
				uploadSideBar.show();
			} else {
				App.alert("请先查询下协议！");
			}*/
		},
		cancel:function(){//放弃按钮
			
		},
		submitUW:function(){//提交
        	var batchNo = model.get("agreementBatchApply.batchNo");
        	var agreementNo = model.get("agreementBatchApply.policyNo");
        	var startTime = model.get("agreementBatchApply.startTime");
        	var endTime = model.get("agreementBatchApply.endTime");
        	var uploadFlag = model.get("uploadFlag");
        	if(!agreementNo) {
        		App.alert("请先查询协议信息");
        		return false;
        	}
        	if(uploadFlag != "1") {
        		App.alert("请先上传清单");
        		return false;
        	}
        	if(!startTime) {
        		App.alert("保险起期不能为空");
        		return false;
        	}
        	if(!endTime) {
        		App.alert("保险止期不能为空");
        		return false;
        	}
        	var params = {};
        	params.batchNo = batchNo;
        	params.agreementNo = agreementNo;
        	params.startTime = startTime;
        	params.endTime = endTime;
        	params.taskType = "Application";
        	params.processDefinitionKey = "underwriting"
        	$.ajax({
        		url: "controller/agreement/agreementTemplate/processSubmitUploadData",
        		type: "POST",
        		datatype: "json",
                contentType: "application/json;charset=UTF-8",
                data: JSON.stringify(params),
                success: function(data) {
                	if(data.status == "200") {
                		cola.NotifyTipManager.info({
                			message: data.message,
                			showDuration: 3000
                		});
                	} else {
                		cola.NotifyTipManager.error({
                			message: data.message,
                			showDuration: 3000
                		});
                	}
                },
                error:function(){
                    
                }
        	})
		},
		//下载模板
		downLoadTemplate: function () {
			var agreementId = model.get("agreementBatchApply.actualId");//协议Id
			var agreementNo = model.get("agreementBatchApply.policyNo");//协议号
			if(!agreementNo || agreementId == undefined) {
				App.alert("协议号不存在或者先查询下协议！");
				return false;
			}
        	var url="controller/agreement/agreementTemplate/getExcelTemplate?agreementId=" + agreementId + "&agreementNo=" + agreementNo + "&insuraceMode=BATCH";
            window.open(url, "_self");
		},
		//下载失败清单
		failureList: function () {
			var batchNo = model.get("agreementBatchApply.batchNo");
        	var agreementNo = model.get("agreementBatchApply.policyNo");
        	if(!agreementNo) {
				App.alert("协议号为空或者先查询下协议！");
				return false;
			}
            var batchFailure = model.get("batchFailure");
            if (batchFailure == 0 || batchFailure == undefined) {
                return;
            }
            else {
                window.open("controller/agreement/agreementTemplate/getFailExcel?batchNo=" + batchNo + "&agreementNo=" + agreementNo, "_self");
            }
		},
		//处理状态
		onItemRender: function (dom, model) {
			if (model.get("batchStatus") == "Processing" || model.get("batchStatus") == "01") {
                $(dom).html("处理中");
            }
            else if (model.get("batchStatus") == "Completed" || model.get("batchStatus") == "02") {
                $(dom).html("已完成");
            }
		},
		//刷新
		flushInfo: function () {
			getGroupStatus();
			$("#nprogress").css("display", "none");
		},
		selectData: function(self,arg) {
			debugger
		}
	});
	
	model.set("datas",[{"key":"01","value":"提交人工核保"},{"key":"02","value":"放弃"}]);

	//文件校验失败记录
	function getfailureRecord() {
		var batchNo = model.get("agreementBatchApply.batchNo");
        var agreementNo = model.get("agreementBatchApply.policyNo");
        var failuretable = cola.widget("failureRecord");
		$.ajax({
			url: "controller/agreement/agreementTemplate/getAgrUploadResultData?batchNo="+batchNo+"&agreementNo="+agreementNo,
			type: "GET",
			contentType: "application/json",
			success: function(data) {
				var headMap = data.errorHeadMap;
				var result = data.failResult;
				var headData = [];
				var itemsData = [];
				var columns = [];
				for(var i=0,len=Object.keys(headMap).length; i<len; i++) {
					var column = {};
					column.property = "property";
					var obj = headMap[i];
					for(var key in obj) {
						column.property = key;
						columns.push(key);
					}
					headData.push(column);
				}
				
				if(result) {
					result.forEach(function(obj){
						var items = {};
						for(var i=0,len=Object.keys(obj).length; i<len; i++) {
							items[columns[i]] = obj[i];
						}
						itemsData.push(items);
					})
					failuretable.set("columns",headData);
					failuretable.set("items",itemsData);
				}
			}
		})
	}
	//文件校验提醒记录
	function getremindRecord() {
		var batchNo = model.get("agreementBatchApply.batchNo");
        var agreementNo = model.get("agreementBatchApply.policyNo");
//        batchNo = "BATCH-NO-423";
//        agreementNo = "7601201800700054";
        var remindtable = cola.widget("remindRecord");
		$.ajax({
			url: "controller/agreement/agreementTemplate/getAgrUploadResultData?batchNo="+batchNo+"&agreementNo="+agreementNo,
			type: "GET",
			contentType: "application/json",
			success: function(data) {
				var headMap = data.errorHeadMap;
				var result = data.warningResult;
//				var result = data.failResult;
				var headData = [];
				var itemsData = [];
				var columns = [];
				for(var i=0,len=Object.keys(headMap).length; i<len; i++) {
					var column = {};
					column.property = "property";
					var obj = headMap[i];
						for(var key in obj) {
							column.property = key;
							columns.push(key);
						}
					headData.push(column);
				}

				if(result) {
					result.forEach(function(obj){
						var items = {};
						for(var i=0,len=Object.keys(obj).length; i<len; i++) {
								items[columns[i]] = obj[i];
						}
						itemsData.push(items);
					})
					
					var e = {
				        caption: "操作",
				        "width":"170px",
				        template: {
				        	content:[{
				                tagName: "c-dropdown",
				                "width":"120px",
				                "c-items":"datas",
				                "value":"01",
				                "change":"selectData"
				            }]
				        }
				    }
					headData.push(e);
					remindtable.set("columns",headData);
					remindtable.set("items",itemsData);
				}
			}
		})
	}
	//封装上传清单数据
	function getGroupStatus() {
		var batchNo = model.get("agreementBatchApply.batchNo");
        var agreementNo = model.get("agreementBatchApply.policyNo");
        if(!agreementNo) {
			App.alert("协议号为空或者先查询下协议！");
			return false;
		}
        var url = "controller/agreement/agreementTemplate/getAgreementExcelResult?batchNo=" + batchNo + "&agreementNo=" + agreementNo;
        $.ajax({
            url: url,
            method: "get",
            async: false,
            success: function (data) {
            	debugger
            	if( !data ){
            		model.set("batchCompelete","");
            		model.set("upLoadList", []);
            	}
                if (data.errorMessage) {
                    cola.alert(data.errorMessage);
                }
                var batchNum = data.batchNum;
                var batchStatus = data.batchStatus;
                var batchCompelete = data.batchCompelete;
                model.set("batchCompelete",batchCompelete);
                var batchFailure = data.batchFailure;
                model.set("batchNum", batchNum);
                model.set("batchStatus", batchStatus);
                model.set("batchCompelete", batchCompelete);
                model.set("batchFailure", batchFailure);
                //隐藏等待动画
                if(batchStatus=="02") {
                    $(".groupWaitBox").css("display","none");
                }
            },
            error:function(){
                $(".groupWaitBox").css("display","none");
            }
        })
    }
	
	function getIdx() {
		var o = cola.widget("remindRecord")._items;
		/*if (o) {
			o.forEach(function(index)) {
				
			}
		}*/
	}
});