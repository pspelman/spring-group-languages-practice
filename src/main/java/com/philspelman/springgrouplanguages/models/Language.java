
package com.philspelman.springgrouplanguages.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

//DONE: make this an entity w/@Entity

@Entity
public class Language {

    //DONE: add an ID @Id & @GeneratedValue
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //DONE: make the attributes into columns
    @Column
    @Size(min = 2, max = 40)
    private String name;

    @Column
    @Size(min = 2, max = 100)
    private String creator;

    @Column
    @Size(min = 2, max = 30)
    private String currentVersion;

    //DONE: add createdAt Date() w/(updatable = false)
    //Prevent the createdAt column from being updated after it is created
    @Column(updatable = false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;




    //DONE: add updatedAt Date()
    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {return createdAt; }

    public void setCreateAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


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

    public Language() {
    }

    //something that should always happen BEFORE creating the object
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    //Add the @PreUpdate - associated code should ALWAYS happen before UPDATING the object
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


    public Language(String name, String creator, String currentVersion) {
        this.name = name;
        this.creator = creator;
        this.currentVersion = currentVersion;

        //DONE: add createdAt and updatedAt to the constructor
        onCreate();
        onUpdate();

        //fixed: onCreate();
        //fixed: onUpdate();

    }

    public String getLanguage() {
        return name;}

    @Override
    public String toString() {
        return String.format("Language: %s | Creator: %s | V: %s", this.name, this.creator, this.currentVersion);
    }



}


