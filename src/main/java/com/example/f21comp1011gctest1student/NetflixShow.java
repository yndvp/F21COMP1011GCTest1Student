package com.example.f21comp1011gctest1student;

import java.util.Arrays;
import java.util.List;

public class NetflixShow {
    private String showId;
    private String type;
    private String title;
    private String rating;
    private String director;
    private String cast;

    public NetflixShow(String showId, String type, String title, String rating, String director, String cast) {
        setShowId(showId);
        setType(type);
        setTitle(title);
        setRating(rating);
        setDirector(director);
        setCast(cast);
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        if (showId.matches("[s]\\d*"))
            this.showId = showId;
        else
            throw new IllegalArgumentException("The showId should be a String that starts with ‘s’ followed by any number of digits");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type == "Movie" || type == "TV Show")
            this.type = type;
        else
            throw new IllegalArgumentException("The type should be one of the following String’s “Movie” or “TV Show”");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.matches(".*[a-zA-Z].*[a-zA-Z].*"))
            this.title = title;
        else
            throw new IllegalArgumentException("The title should be a String that holds at least 2 characters");
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        List<String> validRatings = Arrays.asList("PG-13","R","TV-14","TV-G","TV-MA","TV-Y","TV-Y7");
        if (validRatings.contains(rating))
            this.rating = rating;
        else
            throw new IllegalArgumentException(String.format("%s is invalid, choose from %s",rating,
                    validRatings));
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        if (director.matches(".*[a-zA-Z].*[a-zA-Z].*"))
            this.director = director;
        else
            throw new IllegalArgumentException("The director should be a String that holds at least 2 characters");
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        if (cast.matches(".*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*[a-zA-Z].*"))
            this.cast = cast;
        else
            throw new IllegalArgumentException("The cast should be a String that holds at least 5 characters");
    }
}
