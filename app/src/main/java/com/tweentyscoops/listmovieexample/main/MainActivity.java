package com.tweentyscoops.listmovieexample.main;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.tweentyscoops.listmovieexample.R;
import com.tweentyscoops.listmovieexample.detail.DetailActivity;
import com.tweentyscoops.listmovieexample.main.adapter.MovieAdapter;
import com.tweentyscoops.listmovieexample.model.MovieDao;
import com.tweentyscoops.listmovieexample.model.MovieDetailDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView, MovieAdapter.MovieListener, SwipeRefreshLayout.OnRefreshListener {

    private MainController controller;
    private MovieAdapter movieAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MovieDao dao;
    public static String KEY_MODEL = "model";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupInstance();
        setupView();
        // FIXME : check instance is null for configuration
        controller.requestListMovie();
    }

    private void setupInstance() {
        // TODO #1 : create instance object
    }

    private void setupView() {
        RecyclerView rvMovie = findViewById(R.id.rvMovie);
        swipeRefreshLayout = findViewById(R.id.swpLayout);
        rvMovie.setLayoutManager(new LinearLayoutManager(this));
        rvMovie.setAdapter(movieAdapter);
        rvMovie.setHasFixedSize(false);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorAccent));
    }

    @Override
    public void onRefresh() {
        // TODO #2 : request APIs for refresh list movie
    }

    @Override
    public void showProgressBar() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideProgressBar() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showMessage(String message) {
        // TODO #3 : show error by Toast android
    }

    @Override
    public void setListMovie(MovieDao dao) {
        // TODO #4 : set items to list movie
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(KEY_MODEL, dao);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        dao = savedInstanceState.getParcelable(KEY_MODEL);
        setListMovie(dao);
    }

    @Override
    public void onNavigateToDetail(MovieDetailDao model) {
        // TODO #5 : intent to MovieDetailActivity
    }
}