const transformObj =(report)=>{
    const obj ={};
    const set = [...new Set(report)];
    set.forEach((log) => {
        const tmp = log.split(' ');
        if (obj[tmp[1]] === undefined) {
          obj[tmp[1]] = [tmp[0]];
        } else {
          obj[tmp[1]] = [...obj[tmp[1]], tmp[0]];
        }
      });
  return obj;
    
}

const solution=(id_list, report, k)=>{
    const report_obj = transformObj(report);
    
    const answer = Array.from({ length: id_list.length }, () => 0);

     for (let i in report_obj) {
        if (report_obj[i].length >= k) {
          const ids = report_obj[i];
          ids.forEach((id) => {
            const index = id_list.indexOf(id);
            answer[index]++;
          });
        }
      }
    
    return answer;
}
