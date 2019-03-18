package com.example.week01.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.week01.R;
import com.example.week01.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    ArrayList<Bean.DataBean> list = new ArrayList<>();

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item, viewGroup, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(mainViewHolder.itemView.getContext()).asBitmap().apply(requestOptions).load(list.get(i).getPic()).into(mainViewHolder.showimg);
        mainViewHolder.showtext.setText(list.get(i).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void refresh(List<Bean.DataBean> data) {
        this.list.clear();
        this.list.addAll(data);
        notifyDataSetChanged();
    }

    class MainViewHolder extends RecyclerView.ViewHolder{

        ImageView showimg;
        TextView showtext;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            showimg = itemView.findViewById(R.id.showimg);
            showtext = itemView.findViewById(R.id.showtext);
        }
    }
}
