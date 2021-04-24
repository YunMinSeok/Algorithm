import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int count = sc.nextInt();//사람수
        int sum = 0; // 시간 총합
        int []time = new int[count];//각각의 시간
        
        for(int i = 0 ; i < count; i++){
            time[i]= sc.nextInt();
        }
        
        Arrays.sort(time);//배열 오름차순
        
        for(int i = 0 ; i < count; i++){
            for(int j = 0 ; j<= i; j++){
                sum += time[j];
            }
        }
        
        System.out.println(sum);
    }
}
