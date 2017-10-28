package br.com.bueno.filmes.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by guibueno on 21/10/17.
 */

public class Movie implements Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("vote_average")
    private Double average;

    @SerializedName("genre_ids")
    private List<Integer> categories;

    @SerializedName("overview")
    private String overview;

    @SerializedName("backdrop_path")
    private String imagePath;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public List<Integer> getCategories() {
        return categories;
    }

    public void setCategories(List<Integer> categories) {
        this.categories = categories;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
