function solution(n, results) {
    const graph = Array.from({length: n+1}, ()=> Array(n+1).fill(false));
    
    results.map((val)=>{
        const[win,lose] = val;
        graph[win][lose] = 1;
        graph[lose][win] = -1;
        graph[win][win] = 0;
        graph[lose][lose] = 0;
    });
    
    const rangeN = [...Array(n).keys()].map((e)=>e+1);
    
    for(const mid of rangeN){
        for(const a of rangeN){
            for(const b of rangeN){
                if(graph[a][mid] === 1 && graph[mid][b]===1) graph[a][b]=1;
                if(graph[a][mid] === -1 && graph[mid][b] === -1) graph[a][b] = -1;
            }
        }
    }
    
    let ans =0;
    
    for(const self of rangeN){
        let hasFalse = false;
        for(const other of rangeN){
            if(graph[self][other]=== false){
                hasFalse = true;
                break;
            }
        }
        ans += hasFalse ? 0 : 1;
    }
    return ans;
}
