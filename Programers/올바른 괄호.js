function solution(s){
    let stack = [];
    stack.push(s[0]);
    for(let i=1; i < s.length; i++){
        if(s[i] === ")"){
            stack.pop();
        }else{
            stack.push(s[i]);
        }
    }

    return stack.length === 0 ? true : false;
}
