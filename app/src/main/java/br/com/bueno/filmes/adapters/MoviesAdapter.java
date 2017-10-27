package br.com.bueno.filmes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.bueno.filmes.R;
import br.com.bueno.filmes.contracts.OnItemClickListener;
import br.com.bueno.filmes.models.Movie;

/**
 * Created by guibueno on 21/10/17.
 */

public class MoviesAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Movie> mMovies;
    private OnItemClickListener mListener;

    public MoviesAdapter(Context context, List<Movie> movies, OnItemClickListener listener) {
        mInflater = LayoutInflater.from(context);
        mMovies = movies;
        mListener = listener;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        MoviesViewHolder moviesViewHolder;

        if (view == null) {
            view = mInflater.inflate(R.layout.movies_item, null);
            moviesViewHolder = new MoviesViewHolder(view, mListener);
            view.setTag(moviesViewHolder);
        } else {
            moviesViewHolder = (MoviesViewHolder) view.getTag();
        }

//        Movie movie = mMovies.get(position);
//        moviesViewHolder.onBindViewHolder(movie);

        moviesViewHolder.onBindViewHolder(getItem(position));

        return view;
    }

    @Override
    public Movie getItem(int position) {
        Movie movie = mMovies.get(position);
        return movie;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }
}
