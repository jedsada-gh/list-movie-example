package com.tweentyscoops.listmovieexample.main;

class MainController {

    private MainView view;

    MainController(MainView view) {
        this.view = view;
    }

    void requestListMovie() {
        if(view != null) {
            view.showProgressBar();
        }
    }
}
