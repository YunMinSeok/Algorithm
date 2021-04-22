import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[][] arr;
    static boolean [][] visit;
    
    static int [] ax = {-1,0,0,1};
    static int [] ay = {0,1,-1,0};
    
    static void bfs(int x, int y,int h){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        
        qx.add(x);
        qy.add(y);
        
        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();
            visit[x][y] = true;
            
            for(int i=0; i < 4; i++){
                int xx = x + ax[i];
                int yy = y + ay[i];
                
                if(xx >=0 && yy>=0 && xx<N && yy <N){
                    if(arr[xx][yy] > h && !visit[xx][yy]){
                        qx.add(xx);
                        qy.add(yy);
                        visit[xx][yy] = true;
                    }
                }
            }
        }
        
    }
    
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        
        arr = new int[N][N];
        
        for(int i=0; i < N; i++){
            for(int j=0; j < N; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        
        int max = 0;
        for(int h=0; h<=100; h++){
            int size=0;
            visit = new boolean[N][N];
            for(int i=0; i < N; i++){
                for(int j=0; j < N; j++){
                    if(arr[i][j] > h && !visit[i][j]){
                        bfs(i,j,h);
                        size++;
                    }
                }
            }
            if(max < size){
               max = size;
             }
        }
        
        System.out.println(max);
    }
}
