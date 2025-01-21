package 보석_도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1202 {

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

		/*
			1. 높은 가치를 가진 보석을 가능한 큰 가방에 먼저 넣는다. (X)

			tc
			1 2
			3 10
			4 9
			3
			4

			3번 보석을 4번 가방에 넣으면 4번 보석을 넣을 수 없기 때문에 틀린다.


			2. 높은 가치를 가진 보석을 가능한 작은 가방에 먼저 넣는다. (O)
			보석 리스트를 가치 내림차순, 무게 내림차순으로 정렬한다.
			동일한 가치의 보석 중에서는 무게가 무거운 보석부터 시도한다.
			보석의 무게를 담을 수 있는 가장 작은 가방을 찾기 위해 TreeSet을 사용했었는데,
			무게가 같은 가방이 있는 경우 틀린다.
			TreeMap을 사용해서, key로 가방의 용량을, value로 그 용량 가방의 개수를 저장하여
			같은 무게의 가방을 여러 개 관리하면 맞는 로직이다.

			보석을 정렬하고 O(NlogN)
			가방을 트리에 저장한다. O(KlogK)
			보석 리스트를 순회하면서 O(N), 보석을 담을 수 있는 가장 작은 가방을 이진탐색으로 찾는다. O(logK) | O(NlogK)
			시간복잡도는 O((N+K)logK)로 예상한다.


			3. 큰 가방부터, 가방에 담을 수 있는 보석 중 가장 높은 가치의 보석을 담는다. (X)

			4. 작은 가방부터, 가방에 담을 수 있는 보석 중 가장 높은 가치의 보석을 담는다. (O)
			가방 리스트를 용량 오름차순으로 정렬한다.
			보석 리스트를 무게 오름차순으로 정렬한다. 가치는 상관없다.
			가방 리스트를 순회하면서 가방에 담을 수 있는 보석, 즉 가방의 용량보다 무게가 덜 나가는 보석(의 가치)를 힙에 넣는다.
			힙은 최대 힙이며, 탑에는 항상 현재 가방에 넣을 수 있는 보석 중 가장 가치가 높은 보석의 가치가 존재한다.

			큰 가방에는, 보다 작은 가방에 넣을 수 있는 보석 또한 넣을 수 있다.
			작은 가방에 넣을 수 있는 보석중 가장 가치있는 보석을 넣고 난 후 나머지 보석들을 다시 탐색할 필요 없이,
			그대로 더 큰 가방에 넣을 수 있는 후보로 만드는 로직이다.

			힙에는 모든 보석이 많아야 한 번 씩만 들어간다.
			따라서 가방 리스트를 순회하면서 O(K), 가장 가치있는 보석을 찾는다. O(logN) | O(KlogN)
			그 과정에서 모든 보석이 O(N) 한 번 씩 힙에 들어가게 된다. O(logN) | O(NlogN)
			시간복잡도는 O((K+N)logN)으로 예상한다.


		 */
		Arrays.sort(jewelries, Comparator.comparingInt(j -> j.m));
		int[] bags = new int[K];
		for (int i = 0; i < K; ++i) {
			bags[i] = Integer.parseInt(br.readLine());
		}

//		Arrays.sort(bags);

		int j = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int bag : bags) {
			while (j < N && jewelries[j].m <= bag) {
				pq.offer(jewelries[j].v);
				++j;
			}
			Integer top = pq.poll();
			if (top == null) {
				continue;
			}
			answer += top;
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
