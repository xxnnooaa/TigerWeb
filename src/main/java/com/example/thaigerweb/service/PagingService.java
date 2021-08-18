package com.example.thaigerweb.service;

import java.io.IOException;
import org.json.JSONArray;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PagingService {

    public JSONArray putLink(String linky){

        JSONArray urls = new JSONArray();
        urls.put(linky);
         try {
            
            Document doc = Jsoup.connect(urls.get(0).toString()).get();
            
            Elements pages = doc.select(".inactive");
            Elements pagelink = pages.select("a");

            for(Element page : pagelink){
                urls.put(page.attr("href"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return urls;
    }

       
}

