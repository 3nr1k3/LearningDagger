package com.ecardero.learningdagger.data.entity.service.StarWarsApi;

import java.util.UUID;

public class Image {
    private UUID id;
    private String url;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
