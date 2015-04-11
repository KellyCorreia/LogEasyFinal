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

    public static final String TABLE_QUESTIONS = "table_questions";
    public static final String COLUMN_QUESTION_ID = "Q_id";
    public static final String COLUMN_QUESTION_TEXT = "Q_text";
    public static final String COLUMN_RIGHT_ANSWER = "right_A";
    public static final String COLUMN_LEVEL_ID = "L_id";


    public static final String TABLE_USERS_ACT = "users_activity";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USER_ID = "user_id";
    // + Q_id
    public static final String COLUMN_WRONG_YN = "wrong_YN";
    public static final String COLUMN_DATE = "date";


    public static final String TABLE_ANSWERS = "table_answers";
    public static final String COLUMN_ANSWER_ID= "A_id";
    // + Q_id
    public static final String COLUMN_ANSWER_TEXT="A_text";

    public static final String TABLE_USERS="table_users";
    //user_id;
    public static final String COLUMN_USERNAME="username";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_PASS="password";
    public static final String COLUMN_POINTS="points";
    public static final String COLUMN_WRONG_PERCENT="wrong_percent";


    public static final String COLUMN_AVATAR="avatar";
    public static final String TABLE_SCOREBOARD="table_scoreboard";

    public static final String TABLE_LEVEL="table_level";
    public static final String COLUMN_LEVEL_NAME="l_name";
    public static final String COLUMN_LESSON="lesson";
    public static final String COLUMN_TIP="tip";


    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String QUESTIONS_DATABASE_CREATE = "create table "
            + TABLE_QUESTIONS + "(" + COLUMN_QUESTION_ID
            + " text primary key, " + COLUMN_QUESTION_TEXT
            + " text not null, "+ COLUMN_LEVEL_ID
            + " text not null, "+ COLUMN_RIGHT_ANSWER
            + " text not null);";

    private static final String USERS_ACT_DATABASE_CREATE ="CREATE TABLE "
            + TABLE_USERS_ACT + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_USER_ID
            + " integer not null, "+ COLUMN_QUESTION_ID
            + " text, "+ COLUMN_ANSWER_ID
            + " text, "+ COLUMN_WRONG_YN
            + " text, "+ COLUMN_DATE
            + " text);";


    private static final String ANSWERS_DATABASE_CREATE="CREATE TABLE "
            + TABLE_ANSWERS + "(" + COLUMN_ANSWER_ID
            + " integer primary key, " + COLUMN_ANSWER_TEXT
            + " text not null, "+ COLUMN_QUESTION_ID
            + " text not null);";


    private static final String USERS_DATABASE_CREATE="CREATE TABLE "
            + TABLE_USERS +"(" + COLUMN_USER_ID
            + " integer primary key autoincrement, "+ COLUMN_USERNAME
            + " text not null, "+ COLUMN_EMAIL
            + " text not null, "+ COLUMN_PASS
            + " text not null, "+ COLUMN_AVATAR
            + " text);";


    private static final String SCOREBOARD_DATABASE_CREATE="CREATE TABLE "
            + TABLE_SCOREBOARD +"("+ COLUMN_USER_ID
            +" integer primary key, "+ COLUMN_POINTS
            +" integer, "+ COLUMN_WRONG_PERCENT
            +" integer, "+ COLUMN_LEVEL_ID
            +" text);";

    private static final String LEVEL_DATABASE_CREATE="CREATE TABLE "
            + TABLE_LEVEL +"("+ COLUMN_LEVEL_ID
            +" text primary key, "+ COLUMN_LEVEL_NAME
            +" text not null, "+ COLUMN_LESSON
            +" text,"+ COLUMN_TIP
            +" text);";


    //OR:     private SQLiteDatabase dbase;
    public SQLiteDatabase database=this.getWritableDatabase();


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        database=db;
        db.execSQL(QUESTIONS_DATABASE_CREATE);
        db.execSQL(USERS_ACT_DATABASE_CREATE);
        db.execSQL(USERS_DATABASE_CREATE);
        db.execSQL(ANSWERS_DATABASE_CREATE);
        db.execSQL(SCOREBOARD_DATABASE_CREATE);
        db.execSQL(LEVEL_DATABASE_CREATE);
        addQuestions();
        addAnswers();
        addLevels();
        addUsers();
        //db.close();
    }

    private void addQuestions()
    {
        QuestionClass q1=new QuestionClass("Q001", "Test Question 1", "L01", "A001a");
        this.addQuestion(q1);

        QuestionClass q2=new QuestionClass("Q002", "Test Question 2", "L01", "A002a");
        this.addQuestion(q2);

        QuestionClass q3=new QuestionClass("Q003", "Test Question 3", "L01", "A003a");
        this.addQuestion(q3);

        QuestionClass q4=new QuestionClass("Q004", "Test Question 4", "L01", "A004a");
        this.addQuestion(q4);

        QuestionClass q5=new QuestionClass("Q005", "Test Question 5", "L01", "A005a");
        this.addQuestion(q5);

        QuestionClass q6=new QuestionClass("Q006", "Test Question 6", "L02", "A006a");
        this.addQuestion(q6);

        QuestionClass q7=new QuestionClass("Q007", "Test Question 7", "L02", "A007a");
        this.addQuestion(q7);

        QuestionClass q8=new QuestionClass("Q008", "Test Question 8", "L02", "A008a");
        this.addQuestion(q8);

        QuestionClass q9=new QuestionClass("Q009", "Test Question 9", "L02", "A009a");
        this.addQuestion(q9);

        QuestionClass q10=new QuestionClass("Q010", "Test Question 10", "L02", "A010a");
        this.addQuestion(q10);

        QuestionClass q11=new QuestionClass("Q011", "Test Question 11", "L02", "A011a");
        this.addQuestion(q11);

        QuestionClass q12=new QuestionClass("Q012", "Test Question 12", "L03", "A012a");
        this.addQuestion(q12);
    }

    private void addLevels(){
        LevelClass l1 = new LevelClass("L01", "Level 1 Name", "Lesson 1", "Tip 1");
        this.addLevel(l1);

        LevelClass l2 = new LevelClass("L02", "Level 2 Name", "Lesson 2", "Tip 2");
        this.addLevel(l2);

        LevelClass l3 = new LevelClass("L03", "Level 3 Name", "Lesson 3", "Tip 3");
        this.addLevel(l3);
    }

    private void addAnswers() {
        AnswerClass a1 = new AnswerClass("A001a", "Answer A", "Q001");
        this.addAnswer(a1);

        AnswerClass a2 = new AnswerClass("A001b", "Answer B", "Q001");
        this.addAnswer(a2);

        AnswerClass a3 = new AnswerClass("A001c", "Answer C", "Q001");
        this.addAnswer(a3);

        AnswerClass a4 = new AnswerClass("A002a", "Answer A", "Q002");
        this.addAnswer(a4);

        AnswerClass a5 = new AnswerClass("A002b", "Answer B", "Q002");
        this.addAnswer(a5);

        AnswerClass a6 = new AnswerClass("A002c", "Answer C", "Q002");
        this.addAnswer(a6);

        AnswerClass a7 = new AnswerClass("A003a", "Answer A", "Q003");
        this.addAnswer(a7);

        AnswerClass a8 = new AnswerClass("A003b", "Answer B", "Q003");
        this.addAnswer(a8);

        AnswerClass a9 = new AnswerClass("A003c", "Answer C", "Q003");
        this.addAnswer(a9);

        AnswerClass a10 = new AnswerClass("A004a", "Answer A", "Q003");
        this.addAnswer(a10);

        AnswerClass a11 = new AnswerClass("A004b", "Answer B", "Q003");
        this.addAnswer(a11);

        AnswerClass a12 = new AnswerClass("A004c", "Answer C", "Q004");
        this.addAnswer(a12);

        AnswerClass a13 = new AnswerClass("A005a", "Answer A", "Q005");
        this.addAnswer(a13);

        AnswerClass a14 = new AnswerClass("A005b", "Answer B", "Q005");
        this.addAnswer(a14);

        AnswerClass a15 = new AnswerClass("A005c", "Answer C", "Q005");
        this.addAnswer(a15);

        AnswerClass a16 = new AnswerClass("A006a", "Answer A", "Q006");
        this.addAnswer(a16);

        AnswerClass a17 = new AnswerClass("A006b", "Answer B", "Q006");
        this.addAnswer(a17);

        AnswerClass a18 = new AnswerClass("A006c", "Answer C", "Q006");
        this.addAnswer(a18);

        AnswerClass a19 = new AnswerClass("A007a", "Answer A", "Q007");
        this.addAnswer(a19);

        AnswerClass a20 = new AnswerClass("A007b", "Answer B", "Q007");
        this.addAnswer(a20);

        AnswerClass a21 = new AnswerClass("A007c", "Answer C", "Q007");
        this.addAnswer(a21);

        AnswerClass a22 = new AnswerClass("A008a", "Answer A", "Q008");
        this.addAnswer(a22);

        AnswerClass a23 = new AnswerClass("A008b", "Answer B", "Q008");
        this.addAnswer(a23);

        AnswerClass a24 = new AnswerClass("A008c", "Answer C", "Q008");
        this.addAnswer(a24);

        AnswerClass a25 = new AnswerClass("A009a", "Answer A", "Q009");
        this.addAnswer(a25);

        AnswerClass a26 = new AnswerClass("A009b", "Answer B", "Q009");
        this.addAnswer(a26);

        AnswerClass a27 = new AnswerClass("A009c", "Answer C", "Q009");
        this.addAnswer(a27);

        AnswerClass a28 = new AnswerClass("A010a", "Answer A", "Q010");
        this.addAnswer(a28);

        AnswerClass a29 = new AnswerClass("A010b", "Answer B", "Q010");
        this.addAnswer(a29);

        AnswerClass a30 = new AnswerClass("A010c", "Answer C", "Q010");
        this.addAnswer(a30);

        AnswerClass a31 = new AnswerClass("A011a", "Answer A", "Q011");
        this.addAnswer(a31);

        AnswerClass a32 = new AnswerClass("A011b", "Answer B", "Q011");
        this.addAnswer(a32);

        AnswerClass a33 = new AnswerClass("A011c", "Answer C", "Q011");
        this.addAnswer(a33);

        AnswerClass a34 = new AnswerClass("A012a", "Answer A", "Q012");
        this.addAnswer(a34);

        AnswerClass a35 = new AnswerClass("A012b", "Answer B", "Q012");
        this.addAnswer(a35);

        AnswerClass a36 = new AnswerClass("A012c", "Answer C", "Q012");
        this.addAnswer(a36);


    }

    private void addUsers(){
        UserClass user;
        user = new UserClass("user1","user1@gmail.com","111","Avatar2");
        this.addUser(user);
        user = new UserClass("user2","user2@gmail.com","222","Avatar3");
        this.addUser(user);
        user = new UserClass("user3","user3@gmail.com","333","Avatar1");
        this.addUser(user);
        user = new UserClass("user4","user4@gmail.com","444","Avatar4");
        this.addUser(user);
    }

    // Adding new question
    public void addQuestion(QuestionClass q){
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION_ID, q.getQuestion_id());
        values.put(COLUMN_QUESTION_TEXT, q.getQuestion_text());
        values.put(COLUMN_LEVEL_ID, q.getLevel_id());
        values.put(COLUMN_RIGHT_ANSWER, q.getRight_answer());
        database.insert(TABLE_QUESTIONS, null, values);
    }

    // Adding new answer
    public void addAnswer(AnswerClass a){
        ContentValues values = new ContentValues();
        values.put(COLUMN_ANSWER_ID, a.getAnswer_id());
        values.put(COLUMN_ANSWER_TEXT, a.getAnswer_text());
        values.put(COLUMN_QUESTION_ID, a.getQuestion_id());
        database.insert(TABLE_ANSWERS, null, values);
    }

    public void addLevel(LevelClass l){
        ContentValues values = new ContentValues();
        values.put(COLUMN_LEVEL_ID, l.getLevel_id());
        values.put(COLUMN_LEVEL_NAME, l.getLevelname());
        values.put(COLUMN_LESSON, l.getLesson());
        values.put(COLUMN_TIP, l.getTip());
        database.insert(TABLE_LEVEL, null, values);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS_ACT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        onCreate(db);
    }


    public boolean addUser(UserClass user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_EMAIL, user.getEmail());
        values.put(COLUMN_PASS, user.getPass());
        values.put(COLUMN_AVATAR, user.getAvatar());
        database.insert(TABLE_USERS, null, values);
        return true;
    }


    public List<QuestionClass> getAllQuestions() {
        List<QuestionClass> qList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_QUESTIONS + ";";
        database=this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                QuestionClass q = new QuestionClass();
                q.setQuestion_id(cursor.getString(0));
                q.setQuestion_text(cursor.getString(1));
                q.setRight_answer(cursor.getString(2));
                q.setLevel_id(cursor.getString(3));
                qList.add(q);
            } while (cursor.moveToNext());
        }
        return qList;
    }

    public List<UserClass> getAllUsers() {
        List<UserClass> usersList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_USERS + ";";
        database=this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                UserClass user = new UserClass();
                user.setUser_id(Integer.parseInt(cursor.getString(0)));
                user.setUsername(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setPass(cursor.getString(3));
                user.setAvatar(cursor.getString(4));
                usersList.add(user);
            } while (cursor.moveToNext());
        }
        return usersList;
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

