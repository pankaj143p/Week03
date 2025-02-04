package src.com.probles.linear;
import java.util.Scanner;

class SearchInSentence{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        // take a 2d string array
        String sentences[][]=new String[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                String word=sc.next();
                sentences[i][j]=sc.next();
            }
        }
        // take a word from user
        System.out.println("Enter word which you want to find");
        String word=sc.next();
        // declare boolean variable for checking word is found or not
        boolean isFound=false;
        // itrate for finding word if present
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               if(sentences[i][j].equals(word)){
                   isFound=true;
                   System.out.println("word found in sentence : "+(i+1));
                   break;
               }
            }
        }
        if(!isFound){
            System.out.println("not found");
        }
    }
}