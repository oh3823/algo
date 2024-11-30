package 사회망_서비스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2533 {

	private static ArrayList<Integer>[] arr;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];

		for (int i = 1; i <= N; ++i) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			arr[u].add(v);
			arr[v].add(u);
		}

		/*
			1. 아무 노드에서부터 트리를 탐색하고, 홀수 lv와 짝수 lv에 속한 노드 중 작은 개수를 구하면 된다. (X)
			2. DFS로 탐색하면서, 번갈아가면서 adaptor 설정
				2.1 leaf는 adaptor가 되지 않는다고 가정
				2.2 자식 노드 중에 adaptor가 하나도 없으면 내가 adaptor가 된다.
		 */
		dfs(1, new boolean[N + 1]);
		System.out.println(answer);
	}

	private static boolean dfs(int now, boolean[] visited) {
		visited[now] = true;
		boolean adapted = false; // 자식 중 어답터가 하나라도 없으면 false

		for (int next : arr[now]) {
			if (visited[next]) {
				continue;
			}
			boolean isAdaptor = dfs(next, visited);
			adapted = !isAdaptor || adapted;
		}

		if (adapted) {
			++answer;
		}

		return adapted;
	}

}