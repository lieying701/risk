App.alert=function(content){
    var tip = new cola.NotifyTip({
        class: "cl-toast",
        type: "info",
        description: content,
        showDuration:"2000"
    });
    if($(".cl-toast-wrap").length!=0){
        $(".cl-toast-wrap").append(tip.getDom());
    }else{
        var toastDom = $.xCreate({
            tagName: "Div",
            "class": "cl-toast-wrap"
        });
        toastDom.appendChild(tip.getDom());
        window.document.body.appendChild(toastDom);
    }
    tip.show();
}