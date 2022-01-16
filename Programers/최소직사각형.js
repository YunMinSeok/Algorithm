function solution(sizes) {
    var answer = 0;
    
    let garo = 0;
    let sero = 0;
    for(let i = 0; i < sizes.length; i++){
        sizes[i].sort((a,b) => b-a);
    }
    
    for(let i = 0; i < sizes.length; i++){
        if(sizes[i][0] > garo){
            garo = sizes[i][0];
        }
        if(sizes[i][1] > sero){
            sero = sizes[i][1];
        }
    }
    
    answer = garo * sero;
    return answer;
}
