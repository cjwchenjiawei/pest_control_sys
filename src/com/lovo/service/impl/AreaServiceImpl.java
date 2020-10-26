package com.lovo.service.impl;

import com.lovo.bean.Area;
import com.lovo.dao.IAreaDao;
import com.lovo.dao.impl.AreaDaoImpl;
import com.lovo.service.IAreaService;
import com.lovo.util.PageUtil;
import com.lovo.vo.AreaVO;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class AreaServiceImpl implements IAreaService {
    IAreaDao ad = new AreaDaoImpl();
    @Override
    public PageUtil<AreaVO> listByPage(int pageNo, int pageSize, String areaName, String forestType, String myClassName) {
        int count = ad.count(areaName,forestType,myClassName);
        List<Area>list = ad.listByPage(pageNo,pageSize,areaName,forestType,myClassName);
        List<AreaVO>listVO = new ArrayList<>();
        for (Area a : list) {
            AreaVO areaVO = new AreaVO();
            try {
                BeanUtils.copyProperties(areaVO,a);
                BeanUtils.copyProperty(areaVO,"myClassName",a.getMyClass().getClassName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            listVO.add(areaVO);
        }
        PageUtil<AreaVO>pageBean = new PageUtil<>(listVO,pageNo,pageSize,count);
        return pageBean;
    }

    @Override
    public boolean addArea(Area a) {
        int n = ad.addArea(a);
        return n>0?true:false;
    }

    @Override
    public List<Area> queryAreaList() {
        return ad.queryAreaList();
    }
}
