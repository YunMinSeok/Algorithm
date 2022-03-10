function solution(tickets) {
    let answer = [];
    let result = [];
    let visited = [];
    
    tickets.sort();
    const len = tickets.length;
    
    const dfs = (str,count) => {
        result.push(str);
        
        if(count === len){
            answer = result;
            return true;
        }
        console.log(result)
        for(let i=0; i< len; i++){
            if(!visited[i] && tickets[i][0] === str){
                visited[i] = true;
                if(dfs(tickets[i][1],count+1)) return true;
                visited[i] = false;
            }
        }
        result.pop();
        
        return false;
    }
        
    dfs("ICN",0);
    
    return answer;
}
