import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int dp[];
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        dp = new int[n+1];
        if(n>1 && n%2==0){
        dp[0] = 1;
        dp[2] = 3;
        for(int i=4; i <=n; i+=2){
            dp[i] = dp[2] * dp[i-2];
            for(int j=4; j <=i; j+=2){
                dp[i] += 2*dp[i-j];
            }
        }
        }
        System.out.println(dp[n]);
        
    }
}
