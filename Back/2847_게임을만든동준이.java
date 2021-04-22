import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int lev[] = new int[N+1];
        
        
        for(int i=1; i < N+1; i++){
            st =new StringTokenizer(br.readLine());
            lev[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int score = lev[N];
        
        for(int i= N-1; i>0; i--){  
            while(lev[i] >= score){
                lev[i] -= 1;
                sum++;
            }
            score = lev[i];
        }
        
        System.out.println(sum);
    }
}
