package com.lovo.controller;

import com.google.gson.Gson;
import com.lovo.bean.Pest;
import com.lovo.service.IPestService;
import com.lovo.service.impl.PestServiceImpl;
import com.lovo.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PestServlet",urlPatterns = "/pest.do")
public class PestServlet extends HttpServlet {
    IPestService ps = new PestServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if (method==null||method.equalsIgnoreCase("")){
            indexByPage(request,response);
        }else if (method==null||method.equalsIgnoreCase("addPest")){
            addPest(request,response);
        }
    }

    private void addPest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String pestName = request.getParameter("pestName");
        String host = request.getParameter("host");
        String breed = request.getParameter("breed");
        String enemy = request.getParameter("enemy");
        String larvaeImages = request.getParameter("larvaeImages");
        String adultImages = request.getParameter("adultImages");
        String detriment = request.getParameter("detriment");
        String control = request.getParameter("control");
        Pest pest = new Pest(pestName,host,breed,enemy,larvaeImages,adultImages,detriment,control);
        boolean flag = ps.addPest(pest);
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
        String pestName = request.getParameter("pestName");
        String host = request.getParameter("host");
        PageUtil<Pest> pageBean = ps.listByPage(pageNo,pageSize,pestName,host);
        Gson gson = new Gson();
        String json = gson.toJson(pageBean);
        out.write(json);
    }
}
