package chess_tournament;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13344 {
    static int[] eq;
    static ArrayList<Integer>[] arr;

    public static int findClass(int a) {
        if (eq[a] == a) return a;

        return eq[a] = findClass(eq[a]);
    }

    public static void setDraw(int a, int b) {
        int aClass = findClass(a);
        int bClass = findClass(b);

        if (aClass == bClass) return;

        eq[bClass] = aClass;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N];
        eq = new int[N];

        for (int i = 0; i < N; i++) {
            eq[i] = i;
            arr[i] = new ArrayList<>();
        }

        ArrayList<Pair> compareList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            if (op.equals("=")) {
                setDraw(a, b);
                continue;
            }

            compareList.add(new Pair(a, b));
        }

        for (Pair pair : compareList) {
            int winner = pair.winner;
            int loser = pair.loser;

            int winClass = findClass(winner);
            int loseClass = findClass(loser);
            arr[winClass].add(loseClass);
        }

        boolean[] checked = new boolean[N];
        for (int node = 0; node < N; node++) {
            if (!isConsistent(node, checked, new boolean[N])) {
                System.out.println("inconsistent");
                return;
            }
        }

        System.out.println("consistent");
    }

    private static boolean isConsistent(int node, boolean[] checked, boolean[] visited) {
        if (visited[node]) return false;
        if (checked[node]) return true;

        visited[node] = true;
        checked[node] = true;

        for (int i : arr[node]) {
            if (!isConsistent(i, checked, visited)) {
                return false;
            }
        }

        visited[node] = false;

        return true;
    }

    private static class Pair {
        int winner, loser;

        public Pair(int winner, int loser) {
            this.winner = winner;
            this.loser = loser;
        }
    }
}