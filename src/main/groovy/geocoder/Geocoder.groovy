package geocoder

class Geocoder {
    String base = 'http://maps.google.com/maps/api/geocode/xml?'

    void fillInLatLng(Stadium stadium) {
        String encoded =
            [stadium.street, stadium.city, stadium.state].collect { 
                URLEncoder.encode(it,'UTF-8')
            }.join(',')
        String qs = "address=$encoded"
        def response = new XmlSlurper().parse("$base$qs")
        stadium.latitude = response.result[0].geometry.location.lat.toDouble()
        stadium.longitude = response.result[0].geometry.location.lng.toDouble()
    }
}
