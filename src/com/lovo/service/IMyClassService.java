package com.lovo.service;

import com.lovo.bean.MyClass;
import com.lovo.util.PageUtil;
import com.lovo.vo.MyClassVO;

public interface IMyClassService {
    PageUtil<MyClassVO> listByPage(int pageNo, int pageSize, String className, String areaName);

    boolean addClass(MyClass mc);

    boolean updateClass(MyClass mc);
}
