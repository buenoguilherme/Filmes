package br.com.bueno.filmes.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import br.com.bueno.filmes.R;
import br.com.bueno.filmes.adapters.MoviesAdapter;
import br.com.bueno.filmes.contracts.OnItemClickListener;
import br.com.bueno.filmes.models.Movie;
import br.com.bueno.filmes.models.MovieRepository;

public class MoviesActivity extends AppCompatActivity implements OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }

    @Override
    protected void onResume() {
        super.onResume();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);

        MoviesAdapter moviesAdapter = new MoviesAdapter(MovieRepository.getMovieList(), this);

        recyclerView.setAdapter(moviesAdapter);
    }

    @Override
    public void onItemClick(View view, Movie movie) {
        Intent intent = new Intent(MoviesActivity.this,
                MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.MOVIE_EXTRA, movie);
        startActivity(intent);
    }
}
