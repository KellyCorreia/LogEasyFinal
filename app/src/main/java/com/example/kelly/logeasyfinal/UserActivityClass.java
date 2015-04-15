package com.example.kelly.logeasyfinal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by oanacozma on 04/04/15.
 */
public class UserActivityClass {

    private long activity_id;
    private long user_id;
    private String question_id;
    private String answer_id;
    private String wrong_YN;
    private String date;

    public UserActivityClass(){
        activity_id=0;
        user_id=0;
        question_id="";
        answer_id="";
        wrong_YN="";
        date="";
    }


    public UserActivityClass( long u_id, String q_id, String a_id,  String wrong){

        user_id=u_id;
        question_id=q_id;
        answer_id=a_id;
        wrong_YN=wrong;
        date=getDateTime();
    }


    public long getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(long activity_id) {
        this.activity_id = activity_id;
    }

    public void setUser_id(long id) {
        this.user_id = id;
    }

    public String getDate() {
        return date;
    }

    public void setQuestion_id(String question_id) {
        this.question_id = question_id;
    }

    public void setAnswer_id(String answer_id) {
        this.answer_id = answer_id;
    }

    public void setWrong_YN(String wrong_YN) {
        this.wrong_YN = wrong_YN;
    }

    public void setDate() {
        this.date = this.getDateTime();
    }


    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getQuestion_id() {
        return question_id;
    }

    public String getWrong_YN() {
        return wrong_YN;
    }

    public String getAnswer_id() {
        return answer_id;
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

}
