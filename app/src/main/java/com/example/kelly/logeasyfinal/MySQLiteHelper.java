package com.example.kelly.logeasyfinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kelly on 03/04/2015.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "databaseQuiz";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_QUESTIONS = "table_questions";
    public static final String COLUMN_QUESTION_ID = "_id";
    public static final String COLUMN_QUESTION_TEXT = "question_text";
    public static final String COLUMN_RIGHT_ANSWER = "right_answer";
    public static final String COLUMN_LEVEL_ID = "level_id";


    public static final String TABLE_USERS_ACT = "users_activity";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_Q_ID = "question_id";
    public static final String COLUMN_DATE = "date";


    private static final String QUESTIONS_DATABASE_CREATE = "create table "
            + TABLE_QUESTIONS + "(" + COLUMN_QUESTION_ID
            + " integer primary key autoincrement, " + COLUMN_QUESTION_TEXT
            + " text not null, "+ COLUMN_LEVEL_ID
            + " text not null, "+ COLUMN_RIGHT_ANSWER
            + " text not null)";

    private static final String USERS_ACT_DATABASE_CREATE ="CREATE TABLE "
            + TABLE_USERS_ACT + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_USER_ID
            + " text not null, "+ COLUMN_Q_ID
            + " text not null, "+ COLUMN_DATE
            + " text not null)";

    private SQLiteDatabase dbase;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        db.execSQL(QUESTIONS_DATABASE_CREATE);
        db.execSQL(USERS_ACT_DATABASE_CREATE);
        addQuestions();
        //db.close();
    }

    private void addQuestions()
    {
        Question q1=new Question("Test Question 1", "a", "Level01");
        this.addQuestion(q1);

        Question q2=new Question("Test Question 2", "b", "Level01");
        this.addQuestion(q2);

        Question q3=new Question("Test Question 3", "c", "Level02");
        this.addQuestion(q3);

        Question q4=new Question("Test Question 4", "a", "Level03");
        this.addQuestion(q4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS_ACT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question q){
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION_TEXT, q.getQuestion_text());
        values.put(COLUMN_RIGHT_ANSWER, q.getRight_answer());
        values.put(COLUMN_LEVEL_ID, q.getLevel_id());
        dbase.insert(TABLE_QUESTIONS, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> qList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTIONS;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Question q = new Question();
                q.setId(cursor.getInt(0));
                q.setQuestion_text(cursor.getString(1));
                q.setRight_answer(cursor.getString(2));
                q.setLevel_id(cursor.getString(3));
                qList.add(q);
            } while (cursor.moveToNext());
        }
        return qList;
    }

    public int rowcount(){
        int row=0;
        String selectQuery="SELECT * FROM "+TABLE_QUESTIONS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}

