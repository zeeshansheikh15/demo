package org.mongo.zee.UserDao;

import org.json.simple.JSONArray;
import org.mongo.zee.model.UserLiability;

import java.util.List;

public interface UserDao {

    List<UserLiability> getAllUsers();

    List<UserLiability> getAllUserId();

    JSONArray getAllUserIdandisactive();

    List<UserLiability> getUserLivepnlandresultname();

    List<UserLiability> notuseridandisactive();

    List<UserLiability> getAllNotUserIdandisactive();

    List<UserLiability> getAllUserLivepnlandresultname();
}
