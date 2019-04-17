package com.example.swim_zad3_b;

public class Book {

    private String Author, Title, Type;

    public Book(String Title, String Author, String Type){
        this.Author = Author;
        this.Title = Title;
        this.Type = Type;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public String getType() {
        return Type;
    }

    @Override
    public String toString() {
        return Title + "  ~" + Author + "  ["+Type +"]" ;
    }
}
