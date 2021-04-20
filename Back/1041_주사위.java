import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long N = Long.parseLong(br.readLine());//주사위 개수
        ArrayList<Integer>num = new ArrayList<Integer>();//주사위숫자
        long sum =0;//최종답
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        while(st.hasMoreTokens()){
            num.add(Integer.parseInt(st.nextToken()));
        }//값 받는거 마무리
        
        if(N ==1){//주사위가 한개일 경우
            Collections.sort(num);
            for(int i=0;i <5; i++){
                sum += num.get(i);
            }
        }else{

            int one = Collections.min(num);//면의 개수
            
            int sums[] = new int[3];
            sums[0] = Math.min(num.get(0),num.get(5));
            sums[1] = Math.min(num.get(1),num.get(4));
            sums[2] = Math.min(num.get(2),num.get(3));
            
            int two = Math.min(sums[0] +sums[1], Math.min(sums[1] + sums[2], sums[0] + sums[2]));
            long three =0;
            
            for(int i=0; i < 3; i++){
                three += sums[i];
            }
            
            sum += ((N-2) * (N-2) * 5 + (N-2) *4) * one;//면 1
            sum += ((N-2) * 8 + 4) * two;//면 2
            sum +=  4 * three;//면 3
        }
        System.out.println(sum);
    }
}
