import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//킬로그램 입력받기
        sc.close();
        
        int a , b;
        
        a = n/5;
        if(n==0){
            System.out.println("0");
            System.exit(0);
        }
        
        while(a>-1){
            b=0;
            while(true){
                
                int ans = a*5 + b*3;
                
                if(ans == n){
                    System.out.println(a+b);
                    System.exit(0);
                }
                
                if(ans > n){
                    break;
                }
                
                b++;
            }
            a--;
        }
        
        System.out.println("-1");
        System.exit(0);
    }
}
