package com.lovo.controller;

import com.google.gson.Gson;
import com.lovo.bean.Area;
import com.lovo.bean.MyClass;
import com.lovo.service.IMyClassService;
import com.lovo.service.impl.MyClassServiceImpl;
import com.lovo.util.PageUtil;
import com.lovo.vo.MyClassVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "MyClassServlet",urlPatterns = "/MyClass.do")
public class MyClassServlet extends HttpServlet {
    IMyClassService cs = new MyClassServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method==null||method.equals("")){
            indexByPage(request,response);
        }else if (method.equalsIgnoreCase("addClass")){
            addClass(request,response);
        }else if (method.equalsIgnoreCase("updateClass")){
            updateClass(request,response);
        }
    }

    private void updateClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int pkid = Integer.parseInt(request.getParameter("pkid"));
        String leader = request.getParameter("leader");
        String tel = request.getParameter("tel");
        MyClass mc = new MyClass();
        mc.setPkid(pkid);
        mc.setLeader(leader);
        mc.setTel(tel);
        boolean flag = cs.updateClass(mc);
        out.write(String.valueOf(flag));
    }

    private void addClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String className = request.getParameter("className");
        String leader = request.getParameter("leader");
        String tel = request.getParameter("tel");
        int number = Integer.parseInt(request.getParameter("number"));
        int areaId = Integer.parseInt(request.getParameter("areaName"));
        Area a = new Area();
        a.setPkid(areaId);

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String establishDate = format.format(date);


        MyClass mc = new MyClass(className,leader,tel,number,a,establishDate);
        boolean flag = cs.addClass(mc);
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
        String className = request.getParameter("className");
        String areaName = request.getParameter("areaName");
        PageUtil<MyClassVO>pageBean = cs.listByPage(pageNo,pageSize,className,areaName);
        Gson gson = new Gson();
        String json = gson.toJson(pageBean);
        out.write(json);
    }
}

