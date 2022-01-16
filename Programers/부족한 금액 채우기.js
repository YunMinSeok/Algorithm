function solution(price, money, count) {
    var answer = 0;
    
    let result = 0;
    for(let i=1; i <= count; i++){
        result += price * i;
    }
    
    if(result > money){
    answer = result - money;
    }
    
    
    return answer;
}
