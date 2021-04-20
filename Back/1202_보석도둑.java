import java.util.*;
import java.io.*;

class Jewel implements Comparable<Jewel>{
    int m;
    int v;
    
    Jewel(int m, int v){
        this.m = m;
        this.v = v;
    }
    @Override
    public int compareTo(Jewel t){
        return this.m-t.m;
    }
}

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//보석의 갯수
        int K = Integer.parseInt(st.nextToken());//가방의 갯수
        
        ArrayList <Jewel> jewel = new ArrayList<>();//보석정보 배열
        for(int i=0; i < N; i++){//보석 정보 입력
            st = new StringTokenizer(br.readLine());
            jewel.add(new Jewel(Integer.parseInt(st.nextToken()),
                                Integer.parseInt(st.nextToken())));   
        }
        
        ArrayList<Integer> bag = new ArrayList<>();
        for(int i=0; i<K; i++){
           bag.add(Integer.parseInt(br.readLine()));//가방 정보 받기
        }
        
        Collections.sort(jewel);
        Collections.sort(bag);
        
        PriorityQueue<Integer>pq = new PriorityQueue<>();//우선순위가 낮은순
        
        long sum=0;
        int temp = 0;
        
        for(int i=0; i<K; i++){
           for(int j=temp; j< N; j++){//가방정보 받으면 비교하기
             if(bag.get(i) >= jewel.get(j).m){
                 pq.offer(-jewel.get(j).v);//minheap을 이용
                 temp++;
               }else{
                 break;
             }
            }
            if(!pq.isEmpty()){
                sum += Math.abs(pq.poll());
            }
        }
        
        System.out.println(sum);        
        
    }
}
