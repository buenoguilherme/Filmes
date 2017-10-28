package br.com.bueno.filmes.services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import br.com.bueno.filmes.R;
import br.com.bueno.filmes.models.Results;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by guibueno on 28/10/17.
 */

public class MovieService {

    private static String BASE_URL = "https://api.themoviedb.org/3/";
    private static String API_KEY = "45d473a23f53a0090642e3cd68af6882";
    private static String LANGUAGE = "pt-BR";

    private static OkHttpClient client = new OkHttpClient();

    private static String query() {
        return "?api_key="
                .concat(API_KEY)
                .concat("&language=")
                .concat(LANGUAGE);
        // ?api_key=2789eddh982d2&language=pt-BR
    }

    private static String getUrl(String endPoint) {
        return BASE_URL
                .concat(endPoint)
                .concat(query());
        // https://api.themoviedb.org/3/movie?api_key=2789eddh982d2&language=pt-BR
    }

    public static Results getPopularMovies(int page) throws IOException {
        String urlDoServico = getUrl("movie/popular")
                .concat("&page=")
                .concat(String.valueOf(page));

        Request request = new Request.Builder()
                .url(urlDoServico)
                .build();

        Response response = client.newCall(request).execute();
        String stringJson = response.body().string();

        Results movieList = null;

        if (response.isSuccessful()) {
            Type listType = new TypeToken<Results>(){}.getType();
            movieList = new Gson().fromJson(stringJson, listType);
        }

        return movieList;
    }

}
