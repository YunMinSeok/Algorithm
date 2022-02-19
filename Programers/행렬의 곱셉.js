function solution(a, b) {
    var answer = [];
    
    for(let i=0; i <a.length; i++){
        let arr = a[i];
        answer.push([]);
        for(let j=0; j <b[0].length; j++){
            let sum = 0;
            for(let z=0; z<b.length; z++){
               sum += arr[z]*b[z][j];
            }
            answer[i].push(sum);
        }
    }
    
    return answer;
}
