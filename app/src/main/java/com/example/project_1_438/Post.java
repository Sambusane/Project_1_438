package com.example.project_1_438;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Post {
    @SerializedName("base")
    String base;
    @SerializedName("coord")
    Coord coord;
    @SerializedName("weather")
    List<Weather> weather;
    @SerializedName("main")
    Main1 main1;
    @SerializedName("visibility")
    Integer visibility;
    @SerializedName("wind")
    Wind wind;
    @SerializedName("clouds")
    Clouds cloud;
    @SerializedName("dt")
    Integer dt;
    @SerializedName("sys")
    Sys sys;
    @SerializedName("timezone")
    Integer timeZone;
    @SerializedName("id")
    Integer id;
    @SerializedName("name")
    String name;
    @SerializedName("cod")
    Integer cod;

    public Post(String base, Coord coord, List<Weather> weather, Main1 main1, Integer visibility, Wind wind, Clouds cloud, Integer dt, Sys sys, Integer timeZone, Integer id, String name, Integer cod) {
        this.base = base;
        this.coord = coord;
        this.weather = weather;
        this.main1 = main1;
        this.visibility = visibility;
        this.wind = wind;
        this.cloud = cloud;
        this.dt = dt;
        this.sys = sys;
        this.timeZone = timeZone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main1 getMain1() {
        return main1;
    }

    public void setMain1(Main1 main1) {
        this.main1 = main1;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getCloud() {
        return cloud;
    }

    public void setCloud(Clouds cloud) {
        this.cloud = cloud;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Integer getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Integer timeZone) {
        this.timeZone = timeZone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }
}

class Coord{
    @SerializedName("lon")
    float longitude;
    @SerializedName("lat")
    float latitude;

    public Coord(float longitude, float latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
}
class Weather {
    @SerializedName("id")
    Integer wId;
    @SerializedName("main")
    String main;
    @SerializedName("description")
    String description;
    @SerializedName("icon")
    String icon;

    public Weather(Integer wId, String main, String description, String icon) {
        this.wId = wId;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public Integer getwId() {
        return wId;
    }

    public void setwId(Integer wId) {
        this.wId = wId;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
class Main1 {
    @SerializedName("temp")
    float temp;
    @SerializedName("feels_like")
    float feels;
    @SerializedName("temp_min")
    float minTemp;
    @SerializedName("temp_max")
    float maxTemp;
    @SerializedName("pressure")
    float pressure;
    @SerializedName("humidity")
    float humidity;

    public Main1(float temp, float feels, float minTemp, float maxTemp, float pressure, float humidity) {
        this.temp = temp;
        this.feels = feels;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeels() {
        return feels;
    }

    public void setFeels(float feels) {
        this.feels = feels;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
}
class Wind{
    @SerializedName("speed")
    float speed;
    @SerializedName("deg")
    Integer degree;

    public Wind(float speed, Integer degree) {
        this.speed = speed;
        this.degree = degree;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }
}
class Clouds{
    @SerializedName("all")
    Integer all;

    public Clouds(Integer all) {
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }
}
class Sys{
    @SerializedName("type")
    Integer type;
    @SerializedName("id")
    Integer id;
    @SerializedName("message")
    float message;
    @SerializedName("country")
    String country;
    @SerializedName("sunrise")
    Integer sunrise;
    @SerializedName("sunset")
    Integer sunset;

    public Sys(Integer type, Integer id, float message, String country, Integer sunrise, Integer sunset) {
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getMessage() {
        return message;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }
}

