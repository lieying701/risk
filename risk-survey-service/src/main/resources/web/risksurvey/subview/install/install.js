cola(function(model){
    var installModel = [{}];

    model.set("surveyInstall", installModel);

    var delFlag = false;
    
    model.action({
        addInstall: function(){
            var install = model.get("surveyInstall");
			install.insert(installModel);
			install.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        delInstall: function(obj,index){
            delFlag = true;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条安装试车风险信息",
					showDuration: 3000
				});
				return false;
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "安装试车风险删除成功",
				showDuration: 3000
			});

			delFlag = false;
        }
    })
})