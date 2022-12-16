package com.example.studentlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import java.util.List;

import Model.Model;
import Model.Student;

public class StudentRecyclerList extends AppCompatActivity {
    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);
        data = Model.intance.getAllStudents();

        RecyclerView list = findViewById(R.id.studentRecyclerList_list);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new StudentRecyclerAdapter());
    }

    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView id;
        CheckBox cb;

        public StudentViewHolder(@NonNull View itemView) {
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
        }

        public void bind(Student st, int position) {
            name.setText(st.name);
            id.setText(st.id);
            cb.setChecked(st.cb);
            cb.setTag(position);
        }
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {

        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_list_row, parent, false);

            return new StudentViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            Student st = data.get(position);
            holder.bind(st, position);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}

