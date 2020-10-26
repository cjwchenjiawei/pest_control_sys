package com.lovo.dao.impl;

import com.lovo.bean.Area;
import com.lovo.bean.MyClass;
import com.lovo.bean.Pest;
import com.lovo.dao.IAreaDao;
import com.lovo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreaDaoImpl implements IAreaDao {
    @Override
    public int count(String areaName, String forestType, String myClassName) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("SELECT " +
                    "count(0) " +
                    "FROM " +
                    "t_area a " +
                    "left join " +
                    "t_class c " +
                    "on a.pkid = c.pkid " +
                    "where 1=1 ");
            if (areaName!=null&&!areaName.equals("")){
                sql.append("and a.f_areaName like '%"+areaName+"%' ");
            }else if (forestType!=null&&!forestType.equals("")){
                sql.append(" and a.f_forestType like '%"+forestType+"%' ");
            }else if (myClassName!=null&&!myClassName.equals("")){
                sql.append(" and c.f_className like '%"+myClassName+"%' ");
            }
            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            if(rs.next()){
                //读取数据库字段内容
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs,ps,conn);
        }
        return count;
    }

    @Override
    public List<Area> listByPage(int pageNo, int pageSize, String areaName, String forestType, String myClassName) {
        List<Area> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("SELECT " +
                    "* " +
                    "FROM " +
                    "t_area a " +
                    "left join " +
                    "t_class c " +
                    "on a.pkid = c.pkid " +
                    "where 1=1 ");
            if (areaName!=null&&!areaName.equals("")){
                sql.append("and a.f_areaName like '%"+areaName+"%' ");
            }else if (forestType!=null&&!forestType.equals("")){
                sql.append(" and a.f_forestType like '%"+forestType+"%' ");
            }else if (myClassName!=null&&!myClassName.equals("")){
                sql.append(" and c.f_className like '%"+myClassName+"%' ");
            }
            sql.append("limit "+(pageNo-1)*pageSize+","+pageSize);

            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while(rs.next()){
                //读取数据库字段内容
                Area a = new Area();
                a.setPkid(rs.getInt("a.pkid"));
                a.setAreaName(rs.getString("a.f_areaName"));
                a.setForestType(rs.getString("a.f_forestType"));
                a.setLandType(rs.getString("a.f_landType"));
                a.setAdvantageTreeType(rs.getString("a.f_advantageTreeType"));
                MyClass mc = new MyClass();
                mc.setPkid(rs.getInt("c.pkid"));
                mc.setClassName(rs.getString("c.f_className"));
                mc.setLeader(rs.getString("c.f_leader"));
                mc.setTel(rs.getString("c.f_tel"));
                mc.setNumber(rs.getInt("c.f_number"));
                mc.setArea(a);
                mc.setEstablishDate(rs.getString("c.f_establishDate"));
                a.setMyClass(mc);
                list.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs,ps,conn);
        }
        return list;
    }

    @Override
    public int addArea(Area a) {
        int n = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("insert into t_area (f_areaName,f_forestType,f_landType,f_advantageTreeType) values(?,?,?,?)");
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1,a.getAreaName());
            ps.setString(2,a.getForestType());
            ps.setString(3,a.getLandType());
            ps.setString(4,a.getAdvantageTreeType());
            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
        return n;
    }

    @Override
    public int getId(String areaName) {
        int id = -1;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("SELECT " +
                    "pkid " +
                    "FROM " +
                    "t_area " +
                    "where f_areaName = ?");

            ps = conn.prepareStatement(sql.toString());
            ps.setString(1,areaName);
            rs = ps.executeQuery();
            if(rs.next()){
                //读取数据库字段内容
                id = rs.getInt("pkid");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs,ps,conn);
        }
        return id;
    }

    @Override
    public List<Area> queryAreaList() {
        List<Area> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("SELECT " +
                    "* " +
                    "FROM " +
                    "t_area a " +
                    "left join " +
                    "t_class c " +
                    "on a.pkid = c.pkid " +
                    "where c.pkid IS NULL ");

            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while(rs.next()){
                //读取数据库字段内容
                Area a = new Area();
                a.setPkid(rs.getInt("a.pkid"));
                a.setAreaName(rs.getString("a.f_areaName"));
                a.setForestType(rs.getString("a.f_forestType"));
                a.setLandType(rs.getString("a.f_landType"));
                a.setAdvantageTreeType(rs.getString("a.f_advantageTreeType"));
                MyClass mc = new MyClass();
                mc.setPkid(rs.getInt("c.pkid"));
                mc.setClassName(rs.getString("c.f_className"));
                mc.setLeader(rs.getString("c.f_leader"));
                mc.setTel(rs.getString("c.f_tel"));
                mc.setNumber(rs.getInt("c.f_number"));
                mc.setEstablishDate(rs.getString("c.f_establishDate"));
                a.setMyClass(mc);
                list.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs,ps,conn);
        }
        return list;
    }
}
