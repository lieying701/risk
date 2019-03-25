cola(function(model){
    model.set("crossRiverFlagItems",[
        { "key":"0","value":"否" },
        { "key":"0","value":"是" }
    ])

    var bridgeModel = [{}];

    model.set("surveyBridge", bridgeModel);

    var delFlag = false;

    model.action({
        addBridge: function(){
            var bridge = model.get("surveyBridge");
			bridge.insert(bridgeModel);
			bridge.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        delBridge: function(obj,index){
            delFlag = true;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条桥梁施工风险信息",
					showDuration: 3000
				});
				return false
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "桥梁施工风险删除成功",
				showDuration: 3000
			});

			delFlag = false;
        }
    })
})