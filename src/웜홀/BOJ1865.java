package 웜홀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		final int INF = 1000000000;

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; ++tc) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			ArrayList<Edge> edges = new ArrayList<>();

			int a, b, c;
			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				edges.add(new Edge(a, b, c));
				edges.add(new Edge(b, a, c));
			}

			for (int i = 0; i < W; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				edges.add(new Edge(a, b, -c));
			}

			int[] d = new int[N + 1];
			Arrays.fill(d, INF);
			d[1] = 0;

			String answer = "NO";
			for (int i = 0; i < N; ++i) {
				for (Edge edge : edges) {
					if (d[edge.b] > d[edge.a] + edge.cost) {
						d[edge.b] = d[edge.a] + edge.cost;
						if (i == N - 1) {
							answer = "YES";
						}
					}
				}
			}

			System.out.println(answer);
		}


	}

	private static class Edge {

		int a, b, cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}
}
