package 수_나누기_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ27172 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int[] score = new int[N + 1];
		int[] x = new int[N + 1];
		int[] arr = new int[1000001];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; ++i) {
			x[i] = Integer.parseInt(st.nextToken());
			arr[x[i]] = i;
		}

		for (int i = 1; i <= N; ++i) {
			for (int j = x[i] * 2; j <= 1000000; j += x[i]) {
				if (arr[j] > 0) {
					--score[arr[j]];
					++score[i];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; ++i) {
			sb.append(score[i]).append(" ");
		}
		System.out.println(sb);
	}
}