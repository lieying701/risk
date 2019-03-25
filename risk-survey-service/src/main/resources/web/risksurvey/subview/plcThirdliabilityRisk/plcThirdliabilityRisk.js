cola(function(model){
    model.set("buildTypeItems",[{
        key : "01",
        value : "民宅公寓"
    },{
        key : "02",
        value : "工矿企业"
    },{
        key : "03",
        value : "商业服务业"
    },{
        key : "04",
        value : "公共建筑"
    },{
        key : "05",
        value : "多层建筑"
    },{
        key : "06",
        value : "高层建筑"
    },{
        key : "07",
        value : "其他建筑"
    }
    ])

    var thirdLiaRiskModel = [{}];

    model.set("surveyThirdduty", thirdLiaRiskModel);

    var delFlag = false;

    model.action({
        addThirdLiaRisk: function(){
            var thirdLiaRisk = model.get("surveyThirdduty");
			thirdLiaRisk.insert(thirdLiaRiskModel);
			thirdLiaRisk.each(function (data, index) {
				data.set("serialNo", index + 1)
			})
        },
        delThirdLiaRisk: function(obj,index){
            delFlag = true;
			if (obj.parent.entityCount <= 1) {
				cola.NotifyTipManager.warning({
					message: "",
					description: "请至少保留一条第三者责任风险",
					showDuration: 3000
				});
				return false
			}
			obj.remove();
			cola.NotifyTipManager.warning({
				message: "",
				description: "第三者责任风险删除成功",
				showDuration: 3000
			});

			delFlag = false;
        }
    })
})