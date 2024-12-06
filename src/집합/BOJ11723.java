package 집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		boolean[] set = new boolean[21];

		final String add = "add";
		final String remove = "remove";
		final String check = "check";
		final String toggle = "toggle";
		final String all = "all";
		final String empty = "empty";

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			String operation = st.nextToken();
			int num = 0;
			if (!(operation.equals(all) || operation.equals(empty))) {
				num = Integer.parseInt(st.nextToken());
			}
			switch (operation) {
				case add:
					set[num] = true;
					break;
				case remove:
					set[num] = false;
					break;
				case check:
					sb.append(set[num] ? 1 : 0).append("\n");
					break;
				case toggle:
					set[num] = !set[num];
					break;
				case all:
					for (int j = 1; j <= 20; ++j) {
						set[j] = true;
					}
					break;
				case empty:
					for (int j = 1; j <= 20; ++j) {
						set[j] = false;
					}
					break;
			}
		}
		System.out.println(sb);
	}
}