package 행렬_곱셈_순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11049 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N + 1][2];
		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		int[][] d = new int[N + 1][N + 1];
		for (int i = N; i > 0; --i) {
			for (int j = i + 1; j <= N; ++j) {
				d[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; ++k) {
					d[i][j] = Math.min(d[i][j],
							d[i][k] + d[k + 1][j] + arr[i][0] * arr[k][1] * arr[j][1]);
				}
			}
		}
		System.out.println(d[1][N]);
	}
}