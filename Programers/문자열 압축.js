function solution(s) {
    let min_len = s.length;
    
    for(let i=1; i<= s.length/2; i++){
        let prev = s.substr(0,i);
        let cnt = 1;
        let tmp = "";
        for(let k =i; k<s.length; k+=i){
            const cur = s.substr(k,i);
            if(prev === cur) cnt++;
            else{
                tmp += (cnt > 1 ? cnt : "") +prev;
                cnt = 1;
                prev = cur;
            }
        }
        tmp += (cnt > 1 ? cnt : "") +prev;
        min_len = Math.min(min_len, tmp.length)
    }
    
    return min_len;
}
