function solution(sizes) {
    let answer = 0;
    
    for(let i in sizes){
        sizes[i].sort((a,b)=> b-a);
    }
    
    let garo = 0;
    let sero = 0;
    
    for(let i in sizes){
        if(sizes[i][0] > garo){
            garo = sizes[i][0]
        }
        if(sizes[i][1] > sero){
            sero = sizes[i][1]
        }
    }
    answer = garo * sero
    return answer;
}
