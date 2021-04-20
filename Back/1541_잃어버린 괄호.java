import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        String s[] = sc.nextLine().split("-");
        int result = 0;
        
        for(int i=0; i < s.length; i++){
            int num=0;
            if(s[i].contains("+")){
                for(String plus_num : s[i].split("\\+")){
                    num += Integer.parseInt(plus_num);                
                }
            }else{
                num = Integer.parseInt(s[i]);
            }
            
            result = (i==0) ? num : result-num;
        }
        
        System.out.println(result);
    }
}
