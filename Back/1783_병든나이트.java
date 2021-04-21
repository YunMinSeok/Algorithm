import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int sum = 0;
        
        if(n == 1){
            sum = 1;
        }else if(n == 2){
            if(m%2 == 0 && m < 11){
                sum = m/2;
            }else if(m %2 == 1 && m < 11){
                sum = m/2+1;
            }else{
                sum = 4;
            }
             
        }else{
            if(m < 4){
                sum = m;
            }else if(m < 7){
                sum = 4;
            }else{
                sum = m-2;
            }
        }
        
        
        System.out.println(sum);
        
    }
}
