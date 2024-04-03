import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] U = new int[N];
        for (int i = 0; i < N; i++) {
            U[i] = Integer.parseInt(br.readLine()); //U에 대한 배열
        }

        Arrays.sort(U);

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                set.add(U[i] + U[j]);
            }
        }

        int max = 0;
        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                int k = U[i] - U[j];
                if (set.contains(k)) {
                    max = Math.max(U[i], max);
                }

            }
        }

        System.out.println(max);


    }
}
