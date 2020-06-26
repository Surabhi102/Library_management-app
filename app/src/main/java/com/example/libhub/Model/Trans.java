package com.example.libhub.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trans {
    @SerializedName("Bookid")
    @Expose
    private String bookid;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Due Date")
    @Expose
    private String dueDate;

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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
