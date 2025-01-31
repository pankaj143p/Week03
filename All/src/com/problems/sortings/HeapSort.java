package src.com.problems.sortings;

import java.util.Scanner;

public class HeapSort {
    public static void heapSort(int arr[], int idx, int n){
        int left=idx*2+1;
        int right=idx*2+2;
        int li=idx;
        if(left<n && arr[left]>arr[li]){
            li=left;
        }

        if(right<n && arr[right]>arr[li]){
            li=right;
        }

        if(li!=idx){
            int temp=arr[li];
            arr[li]=arr[idx];
            arr[idx]=temp;
            heapSort(arr, li, n);
        }
    }
    public static void createHeap(int arr[], int n){
        int start=(n/2)-1;
        for(int i=start; i>=0; i--){
            heapSort(arr,i,n);
        }
        for(int i=n-1; i>=0; i--){
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapSort(arr, 0, i);
        } 
    }
    public static void printArr(int arr[]){
        System.out.println("Sorted Heap for given array : ");
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
                createHeap(arr,n);
                printArr(arr);
                sc.close();
      }
}
