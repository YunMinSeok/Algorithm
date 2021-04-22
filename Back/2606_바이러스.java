import java.util.*;
import java.io.*;

public class Main{
    static int computer,linecount;
    public static ArrayList<Integer>[] line;
    public static boolean[] visit;
    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        computer = Integer.parseInt(br.readLine());
        linecount = Integer.parseInt(br.readLine());
        
        line = new ArrayList[1001];
        
        for(int i=0; i <= computer; i++){
            line[i]= new ArrayList<>();
        }
        
        for(int i=0; i< linecount; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            line[x].add(y);
            line[y].add(x);
        }
        visit = new boolean[computer+1];
        bfs(1);
        
    }//메인 끝
    
    static int count=0;
    
    public static void bfs(int birus){
        Queue<Integer> que = new LinkedList<>();
        que.add(birus);
        visit[birus] = true;
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int i=0; i < line[cur].size(); i++){
                int a = line[cur].get(i);
                if(!visit[a]){
                    que.add(a);
                    visit[a] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    
    
}//클래스 끝
