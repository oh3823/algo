package 비밀번호_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ17219 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			String site = st.nextToken();
			String pw = st.nextToken();
			map.put(site, pw);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			String site = st.nextToken();
			String pw = map.get(site);
			sb.append(pw).append("\n");
		}

		System.out.println(sb);
	}
}
