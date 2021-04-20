import java.util.*;
import java.io.*;

public class Main{
    static int t;
    static int dp[][] = new int[41][2];
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        t = Integer.parseInt(br.readLine());
        
        dp[0][0] = 1;
        dp[1][1] = 1;
        
        for(int i=2; i <=40; i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }
        
        for(int i=0; i < t; i++){
            int a = Integer.parseInt(br.readLine());
            System.out.println(dp[a][0] + " " + dp[a][1]);
        }
        
        
    }
}
