package com.al_qatawi.teastapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.al_qatawi.teastapi.modle.PostRecycler;
import com.al_qatawi.teastapi.modle.Posts;
import com.al_qatawi.teastapi.viewModle.PostsViewModle;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    PostsViewModle postsViewModle;
    RecyclerView recyclerView;
    PostRecycler adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        postsViewModle =new ViewModelProvider(this).get(PostsViewModle.class);
        postsViewModle.getPosts();


        postsViewModle.getPostsList().observe(this, new Observer<List<Posts>>() {
            @Override
            public void onChanged(List<Posts> posts) {
                adapter = new PostRecycler((ArrayList<Posts>) posts);
                recyclerView.setAdapter(adapter);
            }
        });












    }
}