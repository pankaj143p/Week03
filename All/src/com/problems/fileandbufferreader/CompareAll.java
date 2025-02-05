package src.com.probles.fileandbufferreader;
import java.io.*;
import java.util.Scanner;

public class CompareAll {

    public static void main(String[] args) {
        // Step 1: StringBuilder and StringBuffer Comparison

        long startTime, endTime;
        // List of strings to concatenate
        String str = "Capgemini ";
        // StringBuilder Test
        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append(str);
        }
        endTime = System.nanoTime();
        long sbTime = endTime - startTime;
        System.out.println("Time taken by StringBuilder: " + sbTime + " nanoseconds");
        // StringBuffer Test
        startTime = System.nanoTime();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sf.append(str);
        }
        endTime = System.nanoTime();
        long sfTime = endTime - startTime;
        System.out.println("Time taken by StringBuffer: " + sfTime + " nanoseconds");
        // check which is faster
        if(sfTime<sbTime){
            System.out.println("stringbuffer takes less time : ");
        }else if(sfTime>sbTime){
            System.out.println("stringbuilder takes less time : ");
        }else{
            System.out.println("both takes equals time : ");
        }
        // Step 2: FileReader and InputStreamReader Word Count Comparison
        String filePath = "myfile.txt"; // Replace with the path to your large file (100MB)
        // Reading file using FileReader
        try {
            startTime = System.nanoTime();
            int wordCountFileReader = countWordsWithFileReader(filePath);
            endTime = System.nanoTime();
            long frTime = endTime - startTime;
            System.out.println("Time taken by FileReader to count words: " + frTime + " nanoseconds");
            System.out.println("Word count using FileReader: " + wordCountFileReader);
        } catch (IOException e) {
            System.err.println("Error reading file with FileReader: " + e.getMessage());
        }
        // Reading file using InputStreamReader
        try {
            startTime = System.nanoTime();
            int wordCountInputStreamReader = countWordsWithInputStreamReader(filePath);
            endTime = System.nanoTime();
            long isrTime = endTime - startTime;
            System.out.println("Time taken by InputStreamReader to count words: " + isrTime + " nanoseconds");
            System.out.println("Word count using InputStreamReader: " + wordCountInputStreamReader);
        } catch (IOException e) {
            System.err.println("Error reading file with InputStreamReader: " + e.getMessage());
        }
    }
    // Count words using FileReader
    public static int countWordsWithFileReader(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int wordCount = 0;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount+=words.length;
        }
        // close bufferedreader
        br.close();
        return wordCount;
    }

    // Count words using InputStreamReader
    public static int countWordsWithInputStreamReader(String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line;
        // intilize wordcount variables for count number of words
        int wordCount = 0;

        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }

        br.close();
        return wordCount;
    }
}
