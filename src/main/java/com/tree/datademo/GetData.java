package com.tree.datademo;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GetData {

//    Connection conn = GetDataService.getConn();
//    Statement stmt = GetDataService.getStmt(conn);
//    String tableName = "ods_combiner_box_detail_d";
//    String deviceid = "7c97a84822b6bcdd6336c38b1dd26f8f";
//    String measur_dt = "20200804";
//
//
//    String sql = "select * from test";
//
//    ResultSet res = null;
//              try {
//        res = stmt.executeQuery(sql);
//
//        ResultSetMetaData meta = res.getMetaData();
//
//        for(int i = 1; i <= meta.getColumnCount(); i++){
//            System.out.print(meta.getColumnName(i) + "    ");
//        }
//        System.out.println();
//        while(res.next()){
//            System.out.print(res.getString(1) + "    ");
//            System.out.print(res.getString(2) + "    ");
//            System.out.println();
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//
//              try {
//        stmt.execute("insert into test1(id, name) values(222,'yang')");//需要拥有hdfs文件读写权限的用户才可以进行此操作
//        logger.debug("create is susscess");
//
//    } catch (SQLException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
//              HiveService.closeStmt(stmt);
//              HiveService.closeConn(conn);
//}

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";

//    public GetData() throws SQLException {
//    }

    public static void main(String[] args) throws SQLException {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
        //replace "hive" here with the name of the user the queries should run as
        Connection con = DriverManager.getConnection("jdbc:hive2://10.20.200.183:10000");
        Statement stmt = con.createStatement();
        String tableName = "new_energy.ods_combiner_box_detail_d";
        String deviceid = "\"7c97a84822b6bcdd6336c38b1dd26f8f\"";
        String measur_dt = "\"20200804\"";

//        // show tables
//        String sql = "show tables '" + tableName + "'";
//        System.out.println("Running: " + sql);
//        ResultSet res = stmt.executeQuery(sql);
//        if (res.next()) {
//            System.out.println(res.getString(1));
//        }


        // select * query
        //        SELECT p2m2,p2m3,ts FROM ods_combiner_box_detail_d
        //        WHERE deviceid = "7c97a84822b6bcdd6336c38b1dd26f8f"
        //        and measur_dt = "20200804" ORDER BY ts
        String sql = "SELECT p2m2,p2m3,ts FROM " + tableName + " WHERE deviceid ="+deviceid
                + " and measur_dt =" + measur_dt + " ORDER BY ts";
        System.out.println("Running: " + sql);
        ResultSet res = stmt.executeQuery(sql);
        Map<Integer,Object> results = new HashMap<>();
        while (res.next()) {
            float v = res.getFloat("p2m2");
            float i = res.getFloat("p2m3");
            Integer ts = new Integer(res.getString("ts"));
//            results.put()
//            System.out.println(String.valueOf(res.getFloat("p2m2")) + "\t" + String.valueOf(res.getFloat("p2m3")) + "\t" +res.getString("ts"));
        }
        GetDataService.closeStmt(stmt);
        GetDataService.closeConn(con);

        // regular hive query
//        sql = "select count(1) from " + tableName;
//        System.out.println("Running: " + sql);
//        res = stmt.executeQuery(sql);
//        while (res.next()) {
//            System.out.println(res.getString(1));
//        }
    }

}
