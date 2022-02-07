function solution(skill, skill_trees) {
    var answer = 0;
    
    let filterTree = skill_trees.map(tree =>{
        return tree.split("").filter(fl => skill.includes(fl));
    })
    
    for(let i = 0; i < filterTree.length; i++) {
        let bl = true;
        for(let j = 0; j < filterTree[i].length; j++) {
          if(skill[j] !== filterTree[i][j]) {
            bl = false;
            break;
          }
        }
        if(bl) answer++;
    }
    
    return answer;
}
