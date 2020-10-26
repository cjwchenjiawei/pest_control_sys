package com.lovo.controller;

import com.google.gson.Gson;
import com.lovo.bean.Area;
import com.lovo.service.IAreaService;
import com.lovo.service.impl.AreaServiceImpl;
import com.lovo.util.PageUtil;
import com.lovo.vo.AreaVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AreaServlet",urlPatterns = "/area.do")
public class AreaServlet extends HttpServlet {
    IAreaService as = new AreaServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method==null||method.equals("")){
            indexByPage(request,response);
        }else if (method.equalsIgnoreCase("addArea")){
            addArea(request,response);
        }else if (method.equalsIgnoreCase("queryAreaList")){
            queryAreaList(request,response);
        }
    }

    private void queryAreaList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        List<Area> list = as.queryAreaList();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        System.out.println("json = " + json);
        out.write(json);
    }

    private void addArea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String areaName = request.getParameter("areaName");
        String forestType = request.getParameter("forestType");
        String landType = request.getParameter("landType");
        String advantageTreeType = request.getParameter("advantageTreeType");
        Area a = new Area(areaName,forestType,landType,advantageTreeType);
        boolean flag = as.addArea(a);
        out.write(String.valueOf(flag));
    }

    private void indexByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNo = 1;
        String p = request.getParameter("pageNo");
        if(p == null){
            pageNo = 1;
        }
        else{
            pageNo = Integer.parseInt(p);
        }
        String areaName = request.getParameter("areaName");
        String forestType = request.getParameter("forestType");
        String myClassName = request.getParameter("myClass");
        PageUtil<AreaVO>pageBean = as.listByPage(pageNo,pageSize,areaName,forestType,myClassName);
        Gson gson = new Gson();
        String json = gson.toJson(pageBean);
        out.write(json);
    }
}
