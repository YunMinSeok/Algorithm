import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());//꽃의 개수
        int [][] flower = new int[N][2];
        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            flower[i][0] = a*100+b;
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            flower[i][1] = c*100+d;
        }
        
        Arrays.sort(flower,(o1,o2)->{
           if(o1[0] == o2[0]){
               return Integer.compare(o1[1],o2[1]);
           }else{
               return Integer.compare(o1[0],o2[0]);
           }
        });//피어난 날짜로 정렬
        
        int ans=0;//최종답
        int i=0;//flower[i][]
        int date = 301;
        int max =0;//끝나는 날짜 저장소
        boolean t = false;
        int maxint =0; //배열의 숫자 받는것
        while(date <= 1131 && i < N){
            for(int j =i; j < N; j++){
                if(date > flower[j][1]){
                    continue;
                }
                if(date >= flower[j][0]){
                    int tmp = flower[j][1];
                    if(max < tmp){
                        max = tmp;
                        maxint = j;
                        t = true;
                    }
                }else{
                    break;
                }
                 
            }
           
            if(t){
                date = max;
                i = maxint;
                ans++;
                t = false;
            }else{
                break;
            }
            i++;
        }
        
        if(date < 1131){
            System.out.println("0");
        }else{
            System.out.println(ans);    
        }
        
    }
}
