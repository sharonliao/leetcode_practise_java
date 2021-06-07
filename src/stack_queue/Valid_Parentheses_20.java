package stack_queue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Valid_Parentheses_20 {
    HashMap<Character,Character> char_pairs = new HashMap<>(){{
//        '(', ')', '{', '}', '[' and ']'
        put(')','(');
        put('}','{');
        put(']','[');
    }};

    public boolean isValid(String s) {
        char[] charArry =  s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i<charArry.length){
            if(char_pairs.containsValue(charArry[i])){
                stack.push(charArry[i]);
            }else if(char_pairs.containsKey(charArry[i]) && !stack.empty()){
                if(!stack.pop().equals(char_pairs.get(charArry[i]))) return false;
            }else {
                return false;
            }
            i++;
        }

        if(stack.empty()){
            return true;
        }else {
            return false;
        }
    }


    public static void main(String[] args){
        String a = "()";
        Valid_Parentheses_20 test = new Valid_Parentheses_20();
        System.out.println(test.isValid(a));
    }
}
