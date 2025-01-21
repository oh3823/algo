package 보석_도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ1202_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		long answer = 0;

		Jewelry[] jewelries = new Jewelry[N];
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			jewelries[i] = new Jewelry(M, V);
		}

		Arrays.sort(jewelries, (a, b) -> a.v == b.v ? b.m - a.m : b.v - a.v);
		TreeMap<Integer, Integer> bags = new TreeMap<>();
		bags.put(0, 0);

		for (int i = 0; i < K; ++i) {
			int bag = Integer.parseInt(br.readLine());
			bags.put(bag, bags.getOrDefault(bag, 0) + 1);
		}

		for (Jewelry jewelry : jewelries) {
			Integer bag = bags.ceilingKey(jewelry.m);
			if (bag == null) {
				continue;
			}
			answer += jewelry.v;
			Integer r = bags.getOrDefault(bag, 1);
			if (r == 1) {
				bags.remove(bag);
			} else {
				bags.put(bag, r - 1);
			}
		}

		System.out.println(answer);
	}

	private static class Jewelry {

		int m, v;

		public Jewelry(int m, int v) {
			this.m = m;
			this.v = v;
		}

	}
}
