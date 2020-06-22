package com.wangqingyi.coolweather.util;

import android.text.TextUtils;

import com.wangqingyi.coolweather.db.City;
import com.wangqingyi.coolweather.db.County;
import com.wangqingyi.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 用于解析和处理JSON数据
 */

 public class Utility {

    /**
     * 解析和处理从服务其返回的省级数据
     */
    public static boolean handleProvinceResponse(String response) {
        //对response进行判空
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvider = new JSONArray(response);
                //用LitePal对数据进行遍历
                for (int i = 0; i < allProvider.length(); i++) {
                    JSONObject providerObject = allProvider.getJSONObject(i);
                   //用LitePal对数据进行保存
                    Province province = new Province();
                    province.setProvinceName(providerObject.getString("name"));
                    province.setProvinceCode(providerObject.getInt("id"));
                    //将数据存储到数据库中
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {

                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handCountiesResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i < allCounties.length(); i++) {
                    JSONObject countiesObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countiesObject.getString("name"));
                    county.setWeatherId(countiesObject.getInt("id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}