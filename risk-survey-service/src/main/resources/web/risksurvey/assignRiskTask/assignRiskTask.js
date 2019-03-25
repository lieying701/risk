cola(function(model){
    model.set("institutionItems",[{
        key : "01",
        value : "一级"
    },{
        key : "02",
        value : "二级"
    },{
        key : "03",
        value : "三级"
    }
    ]);
    model.set("surveyMembers",[{
        key : "01",
        value : "小李"
    },{
        key : "02",
        value : "小张"
    },{
        key : "03",
        value : "test"
    }
    ])

    model.action({
        confirmAssign: function(){
            console.log("click confirm assign btn...");
        },
        cancelAssign: function(){
            console.log("click cancel assign btn...");
        }
    })
})