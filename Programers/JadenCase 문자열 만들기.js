function solution(s) {
    var answer = '';
    
    let arr = s.split(" ");
    
    for(let i=0, len = arr.length; i< len; i++){
        arr[i] = arr[i].charAt(0).toUpperCase() +  arr[i].slice(1).toLowerCase();
        if(i === len-1){
            answer += arr[i];
        }else{
        answer += arr[i] + " ";
            }
    }
    
    return answer;
}
