package com.example.Analytics.repository;

import com.example.Analytics.entity.QuizUsersEntity;
import com.example.Analytics.entity.QuoraUsersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface QuoraUsersRepository extends MongoRepository<QuoraUsersEntity, String> {

    //changes
    Iterable<QuoraUsersEntity> findByTimestampBetween(Date today, Date before);
    //changes

}
