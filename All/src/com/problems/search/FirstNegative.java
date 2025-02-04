package src.com.probles.linear;
import java.util.Scanner;
class FirstNegative{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        boolean found=false;
        // for search firts negative element if present in any index
        for(int i=0; i<n; i++){
            if(arr[i]<0){
                found=true;
                System.out.println("Element present at index : "+i);
                break;
            }
        }
        if(!found){
            System.out.println(-1);
        }
    }
}