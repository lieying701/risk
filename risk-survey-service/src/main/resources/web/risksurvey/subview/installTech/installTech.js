cola(function(model){
    var installTechModel = [{}];

    model.set("surveyInstalltech", installTechModel);

    var delFlag = false;
    
    model.action({
        addInstallTech: function(){
            var installTech = model.get("surveyInstalltech");
			installTech.insert(installTechModel);
			installTech.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        delInstallTech: function(obj,index){
            delFlag = true;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条工艺流程",
					showDuration: 3000
				});
				return false;
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "工艺流程删除成功",
				showDuration: 3000
			});

			delFlag = false;
        }
    })
})