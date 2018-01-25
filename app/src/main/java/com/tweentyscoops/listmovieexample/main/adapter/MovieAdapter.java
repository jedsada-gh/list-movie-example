package com.tweentyscoops.listmovieexample.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tweentyscoops.listmovieexample.R;
import com.tweentyscoops.listmovieexample.model.MovieDetailDao;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> implements MovieViewHolder.MovieViewHolderListener {

    public interface MovieListener {
        void onNavigateToDetail(MovieDetailDao model);
    }

    private List<MovieDetailDao> items = new ArrayList<>();
    private MovieListener movieListener;

    public void setMovieListener(MovieListener listener) {
        this.movieListener = listener;
    }

    public void setItems(List<MovieDetailDao> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MovieViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false));
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.onBindData(items.get(position));
        holder.setListener(this);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onItemMovieClick(int position) {
        if (movieListener != null) movieListener.onNavigateToDetail(items.get(position));
    }
}
