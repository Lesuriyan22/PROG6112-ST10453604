/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package library;

import java.util.Scanner;

public class LibraryApp1 {
    private static Book[] books = new Book[10]; // array for books
    private static LibraryMember[] members = new LibraryMember[5]; // array for members
    private static int bookCount = 0;
    private static int memberCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        // Sample data
        books[bookCount++] = new Novel("1984", "George Orwell", "12345", "Dystopian");
        books[bookCount++] = new ReferenceBook("Physics 101", "Isaac Newton", "67890", "Science");
        members[memberCount++] = new LibraryMember("Alice", "M001");

        while (running) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display all books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(option) {
                case 1:
                    displayBooks();
                    break;
                case 2:
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowIsbn = sc.nextLine();
                    borrowBook(borrowIsbn);
                    break;
                case 3:
                    System.out.print("Enter ISBN to return: ");
                    String returnIsbn = sc.nextLine();
                    returnBook(returnIsbn);
                    break;
                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }

    public static void displayBooks() {
        System.out.println("\nLibrary Book Report:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i].getDetails());
        }
    }

    public static void borrowBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i].borrowBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void returnBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i].returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}