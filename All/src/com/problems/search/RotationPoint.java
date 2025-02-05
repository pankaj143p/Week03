package src.com.problems.search;
import java.util.*;
class RotationPoint{
    // function to find min using binary search
    public static int minEle(int arr[]){
        int i=0,j=arr.length-1;
        while(i<=j){
            int m=i+(j-i)/2;
            // search in left part
            if(arr[m]>arr[j]){
                i=m+1;
                // in right part
            }else if(arr[m]<arr[i]){
                j=m;
            }else{
                return arr[i];
            }
        }
        return arr[0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(minEle(arr));
    }
}