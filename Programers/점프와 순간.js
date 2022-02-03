function solution(n){
    var answer = 0;
  
    while(n>0){
        if(n%2 !== 0){
            n-=1;
            answer +=1;
        }else{
            n /=2;
        }
    }
    
    return answer;
}
