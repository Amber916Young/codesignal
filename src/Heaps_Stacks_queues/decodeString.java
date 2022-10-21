package Heaps_Stacks_queues;

import java.util.Stack;

/**
 * @ClassName:decodeString
 * @Auther: yyj
 * @Description:
 * @Date: 21/10/2022 11:15
 * @Version: v1.0
 */
public class decodeString {


    public static void main(String[] args) {
        decodeString string = new decodeString();
        string.solution("100[codesignal]");
    }

    /***
     * For s = "4[ab]", the output should be
     * solution(s) = "abababab";
     *
     * For s = "2[b3[a]]", the output should be
     * solution(s) = "baaabaaa";
     *
     * For s = "z1[y]zzz2[abc]", the output should be
     * solution(s) = "zyzzzabcabc".
     *
     * **/

    String solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int index = 0;
        StringBuilder ans = new StringBuilder();
        while (index < chars.length) {
            char cur = chars[index++];
            if (stack.isEmpty()) {
                stack.push(cur);
                continue;
            }
            if (cur == ']') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                String re = sb.reverse().toString();
                StringBuilder count = new StringBuilder(0);

                while (!stack.isEmpty() &&stack.peek() >='0' && stack.peek()<= '9' ){
                    count.append(stack.pop());
                }

                int times = Integer.parseInt(count.reverse().toString());
                while (times > 0) {
                   for(int i  =0;i<re.length();i++){
                       stack.push(re.charAt(i));
                   }
                    times--;
                }
                continue;
            }
            stack.push(cur);
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }



        return ans.toString();

    }
}
