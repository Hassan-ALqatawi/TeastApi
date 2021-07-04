package com.al_qatawi.teastapi.repository;

import com.al_qatawi.teastapi.interfeas.PostsApiInterfeas;
import com.al_qatawi.teastapi.modle.Posts;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Single;

public class Repository {

    private PostsApiInterfeas postsApiInterfeas;

    @Inject
    public Repository(PostsApiInterfeas postsApiInterfeas) {
        this.postsApiInterfeas = postsApiInterfeas;
    }

    public Single<List<Posts>> getPosts(){

        return postsApiInterfeas.getPosts();
    }



}
