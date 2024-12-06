package 합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1132 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());

		long[] count = new long[10];
		int[] nonzero = new int[10];
		char[][] nums = new char[N][];
		for (int i = 0; i < N; ++i) {
			nums[i] = br.readLine().toCharArray();
			long d = 1;
			for (int j = nums[i].length - 1; j >= 0; --j, d *= 10) {
				int index = nums[i][j] - 'A';
				count[index] += d;
				if (j == 0) {
					nonzero[index] = 1;
				}
			}
		}

		Integer[] list = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		Arrays.sort(list, (l1, l2) -> Long.compare(count[l1], count[l2]));

		while (nonzero[list[0]] == 1) {
			int j = 0;
			while (j < 10) {
				if (nonzero[list[j]] == 0) {
					int temp = list[j];
					for (int i = j; i > 0; --i) {
						list[i] = list[i - 1];
					}
					list[0] = temp;
					break;
				}
				++j;
			}
		}

		long answer = 0;
		for (int i = 0; i < 10; ++i) {
			int index = list[i];
			answer += count[index] * i;
		}
		System.out.println(answer);
	}
}