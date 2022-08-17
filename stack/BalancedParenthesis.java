package stack;
import java.util.Stack;

public class BalancedParenthesis {

//    public static boolean check(String expression, char exp){
//        return expression.charAt(0) == exp;
//    }

    public static boolean isBalanced(String expression){
        Stack<Character> stack = new Stack<>();
        if(expression.length() % 2 != 0){
            return false;
        }
        for(int i=0; i<expression.length(); i++){
            char match = expression.charAt(i);
            if(stack.isEmpty()){
                stack.push(match);
            }else if (stack.peek() == '[') {
//                boolean match = check(expression.substring(i),']');
//                if(match){
//                    stack.pop();
//                }else {
//                    stack.push(expression.charAt(i));
//                }
                if(match == ']'){
                    stack.pop();
                }else {
                    stack.push(match);
                }



            }else if (stack.peek() == '{') {
//                boolean match = check(expression.substring(i),'}');
//                if(match){
//                    stack.pop();
//                }else {
//                    stack.push(expression.charAt(i));
//                }
                if(match == '}'){
                    stack.pop();
                }else {
                    stack.push(match);
                }



            }else if (stack.peek() == '(') {
//                boolean match = check(expression.substring(i),')');
//                if(match){
//                    stack.pop();
//                }else {
//                    stack.push(expression.charAt(i));
//                }
                if(match == ')'){
                    stack.pop();
                }else {
                    stack.push(match);
                }


            }else {
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public static int countBracketReversals(String input) {
        //Your code goes here
        if(input.length() % 2 != 0){
            return -1;
        }

        Stack<Character> stack = new Stack<>();
        int count = 0;
        for(int i=0; i<input.length(); i++){
            char match = input.charAt(i);

            if(match == '{'){
                stack.push(match);
            }else{
                if(stack.isEmpty()){
                    stack.push(match);
                }else if(stack.peek() == '{'){
                    stack.pop();
                }else{
                    stack.push(match);
                }
            }
        }

        while(!stack.isEmpty()){
            char c1 = stack.pop();
            char c2 = stack.pop();

            if(c1 == c2){
                count += 1;
            }else{
                count += 2;
            }
        }

        if(count == 0){
            return -1;
        }else{
            return count;
        }
    }


    public static void main(String[] args) {
//        String str = ")[{(())}](";
//        System.out.println(isBalanced(str));

        String input = "}{";
        System.out.println(countBracketReversals(input));
    }
}
