package com.al_qatawi.teastapi.interfeas;

import com.al_qatawi.teastapi.modle.Posts;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface PostsApiInterfeas {


    @GET("/posts")
    Single<List<Posts>> getPosts();


}
