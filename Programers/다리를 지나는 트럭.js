function solution(bridge_length, weight, truck_weights) {
   let bridge = Array.from({ length: bridge_length }, () => 0);

  let time = 0;

  while (bridge.length) {
    bridge.shift();
    time += 1;

    if (truck_weights.length) {
      let sum = bridge.reduce((sum, curValue,i)=> {
        return sum + curValue;
      });

      if (sum + truck_weights[0] <= weight) {
        bridge.push(truck_weights.shift());
      } else {
        bridge.push(0);
      }
    }
  }

  return time;
}
