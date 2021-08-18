package com.example.thaigerweb.getdata;

import com.example.thaigerweb.service.GetContent;
import com.example.thaigerweb.service.Getlink;
import com.example.thaigerweb.service.Inputapi;
import com.example.thaigerweb.service.PagingService;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Getdata {
    @Scheduled(fixedRate = 80000)
    public void getbklinks() {

            PagingService s = new PagingService();
            JSONArray link = s.putLink("https://thethaiger.com/?s=excise");
            for(int i=0 ; i<link.length() ; i++){
                    Getlink links = new Getlink();
                    JSONArray url = links.putpgLink(link.get(i).toString());

                    for(int j=0; j<url.length(); j++){
                        GetContent data = new GetContent();
                        JSONObject item = data.putData(url.get(j).toString());

                        Inputapi in = new Inputapi();
                        in.inputAPI(item);
                    }

            }
    }
}
