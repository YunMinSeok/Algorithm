import java.util.*;
import java.io.*;

public class Main{
    static int testcase;
    
    static ArrayList<Node> arr[];
    static int dist[];
    
    static int count;
    
    static class Node implements Comparable<Node>{
        int b,time;
        Node(int b, int time){
            this.b = b;
            this.time =time;
        }
        
        public int compareTo(Node n){
            return this.time - n.time;
        }
    }
    
    static void bfs(int start ){
        Queue<Node> que = new PriorityQueue<>();
        dist[start] =0;
        que.add(new Node(start,dist[start]));
        
        while(!que.isEmpty()){
            Node no = que.poll();
            
            int bb =no.b;
            int tt = no.time;
            
            if(tt > dist[bb]) continue;
            
            for(Node to : arr[bb]){
                if(dist[to.b] > dist[bb] + to.time){
                    if(dist[to.b] == Integer.MAX_VALUE)
                        count++;
                    dist[to.b] = dist[bb] + to.time;
                    que.add(new Node(to.b, dist[to.b]));
                }
            }
        }
    }
    
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        testcase = Integer.parseInt(br.readLine());
        
        while(testcase --> 0){
            st = new StringTokenizer(br.readLine());
            int computer = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            
            arr = new ArrayList[computer+1];
            dist = new int[computer+1];
            Arrays.fill(dist,Integer.MAX_VALUE);
            
            count =1;
            
            for(int i=1; i <=computer; i++){
                arr[i] = new ArrayList<>();
            }
            
            for(int i=0; i < line; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                arr[b].add(new Node(a,time));
            }
            
            bfs(start);
            int result[] = Arrays.stream(dist).filter(k -> k != Integer.MAX_VALUE).toArray();
            Arrays.sort(result);
            
            System.out.println(count + " " + result[result.length -1]);
            
        }
        
    }
}
