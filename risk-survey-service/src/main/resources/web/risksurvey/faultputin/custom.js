App.alert=function(content){
    cola.NotifyTipManager.warning({
        message:"",
        description:content,
        showDuration:3000
    });
}
cola.defaultAction.dropDownTitle = function(itemName,itemCode) {
    if(itemName){
        if(itemCode){
            return itemCode+'-'+itemName;
        }else{
            return itemName;
        }
    }else{
        return "";
    }
}
cola.defaultAction.magnifyInputTip = function(self) {
    var $tip, path;
    self.set({
        input: function (self, arg) {
            var _val = arg.inputValue;
            if(_val){
                _val=_val.toString();
                _val= _val.replace(/\s/g,'').replace(/(.{4})/g,"$1 ");
            }
            self.get("model").set(path, _val);
        },
        focus: function (self) {
            if (!$tip) {
                var id = self.getDom().id || cola.uniqueId();
                path = id + "TipText";

                var tipId = id + "Tip";
                $tip = $("#" + tipId).addClass("input-tip");
                if (!$tip.length) {
                    $tip = $(cola.xRender({
                        id: tipId,
                        class: "input-tip",
                        "c-bind": path
                    }, self.get("model")));
                    $(document.body).append($tip);
                }
            }
            var _val = self.get("value");
            if(_val){
                _val=_val.toString();
                _val= _val.replace(/\s/g,'').replace(/(.{4})/g,"$1 ");
            }
            self.get("model").set(path,_val);

            var $inputDom = self.get$Dom();
            var offset = $inputDom.offset();
            $tip.css({
                //left: offset.left + $inputDom.width() / 2,
                left: offset.left,
                top: offset.top
            }).show();
        },
        blur: function (self) {
            $tip.hide();
        }
    });
}
window.openDoc=function(dom,text){
    if(!text){
        $(dom).popup({
            position   : 'top right',
            title:"知识库",
            on:"click"
        });
        $(dom).popup("show");
    }else{
        $.ajax({
            url:"controller/knowledge/knowledge/knowledge?keywords="+text,
            type:"GET",
            success:function (data) {
                var memo="";
                var detailUrl="";
                if(data.memo){
                    memo=data.memo;
                }
                if(data.detailUrl) {
                    detailUrl = data.detailUrl;
                }
                $(dom).popup({
                    position   : 'top right',
                    title:"知识库",
                    html : memo+"   <a href='"+detailUrl+"' target='_blank'>详细</a>",
                    on:"click"
                });
                $(dom).popup("show");
            }
        });
    }
}
var gloalknowledgePopup={
    text:"",
    dom:undefined
};
var customPopGuide="<div class='ui custom popup custompopup' style='z-index:9999'><span class='custompopguide'></span><span class='custompoptext'><span></div>";
$('body').append(customPopGuide);
var fragment="<i class='help circle icon' onClick='knowledgePopup(this)' style='float:right'></i>"
$(".knowledge").append(fragment);
window.knowledgePopup=function(_self){ 
    debugger
    event.stopPropagation(); 
    var kng$ = $(_self).closest(".knowledgeWrap")
    $(_self).popup({
        popup:$(".custompopup"),     
        hoverable:true,
        target :kng$,
        boundary:window,
        position:"bottom left",
        onShow:function(self){
        debugger;
        var text=$(_self).parent().attr("data-knowledge");
    if(text){
        $.ajax({
            url:"controller/knowledge/knowledge/knowledge?keywords="+text,
            type:"GET",
            success:function (data) {
                debugger;
                var memo="";
                var detailUrl="";
                if(data.memo){
                    memo=data.memo;
                }
                if(data.detailUrl) {
                    detailUrl = data.detailUrl;
                }
                $(".custompoptext span").text(memo);
                $(".custompoptext a").attr("href",detailUrl);
            }
        });
      
    }
        }
    });
    $(_self).popup("show");
    event.stopPropagation();
}
window.knowledgePopupShow=function() {  

    $(".custompopguide").hide();
   
}