cola(function(model){

    var tunnelModel = [{}];

    model.set("surveyTunnel", tunnelModel);

    var delFlag = false;

    model.action({
        addTunnel: function(){
            var tunnel = model.get("surveyTunnel");
			tunnel.insert(tunnelModel);
			tunnel.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        delTunnel: function(obj,index){
            delFlag = true;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条隧道施工风险",
					showDuration: 3000
				});
				return false
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "隧道施工风险删除成功",
				showDuration: 3000
			});

			delFlag = false;
        }
    })
})