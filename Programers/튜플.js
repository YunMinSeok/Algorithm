function solution(s) {
    const answer = [];
    s = s.substring(2,s.length-2).replace(/},{/gi, "-");
    let arr = s.split("-");
    
    arr = arr.sort((a,b)=>{
        return a.length - b.length;
    });
    
    for(let num of arr){
        let numArr = num.split(",");
        for(let b of numArr){
            let parseNum = parseInt(b);
            if(!answer.includes(parseNum)){
                answer.push(parseNum);
            }
        }
    }
    
    return answer;
}
