package ass.question.weather.Retrofit;

import java.util.Map;

import ass.question.weather.models.GetWeatherApi.GetCurrentWeather;
import ass.question.weather.models.PostForecast.SendForecastData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetDataService {

    @Headers("API-KEY:ECOVIBEAPIKEY")
    @GET("/GnrgyTestService/Weather.svc/GetCurrentWeather?lat=12.9716&lon=77.5946")
    Call<ResponseBody> getCurretnWeather(/*@Query(value="lat", encoded=true) String latlong*/);

    @Headers("API-KEY:ECOVIBEAPIKEY")
    @POST("GnrgyTestService/Weather.svc/PostForcast")
    Call<ResponseBody> getPostForecast(@Body SendForecastData sendForecastData);
}