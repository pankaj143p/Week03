package src.com.problems.search;

import java.util.*;
class FirstAndLast{
    public static int occuranceFind(int[] nums, int target, boolean isFirst) {
        int idx=-1;
        int i=0,j=nums.length-1;
        while(i<=j){
            int k=i+(j-i)/2;
            if(target<nums[k]){
                j=k-1;
            }else if(nums[k]<target){
                i=k+1;
            }else{
                idx=k;
                if(isFirst){
                    j=k-1;
                }else{
                    i=k+1;
                }
            }

        }

        return idx;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        int tar=sc.nextInt();
        int ans[]=new int[2];
        ans[0]=occuranceFind(arr,tar,true);
        ans[1]=occuranceFind(arr,tar,false);
        System.out.println(ans[0]+" "+ans[1]);
    }
}