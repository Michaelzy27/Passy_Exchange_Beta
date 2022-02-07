package com.michael.passy_exchange.homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.michael.passy_exchange.R;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView arrow;
        public TextView task_desc, task_deadline, task_track, task_status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            arrow = itemView.findViewById(R.id.arrow);
            task_desc = itemView.findViewById(R.id.task_desc);
            task_deadline = itemView.findViewById(R.id.task_deadline);
            task_track = itemView.findViewById(R.id.task_track);
            task_status = itemView.findViewById(R.id.task_status);

        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.task_desc.setText(task.getTask_desc());
        holder.task_deadline.setText(task.getDeadline());
        holder.task_status.setText(task.getStatus());
        holder.arrow.setImageResource(task.getArrow());
        holder.task_track.setText(task.getTrack());
    }


    @Override
    public int getItemCount() {
        return taskList.size();
    }

}
