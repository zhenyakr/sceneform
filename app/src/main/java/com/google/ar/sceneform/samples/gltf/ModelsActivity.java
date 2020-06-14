package com.google.ar.sceneform.samples.gltf;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import java.util.ArrayList;

public class ModelsActivity extends AppCompatActivity implements Adapter.OnModelClickListener {

    RecyclerView recyclerView;
    public Adapter adapter;
    ArrayList<Model> modelArrayList;
    FloatingActionButton fab;
    SwipeRefreshLayout swipeRefreshLayout;
    ArrayList<Model> wthJstCreated;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_models);
        wthJstCreated = Model.modelArrayList();
        //modelArrayList = Model.modelArrayList();
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        recyclerView = findViewById(R.id.rv_models);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new Adapter(this, wthJstCreated, this);
        recyclerView.setAdapter(adapter);
        fab = findViewById(R.id.fab_add);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(this, ModelCreateActivity.class);
            startActivity(intent);
        });

        swipeRefreshLayout.setOnRefreshListener(() -> {
            adapter = null;
            adapter = new Adapter(this, wthJstCreated, this);
            recyclerView.setAdapter(adapter);
            swipeRefreshLayout.setRefreshing(false);
        });
    }



    @Override
    public void onModelClick(int position) {
        Intent intent = new Intent(this, ModelDetailsActivity.class);
        intent.putExtra("selected_model_title", modelArrayList.get(position).getTitle());
        intent.putExtra("selected_model_image", modelArrayList.get(position).getImageId());
        startActivity(intent);
    }
}