package com.example.kelly.logeasyfinal;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by oanacozma on 04/04/15.
 */
public class ScoreboardClass implements Parcelable {
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

    public ScoreboardClass(Parcel in){
        readFromParcel(in);
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeLong(user_id);
        out.writeInt(points);
        out.writeInt(wrong_percent);
        out.writeString(level_id);
    }

    private void readFromParcel(Parcel in) {
        user_id = in.readInt();
        points = in.readInt();
        wrong_percent = in.readInt();
        level_id = in.readString();
    }

    @SuppressWarnings("unchecked")
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public ScoreboardClass createFromParcel(Parcel in) {
            return new ScoreboardClass(in);
        }

        public ScoreboardClass[] newArray(int size) {
            return new ScoreboardClass[size];
        }
    };
}
