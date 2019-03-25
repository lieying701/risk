cola(function(model){

    var stationModel = [{
    	buildAllConCostRate: null,
    	buildCoverConCostRate: null,
    	stationName: null
    }];

    model.set("surveyStation", stationModel);

    var delFlag = false;

    model.action({
        addStation: function(){
            var station = model.get("surveyStation");
			station.insert(stationModel);
			station.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        delStation: function(obj,index){
            delFlag = true;
            debugger;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条车站施工风险",
					showDuration: 3000
				});
				return false;
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "车站施工风险删除成功",
				showDuration: 3000
			});

			delFlag = false;
        }
    })
})