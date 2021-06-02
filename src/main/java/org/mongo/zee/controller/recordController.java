package org.mongo.zee.controller;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.mongo.zee.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class recordController {

    @Autowired
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
