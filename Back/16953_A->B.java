import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        long A = (long)(sc.nextInt());
        long B = (long)(sc.nextInt());
        
        int sum =0;
        
        while(true){
             if(A == B){
                 sum+=1;
                 break;
             }
            if(A > B){
                sum=-1;
                break;
            }
            
            if(B %10 == 1){
                B/=10;
            }else if(B%2 == 0){
                B/=2;
            }else{
                sum= -1;
                break;
            }
            
            sum++;
        }
        System.out.println(sum);
        
    }
}
