/**
 * Created by 陈星 on 2017/10/24.
 */
$(function(){
	map_init('allmapBj',116.461258,39.919743);
	map_init('allmapSh',121.522762,31.235387);
	map_init('allmapSz',113.932661,22.538709);
});

var map; // Map实例
function map_init(id,lng,lat) {
	map = new BMap.Map(id);
	// 第1步：设置地图中心点，当前城市
	var point = new BMap.Point(lng,lat);
	// 第2步：初始化地图,设置中心点坐标和地图级别。
	map.centerAndZoom(point, 16);
	// 第3步：启用滚轮放大缩小
	map.enableScrollWheelZoom(true);
	// 第4步：向地图中添加缩放控件
	var ctrlNav = new window.BMap.NavigationControl({
		anchor: BMAP_ANCHOR_TOP_LEFT,
		type: BMAP_NAVIGATION_CONTROL_LARGE
	});
	map.addControl(ctrlNav);
	// 第5步：向地图中添加缩略图控件
	var ctrlOve = new window.BMap.OverviewMapControl({
		anchor: BMAP_ANCHOR_BOTTOM_RIGHT,
		isOpen: 1
	});
	map.addControl(ctrlOve);
	// 第6步：向地图中添加比例尺控件
	var ctrlSca = new window.BMap.ScaleControl({
		anchor: BMAP_ANCHOR_BOTTOM_LEFT
	});
	map.addControl(ctrlSca);
	var marker = new BMap.Marker(point); //将点转化成标注点
	map.addOverlay(marker);  //将标注点添加到地图上
}

//添加标注
function addMarker(points) {
	var myIcon = new BMap.Icon("http://api.map.baidu.com/img/markers.png",
	new BMap.Size(23, 25), {
		offset: new BMap.Size(10, 25),
		imageOffset: new BMap.Size(0, - 25)
	});
	var marker = new BMap.Marker(points, { icon: myIcon });
	map.addOverlay(marker);
	return marker;
}
