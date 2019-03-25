cola(function (model) {
    $(function () {
        var params = cola.util.queryParams()
        if(params.id==1){
            $.ajax({
                url:"controller/uwImage/image/imageScanUpdateBuildXMLCar",
                type:"POST",
                data: JSON.stringify({
                    classCode: params.classCode,
                    proposalNo: params.proposalNo
                }),
                datatype:"json",
                contentType:"application/json;charset=UTF-8",
                success:function (data) {
                    $("#tranSfer").attr("action",data.url);
                    $("#tranSfer>textarea").val(data.xml);
                    $("#tranSfer").submit();
                }
            })
        }else if(params.id==2){
            $.ajax({
                url:"controller/uwImage/image/imageQueryBuildXML",
                type:"POST",
                data: JSON.stringify({
                    classCode: params.classCode,
                    proposalNo: params.proposalNo
                }),
                datatype:"json",
                contentType:"application/json;charset=UTF-8",
                success:function (data) {
                    $("#tranSfer").attr("action",data.url);
                    $("#tranSfer>textarea").val(data.xml);
                    $("#tranSfer").submit();
                }
            })
        }

    })
})
