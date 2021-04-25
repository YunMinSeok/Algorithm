import java.util.*;
import java.io.*;

public class Main{
    static PriorityQueue<Node> pq;
    static int arr[][];
    static int distance[];
    static int N,M,S,D;
    
    static class Node{
        int b,len;
        Node(int b, int len){
            this.b = b;
            this.len = len;
        }
    }

    static void dijkstra(){
      pq = new PriorityQueue<Node>(new Comparator<Node>(){
          public int compare(Node n1, Node n2){
            return n1.len - n2.len;
          }
      });

      que.add(new Node(S,0));

      while(!pq.isEmpty()){
        Node no = pq.poll();
        if(no.len > distance[no.b]){
          continue;
        }

        for(int i=0; i < N; i++){
          if(arr[no.b][i] == 0){
            continue;
          }

          if(distance[no.b] + arr[no.b][i] < distance[i]){
            distance[i] = distance[no.b] + arr[no.b][i];
            pq.add(new Node(i, distance[i]));
          }
        }

      }

    }

    static void deleteNode(){
      Queue<Integer> q = new LinkedList<>();
      q.add(D);

      while(!q.isEmpty()){
        int no = q.poll();

        for(int i=0; i <N; i++){
          if(arr[i][no] == 0){
            continue;
          }

          if(distance[no] == distance[i] + arr[i][no]){
            arr[i][no] = 0;
            q.add(i);
          }
        }
      }
    }
    
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        while(true){
            st  = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            if(N == 0 && M == 0){
                break;
            }
            
            arr = new int[N][N];
            distance = new int[N];
            
            st  = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            
            for(int i=0; i < M; i++){
              st  = new StringTokenizer(br.readLine());
              int a = Integer.parseInt(st.nextToken());
              int b = Integer.parseInt(st.nextToken());
              int len = Integer.parseInt(st.nextToken());
          
              arr[a][b] = len;
            }

            Arrays.fill(distance , Integer.MAX_VALUE);
            distance[S] = 0;
            dijkstra();

            deleteNode();

            Arrays.fill(distance , Integer.MAX_VALUE);
            distance[S] = 0;
            dijkstra();

            System.out.println(distance[D] == Integer.MAX_VALUE ? -1 : distance[D]);

        }
    }
}
