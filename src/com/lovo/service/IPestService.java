package com.lovo.service;

import com.lovo.bean.Pest;
import com.lovo.util.PageUtil;

public interface IPestService{
    PageUtil<Pest> listByPage(int pageNo, int pageSize, String pestName,String host);

    boolean addPest(Pest pest);
}
