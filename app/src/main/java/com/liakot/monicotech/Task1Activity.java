package com.liakot.monicotech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class Task1Activity extends AppCompatActivity {

    ArrayList<ClassTodo> arrayList;
    AdapterTodo adapter;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task1);
        InitializeAll();
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);

        fetch();

        Log.e("RESPONSE1", "Arraylist: " + arrayList.size());

        adapter = new AdapterTodo(Task1Activity.this, arrayList);
        recyclerView.setAdapter(adapter);

        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void InitializeAll() {
        arrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);
        progressBar = findViewById(R.id.progress_bar);
        layoutManager = new LinearLayoutManager(Task1Activity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

    private void fetch()
    {
        RequestQueue mQueue = Volley.newRequestQueue(Task1Activity.this);
        String url = "https://jsonplaceholder.typicode.com/todos";
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        progressBar.setVisibility(View.VISIBLE);
                        for(int i=0; i<response.length(); i++) {
                            try {
                                JSONObject object = response.getJSONObject(i);
                                String title;
                                int id, userId;
                                boolean complete;
                                title = object.getString("title");
                                id = object.getInt("id");
                                userId = object.getInt("userId");
                                complete = object.getBoolean("completed");

                                ClassTodo todo = new ClassTodo(userId, id, title, complete);
                                Log.e("RESPONSE1", "onResponse: " + todo.getId());
                                arrayList.add(todo);
                                adapter.notifyDataSetChanged();

                            } catch (Exception e) {
                                e.printStackTrace();
                                Log.e("RESPONSE1", "Exception: " + e);
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                error.printStackTrace();
                Log.e("RESPONSE1", "onErrorResponse: " + error);
            }
        });
        mQueue.add(request);
    }
}