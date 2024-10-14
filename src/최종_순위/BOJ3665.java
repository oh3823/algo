package 최종_순위;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ3665 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int T = Integer.parseInt(st.nextToken());
		String IMPOSSIBLE = "IMPOSSIBLE";

		for (int tc = 0; tc < T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());

			int[] order = new int[n];
			int[] rank = new int[n + 1];
			int[][] arr = new int[n + 1][n + 1];
			int[] ref = new int[n + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; ++i) {
				order[i] = Integer.parseInt(st.nextToken()); // order는 순서를 저장하기 위함
				rank[order[i]] = i + 1; // rank[i] = i의 rank
			}

			for (int i = 0; i < n; ++i) {
				for (int j = i + 1; j < n; ++j) {
					arr[order[i]][order[j]] = 1;
				}
				ref[order[i]] = i;
			}

			st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());

			for (int i = 0; i < m; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (rank[a] > rank[b]) { // 항상 a가 더 높은 순위로
					int temp = a;
					a = b;
					b = temp;
				}

				arr[a][b] = 0;
				arr[b][a] = 1;
				--ref[b];
				++ref[a];
			}

			Queue<Integer> Q = new ArrayDeque<>();

			int count = 0;
			for (int i = 1; i <= n; ++i) {
				if (ref[i] == 0) {
					Q.add(i);
				}
			}

			StringBuilder sb = new StringBuilder();
			while (!Q.isEmpty()) {
				int now = Q.poll();
				sb.append(now).append(" ");
				++count;

				for (int i = 1; i <= n; ++i) {
					if (arr[now][i] == 0) {
						continue;
					}

					arr[now][i] = 0;
					--ref[i];

					if (ref[i] == 0) {
						Q.add(i);
					}
				}
			}

			if (count < n) {
				System.out.println(IMPOSSIBLE);
			} else {
				System.out.println(sb);
			}
		}
	}
}
