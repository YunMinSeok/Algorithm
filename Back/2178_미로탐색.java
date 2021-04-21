import java.util.*;
import java.io.*;

public class Main{
    static int [] dx = {0,1,0,-1};
    static int [] dy = {1,0,-1,0};
    public static int N, M;
    public static int miro[][];
    public static boolean visit[][];
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        miro = new int[100][100];
        visit = new boolean[100][100];
        
        for(int i=0; i < N; i++){
            String m = sc.next();
            for(int j=0; j <M; j++){
                miro[i][j] = m.charAt(j) - 48;
            }
        }
        
        bfs(0,0);
        System.out.println(miro[N-1][M-1]);
    }
    
    public static void bfs(int x, int y){
        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        
        qx.add(x);
        qy.add(y);
        
        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();
            visit[x][y] = true;
            
            for(int i=0; i < 4; i++){
                int xx = x + dx[i];
                int yy = y + dy[i];
                
                if(xx >= 0 && yy >=0 && xx<N && yy < M){
                    if(miro[xx][yy] == 1 && visit[xx][yy] == false){
                        qx.add(xx);
                        qy.add(yy);
                        visit[xx][yy] = true;
                        miro[xx][yy] = miro[x][y]+1;
                    }
                }
            }
        }
        
    }
    
}
