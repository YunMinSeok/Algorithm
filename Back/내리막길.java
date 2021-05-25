import java.util.*;
import java.io.*;
public class Main{
    static int M,N;
    static int dp[][];
    static int map[][];
	static int[] movex = { 0, 1, 0, -1 };
	static int[] movey = { 1, 0, -1, 0 };
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken()); 
        N = Integer.parseInt(st.nextToken()); 
        
        dp = new int[M+1][N+1];
        map = new int[M+1][N+1];
        
        for(int i=1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }    
        }
        
        int res = dfs(1,1);
        
        System.out.println(res);
        
    }
    
    public static int dfs(int sm, int sn){
        dp[sm][sn] = 0;
        
        for(int i=0; i < 4; i++){
            int m = sm + movey[i];
            int n = sn + movex[i];
            if((1 <= m && m <= M) && (1 <= n && n <= N)){
                if(map[m][n] < map[sm][sn]){
                    if(m == M && n == N){
                        dp[sm][sn] += 1;
                    }
                    if(dp[m][n] >=0)
                        dp[sm][sn] += dp[m][n];
                    else
                        dp[sm][sn] += dfs(m,n);
                }
            }
        }
        return dp[sm][sn];
    }
}
