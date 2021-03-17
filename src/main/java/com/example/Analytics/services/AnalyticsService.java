package com.example.Analytics.services;

import com.example.Analytics.entity.DtoEntity;
import com.example.Analytics.entity.PbUsersEntity;
import com.example.Analytics.entity.QuizUsersEntity;
import com.example.Analytics.entity.QuoraUsersEntity;

import java.util.Date;
import java.util.List;

public interface AnalyticsService {

    void saveForLoginRegisterInPb(DtoEntity dtoEntity);
    void saveForLogutInPb(DtoEntity dtoEntity);
    void incrementViewCountInPb(DtoEntity dtoEntity);
    void incrementFollowCountInPb(DtoEntity dtoEntity);
    void saveForPost(DtoEntity dtoEntity);
    void likePostInPb(DtoEntity dtoEntity);
    void dislikePostInPb(DtoEntity dtoEntity);
    void commentPostInPb(DtoEntity dtoEntity);

    void saveForLoginRegisterInQuora(DtoEntity dtoEntity);
    void saveForLogutInQuora(DtoEntity dtoEntity);
    void incrementViewCountInQuora(DtoEntity dtoEntity);
    void incrementFollowCountInQuora(DtoEntity dtoEntity);
    void likePostInQuora(DtoEntity dtoEntity);
    void dislikePostInQuora(DtoEntity dtoEntity);
    void commentPostInQuora(DtoEntity dtoEntity);

    void saveForLoginRegisterInQuiz(DtoEntity dtoEntity);
    void saveForLogutInQuiz(DtoEntity dtoEntity);

    int count(int channelId);
    int countViews(int channelId, String id);
    int countFollows(int channelId, String id);

    //changes
    List<PbUsersEntity> getFilterRegUserPb(Date today, Date before);
    List<QuoraUsersEntity> getFilterRegUserQuora(Date today, Date before);
    List<QuizUsersEntity> getFilterRegUserQuiz(Date today, Date before);
    //changes
}
