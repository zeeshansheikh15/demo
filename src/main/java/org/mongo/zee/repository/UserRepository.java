package org.mongo.zee.repository;

import org.mongo.zee.model.UserLiability;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserLiability, String> {

    List<UserLiability> findByuserid(String UserId);

    List<UserLiability> findByuseridAndIsactive(String UserId, Boolean isactive);

}
