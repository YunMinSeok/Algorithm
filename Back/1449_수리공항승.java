import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();//물이 새는 곳
        int L = sc.nextInt();//테이프의 길이
        
        int sum = N;// 최종답
        int len [] = new int[N];// 숫자 받는곳
        int count =0;
        
        for(int i=0; i < N; i++){
            len[i] = sc.nextInt();  
        }
        
        Arrays.sort(len);
        
        int ss = 0;
        int i=0;
        
        while(i < len.length-1){
            if(L > ss + (len[i+1] - len[i])){
                ss += (len[i+1] - len[i]);
                sum--;
            }else{
                ss =0;
            }
            i++;
        }
        
        System.out.println(sum);
        
    }
}
