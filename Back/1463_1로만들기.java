import java.util.*;
import java.io.*;

public class Main{
    static int N;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        if(N == 1){
            System.out.println("0");
        }else if(N ==2 || N==3){
            System.out.println("1");
        }else{
            int []dp = new int[N+1];
            for(int i=1; i <=N; i++){
                dp[i] = Integer.MAX_VALUE;
            }
            
            dp[1] = 0;
            dp[2] = 1;
            dp[3] = 1;
            
            for(int i=4; i <=N; i++){
                if(i%3 == 0){
                    dp[i] = Math.min(dp[i/3]+1, dp[i]);
                }
                if(i%2 ==0){
                    dp[i] = Math.min(dp[i/2]+1, dp[i]);    
                }
                dp[i] = Math.min(dp[i], dp[i-1]+1);
                
            }
            
            System.out.println(dp[N]);
            
        }
        
        
    }
}
