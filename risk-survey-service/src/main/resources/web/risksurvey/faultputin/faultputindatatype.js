cola(function(model){
    model.dataType({
        name: "Fultputininfo",
        properties: {
            customerWaiting: {
                caption: "是否为客户等待",
                dataType: "string"
            },
            systemName: {
                caption: "系统名称",
                dataType: "string"
            },
            businessArea: {
                caption: "业务领域",
                dataType: "string"
            },
            faultType: {
                caption: "问题类型",
                dataType: "string"
            },
            operationNumber: {
                caption: "业务号",
                dataType: "string"
            },
            operationStep: {
                caption: "操作步骤",
                dataType: "string"
            },
            faultDescription: {
                caption: "故障描述",
                dataType: "string"
            }
        }
    });
})
