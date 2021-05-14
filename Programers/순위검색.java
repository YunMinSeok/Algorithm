import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String , List<Integer>>map = new HashMap<>();
        
        for(String in : info){
            String[] split = in.split(" ");
            int score = Integer.parseInt(split[4]);
            
            for(int i=0; i < (1<<4); i++){
                StringBuilder key = new StringBuilder();
                for(int j=0; j < 4; j++){
                    if((i&(1<<j))>0) key.append(split[j]);
                }
                map.computeIfAbsent(key.toString(), s-> new ArrayList<>()).add(score);
            }
        }
        
        for(Map.Entry<String,List<Integer>>entry : map.entrySet()){
            entry.getValue().sort(null);
        }
        
        int[] answer = new int[query.length];
        
        for(int i=0; i < query.length; i++){
            String[]splits = query[i].replaceAll("-","").replaceAll(" and ","").split(" ");
            String key = splits[0];
            int score = Integer.parseInt(splits[1]);
            List<Integer>list = map.getOrDefault(key,new ArrayList<>());
            int start = 0;
            int end = list.size();
            
            while(start < end){
                int mid = (start+end)/2;
                if(list.get(mid)<score){
                    start = mid +1;
                }else{
                    end = mid;
                }
            }
            answer[i] = list.size() - start;
        }
        
        return answer;
    }
}
