package com.lovo.dao.impl;

import com.lovo.bean.Pest;
import com.lovo.dao.IPestDao;
import com.lovo.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PestDaoImpl implements IPestDao {
    @Override
    public List<Pest> listByPage(int pageNo, int pageSize, String pestName,String host) {
        List<Pest>pests = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("SELECT " +
                    "*" +
                    "FROM " +
                    "t_pest " +
                    " where 1=1 ");
            if (pestName!=null&&!pestName.equals("")){
                sql.append(" and t_pest.f_pestName like '%"+pestName+"%' ");
            }else if (host!=null&&!host.equals("")){
                sql.append(" and t_pest.f_host like '%"+host+"%' ");
            }
            sql.append("limit "+(pageNo-1)*pageSize+","+pageSize);

            ps = conn.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while(rs.next()){
                //读取数据库字段内容
                Pest pest = new Pest();
                pest.setPkid(rs.getInt("pkid"));
                pest.setPestName(rs.getString("f_pestName"));
                pest.setHost(rs.getString("f_host"));
                pest.setBreed(rs.getString("f_breed"));
                pest.setEnemy(rs.getString("f_enemy"));
                pest.setLarvaeImages(rs.getString("f_larvaeImages"));
                pest.setAdultImages(rs.getString("f_adultImages"));
                pest.setDetriment(rs.getString("f_detriment"));
                pest.setControl(rs.getString("f_control"));
                pests.add(pest);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs,ps,conn);
        }
        return pests;
    }

    @Override
    public int count(String pestName,String host) {
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("SELECT " +
                    "count(0) " +
                    "FROM " +
                    "t_pest where 1=1 ");
            if (pestName!=null&&!pestName.equals("")){
                sql.append("and t_pest.f_pestName like '%"+pestName+"%' ");
            }else if (host!=null&&!host.equals("")){
                sql.append(" and t_pest.f_host like '%"+host+"%' ");
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
    public int addPest(Pest pest) {
        int n = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConn();
            StringBuffer sql = new StringBuffer("insert into t_pest (f_pestName,f_host,f_breed,f_enemy,f_larvaeImages,f_adultImages,f_detriment,f_control) values (?,?,?,?,?,?,?,?)");
            ps = conn.prepareStatement(sql.toString());
            ps.setString(1,pest.getPestName());
            ps.setString(2,pest.getHost());
            ps.setString(3,pest.getBreed());
            ps.setString(4,pest.getEnemy());
            ps.setString(5,pest.getLarvaeImages());
            ps.setString(6,pest.getAdultImages());
            ps.setString(7,pest.getDetriment());
            ps.setString(8,pest.getControl());
            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(null,ps,conn);
        }
        return n;
    }
}
