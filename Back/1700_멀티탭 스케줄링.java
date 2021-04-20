import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//멀티탭 구멍 개수
        int K = sc.nextInt();//전기용품 총 사용 횟수
        int a[] = new int[K];//전기용품이용 순서 배열
        int [] how = new int[101];//몇번 출현하는지
        
        for(int i=0; i < K; i++){//사용 순서 배열 입력
            a[i] = sc.nextInt();    
            how[a[i]]++;
        }
        
        int sum = 0;//최종답
        List<Integer>li = new ArrayList<>();
       for(int i = 0; i < K; i++){
           how[a[i]]--;
           
           if(li.contains(a[i])) continue;//이미 값이 있을때
           
           if(li.size() >= N){//값이 없을때
               sum++;
               boolean ok = false;//삭제여부
               for(int j=0; j< li.size(); j++){//앞으로 사용하지 않는 수 찾기
                   if(how[li.get(j)] <= 0){//출현횟수가 0보다 작으면 앞으로 안나옴
                       li.remove(new Integer(li.get(j)));
                       ok = true;
                       break;
                   }
               }
               if(!ok){//앞으로 사용하지 않는 수가 없을시 가장 나중에 출현한수 지움
                   boolean [] b = new boolean[N];
                   int check = N;
                   loop:{
                       for(int j = i+1; j < K; j++){
                           for(int k=0; k <N; k++){
                               if(li.get(k) == a[j] && !b[k]){
                                   b[k]= true;
                                   check--;
                                   if(check == 0){
                                       li.remove(new Integer(a[j]));
                                       break loop;
                                   }
                                   break;
                               }
                           }
                       }
                   }
               }
           }
           li.add(a[i]);
        }
        
        System.out.println(sum);
        
    }
}
