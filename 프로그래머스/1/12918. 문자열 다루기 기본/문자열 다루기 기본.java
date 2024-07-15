class Solution {
    public boolean solution(String s) {
      if (s.length() == 4 || s.length() == 6) {
            // 문자열의 각 문자가 숫자인지 확인
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < '0' || c > '9') { // 아스키 코드값이 숫자 범위 (48-57) 인지 확인
                    return false; // 숫자가 아닌 문자가 하나라도 있으면 false 반환
                }
            }
            return true; // 모두 숫자이면 true 반환
        }
        return false; // 문자열의 길이가 4나 6이 아니면 false 반환
    }
}