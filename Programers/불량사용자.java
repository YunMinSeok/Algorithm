import java.util.*;

class Solution {
    
    static boolean [] visit;
    static Set<String>set = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        visit = new boolean[user_id.length];
        dfs(0,"",user_id,banned_id);
        
        return set.size();
    }
    
    static void dfs(int n,String str,String[] uid,String[] bid){
        if(n== bid.length){
            String [] strarr = str.split(" ");

            Arrays.sort(strarr);
            StringBuilder sb = new StringBuilder();
            for(String s : strarr){
                sb.append(s);
            }
            set.add(sb.toString());
            return;
        }
        String reg = bid[n].replace("*","[\\w\\d]");
        
        for(int i=0; i < uid.length;i++){
            if(uid[i].matches(reg)&& !visit[i]){
                visit[i] = true;
                dfs(n+1,str + " " + uid[i],uid,bid);
                visit[i] = false;
            }
        }
    }
}
