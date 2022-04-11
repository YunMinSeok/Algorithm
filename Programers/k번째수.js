function solution(array, commands) {
    let answer = [];
    
    for(let c of commands){
        let arr = array.slice(c[0]-1,c[1])
        arr.sort((a,b)=> {return a-b});
        answer.push(arr.slice(c[2]-1,c[2])[0])
    }
    
    return answer;
}
