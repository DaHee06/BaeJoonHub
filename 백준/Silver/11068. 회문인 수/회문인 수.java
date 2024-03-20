import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 11068. 회문인 수
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(st.nextToken());
        for(int i = 0; i< T ;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            boolean found = false;
            for(int B =2 ; B<65 ; B++){
                String str = converse(n, B);

                String str2 = new StringBuffer(str).reverse().toString();

                if(str.equals(str2)) {
                    sb.append(1).append('\n');
                    found = true;
                    break;
                }
            }
            if (!found) {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    //진법 변환
    public static String converse(int n, int B) {
        StringBuffer sb = new StringBuffer();

        while(n > 0){
            sb.append((char)(n % B));
            n /= B;
        }
        return sb.reverse().toString();
    }
}