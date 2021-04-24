import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int count = sc.nextInt();//도시의 개수
        count--;
        long mx = 1000000001;
        
        long ln[] = new long [count];// 도시끼리의 거리
        //int price[] = new int[count];// 기름 가격
        long sum = 0;// 최종값
        
        for(int i=0; i < count; i++){//거리 값 입력
            ln[i] = sc.nextLong();
        }
        
        for(int i=0; i < count; i++){//가격 입력
            //price[i] = sc.nextInt();
            long s = sc.nextLong();
            mx = mx > s ? s : mx;
            sum += mx * ln[i];
        }
        
        System.out.println(sum);
        
    }
}
