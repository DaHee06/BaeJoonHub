class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, target, 0);
    }

    public static int dfs(int[] numbers, int depth, int target, int result) {
        if (depth == numbers.length) {
            return result == target ? 1 : 0;
        }

        int plus = dfs(numbers, depth + 1, target, result + numbers[depth]);
        int minus = dfs(numbers, depth + 1, target, result - numbers[depth]);

        // 각 호출에서 반환된 값을 합산하여 반환
        return plus + minus;
    }
}