function solution(s) {
    let answer = [];
    let stack = [];
    
    [...s].forEach((str)=>{
        if(!stack.includes(str)){
            answer.push(-1)
        }else{
            answer.push(stack.length - stack.lastIndexOf(str));
        }
        
        stack.push(str)
    })
    
    return answer;
}
