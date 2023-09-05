package com.liakot.monicotech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class TaskDetails extends AppCompatActivity {

    TextView title, id, userId, complete;
    String todo_title;
    String todo_id, todo_user_id;
    String todo_complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        InitializeAll();

    }

    private void InitializeAll() {
        todo_title = getIntent().getStringExtra("title");
        todo_id = getIntent().getStringExtra("id");
        todo_user_id = getIntent().getStringExtra("userId");
        todo_complete = getIntent().getStringExtra("completed");


        title = findViewById(R.id.details_title);
        id = findViewById(R.id.details_id);
        userId = findViewById(R.id.details_used_id);
        complete = findViewById(R.id.details_completed);

        Log.e("Details", "InitializeAll: " + todo_title + " " + todo_id + " " + todo_user_id + " " + todo_complete);

        title.setText(todo_title);
        id.setText("ID : " + todo_id);
        userId.setText("User ID : " + todo_user_id);
        complete.setText("Completed : " + todo_complete);
    }
}