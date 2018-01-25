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
        if (savedInstanceState == null) controller.requestListMovie();
    }

    private void setupInstance() {
        controller = new MainController(this);
        movieAdapter = new MovieAdapter();
        movieAdapter.setMovieListener(this);
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
        controller.requestListMovie();
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
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setListMovie(MovieDao dao) {
        this.dao = dao;
        movieAdapter.setItems(this.dao.getMovies());
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
        startActivity(new Intent(this, DetailActivity.class).putExtra(KEY_MODEL, model));
    }
}