package stack;

import java.util.ArrayDeque;

public class BalancedParanthesis {

    public boolean isBalanced(String expression){

        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i=0; i<expression.length(); i++){
            if(validSetLeft(expression.charAt(i))){
                stack.push(expression.charAt(i));
            }
            else if(validSetRight(expression.charAt(i))){
                if(stack.isEmpty()){
                    return false;
                }
                if(!isRightParanthesisPair(stack.pop(),expression.charAt(i))){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isRightParanthesisPair(Character s, Character t){
        switch (s){
            case '{' :
                if(t!='}') {
                    return false;
                }
                break;
            case '[' :
                if(t!=']'){
                    return false;
                }
                break;
            case '(' :
                if(t!=')'){
                    return false;
                }
                break;
            default: return false;
        }
        return true;
    }

    public boolean validSetLeft(Character ch){
        return ch=='{' || ch=='[' || ch=='(';
    }

    public boolean validSetRight(Character ch){
        return ch=='}' || ch==']' || ch==')';
    }
}

class AppRunner {
    public static void main(String[] args) {
        BalancedParanthesis balancedParanthesis = new BalancedParanthesis();
        System.out.println("balancedParanthesis.isBalanced(\"{[()]}\") = " + balancedParanthesis.isBalanced("{[()]}"));
        System.out.println("balancedParanthesis.isBalanced(\"{()}\") = " + balancedParanthesis.isBalanced("{()}"));
        System.out.println("balancedParanthesis.isBalanced(\"{{{}}\") = " + balancedParanthesis.isBalanced("{{{}}"));
        System.out.println("balancedParanthesis.isBalanced(\"{[}]\") = " + balancedParanthesis.isBalanced("{[}]"));
        System.out.println("balancedParanthesis.isBalanced(\"{}[()]\") = " + balancedParanthesis.isBalanced("{}[()]"));
    }
}
