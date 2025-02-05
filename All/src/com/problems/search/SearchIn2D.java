package src.com.problems.search;
import java.util.*;
class SearchIn2d{
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
        int l=0,r=n*m-1;

        boolean f=false;
           while(l<=r){
               int mid=l+(r-l)/2;
               int rw=mid/m;
               int cl=mid%m;
               if(arr[rw][cl]==key){
                   f=true;
                   System.out.println("Element found : ");
                   break;
               }else if(arr[rw][cl]>key){
                   r=mid-1;
               }else{
                   l=mid+1;
               }
           }
           if(!f){
               System.out.println("Element Not found");
           }

    }
}