package com.example.thaigerweb.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.json.JSONObject;

public class InputData {
    public void inputData(JSONObject n){
         
        try {
            HttpResponse<String> response = Unirest.post("http://localhost:9200/thaiger_web/_doc/"+n.getString("MD5"))
            .header("Content-Type", "application/json")
            .body(n.toString())
            .asString();
        } catch (UnirestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

}
