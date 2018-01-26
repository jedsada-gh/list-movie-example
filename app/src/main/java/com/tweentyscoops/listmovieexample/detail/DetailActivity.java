package com.tweentyscoops.listmovieexample.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tweentyscoops.listmovieexample.R;
import com.tweentyscoops.listmovieexample.model.MovieDetailDao;
import com.tweentyscoops.listmovieexample.widget.CustomImageView;

import static com.tweentyscoops.listmovieexample.main.MainActivity.KEY_MODEL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(getMovieDetail().getTitle());
        }
        ((AppCompatTextView) findViewById(R.id.tvNameMovie)).setText(getMovieDetail().getTitle());
        ((AppCompatTextView) findViewById(R.id.tvOverviewMovie)).setText(getMovieDetail().getOverview());
        Glide.with(this).load(getMovieDetail().getImageUrl())
                .apply(new RequestOptions()
                        .placeholder(android.R.color.darker_gray)
                        .error(android.R.color.darker_gray))
                .into((CustomImageView) findViewById(R.id.imgMovie));
    }

    private MovieDetailDao getMovieDetail() {
        return getIntent().getParcelableExtra(KEY_MODEL);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}