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
import org.mongo.zee.services.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class recordController {

    private RecordService recordService;

    @GetMapping("/records")
    public String fetchResults(Model model) throws IOException, ParseException {
        model.addAttribute("count", recordService.getCount() );
        return "home";
    }

    @GetMapping("/recordsTotal")
    public String fetchResultsTotal(Model model) throws IOException, ParseException {
        model.addAttribute("map", recordService.getTotal() );
        return "home2";
    }

}
