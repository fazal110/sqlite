package com.example.vin.sqlitesaylaniexamplemyapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Fazal on 10/11/2015.
 */
public class BAL {
    DBConnect db;

    public BAL(Context context) {
        db = new DBConnect(context);
    }

    public  Long insertStudent(StudentBeen been){
        try{
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(DBConnect.COL_2, been.getStudentName());
            sqLiteDatabase.insert(DBConnect.TABLE_NAME, null, contentValues);
            sqLiteDatabase.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        return (long)0;
    }

    public  boolean UpdateStudent(StudentBeen been){
        try{
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("studentID", been.getStudentID());
            contentValues.put("studentName", been.getStudentName());
            sqLiteDatabase.update("student", contentValues, "studentID = ?", new String[]{been.getStudentID() + ""});
            sqLiteDatabase.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public int deleteRecord(String id)
    {
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        return sqLiteDatabase.delete(DBConnect.TABLE_NAME,DBConnect.COL_1+" = ?",new String[]{id});

    }

    public boolean deleteAll(){
        SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
        sqLiteDatabase.execSQL("delete from "+DBConnect.TABLE_NAME);
        sqLiteDatabase.close();
        return true;
    }

    public ArrayList<String> getAllStudent(){
        ArrayList<String> arrayList = new ArrayList<>();
        try{
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
            String query = "SELECT * FROM "+DBConnect.TABLE_NAME;
            Cursor cursor = sqLiteDatabase.rawQuery(query,null);
            if(cursor.getCount() >0){
                while (cursor.moveToNext()){
                    StudentBeen been = new StudentBeen();
                    been.setStudentID(cursor.getInt(0));
                    been.setStudentName(cursor.getString(1));
                    System.out.print("id======================"+been.getStudentID());
                    arrayList.add(String.valueOf(been.getStudentID())+":  " + been.getStudentName());

                }
            }
            sqLiteDatabase.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return arrayList;
    }

    public ArrayList<String> getAllid(){
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            SQLiteDatabase sqLiteDatabase = db.getWritableDatabase();
            String query = "SELECT * FROM "+DBConnect.TABLE_NAME;
            Cursor cursor = sqLiteDatabase.rawQuery(query,null);
            if(cursor.getCount() >0){
                while (cursor.moveToNext()){
                    StudentBeen been = new StudentBeen();
                    been.setStudentID(cursor.getInt(0));
                    been.setStudentName(cursor.getString(1));
                    System.out.print("id======================" + been.getStudentID());
                    arrayList.add(been.getStudentID()+"");

                }
            }
            sqLiteDatabase.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return arrayList;
    }
}
