package com.example.kelly.logeasyfinal;

/**
 * Created by Kelly on 03/04/2015.
 */
public class Answers {

    private long id;
    private String q_id;
    private String ans_a;
    private String ans_b;
    private String ans_c;

    public Answers(){
        id = 0;
    }

    public Answers(String question_id, String answerA, String answerB, String answerC){
        q_id = question_id;
        ans_a=answerA;
        ans_b=answerB;
        ans_c=answerC;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQ_id() {
        return q_id;
    }

    public void setQ_id(String q_id) {
        this.q_id = q_id;
    }

    public String getAns_a() {
        return ans_a;
    }

    public void setAns_a(String ans_a) {
        this.ans_a = ans_a;
    }

    public String getAns_b() {
        return ans_b;
    }

    public void setAns_b(String ans_b) {
        this.ans_b = ans_b;
    }

    public String getAns_c() {
        return ans_c;
    }

    public void setAns_c(String ans_c) {
        this.ans_c = ans_c;
    }
}

