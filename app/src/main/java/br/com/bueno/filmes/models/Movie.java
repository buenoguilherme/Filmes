package br.com.bueno.filmes.models;

import java.io.Serializable;

/**
 * Created by guibueno on 21/10/17.
 */

public class Movie implements Serializable {

    private int imageResource;
    private String title;
    private Double average;
    private int year;
    private String category;
    private String summary;

    public Movie(int imageResource, String title, Double average, int year, String category, String summary) {
        this.imageResource = imageResource;
        this.title = title;
        this.average = average;
        this.year = year;
        this.category = category;
        this.summary = summary;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
