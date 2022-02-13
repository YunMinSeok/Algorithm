function solution(s) {
    var answer = '';
    
    s= s.split(" ").map((item)=>{
        return parseInt(item)
    });
    
    answer += Math.min.apply(null,s) + " ";
    answer += Math.max.apply(null,s)
    
    
    
    return answer;
}
