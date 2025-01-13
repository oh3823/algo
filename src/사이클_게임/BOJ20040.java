package 사이클_게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20040 {

	private static int[] union;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		union = new int[N + 1];

		int answer = 0;

		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) + 1;
			int b = Integer.parseInt(st.nextToken()) + 1;

			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}

			boolean cycle = setUnion(a, b);

			if (cycle) {
				answer = i + 1;
				break;
			}
		}

		System.out.println(answer);
	}

	private static boolean setUnion(int a, int b) {
		int unionA = findUnion(a);
		int unionB = findUnion(b);
		if (unionA == unionB) {
			return true;
		}

		union[unionB] = unionA;
		return false;
	}

	private static int findUnion(int n) {
		if (union[n] == 0) {
			return n;
		}

		return union[n] = findUnion(union[n]);
	}
}
