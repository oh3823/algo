package 음악프로그램;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ2623 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		TreeSet<Integer>[] arr = new TreeSet[N + 1];
		TreeSet<Integer>[] d = new TreeSet[N + 1];
		int[] deg = new int[N + 1];

		for (int i = 0; i <= N; ++i) {
			arr[i] = new TreeSet<>();
			d[i] = new TreeSet<>();
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int P = Integer.parseInt(st.nextToken());
			int a = 0, b;
			for (int j = 0; j < P; ++j) {
				b = Integer.parseInt(st.nextToken());
				if (a != 0) {
					arr[a].add(b);
					d[b].add(a);
				}
				a = b;
			}
		}
		Queue<Integer> Q = new ArrayDeque<>();
		for (int i = 1; i <= N; ++i) {
			deg[i] = d[i].size();
			if (deg[i] == 0) {
				Q.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		boolean fail = false;
		int count = 0;
		while (!Q.isEmpty()) {
			int now = Q.poll();
			sb.append(now).append("\n");
			++count;
			for (int next : arr[now]) {
				--deg[next];
				if (deg[next] < 0) {
					fail = true;
					break;
				}
				if (deg[next] == 0) {
					Q.offer(next);
				}
			}
			if (fail) {
				break;
			}
		}

		if (fail || count < N) {
			System.out.println(0);
			return;
		}
		System.out.println(sb);
	}
}
