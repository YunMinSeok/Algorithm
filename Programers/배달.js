function solution(N, road, K) {
    let answer = 0;
    const graph = Array.from({length: N+1},()=> Array());
    const dist = Array(N+1).fill(Infinity)
    const queue = [];
    
    for(let i=0; i < road.length; i++){
        const start = road[i][0];
        const target = road[i][1];
        const cost = road[i][2];
        
        graph[start].push([target,cost]);
        graph[target].push([start,cost]);
    }
    
    queue.push([1,0]);
    dist[1]=0;
    
    while(queue.length){
        const [current,cost] = queue.shift();
        for( let i=0; i < graph[current].length; i++){
            const next = graph[current][i][0];
            const nextCost = graph[current][i][1];
            if(dist[next] > dist[current] + nextCost){
                dist[next] = dist[current] + nextCost;
                queue.push([next,nextCost]);
            }
        }
    }
    
    for(let i=1; i <=N; i++ ){
        answer += dist[i] <= K ? 1 : 0;
    }
    
    return answer;
}
