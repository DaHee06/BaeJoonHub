import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        int[] count = new int[26]; //영문자 개수
        for (int i = 0; i < str.length(); i++) {
            if(65 <= str.charAt(i) && str.charAt(i) <=90){
                count[str.charAt(i)-'A']++;
            }
        }

        int max = 0;
        char answer ='?';
        for(int i = 0; i<count.length;i++){
            if(max < count[i]){
                max = count[i];
                //char 형 타입의 변수에 int와 char을 연산하여 저장할 경우 캐스팅 해줘야함
                answer = (char)(i + 'A');
            }else if(max == count[i]){
                answer = '?';
            }
        }
        System.out.println(answer);
    }
}