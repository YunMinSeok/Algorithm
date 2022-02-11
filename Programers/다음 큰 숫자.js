function solution(n) {
    var answer = 0;
    
    let str = n.toString(2);
    let count = str.match(/1/g).filter(item => item !== '').length;
    
    
    while(true){
        n++;
        let cc = n.toString(2);
        let ct = cc.match(/1/g).filter(item => item !== '').length;
        if(count === ct){
            answer = n;
            break;
        }
    }
    
    return answer;
}
