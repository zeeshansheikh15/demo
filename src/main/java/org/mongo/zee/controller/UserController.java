package org.mongo.zee.controller;

import org.json.simple.JSONArray;
import org.mongo.zee.UserDao.UserDaoImpl;
import org.mongo.zee.model.UserLiability;
import org.mongo.zee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserDaoImpl userDao;

    @GetMapping("/users")
    public ResponseEntity<List<UserLiability>> getAllUsers(){
        return new ResponseEntity<>(userDao.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/userid")
    public ResponseEntity<List<UserLiability>> getAllUserId(){
        return new ResponseEntity<>(userDao.getAllUserId(), HttpStatus.OK);
    }

    @GetMapping("/useridandisactive")
    public ResponseEntity<JSONArray> getAllUserIdandisactive(){
        return new ResponseEntity<>(userDao.getAllUserIdandisactive(), HttpStatus.OK);
    }

    @GetMapping("/livepnlandresultnamefunc")
    public ResponseEntity<List<UserLiability>> getUserLivepnlandresultname(){
        return new ResponseEntity<>(userDao.getUserLivepnlandresultname(), HttpStatus.OK);
    }

    @GetMapping("/notuseridandisactivefunc")
    public ResponseEntity<List<UserLiability>> notuseridandisactive(){
        return new ResponseEntity<>(userDao.notuseridandisactive(), HttpStatus.OK);
    }


    @GetMapping("/notuseridandisactive")
    public ResponseEntity<List<UserLiability>> getAllNotUserIdandisactive(){
        return new ResponseEntity<>(userDao.getAllNotUserIdandisactive(), HttpStatus.OK);
    }

    @GetMapping("/livepnlandresultname")
    public ResponseEntity<List<UserLiability>> getAllUserLivepnlandresultname(){
        return new ResponseEntity<>(userDao.getAllUserLivepnlandresultname(), HttpStatus.OK);
    }



}