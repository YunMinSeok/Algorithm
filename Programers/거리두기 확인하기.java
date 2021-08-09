import java.util.*;

class Solution {

    static String [][] map;
    static boolean [][] chk ;
    static int [] diry = {-1,0,1,0};
    static int [] dirx = {0,1,0,-1};
    static class Node{
        int y;
        int x;
        int dis;
        public Node(int y, int x, int dis){
            this.y=y;
            this.x=x;
            this.dis = dis;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        map = new String[places.length][5];
        chk = new boolean[places.length][5];

        for(int i=0; i<places.length; i++){
            for(int j=0; j<5; j++){
                String [] line = places[i][j].split("");
                for(int k=0; k<5; k++){
                    map[j][k] = line[k]; 
                }
                Arrays.fill(chk[j],false);
            }
            int res = 1;
            for(int p=0; p<5; p++){
                for(int q=0; q<5; q++){
                    if(map[p][q].equals("P")){
                       res = Math.min(res,bfs(p,q));
                    }
                }
            }
            if(res==0){
                answer[i] = 0;
            }else{
                answer[i] = 1;
            } 
        }
        return answer;
    }

    public static int bfs(int y, int x){
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(y,x,0));
        boolean checker = true;
        chk[y][x] = true;
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(now.dis>=2){
                continue;
            }
            for(int i=0; i<4; i++){
                int now_y = now.y + diry[i];
                int now_x = now.x + dirx[i];
                int now_dis = now.dis;
                if(now_y>=0 && now_y<5 && now_x>=0 && now_x<5){
                    if(!chk[now_y][now_x]){
                        if(map[now_y][now_x].equals("O")){
                            queue.add(new Node(now_y,now_x,now_dis+1));
                        }else if(map[now_y][now_x].equals("P")){
                            if(now.dis<=2){
                                checker = false;
                                break;
                            }
                        }
                    }
                }
            }
            if(!checker){
                return 0;
            }
        }
        for(int i=0; i<chk.length; i++){
            Arrays.fill(chk[i],false);
        }
         return 1;
    }

}
