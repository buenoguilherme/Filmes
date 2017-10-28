package br.com.bueno.filmes.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.bueno.filmes.R;
import br.com.bueno.filmes.contracts.OnItemClickListener;
import br.com.bueno.filmes.models.Movie;

/**
 * Created by guibueno on 21/10/17.
 */

public class MoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View mView;
    private Movie mMovie;
    private OnItemClickListener mListener;

    private TextView mTextViewTitle;
    private ImageView mImageMovie;

    public MoviesViewHolder(View view, OnItemClickListener listener) {
        super(view);
        mView = view;
        mListener = listener;

        mTextViewTitle = (TextView) view.findViewById(R.id.title_text_view);
        mImageMovie = (ImageView) view.findViewById(R.id.image_movie);

    }

    public void onBindViewHolder(Movie movie) {
        mMovie = movie;

        mTextViewTitle.setText(mMovie.getTitle());
        mImageMovie.setImageResource(mMovie.getImageResource());

        mView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.onItemClick(view, mMovie);
        }
    }
}









