import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//글자수
        int K = Integer.parseInt(st.nextToken());//빼야하는 글자수
        
        Deque<Character> dq = new ArrayDeque<Character>();
        String input =  br.readLine();
        char[] numstr = input.toCharArray();
        StringBuilder str = new StringBuilder();
        
        for(int i=0; i< N; i++){
            while(!dq.isEmpty() && K > 0 && dq.getLast() < numstr[i]){
                dq.pollLast();//맨마지막값 삭제
                K--;
            }
            dq.addLast(numstr[i]);
        }
        
        while(dq.size() > K){
            str.append(dq.removeFirst());
        }
        
        System.out.println(str);
    }
}
