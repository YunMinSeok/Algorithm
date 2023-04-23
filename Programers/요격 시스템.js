function solution(targets) {
    let answer = 0;
    targets.sort((a, b) => {
        if (a[1] == b[1]) {
            return a[0] - b[0];
        }
        return a[1] - b[1];
    });
    
    let cut = -1
    for(let i=0; i< targets.length; i++){
        let left = targets[i][0];
        let right = targets[i][1];
        if (left >= cut) {
            answer++;
            cut = right;
        }
    }
    
    return answer;
}
