function solution(s) {
    return s.split('').sort((a, b) => {
        return (b < a) ? -1 : (a === b) ? 0 : 1;
    }).join('');
}
