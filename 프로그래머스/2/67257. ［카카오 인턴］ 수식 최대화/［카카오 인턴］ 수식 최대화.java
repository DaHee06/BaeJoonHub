import java.util.ArrayList;

class Solution {
    public long solution(String expression) {
        long answer = 0;

        String op[][] = {{"+","-","*"},{"+","*","-"},{"-","+","*"},{"-","*","+"},{"*","-","+"},{"*","+","-"}};

        ArrayList<String> list = new ArrayList<String>();

        //StringTokenizer로 변경해보기
        int start = 0;
        for(int i=0;i<expression.length();i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                list.add(expression.substring(start,i));
                list.add(expression.charAt(i)+""); //String으로 변경
                start = i+1;
            }
        }
        list.add(expression.substring(start));

        for(int i = 0 ; i<op.length;i++){
            ArrayList<String> sub_list = new ArrayList<String>(list);
            for(int j = 0; j<3;j++){
                for (int k = 0; k < sub_list.size(); k++) {
                    if (op[i][j].equals(sub_list.get(k))) {
                        sub_list.set(k - 1, calculate(sub_list.get(k - 1), sub_list.get(k), sub_list.get(k + 1)));
                        sub_list.remove(k);
                        sub_list.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(sub_list.get(0))));
        }

        return answer;
    
    }
    
    
    public  String calculate(String num1, String oper, String num2){
        long n1 = Long.parseLong(num1);
        long n2 = Long.parseLong(num2);

//        return switch (oper){
//            case "+" n1 + n2 + ""; break;
//
//        }
        if(oper.equals("+")){
            return n1 + n2 + "";
        }else if(oper.equals("-")){
            return n1 - n2 + "";
        }else{
            return n1 * n2 + "";
        }
    }
}


