package 쉬운_최단거리;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14940 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		Pos start = null;
		final int INF = 10000000;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					arr[i][j] = 0;
					start = new Pos(i, j, 0);
				} else if (arr[i][j] == 1) {
					arr[i][j] = INF;
				}
			}
		}
		Queue<Pos> Q = new ArrayDeque<>();
		Q.add(start);

		int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

		while (!Q.isEmpty()) {
			Pos now = Q.poll();
			for (int i = 0; i < 4; ++i) {
				int di = now.i + dir[i][0];
				int dj = now.j + dir[i][1];

				if (di < 0 || dj < 0 || di >= N || dj >= M || arr[di][dj] == 0) {
					continue;
				}
				if (arr[di][dj] > now.lv + 1) {
					arr[di][dj] = now.lv + 1;
					Q.add(new Pos(di, dj, now.lv + 1));
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				sb.append(arr[i][j] == INF ? -1 : arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
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