package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

    public static void main(String[] args) throws SQLException {
        //create();
        //read();
        //update();
        //delete();
    }

    static void create() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "insert into airport.employee (name, surname) values ('name1', 'surname1') ";
            int i = st.executeUpdate(sql);
            System.out.println("i=" + i);
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
    }

    static void read() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("select id, name, surname from airport.employee");
            while (rs.next()) {
                System.out.println(rs.getObject("id") + "\t"
                        + rs.getObject("name") + "\t"
                        + rs.getObject("surname") + "\t");
            }
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
    }

    static void update() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "update airport.employee set name='name2' ";
            int i = st.executeUpdate(sql);
            System.out.println("i=" + i);
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
    }

    static void delete() throws SQLException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();
            String sql = "delete from airport.employee where id<4";
            int i = st.executeUpdate(sql);
            System.out.println("i=" + i);
        } finally {
            JdbcUtils.free(rs, st, conn);
        }
    }
}