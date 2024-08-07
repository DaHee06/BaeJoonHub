class Solution {
    public String[] solution(String[] strings, int n) {
        // 문자열 배열의 길이를 구함
        int length = strings.length;
        
        // 버블 정렬을 사용하여 n번째 문자를 기준으로 정렬
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                // n번째 문자가 같을 경우 전체 문자열로 비교하여 사전순으로 정렬
                if (strings[j].charAt(n) == strings[j + 1].charAt(n)) {
                    if (strings[j].compareTo(strings[j + 1]) > 0) {
                        // swap strings[j] and strings[j + 1]
                        String temp = strings[j];
                        strings[j] = strings[j + 1];
                        strings[j + 1] = temp;
                    }
                } else if (strings[j].charAt(n) > strings[j + 1].charAt(n)) {
                    // n번째 문자를 기준으로 정렬
                    // swap strings[j] and strings[j + 1]
                    String temp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = temp;
                }
            }
        }

        return strings;
    }
}