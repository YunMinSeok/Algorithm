import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        int [][] a = new int [N][2];
        
        for(int i=0; i < N; i++){//이중 배열로 받기
            st = new StringTokenizer(br.readLine());
            for(int j=0; j < 2; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Arrays.sort(a , new Comparator<int[]>(){//시작시간을 기준으로 오름차순 정렬
           @Override
            public int compare(int[] t1, int[] t2){
                return t1[0] - t2[0];
            }
        });
        
        PriorityQueue <Integer> Que  = new PriorityQueue<Integer>(); 
        Que.offer(a[0][1]);
        
        for(int i=1; i < N; i++){
            if(Que.peek() <= a[i][0]){
                Que.poll();
            }
            Que.offer(a[i][1]);
            
        }
        
        System.out.println(Que.size());
    }
}
