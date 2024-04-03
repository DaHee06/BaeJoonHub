import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr= new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i< N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); // 해답을 오름차순으로 답하기 위해

        int left = 0;
        int right = N - 1;
        int minSum = Integer.MAX_VALUE;
        int answer1 = 0;
        int answer2 = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < minSum) {
                minSum = Math.abs(sum);
                answer1 = arr[left];
                answer2 = arr[right];
            }
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                break;
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}
