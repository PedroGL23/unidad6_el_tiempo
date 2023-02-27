package layout

import com.example.unidad6_eltiempo.data.models.WeatherResponse
import com.example.unidad6_eltiempo.data.remote.ApiRest
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET ("weather")
    suspend fun getWeatherInfo(
        @Query("appid") apikey: String = ApiRest.appid,
        @Query("lang") language: String = ApiRest.lang,
        @Query("lat") latitude: String = ApiRest.latitude,
        @Query("lon") longitude: String = ApiRest.longitude,
        @Query("units") units: String = ApiRest.units
    ): Response<WeatherResponse>


}