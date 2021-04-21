import java.util.*;
import java.io.*;

public class Main{
    static int R,C,max = 0;
    static char [][] arr;
    static boolean [] visit;
    static ArrayList<Character> check = new ArrayList<Character>();
    static int count =1;
    static int ax[] = {-1,0,0,1};
    static int ay[] = {0,1,-1,0};

    static class Pair{
      int x;
      int y;
      int cnt;
      Pair(int x, int y,int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
      }
    }
    
    static void dfs(int x, int y, int cnt){
      
      visit[arr[x][y] - 'A'] = true;

      for(int i=0; i < 4; i++){
        int xx = x + ax[i];
        int yy = y + ay[i];
        
        if(xx >= 0 && yy >=0 && xx < R && yy < C){
          if(!visit[arr[xx][yy]-'A']){
              dfs(xx,yy,cnt+1);
          }
        }

      }
      visit[arr[x][y] - 'A'] = false;
      max = Math.max(max,cnt);

    }

    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        arr = new char[R][C];
        visit = new boolean[26];
        
        for(int i=0; i < R; i++){
            String s = br.readLine();
            for(int j=0; j<C; j++){
                arr[i][j] = s.charAt(j);
            }
        }

       check.add(arr[0][0]); 
        dfs(0,0,1);
        
        System.out.println(max);
    }
}
