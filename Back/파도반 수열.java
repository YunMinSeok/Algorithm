import java.util.*;

public class Main{
    static Long dp[] = new Long[101];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        
        int T = sc.nextInt();
        
        for(int i=0; i < T; i++){
            int N = sc.nextInt();
            System.out.println(padovan(N));
        }
    }
    
    public static long padovan(int N){
        if(dp[N] == null){
            dp[N] = padovan(N-2) + padovan(N-3);
        }
        return dp[N];
    }
}
