function solution(s) {
    let answer = 0;
    s = s.split("");
    let tc = s.length-1;
    
    while (tc--) {
        const stack = [];
        for (let i = 0; i < s.length; i++) {
          stack.push(s[i]);
          if (
            (stack[stack.length - 2] === "(" && stack[stack.length - 1] === ")") ||
            (stack[stack.length - 2] === "{" && stack[stack.length - 1] === "}") ||
            (stack[stack.length - 2] === "[" && stack[stack.length - 1] === "]")
          ) {
            stack.pop();
            stack.pop();
          }
    }

    if (stack.length === 0) answer++;

    const temp = s.shift();
    s.push(temp);
  }

    return answer;
}
