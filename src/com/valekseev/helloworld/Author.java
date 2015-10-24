package com.valekseev.helloworld;


import java.util.HashSet;
import java.util.Set;

public class Author {

    private Long authorId;
    private String firstName;
    private String lastName;
    private Integer age;

    private Set emailAddresses = new HashSet();
    private Set books = new HashSet();


    public Author(){

        this.firstName = "";
        this.lastName = "";
        this.age = 0;
    }

    public Author(String firstName, String lastName, Integer age){

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getAuthorId() {
        return authorId;
    }

    private void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(Set emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public Set getBooks() {
        return books;
    }

    public void setBooks(Set books) {
        this.books = books;
    }

    @Override
    public String toString(){
      return "Author name - " + firstName + " " + lastName + "; age - " +  age + "; id = " + authorId  + "; books = " + books.size();

    }

    public String toFullString(){
        return "Author name - " + firstName + " " + lastName + "; age - " +  age + "; e-mails - "+ emailAddresses.toString() +"; id = " + authorId;

    }

}
