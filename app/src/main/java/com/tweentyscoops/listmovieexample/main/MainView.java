package com.tweentyscoops.listmovieexample.main;

import com.tweentyscoops.listmovieexample.model.MovieDao;

public interface MainView {
    void showProgressBar();

    void hideProgressBar();

    void showMessage(String message);

    void setListMovie(MovieDao dao);
}