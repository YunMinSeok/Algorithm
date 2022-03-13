function solution(fees, records) {
    let answer = [];
    const [limitTime, feePerLimit, minute, feePerMinute] = fees;
    const inCars = new Map();
    const outCars = new Map();
    const carsNumber = [];
    
    for(const record of records){
        const [time,number,state] = record.split(" ");
        carsNumber.push(number);
        
        if(state === "IN"){
            inCars.set(number, time);
        }else{
            const [inHour,inMinute] = inCars.get(number).split(":");
            const [outHour,outMinute] = time.split(":");
            const inTotal = (parseInt(inHour)*60) + parseInt(inMinute);
            const outTotal = (parseInt(outHour)*60) + parseInt(outMinute);
            const saveTime = outCars.get(number) || 0;
            
            outCars.set(number, saveTime + (outTotal - inTotal));
            inCars.delete(number);
        }
    }
    
    for(const [key,value] of inCars){
        const [inHour,inMinute] = value.split(":");
        const saveTime = outCars.get(key) || 0;
        outCars.set(key, saveTime + ((60 * 23) + 59) - ((parseInt(inHour) * 60) + parseInt(inMinute)));
    }
    
    const orderedNumbers  = [...new Set(carsNumber)].sort((a,b)=> a-b);
    
    for(const number of orderedNumbers){
        const saveTime = outCars.get(number);
        const totalFee = saveTime <= limitTime ? feePerLimit : (feePerLimit+ Math.ceil((saveTime - limitTime)/minute)*feePerMinute);
        answer.push(totalFee)
    }
    
    return answer;
}
