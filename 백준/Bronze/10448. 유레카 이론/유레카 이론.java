import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 테스트케이스 개수
        int[] arr = new int[45];
        for(int i = 1; i< 45; i++){
            arr[i] = i*(i+1)/2;
        }
        for(int i = 0 ; i< N ; i ++) {
            int result = 0;
            int num = Integer.parseInt(br.readLine());
            result = calulate(num, arr);
            System.out.println(result);
        }
    }

    public static int calulate(int num, int[] arr){
        int sum = 0;
        for(int i = 1; i<arr.length; i++){
            for(int j = 1; j<arr.length; j++){
                for(int k = 1; k<arr.length; k++){
                    sum = arr[i] + arr[j] + arr[k];
                    if(sum == num) return 1;
                }
            }
        }
        return 0;
    }
}