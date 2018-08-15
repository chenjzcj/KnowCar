package com.succ7.knowcar.bean;

import java.io.Serializable;

/**
 * author : 527633405@qq.com
 * time : 2016/4/5
 */
public class Car implements Serializable{
    private String carName;//车名
    private String carHome;//车的产地
    private int carLogoId;//车的logo资料id
    private String carIntroduces;//车的介绍
    private String carBDaddress;//百度百科地址

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarHome() {
        return carHome;
    }

    public void setCarHome(String carHome) {
        this.carHome = carHome;
    }

    public int getCarLogoId() {
        return carLogoId;
    }

    public void setCarLogoId(int carLogoId) {
        this.carLogoId = carLogoId;
    }

    public String getCarIntroduces() {
        return carIntroduces;
    }

    public void setCarIntroduces(String carIntroduces) {
        this.carIntroduces = carIntroduces;
    }

    public String getCarBDaddress() {
        return carBDaddress;
    }

    public void setCarBDaddress(String carBDaddress) {
        this.carBDaddress = carBDaddress;
    }
}
