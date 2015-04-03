package com.example.kelly.logeasyfinal;

/**
 * Created by Kelly on 03/04/2015.
 */
public class Question {

    private long id;
    private String question_text;
    private String right_answer;
    private String level_id;

    public Question()
    {
        id=0;
    }

    public Question(String question, String answer, String level) {
        question_text=question;
        right_answer=answer;
        level_id=level;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public void setRight_answer(String right_answer){
        this.right_answer = right_answer;
    }

    public String getRight_answer(){
        return right_answer;
    }

    public void setLevel_id(String level_id){
        this.level_id=level_id;
    }

    public String getLevel_id(){
        return level_id;
    }
}

