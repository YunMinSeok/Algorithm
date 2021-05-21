import java.util.*;

public class Main{
    static int dp[][] = new int[101][10];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in); 
        int N = sc.nextInt();
       
        dp[1][0] = 0;
        for(int i=1; i <=9; i++){
            dp[1][i] = 1;
        }
        int ans = 0;
        for(int i=2; i <= N; i++){
            dp[i][0] = dp[i-1][1];
            dp[i][9] = dp[i-1][8];
            for(int j=1; j < 9; j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%1000000000;
            }
        }
        
        for(int i=0; i <=9; i++){
            ans = (ans + dp[N][i]) % 1000000000;
        }
        
        System.out.println(ans);
    }
}
