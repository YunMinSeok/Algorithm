import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        PriorityQueue<Integer>crew = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o1-o2;
            }
        });
        
        for(String table : timetable){
            int time = Integer.parseInt(table.substring(0,2))*60 + Integer.parseInt(table.substring(3));
            crew.add(time);
        }
        
        int bustime = 9*60;
        
        int last = 0;
        
        while(n-->0){
            int accept = m;
            int time = 0;
            while(!crew.isEmpty()){
                if(crew.peek() <= bustime && accept > 0){
                    accept--;
                    time = crew.poll();
                }else break;
            }
            if(n>0){
                if(crew.isEmpty()){
                    last = bustime + ((n+1)*t);
                    break;
                }
                bustime += t;
            }else{
                if(accept>0) last = bustime;
                else last = time-1;
                
                break;
            }
            
        }
         answer = String.format("%02d",last/60) + ":" + String.format("%02d", last%60);
        
        return answer;
    }
}
