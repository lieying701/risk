cola(function(model){
    var pipingModel = [{}];

    model.set("surveyPiping", pipingModel);

    var delFlag = false;
    
    model.action({
        addPiping: function(){
            var piping = model.get("surveyPiping");
			piping.insert(pipingModel);
			piping.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        delPiping: function(obj,index){
            delFlag = true;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条管道施工风险",
					showDuration: 3000
				});
				return false;
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "管道施工风险删除成功",
				showDuration: 3000
			});

			delFlag = false;
        }
    })
})