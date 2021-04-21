import java.util.*;
import java.io.*;

public class Main{
    static int arr[][];
    static int sum=1;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        arr= new int[N][2];
        
        for(int i=0; i < N; i++){
            for(int j=0; j <2; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        Arrays.sort(arr,new Comparator<int[]>(){
          public int compare(int[] o1, int[] o2){
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }else{
                return o1[1] - o2[1];
            }
           }
        });
        
        int temp = arr[0][1];
        
        for(int i=1; i<N; i++){
            if(temp <= arr[i][0]){
                temp = arr[i][1];
                sum++;
            }
        }
        
        System.out.println(sum);
        
    }
}
