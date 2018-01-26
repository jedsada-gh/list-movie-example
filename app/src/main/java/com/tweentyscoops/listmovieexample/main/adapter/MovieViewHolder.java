package com.tweentyscoops.listmovieexample.main.adapter;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tweentyscoops.listmovieexample.R;
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
        imgMovie = itemView.findViewById(R.id.imgMovie);
        tvNameMovie = itemView.findViewById(R.id.tvNameMovie);
        itemView.setOnClickListener(this);
    }

    void setListener(MovieViewHolderListener listener) {
        this.listener = listener;
    }

    void onBindData(MovieDetailDao model) {
        tvNameMovie.setText(model.getTitle());
        Glide.with(itemView.getContext())
                .load(model.getImageUrl())
                .apply(new RequestOptions()
                        .error(android.R.color.darker_gray)
                        .placeholder(android.R.color.darker_gray))
                .into(imgMovie);
    }

    @Override
    public void onClick(View view) {
        if (listener != null) listener.onItemMovieClick(getAdapterPosition());
    }
}
