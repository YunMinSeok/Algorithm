function solution(begin, target, words) {
    let answer = 0;
    let visited = [];
    let queue = [];
    
    if(!words.includes(target)) return 0;
    
    queue.push([begin,answer]);
    
    while(queue){
        let [v,cnt] = queue.shift();
        
        if(v === target) return cnt;
        
        words.forEach(word => {
            let count = 0;
            
            if(visited.includes(word)) return;
            
            for(let i=0; i< word.length; i++){
                if(word[i] !== v[i]){
                    count++;
                }
            }
            if(count === 1){
                queue.push([word,++cnt]);
                visited.push(word);
            }
        })
    }
    
    return answer;
}
