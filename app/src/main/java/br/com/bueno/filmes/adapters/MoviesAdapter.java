package br.com.bueno.filmes.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder> {

    private List<Movie> mMovies;
    private OnItemClickListener mListener;

    public MoviesAdapter(List<Movie> movieList, OnItemClickListener listener) {
        mMovies = movieList;
        mListener = listener;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movies_item, parent, false);
        return new MoviesViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        Movie movie = mMovies.get(position);
        holder.onBindViewHolder(movie);
    }

    @Override
    public int getItemCount() {
        return mMovies != null ? mMovies.size() : 0;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

}
