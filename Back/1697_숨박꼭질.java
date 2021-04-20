import java.util.*;
import java.io.*;

public class Main{
    static int N,K;
    static int result =0;
    static boolean visit[] = new boolean[100001];
  public static void bfs(int N, int K){
      Queue<Integer>que = new LinkedList<>();
      que.add(N);
      Queue<Integer>next = new LinkedList<>();

      while(!que.isEmpty()){
        if(N == K){
          break;
        }
          result++;
          next = new LinkedList<>();
          
          while(!que.isEmpty()){
              int cur = que.poll();
              visit[cur] = true;
              int [] f = {cur-1,cur+1,cur*2};
              
              for(int i=0; i<3; i++){
                  if(f[i] == K){
                      que.clear();
                      next.clear();
                      break;
                  }else if(f[i] >=0 && f[i]<=100000 && !visit[f[i]]){
                      next.add(f[i]);
                  }
              }
          }
          que = next;
      }
    }
    
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        bfs(N,K);
        System.out.println(result);
    }
}
