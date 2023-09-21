package com.mymicro.microservice.model.rawgModel;

import java.util.List;

public class GameProcessed {
    int id;
    String name;

    String background_image;
    List<Platform> parent_platforms;

    public GameProcessed(int id, String name, String background_image, List<Platform> parent_platforms) {
        this.id = id;
        this.name = name;
        this.background_image = background_image;
        this.parent_platforms = parent_platforms;
    }

    public List<Platform> getParent_platforms() {
        return parent_platforms;
    }

    public void setParent_platforms(List<Platform> parent_platforms) {
        this.parent_platforms = parent_platforms;
    }

    public GameProcessed() {
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

    public String getBackground_image() {
        return background_image;
    }

    public void setBackground_image(String background_image) {
        this.background_image = background_image;
    }




}
