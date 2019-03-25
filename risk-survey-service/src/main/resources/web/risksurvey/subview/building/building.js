cola(function(model){

    var buildingModel = [{}];

    model.set("surveyBuildconstruct", buildingModel);

    var delFlag = false;

    model.action({
        addBuilding: function(){
            var building = model.get("surveyBuildconstruct");
			building.insert(buildingModel);
			building.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        delBuilding: function(obj,index){
            delFlag = true;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条楼宇工程风险",
					showDuration: 3000
				});
				return false
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "楼宇工程风险删除成功",
				showDuration: 3000
			});

			delFlag = false;
        }
    })
})