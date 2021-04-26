import java.util.*;
import java.io.*;

public class Main{
    static int N,M,K;
    static ArrayList<Node>[]arr,reversearr;
    static int[] dp,reversedp;
    static boolean visit[];
    static int INF = 1000000000;
    
    static class Node implements Comparable<Node>{
        int b, len;
        Node(int b, int len){
            this.b = b;
            this.len = len;
        }
        public int compareTo(Node n){
            return this.len - n.len;
        }
    }
    
    static void dijkstra(ArrayList<Node>[] arr,int[] distance,int start){
        visit = new boolean[N+1];
        Queue<Node>que = new PriorityQueue<>();
        que.add(new Node(start,0));
        distance[start] = 0;
        
        while(!que.isEmpty()){
            Node n = que.poll();
            int bb = n.b;
            
            if(visit[bb]) continue;
            visit[bb] = true;
            
            for(int i=0; i < arr[bb].size(); i++){
                Node tmp = arr[bb].get(i);
                if(distance[tmp.b] > distance[bb] + tmp.len){
                    distance[tmp.b] = distance[bb] + tmp.len;
                    que.add(new Node(tmp.b,distance[tmp.b]));
                }
            }
        }
    }
    
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        arr = new ArrayList[N+1];
        reversearr = new ArrayList[N+1];
        dp = new int[N+1];
        reversedp = new int[N+1];
        
        for(int i=1; i <=N; i++){
            arr[i] = new ArrayList<>();
            reversearr[i] = new ArrayList<>();  
        }
        Arrays.fill(dp, INF);
        Arrays.fill(reversedp, INF);
        
        for(int i=0; i < M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a].add(new Node(b,c));
            reversearr[b].add(new Node(a,c));
        }
        int ans= -1;
        
        dijkstra(arr,dp,K);
        dijkstra(reversearr,reversedp,K);
        
        for(int i=1; i <=N; i++){
            ans = Math.max(ans,dp[i]+reversedp[i]);
        }
        
        System.out.println(ans);
    }
}
