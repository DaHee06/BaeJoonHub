import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;

        //int를 set으로 변환 
        Set<Integer> intSet = Arrays.stream(numbers)
                .boxed().collect(Collectors.toSet());
        
        for(int i = 0 ;i < 10 ; i ++){
            if(!intSet.contains(i)) answer += i ;
        }
        return answer;
    }
}