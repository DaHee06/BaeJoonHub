import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < M ; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int X = 1;
            if(N%H == 0){
                X = (N/H);
            }else{
                X = (N/H) + 1;
            }
            int Y = 1;
            if(N%H == 0){
                Y = H * 100;
            }else{
                Y = (N%H) * 100;
            }

            int ans = Y + X ;
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}
