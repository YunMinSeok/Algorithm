function solution(strings, skip, index) {
    let answer = '';
  const alphabet = new Set('abcdefghijklmnopqrstuvwxyz');
  [...skip].forEach(val => alphabet.delete(val));

  const arr = [...alphabet];

  for (const s of strings) {
    const idx = arr.indexOf(s) + index;
    answer += arr[idx % arr.length];
  }

  return answer;
}
