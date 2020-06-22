package com.wangqingyi.coolweather.db;

import org.litepal.crud.LitePalSupport;

public class City extends LitePalSupport {
    /**
     * 每个实体类都应该有的字段
     */
    private int id;
    /**
     * 记录市的代号
     */
    private int cityCode;
    /**
     * 记录市的名字
     */
    private String cityName;
    /**
     * 记录当前市所属省的id值
     */
    private int provinceId;
    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }



    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
