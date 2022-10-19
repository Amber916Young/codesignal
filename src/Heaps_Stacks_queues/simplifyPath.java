package Heaps_Stacks_queues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @ClassName:simplifyPath
 * @Auther: yyj
 * @Description:
 * @Date: 19/10/2022 20:48
 * @Version: v1.0
 */
public class simplifyPath {
    public static void main(String[] args) {
        simplifyPath largestElement = new simplifyPath();
        largestElement.solution1("/home/a/./x/../b//c/");
    }

    /**
     *
     * / is the root directory; the path should always start with it even if it isn't there in the given path;
     * / is also used as a directory separator; for example, /code/fights denotes a fights subfolder in the code folder in the root directory;
     * this also means that // stands for "change the current directory to the current directory"
     * . is used to mark the current directory;
     * .. is used to mark the parent directory; if the current directory is root already, .. does nothing.
     * path = "/home/a/./x/../b//c/", the output should be
     * solution(path) = "/home/a/b/c".
     **/
    String solution1(String path) {

        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        int index = 0;
        while (index < paths.length) {
            String cur = paths[index++];
            if (cur.equals("")) continue;
            if (stack.isEmpty()) {
                if (cur.equals("..") || cur.equals(".")) continue;
                stack.add(cur);
                continue;
            }
            if (cur.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (cur.equals(".")) {
                continue;
            } else {
                stack.add(cur);
            }
        }
        if (stack.isEmpty()) return "/";

//        StringBuilder sb = new StringBuilder();
//        while (!stack.isEmpty()){
//            String cur = stack.firstElement();
//            stack.remove(cur);
//            sb.append("/");
//            sb.append(cur);
//        }
//        return sb.toString();
        System.out.println("/" + String.join("/", stack));
        return "/" + String.join("/", stack);


    }


    String solution2(String path) {
        String[] dirs = path.split("/");
        Deque<String> sp = new ArrayDeque<>();
        for (String dir : dirs) {
            if ("..".equals(dir)) {
                if (!sp.isEmpty()) {
                    sp.removeLast();
                }
            } else if (!dir.isEmpty() && !".".equals(dir)) {
                sp.addLast(dir);
            }
        }
        return "/" + String.join("/", sp);
    }


    String solution3(String path) {
        Stack<String> stack = new Stack<>();

        for (String s : path.split("/")) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s.isEmpty() && !".".equals(s)) {
                stack.push(s);
            }
        }

        return "/" + String.join("/", stack);
    }


}
