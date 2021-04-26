import java.io.*;
import java.util.*;

public class Main{
    static int N,D;
    static ArrayList<Node>arr = new ArrayList<>();
    static int dp[];
    
    static class Node{
        int a,b, len;
        public Node(int a,int b, int len){
            this.a = a;
            this.b = b;
            this.len = len;
        }
    }

    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        dp = new int[D];
        for(int i=0; i < N; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if(b > D) continue;
            if(b-a <= len) continue;
            arr.add(new Node(a,b,len));
        }

        Collections.sort(arr,new Comparator<Node>(){
          public int compare(Node n1, Node n2){
            if(n1.a == n2.a) return Integer.compare(n1.b,n2.b);
            return Integer.compare(n1.a,n2.a);
          }
        });

        int move =0;
        dp = new int[D+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        int idx = 0;

        while(move <D){
          if(idx < arr.size()){
            Node n = arr.get(idx);
            if(move == n.a){
              dp[n.b] = Math.min(dp[move] + n.len, dp[n.b]);
              idx++;
            }else{
              dp[move+1] = Math.min(dp[move+1],dp[move]+1);
              move++;
            }
          }else{
            dp[move+1] = Math.min(dp[move+1],dp[move]+1);
            move++;
          }
        }

        System.out.println(dp[D]);
        
    }
}
