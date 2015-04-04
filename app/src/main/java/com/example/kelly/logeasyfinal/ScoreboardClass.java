package com.example.kelly.logeasyfinal;

/**
 * Created by oanacozma on 04/04/15.
 */
public class ScoreboardClass {
    private int user_id;
    private int points;
    private int wrong_percent;
    private String level_id;

    public ScoreboardClass(){
        user_id=0;
        points=0;
        wrong_percent=0;
        level_id="";
    }

    public ScoreboardClass(int user, int no_of_points, int percent_wrong, String level){
        user_id=user;
        points=no_of_points;
        wrong_percent=percent_wrong;
        level_id=level;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getPoints() {
        return points;
    }

    public int getWrong_percent() {
        return wrong_percent;
    }

    public String getLevel_id() {
        return level_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setWrong_percent(int wrong_percent) {
        this.wrong_percent = wrong_percent;
    }

    public void setLevel_id(String level_id) {
        this.level_id = level_id;
    }
}
