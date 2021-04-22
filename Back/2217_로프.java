import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int count = sc.nextInt();//줄의 갯수
        Integer lope[] = new Integer[count];
        
        for(int i =0; i < count; i++){
            lope[i] = sc.nextInt();
        }
        
        Arrays.sort(lope,Collections.reverseOrder());
        
        int a =1;
        int max = lope[0];
        
        for(int i=1; i < count; i++){
            a++;
            if(lope[i]*a >= max){
                max = lope[i] *a;
            }
        }
        System.out.println(max);
        
    }
}
