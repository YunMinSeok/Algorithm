function solution(cacheSize, cities) {
    
    let times = 0;
    let cache = [];
    
    if(!cacheSize) return 5 * cities.length;
    
    cities.forEach((city) => {
        
        city = city.toLowerCase();
        
        if(cache.includes(city)) {
            cache.splice(cache.indexOf(city),1);
            times += 1;
        } else {
            if(cache.length == cacheSize) cache.shift();
            times += 5;
        }
            cache.push(city)
    })
    return times 
}
