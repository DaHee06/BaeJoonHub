class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();

        //진법 변환 대표
        int a = n;
        while (a > 0) {
            sb.append(a % 3);
            a /= 3;
        }


        String reverseNum = sb.toString();  // 이미 3진수 변환 과정에서 뒤집힌 형태로 저장됨
        int decimalValue = 0;
        int length = reverseNum.length();
        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(reverseNum.charAt(length - 1 - i));  // 뒤집힌 문자열을 다시 원래 순서로 가져옴
            decimalValue += digit * Math.pow(3, i);  // 10진수로 변환
        }
        
        //

        return decimalValue;
    }
}