cola(function(model){

    model.set("level", [{"key":"5","value":"5"},{"key":"4","value":"4"},{"key":"3","value":"3"},{"key":"2","value":"2"},{"key":"1","value":"1"}])

    model.set("locations", [])

    var clickListener,map = new AMap.Map('container', {
        center: [116.397428, 39.90923],
        layers: [new AMap.TileLayer.Satellite()],
        zoom: 15,
		resizeEnable: true
    });

    var positionMarkers = []; //坐标点
    var positionMarker;
    var markers = []; //marker图标
    var marker;

    var drawComplete = false;

    //为地图注册click事件获取鼠标点击出的经纬度坐标
    var i = 0;
    map.on('click', function(e) {
        if (drawComplete) {
            model.set("locations", []);
            drawComplete = false;
            i = 0;
        }
        i ++;
        if(i == 1){
            removeMarkers(map);
        }
        var l = {};
        var points = "";
        l.LngName = "东经";
        l.Lngdegree = getDegree(e.lnglat.getLng());
        l.Lngpoints = parseInt(convertNum(getDouble(e.lnglat.getLng())));
        points = convertNum(getDouble(e.lnglat.getLng()));
        l.Lngseconds = parseInt(convertNum(getDouble(points)));
        
        l.LatName = "北纬";
        l.Latdegree = getDegree(e.lnglat.getLat());
        l.Latpoints = parseInt(convertNum(getDouble(e.lnglat.getLat())));
        points = convertNum(getDouble(e.lnglat.getLat()));
        l.Latseconds = parseInt(convertNum(getDouble(points)));
        model.get("locations").insert(l);
        addMarker(e.lnglat, l, i);
        console.info("当前经纬度:" + e.lnglat.getLng() + ',' + e.lnglat.getLat());
    });

    clickListener = AMap.event.addListener(map, "click", function(e) {
		marker = new AMap.Marker({
			position: e.lnglat,
			map: map
        });
        markers.push(marker);
	});

    var mouseTool = new AMap.MouseTool(map);
    mouseTool.polygon({
        strokeColor: "#FFE74D",
        strokeOpacity: 1,
        strokeWeight: 3,
        strokeOpacity: 3.2,
        fillColor: '#FFE74D',
        fillOpacity: 0.4,
        // 线样式还支持 'dashed'
        strokeStyle: "solid",
        // strokeStyle是dashed时有效
        // strokeDasharray: [30,10],
    })

     // 实例化点标记
    function addMarker(location, l, i) {
		var content = "";
        content = "<div style=\"padding:0px 0px 0px 4px;\"><b>定位点" + i + "</b><br/>";
        content += "<div style='margin-top: 1px;padding-top:8px;border-top:1px dashed #D9D9D9;'>东经 : " + l.Lngdegree + "," + l.Lngpoints + "," + l.Lngseconds + "</div>";
        content += "<div>北纬 : " + l.Latdegree + "," + l.Latpoints + "," + l.Latseconds + "</div></div>";
		var offset = new AMap.Pixel(2, 10);
		positionMarker = new AMap.Marker({
            icon: "./risksurvey/risksurvey/images/poi-marker-default.png",
            position: [location.getLng(),location.getLat()],
            offset: new AMap.Pixel(-56, -110),
			//angle: 180,
			label: {content, offset},
			title: '定位点' + i
        });
        positionMarker.setMap(map);
        positionMarkers.push(positionMarker);
    }

    mouseTool.on('draw', function(event) {
        drawComplete = true;
        console.info('覆盖物对象绘制完成');
    })
    function removeMarkers(map){
        //删除坐标点
        if(positionMarker){
            positionMarker.setMap(null);
            positionMarker = null;
            map.remove(positionMarkers);
        }
        //删除图标markers
        if(marker){
            marker.setMap(null);
            marker = null;
            map.remove(markers);
        }
        //清除矢量图覆盖物
        map.clearMap();
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
})