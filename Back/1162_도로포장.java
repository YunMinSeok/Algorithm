import java.util.*;
import java.io.*;

public class Main{
    static long alist[][];
    static ArrayList<Integer> nlist[];
    static ArrayList<Integer> clist[];
    static int N,M,K;

    static class Node implements Comparable<Node>{
        int node;
        long cost;
        int count;
        Node(int node, long cost, int count){
            super();
            this.node = node;
            this.cost = cost;
            this.count = count;
        }

        public int compareTo(Node a){
          if(this.cost < a.cost){
            return -1;
          }else if(this.cost > a.cost){
            return 1;
          }else{
            return 0;
          }
        }
    }
    
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nlist = new ArrayList[N+1];
        clist = new ArrayList[N+1];

        alist = new long[N+1][K+1];

        for(int i=0; i <=K; i++){
          for(int j=1; j<=N; j++){
            alist[j][i] = Long.MAX_VALUE;
          }
        }

        for(int i=1; i <= N; i++){
          nlist[i] = new ArrayList<Integer>();
          clist[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<=M; i++){
          st =new StringTokenizer(br.readLine());
          int s = Integer.parseInt(st.nextToken());
          int e = Integer.parseInt(st.nextToken());
          int v = Integer.parseInt(st.nextToken());
          nlist[s].add(e);
          nlist[e].add(s);
          clist[s].add(v);
          clist[e].add(v);
        }

        alist[1][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        pq.add(new Node(1,0,0));

        while(!pq.isEmpty()){
          Node t = pq.poll();

          if(alist[t.node][t.count] < t.cost){
            continue;
          }

          for(int i=0; i<nlist[t.node].size(); i++){
            int x = nlist[t.node].get(i);
            long c = clist[t.node].get(i);

            if(t.count +1 <= K && alist[x][t.count+1] > alist[t.node][t.count]){
              alist[x][t.count +1] = alist[t.node][t.count];
              pq.add(new Node(x,alist[x][t.count+1],t.count+1));
            }

            if(alist[x][t.count] > alist[t.node][t.count]+c){
              alist[x][t.count] = alist[t.node][t.count]+c;
              pq.add(new Node(x, alist[x][t.count], t.count));
            }
          }

        }

        long answer = Long.MAX_VALUE;
        for (int i= 0; i<=K; i++) {
          answer = Math.min(answer, alist[N][i]);
        }
        
        System.out.println(answer);
        
    }
}
