package com.baidu._04_Test;

public class Book implements Cloneable{
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // 浅克隆
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title='" + title + '\'' + ", author='" + author + '\'' + '}';
    }
}
