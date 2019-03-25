cola(function(model){

    var roadModel = [{}];

    model.set("surveyRoad", roadModel);

    var delFlag = false;

    model.action({
        addRoad: function(){
            var road = model.get("surveyRoad");
			road.insert(roadModel);
			road.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        delRoad: function(obj,index){
            delFlag = true;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条道路施工风险",
					showDuration: 3000
				});
				return false
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "道路施工风险删除成功",
				showDuration: 3000
			});

			delFlag = false;
        }
    })
})