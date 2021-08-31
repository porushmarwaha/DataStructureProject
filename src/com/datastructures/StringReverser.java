package com.datastructures;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if(input == null)
            throw new IllegalArgumentException();
        Stack<Character> stack = new Stack<>();
        for(char ch:input.toCharArray())
            stack.push(ch);

        StringBuffer reversed = new StringBuffer();
        while (!stack.empty()){
            reversed.append(stack.pop());
        }
        return reversed.toString();
    }
    public boolean bracketChecker(String input){
        if(input == null)
            throw new IllegalArgumentException();

        Stack<Character> stack = new Stack<>();
        char test[] = {'[',']','{','}','(',')','<','>' };
        short count = 0;
        for(int i = 0; i<input.length();i++){
            if(     input.charAt(i) == '['
                    || input.charAt(i) == '{'
                    || input.charAt(i) == '('
                    || input.charAt(i) == '<'
            ) {
                stack.push(input.charAt(i));
                count++;
            //    System.out.println(input.charAt(i));
            }

            if(input.charAt(i) == ']' || input.charAt(i) == '}' || input.charAt(i) == ')' || input.charAt(i) == '>') {
              //  System.out.println(input.charAt(i));
                    char check = stack.pop();
                System.out.println(check);
                    count--;
                if(
                        (input.charAt(i) == test[1] && check == test[0])  ||
                        (input.charAt(i) == test[3] && check == test[2])  ||
                        (input.charAt(i) == test[5] && check == test[4])  ||
                                (input.charAt(i) == test[7]  && check == test[6])
                ) continue; else return false;

            }
            if(count == 0)
                return true;
            else return false;
        }
            return true;
    }
}
