function solution(n, m, section) {
    let answer = 0;
    let max = 0;
     for (let i = 0; i < section.length; i++) {
          if (section[i] < max) {
              continue;
          }

          answer += 1;
          max = section[i] + m;
      }

      return answer;
}
