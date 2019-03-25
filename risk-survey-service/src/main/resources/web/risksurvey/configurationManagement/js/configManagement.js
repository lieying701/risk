cola(function (model) {
	  //查询域数据类型
    model.dataType({
        name: "differenceInfoAdd",
        properties: {
        	columnLabels:{
        		caption: "[(#{columnLabels})]",
                dataType: "string",
                validators: ["required"]
            },
            columnNames: {
                caption: "[(#{columnNames})]",
                dataType: "string",
                validators: ["required",function(value){
                	if(value && !(/^[\a-zA-Z0-9]+$/.test(value))){
                		ispublicinforquery = false;
                        return "只能是英文或数字";
                	}
                	ispublicinforquery = true;
                }]
            },
            columnNos:{
            	caption: "[(#{columnNos})]",
                dataType: "string",
                validators: [function (value) {
                	if (value && !(/^[\0-9]+$/.test(value))) {
						App.alert( "只能是数字");
						model.set("differenceInfoAdd.columnNos");
						return "只能是数字";
					}
                }]
            },
            dataTypes:{
            	caption: "[(#{dataTypes})]",
                dataType: "string",
                validators: ["required"]
            },
            pagetypes:{
            	caption: "[(#{pagetypes})]",
                dataType: "string",
                validators: ["required"]
            },
        }
    });
    model.describe("differenceInfoAdd", "differenceInfoAdd");
    model.set("differenceInfoAdd", {});
    
    
    //查询域数据类型
    model.dataType({
        name: "differenceInfoModify",
        properties: {
        	columnLabelsupdate:{
        		caption: "[(#{columnLabelsupdate})]",
                dataType: "string",
                validators: ["required"]
            },
        	columnNamesupdate:{
        		caption: "[(#{columnNamesupdate})]",
                dataType: "string",
                validators: ["required",function (value) {
                	if (value && !(/^[\a-zA-Z0-9]+$/.test(value))) {
                            App.alert( "只能是英文或数字");
                            model.set("differenceInfoModify.columnNamesupdate");
                            return "只能是英文或数字";
                	}
                }]
            },
            columnNosupdate:{
            	caption: "[(#{columnNosupdate})]",
                dataType: "string",
                validators: [function (value) {
                	if (value && !(/^[\0-9]+$/.test(value))) {
						App.alert( "只能是数字");
						model.set("differenceInfoModify.columnNosupdate");
						return "只能是数字";
					}
                }]
            },
            dataTypesupdate:{
            	caption: "[(#{dataTypesupdate})]",
                dataType: "string",
                validators: ["required"]
            },
            pagetypeModify:{
            	caption: "[(#{pagetypeModify})]",
                dataType: "string",
                validators: ["required"]
            },
        }
    });
    model.describe("differenceInfoModify", "differenceInfoModify");
    model.set("differenceInfoModify", {});
	
	
	
	model.set("businessLines", []);


	model.set("groupItems", [{
		"key": "1",
		"value": "是"
	}, {
		"key": "0",
		"value": "否"
	}]);
	model.set("requiredFlaggroupItems", [{
		"key": "1",
		"value": "是"
	}, {
		"key": "0",
		"value": "否"
	}]);

	model.set("dataTypess", [{
		name: "number",
		key: "1"
	}, {
		name: "char",
		key: "2"
	}, {
		name: "Date",
		key: "3"
	}])
	model.set("newDataTypes", [{
		name: "number",
		key: "1"
	}, {
		name: "char",
		key: "2"
	}, {
		name: "Date",
		key: "3"
	}])
	model.set("listpagetypes", [{
		name: "单行文本框",    //c-input
		key: "01"
	}, {
		name: "下拉框",      //c-dropdown
		key: "02"
	}, {
		name: "多行文本框",   //c-textarea
		key: "03"
	}, {
		name: "日期",            //c-datepicker
		key: "04"
	}, {
		name: "多选框",
		key: "05"
	}])

	model.set("pagetypeModifys", [{
		name: "单行文本框",    //c-input
		key: "01"
	}, {
		name: "下拉框",      //c-dropdown
		key: "02"
	}, {
		name: "多行文本框",   //c-textarea
		key: "03"
	}, {
		name: "日期",            //c-datepicker
		key: "04"
	}, {
		name: "多选框",
		key: "05"
	}])


	model.set("displayFlags", "1");
	model.set("requiredFlag", "1"); 
	var typeCooperations = []; // 第三方分类
	var businessLines = [];
	cola.ready(function () {
		// 获取第三方分类
		$.ajax({
			url: "service/basecode/codeDetail/findCachedCodeDetails?baseCodeId=ThirdPartyType",
			type: "GET",
			contentType: "application/json",
			success: function (data) {
				$.each(data, function (index, obj) {
					typeCooperations.push({
						key: obj.kind,
						name: obj.name
					});
				})
				model.set("typeCooperations", typeCooperations);
			}
		});
		$.ajax({
			url: "service/basecode/codeDetail/findCachedCodeDetails?baseCodeId=DepartmentCode",
			type: 'GET',
			contentType: 'application/json',
			success: function (data) {
				$.each(data, function (index, obj) {
					businessLines.push({
						key: obj.kind,
						name: obj.name
					});
				})
				model.set("attributionBusinesss", businessLines);
				model.set("businessLines", businessLines);
			}
		});
	});
	model.set("attributionBusinesss", []);

	// 查询域数据类型
	model.dataType({
		name: "taskInfos",
		properties: {}
	});
	// 数据展示列表数据设置
	model.describe("taskInfo", {
		dataType: "taskInfos",
		provider: {
			url: "thirdparty/controller/thirdDiffInfoNote/listBydepAndType?from={{$from}}&limit={{$limit}}",
			pageSize: 10,
			loadMode: "mantual",
			sendJson: true,
			parameter: "{{thirdDifferenInfo}}",
			beforeSend: function (self, arg) {
				debugger;
				var department = model.get("department");
				var thirdType = model.get("thirdType");
				var parament = {
					"department": department,
					"thirdType": thirdType
				}

				var data = JSON.parse(arg.options.data);
				data["department"] = department;
				data["thirdType"] = thirdType;
				arg.options.data = JSON.stringify(data);
			},
			ajaxOptions: {
				contentType: "application/json",
				sendJson: true
			},
			response: function (self, arg) {
				debugger;
				// var result = arg.result;
				if (arg.result.data$) {
					for (var i = 0; i < arg.result.data$.length; i++) {

						if (arg.result.data$[i].displayFlag == "1") {
							arg.result.data$[i].displayFlag = "是";
						} else {
							arg.result.data$[i].displayFlag = "否";
						}

						if (arg.result.data$[i].requiredFlag == "1") {
							arg.result.data$[i].requiredFlag = "是";
						} else {
							arg.result.data$[i].requiredFlag = "否";
						}
						if (arg.result.data$[i].dataType == "1") {
							arg.result.data$[i].dataType = "number";
						} else if (arg.result.data$[i].dataType == "2") {
							arg.result.data$[i].dataType = "char";
						} else if (arg.result.data$[i].dataType == "3") {
							arg.result.data$[i].dataType = "Date";
						}
						arg.result.data$[i].pageType = changepageType(arg.result.data$[i].pageType);

					}
				}
				return;
			}
		}
	});
	//把界面类型转换为中文
	function changepageType(pageType) {
		switch (pageType) {
			case "01":
				return "单行文本框";
				break;
			case "02":
				return "下拉框";
				break;
			case "03":
				return "多行文本框";
				break;
			case "04":
				return "日期";
				break;
			case "05":
				return "多选框";
				break;
			default:
				break;
		};
	}
	model.action({
		BusinesssChange: function () {
			var department = model.get("department");
			var thirdType = model.get("thirdType");
			if (department == undefined || thirdType == undefined) {
				return false;
			} else {
				//调用  查询方法
				model.action("differenQuery")();
			}
		},
		thirdTypeChange: function () {
			var department = model.get("department");
			var thirdType = model.get("thirdType");
			if (department == undefined || thirdType == undefined) {
				return false;
			} else {
				//调用  查询方法
				model.action("differenQuery")();
			}
		},
		insertField: function () { // 新增字段
			cola.widget("addFields").show();
			model.set("columnLabels", "");
			model.set("columnNames", "");
			model.set("defaultValues", "");
			model.set("dataTypes", "");
			model.set("differenceInfoAdd", "");
			model.set("notes", "");

			model.set("listValuess", "");
			model.set("basecodeIds", "");
			model.set("pagetypes", "");
			model.set("aliasNames", "");
			
			model.set("columnRule");
			model.set("requiredFlag","1");
			model.set("displayFlags","1");

		},
		tabClick: function (id) {// subview懒加载
			cola.widget(id).loadIfNecessary();
		},
		differenQuery: function () { // 查询
			var attributionBusiness = model.get("department");
			var thirdType = model.get("thirdType");
			if (attributionBusiness == undefined || thirdType == undefined) {
				cola.alert("请先选择业务归属条线或第三方分类");
				return false;
			}
			debugger;
			model.flush("taskInfo");
			App.setFieldVisible($(".newAdd"), true, false);
		},
		revise: function (item) { // 修改
			debugger;
			var columnLabels = item._data.columnLabel;
			var columnNames = item._data.columnName;
			var defaultValues = item._data.defaultValue;
			var dataTypes = item._data.dataType;
			var columnNos = item._data.columnNo;
			var displayFlags = item._data.displayFlag;
			var notes = item._data.note;
			var aliasName = item._data.aliasName;
			var baseCodeId = item._data.baseCodeId;

			var listValuesModify = item._data.listValues;
			var pagetypeModify = item._data.pageType;

			var columnRule = item._data.columnRule;  //字段校验规则
			var requiredFlag = item._data.requiredFlag;  //是否必填

			var noteId = item._data.noteId;

			cola.widget("updateFields").show();

			model.set("columnLabelsupdateid", noteId);
			model.set("differenceInfoModify.columnLabelsupdate", columnLabels);
			model.set("differenceInfoModify.columnNamesupdate", columnNames);
			model.set("defaultValuesupdate", defaultValues);
			model.set("differenceInfoModify.dataTypesupdate", dataTypes);
			model.set("differenceInfoModify.columnNosupdate", columnNos);
			model.set("aliasNameModify", aliasName);
			model.set("basecodeIdModify", baseCodeId);
			model.set("listValuesModify", listValuesModify);
			model.set("differenceInfoModify.pagetypeModify", pagetypeModify);

			model.set("columnRuleModify", columnRule);
			if (requiredFlag == "是") {
				model.set("requiredFlagModify", "1");
			} else {
				model.set("requiredFlagModify", "0");
			}


			if (displayFlags == "是") {
				model.set("displayFlagsupdate", "1");
			} else {
				model.set("displayFlagsupdate", "0");
			}
			model.set("notesupdate", notes);
		},
		unCancel: function (item) { // 恢复
			debugger;
			var noteId = item._data.noteId;
			var parament = {
				"noteId": noteId
			}
			$.ajax({
				url: "thirdparty/controller/thirdDiffInfoNote/unCancelThirdDiffInfoNote",
				type: "POST",
				data: JSON.stringify(parament),
				contentType: "application/json",
				success: function (data) {
					debugger;
					model.flush("taskInfo");

				},
				error: function () {
					App.alert("恢复失败");
				}
			})
		},
		recallTask: function (item) { // 注销
			debugger;
			var noteId = item._data.noteId;
			var parament = {
				"noteId": noteId
			}
			$.ajax({
				url: "thirdparty/controller/thirdDiffInfoNote/cancelThirdDiffInfoNote",
				type: "POST",
				data: JSON.stringify(parament),
				contentType: "application/json",
				success: function (data) {
					debugger;
					model.flush("taskInfo");

				},
				error: function () {
					App.alert("注销失败");
				}
			})
		},
		recallTasks: function (taskInfo) { // x下面的总注销
			debugger;
			if(taskInfo.current._data.$selected){
			}else{
				App.alert("请选择需要注销的内容");
				return false;
			}
			var noteId = [];
			taskInfo.each(function (entity) {
				if (entity.get("$selected")) {
					debugger;
					noteId.push(entity._data.noteId);
				}
			});
			var parament = {
				"noteIds": noteId
			}
			$.ajax({
				url: "thirdparty/controller/thirdDiffInfoNote/cancelThirdDiffInfoNoteByIds",
				type: "POST",
				data: JSON.stringify(parament),
				contentType: "application/json",
				success: function (data) {
					debugger;
					model.flush("taskInfo");

				},
				error: function () {
					App.alert("注销有异常");
				}
			})

		},
		cofirmInsertField: function () { // 新增确定
			debugger;
			var department = model.get("department");
			var thirdType = model.get("thirdType");

			var columnLabels = model.get("differenceInfoAdd.columnLabels");
			var columnNames = model.get("differenceInfoAdd.columnNames");
			var defaultValues = model.get("defaultValues");
			var dataTypes = model.get("differenceInfoAdd.dataTypes");
			// var alias=model.get("alias");
			var columnNos = model.get("differenceInfoAdd.columnNos");
			var displayFlags = model.get("displayFlags");
			var notes = model.get("notes");
			var aliasName = model.get("aliasNames");
			var pageType = model.get("differenceInfoAdd.pagetypes");
			var baseCodeId = model.get("basecodeIds");
			var listValues = model.get("listValuess");

			var columnRule = model.get("columnRule");  //字段校验规则
			var requiredFlag = model.get("requiredFlag");  //是否必填
			
            if(columnLabels==null || columnLabels.trim() == ""){
            	App.alert("标识不能为空");
            	return false;
            }
			if (columnNames==null || columnNames.trim() == "") {
				App.alert("名称不能为空");
				return false;
			}
			if (dataTypes==null || dataTypes.trim() == "") {
				App.alert("数据类型不能为空");
				return false;
			}
			if (pageType==null || pageType.trim() == "") {
				App.alert("界面类型不能为空");
				return false;
			}
			if (pageType == "02") {     //判断界面类型为下拉框或者多选框时，基础代码值或下拉列表不能同时为空
				if (baseCodeId == "" && listValues == "") {
					App.alert("界面类型为下拉框时,基础代码值和下拉列表不能同时为空");
					return false;
				}
			}
			if (pageType == "05") {     //判断界面类型为下拉框或者多选框时，基础代码值或下拉列表不能同时为空
				if (baseCodeId == "" && listValues == "") {
					App.alert("界面类型为多选框时,基础代码值和下拉列表不能同时为空");
					return false;
				}
			}

			var parament = {
				"columnLabel": columnLabels,
				"columnName": columnNames,
				"defaultValue": defaultValues,
				"dataType": dataTypes,
				"columnNo": columnNos,
				"displayFlag": displayFlags,
				"note": notes,
				"department": department,
				"thirdType": thirdType,
				"aliasName": aliasName,   //字段别名
				"pageType": pageType,       //界面类型
				"baseCodeId": baseCodeId,    //基础代码值
				"listValues": listValues,     //下拉列表值
				"columnRule": columnRule,     //校验规则
				"requiredFlag": requiredFlag    //是否必填
			}
			$.ajax({
				url: "thirdparty/controller/thirdDiffInfoNote/insertThirdDiffInfoNote",
				type: "POST",
				data: JSON.stringify(parament),
				contentType: "application/json",
				success: function (data) {
					debugger;

					cola.widget("addFields").hide();
					model.flush("taskInfo");
				},
				error: function () {
					App.alert("新增失败");
				}
			})

		},
		cofirmInsertFieldupdate: function () {                                         //修改点击确定

			debugger;
			var noteId = model.get("columnLabelsupdateid");

			var columnLabelsupdate = model.get("differenceInfoModify.columnLabelsupdate");//标识
			var columnNamesupdate = model.get("differenceInfoModify.columnNamesupdate");//名称
			var defaultValuesupdate = model.get("defaultValuesupdate");//默认值
			var dataTypesupdate = model.get("differenceInfoModify.dataTypesupdate");//数据类型
			var columnNosupdate = model.get("differenceInfoModify.columnNosupdate");//字符排序
			var displayFlagsupdate = model.get("displayFlagsupdate");//是否可见
			var notesupdate = model.get("notesupdate");            //说明
			var aliasNameModify = model.get("aliasNameModify");//字段别名

			var columnRule = model.get("columnRuleModify");
			var requiredFlag = model.get("requiredFlagModify");

			var department = model.get("department");
			var thirdType = model.get("thirdType");
			var pagetypeModify = model.get("differenceInfoModify.pagetypeModify");    //界面类型
			if(columnLabelsupdate==null || columnLabelsupdate.trim() == ""){
				App.alert("标识不能为空");
				return false;
			}
			if (pagetypeModify == "单行文本框" || pagetypeModify == "01") {
				pagetypeModify = "01";
			} else if (pagetypeModify == "下拉框" || pagetypeModify == "02") {
				pagetypeModify = "02";
			} else if (pagetypeModify == "多行文本框" || pagetypeModify == "03") {
				pagetypeModify = "03";
			} else if (pagetypeModify == "日期" || pagetypeModify == "04") {
				pagetypeModify = "04";
			} else if (pagetypeModify == "多选框" || pagetypeModify == "05") {
				pagetypeModify = "05";
			} else {
				pagetypeModify = "";
			}
			var basecodeIdModify = model.get("basecodeIdModify");   //基础代码值
			var listValuesModify = model.get("listValuesModify");    //下拉列表值
			if (columnNamesupdate == null || columnNamesupdate == "") {
				App.alert("名称不能为空");
				return false;
			}
			if (dataTypesupdate == null || dataTypesupdate == "") {
				App.alert("数据类型不能为空");
				return false;
			}
			if(dataTypesupdate == "number" || dataTypesupdate =="1"){
				dataTypesupdate = "1";
			}else if(dataTypesupdate == "char" || dataTypesupdate =="2"){
				dataTypesupdate = "2";
			}else if(dataTypesupdate == "Date" || dataTypesupdate =="3"){
				dataTypesupdate = "3";
			}
			if (pagetypeModify == null || pagetypeModify == "") {
				App.alert("界面类型不能为空");
				return false;
			}
			if (pagetypeModify == "02") {     //判断界面类型为下拉框或者多选框时，基础代码值或下拉列表不能同时为空
				if (basecodeIdModify == "" && listValuesModify == "") {
					App.alert("界面类型为下拉框时,基础代码值和下拉列表不能同时为空");
					return false;
				} else if (basecodeIdModify == undefined && listValuesModify == undefined) {
					App.alert("界面类型为下拉框时,基础代码值和下拉列表不能同时为空");
					return false;
				}
			}
			if (pagetypeModify == "05") {     //判断界面类型为下拉框或者多选框时，基础代码值或下拉列表不能同时为空
				if (basecodeIdModify == "" && listValuesModify == "") {
					App.alert("界面类型为多选框时,基础代码值和下拉列表不能同时为空");
					return false;
				} else if (basecodeIdModify == undefined && listValuesModify == undefined) {
					App.alert("界面类型为多选框时,基础代码值和下拉列表不能同时为空");
					return false;
				}
			}
			var parament = {
				"noteId": noteId,
				"department": department,
				"thirdType": thirdType,
				"columnLabel": columnLabelsupdate,
				"columnName": columnNamesupdate,
				"defaultValue": defaultValuesupdate,
				"dataType": dataTypesupdate,
				"columnNo": columnNosupdate,
				"displayFlag": displayFlagsupdate,
				"note": notesupdate,
				"aliasName": aliasNameModify,
				"listValues": listValuesModify,
				"baseCodeId": basecodeIdModify,
				"pageType": pagetypeModify,
				"columnRule": columnRule,     //校验规则
				"requiredFlag": requiredFlag    //是否必填
			}
			$.ajax({
				url: "thirdparty/controller/thirdDiffInfoNote/updateThirdDiffInfoNote",
				type: "POST",
				data: JSON.stringify(parament),
				contentType: "application/json",
				success: function (data) {
					debugger;
					cola.widget("updateFields").hide();
					model.flush("taskInfo");
				},
				error: function () {
					App.alert("修改失败");
				}
			})
		},
		reset: function () {
			model.set("columnLabels", "");
			model.set("defaultValues", "");
			model.set("dataTypes", "");
			model.set("differenceInfoAdd", "");
			model.set("notes", "");

			model.set("listValuess", "");
			model.set("basecodeIds", "");
			model.set("pagetypes", "");
			model.set("aliasNames", "");
			
			model.set("columnRule");
			model.set("requiredFlag","1");
			model.set("displayFlags","1");
		},
		resetupdate: function () {

			model.set("columnLabelsupdate", "");
			model.set("defaultValuesupdate", "");
			model.set("dataTypesupdate", "");
			model.set("differenceInfoModify", "");
			model.set("notesupdate", "");

			model.set("listValuesModify", "");
			model.set("basecodeIdModify", "");
			model.set("pagetypeModify", "");
			model.set("aliasNameModify", "");
			
			model.set("displayFlagsupdate","1");
			model.set("columnRuleModify");
			model.set("requiredFlagModify","1");
			
		}
	})
});