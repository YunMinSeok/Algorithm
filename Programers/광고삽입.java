import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playtime = timetosecond(play_time);
        int advtime = timetosecond(adv_time);
        
        long[] playcnt = new long[playtime+1];
        
        for(String log : logs){
            String[] split = log.split("-");
            playcnt[timetosecond(split[0])]++;
            playcnt[timetosecond(split[1])]--;
        }
        
        for(int i=1; i <= playtime; i++) playcnt[i] += playcnt[i-1];
        for(int i=1; i <= playtime; i++) playcnt[i] += playcnt[i-1];
        
       long maxTime = playcnt[advtime - 1], maxStartTime = 0;
        for (int i = 0; i + advtime <= playtime; i++) {
            long tmp = playcnt[i + advtime] - playcnt[i];

            if (tmp > maxTime) {
                maxTime = tmp;
                maxStartTime = i + 1;
            }
        }

        return String.format("%02d:%02d:%02d", maxStartTime / (60 * 60), (maxStartTime / 60) % 60, maxStartTime % 60);
    }
    
    int timetosecond(String str){
        int [] parse = Arrays.stream(str.split(":")).mapToInt(Integer::parseInt).toArray();
        return parse[0] *60 *60 + parse[1] *60 + parse[2];
    }
}
