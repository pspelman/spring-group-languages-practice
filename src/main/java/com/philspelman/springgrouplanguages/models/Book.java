package com.philspelman.springgrouplanguages.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @Size(min = 3, max = 100)
    private String title;

    @Column
    @Size(min = 5, max = 400)
    private String description;

    @Column
    @Size(min = 3, max = 40)
    private String language;

    @Column
    @Min(30)
    private int numberOfPages;

    //Prevent the createdAt column from being updated after it is created
    @Column(updatable = false)
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;

    @Column
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createdAt;
    }

    public void setCreateAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    //something that should always happen BEFORE creating the object
    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    //something that should always happen before UPDATING the object
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }


    public Book() {
    }

    public Book(String title, String desc, String lang, int pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
        onCreate();
        onUpdate();
//        this.createdAt = new Date();
//        this.updatedAt = new Date();
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}