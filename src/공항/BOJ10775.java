package 공항;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10775 {

	static int[] G;

	public static int find(int n) {
		if (G[n] == 0) {
			return 0;
		}
		if (G[n] == n) {
			--G[n];
			return n;
		}
		return G[n] = find(G[n]);
	}

	public static void print(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.print("]");
	}

	public static void main(String[] args) throws IOException {
		int g;
		int p;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		g = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		p = Integer.parseInt(st.nextToken());

		G = new int[g + 1];
		for (int i = 1; i <= g; ++i) {
			G[i] = i;
		}

		int answer = 0;
		for (int i = 0; i < p; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int gate = Integer.parseInt(st.nextToken());

			int result = find(gate);

			if (result == 0) {
				break;
			}
			++answer;
		}

		System.out.println(answer);

	}
}