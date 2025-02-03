package src.com.problems.library;
class BookLibrary {
    private BookNode head = null;  // Head of the list
    private BookNode tail = null;  // Tail of the list

    // Add a new book at the beginning
    public void addBeginning(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a new book at the end
    public void addEnding(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookId, availabilityStatus);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add a new book at a specific position
    public void addAtPosition(String bookTitle, String author, String genre, int bookId, boolean availabilityStatus, int position) {
        BookNode newBook = new BookNode(bookTitle, author, genre, bookId, availabilityStatus);
        if (position == 0) {
            addBeginning(bookTitle, author, genre, bookId, availabilityStatus);
            return;
        }

        BookNode curr = head;
        int count = 0;
        while (curr != null && count < position - 1) {
            curr = curr.next;
            count++;
        }

        if (curr == null) {
            System.out.println("Position out of bounds. Adding book at the end.");
            addEnding(bookTitle, author, genre, bookId, availabilityStatus);
        } else {
            newBook.next = curr.next;
            newBook.prev = curr;
            if (curr.next != null) {
                curr.next.prev = newBook;
            }
            curr.next = newBook;
        }
    }

    // Remove a book by Book ID
    public void removeByBookId(int bookId) {
        BookNode curr = head;
        while (curr != null) {
            if (curr.bookId == bookId) {
                if (curr == head) {
                    head = curr.next;
                    if (head != null) head.prev = null;
                } else if (curr == tail) {
                    tail = curr.prev;
                    if (tail != null) tail.next = null;
                } else {
                    curr.prev.next = curr.next;
                    if (curr.next != null) curr.next.prev = curr.prev;
                }
                return;
            }
            curr = curr.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Search for a book by Book Title
    public BookNode searchByBookTitle(String bookTitle) {
        BookNode curr = head;
        while (curr != null) {
            if (curr.bookTitle.equalsIgnoreCase(bookTitle)) {
                return curr;
            }
            curr = curr.next;
        }
        System.out.println("Book with title \"" + bookTitle + "\" not found.");
        return null;
    }

    // Search for a book by Author
    public BookNode searchByAuthor(String author) {
        BookNode curr = head;
        while (curr != null) {
            if (curr.author.equalsIgnoreCase(author)) {
                return curr;
            }
            curr = curr.next;
        }
        System.out.println("Book by author \"" + author + "\" not found.");
        return null;
    }

    // Update the availability status of a book
    public void updateAvailabilityStatus(int bookId, boolean newAvailabilityStatus) {
        BookNode curr = head;
        while (curr != null) {
            if (curr.bookId == bookId) {
                curr.availabilityStatus = newAvailabilityStatus;
                return;
            }
            curr = curr.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Display all books in forward order
    public void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode curr = head;
        while (curr != null) {
            System.out.println("Book ID: " + curr.bookId + ", Title: " + curr.bookTitle +
                               ", Author: " + curr.author + ", Genre: " + curr.genre +
                               ", Availability: " + (curr.availabilityStatus ? "Available" : "Checked-out"));
            curr = curr.next;
        }
    }

    // Display all books in reverse order
    public void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode curr = tail;
        while (curr != null) {
            System.out.println("Book ID: " + curr.bookId + ", Title: " + curr.bookTitle +
                               ", Author: " + curr.author + ", Genre: " + curr.genre +
                               ", Availability: " + (curr.availabilityStatus ? "Available" : "Checked-out"));
            curr = curr.prev;
        }
    }

    // Count the total number of books in the library
    public int countBooks() {
        int count = 0;
        BookNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}

