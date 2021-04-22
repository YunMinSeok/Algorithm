import java.util.*;

public class Main{
    int count = 1;
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);// 스캐너
        ArrayList<Day> day = new ArrayList<Day>();
        int L,P,V;
        
        while(true){ 
           L = sc.nextInt();//숫자 입력받기
           P = sc.nextInt();//숫자 입력받기
           V = sc.nextInt();//숫자 입력받기
            
            if(V == 0 && L == 0 && P == 0){//0이면 그만
                break;
            }
            Day d = new Day(L,P,V);
            day.add(d);
        }
        
        int index =0;
        
        while(true){
            
            if(index == day.size()){
                break;
            }
            
            int n=0;
            
            if(day.get(index).V % day.get(index).P >= day.get(index).L){
                n = day.get(index).L;
            }else{
                n = day.get(index).V%day.get(index).P;
            }
            
            int a;
            a = (day.get(index).V/day.get(index).P)*day.get(index).L +n;
            
            System.out.println("Case " + (index+1) + ": " + a);
            index++;
        }
    }
    
   public static class Day{
    int L,P,V;   
    public Day(int L, int P, int V) {
        this.L = L;
        this.P = P;
        this.V = V;
    }
 }
    
}
