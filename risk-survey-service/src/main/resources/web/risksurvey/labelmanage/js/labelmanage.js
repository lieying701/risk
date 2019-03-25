cola(function (model) {
	//控制部门名字显示次数
	var boolean = new Boolean(true);
	//给jade文件中的部门显示变量赋值
	model.set("departments", []);
	//定义添加标签分类下拉框变量
	var labelvarietydropdownlist = [];
	//定义添加标签下拉框变量
	var labeldropdownlist = [];
	//定义主界面提交时的总数据
	var havadepartment = [];
	//维持标签分类信息
	var MaintainingLabelClassInfor = [];
	model.set("addlabelvarietydropdownlist", []);
	model.set("addlabeldropdownlist", []);
	//给jade文件中的添加自定义标签赋值
	model.set("modifyLabels", []);
	model.action({
		//添加部门对话框显示按钮
		addDepartment: function () {
			cola.widget("adddepartment").show();
		},
		//添加部门对话框点击确定事件
		adddepartmentdialog: function ($dom) {
			var departmentId = model.get("departmentnamedropdown");
			var departmentname = changeDepartment(departmentId);
			if (departmentId == undefined || departmentId == "") {
				App.alert("请您正确选择部门");
				return true;
			} else {
				if (havadepartment.length > 0) {
					for (var i = 0; i < havadepartment.length; i++) {
						var havedata = havadepartment[i].departmentId;
						if (departmentId == havedata) {
							App.alert("该部门已经选择，请选择其他部门！");
							return true;
						}
					}
				}
				cola.widget("adddepartment").hide();
				var labelvarietydropdownlist = [];
				$.ajax({
					url: "service/third-party-service/thirdLabelVarietyService/findByBusinessLine?bsLine=" + departmentId,
					type: "GET",
					contentType: "application/json",
					success: function (data) {
						if (data.length == 0) {
							App.alert("当前部门未添加公共的标签配置,需要添加对应的公共标签分类，才可以添加标签内容。");
							return true;
						} else {
							var labelTypeInfoList = [];
							var pushhavadepartment = {
								"departmentId": departmentId,
								"departmentName": departmentname,
								"thirdPartyId": thirdPartyId,
								"labelTypeInfoList": labelTypeInfoList
							}
							//havadepartment最终提交的数据，封装部门数据
							havadepartment.push(pushhavadepartment);
							checkdepartments(departmentId);
							$.each(data, function (index, obj) {
								//部门名称只进行一次插入
								if (boolean) {
									//插入部门信息
									insertDepartment(departmentname,departmentId);
									boolean = false;
									var parameter = {
											"departmentId":departmentId,
											"labelVarietyName":obj.labelVarietyName,
											"labelVarietyId":obj.labelVarietyId,
											"labelVarietydata":data
									}
									MaintainingLabelClassInfor.push(parameter);
								}
								var labelVarietyName = obj.labelVarietyName;
								var labelVarietyId = obj.labelVarietyId;
								//插入标签分类
								insertLabelVariety(labelVarietyName,labelVarietyId);
								var labels = obj.labelSet;
								//插入标签
								var oBuffer = insertLabel(labels);
								var labelIds = oBuffer.join();
								var labelVarietyNames = {
									"labelVarietyName": labelVarietyName,
									"labelVarietyId": labelVarietyId,
									"thirdPartyId": thirdPartyId,
									"labelIds": labelIds,
									"labelValues": ""
								}
								//封装最终提交的数据-标签分类信息
								labelTypeInfoList.push(labelVarietyNames);
							})
						}
					}
				});
			}
			model.set("departmentnamedropdown", "");
			boolean = true;
		},
		//添加部门对话框点击取消事件
		canceladddepartmentdialog: function () {
			cola.widget("adddepartment").hide();
		},
		//添加标签分类对话框按钮事件 
		addFieldss: function (department) {
			department.setCurrent();
			cola.widget("addlabelvariety").show();
			model.set("departmentid", department._data.departmentId);
		},
		//添加标签分类对话框点击取消事件
		canceladdlabelvarietydialog: function () {
			cola.widget("addlabelvariety").hide();
		},
		//点击弹出添加自定义标签对话框
		editLable: function (assessmentContext, department) {
			assessmentContext.setCurrent();
			department.setCurrent();
			model.set("labelvarietynamedialog", assessmentContext._data.labelVarietyId);
			model.set("addnewlabeldepartmentid", department._data.departmentId);
			model.set("modifylabelTtype", assessmentContext._data.labelVarietyName);
			cola.widget("addnewLabel").show();
		},
		//点击添加自定义标签字段输入框
		modifyAddLabels: function (modifyLabel) {
			model.get("modifyLabels").insert();
		},
		//添加自定义标签对话框点击确定事件
		modifyConfirm: function (modifyLabel) {
			var modifyLabels = model.get("modifyLabels");
			var current = modifyLabels._currentPage;

			//说明啥也没有操作
			if (current == undefined) {
				model.set("modifyLabels", []);
				cola.widget("addnewLabel").hide();
				return true;
			}
			var labelVarietyId = model.get("labelvarietynamedialog");
			var departmentId = model.get("addnewlabeldepartmentid");

			//拿到用户输入的标签放到数组里面
			var newlabel = new Array();
			for (var i = 0; i < modifyLabels._currentPage.length; i++) {
				var newAddlabelName = modifyLabels._currentPage[i]._data.text;
				if (newAddlabelName == undefined || newAddlabelName.trim().length === 0) {
					App.alert("您好，有输入框没有填数据，请查看");
					return true;
				}
				newlabel.push(newAddlabelName);
			}

			//拿到公共配置的标签信息放到数组里面
			var newlabelold = new Array();
			var labels = model.get("departments").current.get("assessmentContexts").current.get("labelselects");
			if (labels.entityCount > 0) {
				for (var i = 0; i < labels._currentPage.length; i++) {
					newlabelold.push(labels._currentPage[i]._data.labelselectName);
				}
			}
			//重复判断比较
			if (modifyLabels.entityCount >= 1) {
				newlabelold = newlabelold.concat(newlabel);
				var nary = newlabelold.sort();
				for (var i = 0; i < newlabelold.length; i++) {
					if (nary[i] == nary[i + 1]) {
						App.alert("添加的标签有重复内容");
						return true;
					}
				}
				//判断没有重复的以后进行插入操作
				for (var i = 0; i < newlabel.length; i++) {
					model.get("departments").current.get("assessmentContexts").current.get("labelselects").insert({ "labelselectName": newlabel[i] });
				}
				//更改最终提交的数据结构
				for (var i = 0; i < havadepartment.length; i++) {
					var departmentIdold = havadepartment[i].departmentId;
					if (departmentIdold == departmentId) {
						var labelSet = havadepartment[i].labelTypeInfoList;
						if (labelSet.length > 0) {
							for (var j = 0; j < labelSet.length; j++) {
								if (labelVarietyId == labelSet[j].labelVarietyId) {
									if (labelSet[j].labelValues == "") {
										labelSet[j].labelValues = newlabel.join();
									} else {
										labelSet[j].labelValues = labelSet[j].labelValues + "," + newlabel.join();
									}
								}
							}
						}
					}
				}
			}
			model.set("modifyLabels", []);
			cola.widget("addnewLabel").hide();
		},
		//添加自定义标签对话框输入框后面操作事件
		modifyDeleteLabel: function (modifyLabel) {    
			modifyLabel.remove();
		},
		//主界面保存事件
		save: function () {
			debugger;
			if (havadepartment.length == 0) {
				App.alert("请先选择标签信息");
				return true;
			}
			console.log(havadepartment);
			$.ajax({
				url: "thirdparty/controller/thirdLabelInfoController/insertOrUpdateThirdLabelInfo",
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify(havadepartment),
				success: function (data) {
					App.alert("标签配置成功,界面将在两秒内关闭返回上一界面");
					setTimeout(function () {
						window.close();
					}, 2000);
					model.set("departments", []);
					MaintainingLabelClassInfor = [];
					havadepartment = [];
				},
				error: function () {
					App.alert("标签配置失败,请联系后台技术人员操作！！！");
				}
			});
		},
		//主界面取消事件
		cancel: function () {
			if (havadepartment.length == 0) {
				App.alert("无配置信息可取消");
				return true;
			}
			debugger;
            $(".waittingRenderBox").show();// loading
			var departmends = model.get("departments");
			var currentPage = departmends._currentPage;
			//删除部门信息id封装
			var infoIds = [];
			if (currentPage != undefined && currentPage.length > 0) {
				for (var i = 0; i < currentPage.length; i++) {
					//删除完数据以后把此部门添加到显示列表中可重新显示
					var adddepartment = {
						name: currentPage[i]._data.departmentname,
						key: currentPage[i]._data.departmentId
					}
					bsLineLists.push(adddepartment);
					model.set("bsLineList", bsLineLists);
					//存放部门labelInfoId
					if(currentPage[i]._data.labelInfoId != undefined){
						infoIds.push(currentPage[i]._data.labelInfoId);
					}
				}
			}
			//删除所有的部门
			if(infoIds != []){
				$.ajax({
					url: "thirdparty/controller/thirdLabelInfoController/deleteThirdLabelInfoByIds",
					type: 'POST',
					async: false,
					contentType: 'application/json',
					data: JSON.stringify(infoIds),
					success: function (data) {
						App.alert("部门信息删除成功");
					}
				});
			}
			//删除所有的标签分类
			$.ajax({
				url: "thirdparty/controller/thirdLabelTypeInfoController/deleteThirdlabelTypeIdBythirdPartyId?thirdPartyId="+thirdPartyId,
				type: 'GET',
				async: false,
				contentType: 'application/json',
				success: function (data) {
					App.alert("删除标签分类信息成功");
				}
			});
			//清理界面缓存
			model.set("departments", []);
			MaintainingLabelClassInfor = [];
			havadepartment = [];
            $(".waittingRenderBox").hide();// loading
		},
		//删除部门事件
		delDepartment: function (department) {
			//说明这个部门是数据库有的数据，所以做删除操作
			if(department._data.labelInfoId != undefined){
				var labelInfoId = department._data.labelInfoId ;
				var infoIds = [];
				infoIds.push(labelInfoId);
				$.ajax({
					url: "thirdparty/controller/thirdLabelInfoController/deleteThirdLabelInfoByIds",
					type: 'POST',
					async: false,
					contentType: 'application/json',
					data: JSON.stringify(infoIds),
					success: function (data) {
						App.alert("部门信息删除成功");
					}
				});
			}
			var departmentId = department._data.departmentId
			for (var i = 0; i < havadepartment.length; i++) {
				var id = havadepartment[i].departmentId;
				if (id == departmentId) {
					havadepartment.splice(i, 1);
				}
			}
			//删除完数据以后把此部门添加到显示列表中可重新显示
			var adddepartment = {
				name: department._data.departmentname,
				key: departmentId
			}
			bsLineLists.push(adddepartment);
			model.set("bsLineList", bsLineLists);
			//把部门信息的缓存数据清除
			for (var i = 0; i < MaintainingLabelClassInfor.length; i++) {
				if (departmentId == MaintainingLabelClassInfor[i].departmentId) {
					MaintainingLabelClassInfor.splice(i, 1);
				}
			}
			department.remove();
		},
		//标签分类对话框下拉前事件
		labelvarietyOpen: function () {
			labelvarietydropdownlist = [];
			debugger;
			var businessLine = model.get("departmentid");
			var parameter = {
				"businessLine": businessLine
			}
			//获取界面已经存在的标签分类id放到数据里面
			var uihavedata = model.get("departments").current.get("assessmentContexts");
			var havelabervarietyid = new Array();
			if (uihavedata._currentPage.length > 0) {
				for (var i = 0; i < uihavedata._currentPage.length; i++) {
					havelabervarietyid.push(uihavedata._currentPage[i]._data.labelVarietyId);
				}
			}
			for (var i = 0; i < MaintainingLabelClassInfor.length; i++) {
				if (businessLine == MaintainingLabelClassInfor[i].departmentId) {
					var data = MaintainingLabelClassInfor[i].labelVarietydata;
					for (var j = 0; j < data.length; j++) {
						//如果请求的数据在界面已经存在了，就结束本次循环
						if (havelabervarietyid.indexOf(data[j].labelVarietyId) >= 0) {
							continue;
						}
						var labelVarietyName = {
							name: data[j].labelVarietyName,
							key: data[j].labelVarietyId,
							data: data[j].labelSet

						}
						if(labelvarietydropdownlist != undefined && labelvarietydropdownlist.length>=0){
							var labelvarietydropdownlisthaveid = new Array();
							for(var m=0;m<labelvarietydropdownlist.length;m++){ 
								labelvarietydropdownlisthaveid.push(labelvarietydropdownlist[m].key);
							}
							if(labelvarietydropdownlisthaveid.indexOf(data[j].labelVarietyId) < 0){
								labelvarietydropdownlist.push(labelVarietyName);
							}
						}
					}
					if (labelvarietydropdownlist.length == 0) {
						App.alert("您好，目前所有公共配置标签分类已经添加，如果想再添加标签分类，请在公共配置界面先配置再使用");
					}
					model.set("addlabelvarietydropdownlist", labelvarietydropdownlist);
				}
			}
		},
		//添加标签分类对话框点击确定按钮事件
		addlabelvarietydialog: function () {
			debugger;
			var labelVarietyId = model.get("addlabelvarietydropdown");
			if (labelVarietyId == undefined || labelVarietyId == "") {
				App.alert("请您正确选择标签分类");
				return true;
			}
			//获取这个标签分类底下的标签集合
			var labels;
			for (var i = 0; i < labelvarietydropdownlist.length; i++) {
				if (labelVarietyId == labelvarietydropdownlist[i].key) {
					labels = labelvarietydropdownlist[i].data;
				}
			}
			//把code值转换成名字给界面显示
			var labelVarietyName = changelabelVarietystatus(labelVarietyId);
			var departmentIdold = model.get("departments").current._data.departmentId;
			for (var i = 0; i < havadepartment.length; i++) {
				var Id = havadepartment[i].departmentId;
				if (Id == departmentIdold) {
					var labelSet = havadepartment[i].labelTypeInfoList;
					if (labelSet.length >= 0) {
						for (var j = 0; j < labelSet.length; j++) {
							if (labelVarietyId == labelSet[j].labelVarietyId) {
								App.alert("该标签分类已经选择，请重新选择！");
								return true;
							}
						}
					}
					cola.widget("addlabelvariety").hide();
					model.get("departments").current.get("assessmentContexts").insert({ "labelVarietyName": labelVarietyName, "labelVarietyId": labelVarietyId, labelselects: [] });
					model.set("addlabelvarietydropdown", "");
					//设置当前分类id属于哪个部门的界面
					var assessmentConfig = model.get("departments").current.get("assessmentContexts");
					var assessConfiglength = assessmentConfig.entityCount;
					assessmentConfig._currentPage[assessConfiglength - 1].setCurrent();
                    // 插入标签
					var oBuffer = insertLabel(labels);
					var labelIds = oBuffer.join();
					var labelVarietyNames = {
						"labelVarietyName": labelVarietyName,
						"labelVarietyId": labelVarietyId,
						"thirdPartyId": thirdPartyId,
						"labelIds": labelIds,
						"labelValues": ""
					}
					havadepartment[i].labelTypeInfoList.push(labelVarietyNames);
				}
			}
			labelvarietydropdownlist = [];
			model.set("addlabelvarietydropdownlist", labelvarietydropdownlist);
		},
		//删除标签分类事件
		deleteLabelType: function (assessmentContext) {
			if(assessmentContext._data.labelTypeId != undefined){
				var labelTypeId = assessmentContext._data.labelTypeId;
				$.ajax({
				url:"thirdparty/controller/thirdLabelTypeInfoController/deleteThirdlabelTypeIdById?labelTypeId="+labelTypeId,
				type:'GET',
				contentType:'application/json',
				success:function(data){
					App.alert("删除标签分类成功");
				},
			});
			}
			var departmentId = assessmentContext.parent.parent._data.departmentId;
			var labelVarietyId = assessmentContext._data.labelVarietyId;
			for (var i = 0; i < havadepartment.length; i++) {
				var id = havadepartment[i].departmentId;
				if (id == departmentId) {
					var labelSet = havadepartment[i].labelTypeInfoList;
					if (labelSet.length >= 0) {
						for (var j = 0; j < labelSet.length; j++) {
							if (labelVarietyId == labelSet[j].labelVarietyId) {
								labelSet.splice(j, 1);
							}
						}
					}
				}
			}
			assessmentContext.remove();
		},
		//添加部门对话框消失前清理数据
		departmentdialogbeforehide: function () {
			model.set("departmentnamedropdown", "");
		},
		//添加标签分类对话框消失前清理数据
		labelvarietydialogbeforehide: function () {
			model.set("addlabelvarietydropdown", "");
		},
		//添加自定义标签对话框消失前事件
		addnewlabeldialogbeforehide: function () {
			model.set("modifyLabels", []);
		},
		//添加自定义标签对话框取消事件
		modifyCancel: function () {
			model.set("modifyLabels", []);
			cola.widget("addnewLabel").hide();

		}
	});
	//将对应的部门编码转换成中文
	function changeDepartment(status) {
		if (bsLineLists.length >= 0) {
			for (var i = 0; i < bsLineLists.length; i++) {
				var obj = bsLineLists[i];
				if (obj.key == status) {
					return obj.name;
				}
			}
		}
	};
	//将对应的标签分类id转换成名字
	function changelabelVarietystatus(code) {
		if (labelvarietydropdownlist.length >= 0) {
			for (var i = 0; i < labelvarietydropdownlist.length; i++) {
				var obj = labelvarietydropdownlist[i];
				if (obj.key == code) {
					return obj.name;
				}
			}
		}
	};
	//将对应的标签id转换成 名字
	function changelabelstatus(code) {
		if (labeldropdownlist.length >= 0) {
			for (var i = 0; i < labeldropdownlist.length; i++) {
				var obj = labeldropdownlist[i];
				if (obj.key == code) {
					return obj.name;
				}
			}
		}
	};
	//把刚添加的部门数据清除掉
	function checkdepartments(departmentId) {
		for (var i = 0; i < bsLineLists.length; i++) {
			var obj = bsLineLists[i];
			if (obj.key == departmentId) {
				bsLineLists.splice(i, 1);
				model.set("bsLineList", bsLineLists);
				return true;
			}
		}
	};
	var bsLineLists = [];
	var thirdPartyId;
	cola.ready(function () {
        $(".waittingRenderBox").hide();// loading
		var params = cola.util.queryParams();
		thirdPartyId = params.thirdPartyId;
		if(thirdPartyId == undefined || thirdPartyId.length<8){
			App.alert("缺少必要的参数,禁止操作,界面将在两秒内关闭！！！！！");
			setTimeout(function(){
				window.close();
			},2000);
		}
		$.ajax({
			url:"thirdparty/controller/thirdPubInfo/getThirdPaubInfoByThirdPartyId?thirdpartyId="+thirdPartyId,
			type:'GET',
			contentType:'application/json',
			success:function(data){
				model.set("thirdName","标签管理-"+data.thirdName)
			},
			error:function(data){
				debugger;
				App.alert("参数传输异常,禁止操作,界面将在两秒内关闭！！！！！");
				setTimeout(function(){
					window.close();
				},2000);
			}
		});
		$.ajax({
			url: "service/basecode/codeDetail/findCachedCodeDetails?baseCodeId=DepartmentCode",
			type: 'GET',
			contentType: 'application/json',
			success: function (data) {
				$.each(data, function (index, obj) {
					bsLineLists.push({
						key: obj.kind,
						name: obj.name
					});
				})
				model.set("bsLineList", bsLineLists);
			}
		});

		$.ajax({
			url: "thirdparty/controller/thirdLabelInfoController/selectThirdLabelInfoByThirdPartyId?id=" + thirdPartyId,
			type: 'GET',
			contentType: 'application/json',
			success: function (data) {
				console.log(data);
				if (data.length > 0) {
					//每个data代表一个部门的信息
					$.each(data, function (index, obj) {
						
						var labelTypeInfoList = [];
						var pushhavadepartment = {
							"labelInfoId": obj.labelInfoId,
							"departmentId": obj.departmentId,
							"departmentName": obj.departmentName,
							"thirdPartyId": thirdPartyId,
							"labelTypeInfoList": labelTypeInfoList
						}
						//封装最终提交的数据
						havadepartment.push(pushhavadepartment);
						checkdepartments(obj.departmentId);
						//插入部门信息--这个部门信息带有labelInfoId
						model.get("departments").insert({ "departmentname":obj.departmentName, "departmentId":obj.departmentId,"labelInfoId":obj.labelInfoId, assessmentContexts: [] });
						var departConfig = model.get("departments");
						var departlength = departConfig.entityCount;
						departConfig._currentPage[departlength - 1].setCurrent();
						
						//拿到这个部门下的标签分类集合遍历
						var labelTypeInfoListentitys = obj.labelTypeInfoList;
						if (labelTypeInfoListentitys.length > 0) {
							for (var i = 0; i < labelTypeInfoListentitys.length; i++) {
								var labelTypeInfoListentity = labelTypeInfoListentitys[i];
								var labelVarietyName = labelTypeInfoListentity.labelVarietyName;
								var labelVarietyId = labelTypeInfoListentity.labelVarietyId;
								//插入标签分类加上 -- 这个标签分类带有labelTypeId
								model.get("departments").current.get("assessmentContexts").insert({ "labelVarietyName": labelVarietyName, "labelVarietyId": labelVarietyId,"labelTypeId":labelTypeInfoListentity.labelTypeId, labelselects: [] });
								var assessmentConfig = model.get("departments").current.get("assessmentContexts");
								var assessConfiglength = assessmentConfig.entityCount;
								assessmentConfig._currentPage[assessConfiglength - 1].setCurrent();
								
								var labels = labelTypeInfoListentity.savePubLabelList;
								//插入标签
								var oBuffer = insertLabel(labels);
								var labelValues = labelTypeInfoListentity.labelValues;
								//自定义标签
								var labelcustom = [];
								if (labelValues != undefined) {
									//说明这个自定义标签只有一个
									if (labelValues.indexOf(",") == -1) {
										labelcustom.push(labelValues);
									} else {
										labelcustom = labelValues.split(",");
									}
									for (var k = 0; k < labelcustom.length; k++) {
										model.get("departments").current.get("assessmentContexts").current.get("labelselects").insert({ "labelselectName": labelcustom[k] });
									}
								} else {
									labelValues = "";
								}
								var labelIds = oBuffer.join();
								var labelVarietyNames = {
									"labelInfoId": labelTypeInfoListentity.labelInfoId,
									"labelTypeId": labelTypeInfoListentity.labelTypeId,
									"thirdPartyId": thirdPartyId,
									"labelVarietyId": labelVarietyId,
									"labelVarietyName": labelVarietyName,
									"labelIds": labelIds,
									"labelValues": labelValues
								}
								//封装最终提交的数据-标签分类信息
								labelTypeInfoList.push(labelVarietyNames);
							}
						}
						var parameterbusinessLine = {
							"businessLine": obj.departmentId
						}
						$.ajax({
							url: "thirdparty/controller/thirdLabelVariety/listByBusinseeLine",
							type: 'POST',
							async: false,
							contentType: 'application/json',
							data: JSON.stringify(parameterbusinessLine),
							success: function (data) {
								//给公共配置里面增加配置这个第三方资源没有的标签
								for (var i = 0; i < data.length; i++) {
									for (var j = 0; j < labelTypeInfoListentitys.length; j++) {
										if (data[i].labelVarietyId == labelTypeInfoListentitys[j].labelVarietyId) {
											//公共配置的标签
											data[i].labelSet = [];
											//把配置的标签付给公共配置的标签，因为标签在配置界面不能删除
											data[i].labelSet = labelTypeInfoListentitys[j].savePubLabelList;
										}
									}
								}
								//维护标签分类数据
								var parameter = {
									"departmentId": obj.departmentId,
									"labelVarietyName": data.labelVarietyName,
									"labelVarietyId": data.labelVarietyId,
									"labelVarietydata": data
								}
								MaintainingLabelClassInfor.push(parameter);
							}
						});
					});
				} else {
					App.alert("该第三方资源还没有配置标签信息，您可以继续添加标签管理！！！！");
				}
			}
		});
	});
	//插入部门信息
	function insertDepartment(departmentName,departmentId){
		model.get("departments").insert({ "departmentname":departmentName, "departmentId":departmentId, assessmentContexts: [] });
		var departConfig = model.get("departments");
		var departlength = departConfig.entityCount;
		departConfig._currentPage[departlength - 1].setCurrent();
	};
	//插入标签分类
	function insertLabelVariety(labelVarietyName,labelVarietyId){
		model.get("departments").current.get("assessmentContexts").insert({ "labelVarietyName": labelVarietyName, "labelVarietyId": labelVarietyId, labelselects: [] });
		var assessmentConfig = model.get("departments").current.get("assessmentContexts");
		var assessConfiglength = assessmentConfig.entityCount;
		assessmentConfig._currentPage[assessConfiglength - 1].setCurrent();
	};
	//插入标签
	function insertLabel(labels){
		var oBuffer = new Array();
		for (var j = 0; j < labels.length; j++) {
			var labelName = labels[j].labelName;
			oBuffer.push(labels[j].labelId);
			model.get("departments").current.get("assessmentContexts").current.get("labelselects").insert({ "labelselectName": labelName });
		}
		return oBuffer;
	}
});