package src.com.problems.search;
import java.util.*;
class BinarySearch{
    // function to find min using binary search
    public static int minEle(int arr[],int key){
        int i=0,j=arr.length-1;
        while(i<=j){
            int m=i+(j-i)/2;
            // search in left part
            if(arr[m]==key){
               return m;
                // in right part
            }else if(arr[m]>key){
                j=m-1;
            }else{
                i=m+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int key=sc.nextInt();
        System.out.println(minEle(arr,key));
    }
}