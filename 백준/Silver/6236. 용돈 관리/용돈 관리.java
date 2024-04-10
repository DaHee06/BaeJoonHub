import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사용 일수
        int M = Integer.parseInt(st.nextToken()); // 인출 횟수

        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]); // 사용할 금액 중 최댓값 찾기
        }

        int lo = max; // 인출 금액의 최솟값은 사용할 금액의 최댓값
        int hi = 100000 * N; // 인출 금액의 최댓값은 하루에 사용할 수 있는 금액의 최댓값

        int result = hi; // 결과 변수 초기화
        while (lo <= hi) {
            int mid = (lo + hi) / 2; // 이분 탐색의 중간값 설정
            int count = 1; // 인출 횟수 초기화
            int sum = 0; // 현재 인출한 금액의 합 초기화

            for (int i = 0; i < N; i++) {
                // 현재까지 인출한 금액과 다음에 사용할 금액을 비교하여 인출 결정
                if (sum + arr[i] > mid) {
                    count++; // 새로운 인출 필요
                    sum = 0; // 다음 인출에서 사용할 새로운 금액 합 초기화
                }
                sum += arr[i]; // 다음에 사용할 금액 합 갱신
            }

            // 인출 횟수가 M보다 작거나 같으면 결과 갱신 후 더 작은 값으로 이분 탐색
            if (count <= M) {
                result = Math.min(result, mid);
                hi = mid - 1;
            }
            // 인출 횟수가 M보다 크면 인출 금액을 늘려야 하므로 범위를 늘림
            else {
                lo = mid + 1;
            }
        }

        System.out.println(result);
    }
}
