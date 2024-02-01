package com.panhacode;


import com.panhacode.model.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Query {
    Validation validation = new Validation();
    Scanner scanner = new Scanner(System.in);
    private int bookCount = 0;
    static int totalRow = 3;
    static int page = 1;

    private Book[] books = new Book[100];

    {
        books[0] = new Book("Panhala0", new Author("panha", "2023-Now"), LocalDate.of(2000, 1, 1));
        books[1] = new Book("Panhala1", new Author("panha", "2023-Now"), LocalDate.of(2000, 1, 1));
/*        books[2] = new Book("Panhala2", new Author("panha", "2023-Now"), LocalDate.of(2000, 1, 1));
        books[3] = new Book("Panhala3", new Author("panha", "2023-Now"), LocalDate.of(2000, 1, 1));*/

    }

    public Book[] getAllBooks() {
        return books;
    }

    public void writeBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();

        System.out.print("Enter Active: ");
        String active = scanner.nextLine();

        System.out.print("Enter published year (YYYY-MM-DD): ");
        LocalDate publishedYear = LocalDate.parse(scanner.nextLine());

        Book book = new Book(title, new Author(author, active), publishedYear);

        if (bookCount < books.length) {
            books[bookCount] = book;
            bookCount++;
            System.out.println("Book added successfully. Book ID: " + book.getId());
        } else {
            System.out.println("Maximum book limit reached. Cannot add more books.");
        }
    }

    public void deleteById() {
        int id = validation.getValidate("Input Stock's ID: ", "\\d+", 1,100, scanner);

        System.out.print("Enter book ID to delete: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Book bookToDelete = findBookById(bookId);
        if (bookToDelete != null) {
            // Shift the subsequent elements to the left
            for (int i = bookToDelete.getId() - 1; i < bookCount - 1; i++) {
                books[i] = books[i + 1];
            }
            bookCount--;

            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private Book findBookById(int bookId) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == bookId) {
                return books[i];
            }
        }
        return null;
    }
}
