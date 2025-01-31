package src.com.problems.sortings;
import java.util.Scanner;

public class InsertionSort {
        private static void insertionSort(int arr[]){
            int n=arr.length;
            for(int i=1; i<n; i++){
               int j=i-1;
               int temp=arr[i];
               while(j>=0 && temp<=arr[j]){
                arr[j+1]=arr[j];
                j--;
               }
               arr[j+1]=temp;
            }
        }
        public static void printArr(int arr[]){
            for(int ii : arr){
                System.out.print(ii+" ");
            }
            System.out.println();
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0; i<n ;i++){
                int ele=sc.nextInt();
                arr[i]=ele;
            }
            insertionSort(arr);
            printArr(arr);
            sc.close();
        }
    }
    
