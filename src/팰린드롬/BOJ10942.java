package 팰린드롬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10942 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int[] numbers = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; ++i) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		boolean[][] arr = setPalindromeTable(numbers);

		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < M; ++t) {
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			sb.append(arr[S][E] ? 1 : 0).append("\n");
		}
		System.out.println(sb);
	}

	private static boolean[][] setPalindromeTable(int[] numbers) {
		int n = numbers.length;
		boolean[][] dp = new boolean[n][n];

		for (int center = 1; center <= n; ++center) {
			expandPalindrome(numbers, dp, center, center);
			expandPalindrome(numbers, dp, center, center + 1);
		}

		return dp;
	}

	private static void expandPalindrome(int[] numbers, boolean[][] dp, int left, int right) {
		while (1 <= left && right < numbers.length) {
			if (numbers[left] != numbers[right]) {
				return;
			}
			dp[left][right] = true;
			--left;
			++right;
		}
	}

}