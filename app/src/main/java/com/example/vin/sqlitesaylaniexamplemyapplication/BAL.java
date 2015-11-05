package com.example.vin.sqlitesaylaniexamplemyapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by VIN on 10/11/2015.
 */
public class BAL {
    DBConnect db;

    public BAL(Context context) {
        db = new DBConnect(context);
    }
    public  Long insertStudent(StudentBeen been){
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("studentName", been.getStudentName());
        sqLiteDatabase.insert("student", null, contentValues);
        sqLiteDatabase.close();
        return (long)0;
    }

    public ArrayList<String> getAllStudent(){
        ArrayList<String> arrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        String query = "SELECT * FROM student";
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.getCount() >0){
            while (cursor.moveToNext()){
                StudentBeen been = new StudentBeen();
                been.setStudentID(cursor.getInt(0));
                been.setStudentName(cursor.getString(1));
                arrayList.add(been.getStudentName());
            }
        }
        sqLiteDatabase.close();
        return arrayList;
    }
}
