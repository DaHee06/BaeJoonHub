class Solution {
    public int[] solution(int brown, int yellow) {
        int[] arr = new int[2];
        int sum = brown + yellow; // 격자 총 개수
        for(int i =3 ;i<sum/2 ;i ++){ // 최소 가로 행의 수 3, 최대 격자 수 sum/2
            int row = i;
            int col = sum/row;

            if((row - 2) * (col-2) == yellow){
                arr[0] = col;
                arr[1] = row;
                break;
            }

        }
        return arr;
    }
}