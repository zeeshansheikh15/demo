package org.mongo.zee.controller;

import org.json.simple.JSONArray;
import org.mongo.zee.UserDao.UserDaoImpl;
import org.mongo.zee.model.UserLiability;
import org.mongo.zee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserDaoImpl userDao;

    @GetMapping("/users")
    public List<UserLiability> getAllUsers(){
        return userDao.getAllUsers();
    }

    @GetMapping("/userid")
    public List<UserLiability> getAllUserId(){
        return userDao.getAllUserId();
    }

    @GetMapping("/useridandisactive")
    public JSONArray getAllUserIdandisactive(){
        return userDao.getAllUserIdandisactive();
    }

    @GetMapping("/livepnlandresultnamefunc")
    public List<UserLiability> getUserLivepnlandresultname(){
        return userDao.getUserLivepnlandresultname();
    }

    @GetMapping("/notuseridandisactivefunc")
    public List<UserLiability> notuseridandisactive(){
        return userDao.notuseridandisactive();
    }


    @GetMapping("/notuseridandisactive")
    public List<UserLiability> getAllNotUserIdandisactive(){
        return userDao.getAllNotUserIdandisactive();
    }

    @GetMapping("/livepnlandresultname")
    public List<UserLiability> getAllUserLivepnlandresultname(){
        return userDao.getAllUserLivepnlandresultname();
    }



}