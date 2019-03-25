cola(function (model) {
    //判断要加载的subview
    model.set("templateType","");
    var urlParams=cola.util.queryParams();
    if(urlParams.isQuotationSolution){
        /*标识是否从报价方案配置进入开始*/
        $(".topstep").addClass("display-none");
        $(".entertxt span:nth-child(1)").addClass("display-none");
        $(".entertxt span:nth-child(2)").removeClass("display-none");
        $(".subviewcont2").css({
            marginTop:"0px"
        })
        $(".commonProductInfo").addClass("display-none");
        $(".tempSave").siblings().addClass("display-none");
        $(".tempSave").addClass("currentbtn");
        $(".returnQuotatinConfig").removeClass("display-none");
        $(".wrapcontent #navMain .addproduct").addClass("display-none");
        $(".scrollbar").addClass("display-none");
        $(".topenter").css({
            width:"100%"
        })
        model.set("templateType","quotationPersonalSheet");
        /*标识是否从报价方案配置进入结束*/
    }
    else if(urlParams.isInsuranceGroup){
        model.set("templateType","insuranceGroupsheet");
        //加载对应的css文件
        function loadJsCss(filename, filetype){
            if (filetype=="css")
            {
                var fileref=document.createElement("link")
                fileref.setAttribute("rel", "stylesheet")
                fileref.setAttribute("type", "text/css")
                fileref.setAttribute("href", filename)
            }
            if (typeof fileref!="undefined")
            {
                document.getElementsByTagName("head")[0].appendChild(fileref)
            }
        }
        loadJsCss("contractcenter/group/css/group.less", "css") //打开页面时浏览器动态的加载css 文件
    }
    else{
        model.set("templateType","insurancePolicySheet");
    }

    model.set("uwTaskFlag",true);
    window.readonlyFn = function(){
        cola.ready(function () {
            cola.tag("uwTaskTag").set("readOnly",true);
            cola.tag("uwTaskTag_radio_group").set("readOnly",true);
            cola.tag("uwTaskTag_dropdown").set("disabled",true);
            if(urlParams.taskType == "04" || urlParams.viewFlag == "false"){
                cola.tag("viewFlag_input").set("readOnly",true);
                cola.tag("viewFlag_dropdown").set("disabled",true);
            }
            // cola.tag("readOnlyFalse").set("readOnly",false);
            $(".uwTask_btn").css("display","none");
            //只读状态的下拉框不显示小箭头
            $(".uwTaskTag_dropdown_Class i").css("display","none");
            $(".uwTaskTag_dropdown_Class input").css("cssText","padding-right:0 !important");
            //即时起保复选框设置禁用
            $(".nowTimeCheck").css("pointer-events","none");
            //基本信息大客户标志类型多选设置禁用
            $("#multiselect").css("pointer-events","none");

        })
    }


    $(window).on("insuranceDetail",function () {
        $(function () {
            var initTop = $('.btnGroup').offset().top;
            // var initTop2 = $('.navRightCont').offset().top;
            var maxHeight = ($(window).height() - 150) + 'px';
            $(".rightcontent").css({"max-height": maxHeight, "overflow-y": "auto"});
            $(window).scroll(function () {
                if (initTop <= $(document).scrollTop()) {

                    $('.navRightCont').addClass("fixed-navRightCont");
                    $('.navRightCont').css({
                        "max-height": maxHeight
                    });
                }
                else {

                    $('.navRightCont').removeClass("fixed-navRightCont");
                }

            });

        });
    });

});





