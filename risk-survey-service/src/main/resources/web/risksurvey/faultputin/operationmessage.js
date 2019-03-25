function OperationPage (self,openTab,openPage,closePage,cmd,toscrollTop,sendmessage2){
    var self=null;
    this.selfConfig = function(_self){
        self = _self;
    };
    //this.findWorkbenchTopWindow = function(){
    //    tagWindow = window;
    //    for (var i = 0 ; i<10 ; i++ ){
    //        if(!tagWindow.parent){
    //            tagWindow = tagWindow.parent
    //            if(tagWindow.UNIC_WORKBENCH){
    //                return tagWindow ;
    //            }else{
    //                //继续找parent
    //            }
    //        }else{
    //            return tagWindow ;
    //        }
    //    }
    //};
    this.sendmessage = function (message) {
        //var tagP = OperationPage.findWorkbenchTopWindow();
        window.parent.postMessage({
            status:"sendsuccess",
            content:message
        }, "*")
    };
    this.openTab = function (name,url) {
        window.parent.postMessage({
            status:"open",
            name: name,
            url: url
        }, "*")
    }
    this.openPage = function (name,url,self) {
        //debugger
        if (window.frames.length != parent.frames.length) {
            this.cmd("open", name, url);
        }else{
            if(self){
                window.open(url,self);
            }else{
                window.open(url);
            }
        }
    };
    this.openNewTab = function (url) {
        window.parent.postMessage({
            status:'openNewTab',
            url:url
        }, "*")
    };
    this.closePage = function () {
        if (window.frames.length != parent.frames.length) {
            this.cmd("close");
        }else{
            window.location.href = "about:blank";
            window.close();
        }
    };
    this.resf = function(){
        window.parent.postMessage({
            status:'resfresh'
        }, "*")
    };
    this.centerMessage = function (content) {
        //debugger
        this.message("c-message",content);
    };
    this.mask = function (status) {
        window.parent.postMessage({
            status:status
        }, "*")
    };
    this.cmd = function (status,name,url,kind,widgetElementId,id,$dom) {
        //debugger
        if (window.frames.length != parent.frames.length) {
            window.parent.postMessage({
                status:status,
                name: name,
                url: url
            }, "*")
        }else{
            window.location.href = "about:blank";
            window.close();
        }
    };
    this.message = function (status,content) {
        window.parent.postMessage({
            status:status,
            content: content
        }, "*")
    };


}
var OperationPage = new OperationPage();
OperationPage.selfConfig(self);

//带workbench的路径
//var contextPath = window.location.href.substr(0,window.location.toString().indexOf("/",window.location.origin.length+1)+1);
//不带workbench的路径
//var namePath = window.location.href.substr(0,window.location.href.indexOf("workbench"));
//console.log(contextPath)