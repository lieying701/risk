cola(function (model) {
    var params = cola.util.queryParams();
    var actualId = params.actualId;
    var productCode = params.productCode;
    var taskId = params.taskId;
    var planNo = model.get("actual.plcSolution.plcPackage.planNo");
    var isInsuranceGroup = params.isInsuranceGroup;
    var targetActualId = params.targetActualId;
    var specId=params.specId;

    if(model.get("actual.productCode")){
        if( model.get("actual.productCode").substring(0,2) == '27' ){
            //意外险标志
            model.set("accidentInsurance",true);
        }
    }
    model.set("fileName", "");
    $(window).trigger("changeFlagRadio");

    //已经上传又进该页面显示的上传信息
    if (actualId && isInsuranceGroup=="1") {
        $("#posRight").show();
        getGroupStatus();
    }


    function resetUploadText(){
        var el = $("#uploadSideBar .content .hint");
        if( !el.length ){
        	setTimeout(function(){        		
        		resetUploadText();
        	},50)
        }else{
        	debugger
           el.text("或将文件拖到这里");
        }
    }
    debugger;
    model.set("allUpload",false);//全量上传标志
    model.set("addUpload",false);//增量上传标志
    $(".groupWaitBox").css("display","none");
    model.action({
        //计算被保人or标的总数
        calculateSum: function(){
            debugger;
            var sum = 0;
            if(model.get("solution.plcPackage")){
                model.get("solution.plcPackage").each(function(item){
                    sum += item.get("itemNumber")?item.get("itemNumber")*1:0;
                    //不记名时赋值copies
                    item.set("copies", item.get("itemNumber"));
                });
                model.set("solution.$sum",sum);
                model.set("actual.sumQuantity",sum);
                //if(sum*1>0){//被保人是否必须要大于0
                    cola.tag("getCalcP").set("disabled", false);
                //}
            }
        },
        //清单上传
        beforeSend: function (self, arg) {
            model.set("fileName", arg.file.name);
                //获取specIdList
                var upSpecIdList={};
                var keyMap = model.dataType("BusinessEntity").getProperties().keyMap;
                for(var k in keyMap){
                    if( keyMap[k]._userData && keyMap[k]._userData.loadType == -1 ){
                        debugger;
                        upSpecIdList[k] = keyMap[k]._userData.specId;
                    }
                }
                //全量增量判断
                if(model.get("allUpload")){
                    var uploadFlag=true;//全量
                }else{
                    var uploadFlag=false;//增量
                }
                if(targetActualId){
                    arg.data.parameter = {
                        specId:specId,
                        actualId: targetActualId,
                        productCode: productCode,
                        specIdList:upSpecIdList,
                        uploadFlag:uploadFlag,
                        endorseFlag:"Y"
                    };
                }
                else{
                    arg.data.parameter = {
                        specId:specId,
                        actualId: actualId,
                        productCode: productCode,
                        specIdList:upSpecIdList,
                        uploadFlag:uploadFlag,
                        endorseFlag:"N"
                    };
                }
            var uploadFlag=false;//增量
        },
        //上传成功
        uploadSuccess: function (self, arg) {

            $(".groupWaitBox").css("display","block");
            cola.widget("uploadSideBar").hide();
            getGroupStatus();
            $("#posRight").show();
            $(".showUpLoad").show();
            cola.tag("getCalcP").set("disabled", false);
            if(model.get("batchStatus") == "02"){//状态为“处理中”时显示等待动画
                    $(".groupWaitBox").css("display","block");
            }else{
                $(".groupWaitBox").css("display","none");
            }
            debugger;
            if(model.get("batchCompelete")*1>0){//有上传成功的条数才可以保费计算
                cola.tag("getCalcP").set("disabled", false);
            }
            //自动刷新
            var autoFlush = setInterval(function () {
                if (model.get("batchStatus") == "Completed" || model.get("batchStatus") == "03") {
                    clearInterval(autoFlush);
                    $(".groupWaitBox").css("display","none");
                    cola.NotifyTipManager.info({
                        message: "",
                        description: "文件上传完成！",
                        showDuration: 3000
                    });
                }
                else{
                    //显示等待动画
                    $(".groupWaitBox").css("display","none");
                    model.action.flushInfo();
                }

                if(model.get("batchStatus") == "02"){//显示等待动画
                    $(".groupWaitBox").css("display","block");
                }
                if(!model.get("batchStatus")){
                    $(".groupWaitBox").css("display","none");
                }
            }, 5000);
        },
        uploadError:function(self, reason){
            debugger;
            cola.alert("请上传该产品对应模板！");
            //cola.alert(reason.reason);
            cola.widget("uploadSideBar").hide();
            return false;
        },
        //全量上传
        showAllUploadSideBar: function () {
            debugger;
            if(model.get("batchCompelete")){
                cola.confirm("全量上传清单，会替换已导入的清单信息!",{
                    onApprove:function(){
                        allUpload();
                    },
                    onDeny:function(){
                       return false;
                    }
                });
            }else{
                allUpload();
            }
        },
        //增量上传
        showAddUploadSideBar: function () {
            debugger;
            model.set("addUpload",true);
            model.set("allUpload",false);
            if (targetActualId) {//批改专项处理
                var uploadSideBar = cola.widget("uploadSideBar");
                uploadSideBar.show();
            }else{
            	contractEntity.notSaveCustomerFlag = true;
                model.action("savePolicy")(true, function () {
                    $(".submitPolicy").addClass("disabledSave");
                    $("#qqSubBtn").attr("disabled", true);
                    $("#qqSubBtn").attr("title", "请先计算保费");
                    $(".savePolicy").removeClass("disabledSave");
                    $("#qqSaveBtn").removeAttr("disabled");
                    $(".savePolicy").removeClass("disabledBtn");
                    $("#qqSaveBtn").removeAttr("title");
                    contractEntity.notSaveCustomerFlag = false;

                    var params = cola.util.queryParams();
                    var taskId = params.taskId;
                    var planNo = model.get("actual.plcSolution.plcPackage.planNo");
                    $(".waittingRenderBox").css("display","none");//关闭团单等待动画
                    $(".waittingQuotaBox").css("display","none");//关闭报价等待动画
                    debugger;
                    if (!model.get("batchStatus")) {
                        var uploadSideBar = cola.widget("uploadSideBar");
                        uploadSideBar.show();
                        resetUploadText();
                    }
                    else {
                        if (model.get("batchStatus") == "Completed" || model.get("batchStatus") == "03") {
                            var uploadSideBar = cola.widget("uploadSideBar");
                            uploadSideBar.show();
                            resetUploadText();
                        }
                    }
                });
            }

        },
        //下载模板
        downLoadTemplate: function () {
            if (targetActualId) {
                window.open("controller/policy/group/getEndorseTemplate?productCode=" + productCode, "_self");
            } else {
                window.open("controller/policy/group/getExcelTemplate?productCode=" + productCode, "_self");
            }
        },
        //下载失败清单
        failureList: function () {
            var batchFailure = model.get("batchFailure");
            if (batchFailure == 0 || batchFailure == undefined) {
                return;
            }
            else {
                if (targetActualId) {
                    window.open("controller/policy/group/getFailureList?actualId=" + targetActualId + "&productCode=" + productCode + "&endorseFlag=1", "_self");
                }
                else {
                    window.open("controller/policy/group/getFailureList?actualId=" + actualId + "&productCode=" + productCode, "_self");
                }
            }
        },
        //下载标的清单
        objectList: function () {
            debugger;
            var params = cola.util.queryParams();
            var businessNo=model.get("actual.businessNo");
            var policyNo=model.get("actual.policyNo");
            var actualId=params.actualId;
            var targetActualId=params.targetActualId;
            if(targetActualId){
                actualId=params.targetActualId;
            }else{
                actualId=params.actualId;
            }
            if(policyNo==null){
                policyNo="";
            }
            window.open("controller/policy/group/downLoadItemObject?productCode="+productCode+"&actualId="+actualId+"&schemaName="+"&businessNo="+businessNo+"&policyNo="+policyNo, "_self");

        },
        //处理状态
        onItemRender: function (dom, model) {
            if (model.get("batchStatus") == "ToBeProcessed" || model.get("batchStatus") == "01") {
                $(dom).html("待处理");
            }
            else if (model.get("batchStatus") == "Processing" || model.get("batchStatus") == "02") {
                $(dom).html("处理中");
            }
            else if (model.get("batchStatus") == "Completed" || model.get("batchStatus") == "03") {
                $(dom).html("已完成");
            }
        },
        //刷新
        flushInfo: function () {
            getGroupStatus();
            $("#nprogress").css("display", "none");
        }
    });

    
//封装上传清单数据
    function getGroupStatus() {
        debugger;
        if (targetActualId) {//批改专项处理
            var url = "controller/policy/group/getGroupInsuranceStatus?actualId=" + targetActualId;
        }
        else {
            var url = "controller/policy/group/getGroupInsuranceStatus?actualId=" + actualId;
        }
        $.ajax({
            url: url,
            method: "get",
            async: false,
            success: function (data) {
            	if( !data ){
            		model.set("actual.$batchCompelete","");
            		model.set("batchCompelete","");
            		model.set("upLoadList", []);
            	}
                if (data.errorMessage) {
                    cola.alert(data.errorMessage);
                }
                var batchNum = data.batchNum;
                var batchStatus = data.batchStatus;
                var batchCompelete = data.batchCompelete;
                model.set("actual.$batchCompelete",batchCompelete);
                var batchFailure = data.batchFailure;
                model.set("batchNum", batchNum);
                model.set("batchStatus", batchStatus);
                //model.set("batchCompelete", batchCompelete);
                model.set("batchFailure", batchFailure);
                //隐藏等待动画
                if(batchStatus!="02" || batchFailure){
                    $(".groupWaitBox").css("display","none");
                }


                if (targetActualId) {
                    actualId=params.targetActualId;
                }else{
                    actualId=params.actualId;
                }
                debugger;
                if(batchStatus == "03") {//上传完成请求:每个方案成功失败条数
                    $.ajax({
                        url: "controller/policy/group/getFailAndSuccessNum?actualId=" + actualId,
                        type: "get",
                        success: function (data) {
                            debugger;
                            if (data.errorMessage) {
                                cola.alert(data.errorMessage);
                            }
                            if (!data) return;
                            var arr = [];
                            var sum=0;
                            for (var k in data) {
                                data[k].planName = k;
                                arr.push(data[k]);
                                sum+=data[k].success*1;
                            }
                            model.set("upLoadList", arr);
                            model.set("batchCompelete",sum);
                        }
                    });
                }

            },
            error:function(){
                $(".groupWaitBox").css("display","none");
            }

        })
    }
    $(window).on("getGroupStatus",getGroupStatus);
    //全量上传
    function allUpload(){
        model.set("allUpload",true);
        model.set("addUpload",false);

        if (targetActualId) {//批改专项处理
            var uploadSideBar = cola.widget("uploadSideBar");
            uploadSideBar.show();
        }else{
            debugger;
            contractEntity.notSaveCustomerFlag = true;
            model.action("savePolicy")(true, function () {
                debugger;
                $(".submitPolicy").addClass("disabledSave");
                $("#qqSubBtn").attr("disabled", true);
                $("#qqSubBtn").attr("title", "请先计算保费");
                $(".savePolicy").removeClass("disabledSave");
                $("#qqSaveBtn").removeAttr("disabled");
                $(".savePolicy").removeClass("disabledBtn");
                $("#qqSaveBtn").removeAttr("title");
                contractEntity.notSaveCustomerFlag = false;


                var params = cola.util.queryParams();
                var taskId = params.taskId;
                var planNo = model.get("actual.plcSolution.plcPackage.planNo");
                $(".waittingRenderBox").css("display","none");//关闭团单等待动画
                $(".waittingQuotaBox").css("display","none");//关闭报价等待动画
                if (!model.get("batchStatus")) {
                    var uploadSideBar = cola.widget("uploadSideBar");
                    uploadSideBar.show();
                    resetUploadText();
                }
                else {
                    if (model.get("batchStatus") == "Completed" || model.get("batchStatus") == "03") {
                        var uploadSideBar = cola.widget("uploadSideBar");
                        uploadSideBar.show();
                        resetUploadText();
                    }
                }
            });
        }
    }
    cola.ready(function () {
        // $(window).on("uploaderGroup", getGroupStatus);
        //是否匿名
        debugger
        if(params.anonymousFlag=="0"){
            $(".upLoaderBox").css("display", "block");
            $(".upLoaderBox .showUpLoad").css("display", "block");
            $(".subjectUpLoad").css("display", "none");
            $(".groupSearch").css("display", "block");
        }else{
            debugger;
            $(".upLoaderBox").css("display", "none");
            $(".subjectUpLoad").css("display", "block");
            $(".subjectUpLoad .showUpLoad").css("display", "block");
            $(".productCapContent .groupSearch").css("display", "none");
        }
        if(params.endorseType=="999"){
            cola.tag("endorseProduct").set("disabled", true);
        }

    });
    //解决中途关闭正在上传，进页面还是上传中状态问题
    if(model.get("batchStatus") == "02") {
        var autoFlush = setInterval(function () {
            if (model.get("batchStatus") == "Completed" || model.get("batchStatus") == "03") {
                clearInterval(autoFlush);
                $(".groupWaitBox").css("display","none");
                cola.NotifyTipManager.info({
                    message: "",
                    description: "文件上传完成！",
                    showDuration: 3000
                });
            }
            else{
                //显示等待动画
                $(".groupWaitBox").css("display","none");
                model.action.flushInfo();
            }
            if(model.get("batchStatus") == "02"){//显示等待动画
                $(".groupWaitBox").css("display","block");
            }
            if(!model.get("batchStatus")){
                $(".groupWaitBox").css("display","none");
            }
        }, 5000);
    }

    debugger;
    if(params.anonymousFlag=="1") {//不记名时触发
        model.action("calculateSum")();
    }

    //上传清单后点查询删除，同步已上传的对应方案人数和总数
    function updateList() {
        if (targetActualId) {//批改专项处理
            var url = "controller/policy/group/getGroupInsuranceStatus?actualId=" + targetActualId;
        }
        else {
            var url = "controller/policy/group/getGroupInsuranceStatus?actualId=" + actualId;
        }
        $.ajax({
            url: url,
            type: "get",
            async: false,
            success: function (data) {
                debugger;
                if (data.errorMessage) {
                    cola.alert(data.errorMessage);
                }
                if (targetActualId) {
                    actualId=params.targetActualId;
                }else{
                    actualId=params.actualId;
                }
                 //上传完成请求:每个方案成功失败条数
                    $.ajax({
                        url: "controller/policy/group/getFailAndSuccessNum?actualId=" + actualId,
                        type: "get",
                        async:false,
                        success: function (data) {
                            getGroupStatus();
                           
                        }
                    });
            },
            error:function(){
                $(".groupWaitBox").css("display","none");
            }

        })
    }

    $(window).on("updateList",updateList);
});




