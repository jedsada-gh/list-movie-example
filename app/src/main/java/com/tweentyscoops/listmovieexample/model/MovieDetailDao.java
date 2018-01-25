package com.tweentyscoops.listmovieexample.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class MovieDetailDao implements Parcelable {

    @SerializedName("title")
    private String title;
    @SerializedName("image_url")
    private String imageUrl;
    @SerializedName("overview")
    private String overview;

    private MovieDetailDao(Parcel in) {
        title = in.readString();
        imageUrl = in.readString();
        overview = in.readString();
    }

    static final Creator<MovieDetailDao> CREATOR = new Creator<MovieDetailDao>() {
        @Override
        public MovieDetailDao createFromParcel(Parcel in) {
            return new MovieDetailDao(in);
        }

        @Override
        public MovieDetailDao[] newArray(int size) {
            return new MovieDetailDao[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieDetailDao that = (MovieDetailDao) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null)
            return false;
        return overview != null ? overview.equals(that.overview) : that.overview == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (overview != null ? overview.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MovieDetailDao{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", overview='" + overview + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(imageUrl);
        parcel.writeString(overview);
    }
}
