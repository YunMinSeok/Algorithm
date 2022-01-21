function solution(s) {
    var answer = '';
    
    let middle = Math.floor(s.length / 2);
    
    if(s.length % 2 == 0){
        answer = s.substring(middle-1,middle+1);
    }else{
        answer = s.substring(middle,middle+1);
    }
    
    return answer;
}
