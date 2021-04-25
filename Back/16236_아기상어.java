import java.util.*;
import java.io.*;

public class Main{
    
    static int N;
    static int shockx;
    static int shocky;
    static int body =2;
    static int eatCnt;
    static int ans;
    static boolean visit[][];
    
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    static class Pair{
      int y;
      int x;
      int distance;
      Pair(int y, int x,int distance){
        this.y = y;
        this.x = x;
        this.distance = distance;
      }
    }

    
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        int arr[][] = new int[N][N];
        
        for(int i=0; i< N; i++){
          st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0){
                  if(arr[i][j] == 9){
                      shocky = i;
                      shockx = j;
                      arr[i][j] = 0;
                  }
                }
            }
        }
        
       Queue <Pair> q = new PriorityQueue<>((o1,o2)->{
          if (o1.distance == o2.distance) {
              if (o1.y == o2.y) return Integer.compare(o1.x, o2.x);
              return Integer.compare(o1.y, o2.y);
          }
          return Integer.compare(o1.distance, o2.distance);
       });

       q.add(new Pair(shocky,shockx,0));
       visit = new boolean[N][N];
       visit[shocky][shockx] = true;

       while(!q.isEmpty()){
         Pair p = q.poll();

         for(int i=0; i<=3; i++){
           int movey = p.y + dy[i];
           int movex = p.x + dx[i];

           if(!(movey<N && movex <N && movey>=0 && movex >=0)) continue;
           if(visit[movey][movex]) continue;
             
           visit[movey][movex] = true;
             
           if(arr[movey][movex] <= body){
             q.add(new Pair(movey,movex,p.distance+1));
           }
         }

          if(q.peek() != null){
            Pair peek = q.peek();
            if(arr[peek.y][peek.x] < body && arr[peek.y][peek.x]>0){

              eatCnt++;

              if(eatCnt == body){
                body++;
                eatCnt =0;
              }

              arr[peek.y][peek.x] =0;

              q.clear();
              q.add(new Pair(peek.y,peek.x,0));
              ans += peek.distance;
              visit = new boolean[N][N];
              visit[peek.y][peek.x] = true;
            }
          }

       }
        
        System.out.println(ans);
    }
}
