import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        boolean c[] =new boolean[4];
        Arrays.fill(c,false);
        char alp[] = {'U','C','P','C'};
        
        String st = br.readLine();
        
        char ch[] = st.toCharArray();
        
        int pp= 0;
        
        for(int i=0; i < ch.length && pp < 4; i++){
            if(Character.isUpperCase(ch[i]) == true){
                if(ch[i] == alp[pp]){
                    c[pp]= true;
                    pp++;
                }
            }
            
        }
        
        if(c[0] && c[1] && c[2] && c[3] == true){
            System.out.println("I love UCPC");    
        }else{
            System.out.println("I hate UCPC");
        }
        
        
    }
}
