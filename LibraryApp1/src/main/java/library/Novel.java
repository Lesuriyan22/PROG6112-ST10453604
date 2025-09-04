/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

public class Novel extends Book {
    private String genre;

    public Novel(String title, String author, String isbn, String genre) {
        super(title, author, isbn);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + " | Genre: " + genre;
    }
}
