import java.util.*;
import java.io.*;

public class Main{
    static int N;
    public static boolean visit[][];
    public static int apt[][];
    public static int[] ax = {1,0,0,-1};
    public static int[] ay = {0,1,-1,0};
    public static ArrayList<Integer> arr;
    
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        apt = new int [N][N];
        visit = new boolean[N][N];
        
        for(int i= 0; i < N; i++){
            String m = br.readLine();
            for(int j=0; j < N; j++){
                apt[i][j] = m.charAt(j) - '0';
            }
            Arrays.fill(visit[i],false);
        }
        
        arr = new ArrayList<Integer>();

        for(int i=0; i < N; i++){
            for(int j =0; j< N; j++){
                if(apt[i][j] == 1 && !visit[i][j]){
                    int size = bfs(i,j);
                    arr.add(size);
                }
            }
        }
        
        Collections.sort(arr);
        
        System.out.println(arr.size());
        for(int i=0; i< arr.size(); i++){
            System.out.println(arr.get(i));
        }
        
    }
    
    public static int bfs(int x, int y){
        int count= 1;
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
                
                if(xx >= 0 && yy >=0 && xx< N && yy < N){
                    if(apt[xx][yy] == 1 && !visit[xx][yy]){
                        qx.add(xx);
                        qy.add(yy);
                        visit[xx][yy] = true;
                        count++;
                    }
                }
            }
        }//while문 끝
        return count;
    }
    
}
