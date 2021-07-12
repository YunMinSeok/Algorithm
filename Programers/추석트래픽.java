import java.text.SimpleDateFormat;
import java.util.*;

class Solution {
    public static int solution(String[] lines) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

        int[] counts = new int[lines.length];
        int max = 0;

        for(int i=0; i<lines.length; i++) {
            
            String[] pre = lines[i].split(" ");
            Date preEndDate = format.parse(pre[1]);
            long preEnd = preEndDate.getTime();

            
            for (int j = i ; j < lines.length; j++) {
                
                String[] next = lines[j].split(" ");
                Date nextEndDate = format.parse(next[1]);
                double sec = Double.parseDouble(next[2].substring(0, next[2].length()-1)); 

                
                long nextStart = (long) (nextEndDate.getTime() - sec*1000 + 1);

                
                if(preEnd + 1000 > nextStart) {
                    counts[i] += 1;
                    max = Math.max(max, counts[i]);
                }
            }
        }
        return max;
    }
}
