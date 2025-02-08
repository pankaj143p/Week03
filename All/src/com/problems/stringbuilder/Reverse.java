package src.com.problems.stringbuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Reverse{

    // function for reverse string using string builder
    private static StringBuilder reverse(String str){
        return new StringBuilder(str).reverse();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        System.out.println("String after reverse : "+reverse(str));
    }
}