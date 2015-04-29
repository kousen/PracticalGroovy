package geocoder

import groovy.json.JsonSlurper

class GeocoderJSON {
    String base = 'http://maps.google.com/maps/api/geocode/json?'

    void fillInLatLng(Stadium stadium) {
        String encoded =
            [stadium.street, stadium.city, stadium.state].collect { 
                URLEncoder.encode(it,'UTF-8')
            }.join(',')
        String qs = "address=$encoded"
        def response = new JsonSlurper().parseText(
                "$base$qs".toURL().text)
        stadium.latitude = response.results[0].geometry.location.lat.toDouble()
        stadium.longitude = response.results[0].geometry.location.lng.toDouble()
    }
}
