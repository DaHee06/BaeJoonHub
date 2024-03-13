import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String str2 = br.readLine();
        int length = str.length();
        str = str.replace(str2, "");
        System.out.println((length - str.length())/str2.length());
    }
}