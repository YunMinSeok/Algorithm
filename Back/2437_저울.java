import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int count = sc.nextInt();
        
        ArrayList<Integer>list = new ArrayList<Integer>();
        
        for(int i=0; i < count; i ++){
            int a = sc.nextInt();
            list.add(a);
        }
        
        Collections.sort(list);
        
        int sum = 1;
        
        for(int i=0; i < count; i++){
            if(sum < list.get(i)){
                break;
            }
            
            sum += list.get(i);
        }
        
        System.out.println(sum);
        
    }
}
