package com.soap.testpickerview.models;

import androidx.annotation.NonNull;

public class BuildingModel {
    private final String name;
    private final String id;

    public BuildingModel( String id , String name ){
        this.name = name;
        this.id = id;
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
        return this.getName();
    }
}
