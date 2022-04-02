function solution(s) {
    let alpha = ["zero","one","two","three","four","five","six","seven","eight","nine"];
    let answer = s;
    
    for(let i=0; i< alpha.length; i++){
        let arr = answer.split(alpha[i]);
        answer = arr.join(i)
    }
    
    return Number(answer);
}
