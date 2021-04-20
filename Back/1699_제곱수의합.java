import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int dp[];
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        dp = new int[n+1];

        for(int i=1; i <= n; i++){
          dp[i] = i;
          for(int j=1; j*j <=i;j++){
            if(dp[i] > dp[i-j*j] +1){
                dp[i] = dp[i-j*j]+1;
            }
          }
        }

        System.out.println(dp[n]);
        
    }
}
