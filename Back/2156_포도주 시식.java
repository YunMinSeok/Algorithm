import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int arr[];
    static int dp[];
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n+1];
        dp = new int[n+1];
        
        for(int i=1; i<=n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        dp[1] = arr[1];
        
        if(n>=2){
            dp[2] = arr[1] + arr[2];
        }
        
        for(int i=3; i<=n; i++){
            dp[i] = Math.max(Math.max(dp[i-2],dp[i-3] +arr[i-1])+arr[i],dp[i-1]);
        }
        
        System.out.println(dp[n]);
    }
}
