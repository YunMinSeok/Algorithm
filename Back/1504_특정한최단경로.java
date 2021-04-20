import java.util.*;
import java.io.*;

public class Main{
    static int N,E;
    static boolean check[];
    static int point[];
    static ArrayList<ArrayList<Node>> arr;
    static final int INF = 200000000;

    static class Node implements Comparable<Node>{
        int end,weight;
        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
         
    }

    static int dijkstra(int start, int end){
      Arrays.fill(point,INF);
      Arrays.fill(check,false);
      PriorityQueue<Node> pq = new PriorityQueue<>();
      pq.offer(new Node(start,0));
      point[start] = 0;

      while(!pq.isEmpty()){
        Node no = pq.poll();
        int cur= no.end;

        if(!check[cur]){
          check[cur] = true;

          for(Node node : arr.get(cur)){
            if(!check[node.end] && point[node.end] > point[cur] + node.weight){
              point[node.end] = point[cur] + node.weight;
              pq.add(new Node(node.end, point[node.end]));
            }
          }
        }
        
      }

      return point[end];
    }

    
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());//정점의 개수
        E = Integer.parseInt(st.nextToken()); //간선의 개수
        
        arr = new ArrayList<>();
        point = new int[N+1];
        check = new boolean[N+1];

        Arrays.fill(point,INF);

        for(int i=0; i <=N; i++){
            arr.add(new ArrayList<>());
        }
        
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.get(start).add(new Node(end,weight));
            arr.get(end).add(new Node(start,weight));
        }

        st = new StringTokenizer(br.readLine());

        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        
        int res1 =0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);
 
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1,res2);
        
        System.out.println(ans);
    }
}
