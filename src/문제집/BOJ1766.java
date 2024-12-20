package 문제집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1766 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		/*
			1. N개의 문제는 모두 풀어야 한다.
			2. 먼저 푸는 것이 좋은 문제가 있는 문제는, 먼저 푸는 것이 좋은 문제를 반드시 먼저 풀어야 한다.
			3. 가능하면 쉬운(숫자가 작은) 문제부터 풀어야 한다.
		 */

		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; ++i) {
			arr[i] = new ArrayList<>();
		}

		int[] deg = new int[N + 1];

		int A, B; // A를 B보다 먼저 푸는 것이 좋다.
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			arr[A].add(B);
			++deg[B];
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; ++i) {
			if (deg[i] == 0) {
				pq.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int now = pq.poll();

			sb.append(now).append(" ");

			arr[now].forEach(next -> {
				--deg[next];
				if (deg[next] == 0) {
					pq.offer(next);
				}
			});
		}

		System.out.println(sb);
	}
}