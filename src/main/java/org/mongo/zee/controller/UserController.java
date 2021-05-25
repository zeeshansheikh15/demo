package org.mongo.zee.controller;

import org.json.simple.JSONArray;
import org.mongo.zee.model.UserLiability;
import org.mongo.zee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<UserLiability> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/userid")
    public List<UserLiability> getAllUserId(){
        return userRepository.findByuserid("user");
    }


    @GetMapping("/useridandisactive")
    public JSONArray getAllUserIdandisactive(){
        JSONArray jsonArray = new JSONArray();
        jsonArray.add( userRepository.findByuseridAndIsactive("user", false));
        jsonArray.add( userRepository.findByuseridAndIsactive("user", true));
        return jsonArray;
    }


}