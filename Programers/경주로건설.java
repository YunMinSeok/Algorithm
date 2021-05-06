import java.util.*;
class Solution {
    
    static int move[][]={
        {-1,0},{0,-1},{1,0},{0,1}
    };
    static int N;
    static int map[][];
    static int answer;
    
    public static int solution(int[][] board) {
        N = board.length;
        answer = Integer.MAX_VALUE;
        map = board;
        
        bfs(0,0,0,-1);
        
        return answer;
    }
    
    static void bfs(int x, int y, int cost, int dir){
        
        Queue<Node> que = new LinkedList<Node>();
        que.add(new Node(x,y,cost,dir));
        map[x][y] = 1;
        
        while(!que.isEmpty()){
            
            Node no = que.poll();
            
            if(no.x == N-1 && no.y == N-1){
                answer = Math.min(answer, no.cost); 
                continue;
            }
            
            for(int i=0; i < 4; i++){
                int movex = no.x + move[i][0];
                int movey = no.y + move[i][1];
                
                if(movex >= 0 && movey >=0 && movex < N && movey < N && map[movex][movey] != 1){
                    int new_cost = 0;
                    
                    if(no.dir == -1 || no.dir == i){
                        new_cost = no.cost + 100;
                    }else if(no.dir != i){
                        new_cost = no.cost + 600;
                    }
                    
                    if(map[movex][movey] == 0){
                        map[movex][movey] = new_cost;
                        que.add(new Node(movex,movey, new_cost, i));
                    }else if(map[movex][movey] >= new_cost){
                        map[movex][movey] = new_cost;
                        que.add(new Node(movex,movey, new_cost, i)); 
                    }
                }
            }
        }
    }
    
    public static class Node{
        int x,y,cost,dir;
        Node(int x, int y, int cost,int dir){
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
    
    
}
