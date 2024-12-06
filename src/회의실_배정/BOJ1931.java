package 회의실_배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());

		ArrayList<Meeting> meetings = new ArrayList<>(N);
		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings.add(new Meeting(start, end));
		}

		meetings.sort(
				(m1, m2) -> m1.end == m2.end ? (m1.start - m2.start) : m1.end - m2.end);

		int ended = 0;
		int answer = 0;

		for (Meeting meeting : meetings) {
			int start = meeting.start;
			int end = meeting.end;
			if (ended <= start) {
				++answer;
				ended = end;
			}
		}
		System.out.println(answer);
	}

	private static class Meeting {

		int start, end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}