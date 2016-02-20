package com.example.vin.sqlitesaylaniexamplemyapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by VIN on 10/11/2015.
 */
public class DBConnect extends SQLiteOpenHelper {

    public static String DB_NAME = "Saylani_DB";
    public static int DB_VERSION = 1;
    public static String TABLE_NAME = "student";
    public static String COL_1 = "studentID";
    public static String COL_2 = "studentName";

    public DBConnect(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("+COL_1+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_2+" TEXT)";
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
