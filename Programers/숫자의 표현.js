function solution(n) {
    var answer = 0;
    
    for(let i=1; i<= n; i++){
        let count = i;
        if(i+(i+1)<=n){
            for(let j=i+1; j<=n; j++){
                if(count+j === n){
                    console.log(j)
                    answer++;
                    break;
                }else if(count + j < n){
                    count += j;
                }
                else{
                    break;
                }
            }
        }else{
            break;
        }
    }
    answer++;
    return answer;
}
