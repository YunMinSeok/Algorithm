import java.util.*;

public class Main{
    static int N,K;
    static int ans= Integer.MAX_VALUE;
    static boolean visit[] = new boolean[200001];

    static class Node{
      int N,count;
      public Node(int N, int count){
        this.N = N;
        this.count = count;
      }
    }
    
    public static void bfs(){
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(N,0));
        
        while(!que.isEmpty()){
          Node no = que.poll();
          visit[no.N] = true;

          if(no.N == K){
            ans = Math.min(ans,no.count);
          }

          if(no.N *2 <= 100000 && !visit[no.N *2]){
            que.add(new Node(no.N *2, no.count));
          }

          if(no.N +1 <= 100000 && !visit[no.N +1]){
            que.add(new Node(no.N +1, no.count+1));
          }
          
          if(no.N -1 >= 0 && !visit[no.N -1]){
            que.add(new Node(no.N -1, no.count+1));
          }
        }
        
    }
    
    public static void main(String [] args)throws Exception{
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        
        bfs();
        
        System.out.println(ans);
    }
}
