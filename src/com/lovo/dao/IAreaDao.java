package com.lovo.dao;

import com.lovo.bean.Area;

import java.util.List;

public interface IAreaDao {
    int count(String areaName, String forestType, String myClassName);

    List<Area> listByPage(int pageNo, int pageSize, String areaName, String forestType, String myClassName);

    int addArea(Area a);

    int getId(String areaName);

    List<Area> queryAreaList();
}
