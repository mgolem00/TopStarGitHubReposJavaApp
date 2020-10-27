package com.example.topstargithubrepos_javaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    private ArrayList<Items> mDataset;
    private MainActivity context;

    public static class MyViewHolder extends  RecyclerView.ViewHolder {
        public TextView textView1;
        public TextView textView2;
        public ImageView imgView;
        public MyViewHolder(View v){
            super(v);
            textView1 = v.findViewById(R.id.textViewUsername);
            textView2 = v.findViewById(R.id.textViewRepoName);
            imgView = v.findViewById(R.id.imageView);
        };
    }

    public MyAdapter(ArrayList<Items> myDataset){
        this.mDataset = myDataset;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View viewCell = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.my_view,parent,false);

        MyViewHolder viewHolder = new MyViewHolder(viewCell);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView1.setText(mDataset.get(position).getRepoName() + " - " + mDataset.get(position).getNumOfStars());
        holder.textView2.setText(mDataset.get(position).getRepoOwner());
        Glide.with(holder.imgView.getContext())
                .load(mDataset.get(position).getImgURL())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
