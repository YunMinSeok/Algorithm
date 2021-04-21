import java.util.*;

public class Main{
    static int INF = 16 * 1_000_000;
    static int N;
    static int arr[][];
    static int dp[][];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        arr = new int[N][N];
        dp= new int[N][(1<<N)-1];
        
        for(int i=0; i < N; i++){
            Arrays.fill(dp[i], INF);
        }
      
        for(int i=0; i < N ; i++){
            for(int j=0; j < N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(tsp(0,1));
    }
    
    public static int tsp(int node, int visit){
        if(visit == (1<<N)-1){
            if(arr[node][0] == 0) return INF;
            return arr[node][0];
        }
        
        if(dp[node][visit] != INF){
            return dp[node][visit];
        }
        
        for(int i=0; i < N; i++){
            int next = visit | (1<<i);
            if(arr[node][i] == 0 || (visit & (1<<i))!=0) continue;
            
            dp[node][visit] = Math.min(dp[node][visit], tsp(i,next) + arr[node][i]);
        }
        
        return dp[node][visit];
    }
}
