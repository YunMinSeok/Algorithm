function isPrime(num) {
    if(num <= 1) return false
    for(let i = 2 ; i <= Math.sqrt(num) ; i++ ) {
        if(num%i === 0) return false
    }
    return true
}

function solution(n, k) {
    let result = 0
    let zeroIdx = -1
    const transNum = n.toString(k)
    for(let i = 0 ; i < transNum.length ; i ++) {
        if(!Number(transNum[i])) {
            const nowNum = transNum.substring(zeroIdx+1,i)
            isPrime(nowNum) ? result++ : null
            zeroIdx = i
        }
    }
    isPrime(transNum.substring(transNum.lastIndexOf(0)+1)) ? result++ : null
    return result
}
