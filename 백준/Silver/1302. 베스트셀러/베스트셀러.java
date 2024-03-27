import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        String book = "";
        int max = 0;

        for(int i = 0 ; i <N ; i++){
            String str = br.readLine();
            if(map.containsKey(str)){
                map.put(str, map.get(str)+1);
            }else{
                map.put(str, 1);
            }
        }

        for (String s : map.keySet()) {
            if(map.get(s) > max){
                book = s;
                max = map.get(s);
            }else if(map.get(s) == max && book.compareTo(s) > 0){
                book = s;
                max = map.get(s);
            }
        }
        bw.write(book);

        br.close();

        bw.flush();
        bw.close();

    }
}
