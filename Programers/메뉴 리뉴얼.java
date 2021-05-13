import java.util.*;

class Solution {
    
    static HashMap<String,Integer> map;
    static int m;
    
    public String[] solution(String[] orders, int[] course) {
        PriorityQueue <String>pq = new PriorityQueue<>();
        for(int i = 0 ; i < course.length; i++){
            map = new HashMap<>();
            m = 0;
            
            for(int j=0; j < orders.length; j++){
                find(0,"",course[i],0,orders[j]);
            }
            
            for(String s : map.keySet()){
                if(map.get(s) == m && m>1){
                    pq.offer(s);
                }
            }
        }
        
        
        String[] answer = new String[pq.size()];
        int k=0;
        while(!pq.isEmpty()){
            answer[k++]= pq.poll();
        }
        return answer;
    }
    
    static void find(int cnt,String str, int targetNum,int idx, String word){
        if(cnt==targetNum){
            char c[] = str.toCharArray();
            Arrays.sort(c);
            String temp = "";
            
            for(int i=0; i < c.length; i++){
                temp += c[i];
            }
            map.put(temp, map.getOrDefault(temp,0)+1);
            m = Math.max(m,map.get(temp));
            return;
        }
        for(int i=idx; i < word.length(); i++){
            char now = word.charAt(i);
            find(cnt+1,str+now,targetNum,i+1,word);
        }
    }
}
