import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sum =0;//최종답
        int zero = 0;
        int one = 0;
        
        String st[] = br.readLine().split("");
        
        for(int i=0; i < st.length-1; i++){
            int num = Integer.parseInt(st[i]);
            int num2 = Integer.parseInt(st[i+1]);
            
            if(num != num2){
                if(num == 1){
                    one++;
                }else if(num == 0){
                    zero++;
                }
            }
            
            if(i == st.length-1){
                if(num == 1){
                    one++;
                }else if(num == 0){
                    zero++;
                }
                break;
            }
            
        }
        
        System.out.println(zero > one ? zero : one);
        
        
    }
}
