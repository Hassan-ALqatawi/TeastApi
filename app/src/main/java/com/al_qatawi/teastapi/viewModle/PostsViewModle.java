package com.al_qatawi.teastapi.viewModle;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.al_qatawi.teastapi.modle.Posts;
import com.al_qatawi.teastapi.repository.Repository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class PostsViewModle extends ViewModel {
    private static final String TAG = "PostsViewModle";

    private Repository repository;

    MutableLiveData<List<Posts>> postsList = new MutableLiveData<List<Posts>>();

    @ViewModelInject
    public PostsViewModle(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<List<Posts>> getPostsList() {

        return postsList;
    }

    public void getPosts() {

        Single<List<Posts>> observable = repository.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

        observable.subscribe(o -> postsList.setValue(o), e -> Log.d(TAG, "getPosts: " + e));

    }

}