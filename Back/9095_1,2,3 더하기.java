import java.util.*;

class Main{
    static int dp[];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        dp = new int[11];
        int count = sc.nextInt();
        dp[1] = 1;
        dp[2] = 2;
        dp[3]=  4;
        for(int a=0; a < count; a++){
            int n = sc.nextInt();
            for(int i=4; i <= n; i++){
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }
            System.out.println(dp[n]);
        }
    }
}
