package src.com.problems.movie;
// create a class MovieNodeNode with head

class Movie {

    // Add at beginning
    void addBeginning(MovieNode newMovie) {
        MovieNode newMov = new MovieNode(newMovie.title, newMovie.director, newMovie.yearOfRelease, newMovie.rating);
        newMov.next = head;
        newMov.prev = null;
        if (head != null) {
            head.prev = newMov;
        }
        head = newMov;
    }

    // Add at end
    void addEnding(MovieNode newMovie) {
        MovieNode newMov = new MovieNode(newMovie.title, newMovie.director, newMovie.yearOfRelease, newMovie.rating);
        newMov.next = null;

        if (head == null) {
            newMov.prev = null;
            head = newMov;
            return;
        }

        MovieNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newMov;
        newMov.prev = curr;
    }

    // Add at a specific position
    void addAtPosition(int pos, MovieNode newMovie) {
        if (pos == 0) {
            addBeginning(newMovie);
            return;
        }

        MovieNode newMov = new MovieNode(newMovie.title, newMovie.director, newMovie.yearOfRelease, newMovie.rating);
        MovieNode curr = head;

        while (pos-- > 1 && curr != null) {
            curr = curr.next;
        }

        if (curr == null) {
            System.out.println("Position out of range.");
        } else {
            newMov.next = curr.next;
            if (curr.next != null) {
                curr.next.prev = newMov;
            }
            curr.next = newMov;
            newMov.prev = curr;
        }
    }

    // Search for a movie by title
    void searchByTitle(String title) {
        MovieNode curr = head;
        while (curr != null) {
            if (curr.title.equals(title)) {
                System.out.println("Movie found: Title: " + curr.title + ", Director: " + curr.director + ", Year: " + curr.yearOfRelease + ", Rating: " + curr.rating);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Movie not found by title: " + title);
    }

    // Search for a movie by director
    void searchByDirector(String director) {
        MovieNode curr = head;
        while (curr != null) {
            if (curr.director.equals(director)) {
                System.out.println("Movie found by Director: " + curr.title + ", Year: " + curr.yearOfRelease + ", Rating: " + curr.rating);
            }
            curr = curr.next;
        }
    }

    // Search for a movie by rating
    void searchByRating(int rating) {
        MovieNode curr = head;
        while (curr != null) {
            if (curr.rating == rating) {
                System.out.println("Movie found by Rating: " + curr.title + ", Director: " + curr.director + ", Year: " + curr.yearOfRelease);
            }
            curr = curr.next;
        }
    }

    // Update movie rating by title
    void updateRating(String title, int newRating) {
        MovieNode curr = head;
        while (curr != null) {
            if (curr.title.equals(title)) {
                curr.rating = newRating;
                System.out.println("Updated rating for " + title + " to " + newRating);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Movie not found by title: " + title);
    }

    // Display all movie records in forward order
    void displayForward() {
        MovieNode curr = head;
        while (curr != null) {
            System.out.println("Title: " + curr.title + ", Director: " + curr.director + ", Year: " + curr.yearOfRelease + ", Rating: " + curr.rating);
            curr = curr.next;
        }
    }

    // Display all movie records in reverse order
    void displayReverse() {
        if (head == null) {
            return;
        }
        
        MovieNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        while (curr != null) {
            System.out.println("Title: " + curr.title + ", Director: " + curr.director + ", Year: " + curr.yearOfRelease + ", Rating: " + curr.rating);
            curr = curr.prev;
        }
    }

    // Delete movie by title
    void deleteByTitle(String title) {
        MovieNode curr = head;
        
        if (curr != null && curr.title.equals(title)) {
            head = curr.next;
            if (head != null) {
                head.prev = null;
            }
            return;
        }

        while (curr != null && curr.next != null) {
            if (curr.next.title.equals(title)) {
                curr.next = curr.next.next;
                if (curr.next != null) {
                    curr.next.prev = curr;
                }
                return;
            }
            curr = curr.next;
        }

        System.out.println("Movie not found by title: " + title);
    }


    private MovieNode head;

    Movie() {
        this.head = null;
    }

    // addBegning
    void addBegning(MovieNode s1) {

        MovieNode newMov = new MovieNode(s1.title, s1.director, s1.yearOfRelease, s1.rating);
        newMov.next = head;
        newMov.prev=null;
        if(head!=null){
            head.next=newMov;
        }
        head = newMov;
    }

    // print all MovieNodes record
    void atPosition(int pos, MovieNode s1) {
        MovieNode newMov = new MovieNode(s1.title, s1.director, s1.yearOfRelease, s1.rating);
        if (pos == 0) {
            addBegning(s1);
            return;
        }

        MovieNode curr = head;
        MovieNode temp = null;

        pos = pos - 1;
        while (pos-- > 1) {
            if (curr != null) {
                curr = curr.next;
            }
        }
        if (curr == null) {
            System.out.println("please give position in range of MovieNodes : ");
        } else {
            temp = curr.next;
            curr.next=newMov;
            newMov.next=temp;
            newMov.prev=curr;
        }
        // return head;
    }

    // search MovieNode record by title
    void search(String title) {
        MovieNode curr = head;
        while (curr != null) {
            if (curr.title.equals(title)) {
                System.out.println("title: " + curr.title + "\n" + " director: " + curr.director+"is present in the list");
                return;
            }
            curr = curr.next;
        }
        System.out.println("MovieNode not found");
    }

    // update MovieNode rating by title
    void updaterating(String title, char rating) {
        MovieNode curr = head;
        while (curr != null) {
            if (curr.title.equals(title)) {
                curr.rating = rating;
                return;
            }
            curr = curr.next;
        }
        System.out.println("MovieNode not found");
    }


    // display all MovieNodes record
    void dispaly() {
        MovieNode curr = head;

        while (curr != null) {
            System.out.println("title: " + curr.title + "\n" + " director: " + curr.director + "\n" + " yearOfRelease: "
                    + curr.yearOfRelease + "\n" + " rating: " + curr.rating);

            System.out.println("-------------------------------------------------------------------------");
            curr = curr.next;
        }
    }

    // delete MovieNode record by title
    void delete(String title) {
        MovieNode curr=head;

        if(curr.title.equals(title)){

            head=curr.next;
            return;
        }
        while(curr.next!=null){
            if(curr.next.title.equals(title)){
                curr.next=curr.next.next;
                return;
            }
            curr=curr.next;
        }
    }
}