import java.util.*;

class Main{
    static int dp[];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        dp = new int[21];
        
        dp[0]= 0;
        dp[1] = 1;
        dp[2] = 1;
        
        int n = sc.nextInt();
        
        if(n < 3){
            System.out.println(dp[n]);
        }else{
            for(int i=3; i<=n; i++){
                dp[i] = dp[i-1] + dp[i-2];
            }
             System.out.println(dp[n]);
        }
        
    }
}
