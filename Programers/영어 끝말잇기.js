function solution(n, words) {
    var answer = [];
    const comment= [];
    let count =2;
    
        comment.push(words[0]);
    for(let i=1; i < words.length; i++){
        if(count > n){
            count =1;
        }
        
        if(comment.includes(words[i]) || comment[comment.length-1].charAt(comment[comment.length-1].length-1) !== words[i].charAt(0)){
            answer = [count, Math.ceil((i+1)/n)];
            break;
        }
        comment.push(words[i]);
        count++;
        
    }

    if(answer.length === 0){
        answer = [0,0];
    }
    
    return answer;
}
