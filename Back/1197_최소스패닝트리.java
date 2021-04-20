import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
  int x,y,len;
  public Point(int x,int y, int len){
    this.x = x;
    this.y = y;
    this.len = len;
  }
  @Override
  public int compareTo(Point o){
    if(this.len -o.len == 0)
        return this.x -o.x;
    return this.len -o.len;
  }
}

public class Main{
    static int V,E;
    static int num[];
    static PriorityQueue<Point> pq = new PriorityQueue<>();
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        V = sc.nextInt();
        E = sc.nextInt();
        num = new int[V+1];
        
        for(int i=1; i < V+1; i++){
            num[i]= i;
        }
        
        for(int i = 0; i < E; i++){
            pq.add(new Point(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
        
        int ans=0;
        
        while(!pq.isEmpty()){
            Point p = pq.poll();
            if(find(p.x) != find(p.y)){
                union(p.x,p.y);
                ans += p.len;
            }
             
        }
        System.out.println(ans);
        
    }
    
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a<b){
            num[b] = a;
        }else{
            num[a] = b;
        }
    }
    
    static int find(int a){
        if(num[a] == a){
            return a;
        }
        
        return num[a] = find(num[a]);
    }
}
