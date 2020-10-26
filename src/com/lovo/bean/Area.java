package com.lovo.bean;

public class Area {
    private int pkid; //区域编号
    private String areaName; //区域名称
    private String forestType;  //林中
    private String landType;   //地类
    private String advantageTreeType;   //优势树种
    private MyClass myClass;    //负责小班

    public Area(String areaName, String forestType, String landType, String advantageTreeType) {
        this.areaName = areaName;
        this.forestType = forestType;
        this.landType = landType;
        this.advantageTreeType = advantageTreeType;
    }

    public Area(int pkid, String areaName, String forestType, String landType, String advantageTreeType, MyClass myClass) {
        this.pkid = pkid;
        this.areaName = areaName;
        this.forestType = forestType;
        this.landType = landType;
        this.advantageTreeType = advantageTreeType;
        this.myClass = myClass;
    }

    @Override
    public String toString() {
        return "Area{" +
                "pkid=" + pkid +
                ", areaName='" + areaName + '\'' +
                ", forestType='" + forestType + '\'' +
                ", landType='" + landType + '\'' +
                ", advantageTreeType='" + advantageTreeType + '\'' +
                ", myClass=" + myClass +
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

    public MyClass getMyClass() {
        return myClass;
    }

    public void setMyClass(MyClass myClass) {
        this.myClass = myClass;
    }

    public Area() {
    }
}
