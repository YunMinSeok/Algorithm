import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
  int x,cost;
  public Point(int x, int cost){
    this.x = x;
    this.cost = cost;
  }
  @Override
  public int compareTo(Point o){
    return this.cost -o.cost;
  }
}


public class Main{
    static int N,M;
    static int start,end;
    static int min = Integer.MAX_VALUE;
    static int shortest[];
    static PriorityQueue<Point>pq = new PriorityQueue<>();
	static ArrayList<ArrayList<Point>> graph;
    
    static void dfs(){
      
      shortest[start] = 0;
      pq.add(new Point(start,0));
      while(!pq.isEmpty()){
        Point p = pq.poll();

        for(int i=0; i< graph.get(p.x).size(); i++){
          int startx = p.x;
          int endx = graph.get(startx).get(i).x;
          int cost = graph.get(startx).get(i).cost;

          if(shortest[endx] > shortest[startx] + cost ){
            shortest[endx] = shortest[startx] + cost;
            pq.offer(new Point(endx, shortest[startx]+ cost));
          }
        }
      }
      

    }

    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        shortest = new int[N+1];
        Arrays.fill(shortest, min);

        graph = new ArrayList<ArrayList<Point>>();
        for(int i=0; i < N+1; i++){
          graph.add(new ArrayList<Point>());
        }

        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Point(b,c));
        }
        
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        
        dfs();

        System.out.println(shortest[end]);
    }//main 끝   }//main
    
}
