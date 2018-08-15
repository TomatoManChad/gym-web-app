	var map;
		var windowinfo;
		var request;
		var service;
		var markers = [];
		function initMap() {
			var center = new google.maps.LatLng(55.8642, -4.2518);

			map = new google.maps.Map(document.getElementById('map'), {
				center : center,
				zoom : 13
			});

			request = {
				location : center,
				radius : 8047,
				types : [ 'gym' ]
			};
			windowinfo = new google.maps.InfoWindow();

			service = new google.maps.places.PlacesService(map);
			service.nearbySearch(request, callback);

			google.maps.event.addListener(map, 'rightclick', function(event) {
				map.setCenter(event.latLng)
				clearResults(markers)

				var request = {
					location : event.latLng,
					radius : 8047,
					types : [ 'gym' ]
				};
				service.nearbySearch(request, callback);
			})
		}

		function callback(results, status) {
			if (status === google.maps.places.PlacesServiceStatus.OK) {
				for (var i = 0; i < results.length; i++) {
					markers.push(createMarker(results[i]));
				}
			}
		}

		function createMarker(place) {
			var placeLoc = place.geometry.location;
			var marker = new google.maps.Marker({
				map : map,
				position : place.geometry.location
			});
			google.maps.event.addListener(marker, 'click', function() {
				windowinfo.setContent(place.name);
				windowinfo.open(map, this);
			});
			return marker;
		}

		function clearResults(markers) {
			for ( var m in markers) {
				markers[m].setMap(null)
			}
			markers = []
		}