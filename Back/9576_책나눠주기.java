import java.util.*;
import java.io.*;

public class Main{
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int casecount = Integer.parseInt(br.readLine());//케이스의 수
        StringTokenizer st;
        boolean[] book = new boolean [1001];
        
        for(int i=0; i < casecount; i++){
            int sum =0;//책을 나눠줄수있는 수
            
            st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());//책의 개수
            int M = Integer.parseInt(st.nextToken());//줄의 개수
            
            int readbook[][] = new int[M][2];
            
            
            for(int j=0; j < M; j++){
                st = new StringTokenizer(br.readLine());

                readbook[j][0] = Integer.parseInt(st.nextToken());//최소값
                readbook[j][1] = Integer.parseInt(st.nextToken());//최대값
            }
            
            Arrays.sort(readbook, new Comparator<int[]>(){
                @Override
                public int compare(int[] t1, int[] t2){
                    return t1[1] - t2[1];
                }
            });
            
            loop :
            for(int j=0; j < M; j++){
                for(int z = readbook[j][0]; z< N+1; z++){
                    if(z <= readbook[j][1] && !book[z]){
                        sum++;
                        book[z] = true;
                        break;
                    }
                }

                
            }
           
            System.out.println(sum);
            Arrays.fill(book,false);
            }
        
    }
}
