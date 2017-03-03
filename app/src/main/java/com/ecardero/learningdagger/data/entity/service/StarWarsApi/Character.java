package com.ecardero.learningdagger.data.entity.service.StarWarsApi;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dagger.internal.Preconditions;

public class Character {

    private UUID id;
    private String name;
    private String side;
    private String imageUrl;
    private int imageResource;
    private List<Character> charactersKilled;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public void setCharactersKilled(List<Character> charactersKilled) {
        Preconditions.checkNotNull(charactersKilled);
        this.charactersKilled = charactersKilled;
    }

    public void addCharacterKilled(Character character){
        if(this.charactersKilled == null)
            this.charactersKilled = new ArrayList<>();

        this.charactersKilled.add(character);
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSide() {
        return side;
    }

    public List<Character> getCharactersKilled() {
        return charactersKilled;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getImageResource() {
        return imageResource;
    }
}
