import java.util.*;

public class Main{
    public static void main(String [] args){
        Scanner sc = new Scanner (System.in);
        
        int count = sc.nextInt(); // 수열의 크기
        int zero = 0;// 0의 갯수
        int sum = 0;// 총 합의 수
        ArrayList <Integer>plist = new ArrayList<Integer>();//양수 list
        ArrayList <Integer>mlist = new ArrayList<Integer>();//음수 list
        
        for(int i=0; i < count; i++){
            int num = sc.nextInt();
            
            if(num == 0){
                zero += 1;//0일 경우
            }else if(num == 1){
                sum += num;//1일 경우
            }else if(num > 0){
                plist.add(num);//양수일 경우
            }else if(num < 0){
                mlist.add(num);//음수일 경우
            }
            
        }//for 문 끝
        
        Collections.sort(plist);
        Collections.sort(mlist);
        Collections.reverse(plist);
        
        if(plist.size() % 2 == 1){//양수배열이 홀수일 경우
            plist.add(1);
        }
        
        if(mlist.size() % 2 == 1){//음수배열이 홀수일 경우
            mlist.add(zero > 0 ? 0 : 1);
        }
        
        for(int i=0; i < plist.size(); i+=2){//양수 계산
            sum += plist.get(i) * plist.get(i+1);
        }
        
        for(int i=0; i < mlist.size(); i+=2){//음수 계산
            sum += mlist.get(i) * mlist.get(i+1);
        }
        
        System.out.println(sum);
    }
}
