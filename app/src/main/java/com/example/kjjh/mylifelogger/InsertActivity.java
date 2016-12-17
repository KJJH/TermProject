package com.example.kjjh.mylifelogger;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class InsertActivity extends AppCompatActivity {

    // Datavase 관련 객체들
    SQLiteDatabase db;
    String dbName = "idList.db";
    String tableName = "idListTable"; // name of Table;
    int dbMode = Context.MODE_PRIVATE;

    Button BtSave, BtCancel, BtPhoto;
    ImageView simpleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        // Database 생성 및 열기
        db = openOrCreateDatabase(dbName, dbMode, null);
        // 테이블 생성
        createTable();


        ///////// Spinner 구현 /////////
        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        ///////// Photo 구현 /////////
        BtPhoto = (Button)findViewById(R.id.button);
        BtPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button:
                        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType(MediaStore.Images.Media.CONTENT_TYPE);
                        startActivityForResult(Intent.createChooser(intent, "앨범에서 불러오기"), REQUEST_CODE_PICKALBUM);
                        break;
                }
            }
        });


        //////// Button 구현 /////////
        // Save를 눌렀을 때
        BtSave = (Button)findViewById(R.id.button1);
        BtSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        // Cancel를 눌렀을 때
        BtCancel = (Button)findViewById(R.id.button2);
        BtCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
