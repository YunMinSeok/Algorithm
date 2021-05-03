import java.util.*;

class Solution {
    static ArrayList<Long> numlist = new ArrayList<>();
    static ArrayList<String>operlist = new ArrayList<>();
    static long answer = Long.MIN_VALUE;
    static String[] oper= {"+", "-", "*"};
    static String[] output = new String[3];
    static boolean visit[] = new boolean[3];
    
    public long solution(String expression) {
        
        
        String n ="";
        
        for(int i=0; i < expression.length(); i++){
            char exp = expression.charAt(i);`
            if(exp == '*' ||exp == '-'||exp == '+'){
                operlist.add(exp + "");
                numlist.add(Long.parseLong(n));
                n = "";
            }else{
                n += exp;
            }
        }
        
        numlist.add(Long.parseLong(n));
        
        per(0,oper.length);
        
        return answer;
    }
    
    static void per(int depth, int r){
        if(depth == r){
            solve();
            return;
        }
        for(int i=0; i < oper.length; i++){
            if(!visit[i]){
                visit[i] = true;
                output[depth] = oper[i];
                per(depth+1,r);
                visit[i] = false;
            }
        }
    }
    
    static void solve(){
        ArrayList<String>oper = new ArrayList<>();
        oper.addAll(operlist);
            
        ArrayList<Long> num = new ArrayList<>();
        num.addAll(numlist);
        
        for(int i=0; i <output.length; i++){
            String curoper = output[i];
            
            for(int j=0; j < oper.size(); j++){
                if(oper.get(j).equals(curoper)){
                    long n1 = num.get(j);
                    long n2 = num.get(j+1);
                    long res = cal(n1,n2,curoper);
                    
                    num.remove(j+1);
                    num.remove(j);
                    oper.remove(j);
                    
                    num.add(j,res);
                    
                    j--;
                }
            }
        }
        answer = Math.max(answer,Math.abs(num.get(0)));
    }
    
    static long cal(long n1, long n2, String o){
        long res =0;
        
        switch(o){
            case "+":
                res = n1+n2;
                break;
            case "-":
                res = n1-n2;
                break;
            case "*":
                res = n1*n2;
                break;
        }
        return res;
    }
}
