import java.util.*;
import java.io.*;

public class Main{
    static int N,M;

    static int[][] arr;
    static boolean visit[][][];

    static boolean flag = false;

    static int a[][]={
        {-1,0},{1,0},{0,1},{0,-1}
    };

    public static class point{
      int row;
      int col;
      int cnt;
      boolean had;
      
      public point(int row,int col,int cnt,boolean had){
          this.row=row;
          this.col=col;
          this.cnt=cnt;
          this.had=had;
      }
    }
    
    public static void bfs(int x,int y,int z,boolean o){
        Queue<point> queue = new LinkedList();
        
        queue.add(new point(x,y,z,o));

        visit[0][0][0] = true;
        visit[1][0][0] = true;

        while(!queue.isEmpty()){
            point temp = queue.poll();
            int row = temp.row;
            int col = temp.col;
            int cnt = temp.cnt;
            boolean had = temp.had;

            int isvisit = 0;

            if(had){
              isvisit = 1;
            }

            if(row  == N-1 && col == M-1){
              System.out.println(cnt+1);
              flag = true;
              break;
            }

            int temp_row;
            int temp_col;

            for(int i=0; i< 4; i++){
                temp_row = row + a[i][0];
                temp_col = col + a[i][1];
                
                if(temp_row>=0 && temp_col>=0 && temp_row<N && temp_col <M){
                    if(arr[temp_row][temp_col] == 1){
                      if(isvisit==0 && !visit[1][temp_row][temp_col]){
                        visit[1][temp_row][temp_col] = true;
                        queue.add(new point(temp_row,temp_col,cnt+1,true));
                      }
                    }else{
                        if(!visit[isvisit][temp_row][temp_col]){
                          queue.add(new point(temp_row,temp_col,cnt+1,had));
                          visit[isvisit][temp_row][temp_col]= true;
                        }
                    }
                    
                    }
                    
                }
            }
        }
        

    
    public static void main(String [] args)throws IOException{
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        visit = new boolean[2][N+1][M+1];

        for(int i=0;i<2;i++){
            for(int j=0;j<N;j++){
                Arrays.fill(visit[i][j],false);
            }
        }
        
        for(int i=0; i < N; i++){
          String[] b = br.readLine().split("");
            for(int j=0; j<M; j++){
                 arr[i][j]= Integer.parseInt(b[j]);       
            }
        }
        
        bfs(0,0,0,false);
        
        if(!flag){
          System.out.println(-1);
        }
    }

    
}
