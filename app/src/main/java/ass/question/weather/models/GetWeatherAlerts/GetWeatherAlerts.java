package ass.question.weather.models.GetWeatherAlerts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetWeatherAlerts {

@SerializedName("cod")
@Expose
private Integer cod;
@SerializedName("alerts")
@Expose
private List<Alert> alerts = null;

public Integer getCod() {
return cod;
}

public void setCod(Integer cod) {
this.cod = cod;
}

public List<Alert> getAlerts() {
return alerts;
}

public void setAlerts(List<Alert> alerts) {
this.alerts = alerts;
}

}