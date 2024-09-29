package 운동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class BOJ1956 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V, E;
		int[][] arr;

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		arr = new int[V + 1][V + 1];

		for (int i = 1; i <= V; ++i) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < E; ++i) {
			int s, d, c;
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			arr[s][d] = c;
		}

		for (int k = 1; k <= V; ++k) {
			for (int i = 1; i <= V; ++i) {
				for (int j = 1; j <= V; ++j) {
					if (arr[i][k] < Integer.MAX_VALUE && arr[k][j] < Integer.MAX_VALUE
							&& arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		int answer = Integer.MAX_VALUE;

		for (int i = 1; i <= V; ++i) {
			for (int j = 1; j <= V; ++j) {
				if (arr[i][j] < Integer.MAX_VALUE && arr[j][i] < Integer.MAX_VALUE
						&& arr[i][j] + arr[j][i] < answer) {
					answer = arr[i][j] + arr[j][i];
				}
			}
		}

		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
}