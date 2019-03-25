cola(function (model) {

    var actualId = model.get("insurancePolicy.actualId");
    var status=sessionStorage.getItem("status");
    status=="04"?model.set("flag",true):model.set("flag",false);

    if (actualId) {
        //表格数据
        $.ajax({//开始投保单摘要信息
            url:"controller/uw/autoriskInfo/findByActualId?actualId="+actualId,
            type: "GET",
            contentType: "application/json",
            success: function (data) {

                var covertData = data;
                debugger

                model.set("riskInfo", covertData);
            }
        });
    } else {
        cola.alert("没有业务单号");
    }

    model.action({
        // saveSug: function () {
        //     var resultEntity=model.get("riskInfo").current;
        //     $.ajax({//保存核保意见信息
        //         url:"controller/uw/autoriskInfo/storeSuggestion",
        //         type: "POST",
        //         data:{
        //             actualId:actualId,
        //             ruleNo:resultEntity.get("ruleNo"),
        //             suggestion:resultEntity.get("suggestion")
        //         },
        //         success: function (data) {
        //             console.log("222");
        //         }
        //     });
        // }
    })

});