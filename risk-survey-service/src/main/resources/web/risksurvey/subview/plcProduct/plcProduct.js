cola(function(model){
    var classCodeList = [];// 存储一二级险类
    var productCodeList = [];// 存储三级产品
    var classCodeTwoList = [];
    model.set("classCodeListTwo",[]);
    model.set("classCodeParent","");

    // 险类基础代码
    $.ajax({
        url:"service/product/productClass/getCachedProductClasses",
        type:"post",
        async:false,
        success:function(data) {
            //设置一级险类
            var arr = [];
            if (data) {
                for (var i = 0; i < data.length; i++) {
                    var parentId = data[i].parentId;
                    if (!parentId) {
                        arr.push({
                            key: data[i].classCode,
                            value: data[i].classCode + "-" + data[i].name
                        });
                    }else{
                        classCodeTwoList.push({
                            key: data[i].classCode,
                            value: data[i].classCode + "-" + data[i].name,
                            parentId: data[i].parentId
                        })
                    }

                }
            }
            model.set("classCodeParentList", arr);

            if(arr[0]){
                //设置二级险类
                classCodeTwoList.forEach(function (item,index) {
                    if(arr[0].key == item.key.substring(0,2) ){
                        model.get("classCodeListTwo").insert(item);
                    }
                });
                //设置三级产品
                getProductCodesByClassCode();

            }
        }
    });

    //根据父级中的当前项给多级下拉中的产品设置默认值
    function getProductCodesByClassCode (){
        model.set("classCodeParentList",[]);

        var first = model.get("classCodeListTwo.key");
        if(first){
            //根据险类查产品
            $.ajax({
                url:"service/product/insuranceProduct/getCachedObjects?classCode="+first,
                success:function(data) {
                    //开始设置产品下拉数据
                    model.set("classCodeParentList",[]);
                    var result = data;
                    $.each(result,function(index,i){
                        model.get("classCodeParentList").insert({
                            value:i.productCode+"-"+i.name,
                            key:i.productCode
                        })
                    });

                    //重新渲染选中框和多选框内的内容
                    //renderStructureSelector();
                },
                error: function () {
                    cola.NotifyTipManager.warning({
                        message:"",
                        description:"查询下级产品失败，请重新选择进行查询！",
                        showDuration:3000
                    });
                }
            });
        }
    };

    model.action({
        
        changeCode(self, arg) { //险类值改变，级联加载对应产品集合
            debugger
            var classCode = self.get("value");
            model.set("classCodeListTwo",[]);
            model.set("productCode","");
            if (!classCode) return;
            var url = "service/product/insuranceProduct/getCachedObjects?classCode=" + classCode;
            var productCodeList = [];
            $.post(url, {}, function (data) {
                $.each(data,function(index,i){
                    model.get("classCodeListTwo").insert({
                        value:i.productCode+"-"+i.name,
                        key:i.productCode
                    })
                });
            });

            //投保信息数据
			var productObj = {};
			debugger;
			productObj.product = model.get("product");
			productObj.amount = model.get("amount");
			productObj.productCode = model.get("productCode");
			console.log("productObj is : ", productObj);
        },
    })
})