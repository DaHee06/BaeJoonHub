import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 임의의 문자열 DNA의 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열의 길이

        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] checkArr = new int[4];
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int[] countArr = new int[4];

        // 초기 윈도우 설정
        for (int i = 0; i < P; i++) {
            char c = DNA.charAt(i);
            countArr[getIndex(c)]++;
        }

        // 슬라이딩 윈도우로 부분 문자열 확인
        for (int i = P; i <= S; i++) {
            if (checkSubDNA(countArr, checkArr)) {
                result++;
            }
            if (i < S) {
                char removeChar = DNA.charAt(i - P);
                char addChar = DNA.charAt(i);
                countArr[getIndex(removeChar)]--;
                countArr[getIndex(addChar)]++;
            }
        }

        System.out.println(result);
    }

    // 문자에 해당하는 인덱스 반환
    public static int getIndex(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
            default:
                return -1;
        }
    }

    // 부분 문자열이 주어진 조건을 만족하는지 확인
    public static boolean checkSubDNA(int[] countArr, int[] checkArr) {
        for (int i = 0; i < 4; i++) {
            if (countArr[i] < checkArr[i]) {
                return false;
            }
        }
        return true;
    }
}
