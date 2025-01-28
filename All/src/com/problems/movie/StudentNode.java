package src.com.problems.movie;

// create a class MovieNodeNode with head
class Movie {
    private MovieNode head;

    Movie() {
        this.head = null;
    }

    // addBegning
    void addBegning(MovieNode s1) {

        MovieNode newStu = new MovieNode(s1.title, s1.director, s1.yearOfRelease, s1.rating);
        if (head == null) {
            head = newStu;
        } else {
            newStu.next = head;
            head = newStu;
        }
    }
    // addEnding
    void addEnding(MovieNode s1) {
        MovieNode newStu = new MovieNode(s1.title, s1.director, s1.yearOfRelease, s1.rating);
        if (head == null) {
            head = newStu;
        } else {
            MovieNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newStu;
        }
    }

    // print all MovieNodes record
    void atPosition(int pos, MovieNode s1) {
        MovieNode newStu = new MovieNode(s1.title, s1.director, s1.yearOfRelease, s1.rating);
        if (pos == 0) {
            addBegning(s1);
            return;
        }

        MovieNode curr = head;
        pos = pos - 1;
        while (pos-- > 1) {
            if (curr != null) {
                curr = curr.next;
            }
        }
        if (curr == null) {
            System.out.println("please give position in range of MovieNodes : ");
        } else {
            MovieNode temp = curr.next;
            curr.next = newStu;
            newStu.next = temp;
        }
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