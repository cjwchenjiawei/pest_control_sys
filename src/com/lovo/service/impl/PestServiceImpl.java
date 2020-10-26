package com.lovo.service.impl;

import com.lovo.bean.Pest;
import com.lovo.dao.IPestDao;
import com.lovo.dao.impl.PestDaoImpl;
import com.lovo.service.IPestService;
import com.lovo.util.PageUtil;

import java.util.List;

public class PestServiceImpl implements IPestService {
    IPestDao pd = new PestDaoImpl();
    @Override
    public PageUtil<Pest> listByPage(int pageNo, int pageSize, String pestName,String host) {
        List<Pest> pests = pd.listByPage(pageNo,pageSize,pestName,host);
        int count = pd.count(pestName,host);
        PageUtil<Pest> pageBean = new PageUtil<>(pests,pageNo,pageSize,count);
        return pageBean;
    }

    @Override
    public boolean addPest(Pest pest) {
        int n = pd.addPest(pest);
        return n>0?true:false;
    }
}
