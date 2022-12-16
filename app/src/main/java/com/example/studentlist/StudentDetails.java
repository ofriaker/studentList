package com.example.studentlist;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class StudentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        String id = bundle.getString("id");
        String phone = bundle.getString("phone");
        String address = bundle.getString("address");
        String url = bundle.getString("url");
        Boolean cb = bundle.getBoolean("cb");

        TextView nameTv = findViewById(R.id.studentDetails_stName);
        TextView idTv = findViewById(R.id.studentDetails_stID);
        TextView phoneTv = findViewById(R.id.studentDetails_stPhone);
        TextView addressTv = findViewById(R.id.studentDetails_stAddress);
        ImageView img = findViewById(R.id.studentDetails_avatar);
        CheckBox cbView = findViewById(R.id.studentDetails_cb);

        nameTv.setText(name);
        idTv.setText(id);
        phoneTv.setText(phone);
        addressTv.setText(address);
        img.setImageURI(Uri.parse(url));
        cbView.setChecked(cb);


    }
}