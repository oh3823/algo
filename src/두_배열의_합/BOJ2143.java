package 두_배열의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BOJ2143 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] A = new int[N];
		for (int i = 0; i < N; ++i) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] B = new int[M];
		for (int i = 0; i < M; ++i) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		long answer = 0;
		HashMap<Integer, Integer> a = new HashMap<>();
		HashMap<Integer, Integer> b = new HashMap<>();

		put(A, a);
		put(B, b);

		for (Entry<Integer, Integer> entry : a.entrySet()) {
			int key = entry.getKey();
			long aCount = entry.getValue();
			long bCount = b.getOrDefault(T - key, 0);
			answer += aCount * bCount;
		}

		System.out.println(answer);
	}

	private static void put(int[] arr, HashMap<Integer, Integer> map) {
		int n = arr.length;
		int s = 0;
		for (int len = 1; len <= n; ++len) {
			int sum = (s += arr[len - 1]);
			for (int i = 0; i <= n - len; ++i) {
				map.put(sum, map.getOrDefault(sum, 0) + 1);
				if (i + len == n) {
					break;
				}
				sum -= arr[i];
				sum += arr[i + len];
			}
		}
	}
}