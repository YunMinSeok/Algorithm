const solution = (n) => {
  const arr = [];
  arr.push(0,1, 2,3);
  for (let i = 4; i <= n; i++) {
    arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000007;
  }
  return arr[n];
};
