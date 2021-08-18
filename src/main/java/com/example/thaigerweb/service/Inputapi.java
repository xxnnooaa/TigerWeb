package com.example.thaigerweb.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;

public class Inputapi {
    public void inputAPI(JSONObject data){

        try {
            
            Unirest.setTimeouts(0, 0);
            HttpResponse<String> response = Unirest.post("http://192.168.0.142:8888/text_analytic")
            .header("Content-Type", "application/json")
            .body(data.toString())
            .asString();

            //  get ข้อมูลที่ได้จากการ call Api 
            String n = response.getBody();

            //  แปลง String เป็น Json 
            JSONObject obj = new JSONObject(n);

            String md5 = DigestUtils.md5Hex(obj.toString());

            obj.put("MD5", md5);
            obj.put("language", data.getString("language"));
            obj.put("source", data.getString("source"));
            obj.put("excise_title", data.getString("text_title"));
            obj.put("excise_date", "Published: " + data.getString("date") + "  " + data.getString("post"));
            obj.put("url", data.getString("url"));


            InputData item = new InputData();
            item.inputData(obj);
        } catch (Exception e) {
            //TODO: handle exception
        }

    }
    
}
