function solution(number, limit, power) {
    let answer = 0;
    
    for(let j = 1; j <= number; j++){
        let arr = 0;
        for(let i = 1; i <= Math.sqrt(j); i++){
            if(j % i === 0){
                arr++;
                if(j / i !== i){
                    arr++;
                }
            }
        }
        if(arr <= limit){
            answer += arr;
        }else{
            answer += power
        }
    }
    
    return answer;
}
