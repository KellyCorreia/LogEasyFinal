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

    public static final String TABLE_SCOREBOARD_SCREEN="table_scoreboard_screen";
    public static final String COLUMN_USERNAME_SCOREBOARD="user_name";
    public static final String COLUMN_LEVELNAME_SCOREBOARD="level_name";
    public static final String COLUMN_POINTS_SCOREBOARD="user_points";
    public static final String COLUMN_WRONGPERC_SCOREBOARD="user_wrongperc";


    private static final String DATABASE_NAME = "database.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement

    private static final String SCOREBOARD_SCREEN_DATABASE_CREATE = "create table "
            + TABLE_SCOREBOARD_SCREEN + "(" + COLUMN_USERNAME_SCOREBOARD
            + " text primary key, " + COLUMN_LEVELNAME_SCOREBOARD
            + " text, "+ COLUMN_POINTS_SCOREBOARD
            + " text, "+ COLUMN_WRONGPERC_SCOREBOARD
            + " text);";

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
            + " text, "+ COLUMN_DATE
            + " text);";


    private static final String ANSWERS_DATABASE_CREATE="CREATE TABLE "
            + TABLE_ANSWERS + "(" + COLUMN_ANSWER_ID
            + " text primary key, " + COLUMN_ANSWER_TEXT
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
        db.execSQL(SCOREBOARD_SCREEN_DATABASE_CREATE);
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

        LevelClass l1 = new LevelClass("L01", "Level 1 - Wind","Hello! This is " +
                "the first level of your power conquest. On this level you are going to " +
                        "learn the concept of propositional logic and contradictory propositions. " +
                        "In the end of this level you will have the wind power which is the first " +
                        "step to get the air power, but to finish the level one you have to prove " +
                        "your knowledge about wind by answering 5 questions. " + "\n" +
                        "So, lets get started with the concepts:" + "\n" +
                        "Propositional logics is also called “sentential logic” or “statement logic” " +
                        "and it deals with logical relationship between propositions (also called: " +
                        "claims, statement, sentences, assertions, ..) taken as wholes. A proposition " +
                        "is a declarative sentence which has a True/False value and it is composed by a " +
                        "subject term and a predicate term, for example:" + "\n" +
                        "“The wind is cold”." + "\n" + "The wind= subject term" + "\n" + "“is cold” = " +
                        "the predicate" + "\n" + "We symbolize the proposition using a single letter: " +
                        "\n" + "j: “ Jill is wearing a red dress”." + "\n" + "\n" + "Contradictories, " +
                        "operator \"not\":" + "The Contradictory of A is a claim that always has the " +
                        "opposite truth value of A. In the case of a simple proposition just use a " +
                        "negative word or expression (\"no\", \"not\", \"It is not true\", \"It is false\"...)" +
                        " before the sentence, and you have the contradictory. The “not” operator can also be " +
                        "represented by “¬”. For example:" + "\n" + "a: “The wind is blowing”" + "\n" +
                        "¬a: “The wind is not blowing”" + "\n" + "Notice that ‘¬a’ is the contradictory claim " +
                        "of ‘a’ and vice-versa. " + "\n", "Tip1");
        this.addLevel(l1);

        LevelClass l2 = new LevelClass("L02", "Level 2 - Sound", "Hello! This is the last level of " +
                "your air power conquest. On this level you are going to learn the conjunctions. In " +
                "the end of this level you will have the air power, but to finish the level 2 you have" +
                " to prove your knowledge about sound as well as you proved about wind by answering 5" +
                " questions right." + "\n" + "So, lets get started with the concepts:\n" + "The " +
                "conjunctions use operators such as “and” or “but” to connect two simple propositions," +
                " for example:" + "\n" + "“The wind is blowing hard and it is raining”." +  "\n" +
                "To evaluate this proposition as true both propositions must be true, if one is false" +
                " then the whole statement is false. The “and” operator can be also represented by “^”.\n", "Tip2");
        this.addLevel(l2);

        LevelClass l3 = new LevelClass("L03", "Level 3 Name", "In order to master the Earth power " +
                "you have to pass two levels (Metal and Sand). This is the first one that you have" +
                " to pass, Metal. On this level you are going to learn the disjunctions and to " +
                "complete the level 3 you have to prove your knowledge about metal by answering 5 " +
                "questions right." + "\n" + "So, lets get started with the concepts:\n" + "The " +
                "disjunctions use the “or” operator connects two simple propositions, for example:"+ "\n" +
                "“Iron is a kind of metal or it is a kind of stone”. " + "\n" + "We have two kinds of " +
                "disjunctions: Inclusive “or” and Exclusive “or”." + "\n" + "In the inclusive “or” the " +
                "propositions are evaluated as true when any one of claims is true. The whole " +
                "sentence will be false only if both propositions are false." + "\n" + "In the exclusive " +
                "“or” the propositions are evaluated as true when only one of the claims is true. " +
                "The whole statement is false when both claims have the same value, both false or " +
                "both true." + "\n" + "The “or” operator can be also represented by “v”.\n", "Tip 3");
        this.addLevel(l3);

        LevelClass l4 = new LevelClass("L04", "Level 4 Name", "Lesson 4", "Tip 4");
        this.addLevel(l4);
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

        AnswerClass a10 = new AnswerClass("A004a", "Answer A", "Q004");
        this.addAnswer(a10);

        AnswerClass a11 = new AnswerClass("A004b", "Answer B", "Q004");
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

    public void addUserActivities(Long userID){
        UserActivityClass userActivity;
        userActivity = new UserActivityClass(userID,"Q001","A001a");
        this.addUserActivity(userActivity);
        userActivity = new UserActivityClass(userID,"Q002","A002a");
        this.addUserActivity(userActivity);
        userActivity = new UserActivityClass(userID,"Q003","A003a");
        this.addUserActivity(userActivity);
        userActivity = new UserActivityClass(userID,"Q004","A004a");
        this.addUserActivity(userActivity);
        userActivity = new UserActivityClass(userID,"Q005","A005a");
        this.addUserActivity(userActivity);

    }


    public boolean addUserActivity(UserActivityClass userActivity){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, userActivity.getUser_id());
        values.put(COLUMN_QUESTION_ID, userActivity.getQuestion_id());
        values.put(COLUMN_ANSWER_ID, userActivity.getAnswer_id());
        values.put(COLUMN_DATE, userActivity.getDate());
        database.insert(TABLE_USERS_ACT, null, values);
        return true;
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

        long iduser = database.insert(TABLE_USERS, null, values);

        ScoreboardClass score = new ScoreboardClass((int)iduser, 00, 00, "L01");
        this.addScore(score);

        return true;
    }

    public boolean addScore(ScoreboardClass score){

        ContentValues values;
        values = new ContentValues();
        values.put(COLUMN_USER_ID, score.getUser_id());
        values.put(COLUMN_POINTS, score.getPoints());
        values.put(COLUMN_WRONG_PERCENT, score.getWrong_percent());
        values.put(COLUMN_LEVEL_ID, score.getLevel_id());
        database.insert(TABLE_SCOREBOARD, null, values);

        return true;
    }

    public boolean addScoreboardScreen(ScoreboardScreen scoreboard){

        ContentValues values;
        values = new ContentValues();
        values.put(COLUMN_USERNAME_SCOREBOARD, scoreboard.getUserName());
        values.put(COLUMN_LEVELNAME_SCOREBOARD, scoreboard.getLevelName());
        values.put(COLUMN_POINTS_SCOREBOARD, scoreboard.getPoints());
        values.put(COLUMN_WRONGPERC_SCOREBOARD, scoreboard.getWrongPerc());
        database.insert(TABLE_SCOREBOARD_SCREEN, null, values);

        return true;
    }

    public ArrayList<ScoreboardScreen> getScoreboardTable(){
        ArrayList<ScoreboardScreen> scoreList = new ArrayList<ScoreboardScreen>();
        String selectQuery = "SELECT * FROM " + TABLE_SCOREBOARD_SCREEN + " ORDER BY " + COLUMN_POINTS_SCOREBOARD + " DESC, " + COLUMN_WRONGPERC_SCOREBOARD + " ASC ;";
        database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ScoreboardScreen scoreboard = new ScoreboardScreen();
                scoreboard.setUserName(cursor.getString(0));
                scoreboard.setLevelName(cursor.getString(1));
                scoreboard.setPoints(Integer.parseInt(cursor.getString(2)));
                scoreboard.setWrongPerc(Double.parseDouble(cursor.getString(3)));
                scoreList.add(scoreboard);
            } while (cursor.moveToNext());
        }
        return scoreList;
    }

    public boolean deleteScoreboardTable(){
        //String deleteQuery = "DELETE FROM " + TABLE_SCOREBOARD_SCREEN + ";";
        //database = this.getReadableDatabase();
        database.delete(TABLE_SCOREBOARD_SCREEN, null, null);

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
///inicio
    public String getUserLevel(Long userID){
        String selectQuery = "SELECT "+COLUMN_LEVEL_NAME+" FROM "+TABLE_LEVEL+" WHERE "+COLUMN_LEVEL_ID+" IN ( SELECT "+COLUMN_LEVEL_ID+" FROM "+TABLE_SCOREBOARD+" WHERE "+COLUMN_USER_ID+" = '"+ userID.toString()+"' );";
        database=this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        String levelName = "vazio";
        if (cursor.moveToFirst()) {
            levelName = cursor.getString(0);
        }
        return levelName;
    }

    public boolean lessonStart(String chosenLevelID, Long userID){
        //SELECT u._id FROM users_activity AS u INNER JOIN table_questions AS q ON u.Q_id = q.Q_id INNER JOIN table_level AS l ON q.L_id = l.L_id WHERE u.user_id = 1 AND l.L_id = 'L01';

        String selectQuery = "SELECT u."+COLUMN_ID+" FROM "+TABLE_USERS_ACT
                +" AS u INNER JOIN "+TABLE_QUESTIONS+" AS q ON u."
                +COLUMN_QUESTION_ID+" = q."+COLUMN_QUESTION_ID
                +" INNER JOIN "+TABLE_LEVEL+" AS l ON q."
                +COLUMN_LEVEL_ID+" = l."+COLUMN_LEVEL_ID
                +" WHERE u."+COLUMN_USER_ID+" = "+userID.toString()+" AND l."+COLUMN_LEVEL_ID+" = '"+chosenLevelID+"' ;";
        database=this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if(cursor.getCount()>0){
            return true;
        }
        return false;
    }
///fim
    public int rowcount(){
        int row=0;
        String selectQuery="SELECT * FROM " + TABLE_QUESTIONS + ";";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }

    public LevelClass getLevel(String levelID){
        LevelClass levelobj = new LevelClass();
        Cursor cursor;
        String selectQuery = "SELECT * FROM " + TABLE_LEVEL + " WHERE " + COLUMN_LEVEL_ID + " = '" + (String)levelID + "' ; " ;
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            levelobj.setLevel_id(cursor.getString(0));
            levelobj.setLevelname(cursor.getString(1));
            levelobj.setLesson(cursor.getString(2));
            levelobj.setTip(cursor.getString(3));
        }
        return levelobj;
    }

    public ScoreboardClass getScore(long UserID){
        ScoreboardClass scoreobj = new ScoreboardClass();
        Cursor cursor;
        String UserString = Integer.toString((int)UserID);
        String selectQuery = "SELECT * FROM " + TABLE_SCOREBOARD + " WHERE " + COLUMN_USER_ID + " = '" + UserString + "' ;";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            scoreobj.setUser_id(cursor.getInt(0));
            scoreobj.setPoints(cursor.getInt(1));
            scoreobj.setWrong_percent(cursor.getInt(2));
            scoreobj.setLevel_id(cursor.getString(3));
        }
        return scoreobj;
    }

    public List<AnswerClass> getAnswer(String qid){
        List<AnswerClass> Answerlist = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_ANSWERS + " WHERE " + COLUMN_QUESTION_ID + " = '" + qid + "' ;";
        database=this.getReadableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                AnswerClass answers = new AnswerClass();
                answers.setAnswer_id(cursor.getString(0));
                answers.setAnswer_text(cursor.getString(1));
                answers.setQuestion_id(cursor.getString(2));
                Answerlist.add(answers);
            } while (cursor.moveToNext());
        }
        return Answerlist;
    }

    public List<QuestionClass> levelQuestion(String levelId) {
        List<QuestionClass> questionsList = new ArrayList<>();
        Cursor cursor;
        String selectQuery = "SELECT * FROM " + TABLE_QUESTIONS + " WHERE " + COLUMN_LEVEL_ID + " = '" + levelId + "' ;";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                QuestionClass levelQuestion = new QuestionClass();
                levelQuestion.setQuestion_id(cursor.getString(0));
                levelQuestion.setQuestion_text(cursor.getString(1));
                levelQuestion.setLevel_id(cursor.getString(2));
                levelQuestion.setRight_answer(cursor.getString(3));
                questionsList.add(levelQuestion);
            } while (cursor.moveToNext());
        }

        return questionsList;
    }


    public boolean updatingScore(Integer score, UserClass User, String levelID){
        Cursor cursor;
        String UserString = Integer.toString((int)User.getUser_id());
        String selectQuery = "SELECT * FROM " + TABLE_SCOREBOARD + " WHERE " + COLUMN_USER_ID + " = '" + UserString + "' ";
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        ContentValues values;
        values = new ContentValues();
        if(cursor.moveToFirst()){
            values.put(COLUMN_USER_ID, cursor.getInt(0));
            values.put(COLUMN_POINTS, score);
            values.put(COLUMN_WRONG_PERCENT, cursor.getInt(2));
            values.put(COLUMN_LEVEL_ID, levelID);
        }

        database = this.getWritableDatabase();
        database.update(TABLE_SCOREBOARD,values, COLUMN_USER_ID + "= ?", new String[]{UserString});
        return true;
    }

}

