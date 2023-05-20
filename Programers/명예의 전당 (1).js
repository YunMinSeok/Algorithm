function solution(k, scores) {
    let answer = [];
    let stack = [];
    
    for(score of scores){
        if(stack.length < k){
            stack.push(score)
        }else{
            if(stack[0] < score){
                stack.shift();
                stack.push(score)   
            }
        }
        stack.sort((a,b) => a-b)
        answer.push(stack[0])
    }
    
    
    return answer;
}
