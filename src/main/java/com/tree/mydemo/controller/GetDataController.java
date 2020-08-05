package com.tree.mydemo.controller;

import com.tree.datademo.GetDataService;
import com.tree.mydemo.domain.Telemetry;
import com.tree.mydemo.service.TelemetryService;
import com.tree.mydemo.utils.JsonData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/pub/telemetry")
public class GetDataController {


    String tableName = "new_energy.ods_combiner_box_detail_d";
    String deviceid = "\"7c97a84822b6bcdd6336c38b1dd26f8f\"";
    String measur_dt = "\"20200804\"";
    double capacity = 5.67;

    String sql = "SELECT p2m2,p2m3,ts FROM " + tableName + " WHERE deviceid ="+deviceid
            + " and measur_dt =" + measur_dt + " ORDER BY ts";

    @GetMapping("data")
    public JsonData getData() throws SQLException {
        Connection conn = TelemetryService.getConn();
        Statement stmt = TelemetryService.getStmt(conn);
        System.out.println("Running: " + sql);

        ResultSet res = stmt.executeQuery(sql);
        Map<Integer,Telemetry> results = new HashMap<>();
        int i=0;
        while (res.next()) {
            Telemetry telemetry = new Telemetry();
            telemetry.setV(res.getFloat("p2m2"));
            telemetry.setI(res.getFloat("p2m3"));
            telemetry.setTs(res.getString("ts"));

            results.put(i,telemetry);
            i++;
            //System.out.println(String.valueOf(res.getFloat("p2m2")) + "\t" + String.valueOf(res.getFloat("p2m3")) + "\t" +res.getString("ts"));
        }
        GetDataService.closeStmt(stmt);
        GetDataService.closeConn(conn);
//        System.out.println(results.toString());
        float sum = 0;
        for (int j = 0; j < results.size()-1; j++) {
            float v1 = results.get(j).getV();
            float i1 = results.get(j).getI();
            Long ts1 = Long.parseLong(results.get(j).getTs());
            System.out.println(ts1);

            float v2 = results.get(j+1).getV();
            float i2 = results.get(j+1).getI();
            Long ts2 = Long.parseLong(results.get(j+1).getTs());

//            float p = (v1*i1 + v2*i2)/2 * (ts2-ts1)/(1000*1000*3600);
            float p = (v1*i1 + v2*i2)/2;
            System.out.println(p);
            float ts = ts2-ts1;

            sum = sum + p*ts;

        }
        double hrs = sum/capacity/(1000*1000)/3600;
        return JsonData.buildSuccess(hrs);
    }

}
