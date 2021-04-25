import java.io.*;
import java.util.*;

public class Main{
	static List<Vertex16118>[] graph;
	static long[] foxTime; // 해당 인덱스까지 이동하는데 걸리는 최소시간
	static long[][] wolfTime;
	
	public static void main(String args[]) {
		InputReader in = new InputReader(System.in);
		int n = in.readInt();
		int m = in.readInt();
		graph = new ArrayList[n + 1];
		wolfTime = new long[2][n + 1];	// 0 : 해당 지점에 느리게 달려왔을 때의 최소 시간. 1 : 해당 지점에 빠르게 달려왔을 때의 최소 시간. 
		foxTime = new long[n + 1];
        
		// 다익스트라 최소시간배열 초기화
		Arrays.fill(foxTime, Long.MAX_VALUE);
		Arrays.fill(wolfTime[0], Long.MAX_VALUE);
		Arrays.fill(wolfTime[1], Long.MAX_VALUE);
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Vertex16118>();
		}
		
		// 입력 값 담기 
		for(int i = 0; i < m; i++) {
			int from = in.readInt();
			int to = in.readInt();
			long weight = in.readInt() * 2;
			
			graph[from].add(new Vertex16118(to, weight));
			graph[to].add(new Vertex16118(from, weight));
		}
		
		dijkstra(n);
		dijkstraWolf(n);
		
		int count = 0;
		for(int i = 2; i <= n; i++) {
			if(foxTime[i] < Math.min(wolfTime[0][i], wolfTime[1][i])) {	// 늑대의 속도 별 도착 최소 시간 각각을 여우 이동 최소시간과 비교해야 함 
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	// 달빛늑대 다익스트라 
	static void dijkstraWolf(int n) {
		Queue<Vertex16118> queue = new PriorityQueue<Vertex16118>();
		queue.offer(new Vertex16118(1, 0, 0));
		wolfTime[0][1] = 0;	// 다익스트라 시작지점 초기화(첫 시작은 무조건 빠르게 시작하므로, 시작 지점에 느리게 와서 도착했다고 가정한다.)
		
		while(!queue.isEmpty()) {
			Vertex16118 endVertex = queue.poll();
			int end = endVertex.endIndex;
			long nowTime = endVertex.time;
			
			if(wolfTime[endVertex.state][end] < nowTime) {	// 현재 지점까지 걸리는 최소시간보다 현재 늑대가 해당 지점에 오기까지 걸린 시간이 크면 굳이 계산할 필요가 없다.
				continue;
			}
			
			for(Vertex16118 v : graph[end]) {
				int state = 1 - endVertex.state;	// 0 이면 1로, 1이면 0으로 스위치 전환 가능 
				long cost = wolfTime[endVertex.state][end] + ((endVertex.state == 0) ? v.time / 2 : v.time * 2);	// 상태가 0이면 빠르게, 1이면 느리게 
				if(wolfTime[state][v.endIndex] > cost) {
					wolfTime[state][v.endIndex] = cost;
					queue.offer(new Vertex16118(v.endIndex, cost, state));
				}
			}
		}
	}
	
	// 달빛여우 다익스트라 
	static void dijkstra(int n) {
		Queue<Vertex16118> queue = new PriorityQueue<Vertex16118>();
		queue.offer(new Vertex16118(1, 0));
		foxTime[1] = 0;	// 다익스트라 시작지점 초기화 
		
		while(!queue.isEmpty()) {
			Vertex16118 end = queue.poll();
			
			if(foxTime[end.endIndex] < end.time) {	// 지금 꺼낸 여우가 endIndex까지 걸린 시간이 내가 기록한 최소 시간과 다르면(더 크면) 굳이 체크할 의미가 없으니까.
				continue;
			}
			for(Vertex16118 v : graph[end.endIndex]) {
				long cost = foxTime[end.endIndex] + v.time;
				if(foxTime[v.endIndex] > cost) {
					foxTime[v.endIndex] = cost;
					queue.offer(new Vertex16118(v.endIndex, cost));
				}
			}
		}
	}
	
	// INPUT 속도 증가
	private static class InputReader {
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public int readInt() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}

class Vertex16118 implements Comparable<Vertex16118> {
	int endIndex;
	long time;
	boolean isFasted;
	int state;
	
	Vertex16118(int endIndex, long time) {
		this.endIndex = endIndex;
		this.time = time;
	}
	Vertex16118(int endIndex, long time, int state) {
		this.endIndex = endIndex;
		this.time = time;
		this.state = state;
	}
		
	@Override
	public int compareTo(Vertex16118 o) {
		if(this.time < o.time) {
			return -1;
		}
		else {
			return 1;
		}
	}
}
