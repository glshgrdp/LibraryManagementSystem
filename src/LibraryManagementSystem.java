import java.util.ArrayList;
import java.util.Scanner;

// Book class representing a book in the library
class Book {
    String title;
    String isbn;
    String author;
    boolean isBorrowed;

    // Constructor to initialize book details
    Book(String title, String isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.isBorrowed = false;
    }

    // Method to get the status of the book
    public String getStatus() {
        return isBorrowed ? "Borrowed" : "Available";
    }
}

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            // Display menu options
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewBooks();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    // Method to add a new book to the library
    private static void addBook() {
        System.out.print("Enter the book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        books.add(new Book(title, isbn, author));
        System.out.println("Book successfully added.");
    }

    // Method to display all books in the library
    private static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }
        System.out.println("Books in the Library:");
        for (Book book : books) {
            System.out.println("- " + book.title + " by " + book.author + " (ISBN: " + book.isbn + ") - Status: " + book.getStatus());
        }
    }

    // Method to search for a book by title
    private static void searchBook() {
        System.out.print("Enter the title of the book to search: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book.title + " by " + book.author + " (ISBN: " + book.isbn + ") - Status: " + book.getStatus());
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Method to borrow a book
    private static void borrowBook() {
        System.out.print("Enter the title of the book to borrow: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.isBorrowed) {
                    System.out.println("Sorry, this book is already borrowed.");
                } else {
                    book.isBorrowed = true;
                    System.out.println("You have successfully borrowed the book.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    // Method to return a borrowed book
    private static void returnBook() {
        System.out.print("Enter the title of the book to return: ");
        String title = scanner.nextLine();
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.isBorrowed) {
                    book.isBorrowed = false;
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("This book was not borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
