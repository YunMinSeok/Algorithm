function solution(n, arr1, arr2) {
    const answer = [];
    
    console.log(n,arr1,arr2)
    
    for(let i=0; i< n; i++){
        let str = (arr1[i] |arr2[i]).toString(2)
        str = str.replace(/1/g,"#").replace(/0/g," ")
        answer.push(str.padStart(n," "))
    }
    
    return answer;
}
