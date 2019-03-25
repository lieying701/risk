cola(function(model){
    model.set("locations", [])

	// 百度地图API功能
	var clickListener, map = new BMap.Map("container",{mapType:BMAP_SATELLITE_MAP});    // 创建Map实例
	map.centerAndZoom(new BMap.Point(116.397428, 39.90923), 15);  // 初始化地图,设置中心点坐标和地图级别
	//添加地图类型控件
	// map.addControl(new BMap.MapTypeControl({
	// 	mapTypes:[
    //         BMAP_NORMAL_MAP,
    //         BMAP_HYBRID_MAP
    //     ]
    // }));
    //设置当前城市
    map.setCurrentCity("北京");
    //开启鼠标滚轮缩放
    map.enableScrollWheelZoom(true);

    var drawComplete = false;
    var overlays = [];
    var lastPoint;
    var currentPoint;
    var previousPoint = {};

    //为地图注册click事件获取鼠标点击出的经纬度坐标  
    var i = 0;
    map.addEventListener("click", function(e){
        var lng = e.point.lng;
        var lat = e.point.lat;
         
        if (drawComplete) {
            model.set("locations", []);
            drawComplete = false;
            i = 0;
            lastPoint = null;
            currentPoint = null;
        }
        i ++;
        if(i == 1){
           removeMarkers(map);
           lastPoint = e.point;
           currentPoint = e.point;
        }else{
            lastPoint = currentPoint;
            currentPoint = e.point;
        }
        var l = {};
        var points = "";
        l.LngName = "东经";
        l.Lngdegree = getDegree(lng);
        l.Lngpoints = parseInt(convertNum(getDouble(lng)));
        points = convertNum(getDouble(lng));
        l.Lngseconds = parseInt(convertNum(getDouble(points)));
        
        l.LatName = "北纬";
        l.Latdegree = getDegree(lat);
        l.Latpoints = parseInt(convertNum(getDouble(lat)));
        points = convertNum(getDouble(lat));
        l.Latseconds = parseInt(convertNum(getDouble(points)));

        //console.log("i is :",i+" ; points :", e.points);
        //console.log("previous points :", previousPoint);
        if(previousPoint.lng == e.point.lng && previousPoint.lat == e.point.lat){ //handle double click event
            return false;
        }

        model.get("locations").insert(l);
        addLabelMarker(e.point, l, i);
        console.info("当前经纬度:" + lng + ',' +  lat);
        var marker = new BMap.Marker(new BMap.Point(currentPoint.lng, currentPoint.lat)); // 创建点
        map.addOverlay(marker);
        overlays.push(marker);
        previousPoint.lng = lng;
        previousPoint.lat = lat;
        
        // var polyline = new BMap.Polyline([
        //     new BMap.Point(lastPoint.lng, lastPoint.lat),
        //     new BMap.Point(currentPoint.lng, currentPoint.lat)
        // ], {strokeColor:"blue", strokeWeight:3, strokeOpacity:1});   //创建折线
        // map.addOverlay(polyline);
    });

    // 实例化点标记
    function addLabelMarker(location, l, i) {
		var content = "";
        content = "<div style=\"padding:0px 0px 0px 4px;\"><b>定位点" + i + "</b><br/>";
        content += "<div style='margin-top: 1px;padding-top:8px;border-top:1px dashed #D9D9D9;'>东经 : " + l.Lngdegree + "," + l.Lngpoints + "," + l.Lngseconds + "</div>";
        content += "<div>北纬 : " + l.Latdegree + "," + l.Latpoints + "," + l.Latseconds + "</div></div>";

        var opts = {
            position : point,    // 指定文本标注所在的地理位置
            offset   : new BMap.Size(2, 0)    //设置文本偏移量
        }
        var label = new BMap.Label(content, opts);  // 创建文本标注对象
		label.setStyle({
			 color : "black",
			 fontSize : "12px",
			 height : "80px",
			 lineHeight : "20px",
			 fontFamily:"微软雅黑"
		 });
        map.addOverlay(label); 
        overlays.push(label);
    }

    var styleOptions = {
        strokeColor:"red",    //边线颜色。
        fillColor:"red",      //填充颜色。当参数为空时，圆形将没有填充效果。
        strokeWeight: 3,       //边线的宽度，以像素为单位。
        strokeOpacity: 0.8,	   //边线透明度，取值范围0 - 1。
        fillOpacity: 0.6,      //填充的透明度，取值范围0 - 1。
        strokeStyle: 'solid' //边线的样式，solid或dashed。
    }
    //实例化鼠标绘制工具
    var drawingManager = new BMapLib.DrawingManager(map, {
        isOpen: false, //是否开启绘制模式
        enableDrawingTool: false, //是否显示工具栏
        drawingToolOptions: {
            anchor: BMAP_ANCHOR_TOP_RIGHT, //位置
            offset: new BMap.Size(3, 3), //偏离值
        },
        drawingModes: [BMAP_DRAWING_POLYGON] ,
        circleOptions: styleOptions, //圆的样式
        polylineOptions: styleOptions, //线的样式
        polygonOptions: styleOptions, //多边形的样式
        rectangleOptions: styleOptions //矩形的样式
    });
    drawingManager.setDrawingMode(BMAP_DRAWING_POLYGON);//set drawing mode
    console.log("drawing mode is: ",drawingManager.getDrawingMode());
 
    //鼠标绘制工具监听事件,获取绘制结果
    drawingManager.addEventListener("overlaycomplete", function(e){
        console.log("drawing complete...");
        drawComplete = true;
        overlays.push(e.overlay);
        drawingManager.close();
    });
 
    function removeMarkers(map){
        console.log("overlays:", overlays);
        for(var i = 0; i < overlays.length; i++){
            map.removeOverlay(overlays[i]);
        }
        overlays.length = 0;    
    }

    function getDegree(num) {
        num = num + "";
        var s = num.split(".");
        return s[0];
    }

    function getDouble(num) {
        num = num + "";
        var s = num.split(".");
        return ("0." + s[1]) * 1;
    }

    function convertNum(num) {
        return num * 60;
    }

    model.action({
        drawPolyline: function(){
            console.log("start drawing ");
            model.set("locations", []);
            removeMarkers(map);
            drawingManager.open();
            drawingManager.setDrawingMode(BMAP_DRAWING_POLYGON);//set drawing mode
        }
    })
})