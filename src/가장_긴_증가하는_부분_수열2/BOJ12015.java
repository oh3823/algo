package 가장_긴_증가하는_부분_수열2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12015 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] d = new int[N + 1];
		// index: 이전까지 발견된 가장 긴 부분수열의 길이, d[index]: key를 이루는 수열 중 가장 마지막 원소 (크기 비교를 위함)

		int len = 1;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
			int index = Arrays.binarySearch(d, 0, len, arr[i]);
			index = index < 0 ? -index - 1 : index;
			d[index] = d[index] == 0 ? arr[i] : Math.min(d[index], arr[i]);
			if (index == len) {
				++len;
			}
		}

		System.out.println(len - 1);
	}
}