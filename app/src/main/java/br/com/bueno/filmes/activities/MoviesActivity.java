package br.com.bueno.filmes.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import br.com.bueno.filmes.R;
import br.com.bueno.filmes.adapters.MoviesAdapter;
import br.com.bueno.filmes.contracts.OnItemClickListener;
import br.com.bueno.filmes.models.Movie;
import br.com.bueno.filmes.models.Results;
import br.com.bueno.filmes.services.MovieService;

import static android.view.View.GONE;

public class MoviesActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        bindViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void bindViews() {
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mRecyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);

        getMovieList();
    }

    @Override
    public void onItemClick(View view, Movie movie) {
        Intent intent = new Intent(MoviesActivity.this,
                MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.MOVIE_EXTRA, movie);
        startActivity(intent);
    }

    private void getMovieList() {
        new MovieAsyncTask().execute();
    }

    private void updateList(List<Movie> movies) {
        if (movies != null) {
            MoviesAdapter moviesAdapter = new MoviesAdapter(movies, this);
            mRecyclerView.setAdapter(moviesAdapter);
        }
    }

    class MovieAsyncTask extends AsyncTask<Void, Void, List<Movie>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(GONE);

        }

        @Override
        protected List<Movie> doInBackground(Void... params) {
            List<Movie> results = null;
            try {
                results = MovieService
                        .getPopularMovies(1).getResults();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return results;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(List<Movie> movies) {
            super.onPostExecute(movies);
            updateList(movies);
            mProgressBar.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }
}
