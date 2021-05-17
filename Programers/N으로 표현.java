class Solution {
    static int answer = -1;
    public int solution(int N, int number) {
        
        cal(N,number,0,0);
        
        return answer;
    }
    
    static void cal(int n, int number,int count,int acumm){
        int nn = n;
        
        if(count > 8){
            answer = -1;
            return;
        }
        if(acumm == number){
            if(answer == -1 || answer > count){
                answer = count;
                return;
            }
        }
        
        for(int i=1; i < 9-count; i++){
            cal(n,number,count + i,acumm + nn);
            cal(n,number,count + i,acumm - nn);
            cal(n,number,count + i,acumm * nn);
            cal(n,number,count + i,acumm / nn);
            
            nn = nn*10 + n;
        }
    }
}
