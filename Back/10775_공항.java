import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int ans = 0;//답
        int G = sc.nextInt();//게이트의 수
        int P = sc.nextInt();//비행기의 수
        
        int airport[] = new int[G+1];//연결될 게이트 배열
        
        loop:
            for(int i=0; i < P; i++){
                int a = sc.nextInt();//비행기의 번호

                while(airport[a] != 0){
                    int minus = airport[a];
                    
                    if(a-minus<=0){
                        break loop;    
                    }else{
                        airport[a] += 1;
                        a -= minus;
                    }
                }//else 끝
                
                airport[a] +=1;
                ans++;
            }
        
        System.out.println(ans);
    }
}
