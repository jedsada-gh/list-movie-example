package com.tweentyscoops.listmovieexample.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class MovieDao implements Parcelable {

    @SerializedName("results")
    private List<MovieDetailDao> movies = new ArrayList<>();

    private MovieDao(Parcel in) {
        movies = in.createTypedArrayList(MovieDetailDao.CREATOR);
    }

    public static final Creator<MovieDao> CREATOR = new Creator<MovieDao>() {
        @Override
        public MovieDao createFromParcel(Parcel in) {
            return new MovieDao(in);
        }

        @Override
        public MovieDao[] newArray(int size) {
            return new MovieDao[size];
        }
    };

    public List<MovieDetailDao> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieDetailDao> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDao movieDao = (MovieDao) o;

        return movies != null ? movies.equals(movieDao.movies) : movieDao.movies == null;
    }

    @Override
    public int hashCode() {
        return movies != null ? movies.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "MovieDao{" +
                "movies=" + movies +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(movies);
    }
}