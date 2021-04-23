import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        
        int cost = sc.nextInt();//잔돈의 양
        int count = 0; //잔돈의 갯수
        int sum = 1000- cost;
        int a [] = {500,100,50,10,5,1};
        
        
        for(int i =0; i < a.length; i++){
            count += sum/a[i];
            sum = sum % a[i];
        }
        
        System.out.println(count);
    }
}
