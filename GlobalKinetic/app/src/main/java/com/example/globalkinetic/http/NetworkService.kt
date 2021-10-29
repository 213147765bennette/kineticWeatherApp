package com.example.weatherapp.http

import com.example.weatherapp.response.CurrentTaskResponse
import com.example.weatherapp.response.FiveForecastResponse
import com.example.weatherapp.response.TopCurrentResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * created by {Bennette Molepo} on {10/27/2021}.
 */
interface NetworkService {

    //get weather with users location lat and long values
    @GET(WeatherApis.CURRENT_ENDPOINT)
    fun getTopUserCurrentWeather(@Query("lat") lat:String,@Query("lon") lon:String) : Single<TopCurrentResponse>

    //get weather forecast of users location using current lat and long values
    @GET(WeatherApis.FORECAST_ENDPOINT_COUNT_V2)
    fun getFiveUserDaysForecast(@Query("lat") lat:String,@Query("lon") lon:String) : Single<FiveForecastResponse>

}