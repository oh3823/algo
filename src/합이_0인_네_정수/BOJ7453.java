package 합이_0인_네_정수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7453 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}

		int[] AB = new int[N * N];
		int[] CD = new int[N * N];

		int k = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j, ++k) {
				AB[k] = A[i] + B[j];
				CD[k] = C[i] + D[j];
			}
		}

		Arrays.sort(AB);
		Arrays.sort(CD);

		long answer = 0;
		int i, j;
		for (int g : AB) {
			i = lowerBound(CD, -g);
			j = upperBound(CD, -g);
			answer += j - i;
		}

		System.out.println(answer);
	}

	private static int upperBound(int[] arr, int k) {
		int i = 0;
		int j = arr.length - 1;
		int index = arr.length;
		int m;
		while (i <= j) {
			m = (i + j) / 2;
			if (k >= arr[m]) {
				i = m + 1;
			} else {
				j = m - 1;
				index = m;
			}
		}
		return index;
	}


	private static int lowerBound(int[] arr, int k) {
		int i = 0;
		int j = arr.length - 1;
		int index = arr.length;
		int m;
		while (i <= j) {
			m = (i + j) / 2;
			if (k <= arr[m]) {
				j = m - 1;
				index = m;
			} else {
				i = m + 1;
			}
		}
		return index;
	}
}