package br.com.bueno.filmes.adapters;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.bueno.filmes.R;
import br.com.bueno.filmes.contracts.OnItemClickListener;
import br.com.bueno.filmes.models.Movie;

/**
 * Created by guibueno on 21/10/17.
 */

public class MoviesViewHolder implements View.OnClickListener {
    private View mView;
    private Movie mMovie;
    private OnItemClickListener mListener;

    private TextView mTextViewTitle;
    private TextView mTextViewAverage;
    private TextView mTextViewYear;
    private TextView mTextViewCategory;

    public MoviesViewHolder(View view, OnItemClickListener listener) {
        mView = view;
        mListener = listener;

        mTextViewTitle = (TextView) view.findViewById(R.id.text_view_title);
        mTextViewAverage = (TextView) view.findViewById(R.id.text_view_average);
        mTextViewYear = (TextView) view.findViewById(R.id.text_view_year);
        mTextViewCategory = (TextView) view.findViewById(R.id.text_view_category);

    }

    public void onBindViewHolder(Movie movie) {
        mMovie = movie;

        mTextViewTitle.setText(mMovie.getTitle());
        mTextViewAverage.setText(String.valueOf(mMovie.getAverage()));
        mTextViewYear.setText(String.valueOf(mMovie.getYear()));
        mTextViewCategory.setText(mMovie.getCategory());

        mView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (mListener != null) {
            mListener.onItemClick(view, mMovie);
        }
    }
}









