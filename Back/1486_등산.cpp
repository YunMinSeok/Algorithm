  
#include <iostream>
#include <algorithm>
#include <cstring>
#include <queue>
using namespace std;
int N, M, T, D;
int res;
int p[26][26]; // 지도 정보
int visit[26][26]; // 등산 시간
int back[26][26]; // 하산 시간
int dx[4] = { -1,0,0,1 };
int dy[4] = { 0,-1,1,0 };

void bfs()
{
	memset(visit, -1, sizeof(visit));
	queue<pair<int, int>> q;
	q.push({ 1,1 });
	visit[1][1] = 0;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx<1 || ny<1 || nx>N || ny>M) continue;
			if (abs(p[nx][ny] - p[x][y]) > T) continue; //높이차가 T보다 크면 불가능
			if (p[nx][ny] <= p[x][y]) {
				if (visit[x][y] + 1 > D) continue; // D시간 초과시 방문 불가능
				if (visit[nx][ny] == -1 || visit[nx][ny] > visit[x][y] + 1) {
					visit[nx][ny] = visit[x][y] + 1;
					q.push({ nx,ny });
				}
			}
			else {
				int nextTime = (p[nx][ny] - p[x][y]) * (p[nx][ny] - p[x][y]);
				if (visit[x][y] + nextTime > D) continue; //D시간 초과시 방문 불가능
				if (visit[nx][ny] == -1 || visit[nx][ny] > visit[x][y] + nextTime) {
					visit[nx][ny] = visit[x][y] + nextTime;
					q.push({ nx,ny });
				}
			}
		}
	}
}

void bfs2()
{
	memset(back, -1, sizeof(back));
	queue<pair<int, int>> q;
	q.push({ 1,1 });
	back[1][1] = 0;

	while (!q.empty()) {
		int x = q.front().first;
		int y = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx<1 || ny<1 || nx>N || ny>M) continue;
			if (abs(p[nx][ny] - p[x][y]) > T) continue; //높이차가 T보다 크면 불가능
			if (p[x][y] > p[nx][ny]) {
				int nextTime = (p[x][y] - p[nx][ny]) * (p[x][y] - p[nx][ny]);
				if (back[x][y] + nextTime > D) continue; // D시간 초과시 방문 불가능
				if (back[nx][ny] == -1 || back[nx][ny] > back[x][y] + nextTime) {
					back[nx][ny] = back[x][y] + nextTime;
					q.push({ nx,ny });
				}
			}
			else {
				if (back[x][y] + 1 > D) continue; // D시간 초과시 방문 불가능
				if (back[nx][ny] == -1 || back[nx][ny] > back[x][y] + 1) {
					back[nx][ny] = back[x][y] + 1;
					q.push({ nx,ny });
				}
			}
		}
	}
}

int main()
{
	cin >> N >> M >> T >> D;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			char a;
			cin >> a;
			if ('A' <= a && a <= 'Z') p[i][j] = (a - 'A');
			else p[i][j] = (a - 'a' + 26);
		}
	}

	bfs(); //호텔 -> 등산
	bfs2(); //산->호텔

	res = p[1][1];
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= M; j++) {
			if (visit[i][j] == -1 || back[i][j] == -1) continue;
			if (visit[i][j] + back[i][j] <= D) {
				res = max(res, p[i][j]);
			}
		}
	}

	cout << res;
}
