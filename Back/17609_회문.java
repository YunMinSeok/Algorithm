import java.util.*;
import java.io.*;

public class Main{
    static boolean sss(char[] line , int first, int end){
        while(first < end){
                if(line[first] == line[end]){
                    first++;
                    end--; 
                }else{
                    return false;
                }
            }
        return true;
    }
    static int ss(char[] line , int first, int end){
        boolean ans1 =false;
        boolean ans2 =false;
        while(first < end){
                if(line[first] == line[end]){
                    first++;
                    end--; 
                }else{
                    ans1 = sss(line,first+1,end);  
                    ans2 = sss(line,first,end-1);
                    
                    if (ans1 == true || ans2 == true) return 1;
                    else{
                        return 2;
                    }   
                }
            }//while
            return 0;
    }
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());//문자열 개수
        
        for(int i=0; i < T; i++){
            char[] line = br.readLine().toCharArray();
            int first = 0;
            int end = line.length-1;
            int ans = ss(line,first,end);
            System.out.println(ans);
        }
        
    }
}
