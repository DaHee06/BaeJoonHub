import java.util.Arrays;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = Long.toString(n);

        char[] charArray = str.toCharArray();

        Arrays.sort(charArray);

        StringBuilder sortedStr = new StringBuilder(new String(charArray));
        sortedStr.reverse();


        answer = Long.parseLong(sortedStr.toString());
        return answer;
    }
}