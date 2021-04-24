import java.util.*;
import java.io.*;

public class Main{
    static int N,M;
    static ArrayList<Integer>[] arr;
    static boolean[] visit;
    static int count=0;
    
    static void dfs(int v){
        Queue<Integer>que = new LinkedList<>();
        que.add(v);
        visit[v] = true;
        
        while(!que.isEmpty()){
            int cur = que.poll();
            
            for(int i=0; i < arr[cur].size(); i++){
                int y = arr[cur].get(i);
                if(!visit[y]){
                    que.add(y);
                    visit[y] = true;
                }
            }
            
        }

        return;
    }
    
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        
        arr = new ArrayList[10003];
        visit = new boolean[10003];
        
        for(int i=1; i <=N; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i=0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        for (int i = 1; i <= N; i++) {
          Collections.sort(arr[i]);
        }
        for(int i=1; i <= N; i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }
        
        System.out.println(count);
    }
}
