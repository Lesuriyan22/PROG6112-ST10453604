/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    // Getters and setters (information hiding)
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return isBorrowed; }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
        } else {
            System.out.println("Book already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
        } else {
            System.out.println("Book was not borrowed.");
        }
    }

    public String getDetails() {
        return title + " by " + author + " | ISBN: " + isbn + " | Status: " + (isBorrowed ? "Borrowed" : "Available");
    }
}