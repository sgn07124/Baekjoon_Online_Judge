import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        for (char word : s.toCharArray()) {
            // 문자열이 같으면 스택에서 꺼낸다
            if (!stack.isEmpty() && word == stack.peek()) {
                stack.pop();
            }
            // 문자열이 다르면 스택에 넣는다.
            else {
                stack.push(word);
            }
        }
        
        return stack.size() > 0 ? 0 : 1;
    }
}