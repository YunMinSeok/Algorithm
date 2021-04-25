import java.util.*;
import java.io.*;

public class Main{
    static int N,K,M,X;
    static PriorityQueue<Integer> ans= new PriorityQueue<>();
    static ArrayList<Integer> arr[];
    static boolean visit[];

    static class Node{
      int a,count;
      public Node(int a, int count){
        this.a = a;
        this.count = count;
      }
    }
    
    public static void bfs(int start, int count){
      Queue <Node> que = new LinkedList<>();
      
      que.add(new Node(start,count));
      visit[start] = true;

      while(!que.isEmpty()){
        Node no = que.poll();
        int cur = no.a;
        int cnt = no.count;

        if(cnt == K){
          ans.add(cur);
          continue;
        }

        for(int i=0; i < arr[cur].size(); i++){
          int zz = arr[cur].get(i);
          if(!visit[zz]){
            visit[zz] = true;
            que.add(new Node(zz,cnt+1));
          }
        }

      }
    }
    
    public static void main(String [] args)throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new ArrayList[300001];
        visit = new boolean[300001];

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=N; i++){
          arr[i] = new ArrayList<>();
        }


        for(int i=0; i < M; i++){
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          arr[a].add(b);
        }

        bfs(X,0);
        
        if(ans.isEmpty()){
          System.out.println(-1);
        }else{
          while(!ans.isEmpty()){
             System.out.println(ans.poll());
          }
        }
       
    }
}
