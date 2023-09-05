package com.liakot.monicotech;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterTodo extends RecyclerView.Adapter<AdapterTodo.ViewHolder>{
    ArrayList<ClassTodo> arrayList;
    Context activityContext;

    public AdapterTodo(Context context, ArrayList<ClassTodo> list) {

        activityContext = context;
        arrayList = list;
    }

    //------To hold every list item view------
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
        }
    }

    @NonNull
    @Override
    public AdapterTodo.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.task_model, viewGroup, false);

        return new AdapterTodo.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTodo.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        String title, id, userId, completed;
        title = arrayList.get(position).getTitle();
        id = String.valueOf(arrayList.get(position).getId());
        userId = String.valueOf(arrayList.get(position).getUserid());
        completed = String.valueOf(arrayList.get(position).isCompleted());

        holder.itemView.setTag(arrayList.get(position));

        Log.e("SEEN", "onBindViewHolder: " + id + " " + userId +  " " + completed);
        holder.title.setText(arrayList.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activityContext, TaskDetails.class);
                intent.putExtra("title", title);
                intent.putExtra("id", id);
                intent.putExtra("userId", userId);
                intent.putExtra("completed", completed);
                activityContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
