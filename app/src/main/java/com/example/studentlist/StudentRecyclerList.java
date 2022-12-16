package com.example.studentlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

import com.example.studentlist.Model.Model;
import com.example.studentlist.Model.Student;

public class StudentRecyclerList extends AppCompatActivity {
    List<Student> data;
    StudentRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);
        data = Model.instance().getAllStudents();
        Button addStudentBtn = findViewById(R.id.studentRL_newStudent);

        RecyclerView list = findViewById(R.id.studentRecyclerList_list);
        for(int i=0; i< data.size(); i++) {

        }
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));

        adapter = new StudentRecyclerAdapter();
        list.setAdapter(adapter);

        addStudentBtn.setOnClickListener(view -> {
            Intent intent = new Intent(StudentRecyclerList.this, NewStudent.class);
            startActivity(intent);
        });
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Log.d("tag" , "Row was clicked " + pos);
                Intent intent = new Intent(StudentRecyclerList.this, StudentDetails.class);
                Student st = data.get(pos);
                intent.putExtra("name", st.name);
                intent.putExtra("id", st.id);
                intent.putExtra("phone", st.phone);
                intent.putExtra("address", st.address);
                intent.putExtra("cb", st.cb);
                intent.putExtra("pos", pos);
                startActivity(intent);
            }
        });
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView id;
        TextView phone;
        TextView address;
        CheckBox cb;

        public StudentViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            name = itemView.findViewById(R.id.studentListRow_name);
            id = itemView.findViewById(R.id.studentListRow_id);
            cb = itemView.findViewById(R.id.studentListRow_cb);


            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = (int)cb.getTag();
                    Student st = data.get(pos);
                    st.cb = cb.isChecked();
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos= getAdapterPosition();
                    listener.onItemClick(pos);
                }
            });
        }

        public void bind(Student st, int position) {
            name.setText(st.name);
            id.setText(st.id);
            cb.setChecked(st.cb);
            cb.setTag(position);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int pos) ;
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {

        OnItemClickListener listener;
        void setOnItemClickListener(OnItemClickListener listener) {
            this.listener = listener;
        }


        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row, parent, false);
            return new StudentViewHolder(view,listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            Student st = data.get(position);
            Log.d("tag", "student: " + st.avatarURL);
            holder.bind(st, position);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        data = Model.instance().getAllStudents();
        adapter.notifyDataSetChanged();
    }
}

