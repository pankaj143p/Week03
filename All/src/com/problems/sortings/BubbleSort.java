package src.com.problems.sortings;

import java.util.Scanner;

public class BubbleSort {
    private static void bubbleSort(int arr[]){
        int n=arr.length;
        for(int i=0; i<n; i++){
           int j=i;
           while(j<n){
            if(arr[i]<arr[j]){
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
             }
        j++;
           }
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
        bubbleSort(arr);
        printArr(arr);
        sc.close();
    }
}
