package com.example.Analytics.services.impl;

import com.example.Analytics.entity.*;
import com.example.Analytics.repository.PbUsersRepository;
import com.example.Analytics.repository.PostsRepository;
import com.example.Analytics.repository.QuizUsersRepository;
import com.example.Analytics.repository.QuoraUsersRepository;
import com.example.Analytics.services.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {
    @Autowired
    PbUsersRepository pbUsersRepository;

    @Autowired
    QuoraUsersRepository quoraUsersRepository;

    @Autowired
    QuizUsersRepository quizUsersRepository;

    @Autowired
    PostsRepository postsRepository;

    @Override
    public void saveForLoginRegisterInPb(DtoEntity dtoEntity) {
        PbUsersEntity pbUsersEntity = new PbUsersEntity(dtoEntity.getChannelId(), dtoEntity.getid(), dtoEntity.getCategoryPreference(), true);
        pbUsersRepository.save(pbUsersEntity);
    }

    @Override
    public void saveForLogutInPb(DtoEntity dtoEntity) {
        PbUsersEntity pbUsersEntity = new PbUsersEntity(dtoEntity.getChannelId(), dtoEntity.getid(), dtoEntity.getCategoryPreference(), false);
        pbUsersRepository.save(pbUsersEntity);
    }

    @Override
    public void incrementViewCountInPb(DtoEntity dtoEntity) {
        PbUsersEntity pbUsersEntity= pbUsersRepository.findById(dtoEntity.getid()).get();
        pbUsersEntity.setViews(pbUsersEntity.getViews()+1);
        pbUsersRepository.save(pbUsersEntity);
    }

    @Override
    public void incrementFollowCountInPb(DtoEntity dtoEntity) {
        PbUsersEntity pbUsersEntity= pbUsersRepository.findById(dtoEntity.getid()).get();
        pbUsersEntity.setFollowers(pbUsersEntity.getFollowers()+1);
        pbUsersRepository.save(pbUsersEntity);
    }

    @Override
    public void saveForPost(DtoEntity dtoEntity) {
        PostsEntity postsEntity = new PostsEntity(dtoEntity.getChannelId(), dtoEntity.getid(), dtoEntity.getCategoryPreference(), true);
        postsRepository.save(postsEntity);
    }

    @Override
    public void likePostInPb(DtoEntity dtoEntity) {
        PostsEntity postEntity= postsRepository.findById(dtoEntity.getPostId()).get();
        postEntity.setLikes(postEntity.getLikes()+1);
        postsRepository.save(postEntity);

    }

    @Override
    public void dislikePostInPb(DtoEntity dtoEntity) {
        PostsEntity postEntity= postsRepository.findById(dtoEntity.getPostId()).get();
        postEntity.setDislikes(postEntity.getDislikes()+1);
        postsRepository.save(postEntity);
    }

    @Override
    public void commentPostInPb(DtoEntity dtoEntity) {
        PostsEntity postEntity= postsRepository.findById(dtoEntity.getPostId()).get();
        postEntity.setComments(postEntity.getComments()+1);
        postsRepository.save(postEntity);
    }






    @Override
    public void saveForLoginRegisterInQuora(DtoEntity dtoEntity) {
        QuoraUsersEntity quoraUsersEntity = new QuoraUsersEntity(dtoEntity.getChannelId(), dtoEntity.getid(), dtoEntity.getCategoryPreference(), true);
        quoraUsersRepository.save(quoraUsersEntity);
    }

    @Override
    public void saveForLogutInQuora(DtoEntity dtoEntity) {
        QuoraUsersEntity quoraUsersEntity = new QuoraUsersEntity(dtoEntity.getChannelId(), dtoEntity.getid(), dtoEntity.getCategoryPreference(), false);
        quoraUsersRepository.save(quoraUsersEntity);
    }


    @Override
    public void incrementViewCountInQuora(DtoEntity dtoEntity) {
        QuoraUsersEntity quoraUsersEntity= quoraUsersRepository.findById(dtoEntity.getid()).get();
        quoraUsersEntity.setViews(quoraUsersEntity.getViews()+1);
        quoraUsersRepository.save(quoraUsersEntity);
    }

    @Override
    public void incrementFollowCountInQuora(DtoEntity dtoEntity) {
        QuoraUsersEntity quoraUsersEntity= quoraUsersRepository.findById(dtoEntity.getid()).get();
        quoraUsersEntity.setFollowers(quoraUsersEntity.getFollowers()+1);
        quoraUsersRepository.save(quoraUsersEntity);
    }

    @Override
    public void likePostInQuora(DtoEntity dtoEntity) {

    }

    @Override
    public void dislikePostInQuora(DtoEntity dtoEntity) {

    }

    @Override
    public void commentPostInQuora(DtoEntity dtoEntity) {

    }

    @Override
    public void saveForLoginRegisterInQuiz(DtoEntity dtoEntity) {
        QuizUsersEntity quizUsersEntity = new QuizUsersEntity(dtoEntity.getChannelId(), dtoEntity.getid(), dtoEntity.getCategoryPreference(), true);
        quizUsersRepository.save(quizUsersEntity);
    }

    @Override
    public void saveForLogutInQuiz(DtoEntity dtoEntity) {
        QuizUsersEntity quizUsersEntity = new QuizUsersEntity(dtoEntity.getChannelId(), dtoEntity.getid(), dtoEntity.getCategoryPreference(), false);
        quizUsersRepository.save(quizUsersEntity);
    }

    @Override
    public int count(int channelId) {


        if(channelId==0)
        {
         List<PbUsersEntity> pbUsersEntitiesList = pbUsersRepository.findAll();
        int count0 = 0;
        for (PbUsersEntity pb: pbUsersEntitiesList)
            if(pb.getStatus()==true){
                count0++;
            }
            return count0;

        }
        else if(channelId==1)
        {
            List<QuoraUsersEntity> quoraUsersEntitiesList = quoraUsersRepository.findAll();
            int count1 = 0;
            for (QuoraUsersEntity quora: quoraUsersEntitiesList)
                if(quora.getStatus()==true){
                    count1++;
                }
                return count1;
        }
        else if(channelId==2)
        {
            List<QuizUsersEntity> quizUsersEntitiesList = quizUsersRepository.findAll();
            int count2 = 0;
            for (QuizUsersEntity quiz: quizUsersEntitiesList)
                if(quiz.getStatus()==true){
                    count2++;
                }
                return count2;
        }
        return 0;
    }

    @Override
    public int countViews(int channelId, String id) {
        if(channelId==0)
        {
            List<PbUsersEntity> pbUsersEntitiesList = pbUsersRepository.findAll();
            for (PbUsersEntity pb: pbUsersEntitiesList)
                if(pb.getid().equals(id)){
                    return pb.getViews();
                }

        }
        else if(channelId==1)
        {
            List<QuoraUsersEntity> quoraUsersEntitiesList = quoraUsersRepository.findAll();
            for (QuoraUsersEntity quora: quoraUsersEntitiesList)
                if(quora.getid().equals(id)){
                    return quora.getViews();
                }
        }
        return 0;
    }



    @Override
    public int countFollows(int channelId, String id) {
        if(channelId==0)
        {
            List<PbUsersEntity> pbUsersEntitiesList = pbUsersRepository.findAll();
            for (PbUsersEntity pb: pbUsersEntitiesList)
                if(pb.getid().equals(id)){
                    return pb.getFollowers();
                }

        }
        else if(channelId==1)
        {
            List<QuoraUsersEntity> quoraUsersEntitiesList = quoraUsersRepository.findAll();
            for (QuoraUsersEntity quora: quoraUsersEntitiesList)
                if(quora.getid().equals(id)){
                    return quora.getFollowers();
                }
        }
        return 0;
    }


    @Override
    public List<PbUsersEntity> getFilterRegUserPb(Date today, Date before)
    {
        if(channelId==0) {
            Iterable<PbUsersEntity> userIterable = pbUsersRepository.findByTimestampBetween(today, before);
        }
        List<PbUsersEntity> pbUserList = new ArrayList<>();
        userIterable.forEach(pbUserList::add);
        //pbUserList.forEach(pbUsersEntity -> System.out.println(pbUsersEntity));
        return pbUserList;
    }

    @Override
    public List<QuoraUsersEntity> getFilterRegUserQuora(Date today, Date before)
    {
        Iterable<QuoraUsersEntity> userIterable = quoraUsersRepository.findByTimestampBetween(today, before);
        List<QuoraUsersEntity> quoraUserList = new ArrayList<>();
        userIterable.forEach(quoraUserList::add);
        //pbUserList.forEach(pbUsersEntity -> System.out.println(pbUsersEntity));
        return quoraUserList;
    }

    @Override
    public List<QuizUsersEntity> getFilterRegUserQuiz(Date today, Date before)
    {
        Iterable<QuizUsersEntity> userIterable = quizUsersRepository.findByTimestampBetween(today, before);
        List<QuizUsersEntity> quizUserList = new ArrayList<>();
        userIterable.forEach(quizUserList::add);
        //pbUserList.forEach(pbUsersEntity -> System.out.println(pbUsersEntity));
        return quizUserList;
    }

}
