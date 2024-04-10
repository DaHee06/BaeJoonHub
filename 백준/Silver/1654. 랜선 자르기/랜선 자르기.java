import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        long max = 0; // 배열의 최대값을 찾기 위한 변수
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]); // 최대값 갱신
        }

        long lo = 1; // 최소 길이
        long hi = max; // 최대 길이
        long result = 0;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            long count = 0;

            for (int i : arr) {
                count += (i / mid); // 자르는 랜선의 개수 합산
            }

            if (count >= K) {
                lo = mid + 1;
                result = Math.max(result, mid); // 최대 길이 갱신
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(result);
    }
}
