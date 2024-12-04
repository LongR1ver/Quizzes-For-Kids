package com.example.quizzesforkids3;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Quiz.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_USER = "UserInformation";
    public static final String ID_USER = "ID";
    public static final String COL_USERNAME = "Username";
    public static final String COL_PASSWORD = "Password";
    public static final String COL_EMAIL = "Email";
    public static final String COL_TOTAL_SCORE = "TotalScore";

    public static final String TABLE_QUESTION_ANIMALS = "Question";
    public static final String ID_ANIMALS = "AnimalID";
    public static final String COL_IMAGE = "AnimalImage";
    public static final String COL_ANSWER_ANIMALS = "AnswerAnimals";

    public static final String TABLE_QUESTION_CARTOONS = "CARTOONS";
    public static final String ID_CARTOONS = "CartoonID";
    public static final String COL_QUESTION_CARTOONS = "QuestionCartoons";
    public static final String COL_ANSWER_RIGHT = "RightAnswer";
    public static final String COL_ANSWER_WRONG_1 = "Wrong1";
    public static final String COL_ANSWER_WRONG_2 = "Wrong2";

    public static final String TABLE_ATTEMPT = "ATTEMPT";
    public static final String ID_ATTEMPT = "ATTEMPT_ID";
    public static final String COL_USERNAME_ATTEMPT = "USERNAME_ATTEMPT";
    public static final String COL_FIELD = "FIELD";
    public static final String COL_DATE = "DATE";
    public static final String COL_TIME = "TIME";
    public static final String COL_SCORE = "SCORE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION_ANIMALS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION_CARTOONS);
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USER + " (" + ID_USER + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_USERNAME + " TEXT, " + COL_PASSWORD + " TEXT, " + COL_EMAIL + " TEXT, " + COL_TOTAL_SCORE + " INTEGER);");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_QUESTION_ANIMALS + " (" + ID_ANIMALS + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_IMAGE + " INTEGER, " + COL_ANSWER_ANIMALS + " TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_QUESTION_CARTOONS + " (" + ID_CARTOONS + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_QUESTION_CARTOONS + " TEXT, " + COL_ANSWER_RIGHT + " TEXT, " + COL_ANSWER_WRONG_1 + " TEXT, " + COL_ANSWER_WRONG_2 + " TEXT);");
        sqLiteDatabase.execSQL("CREATE TABLE ATTEMPT (ATTEMPT_ID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME_ATTEMPT TEXT, FIELD TEXT, DATE TEXT, TIME TEXT, SCORE INTEGER);");

        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.mouse + ", " + "\"mouse\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.buffalo + ", " + "\"buffalo\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.tiger + ", " + "\"tiger\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.cat + ", " + "\"cat\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.dragon + ", " + "\"dragon\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.snake + ", " + "\"snake\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.horse + ", " + "\"horse\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.goat + ", " + "\"goat\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.monkey + ", " + "\"monkey\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.chicken + ", " + "\"chicken\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.dog + ", " + "\"dog\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_ANIMALS + " (" + COL_IMAGE + ", " + COL_ANSWER_ANIMALS + ") VALUES (" + R.drawable.pig + ", " + "\"pig\"" + ");");

        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of Doraemon?\"" + ", " + "\"Doraemon\"" + ", " + "\"Jaian\"" + ", " + "\"Suneo\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of Naruto?\"" + ", " + "\"Naruto\"" + ", " + "\"Sasuke\"" + ", " + "\"Sakura\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of Dectective Conan?\"" + ", " + "\"Conan\"" + ", " + "\"Ran\"" + ", " + "\"Sonoko\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of Dragon Ball?\"" + ", " + "\"Songoku\"" + ", " + "\"Vegeta\"" + ", " + "\"Krilin\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of Death Note?\"" + ", " + "\"Light yagami\"" + ", " + "\"L\"" + ", " + "\"Near\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of One Piece?\"" + ", " + "\"Luffy\"" + ", " + "\"Zoro\"" + ", " + "\"Sanji\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of Jojo Bizzare Adventure 3?\"" + ", " + "\"Jotaro Kujo\"" + ", " + "\"DIO\"" + ", " + "\"Joseph Jostar\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of Phineas and Ferb?\"" + ", " + "\"Perry\"" + ", " + "\"Phineas\"" + ", " + "\"Isabella\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of Gravity Falls?\"" + ", " + "\"Dipper and Mabel Pines\"" + ", " + "\"Stanley Pines\"" + ", " + "\"Wendy Corduroy\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of Tom and Jerry?\"" + ", " + "\"Tom and Jerry\"" + ", " + "\"Spike\"" + ", " + "\"Butch\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of Family Guy?\"" + ", " + "\"Griffin family\"" + ", " + "\"Glenn Quagmire\"" + ", " + "\"Joseph Swanson\"" + ");");
        sqLiteDatabase.execSQL("INSERT INTO " + TABLE_QUESTION_CARTOONS + " (" + COL_QUESTION_CARTOONS + ", " + COL_ANSWER_RIGHT + ", " + COL_ANSWER_WRONG_1 + ", " + COL_ANSWER_WRONG_2 + ") VALUES (" + "\"Who is the main character of Oggy and the Cockroaches?\"" + ", " + "\"Oggy and the Cockroaches\"" + ", " + "\"Jack\"" + ", " + "\"Bob\"" + ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION_ANIMALS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION_CARTOONS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTEMPT);
        onCreate(sqLiteDatabase);
    }

    public void addUser(String username, String password, String email, int totalScore) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME, username);
        contentValues.put(COL_PASSWORD, password);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_TOTAL_SCORE, totalScore);
        db.insert(TABLE_USER, null, contentValues);
    }

    public void addAttempt(String username, String field, String date, String time, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERNAME_ATTEMPT, username);
        contentValues.put(COL_FIELD, field);
        contentValues.put(COL_DATE, date);
        contentValues.put(COL_TIME, time);
        contentValues.put(COL_SCORE, score);
        db.insert(TABLE_ATTEMPT, null, contentValues);
    }

    public boolean checkUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[] {ID_USER};
        String selection = COL_USERNAME + " = ?" + " AND " + COL_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[] {ID_USER};
        String selection = COL_EMAIL + " = ?";
        String[] selectionArgs = {email};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[] {ID_USER};
        String selection = COL_USERNAME + " = ?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean checkPassword(String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[] {ID_USER};
        String selection = COL_PASSWORD + " = ?";
        String[] selectionArgs = {password};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void updatePassword(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_PASSWORD, password);
        db.update(TABLE_USER, contentValues, COL_USERNAME + " = ?", new String[] {username});
    }

    @SuppressLint("Range")
    public int getOverallScore(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[] {COL_TOTAL_SCORE};
        String selection = COL_USERNAME + " = ?";
        String[] selectionArgs = {username};
        Cursor cursor = db.query(TABLE_USER, columns, selection, selectionArgs, null, null, null);

        int overallScore = 0;
        if (cursor != null && cursor.moveToFirst()) {
            overallScore = cursor.getInt(cursor.getColumnIndex(COL_TOTAL_SCORE));
            cursor.close();
        }
        return overallScore;
    }

    public void updateOverallScore(String username, int overallScore) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TOTAL_SCORE, overallScore);
        db.update(TABLE_USER, contentValues, COL_USERNAME + " = ?", new String[] {username});
    }

    @SuppressLint("Range")
    public int getImageResourceForAnimal(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[] {COL_IMAGE};
        String selection = ID_ANIMALS + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        Cursor cursor = db.query(TABLE_QUESTION_ANIMALS, columns, selection, selectionArgs, null, null, null);

        int imageResource = 0;

        if (cursor != null && cursor.moveToFirst()) {
            imageResource = cursor.getInt(cursor.getColumnIndex(COL_IMAGE));
            cursor.close();
        }
        return imageResource;
    }

    public boolean checkAnimalsAnswer(int imageResource, String answer) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] column = new String[] {ID_ANIMALS};
        String selection = COL_IMAGE + " = ?" + " AND " + COL_ANSWER_ANIMALS + " = ?";
        String[] selectionArgs = {String.valueOf(imageResource), answer};
        Cursor cursor = db.query(TABLE_QUESTION_ANIMALS, column, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @SuppressLint("Range")
    public Cursor getCartoonQuestion(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = new String[] {COL_QUESTION_CARTOONS, COL_ANSWER_RIGHT, COL_ANSWER_WRONG_1, COL_ANSWER_WRONG_2};
        String selection = ID_CARTOONS + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        Cursor cursor = db.query(TABLE_QUESTION_CARTOONS, columns, selection, selectionArgs, null, null, null);

        return cursor;
    }

    public Cursor viewAllAttempts(String username) {
        /*
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_ATTEMPT + " WHERE " + COL_USERNAME_ATTEMPT + " = ?", new String[] {username});
        return res;
        */
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = null;
        String selection = null;
        String orderBy = ID_ATTEMPT + " DESC";

        if (username != null && !username.isEmpty()) {
            selection = COL_USERNAME_ATTEMPT + " = ?";
            selectionArgs = new String[] {username};
        }

        Cursor res = db.query(TABLE_ATTEMPT, null, selection, selectionArgs, null, null, orderBy);
        return res;
    }

    public Cursor viewAllAttemptsWithOrder(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] selectionArgs = null;
        String selection = null;

        if (username != null && !username.isEmpty()) {
            selection = COL_USERNAME_ATTEMPT + " = ?";
            selectionArgs = new String[] {username};
        }

        Cursor res = db.query(TABLE_ATTEMPT, null, selection, selectionArgs, null, null, COL_FIELD);
        return res;
    }

    /*
    public void deleteAllTables() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION_ANIMALS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION_CARTOONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ATTEMPT);
        onCreate(db);
    }
    //*/
}