package com.lovo.service;

import com.lovo.bean.Area;
import com.lovo.util.PageUtil;
import com.lovo.vo.AreaVO;

import java.util.List;

public interface IAreaService {
    PageUtil<AreaVO> listByPage(int pageNo, int pageSize, String areaName, String forestType, String myClassName);

    boolean addArea(Area a);

    List<Area> queryAreaList();
}
