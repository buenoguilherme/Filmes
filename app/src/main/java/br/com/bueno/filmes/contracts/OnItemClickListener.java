package br.com.bueno.filmes.contracts;

import android.view.View;

import br.com.bueno.filmes.models.Movie;

/**
 * Created by guibueno on 21/10/17.
 */

public interface OnItemClickListener {

    void onItemClick(View view, Movie movie);
}
