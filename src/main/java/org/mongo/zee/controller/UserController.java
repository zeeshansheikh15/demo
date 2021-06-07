package org.mongo.zee.controller;

import org.json.simple.JSONArray;
import org.mongo.zee.DaoImpl.UserDaoImpl;
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
        if(userDao.getAllUsers()!=null)
            return new ResponseEntity<>(userDao.getAllUsers(), HttpStatus.OK);
        else
            return new ResponseEntity<>(userDao.getAllUsers(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/userid")
    public ResponseEntity<List<UserLiability>> getAllUserId(){
        if(userDao.getAllUserId()!=null)
            return new ResponseEntity<>(userDao.getAllUserId(), HttpStatus.OK);
        else
            return new ResponseEntity<>(userDao.getAllUserId(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/useridandisactive")
    public ResponseEntity<JSONArray> getAllUserIdandisactive(){
        if(userDao.getAllUserIdandisactive()!=null)
            return new ResponseEntity<>(userDao.getAllUserIdandisactive(), HttpStatus.OK);
        else
            return new ResponseEntity<>(userDao.getAllUserIdandisactive(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/livepnlandresultnamefunc")
    public ResponseEntity<List<UserLiability>> getUserLivepnlandresultname(){
        if(userDao.getUserLivepnlandresultname()!=null)
            return new ResponseEntity<>(userDao.getUserLivepnlandresultname(), HttpStatus.OK);
        else
            return new ResponseEntity<>(userDao.getUserLivepnlandresultname(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/notuseridandisactivefunc")
    public ResponseEntity<List<UserLiability>> notuseridandisactive(){
        if(userDao.notuseridandisactive()!=null)
            return new ResponseEntity<>(userDao.notuseridandisactive(), HttpStatus.OK);
        else
            return new ResponseEntity<>(userDao.notuseridandisactive(), HttpStatus.NO_CONTENT);
    }


    @GetMapping("/notuseridandisactive")
    public ResponseEntity<List<UserLiability>> getAllNotUserIdandisactive(){
        if(userDao.getAllNotUserIdandisactive()!=null)
            return new ResponseEntity<>(userDao.getAllNotUserIdandisactive(), HttpStatus.OK);
        else
            return new ResponseEntity<>(userDao.getAllNotUserIdandisactive(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/livepnlandresultname")
    public ResponseEntity<List<UserLiability>> getAllUserLivepnlandresultname(){
        if(userDao.getAllUserLivepnlandresultname()!=null)
            return new ResponseEntity<>(userDao.getAllUserLivepnlandresultname(), HttpStatus.OK);
        else
            return new ResponseEntity<>(userDao.getAllUserLivepnlandresultname(), HttpStatus.NO_CONTENT);
    }



}