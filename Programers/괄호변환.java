import java.util.*;
class Solution {
    int position;
    public String solution(String p) {
        
        if(p.isEmpty()) return p;
        
        boolean correct = isCorrect(p);
        
        String u = p.substring(0,position);
        String v = p.substring(position,p.length());
        
        if(correct){
            return u + solution(v);
        }
        
        String answer = "(" + solution(v) + ")";
        
        for(int i=1; i < u.length()-1; i++){
            if(u.charAt(i)== '('){
                answer += ")";
            }else{
                answer += "(";
            }
        }
        
        return answer;
    }
    boolean isCorrect(String str){
        boolean ret = true;
        int left = 0, right= 0;
        Stack<Character>st = new Stack<>();
        
        for(int i= 0 ; i < str.length(); i++){
            if(str.charAt(i) == '('){
                left++;
                st.push('(');
            }
            else{
                right++;
                if(st.isEmpty()){
                    ret = false;
                }else{
                    st.pop();
                }
            }
            if(left == right){
                position = i+1;
                return ret;
            }
        }
        return true;
    }
}
