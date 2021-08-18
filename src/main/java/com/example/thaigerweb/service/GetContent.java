package com.example.thaigerweb.service;

import java.io.IOException;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetContent {
  public JSONObject putData(String data) {
    JSONObject news = new JSONObject();

    try {
      Document doc = Jsoup.connect(data).get();
      Elements title = doc.select(".mvp-post-title.left.entry-title");
      Elements abstracts = doc.select("#mvp-content-main");
      Elements pubDate = doc.select(".post-date.updated");
      Elements source = doc.select(".mvp-nav-logo-small img");
      Elements postby = doc.select(".author-name.vcard.fn.author a");

      news.put("text_title", title.text());
      news.put("text_description", abstracts.text());
      news.put("date", pubDate.text());
      news.put("source", source.attr("alt"));
      news.put("language", "en");
      news.put("post", postby.attr("title"));
      news.put("url", data);

    } catch (Exception e) {
      // TODO: handle exception
    }

    return news;
  }

}
