package com.example.kelly.logeasyfinal;

/**
 * Created by oanacozma on 04/04/15.
 */
public class UserActivityClass {
    private long id;
    private int user_id;
    private String question_id;
    private String answer_id;
    private String wrong_YN;
    private String date;

    public UserActivityClass(){
        id = 0;
        user_id=0;
        question_id="";
        answer_id="";
        wrong_YN="";
        date="";
    }


    public UserActivityClass(int u_id, String q_id, String a_id,  String wrong, String dateTaken){
        user_id=u_id;
        question_id=q_id;
        answer_id=a_id;
        wrong_YN=wrong;
        date=dateTaken;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setDate(String date) {
        this.date = date;
    }


    public int getUser_id() {
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

}
