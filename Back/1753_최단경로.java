import java.io.*;
import java.util.*;

public class Main{

  static int INF = Integer.MAX_VALUE;
  static int V,E,K;
  static ArrayList<Node>arr[];
  static int dp[];
  static boolean visit[];

  static class Node implements Comparable<Node>{
    int b,len;
    Node(int b, int len){
      this.b = b;
      this.len = len;
    }
    public int compareTo(Node n){
      return this.len - n.len;
    }
  }

  static void dijskra(int start){
    Arrays.fill(dp,INF);
    Queue<Node> que = new PriorityQueue<>();
    que.add(new Node(start,0));
    dp[start] = 0;

    while(!que.isEmpty()){
      Node n = que.poll();

      if(visit[n.b]) continue;

      visit[n.b] = true;

      for(int i=0; i < arr[n.b].size(); i++){
        Node nn = arr[n.b].get(i);
        if(!visit[nn.b] && dp[nn.b] > dp[n.b]+ nn.len){
          dp[nn.b] = dp[n.b]+ nn.len;
          que.add(new Node(nn.b, dp[nn.b]));
        }  
      }
    }

  }

  public static void main(String [] args)throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    V = Integer.parseInt(st.nextToken());
    E = Integer.parseInt(st.nextToken());

    K = Integer.parseInt(br.readLine());

    arr = new ArrayList[V+1];
    dp = new int[V+1];
    visit = new boolean[V+1];

    for(int i=1; i<= V; i++){
      arr[i] = new ArrayList<>();
    }

    for(int i=0; i < E; i++){
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int len = Integer.parseInt(st.nextToken());

      arr[a].add(new Node(b,len));
    }

    dijskra(K);
    
    for(int i=1; i <=V; i++){
     
      if(dp[i] == INF){
        System.out.println("INF");
      }else{
        System.out.println(dp[i]); 
      }
      
    }

  }
}
