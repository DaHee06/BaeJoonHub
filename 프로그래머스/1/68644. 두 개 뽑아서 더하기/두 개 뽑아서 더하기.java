import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ;i < numbers.length;i++){
            for(int j = 0 ; j < numbers.length; j++){
                int sum = 0;
                if(i != j){
                    sum = numbers[i] + numbers[j];
                    if(!set.contains(sum)){
                        set.add(sum);
                    }
                }
            }
        }


        // HashSet을 배열로 변환
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();

        // 배열 정렬
        Arrays.sort(answer);

        return answer;
    }
}