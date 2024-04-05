import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int mid;
    static long sum; // long으로 수정

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = 0; // 변경
        int max = arr[N - 1];

        while (min <= max) { // 변경
            sum = 0; // sum 초기화

            mid = (min + max) / 2;

            for (int i : arr) {
                if ((i - mid) > 0) {
                    sum += (i - mid);
                }
            }

            if (sum >= M) { // 변경
                min = mid + 1; // 변경
            } else {
                max = mid - 1; // 변경
            }
        }
        System.out.println(max); // 변경
    }
}
