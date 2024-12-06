package 다각형의_면적;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2166 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());

		Pos[] list = new Pos[N + 1];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			list[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		list[N] = list[0];

		double answer = 0;
		for (int i = 1; i <= N; ++i) {
			long x0 = list[i - 1].x, y0 = list[i - 1].y;
			long x1 = list[i].x, y1 = list[i].y;
			answer += x1 * y0 - x0 * y1;
		}

		System.out.printf("%.1f\n", Math.abs(answer) / 2);
	}

	private static class Pos {

		int x, y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}