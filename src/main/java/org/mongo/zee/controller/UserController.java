package org.mongo.zee.controller;

import org.json.simple.JSONArray;
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

    @GetMapping("/livepnlandresultnamefunc")
    public List<UserLiability> getUserLivepnlandresultname(){
        return userRepository.findByresultNameAndUserlivepnlGreaterThan("Player B", 100);
    }

    @GetMapping("/notuseridandisactivefunc")
    public List<UserLiability> notuseridandisactive(){
        String[] arr = {"5bed21404aa1a721d46facff","rohit22","tinku011"};
        return userRepository.findByIsactiveAndUseridNotIn(true, arr);
    }


    @GetMapping("/notuseridandisactive")
    public List<UserLiability> getAllNotUserIdandisactive(){
        MatchOperation isactive = match(Criteria.where("isactive").is(true)
                .and("userid").nin("5bed21404aa1a721d46facff","rohit22","tinku011"));
        Aggregation aggregation = newAggregation(isactive);
        return mongoTemplate.aggregate(aggregation, "liability", UserLiability.class).getMappedResults();
    }

    @GetMapping("/livepnlandresultname")
    public List<UserLiability> getAllUserLivepnlandresultname(){
        MatchOperation userlivepnl = match(Criteria.where("resultName").is("Player B").and("userlivepnl").gt(100));
        Aggregation aggregation = newAggregation(userlivepnl);
        return mongoTemplate.aggregate(aggregation, "liability", UserLiability.class).getMappedResults();
    }



}