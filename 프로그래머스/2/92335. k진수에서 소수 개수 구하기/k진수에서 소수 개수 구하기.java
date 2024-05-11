import java.util.ArrayList;

class Solution {
    public int solution(int n, int k) {
        int result = 0;

        //n -> k진수로 변경
        StringBuilder sb = new StringBuilder();

        //k진수 변경
        String num = Integer.toString(n, k);
        
        ArrayList<Long> list = new ArrayList<>();

        int start = 0;

        //0을 기준
        for (int i = 0; i < num.length()-1; i++) {
            if (num.charAt(i) == '0') {
                String substring = num.substring(start, i);
                if (!substring.isEmpty()) {
                    long part = Long.parseLong(substring);
                    list.add(part);
                }
                start = i + 1;
            }
        }
        if (start < num.length()) {
            long part = Long.parseLong(num.substring(start));
            list.add(part);
        }

        //소수 판별 -> BigInteger
        for (int i = 0; i < list.size(); i++) {
            long num2 = list.get(i);
            if (isPrime(num2)) {
                result++;
            }
        }

        return result;

    }

    public static boolean isPrime(long num) {
        if (num <= 1) {
            return false; // 1 이하의 수는 소수가 아님
        }

        // 2부터 num의 제곱근까지의 수로 나누어 떨어지는지 확인
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // 나누어 떨어지면 소수가 아님
            }
        }
        return true; // 나누어 떨어지는 수가 없으면 소수임
    }
    
}