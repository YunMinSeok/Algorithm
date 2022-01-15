function solution(a, b) {    
    let mDArr = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
    let dW = ['FRI','SAT', 'SUN', 'MON','TUE','WED','THU'];
    let sum = 0;
    
    for(let i=0; i<a-1; i++){
        sum += mDArr[i];
    }
    sum = (sum + b - 1) % 7;    
    return dW[sum];
}
