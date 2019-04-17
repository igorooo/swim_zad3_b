package com.example.swim_zad3_b;

import com.example.swim_zad3_b.R;

public class Film {

    private String Title,Director;
    private int Rating;
    private Boolean isColored, withSound;

    public Film(String Title, String Director, int Rating, Boolean isColored, Boolean withSound){
        this.Title = Title;
        this.Director = Director;
        this.Rating = Rating;
        this.isColored = isColored;
        this.withSound = withSound;
    }

    public String getTitle() {
        return Title;
    }

    public String getDirector() {
        return Director;
    }

    public String getRating() {
        return Integer.toString(Rating) + "/5";
    }

    public Boolean getC(){
        return isColored;
    }
    public Boolean getS(){
        return withSound;
    }

    public int getR(){
        return Rating;
    }

    public String getColored() {
        if(this.isColored){
            return "Colored";
        }
        return "Black n white";
    }
    public String getWithSound() {
        if(withSound){
            return "with sound";
        }
        return "no sound";
    }
}
