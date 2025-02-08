package src.com.problems.search;
import java.util.*;
class SearchIn2d{
    // function for find any element in 2d array using binary search
    public static int search(int arr[][], int key){
        int n=arr.length;
        int m=arr[0].length;
        int l=0,r=n*m-1;

        boolean f=false;
        while(l<=r){
            int mid=l+(r-l)/2;
            int rw=mid/m;
            int cl=mid%m;
            if(arr[rw][cl]==key){
               return rw;
            }else if(arr[rw][cl]>key){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
     return -1;
    }
        public static void main(String []args){
           Scanner sc=new Scanner(System.in);
           int n=sc.nextInt();
           int m=sc.nextInt();
           int arr[][]=new int[n][m];
           for(int i=0; i<n; i++){
               for(int j=0; j<m; j++){
                   arr[i][j]=sc.nextInt();
               }
           }

        System.out.println("Enter key : ");
        int key=sc.nextInt();
        System.out.println(search(arr,key)==-1 ? "Not found : " : "Element Found");

    }
}