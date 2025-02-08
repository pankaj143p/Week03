package src.com.problems.search;

import java.util.*;
class FirstAndLast{
        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public static int firstMissingPositive(int[] nums) {
            int n = nums.length;

            // Place each positive integer i at index i-1 if possible
            for (int i = 0; i < n; i++) {
                while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                }
            }

            // Find the first missing positive integer
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            // If all positive integers from 1 to n are present, return n + 1
            return n + 1;
        }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
//        int tar=sc.nextInt();
        int ans[]=new int[2];
        System.out.println(firstMissingPositive(arr));
    }
}