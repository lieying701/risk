cola(function(model){
    var installLiftModel = [{}];

    model.set("surveyInstalllift", installLiftModel);

    var delFlag = false;
    
    model.action({
        addInstallLift: function(){
            var installLift = model.get("surveyInstalllift");
			installLift.insert(installLiftModel);
			installLift.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        delInstallLift: function(obj,index){
            delFlag = true;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条吊装工程情况",
					showDuration: 3000
				});
				return false;
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "吊装工程情况删除成功",
				showDuration: 3000
			});

			delFlag = false;
        }
    })
})