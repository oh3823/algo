package 파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		ArrayList<Node>[] arr = new ArrayList[N + 1];

		for (int i = 1; i <= N; ++i) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			arr[a].add(new Node(b, t));
		}

		int[][] dist = new int[N + 1][N + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>(
				Comparator.comparingInt(value -> value.time));

		final int INF = 100000000;
		
		for (int i = 1; i <= N; ++i) {
			int[] d = dist[i];
			Arrays.fill(d, INF);
			d[i] = 0;

			pq.offer(new Node(i, 0));

			while (!pq.isEmpty()) {
				Node now = pq.poll();
				int via = now.dest;
				for (Node next : arr[via]) {
					if (d[next.dest] > d[via] + next.time) {
						d[next.dest] = d[via] + next.time;
						pq.offer(next);
					}
				}
			}
		}

		int answer = 0;
		for (int i = 1; i <= N; ++i) {
			if (answer < dist[i][X] + dist[X][i]) {
				answer = dist[i][X] + dist[X][i];
			}
		}
		System.out.println(answer);
	}

	private static class Node {

		int dest, time;

		public Node(int dest, int time) {
			this.dest = dest;
			this.time = time;
		}
	}
}