import java.util.*;
class Solution {
    static int [][] map;
    static int min;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        map = new int[rows+1][columns+1];
        
        int num = 1;
        
        for(int i=1; i < rows+1; i++){
            for(int j=1; j < columns+1; j++){
                map[i][j] = num;
                num++;
            }
        }
        
         for(int i = 0; i < queries.length; i++) {
            answer[i] = rotation(queries[i]);
        }
        
        return answer;
    }
    
    static int rotation(int [] query){
        int xmove = query[2] - query[0];
        int ymove = query[3] - query[1];
        
        int nx = query[0];
        int ny = query[1];
        int now = map[nx][ny];
        
        min = now;
        
        for(int i=0; i < ymove; i++){
            ny+=1;
            now = move(nx,ny,now);
        }
        for(int i=0; i < xmove; i++){
            nx+=1;
            now = move(nx,ny,now);
        }
        for(int i=0; i < ymove; i++){
            ny-=1;
            now = move(nx,ny,now);
        }
        for(int i=0; i < xmove; i++){
            nx-=1;
            now = move(nx,ny,now);
        }
        return min;
    }
    
    static int move(int x,int y, int before){
        int temp = map[x][y];
        min = Math.min(min,temp);
        map[x][y] = before;
        return temp;
    }
    
}
