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
    }

    private void addQuestions()
    {
        QuestionClass q1=new QuestionClass("Q001", "Which one is the contradictory of the " +
                "following claim: \n “Sometimes the wind is blowing hard.”", "L01", "A001c");
        this.addQuestion(q1);

        QuestionClass q2=new QuestionClass("Q002", "Which one is the contradictory of the " +
                "following statement: \n “The wind is blowing all the time.”", "L01", "A002b");
        this.addQuestion(q2);

        QuestionClass q3=new QuestionClass("Q003", "Which one of the following sentences becomes " +
                "true after applying the NOT operator.", "L01", "A003c");
        this.addQuestion(q3);

        QuestionClass q4=new QuestionClass("Q004", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.", "L01", "A004b");
        this.addQuestion(q4);

        QuestionClass q5=new QuestionClass("Q005", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.", "L01", "A005b");
        this.addQuestion(q5);

        QuestionClass q6=new QuestionClass("Q006", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.", "L01", "A006a");
        this.addQuestion(q6);

        QuestionClass q7=new QuestionClass("Q007", "Which one of the following affirmation becomes " +
                "true after applying the NOT operator.", "L01", "A007a");
        this.addQuestion(q7);

        QuestionClass q8=new QuestionClass("Q008", "Which one is the contradictory of the following" +
                " statement: \n “The wind has no direction.”", "L01", "A008a");
        this.addQuestion(q8);

        QuestionClass q9=new QuestionClass("Q009", "Which one is the contradictory of the following" +
                " claim: \n “The wind’s direction is North.”", "L01", "A009b");
        this.addQuestion(q9);

        QuestionClass q10=new QuestionClass("Q010", "Which one is the contradictory of the following" +
                " sentence: \n “Some breeze is a light wind.”", "L01", "A010a");
        this.addQuestion(q10);

        QuestionClass q11=new QuestionClass("Q011", "Given: a = “The sound is a vibration” is  " +
                "true and b = “The sound is not a wave” is false. Which of the following is true:", "L02", "A011c");
        this.addQuestion(q11);

        QuestionClass q12=new QuestionClass("Q012", "Given: a = “The sound propagates through the air”" +
                " is true. Which of the following is false:", "L02", "A012b");
        this.addQuestion(q12);

        QuestionClass q13=new QuestionClass("Q013", "Given: a = “The sound propagates through solids”" +
                " is true and b = “The sound is not a vibration” is false. Which of the following is true:", "L02", "A013b");
        this.addQuestion(q13);

        QuestionClass q14=new QuestionClass("Q014", "Given: “The speed of the sound is 972m/s” is " +
                "true and “Sound propagates through the air”. Considering the exclusive “or”. Which " +
                "of the following is true:", "L02", "A014c");
        this.addQuestion(q14);

        QuestionClass q15=new QuestionClass("Q012", "Given: a = “All sound come from a vibrating " +
                "source” is true and b = “Sound can be heard” is true. Which os the following is true:", "L02", "A015a");
        this.addQuestion(q15);

        QuestionClass q16=new QuestionClass("Q012", "Given: a = “Sound cannot be heard” is false " +
                "and b = “Sound is a current of air” is false. Which os the following is false:", "L02", "A016c");
        this.addQuestion(q16);

        QuestionClass q17=new QuestionClass("Q012", "Given: a = “Music is a combination of sounds”" +
                " is true. Which os the following is false:", "L02", "A017b");
        this.addQuestion(q17);

        QuestionClass q18=new QuestionClass("Q012", "Given: a = “Music is a combination of sounds”" +
                " is true,  b = “Sound is a current of air” is false and c = “All sound come from a" +
                " vibrating source” is true. Which one of the following is true:", "L02", "A018b");
        this.addQuestion(q18);

        QuestionClass q19=new QuestionClass("Q012", "Given: a = “Sound cannot be heard” is false" +
                " and b = “All sound come from a vibrating source” is true. Which of the following " +
                "is true:", "L02", "A019c");
        this.addQuestion(q19);

        QuestionClass q20=new QuestionClass("Q012", "Given: a = “Music is a combination of sound " +
                "and silence” is true, b = “A very strong sound forms a tornado” is false and c = " +
                "“Sound is not a wave” is false. Which of the following is true:", "L02", "A020a");
        this.addQuestion(q20);

    }

    private void addLevels(){

        LevelClass l1 = new LevelClass("L01", "Level 1 - Wind","<p><b>Hello!</b> This is " +
                "the first level of your power conquest. On this level you are going to " +
                        "learn the concept of <b>propositional logic</b> and <b>contradictory propositions.</b> " +
                        "In the end of this level you will have the <b>wind power</b> which is the first " +
                        "step to get the <b>air power</b>, but to finish the level one you have to prove " +
                        "your knowledge about wind by answering 5 questions. " + "</p>" +
                        "<p>So, lets get started with the concepts:" + "</p>" +
                        "<p><b>Propositional logics</b> is also called <b>“sentential logic”</b> or <b>“statement logic”</b> " +
                        "and it deals with logical relationship between propositions (also called: " +
                        "<b>claims</b>, <b>statement</b>, <b>sentences</b>, <b>assertions</b>, ..) taken as wholes. A proposition " +
                        "is a declarative sentence which has a <b>True/False</b> value and it is composed by a " +
                        "subject term and a predicate term, for example:" + "</p>" +
                        "<p>“The wind is cold”." + "</p>" + "<p>The wind= subject term" + "</p>" + "<p>“is cold” = " +
                        "the predicate" + "</p>" + "<p>We symbolize the proposition using a single letter: " +
                        "</p>" + "<p><b>j</b>: “ Jill is wearing a red dress”." + "</p>" + "<br />" + "<p><b>Contradictories,</b> " +
                        "operator \"<b>not</b>\":" + "</p>" + "<p>The Contradictory of A is a claim that always has the " +
                        "opposite truth value of A. In the case of a simple proposition just use a " +
                        "negative word or expression (<b>\"no\"</b>, <b>\"not\"</b>, <b>\"It is not true\"</b>, <b>\"It is false\"</b>...)" +
                        " before the sentence, and you have the contradictory. The <b>“not”</b> operator can also be " +
                        "represented by <b>“¬”</b>. For example:" + "</p>" + "<p><b>a</b>: “The wind is blowing”" + "</p>" +
                        "<p><b>¬a</b>: “The wind is not blowing”" + "</p>" + "<p>Notice that <b>‘¬a’</b> is the contradictory claim " +
                        "of <b>‘a’</b> and vice-versa. " + "</p>", "Tip1");
        this.addLevel(l1);

        LevelClass l2 = new LevelClass("L02", "Level 2 - Sound", "<p><b>Hello!</b> This is the last level of " +
                "your air power conquest. On this level you are going to learn the <b>conjunctions</b>. In " +
                "the end of this level you will have the <b>air power</b>, but to finish the level 2 you have" +
                " to prove your knowledge about <b>sound</b> as well as you proved about wind by answering 5" +
                " questions right." + "</p>" + "<p>So, lets get started with the concepts:</p>" + "<p>The " +
                "<b>conjunctions</b> use operators such as <b>“and”</b> or <b>“but”</b> to connect two simple propositions," +
                " for example:" + "</p>" + "<p>“The wind is blowing hard and it is raining”." +  "</p>" +
                "<p>To evaluate this proposition as true <b>both</b> propositions must be <b>true</b>, if one is false" +
                " then the whole statement is false. The <b>“and”</b> operator can be also represented by <b>“^”</b>.</p>", "Tip2");
        this.addLevel(l2);

        LevelClass l3 = new LevelClass("L03", "Level 3 Name", "<p>In order to master the <b>Earth power</b> " +
                "you have to pass two levels (<b>Metal</b> and <b>Sand</b>). This is the first one that you have" +
                " to pass, <b>Metal</b>. On this level you are going to learn the <b>disjunctions</b> and to " +
                "complete the level 3 you have to prove your knowledge about metal by answering 5 " +
                "questions right." + "</p>" + "<p>So, lets get started with the concepts: </p>" + "<p>The " +
                "<b>disjunctions</b> use the <b>“or”</b> operator to connect two simple propositions, for example:"+ "</p>" +
                "<p>“Iron is a kind of metal or it is a kind of stone”. " + "</p>" + "<p>We have two kinds of " +
                "disjunctions: <b>Inclusive “or”</b> and <b>Exclusive “or”</b>." + "</p>" + "<p>In the <b>inclusive “or”</b> the " +
                "propositions are evaluated as true when <b>any one</b> of claims is <b>true</b>. The whole " +
                "sentence will be false only if both propositions are false." + "</p>" + "<p>In the <b>exclusive " +
                "“or”</b> the propositions are evaluated as true when <b>only one</b> of the claims is <b>true</b>. " +
                "The whole statement is false when both claims have the same value, both false or " +
                "both true." + "</p>" + "<p>The <b>“or”</b> operator can be also represented by <b>“v”</b>.</p>", "Tip 3");
        this.addLevel(l3);

        LevelClass l4 = new LevelClass("L04", "Level 4 Name", "Lesson 4", "Tip 4");
        this.addLevel(l4);
    }

    private void addAnswers() {
        AnswerClass a1 = new AnswerClass("A001a", "The wind is not blowing hard.", "Q001");
        this.addAnswer(a1);

        AnswerClass a2 = new AnswerClass("A001b", "Sometimes the wind is not blowing hard.", "Q001");
        this.addAnswer(a2);

        AnswerClass a3 = new AnswerClass("A001c", "The wind is never blowing hard.", "Q001");
        this.addAnswer(a3);

        AnswerClass a4 = new AnswerClass("A002a", "The wind is not blowing.", "Q002");
        this.addAnswer(a4);

        AnswerClass a5 = new AnswerClass("A002b", "Sometimes the wind is not blowing.", "Q002");
        this.addAnswer(a5);

        AnswerClass a6 = new AnswerClass("A002c", "The wind is never blowing.", "Q002");
        this.addAnswer(a6);

        AnswerClass a7 = new AnswerClass("A003a", "The wind can change directions.", "Q003");
        this.addAnswer(a7);

        AnswerClass a8 = new AnswerClass("A003b", "The wind is blowing in the same direction.", "Q003");
        this.addAnswer(a8);

        AnswerClass a9 = new AnswerClass("A003c", "The wind can never change directions.", "Q003");
        this.addAnswer(a9);

        AnswerClass a10 = new AnswerClass("A004a", "The wind has the power to destroy houses", "Q004");
        this.addAnswer(a10);

        AnswerClass a11 = new AnswerClass("A004b", "The wind can sometimes destroy houses.", "Q004");
        this.addAnswer(a11);

        AnswerClass a12 = new AnswerClass("A004c", "The wind can destroy houses.", "Q004");
        this.addAnswer(a12);

        AnswerClass a13 = new AnswerClass("A005a", "The wind can blow hard.", "Q005");
        this.addAnswer(a13);

        AnswerClass a14 = new AnswerClass("A005b", "The wind blows hard all the time.", "Q005");
        this.addAnswer(a14);

        AnswerClass a15 = new AnswerClass("A005c", "The wind is not blowing hard.", "Q005");
        this.addAnswer(a15);

        AnswerClass a16 = new AnswerClass("A006a", "The houses may be destroyed by the wind.", "Q006");
        this.addAnswer(a16);

        AnswerClass a17 = new AnswerClass("A006b", "Some houses may be destroyed by the wind.", "Q006");
        this.addAnswer(a17);

        AnswerClass a18 = new AnswerClass("A006c", "Not all the houses can be destroyed by the wind.", "Q006");
        this.addAnswer(a18);

        AnswerClass a19 = new AnswerClass("A007a", "The wind’s direction never changes.", "Q007");
        this.addAnswer(a19);

        AnswerClass a20 = new AnswerClass("A007b", "The wind’s direction can change.", "Q007");
        this.addAnswer(a20);

        AnswerClass a21 = new AnswerClass("A007c", "The wind’s direction can change sometimes.", "Q007");
        this.addAnswer(a21);

        AnswerClass a22 = new AnswerClass("A008a", "The wind sometimes has a direction.", "Q008");
        this.addAnswer(a22);

        AnswerClass a23 = new AnswerClass("A008b", "The wind doesn’t have a direction.", "Q008");
        this.addAnswer(a23);

        AnswerClass a24 = new AnswerClass("A008c", "The wind’s direction exists.", "Q008");
        this.addAnswer(a24);

        AnswerClass a25 = new AnswerClass("A009a", "The wind’s direction is South.", "Q009");
        this.addAnswer(a25);

        AnswerClass a26 = new AnswerClass("A009b", "Sometimes the wind’s direction is not North.", "Q009");
        this.addAnswer(a26);

        AnswerClass a27 = new AnswerClass("A009c", "The wind’s direction is different.", "Q009");
        this.addAnswer(a27);

        AnswerClass a28 = new AnswerClass("A010a", "No breeze is a light wind.", "Q010");
        this.addAnswer(a28);

        AnswerClass a29 = new AnswerClass("A010b", "A breeze is sometimes a light wind.", "Q010");
        this.addAnswer(a29);

        AnswerClass a30 = new AnswerClass("A010c", "All breezes are light.", "Q010");
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

    public boolean addUserActivity(UserActivityClass userActivity){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_ID, userActivity.getUser_id());
        values.put(COLUMN_QUESTION_ID, userActivity.getQuestion_id());
        values.put(COLUMN_ANSWER_ID, userActivity.getAnswer_id());
        values.put(COLUMN_DATE, userActivity.getDate());
        database.insert(TABLE_USERS_ACT, null, values);
        return true;
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
    public long getUserID(UserClass user){
        long userID = 0;

        Cursor cursor;
        String selectQuery = "SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_EMAIL + " = '" + user.getEmail() + "' ; " ;
        database = this.getReadableDatabase();
        cursor = database.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            userID = cursor.getLong(0);
        }
        return userID;
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

