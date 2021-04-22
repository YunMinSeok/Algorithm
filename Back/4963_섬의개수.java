import java.util.*;
import java.io.*;

public class Main{
    static int w,h;
    public static boolean visit[][];
    public static int arr[][];
    public static ArrayList<Integer> ans = new ArrayList<>();
    public static int[] ax = {1,0,0,-1,-1,-1,1,1};
    public static int[] ay = {0,1,-1,0,-1,1,-1,1};
    
    public static void bfs(int x, int y){
        Queue<Integer>qx = new LinkedList<Integer>();
        Queue<Integer>qy = new LinkedList<Integer>();
        
        qx.add(x);
        qy.add(y);
        
        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();
            visit[x][y] = true;
            
            for(int i=0; i <8; i++){
                int xx = x + ax[i];
                int yy = y + ay[i];
                
                if(xx >= 0 && yy >=0 && xx< h && yy < w){
                    if(arr[xx][yy] == 1 && !visit[xx][yy]){
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
           
         while(true){
           
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); //가로
            h = Integer.parseInt(st.nextToken());//세로
            
            if(w == 0 && h == 0){
              break;
            }
            int count=0;
           
            arr = new int[h][w];
            visit = new boolean[h][w];
            
            for(int i=0; i < h; i++){
               st = new StringTokenizer(br.readLine());
              for(int j =0; j< w; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
              }
            }

            for(int i=0; i < h; i++){
              for(int j =0; j< w; j++){
                if(arr[i][j] == 1 && !visit[i][j]){
                  bfs(i,j);
                  count++;
                }
              }
            }
            
            ans.add(count);
        }
        
        for(int i=0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }
}
