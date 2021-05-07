import java.util.*;
class Solution {
    
    static HashMap<Long,Long>hs = new HashMap<>();
    
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for(int i=0; i< room_number.length; i++){
            answer[i]= findroom(room_number[i]);
        }
        
        return answer;
    }
    
    static long findroom(long rn){
        if(!hs.containsKey(rn)){
            hs.put(rn, rn+1);
            return rn;
        }
        
        long nextroom = hs.get(rn);
        long emptyroom = findroom(nextroom);
        
        hs.put(rn,emptyroom);
        return emptyroom;
        
    }
}
