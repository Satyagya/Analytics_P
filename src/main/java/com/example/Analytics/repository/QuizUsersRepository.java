package com.example.Analytics.repository;

import com.example.Analytics.entity.PbUsersEntity;
import com.example.Analytics.entity.QuizUsersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;

public interface QuizUsersRepository  extends MongoRepository<QuizUsersEntity, String> {


    //changes
    Iterable<QuizUsersEntity> findByTimestampBetween(Date today, Date before);
    // changes

}
