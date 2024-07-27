import java.util.ArrayList;

class Solution {
   public static long solution(String expression) {
       String[][] exc = {{"+","-","*"},{"+","*","-"},{"-","+","*"},{"-","*","+"},{"*","-","+"},{"*","+","-"}};

        ArrayList<String> list = new ArrayList<>();
        int start = 0;

        for(int i = 0 ; i<expression.length();i++){
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                list.add(expression.substring(start, i));
                list.add(String.valueOf(expression.charAt(i)));
                start = i+1;
            }
        }

        list.add(expression.substring(start));

        long max  = Integer.MIN_VALUE;

        for (String[] ops : exc) { //
            long result = calculate(new ArrayList<>(list), ops);
            max = Math.max(max, result);
        }

        return max;
    }

    private static long calculate(ArrayList<String> list, String[] ops) {
        for (String op : ops) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(op)) {
                    long n = Long.parseLong(list.get(i - 1));
                    long m = Long.parseLong(list.get(i + 1));
                    long result = 0;
                    switch (op) {
                        case "+":
                            result = n + m;
                            break;
                        case "-":
                            result = n - m;
                            break;
                        case "*":
                            result = n * m;
                            break;
                    }
                    list.set(i - 1, Long.toString(result));
                    list.remove(i);
                    list.remove(i);
                    i--; //
                }
            }
        }
        return Math.abs(Long.parseLong(list.get(0)));
    }
}


