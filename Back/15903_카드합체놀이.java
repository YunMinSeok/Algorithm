aimport java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());//카드의 개수
        int m = Integer.parseInt(st.nextToken());//합체 횟수
        
        st = new StringTokenizer(br.readLine());
        
        PriorityQueue<Long> que = new PriorityQueue<Long>();
        
        while(st.hasMoreTokens()){
            que.offer(Long.parseLong(st.nextToken()));
        }
        
        for(int i=0; i < m; i++){
            long a = que.poll();
            long b = que.poll();
            que.offer(a+b);
            que.offer(a+b);
        }
        
        long sum=0;
        
        while(!que.isEmpty()){
            sum += que.poll();
        }
        
        System.out.println(sum);
        
    }
}
