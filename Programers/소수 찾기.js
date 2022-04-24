function solution(numbers) {
    let answer = 0;
    
    let n = numbers.split("");
    let nums = new Set();
    combi(n,"")
    
     function combi(a, s) {
        if (s.length > 0) {
            if (nums.has(Number(s))=== false) {
                nums.add(Number(s));
                if (chkPrime(Number(s))) {
                    answer++;
                }
            }
        }
        if (a.length > 0) {
            for (var i = 0; i< a.length; i++) {
                var t = a.slice(0)
                t.splice(i,1);
                combi(t,s + a[i]);
            }
        }
    }

    function chkPrime(num) {
        if( num < 2) return false;
        for (var i =2; i <= num / 2 ; i++) {
            if( num % i === 0) return false;
        }
        return true;
    }
    
    return answer;
}
