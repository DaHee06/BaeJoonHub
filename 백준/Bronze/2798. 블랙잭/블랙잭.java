import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        int result = search(arr, N, M);
        System.out.println(result);
    }

    static int search(int[] arr, int N, int M) {
        int answer = 0;

        int MAX = Integer.MIN_VALUE;
        for(int i = 0; i <arr.length-2;i++){
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    answer = arr[i] + arr[j] + arr[k];
                    if(answer == M) return answer;
                    if(answer < M && answer > MAX) {
                        MAX = answer;
                    }
                }
            }
        }

        return MAX;
    }


}