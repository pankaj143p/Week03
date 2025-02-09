package com.problems;
import java.util.Random;
import java.util.HashSet;
import java.util.TreeSet;
class HashComparison{
    private static double con=1_000_000.0;
    private static void searchByArray(long n){
        long a[] = new long[(int)n];
        long startTime,endTime,tTime;
        Random ran = new Random();
        long key=ran.nextInt();
        for(int i=0; i<n; i++){
            a[i] = ran.nextInt();
        }
        startTime=System.nanoTime();
        for(int i=0; i<n; i++){
            if(a[i] == key){
                System.out.println("Element Found");
                return ;
            }
        }
        System.out.println("Element Not found");
        endTime=System.nanoTime();
        tTime=endTime-startTime;
        double tInMs = tTime/con;
        System.out.println("Time taken by linear search : "+tInMs+" ms");
    }
    private static void searchBySet(long n){
        long a[] = new long[(int)n];
        long startTime,endTime,tTime;
        Random ran = new Random();
        long key=ran.nextInt();
        HashSet<Long> hs = new HashSet<>();
        for(int i=0; i<n; i++){
            a[i] = ran.nextInt();
            hs.add(a[i]);
        }
        startTime=System.nanoTime();

        if(hs.contains(key)){
            System.out.println("Element found");
            return ;
            //   }
            //   hs.add(a[i]);
        }
        System.out.println("Element Not found");
        endTime=System.nanoTime();
        tTime=endTime-startTime;
        double tInMs = tTime/con;
        System.out.println("Time taken by HashSet : "+tInMs+" ms");
    }
    private static void searchByTreeSet(long n){
        long a[] = new long[(int)n];
        long startTime,endTime,tTime;
        Random ran = new Random();
        long key=ran.nextInt();
        TreeSet<Long> ts = new TreeSet<>();
        for(int i=0; i<n; i++){
            a[i] = ran.nextInt();
            ts.add(a[i]);
        }
        startTime=System.nanoTime();

        if(ts.contains(key)){
            System.out.println("Element found");
            return ;
            //   }
            //   hs.add(a[i]);
        }
        System.out.println("Element Not found");
        endTime=System.nanoTime();
        tTime=endTime-startTime;
        double tInMs = tTime/con;
        System.out.println("Time taken by TreeSet : "+tInMs+" ms");
    }
    public static void main(String[] args) {
        long sizes[] = {1000, 100000, 1000000};
        for(int i=0; i<3; i++){
            searchByArray(sizes[i]);
            searchBySet(sizes[i]);
            searchByTreeSet(sizes[i]);
            System.out.println("-------------------------------------------------");

        }
    }
}