package com.tweentyscoops.listmovieexample.main.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tweentyscoops.listmovieexample.model.MovieDetailDao;
import com.tweentyscoops.listmovieexample.widget.CustomImageView;

public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    interface MovieViewHolderListener {
        void onItemMovieClick(int position);
    }

    private MovieViewHolderListener listener;
    private CustomImageView imgMovie;
    private AppCompatTextView tvNameMovie;

    MovieViewHolder(View itemView) {
        super(itemView);
        // TODO #8 : findViewById from view holder
    }

    void setListener(MovieViewHolderListener listener) {
        this.listener = listener;
    }

    void onBindData(MovieDetailDao model) {
        // TODO #8.1 : set data to item view
    }

    @Override
    public void onClick(View view) {
        // TODO #8.2 : set callback for interact to class adapter
    }
}
