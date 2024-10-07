package 색상환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2482 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		if (K == 1) {
			System.out.println(N);
			return;
		}

		if (K * 2 > N) {
			System.out.println(0);
			return;
		}

		final long MOD = 1_000_000_003;

		long[][] D = new long[N + 1][K + 1];

		D[0][0] = 1;
		D[1][0] = 1;
		D[1][1] = 1;

		for (int i = 2; i <= N; i++) {
			D[i][0] = 1;
			for (int j = 1; j <= K; j++) {
				D[i][j] = D[i - 2][j - 1] + D[i - 1][j] % MOD;
				if (D[i][j] == 0) {
					break;
				}
			}
		}

		System.out.println((D[N - 3][K - 1] + D[N - 1][K]) % MOD);
	}
}
