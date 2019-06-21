package ass.question.weather.models.PostForecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostForecast {

@SerializedName("cod")
@Expose
private String cod;
@SerializedName("list")
@Expose
private java.util.List<ass.question.weather.models.PostForecast.List> list = null;
@SerializedName("city")
@Expose
private City city;

public String getCod() {
return cod;
}

public void setCod(String cod) {
this.cod = cod;
}

public java.util.List<ass.question.weather.models.PostForecast.List> getList() {
return list;
}

public void setList(java.util.List<ass.question.weather.models.PostForecast.List> list) {
this.list = list;
}

public City getCity() {
return city;
}

public void setCity(City city) {
this.city = city;
}

}