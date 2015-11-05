package com.example.vin.sqlitesaylaniexamplemyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BAL bal;
    EditText mEditText;
    Button mButton;
    ListView mListView;
    ArrayList<String> mArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = (EditText) findViewById(R.id.text);
        mButton = (Button) findViewById(R.id.btn);
        mListView = (ListView) findViewById(R.id.listview);
        bal = new BAL(this);
        showStudent();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentBeen been = new StudentBeen();
                been.setStudentName(mEditText.getText().toString());
                bal.insertStudent(been);
                showStudent();
            }
        });

    }
    public void showStudent(){
        mArrayList = bal.getAllStudent();
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,mArrayList);
        mListView.setAdapter(adapter);
    }

}
