import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int count = sc.nextInt();//원의 종류
        int won = sc.nextInt();//총 금액
        int []a = new int[count];//원의 종류를 담는 배열
        int b = count-1;
        int sum = 0;
        
        for(int i=0; i < count; i++){
            a[i]= sc.nextInt();
        }
        
        while(true){
            if(won>=a[b]){
                sum += won/a[b];
                won = won % a[b];
            }else{
                b--;
            }
            
            if(won == 0){
                System.out.println(sum);
                System.exit(0);
            }
        }
        
        
    }
}
