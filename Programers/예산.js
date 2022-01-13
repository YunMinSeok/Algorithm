function solution(d, budget) {
    var answer = 0;
     d.sort((a,b) => a-b);

    let result=0;
    for(let i=0; i < d.length; i++){
        if(budget >=result + d[i]){
            result += d[i];
            answer++;
        }else{
            break;
        }
    }
    return answer;
}
