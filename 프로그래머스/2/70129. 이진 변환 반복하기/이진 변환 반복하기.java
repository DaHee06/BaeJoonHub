class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int a = 0; // 진법 변환 횟수 -> 진법 변환 메서드
        int b = 0; // 삭제한 0의 개수

        while(!s.equals("1")){
            String newS = s.replace("0","");
            int newLength = newS.length();
            b += (s.length() - newS.length());

            s = convertInt(newLength);
            a++;

        }

        answer[0] = a;
        answer[1] = b;


        return answer;
    }

    public static String convertInt(int n){
        StringBuilder sb = new StringBuilder();

        while(n>0){
            sb.append(n%2);
            n /=2;
        }

        return sb.reverse().toString();


    }
}