package com.example.Analytics.repository;

import com.example.Analytics.entity.PostsEntity;
import com.example.Analytics.entity.QuizUsersEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostsRepository extends MongoRepository<PostsEntity, String> {
}
