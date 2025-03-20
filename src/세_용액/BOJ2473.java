package 세_용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2473 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		long[] answer = new long[3];
		for (int k = 0; k < N; ++k) {
			int i = k + 1, j = N - 1;
			while (i < j) {
				long sum = arr[i] + arr[j] + arr[k];
				if (Math.abs(sum) < min) {
					min = Math.abs(sum);
					answer[0] = arr[k];
					answer[1] = arr[i];
					answer[2] = arr[j];
				}
				if (sum < 0) {
					++i;
				} else {
					--j;
				}
			}
		}

		for (Long a : answer) {
			System.out.printf("%d ", a);
		}
	}
}