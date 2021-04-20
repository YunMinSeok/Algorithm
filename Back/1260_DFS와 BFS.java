import java.util.*;
import java.io.*;

public class Main {
  static ArrayList<Integer>[] visit;
  static boolean isvisit[];
  static int N, M, V;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());// 정점의 개수
    M = Integer.parseInt(st.nextToken());// 간선의 개수
    V = Integer.parseInt(st.nextToken());// 시작 번호

    visit = new ArrayList[10001];

    for (int i = 0; i <= N; i++) {
      visit[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      visit[x].add(y);
      visit[y].add(x);
    }

    for (int i = 0; i <= N; i++) {
      Collections.sort(visit[i]);
    }
    isvisit = new boolean[N + 1];
    dfs(V);
    System.out.println();
    isvisit = new boolean[N + 1];
    bfs(V);

  }

  public static void bfs(int v) {
    Queue<Integer> que = new LinkedList<Integer>();
    que.add(v);
    isvisit[v] = true;
    while (!que.isEmpty()) {
      int cur = que.poll();
          for (int i = 0; i < visit[cur].size(); i++) {
              int y = visit[cur].get(i);
              if (!isvisit[y]) {
                  que.add(y);
                  isvisit[y] = true;
              }
          }
      System.out.print(cur + " ");
    }
    return;
  }

  static int count = 0;

  public static void dfs(int v) {
    if (count == N) {
      return;
    }
    isvisit[v] = true;
    System.out.print(v + " ");
    for (int i = 0; i < visit[v].size(); i++) {
      int y = visit[v].get(i);
      if (!isvisit[y]) {
        dfs(y);
      }
    }
  }

}
