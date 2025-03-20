package 텀_프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ9466 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> count = new HashMap<>();
		for (int tc = 0; tc < T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; ++i) {
				arr[i] = Integer.parseInt(st.nextToken()) - 1;
			}

			int answer = N;
			boolean[] visited = new boolean[N];

			for (int i = 0; i < N; ++i) {
				if (visited[i]) {
					continue;
				}
				int now = i, cnt = 0;
				boolean flag = false;
				count.clear();
				while (!count.containsKey(now)) {
					if (visited[now]) {
						flag = true;
						break;
					}
					visited[now] = true;
					count.put(now, cnt++);
					now = arr[now];
				}
				if (!flag) {
					answer -= cnt - count.get(now);
				}
			}
			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
