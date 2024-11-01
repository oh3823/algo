package 트리의_지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1167 {

	public static int N;
	public static LinkedList<Node>[] arr;

	public static int maxNode;
	private static int maxDistance;

	public static void main(String[] args) throws IOException {
		input();

		boolean[] visited = new boolean[N + 1];

		dfs(1, visited, 0);

		maxDistance = 0;
		dfs(maxNode, visited, 0);

		System.out.println(maxDistance);
	}

	public static void dfs(int now, boolean[] visited, int distance) {
		visited[now] = true;

		if (distance > maxDistance) {
			maxNode = now;
			maxDistance = distance;
		}

		for (Node node : arr[now]) {
			int next = node.num;
			int dist = node.distance;

			if (visited[next]) {
				continue;
			}

			dfs(next, visited, distance + dist);
		}
		visited[now] = false;
	}

	public static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		arr = new LinkedList[N + 1];

		for (int i = 1; i <= N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");

			int base = Integer.parseInt(st.nextToken());
			arr[base] = new LinkedList<>();

			while (true) {
				int node = Integer.parseInt(st.nextToken());
				if (node == -1) {
					break;
				}
				int dist = Integer.parseInt(st.nextToken());
				arr[base].add(new Node(node, dist));
			}
		}
	}

	public static class Node {

		int num;
		int distance;

		public Node(int num, int distance) {
			this.num = num;
			this.distance = distance;
		}
	}
}