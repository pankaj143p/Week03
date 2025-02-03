package src.com.problems.library;

public class LibraryManagement {
    public static void main(String[] args) {
        BookLibrary library = new BookLibrary();

        // Add books to the library
        library.addBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Novel", 101, true);
        library.addEnding("To Kill a Mockingbird", "Harper Lee", "Fiction", 102, true);
        library.addEnding("1984", "George Orwell", "Dystopian", 103, false);
        library.addAtPosition("Pride and Prejudice", "Jane Austen", "Romance", 104, true, 1);

        // Display all books in forward order
        System.out.println("Books in Library (Forward Order):");
        library.displayForward();

        // Search for a book by title
        BookNode foundBook = library.searchByBookTitle("1984");
        if (foundBook != null) {
            System.out.println("\nFound Book: " + foundBook.bookTitle + " by " + foundBook.author);
        }

        // Update availability status
        library.updateAvailabilityStatus(103, true); // Update availability of book ID 103

        // Remove a book by Book ID
        library.removeByBookId(102);

        // Display all books in reverse order
        System.out.println("\nBooks in Library (Reverse Order):");
        library.displayReverse();

        // Count the total number of books in the library
        System.out.println("\nTotal number of books in library: " + library.countBooks());
    }
}
