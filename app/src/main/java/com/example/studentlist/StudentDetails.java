package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.studentlist.Model.Student;

public class StudentDetails extends AppCompatActivity {

    boolean editClicked = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String id = bundle.getString("id");
        String phone = bundle.getString("phone");
        String address = bundle.getString("address");
        Boolean cb = bundle.getBoolean("cb");
        int pos = bundle.getInt("pos");

        TextView nameTv = findViewById(R.id.studentDetails_stName);
        TextView idTv = findViewById(R.id.studentDetails_stID);
        TextView phoneTv = findViewById(R.id.studentDetails_stPhone);
        TextView addressTv = findViewById(R.id.studentDetails_stAddress);
        CheckBox cbView = findViewById(R.id.studentDetails_cb);
        Button editBtn = findViewById(R.id.studentDetails_btn);

        nameTv.setText(name);
        idTv.setText(id);
        phoneTv.setText(phone);
        addressTv.setText(address);
        cbView.setChecked(cb);

        editBtn.setOnClickListener(view -> {
            editClicked = true;
            Intent intent = new Intent(StudentDetails.this, EditStudent.class);
            intent.putExtra("name", name);
            intent.putExtra("id", id);
            intent.putExtra("phone", phone);
            intent.putExtra("address", address);
            intent.putExtra("cb", cb);
            intent.putExtra("pos", pos);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (editClicked){
            finish();
        }
    }
}