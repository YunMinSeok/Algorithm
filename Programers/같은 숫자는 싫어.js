function solution(arr)
{
    const answer = [];
    for(let i=0; i < arr.length; i++){
        if(arr[i+1] !== arr[i]){
            answer.push(arr[i])
        }
    }
    
    return answer;
}
