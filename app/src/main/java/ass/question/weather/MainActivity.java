package ass.question.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ass.question.weather.Retrofit.GetDataService;
import ass.question.weather.Retrofit.RetrofitClientInstance;
import ass.question.weather.Retrofit.RetrofitClientInstanceForGetWeather;
import ass.question.weather.models.GetWeatherApi.GetCurrentWeather;
import ass.question.weather.models.PostForecast.SendForecastData;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         callRetrofitForGetCurrentWeather();
        callRetrofitPostForecast();

    }

    private void callRetrofitForGetCurrentWeather() {
        GetDataService service = RetrofitClientInstanceForGetWeather.getRetrofitInstance().create(GetDataService.class);
        Map<String, String> params = new HashMap<String, String>();
        params.put("lat", "12.9716");
        params.put("lon", "77.5946");

       // String latlng="lat=12.9716&lon=77.5946";
        Call<ResponseBody> call = service.getCurretnWeather();
        call.enqueue(new Callback<ResponseBody>() {


            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    //progressDoalog.dismiss();
                    //GetCurrentWeather getCurrentWeather=response.body();
                    if(response.isSuccessful()) {
                        try {
                            Log.e("response", response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }else{
                        try {
                            Log.e("error",response.errorBody().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    // Toast.makeText(MainActivity.this, getCurrentWeather.getWeather().get(0).getDescription(), Toast.LENGTH_SHORT).show();
                    //generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //progressDoalog.dismiss();
                Log.e("infailure",t.toString());
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void callRetrofitPostForecast(){
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        SendForecastData sendForecastData=new SendForecastData();
        sendForecastData.setCity("Bangalore,IN");
        Call<ResponseBody> call = service.getPostForecast(sendForecastData);
        call.enqueue(new Callback<ResponseBody>() {


            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                //progressDoalog.dismiss();
                //GetCurrentWeather getCurrentWeather=response.body();
                if(response.isSuccessful()) {
                    try {
                        response.raw().request().url();
                        Log.e("response", response.body().string()+ "   "+response.raw().request().url());
                        JSONObject jsonObject = new JSONObject(response.body().string());
                        Toast.makeText(MainActivity.this,String.valueOf(jsonObject.get("cod")), Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    try {
                        Log.e("error",response.errorBody().string()+" "  + response.raw().request().url());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                // Toast.makeText(MainActivity.this, getCurrentWeather.getWeather().get(0).getDescription(), Toast.LENGTH_SHORT).show();
                //generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                //progressDoalog.dismiss();
                Log.e("infailure",t.toString());
                Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }


/*
    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 3;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return FirstFragment.newInstance(0, "Page # 1");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return FirstFragment.newInstance(1, "Page # 2");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return SecondFragment.newInstance(2, "Page # 3");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Page " + position;
        }

    }
*/


/*
    public void getweatherVolley() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = " https://portalstandby.gnrgy.com/GnrgyTestService/Weather.svc/GetCurrentWeather?lat=12.9716&lon=77.5946";
        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d("ERROR","error => "+error.toString());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("API-KEY", "ECOVIBEAPIKEY");
                params.put("Content-Type", "application/x-www-form-urlencoded");

                return params;
            }
        };
        queue.add(getRequest);


}
*/

}

