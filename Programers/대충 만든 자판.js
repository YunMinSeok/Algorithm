function handleKeymap (keymap,target) {
    let value = [];
    for(let i=0; i< keymap.length; i++){
        for(let j=0; j< keymap[i].length; j++){
            if(keymap[i][j] === target){
                value.push(j);
            }
        }
    }
    
    value.sort((a,b) => a-b)
    
    return value[0] + 1;
}

function solution(keymap, targets) {
    let answer = [];
    
    for(let i=0; i < targets.length; i++){
        let res = 0;
        
        for(let j=0; j<targets[i].length; j++){
            res += handleKeymap(keymap,targets[i][j])
        }
        
        if(isNaN(res)){
            answer.push(-1)
        }else{
            answer.push(res)
        }
    }
    
    return answer;
}
