import java.util.ArrayList;

class Solution {
     public ArrayList<Integer> solution(int[] answers) {
        int[][] pattern = {{1, 2, 3, 4, 5},
                           {2, 1, 2, 3, 2, 4, 2, 5},
                           {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i < pattern.length; i++) {
            int cnt = 0;
            for(int j = 0; j < answers.length; j++) {
                if(answers[j] == pattern[i][j % pattern[i].length]) cnt++;
            }
            list.add(cnt);
        }

        int MAX = Integer.MIN_VALUE;

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) > MAX) MAX = list.get(i);
        }

        for(int i = 0; i < list.size(); i++) {
            if(MAX == list.get(i)) ans.add(i + 1);
        }
        return ans;
    }
}