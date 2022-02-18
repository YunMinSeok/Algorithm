function solution(A,B){
    var answer = 0;
    
    A.sort(function(a, b) {
      return a-b;
    });
    B.sort(function(a, b) {
      return b-a;
    });
    
    
    for(let i=0;i < A.length; i++){
        answer+= A[i] * B[i]
    }
    return answer;
}
