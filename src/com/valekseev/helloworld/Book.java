package com.valekseev.helloworld;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Book {

    private Long bookId;
    private String name;
    private Integer year;

    // авторы книги
    private Set authors = new HashSet();

    public Book() {
        this.name = "";
        this.year = 0;

    }

    public Book(String name, Integer year) {
        this.name = name;
        this.year = year;

    }

    public Set getAuthors() {
        return authors;
    }

    public void setAuthors(Set authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString(){
         return "Book name - " + name + "; issue year - " +  year + "; id = " + bookId  + "; authors = " + authors.size();
            }

    public String toString2(){
        String str = "Book name - " + name + "; issue year - " +  year + "; id = " + bookId  + "; authors = " + authors.size();

        Iterator<Author> it = authors.iterator();
        while(it.hasNext()){
            Author a = it.next();
           // str += "; Author name - " + a.getFirstName() + " " + a.getLastName();
            str += "; Author  - " + a.toString();
        }

        return str;
    }
}
