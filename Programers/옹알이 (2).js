function solution(babbling) {
    var answer = 0;
    
    babbling.forEach((value)=>{
        let stack = ["aya", "ye", "woo", "ma"]
        for(let i=0; i< stack.length; i++){
            if(value.includes(stack[i].repeat(2))){
                break;
            value = value.split(stack[i]).join(" ");
        }
        if(value.split(" ").join("").length === 0){
            answer += 1;
        }
    })
    
    return answer;
}
