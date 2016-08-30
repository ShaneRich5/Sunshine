package com.shane.sunshine;

import android.support.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shane on 8/30/2016.
 */
public class WeatherDataParser {
    public static double getMaxTemperatureForDay(@NonNull String weatherJsonString, int dayIndex) throws JSONException {
        JSONObject weatherData = new JSONObject(weatherJsonString);
        JSONArray days = weatherData.getJSONArray("list");
        JSONObject dayInfo = days.getJSONObject(dayIndex);
        JSONObject temperatureInfo = dayInfo.getJSONObject("temp");
        return temperatureInfo.getDouble("max");
    }
}
