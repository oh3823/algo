package 앱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7579 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] m = new int[N + 1];
		int[] c = new int[N + 1];

		int sum = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			m[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			c[i] = Integer.parseInt(st.nextToken());
			sum += c[i];
		}

		int[] d = new int[sum + 1];

		for (int i = 1; i <= N; i++) {
			int mem = m[i];
			int cost = c[i];
			for (int j = sum; j >= cost; j--) {
				if (d[j] < d[j - cost] + mem) {
					d[j] = d[j - cost] + mem;
				}
			}
		}

		for (int i = 0; i < d.length; i++) {
			if (d[i] >= M) {
				System.out.println(i);
				break;
			}
		}
	}
}