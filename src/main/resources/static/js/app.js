app = (function(){
	var map;
	var markers;
	var bounds;

	function plotMarkers(m)
	{
	  markers = [];
	  bounds = new google.maps.LatLngBounds();

	  m.forEach(function (marker) {
	    var position = new google.maps.LatLng(marker.lat, marker.lng);

	    markers.push(
	      new google.maps.Marker({
	        position: position,
	        map: map,
	        animation: google.maps.Animation.DROP
	      })
	    );

	    bounds.extend(position);
	  });

	  map.fitBounds(bounds);
	}
	var show = function(err,data){
		if(err!=null){
			return;
		}
		var tab = $("#tab");
		map = new google.maps.Map(document.getElementById('map'), {
		    center: {lat: -34.397, lng: 150.644},
		    zoom: 8
		  });
		tab.html("");
		var tabl = $("<table class='table'></table>");
		tab.append(tabl);
		tabl.append($("<tr><td>Id</td><td>name</td><td>Code</td></tr>"));
		var m = [];
		data.forEach(function(airport){
			var json = {lat:airport.location.latitude,lng:airport.location.longitude};
			m.push(json);
			//var position = new google.maps.LatLng(airport.location.latitude, airport.location.longitude);
			tabl.append($("<tr><td>"+airport.airportId+"</td><td>"+airport.name+"</td><td>"+airport.code+"</td></tr>"));
		});
		console.log(m);
		plotMarkers(m);
	}
	return {
		getAirports:function(name){
			apiclient.getAirports(name,show)
		},initMap:function(){
			initMap();
		}
	}
})();