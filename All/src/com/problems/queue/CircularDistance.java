package src.com.problems.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CircularDistance {
    public static int solution(int dis[], int pet[], int n){
        // int ans=0;
        Queue<int []> q =new LinkedList<int[]>();
        for(int i=0; i<n; i++){
            q.offer(new int[] {dis[i], pet[i]});
        }
        int sum=0, diff=0;
        while(!q.isEmpty()){
            int arr[]=q.poll();
            int d=arr[0];
            int p=arr[1];
            sum+=d;
            diff=sum-p;
            if(diff>=0){
                return q.size();
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int dis[]=new int[n];
        int pet[]=new int[n];
        for(int i=0; i<n ;i++){
            dis[i]=sc.nextInt();
        }
        for(int i=0; i<n ;i++){
            pet[i]=sc.nextInt();
        }
      
        int ans=solution(dis, pet, n);
        
        System.out.println(ans);
        sc.close();
    }
}
