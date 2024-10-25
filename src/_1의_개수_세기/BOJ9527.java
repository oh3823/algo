package _1의_개수_세기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9527 {

	static long[] N;

	public static long count(String bin) {
		if (bin.length() == 1) {
			return Long.parseLong(bin);
		}

		long res = count(bin.substring(1));
		if (bin.charAt(0) == '1') {
			res += N[bin.length() - 1] + Long.parseLong(bin, 2) - (1L << (bin.length() - 1)) + 1L;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = new long[64];
		N[1] = 1;
		for (int i = 2; i < 56; ++i) {
			N[i] = (N[i - 1] << 1) + (1L << (i - 1));
		}

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		System.out.println(count(Long.toBinaryString(b)) - count(Long.toBinaryString(a - 1)));
	}
}