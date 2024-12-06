package 도시_분할_계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ1647 {


	private static int[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		ArrayList<Edge> edges = new ArrayList<>();

		for (int i = 0; i < E; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b, cost));
		}

		edges.sort(Comparator.comparingLong(value -> value.cost));
		nodes = new int[V + 1];

		long answer = 0;
		long maxCost = 0;

		for (Edge edge : edges) {
			int a = Math.min(edge.a, edge.b);
			int b = Math.max(edge.a, edge.b);
			long cost = edge.cost;
			boolean res = setUnion(a, b);
			if (res) {
				if (maxCost < cost) {
					maxCost = cost;
				}
				answer += cost;
			}
		}

		System.out.println(answer - maxCost);
	}

	private static boolean setUnion(int a, int b) {
		int aUnion = findUnion(a);
		int bUnion = findUnion(b);
		if (aUnion == bUnion) {
			return false;
		}
		nodes[bUnion] = aUnion;
		return true;
	}


	private static int findUnion(int n) {
		if (nodes[n] == 0) {
			return n;
		}
		return nodes[n] = findUnion(nodes[n]);
	}

	private static class Edge {

		int a, b;
		long cost;

		public Edge(int a, int b, long cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}
	}
}