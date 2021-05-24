import java.util.*;

public class Main{
    static int seq[];
    static int dp [];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        seq = new int[n];
        dp = new int[n];
        
        for(int i=0; i < n; i++){
            seq[i] = sc.nextInt();
        }
        
        for(int i= 0; i < n; i++){
            dp[i] = 1;
            for(int j=0; j < i; j++){
                if(seq[j]< seq[i] && dp[i]< dp[j]+1){
                    dp[i] = dp[j] +1;
                }
            }
        }
        
        int max = -1;
        for(int i=0; i < n; i++){
            max = dp[i] > max ? dp[i] : max;
        }
        
        
        System.out.println(max);
    }
}
