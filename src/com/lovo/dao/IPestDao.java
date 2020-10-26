package com.lovo.dao;

import com.lovo.bean.Pest;

import java.util.List;

public interface IPestDao {
    List<Pest> listByPage(int pageNo, int pageSize, String pestName,String host);

    int count(String pestName,String host);

    int addPest(Pest pest);
}
