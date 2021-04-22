import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int count = Integer.parseInt(br.readLine());//좌석 갯수
        String[] st = br.readLine().split("");//좌석 입력
        
        int people = 0;//정답
        int cup = 1;
        int a=0;
        for(int i=0; i < count; i++){
            if(st[i].equals("S")){
                people+=1;
                cup+=1;
            }else if(st[i].equals("L")){
                a++;
                people+=1;
                if(a == 2){
                    cup+=1;
                    a=0;
                }
            }
        }
        
        
        System.out.println(people > cup ? cup : people);
    }
}
