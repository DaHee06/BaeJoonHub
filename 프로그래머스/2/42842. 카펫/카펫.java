class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int carpet = brown + yellow;

        for(int i = 3;i<=carpet;i++){
            int w = i;
            int h = carpet/w;

            if(w >=3 && h>=3) {
                int bow = 2 * (w + h - 2);
                int cen = w * h - bow;

                if (brown == bow && yellow == cen){
                    answer[0] = w;
                    answer[1] = h;
                }
            }
        }

        return answer;
    }
}