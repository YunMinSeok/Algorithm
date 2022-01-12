function solution(lottos, win_nums) {
    var answer = [];
    
    var zero = 0;
    var ans =0;
    
    for(var i=0; i < lottos.length; i++){
        if(lottos[i] == 0){
            zero++;
            continue;
        }
        if(win_nums.includes(lottos[i])){
            ans++;
        }
    }
    
    var max = ans + zero;
    var min = ans;
    
    if(max == 6){
        max = 1;
    }else if(max == 5){
        max = 2;
    }else if(max == 4){
        max = 3;
    }else if(max == 3){
        max = 4;
    }else if(max == 2){
        max = 5;
    }else{
        max = 6;
    }
    
    if(min == 6){
        min = 1;
    }else if(min == 5){
        min = 2;
    }else if(min == 4){
        min = 3;
    }else if(min == 3){
        min = 4;
    }else if(min == 2){
        min = 5;
    }else{
        min = 6;
    }
    
    
    answer.push(max);
    answer.push(min);
    
    return answer;
}
