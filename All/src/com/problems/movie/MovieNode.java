package src.com.problems.movie;
// create a class MovieNode with the following attributes: title, director, yearOfRelease, rating, next, prev
class MovieNode {
    String title;
    String director;
    int yearOfRelease;
    int rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String title, String director, int yearOfRelease, int rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}