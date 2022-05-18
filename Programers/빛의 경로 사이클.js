function solution(grid) {
    const result = [];
    const cycle = grid.map((row) => row.split('') .map((_) => new Array(4).fill(true))); 
    const direct = [[1, 0], [0, 1], [-1, 0], [0, -1]];

    cycle.forEach((row,rdx)=>{
        row.forEach((col,cdx)=>{
            col.forEach((route,idx)=>{
                if(route){
                    result.push(checkCycle(rdx,cdx,idx));
                }
            })
        })
    })
    
    function checkCycle(rdx,cdx,idx){
        let result = 0;
       while (true) { 
           if (!cycle[rdx][cdx][idx]) break; 
           cycle[rdx][cdx][idx] = false; 
           result++; rdx += direct[idx][0]; 
           cdx += direct[idx][1]; 
           if (rdx < 0) rdx = cycle.length - 1; 
           if (rdx >= cycle.length) rdx = 0; 
           if (cdx < 0) cdx = cycle[0].length - 1; 
           if (cdx >= cycle[0].length) cdx = 0; 
           
           if (grid[rdx][cdx] === "L") idx = [1, 2, 3, 0][idx]; 
           if (grid[rdx][cdx] === "R") idx = [3, 0, 1, 2][idx]; 
       } 
        return result; 
    } 
    return result.sort((a, b) => a - b);

}
