function solution(name, yearning, photo) {
    var answer = [];
    
    const arr = {};
    
    for(let i=0; i<name.length; i++){
        arr[name[i]] = yearning[i]
    }
    
    for(let i=0; i <photo.length; i++){
        answer[i]= 0;
        for(let j=0; j<photo[i].length; j++){
            if(arr[photo[i][j]]){
                answer[i] += arr[photo[i][j]]
            }
        }
    }
    
    return answer;
}
