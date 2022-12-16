package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentlist.Model.Model;
import com.example.studentlist.Model.Student;

public class NewStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);

        EditText nameEt = findViewById(R.id.newStudent_etName);
        EditText idEt = findViewById(R.id.newStudent_etID);
        EditText phoneEt = findViewById(R.id.newStudent_etPhone);
        EditText addressEt = findViewById(R.id.newStudent_etAddress);
        Button saveBtn = findViewById(R.id.newStudent_saveBtn);
        Button cancelBtn = findViewById(R.id.newStudent_cancelBtn);
        CheckBox cbBtn = findViewById(R.id.newStudent_cb);
        TextView msg = findViewById(R.id.newStudent_saveMSG);

        saveBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString();
            String id = idEt.getText().toString();
            String phone = phoneEt.getText().toString();
            String address = addressEt.getText().toString();
            Boolean cb = cbBtn.isChecked();

            Student st = new Student(name, id, phone, address, "", cb);
            Model.instance().addStudent(st);
            msg.setVisibility(View.VISIBLE);

        });

        cancelBtn.setOnClickListener(view -> {finish();});
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}