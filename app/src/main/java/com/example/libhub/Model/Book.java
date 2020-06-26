package com.example.libhub.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("Bookid")
    @Expose
    private String bookid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("author")
    @Expose
    private String author;

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
