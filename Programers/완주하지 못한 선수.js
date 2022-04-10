function solution(participant, completion) {
    var answer = '';
    
    completion = completion.sort()
    participant = participant.sort()
    
    for(let i=0; i < participant.length; i++){
        if(participant[i] !== completion[i]){
            return participant[i]
        }
    }
    
    return answer;
}
