package RGB거리2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17404 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[3][N];

		int answer = Integer.MAX_VALUE;
		final int INF = 1001;
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[0][i] = Integer.parseInt(st.nextToken());
			arr[1][i] = Integer.parseInt(st.nextToken());
			arr[2][i] = Integer.parseInt(st.nextToken());
		}

		int[][] d = new int[3][N];
		for (int i = 0; i < 3; ++i) {
			d[0][0] = d[1][0] = d[2][0] = INF;
			d[i][0] = arr[i][0];
			for (int j = 1; j < N; ++j) {
				d[0][j] = Math.min(d[1][j - 1], d[2][j - 1]) + arr[0][j];
				d[1][j] = Math.min(d[0][j - 1], d[2][j - 1]) + arr[1][j];
				d[2][j] = Math.min(d[0][j - 1], d[1][j - 1]) + arr[2][j];
			}

			for (int k = 0; k < 3; ++k) {
				if (k == i) {
					continue;
				}
				answer = Math.min(answer, d[k][N - 1]);
			}
		}

		System.out.println(answer);
	}
}