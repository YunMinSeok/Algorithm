function solution(n) {
    var answer = "";
    
    n = n.toString(3).split("");
    
    while(n.length){
        answer += n.pop()
    }
    
    answer = parseInt(answer,3);
    
    return answer;
}
