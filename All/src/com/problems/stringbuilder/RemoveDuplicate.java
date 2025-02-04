package src.com.problems.stringbuilder;
import java.util.*;
class RemoveDuplicate{
    private static StringBuilder removeDuplicate(String str){
        HashSet<Character> hs = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : str.toCharArray()){
            hs.add(ch);

        }
        for(char ch : hs){
            sb.append(ch);
        }
        return sb;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println("string after removing duplicate : "+removeDuplicate(str));
        sc.close();
    }
}