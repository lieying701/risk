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
var customPopLayer="<div class='ui custom popup custompopup'><span class='custompopguide'></span><span class='custompoptext'><span></div>";
/*
* left,top,width为popup样式
* positionclass用于给箭头定位
* */
window.knowledgePopup=function(_self,left,top,width,positionclass){

    var kng$ = $(_self).closest(".knowledgeWrap");
     var cusPopup$=kng$.find('.custompopup');
    if(cusPopup$.size()==0){
        $(_self).after(customPopLayer);
        cusPopup$=kng$.find('.custompopup');
        cusPopup$.css({
            left:left+'px',
            top:top+'px',
            width:width+'px'
        });
        if(positionclass)cusPopup$.addClass(positionclass);
        var text=$(_self).parent().attr("data-knowledge");
        if(text){
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
                    kng$.find(".custompoptext span").text(memo);
                    kng$.find(".custompoptext a").attr("href",detailUrl);
                }
            });
        }
        kng$.on('mouseleave',function(){
            cusPopup$.hide();
        });
    }
    cusPopup$.show();
    event.stopPropagation();
}



