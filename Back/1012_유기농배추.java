import java.util.*;
import java.io.*;

public class Main{
    static int M,N,K;
    
    public static boolean visit[][];
    public static int bat[][];

    public static int[] ax = {1,0,0,-1};
    public static int[] ay = {0,1,-1,0};
    
    public static void bfs(int x, int y){
        Queue<Integer>qx = new LinkedList<Integer>();
        Queue<Integer>qy = new LinkedList<Integer>();
        
        qx.add(x);
        qy.add(y);
        
        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();
            visit[x][y] = true;
            
            for(int i=0; i <4; i++){
                int xx = x + ax[i];
                int yy = y + ay[i];
                
                if(xx >= 0 && yy >=0 && xx< N && yy < M){
                    if(bat[xx][yy] == 1 && !visit[xx][yy]){
                        qx.add(xx);
                        qy.add(yy);
                        visit[xx][yy] = true;
                    }
                }
            }
        }//while문 끝
    }    
        
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());//테ㅇ스트 케이스 개수
        
        for(int z=0; z < T; z++){
           int count =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); //가로
            N = Integer.parseInt(st.nextToken());//세로
            K = Integer.parseInt(st.nextToken());//배추 개수
            
            bat = new int[N][M];
            visit = new boolean[N][M];
            
            for(int j=0; j < N; j++){//배열 초기값 지정초기값 지정
                Arrays.fill(bat[j],0);
            }

            for(int j=0; j< K; j++){
              st= new StringTokenizer(br.readLine());
              int a = Integer.parseInt(st.nextToken());
              int b = Integer.parseInt(st.nextToken());
              bat[b][a] = 1;
            }

            for(int i=0; i < N; i++){
              for(int j =0; j< M; j++){
                if(bat[i][j] == 1 && !visit[i][j]){
                  bfs(i,j);
                  count++;
                }
              }
            }
            
            System.out.println(count);
        }
        
    }
}
