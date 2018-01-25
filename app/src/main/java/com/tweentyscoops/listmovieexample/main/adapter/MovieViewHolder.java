package com.tweentyscoops.listmovieexample.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tweentyscoops.listmovieexample.model.MovieDetailDao;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    interface MovieViewHolderListener {
        void onItemMovieClick(int position);
    }

    private MovieViewHolderListener listener;

    MovieViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    void setListener(MovieViewHolderListener listener) {
        this.listener = listener;
    }

    void onBindData(MovieDetailDao model) {

    }

    @Override
    public void onClick(View view) {
        if (listener != null) listener.onItemMovieClick(getAdapterPosition());
    }
}
