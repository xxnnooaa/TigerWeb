package com.example.thaigerweb.service;

import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Getlink {
    public JSONArray putpgLink(String linky) {
        JSONArray urls = new JSONArray();
        try {

            Document doc = Jsoup.connect(linky).get();
            Elements classlinks = doc.select(".mvp-main-blog-body .left .relative");
            Elements links = classlinks.select("a[href]");

          for(int  i=0; i<links.size(); i++){
            urls.put(links.get(i).attr("href"));
            }
           
        } catch (Exception e) {
            //TODO: handle exception
        }

        return urls;
    }

        
}

