import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];


        for(int i =0;i< commands.length;i++) {
            int start = commands[i][0]-1;
            int end = commands[i][1];

            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = start; j < end; j++) {
                arr.add(array[j]);
            }
            Collections.sort(arr);
            answer[i] = arr.get(commands[i][2]-1);
        }

        return answer;
    }
}