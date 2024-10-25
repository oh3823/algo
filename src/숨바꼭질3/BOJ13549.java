package 숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13549 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] D = new int[100001];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[a] = 0;

		Queue<Pos> Q = new ArrayDeque<>();

		Q.add(new Pos(a, 0));
		while (!Q.isEmpty()) {
			Pos now = Q.poll();

			if (now.time > D[now.n]) {
				continue;
			}

			if (now.n - 1 >= 0 && D[now.n - 1] > now.time + 1) {
				D[now.n - 1] = now.time + 1;
				Q.add(new Pos(now.n - 1, now.time + 1));
			}
			if (now.n + 1 < D.length && D[now.n + 1] > now.time + 1) {
				D[now.n + 1] = now.time + 1;
				Q.add(new Pos(now.n + 1, now.time + 1));
			}
			if (now.n * 2 < D.length && D[now.n * 2] > now.time) {
				D[now.n * 2] = now.time;
				Q.add(new Pos(now.n * 2, now.time));
			}
		}

		System.out.println(D[b]);
	}

	static class Pos {

		int n, time;

		public Pos(int n, int time) {

			this.n = n;
			this.time = time;
		}
	}
}