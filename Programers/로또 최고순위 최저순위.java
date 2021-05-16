class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int low = 0;
        int zero = 0;
        
        for(int i= 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
                continue;
            }
            for(int j=0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    low++;
                }
            }
        }
        answer[0] = rank(low+zero);
        answer[1] = rank(low);
        
        return answer;
    }
    
    static int rank(int a){
        int aa= 0;
        if(a == 6){
            aa = 1;
        }else if(a == 5){
            aa = 2;
        }else if(a == 4){
            aa = 3;
        }else if(a == 3){
            aa = 4;
        }else if(a == 2){
            aa = 5;
        }else{
            aa = 6;
        }
        return aa;
    }
}
