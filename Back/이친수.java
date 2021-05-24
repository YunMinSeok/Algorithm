import java.util.*;

public class Main{
    static long dp[][] = new long [91][2];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        dp[1][0] = 0;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 0;
        
        for(int i=3; i<= n; i++){
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }
        
        long sum = 0;
        
        for(int i=0; i < 2; i++){
            sum += dp[n][i];
        }
        
        System.out.println(sum);
    }
}
