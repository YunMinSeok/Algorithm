import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr;
    static int notTomato=0;
    static int N,M;
    static Queue<Pair> queue = new LinkedList<>();

    static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs(){
        List<Pair> list = new ArrayList<>();
        int max = 0;
        int cnt = 0;
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(pair.x!=0)
                list.add(new Pair(pair.x-1, pair.y));
            if(pair.y!=0)
                list.add(new Pair(pair.x, pair.y-1));
            if(pair.x<M-1)
                list.add(new Pair(pair.x+1, pair.y));
            if(pair.y<N-1)
                list.add(new Pair(pair.x, pair.y+1));

            Pair tmp;
            for(int i=0;i<list.size();i++) {
                tmp = list.get(i);
                if(arr[tmp.y][tmp.x]!=0)
                    continue;
                queue.add(tmp);
                cnt++; // 안익음 -> 익음 카운트
                max = Math.max(max, arr[pair.y][pair.x]+1);
                arr[tmp.y][tmp.x]=arr[pair.y][pair.x]+1;
            }
            list.clear();
        }

        if(cnt!= M*N-notTomato) // 안익은 토마토 남은 경우
            System.out.println(-1);
        else if( max == 0)
            System.out.println(0);
        else
            System.out.println(max-1);
    }

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]); // v
        N = Integer.parseInt(input[1]); // h

        arr = new int[N][M];
        for(int i=0;i<N;i++){
            input=br.readLine().split(" ");
            for(int j=0;j<M;j++) {
                int tmp = Integer.parseInt(input[j]);
                arr[i][j] = tmp;
                if(tmp!=0) {
                    notTomato++;
                    if (tmp != 1)
                        continue;
                    queue.add(new Pair(j, i));
                }
            }
        }
        bfs();
    }
}
