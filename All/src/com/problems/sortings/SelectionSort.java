package src.com.problems.sortings;
import java.util.Scanner;

public class SelectionSort {
            private static void selectionSort(int arr[]){
                int n=arr.length;
                for(int i=0; i<n; i++){
                 int mn=arr[i];
                 int idx=i;
                 int j=i;
                 while(j<n){
                     if(mn>arr[j]){
                        mn=arr[j];
                        idx=j;
                     }
                     j++;
                  }
                  int temp=arr[i];
                  arr[i]=arr[idx];
                  arr[idx]=temp;
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
                selectionSort(arr);
                printArr(arr);
                sc.close();
            }
        }
        
    