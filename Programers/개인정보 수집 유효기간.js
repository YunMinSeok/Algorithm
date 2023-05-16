function solution(today, terms, privacies) {
    let answer = [];
    let newTerm = [];
    
    for(term of terms){
        const [type,value] = term.split(" ");
        newTerm[type] = parseInt(value)
    }
    
    for(let i = 1; i<= privacies.length; i++){
        const [privacyTime,term] = privacies[i-1].split(" ");
        const time1 = new Date(privacyTime)
        const time2 = new Date(today);
        
        time1.setMonth(time1.getMonth() + newTerm[term])
        if(time2 >= time1){
            answer.push(i)
        }
    }
    
    return answer;
}
