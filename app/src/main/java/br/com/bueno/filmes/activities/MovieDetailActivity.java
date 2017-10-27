package br.com.bueno.filmes.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.bueno.filmes.R;
import br.com.bueno.filmes.models.Movie;

public class MovieDetailActivity extends AppCompatActivity {

    public static final String MOVIE_EXTRA = "MOVIE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Movie movie = (Movie) getIntent().getExtras().getSerializable(MOVIE_EXTRA);
        setTitle(movie.getTitle());
    }
}
