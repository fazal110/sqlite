package com.example.vin.sqlitesaylaniexamplemyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    BAL bal;
    EditText mEditText,mEditText_id;
    Button mButton;
    ListView mListView;
    ArrayList<String> mArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.text);
        mEditText_id = (EditText) findViewById(R.id._id);
        mButton = (Button) findViewById(R.id.btn);
        mListView = (ListView) findViewById(R.id.listview);
        bal = new BAL(this);
        showStudent();
        final DataBeen been = new DataBeen();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                been.setClassifTitle(mEditText.getText().toString());
                SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
                String date = dateformat.format(new Date());
                been.setClaassifdateTime(date);
                been.setClassifUpdatedDateTime(been.getClaassifdateTime());
                bal.InsertData(been);
                showStudent();
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
              try{
                  mArrayList = bal.getAllid();
                  String id = mArrayList.get(i);
                  int deleted_count = bal.deleteRecord(id);
                  showStudent();
                  if(deleted_count>0)
                      Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                  else
                      Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_SHORT).show();
              }catch (Exception e){
                  e.printStackTrace();
              }
            }
        });

    }

    public void DeleteAll(View view){
        try{
            boolean isdeleted = bal.deleteAll();
            showStudent();
            if(isdeleted)
                Toast.makeText(MainActivity.this, "All Data Deleted", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
/*
    public void Update(View view){
        try{
            DataBeen been = new DataBeen();
            been.setStudentID(Integer.valueOf(mEditText_id.getText().toString()));
            been.setStudentName(mEditText.getText().toString());
            boolean isupdated = bal.UpdateStudent(been);
            showStudent();
            if(isupdated)
                Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity.this, "Data not Updated", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }*/

    public void showStudent(){
        mArrayList = bal.getAllStudent();
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,mArrayList);
        mListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
