import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        Map<Integer,Double>map = new HashMap<>();
        
        for(int i=1; i <= N; i++){
            int stage = i;
            int noclearplayer = 0;
            int currentstageplayer = 0;
            
            for(int j=0; j < stages.length; j++){
                int player = stages[j];
                
                if(stage == player){
                    noclearplayer++;
                }
                if(stage<=player){
                    currentstageplayer++;
                }
            }
            
            double failure = 0;
            if(noclearplayer!=0 && currentstageplayer!=0){
                failure = (double)noclearplayer/(double)currentstageplayer;
            }
            map.put(stage,failure);
        }
        
        for(int i=0; i < N; i++){
            double max = -1;
            int maxKey = 0;
            
            for(Integer key : map.keySet()){
                if(max < map.get(key)){
                    max = map.get(key);
                    maxKey = key;
                }
            }
            answer[i] = maxKey;
            map.remove(maxKey);
        }
        
        return answer;
    }
}
