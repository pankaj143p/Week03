package src.com.problems.stringbuffer;
import java.util.*;
class Concate{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        String arr[]=new String[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.next();
        }
        StringBuffer sf=new StringBuffer();
        for(String str : arr){
            sf.append(str);
        }
        System.out.println("String of Array : "+sf.toString());
    }
}