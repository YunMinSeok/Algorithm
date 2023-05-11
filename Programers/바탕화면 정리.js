function solution(wallpaper) {
    let x = [];
    let y = [];
    
    for(let i=0; i<wallpaper.length; i++){
        for(let j=0; j< wallpaper[0].length; j++){
            if(wallpaper[i][j] === "#"){
                x.push(j)
                y.push(i)
            }
        }
    }
    
    x.sort((a,b) => a-b)
    y.sort((a,b) => a-b)
    
    return [y[0],x[0],y[y.length-1]+1,x[x.length-1]+1];
}
