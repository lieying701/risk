cola(function(model){
    model.set("status",true)
    model.set("XTname",[
        {name:"保单中心"},
        {name:"报价中心"},
        {name:"统一工作台"}
    ])
    //$.ajax({
    //    url: "service/product/productClass/getCachedProductClasses",
    //    type: "post",
    //    contentType: "application/json ",
    //    success: function (data) {
    //    }
    //})
    model.describe("fultputininfo", "Fultputininfo");
    model.set("fultputininfo", {});
    model.set("items", [
        {
            key: "0",
            value: "是"
        },
        {
            key: "1",
            value: "否"
        }
    ]);
    model.set("customerWaiting","1");
    model.set("faultPage","");
    model.set("faultButton","");
    
    function submits(){
        $.ajax({
            url: "controller/workbench/FaultReporting/insertFaultReporting",
            type: "POST",
            contentType: "application/json ",
            data:JSON.stringify({
                "customerWaiting":model.get("customerWaiting"),//是否客户等待
                "faultDescription":model.get("faultDescription"),//问题描述
                "faultType":model.get("WTLX"),//问题类型
                "systemName":model.get("XTMC"),// 系统名称
                "operationStep":"[故障页面]:"+model.get("faultPage")+";"+"[故障按钮]:"+model.get("faultButton")+";"+"[操作步骤]:"+model.get("operationStep"),//操作步骤
                "businessNo":model.get("operationNumber"),//业务号
                "productClass":model.get("CPFL"),//产品分类
                "faultCharacter":model.get("faultCharacter"),//问题现象
                "paths":model.get("imgFiles"),//图片路径
                "userEmail":model.get("userEmail"),
                "userPhone":model.get("userPhone")
            }),
            success: function (data) {
                if(data.lineNo){
                    App.alert("提交成功")
                    model.set("customerWaiting","0"),//是否客户等待
                    model.set("faultDescription",""),//问题描述
                    model.set("WTLX",""),//问题类型
                    model.set("XTMC",""),// 系统名称
                    model.set("faultPage",""),//故障页面
                    model.set("faultButton",""),//故障按钮
                    model.set("operationStep",""),//操作步骤
                    model.set("operationNumber",""),//业务号
                    model.set("CPFL",""),//产品分类
                    model.set("faultCharacter","")//问题现象
                    model.set("userPhone","")//手机号
                    model.set("userEmail","")//邮箱
                    setTimeout(function () {
                        OperationPage.openPage("历史故障查询","./workbench/warning/history/history.html")
                    },1000)
                }else{
                    App.alert("提交失败");
                }
            }
        })
    }
    model.action({
    	
    	filter:function(fileName){
    		return fileName.get('file').toString().indexOf('xlsx') > -1;
    	},
    	filterN:function(fileName){
    		return fileName.get('file').toString().indexOf('xlsx') == -1;
    	},
    	openExcel: function(fileName){
    		window.open(fileName.get('file').toString());
    	},
        Submit:function(){

            model.get("imgFiles");
            if(!model.get("faultDescription")){
                App.alert("故障描述不能为空！");
            }else if(!model.get("XTMC")){
                App.alert("系统名称不能为空！");
            }else if(!model.get("WTLX")){
                App.alert("问题类型不能为空！");
            }else if(!model.get("CPFL")){
                App.alert("产品分类不能为空！");
            }else if(!model.get("faultPage")){
                App.alert("故障页面不能为空！");
            }else if(!model.get("faultButton")){
                App.alert("故障按钮不能为空！");
            }else if(!model.get("operationStep")){
                App.alert("操作步骤不能为空！");
            }else if(model.get("faultDescription").length>30){
                App.alert("故障描述长度不能超过30字！");
            }else if(model.get("faultCharacter")&&model.get("faultCharacter").length>300){
                App.alert("问题现象长度不能超过300字！");
            }else if(model.get("operationNumber")&&model.get("operationNumber").length>30){
                App.alert("业务号长度不能超过30字！");
            }else if(model.get("operationStep")&&model.get("operationStep").length>300){
                App.alert("操作步骤长度不能超过300字！");
            }else if(!model.get("userEmail")&&!model.get("userPhone")){
                App.alert("请完善手机号或者邮箱！");
            }else{
                $(".primary").css("background","gray");
                $(".primary").css("border","gray");
                $(".primary").css("pointer-events","none");
                $(".primary").css("-webkit-box-shadow","none");
                setTimeout(function () {
                    $(".primary").css("background","#009966");
                    $(".primary").css("border","#009966");
                    $(".primary").css("pointer-events","auto");
                    $(".primary").css("-webkit-box-shadow","0 0 0 1px #009966 inset");
                },5000)
                submits()
            }
        },
        nameClick: function (name) {
            model.set("WTLX","");
            if(name==null){
                model.set("status",true)
            }
            if(name=="保单中心"){
                model.set("WTtype",[
                    {name:"网速慢(SSLVPN)"},
                    {name:"网速慢(IPSECVPN)"},
                    {name:"登录问题"},
                    {name:"账号权限问题"},
                    {name:"平台交互问题(平台交互报错)"},
                    {name:"投保环节问题"},
                    {name:"批改环节问题"},
                    {name:"保费计算问题(保费不正确)"},
                    {name:"投保单、批单保费计算问题(无法保存)"},
                    {name:"手续费计算问题"},
                    {name:"提交核保、核批问题"},
                    {name:"核保核批查询问题"},
                    {name:"核保核批级别问题"},
                    {name:"核保核批通过问题(核不过)"},
                    {name:"核保系统其它问题"},
                    {name:"团单导入问题"},
                    {name:"电子保单问题"},
                    {name:"保单打印格式问题(保单打印问题)"},
                    {name:"投保单、批单保存问题(无法保存)"},
                    {name:"有线POS刷卡问题（生成保单失败）"},
                    {name:"无线POS刷卡问题（生成保单失败）"},
                    {name:"支票缴费问题"},
                    {name:"发票相关问题"},
                    {name:"非车承保其他问题"},
                    {name:"车险承保其他问题"}
                ]);
                model.set("status",false)
                $(".ui.input input:read-only").css("background","#ffffff !important")
            }
            if(name=="报价中心"){
                model.set("WTtype",[
                    {name:"网速慢(SSLVPN)"},
                    {name:"网速慢(IPSECVPN)"},
                    {name:"登录问题"},
                    {name:"账号权限问题"},
                    {name:"平台交互问题(平台交互报错)"},
                    {name:"报价环节问题"},
                    {name:"保费计算问题(保费不正确)"},
                    {name:"投保单保费计算问题(无法保存)"},
                    {name:"手续费计算问题"},
                    {name:"提交报价问题"},
                    {name:"报价查询问题"},
                    {name:"报价级别问题"},
                    {name:"报价无法完成问题"},
                    {name:"报价系统其它问题"},
                    {name:"团单导入问题"},
                    {name:"报价单打印格式问题"},
                    {name:"报价单保存问题(无法保存)"},
                    {name:"报价系统其它问题"}
                ]);
                model.set("status",false)
                $(".ui.input input:read-only").css("background","#ffffff !important")
            }
            if(name=="统一工作台"){
                model.set("WTtype",[
                    {name:"网速慢(SSLVPN)"},
                    {name:"网速慢(IPSECVPN)"},
                    {name:"登录问题"},
                    {name:"账号权限问题"},
                    {name:"平台交互问题(平台交互报错)"}
                ]);
                model.set("status",false)
                $(".ui.input input:read-only").css("background","#ffffff !important")
            }
        },
        
    })
});