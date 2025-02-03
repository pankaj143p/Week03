package src.com.problems.movie;
class MovieManagement {
    public static void main(String[] args) {
        Movie movieList = new Movie();

        // Adding some movies to the list
        movieList.addBeginning(new MovieNode("The Matrix", "Wachowski", 1999, 9));
        movieList.addEnding(new MovieNode("Inception", "Nolan", 2010, 8));
        movieList.addEnding(new MovieNode("The Dark Knight", "Nolan", 2008, 9));
        movieList.addEnding(new MovieNode("Interstellar", "Nolan", 2014, 8));

        // Displaying all movies in forward order
        System.out.println("Displaying movies in forward order:");
        movieList.displayForward();

        // Displaying all movies in reverse order
        System.out.println("\nDisplaying movies in reverse order:");
        movieList.displayReverse();

        // Searching for a movie by title
        movieList.searchByTitle("Inception");

        // Searching for a movie by director
        System.out.println("\nSearching by director (Nolan):");
        movieList.searchByDirector("Nolan");

        // Searching for a movie by rating
        System.out.println("\nSearching by rating (9):");
        movieList.searchByRating(9);

        // Updating a movie's rating
        movieList.updateRating("Inception", 10);

        // Deleting a movie by title
        movieList.deleteByTitle("The Dark Knight");

        // Displaying all movies after deletion
        System.out.println("\nDisplaying movies after deletion:");
        movieList.displayForward();
    }
}
