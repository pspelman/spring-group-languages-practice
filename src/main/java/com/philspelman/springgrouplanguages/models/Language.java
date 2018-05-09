package com.philspelman.springgrouplanguages.models;


import javax.validation.constraints.Size;

public class Language {
    @Size(min = 2)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCurrentVersion() {
        return currentVersion;
    }

    public void setCurrentVersion(String currentVersion) {
        this.currentVersion = currentVersion;
    }

    @Size(min = 2)

    private String creator;

    @Size(min = 2)
    private String currentVersion;

    public Language() {

    }


    public Language(String name, String creator, String currentVersion) {
        this.name = name;
        this.creator = creator;
        this.currentVersion = currentVersion;
    }

    public String getLanguage() {
        return name;}

    @Override
    public String toString() {
        return String.format("Language: %s | Creator: %s | V: %s", this.name, this.creator, this.currentVersion);
    }


}


