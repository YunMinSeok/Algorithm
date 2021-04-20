import java.util.*;
import java.io.*;
public class Main{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> q = new PriorityQueue<>();
		long sum = 0;
		for(int i=0; i<N; i++){
			q.add(Long.parseLong(br.readLine()));
		}
		
		while(q.size()!=1 && !q.isEmpty()){
			long temp = q.poll() + q.poll();
			q.add(temp);
			sum +=temp;

		}
		System.out.println(sum);
		br.close();
        
    }
}
