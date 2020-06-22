package com.wangqingyi.coolweather.db;

import org.litepal.crud.LitePalSupport;

public class County extends LitePalSupport {
    /**
     * 每个实体类都应该有的字段
     */
    private int id;
    /**
     * 记录当前县对应的天气id
     */
    private int weatherId;
    /**
     * 记录当前县所属市id
     */
    private int cityId;
    /**
     * 记录县的名字
     */
    private String countyName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }


}
