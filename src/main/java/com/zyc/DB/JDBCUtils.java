package com.zyc.DB;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author zhouyongcai
 * @create_time 2020/4/26 10:48
 * @note：
 */
public class JDBCUtils {

    /**
     * 获得链接
     * @param url
     * @param username
     * @param password
     * @return
     */
    public static Connection getConn(String driver, String url, String username, String password) {
        Connection conn = null;
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取已配置好的链接
     * @return
     */
    public static Connection getConn() throws Exception {
        Properties properties=new Properties();
        properties.load(new FileInputStream("src/main/resources/conf/druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        return ds.getConnection();
    }

    /**
     * 获取所有字段
     * @param rs
     * @return
     * @throws SQLException
     */
    public static ArrayList<String> getColumns(ResultSet rs) throws SQLException {
        ArrayList<String> columns = new ArrayList<String>();
        ResultSetMetaData metaData = rs.getMetaData();

        // 添加字段以及字段类型
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            columns.add(metaData.getColumnName(i));
        }

        return columns;
    }

    /**
     * 执行sql，返回数据
     * @param sql 查询sql
     * @return 返回结果集
     */
    public static List<List<Object>> executeQuery(String sql, Connection conn) throws SQLException {
        ArrayList<List<Object>> dataSet = new ArrayList<List<Object>>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ArrayList<String> columns = getColumns(rs);
            while (rs.next()) {
                // 填装单行数据
                ArrayList<Object> line = new ArrayList<Object>();
                for (int i = 0; i < columns.size(); i++) {
                    // 抽象数据类型
                    line.add(rs.getObject(columns.get(i))) ;
                }
                // 填装所有数据
                dataSet.add(line);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(ps, rs);
        }
        return dataSet;
    }

    /**
     * 只支持单行的更新货插入，前提是sql中已写入数据。
     */
    public static void insertOrUpdate(String sql, Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        close(ps, rs);
    }

    /**
     * 关闭 conn, ps, rs
     * @param conn
     * @param ps
     * @param rs
     */
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
            if(conn != null) conn.close();
            if(ps != null) ps.close();
            if(rs != null) rs.close();
    }

    /**
     * 关闭 ps, rs
     * @param ps
     * @param rs
     * @throws SQLException
     */
    public static void close( PreparedStatement ps, ResultSet rs) throws SQLException {
            if(ps != null) ps.close();
            if(rs != null) rs.close();
    }

    /**
     * 关闭 conn
     * @param conn
     */
    public static void close( Connection conn) throws SQLException {
            if(conn != null) conn.close();
    }



}
