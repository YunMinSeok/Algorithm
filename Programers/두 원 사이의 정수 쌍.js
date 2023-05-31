function solution(r1, r2) {
    let answer = 0;
    for(let x= 1; x <= r2; x++){
        const y1 = Math.floor(Math.sqrt(r2 ** 2 - x ** 2));
        const y2 = x >= r1 ? 0 : Math.ceil(Math.sqrt(r1 ** 2 - x ** 2));
        answer += y1 - y2 + 1;
    }
    
    return answer * 4;
}
