package com.mymicro.microservice.model.rawgModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Game {
    int id;
    String name;

    String background_image;

    Platforms[] parent_platforms;

    int metacritic ;

    int rating_top;

    public int getRating_top() {
        return rating_top;
    }

    public void setRating_top(int rating_top) {
        this.rating_top = rating_top;
    }

    public int getMetacritic() {
        return metacritic;
    }

    public void setMetacritic(int metacritic) {
        this.metacritic = metacritic;
    }

    public Platforms[] getParent_platforms() {
        return parent_platforms;
    }

    public void setParent_platforms(Platforms[] parent_platforms) {
        this.parent_platforms = parent_platforms;
    }

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
