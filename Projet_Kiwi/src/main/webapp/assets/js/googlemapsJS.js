var map;
var service;
var infowindow;

function codeAddress(address) {
    var geocoder = new google.maps.Geocoder();
    geocoder.geocode({
        'address': address
    }, function(results, status) {
        if (status == 'OK') {
            map.setCenter(results[0].geometry.location);
            var marker = new google.maps.Marker({
                map: map,
                position: results[0].geometry.location
            });
        } else {
            alert('Geocode was not successful for the following reason: ' + status);
        }
    });
}

function initMap(address) {
    var sydney = new google.maps.LatLng(-33.867, 151.195);

    infowindow = new google.maps.InfoWindow();

    map = new google.maps.Map(
        document.getElementById('map'), {
            center: sydney,
            zoom: 6
        });

    codeAddress(document.getElementById('address').innerText);
}