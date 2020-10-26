package com.lovo.dao.impl;

import com.lovo.bean.Area;
import com.lovo.bean.MyClass;
import com.lovo.dao.IAreaDao;
import com.lovo.dao.IMyClassDao;
import com.lovo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyClassDaoImpl implements IMyClassDao {
    IAreaDao ad = new AreaDaoImpl();
    @Override
    public int count(String className, String areaName) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("SELECT " +
                    "count(0) " +
                    "FROM " +
                    "t_class c " +
                    "inner join " +
                    "t_area a " +
                    "on c.pkid = a.pkid " +
                    "where 1=1 ");
            if (areaName!=null&&!areaName.equals("")){
                sql.append("and a.f_areaName like '%"+areaName+"%' ");
            }else if (className!=null&&!className.equals("")){
                sql.append(" and c.f_className like '%"+className+"%' ");
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
    public List<MyClass> listByPage(int pageNo, int pageSize, String className, String areaName) {
        List<MyClass> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("SELECT " +
                    "* " +
                    "FROM " +
                    "t_area a " +
                    "inner join " +
                    "t_class c " +
                    "on a.pkid = c.pkid " +
                    "where 1=1 ");
            if (areaName!=null&&!areaName.equals("")){
                sql.append("and a.f_areaName like '%"+areaName+"%' ");
            }else if (className!=null&&!className.equals("")){
                sql.append(" and c.f_className like '%"+className+"%' ");
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
                list.add(mc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs,ps,conn);
        }
        return list;
    }

    @Override
    public int addClass(MyClass mc) {
        int n = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("insert into t_class values(?,?,?,?,?,?)");
            ps = conn.prepareStatement(sql.toString());
            int areaId = mc.getArea().getPkid();

            ps.setInt(1,areaId);
            ps.setString(2,mc.getClassName());
            ps.setString(3,mc.getLeader());
            ps.setString(4,mc.getTel());
            ps.setInt(5,mc.getNumber());
            ps.setString(6,mc.getEstablishDate());
            n = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
        return n;
    }

    @Override
    public int updateClass(MyClass mc) {
        int n = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("update t_class set f_leader=?,f_tel=? where pkid=?");
            ps = conn.prepareStatement(sql.toString());

            ps.setString(1,mc.getLeader());
            ps.setString(2,mc.getTel());
            ps.setInt(3,mc.getPkid());

            n = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
        return n;
    }
}
