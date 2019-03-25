cola(function (model) {
/*    imgFile = [];
    model.action({
        beforeUpload: function (self, arg) {
        	 arg.data.parameter = {
             		flag: "faultReport",
     			};
        },
        uploadSuccess: function (self,arg) {
            debugger;
            var objFile = {
                filePath:arg.response.filePath,
                file:arg.response.file
            };
            imgFile.push(objFile);
            model.set("imgFiles",imgFile);
            cola.widget("imageUploader").reset();
            if(imgFile.length<3){
        		$(".addimg").show();
        	}else{
        		$(".addimg").hide();
        	}
        },
        DelFile:function(imgfile){
        	//debugger;
        	imgfile.remove();
        	var path = imgfile.get("filePath")
        	for(var i=0;i<imgFile.length;i++){
        		if(imgFile[i].filePath==path){
        			imgFile.splice(i,1);
        		}
        	}
        	if(imgFile.length<3){
        		$(".addimg").show();
        	}else{
        		$(".addimg").hide();
        	}
        }
    });*/
});