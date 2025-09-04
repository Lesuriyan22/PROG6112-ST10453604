/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

public class ReferenceBook extends Book {
    private String subject;

    public ReferenceBook(String title, String author, String isbn, String subject) {
        super(title, author, isbn);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Subject: " + subject + " (Reference)";
    }
}