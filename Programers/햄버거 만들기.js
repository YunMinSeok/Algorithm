function solution(ingredient) {
    let answer = 0;
    let stack = [];
    
    ingredient.forEach((num)=>{
        stack.push(num);
        
        if(stack.length >= 4){
            const find = stack.slice(-4).join("")
           if(find === "1231"){
               answer++;
               stack.pop()
               stack.pop()
               stack.pop()
               stack.pop()
           }
        }
    })
    
    return answer;
}
