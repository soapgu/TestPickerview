package com.soap.testpickerview.models;

import androidx.annotation.NonNull;

public class SpaceModel {
    private final String id;
    private final String name;

    public SpaceModel( String id , String name ){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return getName();
    }
}
