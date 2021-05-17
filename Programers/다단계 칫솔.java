import java.util.*;
class Solution {
    
    static HashMap<String,String> parentMap = new HashMap<>();
    static HashMap<String,Integer> countMap = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for(int i=0; i < enroll.length;i++){
            parentMap.put(enroll[i],referral[i]);
            countMap.put(enroll[i],i);
        }
        
        for(int i=0; i < seller.length; i++){
            String now = seller[i];
            int profit = 100* amount[i];
            
            while(!now.equals("-")){
                
                int parentprofit = profit/10;
                int nowprofit = profit - parentprofit;
                
                answer[countMap.get(now)] += nowprofit;
                
                now = parentMap.get(now);
                profit /=10;
                
                if(profit<1){
                    break;
                }
            }
        }
        
        return answer;
    }
}
