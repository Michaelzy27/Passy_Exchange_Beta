package com.michael.passy_exchange_beta.homepage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.michael.passy_exchange_beta.R;

import java.util.ArrayList;
import java.util.List;

public class Home_activity extends AppCompatActivity {
    RecyclerView taskRecycler;
    TaskAdapter taskAdapter;
    List<Task> tasks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_activity);

        taskRecycler = findViewById(R.id.tasks_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        taskRecycler.setLayoutManager(layoutManager);
        taskAdapter = new TaskAdapter(tasks);
        taskRecycler.setAdapter(taskAdapter);

        prepareTasks();
    }

    private void prepareTasks() {
        Task
            task = new Task("Stage 2 entry Task: Hotel website design","Deadline: 31/07/2020 12:00 AM",
                "Design","pending",R.drawable.ic_baseline_arrow_forward_ios_24);
        tasks.add(task);
            task = new Task("Task 0.5: Git","Deadline: 07/06/2020 12:00 AM",
                "General","closed",R.drawable.ic_baseline_arrow_forward_ios_24);
        tasks.add(task);
        task = new Task("Task 0.5: Lucid","Deadline: 07/06/2020 12:00 AM",
                "General","closed",R.drawable.ic_baseline_arrow_forward_ios_24);
        tasks.add(task);
    }


}