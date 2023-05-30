function solution(survey, choices) {
    let answer = '';
    const types = { R: 0, T: 0, C: 0, F: 0, J: 0, M: 0, A: 0, N: 0 };
    for(let i=0; i < survey.length; i++){
        const [front,back] = survey[i].split("")
        const value = Math.abs(choices[i] - 4)
        if(choices[i] < 4){
            types[front] += value
        }else{
            types[back] += value
        }
    }
    const type = Object.keys(types);
    
    for(let i=0; i < type.length; i+=2){
        const leftType = types[type[i]]
        const rightType = types[type[i+1]]
        if (leftType >= rightType) {
          answer += type[i];
        } else {
          answer += type[i + 1];
        }
    }
    
    return answer;
}
