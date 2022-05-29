function solution(N, stages) {
    let answer = [];
    
    let people = stages.length;
    
    for(let i=1; i<= N+1; i++){
        let temp = stages.filter(n=> n === i ).length;
        answer.push([i,temp/people]);
        people-= temp;
    }
    
    answer.pop();
    
    answer = answer.sort((a,b)=> b[1] - a[1]);
    
    return answer.map((a) => a[0]);
}
