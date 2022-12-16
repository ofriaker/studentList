package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentlist.Model.Model;
import com.example.studentlist.Model.Student;

public class EditStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        EditText nameEt = findViewById(R.id.editStudent_stName);
        EditText idEt = findViewById(R.id.editStudent_stID);
        EditText phoneEt = findViewById(R.id.editStudent_stPhone);
        EditText addressEt = findViewById(R.id.editStudent_stAddress);
        CheckBox cbBtn = findViewById(R.id.editStudent_cb);
        Button saveBtn = findViewById(R.id.editStudent_saveBtn);
        Button cancelBtn = findViewById(R.id.editStudent_cancelBtn);
        Button deleteBtn = findViewById(R.id.editStudent_deleteBtn);
        TextView msg = findViewById(R.id.editStudent_saveMSG);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String id = bundle.getString("id");
        String phone = bundle.getString("phone");
        String address = bundle.getString("address");
        Boolean cb = bundle.getBoolean("cb");

        nameEt.setText(name);
        idEt.setText(id);
        phoneEt.setText(phone);
        addressEt.setText(address);
        cbBtn.setChecked(cb);


        saveBtn.setOnClickListener(view -> {
            String newName = nameEt.getText().toString();
            String newId = idEt.getText().toString();
            String newPhone = phoneEt.getText().toString();
            String newAddress = addressEt.getText().toString();
            Boolean newCb = cbBtn.isChecked();

            Student st = new Student(newName, newId, newPhone, newAddress, "", newCb);
            Model.instance().addStudent(st);
            msg.setVisibility(View.VISIBLE);
        });

        deleteBtn.setOnClickListener(view -> {
            Model.instance().deleteStudent(pos);
        });
        cancelBtn.setOnClickListener(view -> {finish();});


    }
}