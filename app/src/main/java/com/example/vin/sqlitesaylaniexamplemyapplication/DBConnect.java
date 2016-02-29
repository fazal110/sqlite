package com.example.vin.sqlitesaylaniexamplemyapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by VIN on 10/11/2015.
 */
public class DBConnect extends SQLiteOpenHelper {

    public static String DB_NAME = "Cuny_DB";
    public static int DB_VERSION = 1;
    public static String TABLE_NAME = "ClassificationMaster";
    public static String COL_1 = "ClassificationID";
    public static String COL_2 = "ClassificationTitle";
    public static String COL_3 = "AddedDateTime";
    public static String COL_4 = "LastUpdatedDateTime";


    public DBConnect(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table = "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("+COL_1+" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "+COL_2+" TEXT, "
        +COL_3+" TEXT, "+COL_4+" TEXT)";
        db.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
