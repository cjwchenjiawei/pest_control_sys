package com.lovo.dao;

import com.lovo.bean.MyClass;

import java.util.List;

public interface IMyClassDao {
    int count(String className, String areaName);

    List<MyClass> listByPage(int pageNo, int pageSize, String className, String areaName);

    int addClass(MyClass mc);

    int updateClass(MyClass mc);
}
