package 합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1132 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());

		boolean[] appeared = new boolean[10];
		int count = 0;
		char[][] nums = new char[N][];
		for (int i = 0; i < N; ++i) {
			nums[i] = br.readLine().toCharArray();
			for (int j = 0; j < nums[i].length; ++j) {
				if (!appeared[nums[i][j] - 'A']) {
					appeared[nums[i][j] - 'A'] = true;
					++count;
				}
			}
		}

		int[] arr = new int[count];
		for (int i = 0; i < count; ++i) {
			arr[i] = 10 - count + i;
		}

		long answer = 0;
		do {
			long result = cal(nums, arr);
			if (result > answer) {
				answer = result;
			}
		} while (nextPermutation(arr));

		System.out.println(answer);
	}

	private static long cal(char[][] nums, int[] arr) {
		long result = 0;
		for (char[] str : nums) {
			long num = 0;
			long d = (long) Math.pow(10, str.length - 1);

			if (arr[str[0] - 'A'] == 0) {
				return 0;
			}

			for (char c : str) {
				num += arr[c - 'A'] * d;
				d /= 10;
			}
			result += num;
		}
		return result;
	}

	private static boolean nextPermutation(int[] arr) {
		int i = arr.length - 1;

		while (i > 0 && arr[i - 1] >= arr[i]) {
			--i;
		}

		if (i <= 0) {
			return false;
		}

		int j = arr.length - 1;
		while (arr[j] <= arr[i - 1]) {
			--j;
		}

		int temp = arr[i - 1];
		arr[i - 1] = arr[j];
		arr[j] = temp;

		j = arr.length - 1;
		while (i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			++i;
			--j;
		}
		return true;
	}
}