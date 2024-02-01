package Test;

import java.time.LocalDate;
import java.util.Scanner;

class Book {
    private static int nextId = 1;

    private int id;
    private String title;
    private Author author;
    private LocalDate publishedYear;
    private boolean status;

    public Book(String title, Author author, LocalDate publishedYear) {
        this.id = nextId++;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.status = true; // Assuming the default status is true (available)
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDate getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(LocalDate publishedYear) {
        this.publishedYear = publishedYear;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

class Author {
    private String name;
    private String activeYear;

    public Author() {}
    public Author(String name, String activeYear) {
        this.name = name;
        this.activeYear = activeYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActiveYear() {
        return activeYear;
    }

    public void setActiveYear(String activeYear) {
        this.activeYear = activeYear;
    }
}

public class ArrayObject {

    private static Book[] books = new Book[100];
    {
        books[0] = new Book("Panhala0", new Author("panha", "2023-Now"), LocalDate.of(2000, 1, 1));
        books[1] = new Book("Panhala1", new Author("panha", "2023-Now"), LocalDate.of(2000, 1, 1));
        books[2] = new Book("Panhala2", new Author("panha", "2023-Now"), LocalDate.of(2000, 1, 1));
        books[3] = new Book("Panhala3", new Author("panha", "2023-Now"), LocalDate.of(2000, 1, 1));
    }
    private static int bookCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                    updateBook(scanner);
                    break;
                case 3:
                    deleteBook(scanner);
                    break;
                case 4:
                    displayBooks();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private static void addBook(Scanner scanner) {
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

    private static void updateBook(Scanner scanner) {
        System.out.print("Enter book ID to update: ");
        int bookId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Book bookToUpdate = findBookById(bookId);
        if (bookToUpdate != null) {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();
            System.out.print("Enter author name: ");
            String author = scanner.nextLine();

            System.out.print("Enter Active: ");
            String active = scanner.nextLine();

            System.out.print("Enter published year (YYYY-MM-DD): ");
            LocalDate publishedYear = LocalDate.parse(scanner.nextLine());

            Book book = new Book(title, new Author(author, active), publishedYear);

            bookToUpdate.setTitle(title);
            bookToUpdate.setAuthor(new Author(author, active));
            bookToUpdate.setPublishedYear(publishedYear);

            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void deleteBook(Scanner scanner) {
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

    private static void displayBooks() {
        if (bookCount == 0) {
            System.out.println("No books found.");
        } else {
            System.out.println("List of Books:");

            for (int i = 0; i < bookCount; i++){
                Book book = books[i];
                System.out.println("Book ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor().getName());
                System.out.println("Published Year: " + book.getPublishedYear());
                System.out.println("Status: " + (book.getStatus() ? "Available" : "Not Available"));
                System.out.println("---------------------------");
            }
        }
    }

    private static Book findBookById(int bookId) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getId() == bookId) {
                return books[i];
            }
        }
        return null;
    }
}