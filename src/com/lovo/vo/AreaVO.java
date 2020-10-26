package com.lovo.vo;

import com.lovo.bean.MyClass;

public class AreaVO {
    private int pkid; //区域编号
    private String areaName; //区域名称
    private String forestType;  //林中
    private String landType;   //地类
    private String advantageTreeType;   //优势树种
    private String myClassName;    //负责小班

    @Override
    public String toString() {
        return "AreaVO{" +
                "pkid=" + pkid +
                ", areaName='" + areaName + '\'' +
                ", forestType='" + forestType + '\'' +
                ", landType='" + landType + '\'' +
                ", advantageTreeType='" + advantageTreeType + '\'' +
                ", myClassName='" + myClassName + '\'' +
                '}';
    }

    public int getPkid() {
        return pkid;
    }

    public void setPkid(int pkid) {
        this.pkid = pkid;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getForestType() {
        return forestType;
    }

    public void setForestType(String forestType) {
        this.forestType = forestType;
    }

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public String getAdvantageTreeType() {
        return advantageTreeType;
    }

    public void setAdvantageTreeType(String advantageTreeType) {
        this.advantageTreeType = advantageTreeType;
    }

    public String getMyClassName() {
        return myClassName;
    }

    public void setMyClassName(String myClassName) {
        this.myClassName = myClassName;
    }
}
