package 여행_가자;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1976 {

	static int N;
	private static int[][] arr;
	private static int M;
	private static int[] path;

	public static void main(String[] args) throws IOException {
		init();

		for (int k = 1; k <= N; ++k) {
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					if (arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
		}

		for (int i = 1; i < M; ++i) {
			int s = path[i - 1];
			int e = path[i];
			if (arr[s][e] == 0) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());

		path = new int[M];

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; ++j) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (i == j) {
					arr[i][j] = 1;
				}
			}
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; ++i) {
			path[i] = Integer.parseInt(st.nextToken());
		}
	}
}
