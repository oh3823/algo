package 파일_합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11066 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int K = Integer.parseInt(st.nextToken());

			int[] C = new int[K + 1];
			int[][] D = new int[K + 1][K + 1];
			int[][] P = new int[K + 1][K + 1];

			st = new StringTokenizer(br.readLine(), " ");

			for (int k = 1; k <= K; k++) {
				C[k] = Integer.parseInt(st.nextToken());
				D[k][k] = C[k];
			}

			for (int i = K - 1; i > 0; --i) {
				for (int j = i + 1; j <= K; ++j) {
					D[i][j] = D[i][i] + D[i + 1][j];
					for (int k = i; k < j; k++) {
						P[i][j] = P[i][j] == 0 ? D[i][j] + P[i][k] + P[k + 1][j]
								: Math.min(P[i][j], D[i][j] + P[i][k] + P[k + 1][j]);
					}
				}
			}

			System.out.println(P[1][K]);
		}
	}
}
