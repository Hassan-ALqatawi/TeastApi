package com.al_qatawi.teastapi.modle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.al_qatawi.teastapi.R;

import java.util.ArrayList;

public class PostRecycler extends RecyclerView.Adapter<PostRecycler.PostHolder> {

   private ArrayList<Posts> posts = new ArrayList<>();

    public PostRecycler(ArrayList<Posts> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        holder.userId.setText( "UserId"+" : "+ posts.get(position).getUserId()+"");
        holder.id.setText( "Id"+" : "+ posts.get(position).getId()+"");
        holder.title.setText( "Title"+" : "+"\n"+ posts.get(position).getTitle());
        holder.body.setText( "Body"+" : "+"\n"+ posts.get(position).getBody());

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setList(ArrayList<Posts> list){
       this.posts = list;

    }

    public class PostHolder extends RecyclerView.ViewHolder{

        TextView userId , id , title , body ;


        public PostHolder(@NonNull View itemView) {
            super(itemView);

            userId = itemView.findViewById(R.id.tv_userId);
            id = itemView.findViewById(R.id.tv_id);
            title = itemView.findViewById(R.id.tv_title);
            body = itemView.findViewById(R.id.tv_bod);

        }
    }
}
