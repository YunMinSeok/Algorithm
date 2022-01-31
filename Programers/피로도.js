function solution(k, dungeons) {
    var answer = 0;
    const len = dungeons.length;
    const visited = new Array(len).fill(false);
    
    const dfs = (k,curCnt) => {
        answer = Math.max(curCnt,answer);
        for(let i=0; i < len; i++){
            const [mink,usek] = dungeons[i];
            
            if(k >= mink && !visited[i]){
                visited[i] = true;
                dfs(k-usek,curCnt+1);
                visited[i]= false;
            }
        }
    }
    
    dfs(k,0);
    
    return answer;
}
