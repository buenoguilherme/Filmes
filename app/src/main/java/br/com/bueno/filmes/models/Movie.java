package br.com.bueno.filmes.models;

import java.io.Serializable;

/**
 * Created by guibueno on 21/10/17.
 */

public class Movie implements Serializable {

    private String title;
    private double average;
    private int year;
    private String category;

    public Movie() {
    }

    public Movie(String title, double average, int year, String category) {
        this.title = title;
        this.average = average;
        this.year = year;
        this.category = category;
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
