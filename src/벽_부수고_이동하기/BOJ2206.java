package 벽_부수고_이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {

	private static int N;
	private static int M;
	private static int INF;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] arr = new char[N][M];
		INF = 1000000000;

		ArrayList<Pos> walls = new ArrayList<>();
		for (int i = 0; i < N; ++i) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; ++j) {
				if (arr[i][j] == '1') {
					walls.add(new Pos(i, j, 0));
				}
			}
		}

		int[][] startArray = bfs(arr, 0, 0);
		int[][] targetArray = bfs(arr, N - 1, M - 1);

		int answer = startArray[N - 1][M - 1];
		for (Pos wall : walls) {
			int dist = startArray[wall.i][wall.j] + targetArray[wall.i][wall.j];
			if (dist < answer) {
				answer = dist;
			}
		}
		System.out.println(answer >= INF ? -1 : answer + 1);

	}

	private static int[][] bfs(char[][] arr, int si, int sj) {
		int[][] dist = new int[N][M];
		for (int i = 0; i < N; ++i) {
			Arrays.fill(dist[i], INF);
		}

		dist[si][sj] = 0;
		Queue<Pos> Q = new ArrayDeque<>();
		Q.add(new Pos(si, sj, 0));

		int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

		while (!Q.isEmpty()) {
			Pos now = Q.poll();

			for (int t = 0; t < 4; ++t) {
				int di = now.i + dir[t][0];
				int dj = now.j + dir[t][1];
				if (di < 0 || dj < 0 || di >= N || dj >= M || dist[di][dj] <= now.lv + 1) {
					continue;
				}

				dist[di][dj] = now.lv + 1;
				if (arr[di][dj] == '0') {
					Q.add(new Pos(di, dj, now.lv + 1));
				}
			}
		}
		return dist;
	}

	private static class Pos {

		int i, j, lv;

		public Pos(int i, int j, int lv) {
			this.i = i;
			this.j = j;
			this.lv = lv;
		}
	}
}
