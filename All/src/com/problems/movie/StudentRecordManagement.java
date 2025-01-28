/*
 *  Doubly Linked List: Movie Management System
Problem Statement: Implement a movie management system using a doubly linked list. Each node will represent a movie and 
contain Movie Title, Director, Year of Release, and Rating. Implement the following functionalities:
Add a movie record at the beginning, end, or at a specific position.
Remove a movie record by Movie Title.
Search for a movie record by Director or Rating.
Display all movie records in both forward and reverse order.
Update a movie's Rating based on the Movie Title.
Hint:
Use a doubly linked list where each node has two pointers: one pointing to the next node and the other to the previous node.
Maintain pointers to both the head and tail for easier insertion and deletion at both ends.
For reverse display, start from the tail and traverse backward using the prev pointers.

 */
package src.com.problems.movie;
class MovieNodeRecordManagement {
    public static void main(String[] args) {
        Movie sn = new Movie();
        MovieNode s1 = new MovieNode("10hs", "Alice", 21, 'd');
        MovieNode s2 = new MovieNode("10s", "Alice1", 23, 'c');
        MovieNode s3 = new MovieNode("1011hs", "Alice3", 22, 'd');
        MovieNode s4 = new MovieNode("10hews", "Alice5", 26, 'a');
        MovieNode s5 = new MovieNode("10hsfsfs", "Alice6", 18, 'b');
        sn.addBegning(s1);
        sn.addBegning(s2);
        sn.addEnding(s3);
        sn.search("1011hs");
        sn.dispaly();
        sn.addBegning(s4);
        // sn.updateGrade("10hews", 3);
        sn.atPosition(2, s5);
        sn.dispaly();
        // System.out.println("-------------------------");
        sn.delete("10s");
        sn.dispaly();
    }

}
