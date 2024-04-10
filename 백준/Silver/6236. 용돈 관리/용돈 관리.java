import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max , arr[i]);
        }

        int lo = max ;
        int hi = 10000 * N;

        int result = hi;
        while(lo <= hi){
            int K = (lo + hi) / 2;
            int count = 1;
            int pay = 0;
            for(int i = 0; i < N ; i++){
                if(pay + arr[i] > K){
                    count++;
                    pay = arr[i];
                }else{
                    pay += arr[i];
                }
            }

            if(count > M) lo = K + 1;
            else {
                hi = K - 1;
                result = Math.min(result, K);
            }

        }

        System.out.println(result);
    }
}
