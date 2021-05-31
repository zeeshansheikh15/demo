package org.mongo.zee.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class recordController {

    ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();

    @GetMapping("/records")
    public String fetchResults(Model model) throws IOException, ParseException {
        JSONArray jsonArray= (JSONArray) getConn().get("data");
        model.addAttribute("count", getCount(jsonArray) );
        return "home";
    }

    @GetMapping("/recordsTotal")
    public String fetchResultsTotal(Model model) throws IOException, ParseException {
        JSONArray jsonArray= (JSONArray) getConn().get("data");
        model.addAttribute("map", getTotal(jsonArray) );
        return "home2";
    }



    public int getCount(JSONArray jsonArray){
        int count=0;
        for (Object keyStr : jsonArray) {
            JSONObject jsonObject1 = (JSONObject) keyStr;
            if(Integer.parseInt(jsonObject1.get("team1goals").toString()) == Integer.parseInt(jsonObject1.get("team2goals").toString()))
                count++;
        }
        return count;
    }


    public JSONObject getConn() throws IOException, ParseException {

        String url = "https://jsonmock.hackerrank.com/api/football_matches?year=2011&page=1"; //just a string
        JSONObject jsonObject;
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            JSONParser jsonParser = new JSONParser();
            jsonObject = (JSONObject) jsonParser.parse(sb.toString());

        } finally {
            is.close();
        }
        return jsonObject;
    }

    public ConcurrentHashMap<String, Integer> getTotal(JSONArray jsonArray){
        for (Object keyStr : jsonArray) {
            JSONObject jsonObject1 = (JSONObject) keyStr;
            if(map.isEmpty()){
                System.out.print("str");
                map.put("0", 0);
            }
            for(String str : map.keySet()){
                System.out.print("str");
                if(jsonObject1.get("team1").toString().equalsIgnoreCase(str)){
                    int score = map.get(jsonObject1.get("team1"));
                    System.out.print(score);
                    int newscore = score + Integer.parseInt(jsonObject1.get("team1goals").toString());
                    System.out.println(newscore);
                    map.replace(jsonObject1.get("team1").toString(), score, newscore);
                }
                else {
                    map.put(jsonObject1.get("team1").toString(), Integer.parseInt(jsonObject1.get("team1goals").toString()));
                }

                if(jsonObject1.get("team2").toString().equalsIgnoreCase(str)){
                    int score = map.get(jsonObject1.get("team2"));
                    int newscore = score + Integer.parseInt(jsonObject1.get("team2goals").toString());
                    map.replace(jsonObject1.get("team2").toString(), score, newscore);
                }
                else{
                    map.put(jsonObject1.get("team2").toString(), Integer.parseInt(jsonObject1.get("team2goals").toString()));
                }
           }
        }
        return map;
    }

}
