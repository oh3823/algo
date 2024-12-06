package 용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2467 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());

		int[] list = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; ++i) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		int i = 0, j = N - 1; // iterator
		int absMin = Integer.MAX_VALUE;
		int absMinI = 0, absMinJ = 0;

		while (i < j) {
			int L = list[j] + list[i];
			int abs = Math.abs(L);
			if (abs < absMin) {
				absMin = abs;
				absMinI = i;
				absMinJ = j;
			}
			if (0 < L) { // L이 커졌으면 합을 작게
				--j;
			} else if (0 > L) { // L이 작아졌으면 합을 크게
				++i;
			} else {
				break;
			}
		}
		System.out.println(list[absMinI] + " " + list[absMinJ]);
	}
}