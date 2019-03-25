cola(function(model){
    model.action({
        selectBlock: function (blockId, _self) {
            if(blockId=="00"){return;}
            var screenWidth=$(window).width();
            // if(screenWidth<1024){
            //     $('.rightcontent').slideUp();
            // }
            window.scrollFlag = true;
            $('#navRight li').removeClass("currentNav");
            $(_self).addClass("currentNav");
            if ($("#" + blockId).offset()) {
                $(window).scrollTop($("#" + blockId).offset().top - 40);
            }
        }
    })

})