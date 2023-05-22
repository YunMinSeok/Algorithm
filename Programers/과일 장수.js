function solution(k, m, score) {
    let answer = 0;
    
    score.sort((a,b)=> b-a)
    
    for(let i=0; i < score.length; i+=m){
        if(score.length - i < m){
            break;
        }
        let min = 100;
        let all = 0;
        for(let j=i; j<i+m; j++){
            if(min > score[j]){
                min = score[j]
            }
            all += score[j];
        }
        answer += min * m;
    }
    
    return answer;
}
