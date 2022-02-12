function solution(n) {
    let arr =[0,1,1];
    if(n === 0){
        return 0;
   }
    else if(n === 1){
        return 1;
    }
    else{
        for(let i=2; i <= n; i++){
            arr[i] = (arr[i-2] + arr[i-1])%1234567;
        }
    }
    
    return arr[n];
}
