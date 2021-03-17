package com.example.Analytics.repository;

import com.example.Analytics.entity.PbUsersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PbUsersRepository extends MongoRepository<PbUsersEntity, String> {
//    List<PbUsersEntity> findById(String id);

    //changes
    Iterable<PbUsersEntity> findByTimestampBetween(Date today, Date before);
    // changes
}

