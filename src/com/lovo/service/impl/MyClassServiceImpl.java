package com.lovo.service.impl;

import com.lovo.bean.MyClass;
import com.lovo.dao.IMyClassDao;
import com.lovo.dao.impl.MyClassDaoImpl;
import com.lovo.service.IMyClassService;
import com.lovo.util.PageUtil;
import com.lovo.vo.MyClassVO;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class MyClassServiceImpl implements IMyClassService {
    IMyClassDao cd = new MyClassDaoImpl();
    @Override
    public PageUtil<MyClassVO> listByPage(int pageNo, int pageSize, String className, String areaName) {
        int count = cd.count(className,areaName);
        List<MyClass> list = cd.listByPage(pageNo,pageSize,className,areaName);
        List<MyClassVO> listVO = new ArrayList<>();
        for (MyClass mc : list) {
            MyClassVO mcVO = new MyClassVO();
            try {
                BeanUtils.copyProperties(mcVO,mc);
                BeanUtils.copyProperty(mcVO,"areaName",mc.getArea().getAreaName());
                BeanUtils.copyProperty(mcVO,"forestType",mc.getArea().getForestType());
                BeanUtils.copyProperty(mcVO,"landType",mc.getArea().getLandType());
                BeanUtils.copyProperty(mcVO,"advantageTreeType",mc.getArea().getAdvantageTreeType());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            listVO.add(mcVO);
        }

        PageUtil<MyClassVO>pageBean = new PageUtil<>(listVO,pageNo,pageSize,count);
        return pageBean;
    }

    @Override
    public boolean addClass(MyClass mc) {
        int n = cd.addClass(mc);
        return n>0?true:false;
    }

    @Override
    public boolean updateClass(MyClass mc) {
        int n = cd.updateClass(mc);
        return n>0?true:false;
    }
}
