package com.example.Analytics.controller;

import com.example.Analytics.entity.DtoEntity;
import com.example.Analytics.entity.PbUsersEntity;
import com.example.Analytics.services.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping(value="/analytics")
public class MainController {

    @Autowired
    AnalyticsService analyticsService;


    @PutMapping()
    public void save(@RequestBody DtoEntity dtoEntity)
    {
        switch (dtoEntity.getChannelId())
        {
            case 0:
                if(dtoEntity.getAction().equals("register") || dtoEntity.getAction().equals("login")) {
                    analyticsService.saveForLoginRegisterInPb(dtoEntity);
                }
                else if(dtoEntity.getAction().equals("logout")){
                    analyticsService.saveForLogutInPb(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("view")){
                    analyticsService.incrementViewCountInPb(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("follow")){
                    analyticsService.incrementFollowCountInPb(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("post")) {
                    analyticsService.saveForPost(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("like")){
                    analyticsService.likePostInPb(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("dislike")){
                    analyticsService.dislikePostInPb(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("comment")){
                    analyticsService.commentPostInPb(dtoEntity);
                }

                break;

            case 1:
                if(dtoEntity.getAction().equals("register") || dtoEntity.getAction().equals("login")) {
                    analyticsService.saveForLoginRegisterInQuora(dtoEntity);
                }
                else if(dtoEntity.getAction().equals("logout")){
                    analyticsService.saveForLogutInQuora(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("view")){
                    analyticsService.incrementViewCountInQuora(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("follow")){
                    analyticsService.incrementFollowCountInQuora(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("post")) {
                    analyticsService.saveForPost(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("like")){
                    analyticsService.likePostInQuora(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("dislike")){
                    analyticsService.dislikePostInQuora(dtoEntity);
                }
                else if (dtoEntity.getAction().equals("comment")){
                    analyticsService.commentPostInQuora(dtoEntity);
                }

                break;

            case 2:
                if(dtoEntity.getAction().equals("register") || dtoEntity.getAction().equals("login")) {
                    analyticsService.saveForLoginRegisterInQuiz(dtoEntity);
                }
                else if(dtoEntity.getAction().equals("logout")){
                    analyticsService.saveForLogutInQuiz(dtoEntity);
                }
                break;


        }
    }


    @GetMapping(value="/count/{channelId}")
    public int count(@PathVariable("channelId") int channelId)
    {
        return analyticsService.count(channelId);
    }

    @GetMapping(value="/views/{channelId}/{id}")
    public int countViews(@PathVariable("channelId") int channelId, @PathVariable("id") String id)
    {
        return analyticsService.countViews(channelId, id);
    }

    @GetMapping(value="/follows/{channelId}/{id}")
    public int countFollows(@PathVariable("channelId") int channelId, @PathVariable("id") String id)
    {
        return analyticsService.countFollows(channelId, id);
    }


    //changes
    @GetMapping(value = "/filter/RegUser/{channelId}") //180
    ResponseEntity getFilterRegUserPb(@PathVariable("channelId") int channelId, @RequestParam("day") int day{
        Calendar calendar = Calendar.getInstance();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -day);
        Date before = calendar.getTime();

        if(analyticsService.getFilterRegUserPb(today, before).size()==0)
            return new ResponseEntity("NOT FOUND", HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok()
                .body(analyticsService.getFilterRegUserPb(today, before));

    }
    @GetMapping(value = "/filter/RegUser/{channelId}") //180
    ResponseEntity getFilterRegUserQuora(@PathVariable("channelId") int channelId, @RequestParam("day") int day){
        Calendar calendar = Calendar.getInstance();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -day);
        Date before = calendar.getTime();

        if(analyticsService.getFilterRegUserQuora(today, before).size()==0)
            return new ResponseEntity("NOT FOUND", HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok()
                .body(analyticsService.getFilterRegUserQuora(today, before));

    }
    @GetMapping(value = "/filter/RegUser/{channelId}") //180
    ResponseEntity getFilterRegUserQuiz(@PathVariable("channelId") int channelId, @RequestParam("day") int day){
        Calendar calendar = Calendar.getInstance();
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        Date today = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, -day);
        Date before = calendar.getTime();

        if(analyticsService.getFilterRegUserQuiz(today, before).size()==0)
            return new ResponseEntity("NOT FOUND", HttpStatus.NOT_FOUND);
        else return ResponseEntity.ok()
                .body(analyticsService.getFilterRegUserQuiz(today, before));

    }
    //changes

}
