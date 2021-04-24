import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    
    static char arr[][];
    static boolean visit[][][][];
    
    static int cntr,cntb;
    static int rx,ry;
    static int bx,by;
    
    static int a[][]={
        {-1,0},{1,0},{0,1},{0,-1}
    };
    
    
    static class Block{
        int y;
        int x;
        int cnt;
        Block(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    static int bfs(int redx,int redy, int bluex, int bluey){
        Queue <Block> RED = new LinkedList<>();
        Queue <Block> BLUE = new LinkedList<>();
        
        RED.add(new Block(redx,redy,0));
        BLUE.add(new Block(bluex,bluey,0));
        int result= -1;
    
        while(!RED.isEmpty()){
            Block r = RED.poll();
            Block b = BLUE.poll();

            redx = r.x;
            redy = r.y;
            bluex = b.x;
            bluey = b.y;
            cntr = r.cnt;
            cntb = b.cnt;

            
            if(cntr > 10) break;
            
            
            if(arr[redx][redy] == 'O' && arr[bluex][bluey] != 'O'){
                result =cntr;
                break;
            }

            for(int i=0; i < 4; i++){
                int redxx = redx + a[i][0];
                int redyy = redy + a[i][1];
                int bluexx = bluex + a[i][0];
                int blueyy = bluey + a[i][1];
                
                while(true){//빨간공 움직이기
                  if(arr[redxx][redyy] != '#' &&  arr[redxx][redyy] != 'O'){
                      redxx += a[i][0];
                      redyy += a[i][1];
                  }else{
                    if(arr[redxx][redyy] == '#'){
                      redxx -= a[i][0];
                      redyy -= a[i][1];
                    }
                    break;
                  }
                }

                while(true){//파란공 움직이기
                  if(arr[bluexx][blueyy] != '#' &&  arr[bluexx][blueyy] != 'O'){
                      bluexx += a[i][0];
                      blueyy += a[i][1];
                  }else{
                    if(arr[bluexx][blueyy] == '#'){
                      bluexx -= a[i][0];
                      blueyy -= a[i][1];
                    }
                    break;
                  }
                }

                if(arr[bluexx][blueyy] != 'O' &&  redxx == bluexx && redyy == blueyy){
                  int d_r = Math.abs(redyy - redy) + Math.abs(redxx - redx);
                  int d_y = Math.abs(blueyy - bluey) + Math.abs(bluexx - bluex);

                  if(d_r>d_y){
                    redxx -= a[i][0];
                    redyy -= a[i][1];
                  }else{
                    bluexx -= a[i][0];
                    blueyy -= a[i][1];
                  }
                }

                if(arr[bluexx][blueyy] == 'O') continue;

                if(visit[redxx][redyy][bluexx][blueyy] == false){
                  visit[redxx][redyy][bluexx][blueyy] = true;

                  RED.add(new Block(redxx,redyy,cntr+1));
                  BLUE.add(new Block(bluexx,blueyy,cntb+1));
                }
             
            }

        }

        return result;
    }
    
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new char[N][M];
        visit = new boolean[N][M][N][M];
       
        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                arr[i][j] = s.charAt(j);
                if(s.charAt(j) == 'R'){
                     rx = i;
                     ry = j;
                }else if(s.charAt(j) == 'B'){
                    bx = i;
                    by = j;
                }
            }   
        }
        
        visit[rx][ry][bx][by] = true;
        
        int ans = bfs(rx,ry,bx,by);
        
        System.out.println(ans);
    }
}
