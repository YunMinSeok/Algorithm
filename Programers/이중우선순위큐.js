function solution(operations) {
    const answer = [];
    
    while(operations.length >0){
        let val =  operations.shift().split(" ");
        if(val[0] === "I"){
            answer.push(Number(val[1]))
        }else{
            if(val[1] === "-1"){
               answer.pop();
            }else if(val[1] === "1"){
               answer.shift();
            }
        }
          answer.sort((a,b)=>{
              return b-a;
          });
    }
    
    if(answer.length === 0){
        return [0,0];
    }else{
        return [Math.max(...answer),Math.min(...answer)]
    }
}
