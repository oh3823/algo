package Dance_Dance_Revolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2342 {

	static int[][] cost;
	static int[][][] d;
	static int[] arr;
	static int N;

	static int dfs(int i, int left, int right) {
		if (i == N) {
			return 0;
		}

		if (left > right) {
			int temp = left;
			left = right;
			right = temp;
		}

		if (d[i][left][right] > 0) {
			return d[i][left][right];
		}

		int next = arr[i + 1];
		return d[i][left][right] = Math.min(dfs(i + 1, left, next) + cost[right][next],
				dfs(i + 1, next, right) + cost[left][next]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		arr = new int[100002];
		d = new int[100002][5][5];
		cost = new int[5][5];
		cost[0] = new int[]{0, 2, 2, 2, 2};
		cost[1] = new int[]{0, 1, 3, 4, 3};
		cost[2] = new int[]{0, 3, 1, 3, 4};
		cost[3] = new int[]{0, 4, 3, 1, 3};
		cost[4] = new int[]{0, 3, 4, 3, 1};

		N = 0;
		while (true) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp == 0) {
				break;
			}
			arr[++N] = temp;
		}

		int score = dfs(0, 0, 0);
		System.out.println(score);
	}
}