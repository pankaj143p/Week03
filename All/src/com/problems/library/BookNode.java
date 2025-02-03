package src.com.problems.library;

class BookNode {
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus; 
    BookNode prev;
    BookNode next;

    // Constructor
    public BookNode(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.prev = null;
        this.next = null;
    }
}
