cola(function (model) {
    model.describe("homemenus", {
        provider: {
            url: "./risksurvey/data/menu.json",
            response:function(self,arg){
            	arg.result=JSON.parse(arg.result);
            }
        }
    });

    model.widgetConfig({
        menuTree: {
            autoCollapse: true,
            autoExpand: true,
            bind: {
                expression: "menu in menus",
                textProperty: "label",
                child: {
                    recursive: true,
                    textProperty: "label",
                    expression: "menu in menu.menus"
                }
            },
        },
        homemenuTree: {
            autoCollapse: true,
            autoExpand: true,
            bind: {
                expression: "homemenu in homemenus",
                textProperty: "label",
                child: {
                    recursive: true,
                    textProperty: "label",
                    expression: "homemenu in homemenu.homemenus"
                }
            },
            itemClick: function (self, arg) {
                var data = arg.item.get("data").toJSON();

                if (data.path) {
                    if(data.label=="登录"){
                        location.href=data.path;
                    }else{
                        cola.widget("changeIframe").set("path",data.path);
                    }
                }

            }
        }
    })
    //兼容统一工作台环境外的新页面打开
        $(window).on("message",function(evt){
            var data = evt.originalEvent.data;
            if(data.status=="open"){
                open(data.url,"_blank")
            }else if(data.status=="close"){
            }
            if(data.scrollTo="scrollTo"){
            }
            if(data.url == "myTask"){
            }
        });


})