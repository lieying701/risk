cola(function(model){

    var railwayModel = [{}];

    model.set("surveyRailway", railwayModel);

    var delFlag = false;

    model.action({
        addRailway: function(){
            var railway = model.get("surveyRailway");
			railway.insert(railwayModel);
			railway.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        delRailway: function(obj,index){
            delFlag = true;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条公路铁路工程风险",
					showDuration: 3000
				});
				return false
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "公路铁路工程风险删除成功",
				showDuration: 3000
			});

			delFlag = false;
        }
    })
})