function solution(n, computers) {
    let answer = 0;
    let visited = [];
    for(const computer of computers){
        visited.push(false)
    }
    
    function dfs(index){
        visited[index] = true;
        for(let i=0; i< computers.length; i++){
            if(computers[index][i] === 1 && !visited[i]){
                dfs(i);
            }
        }
    }
    
    for(let i=0; i< computers.length; i++){
        if(!visited[i]){
            dfs(i);
            answer++;
        }
    }
    
    return answer;
}
