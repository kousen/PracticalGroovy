package openweather

import com.google.gson.Gson

class OpenWeather {
    String appid = new File('api_key.txt').text
    String base = 'http://api.openweathermap.org/data/2.5/weather?APPID=$appid&q='
    Gson gson = new Gson()

    String getWeather(city='Marlborough', state='CT') {
        String jsonTxt = "$base$city,$state".toURL().text
        gson.fromJson(jsonTxt, Model).toString()
    }
}
