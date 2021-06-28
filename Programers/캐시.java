import java.util.*;

class Solution {
    
    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;
    
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return 5 * cities.length;
        
        int answer = 0;
        
        LinkedList<String> cache = new LinkedList<>();
        
        for(int i = 0 ; i < cities.length ; ++i){
            String city = cities[i].toUpperCase();
            
            // cache hit
            if(cache.remove(city)){
                cache.addFirst(city);
                answer += CACHE_HIT;
            
            // cache miss
            } else {
                int currentSize = cache.size();
                
                if(currentSize == cacheSize){
                    cache.pollLast();
                }
                
                cache.addFirst(city);
                answer += CACHE_MISS;
            }
        }
        return answer;
    }
}
