package com.example.weatherapp.http

/**
 * created by {Bennette Molepo} on {10/27/2021}.
 */
object WeatherApis {

    //in here am declaring all the open weather apis that i will use to get my weather results

    const val BASE_URL = "http://api.openweathermap.org/data/2.5/"

    const val CURRENT_ENDPOINT = "weather?&&units=metric&appid=3c2c9119fd96f5765412b2eb67d81316"

    const val FORECAST_ENDPOINT_COUNT_V2= "forecast?&&&cnt=5&appid=3c2c9119fd96f5765412b2eb67d81316"

        //with the response count of 5
    const val FORECAST_ENDPOINT_COUNT= "forecast?&lat=26.0208631&lon=28.1995223&cnt=5&appid=3c2c9119fd96f5765412b2eb67d81316"




}