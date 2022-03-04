function solution(n) {
    let result = ""
    for(let i = 1; i<=n; i++){
        if(i % 2 === 0){
            result += "박"
        }else{
            result += "수"
        }
    }
    return result
}
