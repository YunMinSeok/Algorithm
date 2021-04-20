import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> crain = new ArrayList<Integer>();//크게인의 무게제한
        ArrayList <Integer> box = new ArrayList<Integer>();//박스 배열
        
        for(int i=0; i < N ; i++){
            crain.add(sc.nextInt());
        }
        
        int M = sc.nextInt();//박스의 개수
        
        for(int i=0; i <M; i++){
            box.add(sc.nextInt());
        }
        
        Collections.sort(crain, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());//내림차순 정렬
        
        int ans = 0;//최종답
        
        if(box.get(0) > crain.get(0)){
            System.out.println(-1);
        }else{
            while(box.size()!=0){
                int j=0;
                for(int i=0; i < N; i++){
                    if(j == box.size()){
                        break;
                    }
                    if(box.get(j) <= crain.get(i)){
                        box.remove(j);
                    }
                    else{
                        while(true){//이부분 물어보기
                            j++;
                            if(j == box.size()){
                                break;
                            }
                            if(box.get(j) <= crain.get(i)){
                                box.remove(j);
                                break;
                            }
                        }    
                    }
                }
                ans++; 
            }
             System.out.println(ans);
        }
        
        
    }
}
