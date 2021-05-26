import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int map [][];
    static long dp [][];
    
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        dp = new long[N][N];
        
        dp[0][0] = 1;
        for(int i=0; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i < N; i++){
          for(int j=0; j < N; j++){
            if(i==N-1 && j == N-1){
              continue;
            }
            if(i + map[i][j]<N){
              dp[i+ map[i][j]][j] += dp[i][j];
            }
            if(j + map[i][j]<N){
              dp[i][map[i][j]+j] += dp[i][j];
            }
          }
        }
        
        System.out.println(dp[N-1][N-1]);
    }
}
