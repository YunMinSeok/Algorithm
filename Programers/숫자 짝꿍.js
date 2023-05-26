function solution(X, Y) {
    let answer = [];
    
    let countX = new Array(10).fill(0);
    const xArr = X.split("");
    
    xArr.forEach((item)=>{
        countX[item]++;
    })
    
    
    let countY = new Array(10).fill(0);
    const yArr = Y.split("");
    
    yArr.forEach((item) => {
        countY[item]++;
    })
    
    countX.forEach((item, index) => {
        if(item !== 0 && countY[index] !== 0){
            const min = Math.min(item, countY[index]);
            
            answer.push(String(index).repeat(min));
        }
    })
    
    if(answer.length === 0){
        return "-1"
    }
    
    if(Number(answer.join("")) === 0){
        return "0"
    }
    
    
    return answer.reverse().join("");
}
