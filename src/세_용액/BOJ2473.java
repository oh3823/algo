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
		for (int i = 0; i < N; ++i) {
			for (int j = i + 1; j < N; ++j) {
				long sum = arr[i] + arr[j];
				int index = Arrays.binarySearch(arr, j + 1, N, -sum);
				int k = index < 0 ? -index - 1 : index;
				for (int l = k - 1; l <= k; ++l) {
					if (l <= j || l >= N) {
						continue;
					}
					long abs = Math.abs(sum + arr[l]);
					if (abs < min) {
						min = abs;
						answer[0] = arr[i];
						answer[1] = arr[j];
						answer[2] = arr[l];
					}
				}

			}
		}

		for (Long a : answer) {
			System.out.printf("%d ", a);
		}
	}
}