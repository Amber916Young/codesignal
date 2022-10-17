package LinkList;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName:isListPalindrome
 * @Auther: yyj
 * @Description:
 * @Date: 17/10/2022 12:25
 * @Version: v1.0
 */
public class isListPalindrome {

    // Singly-linked lists are already defined with this interface:
     class ListNode<T> {
       ListNode(T x) {
         value = x;
       }
       T value;
       ListNode<T> next;
     }

     // timeout not O(1)
    boolean solution(ListNode<Integer> l) {
        List<String> list = new LinkedList<>();
        while(l != null){
            list.add(String.valueOf(l.value));
            l = l.next;
        }
        for(int i = 0;i< list.size()/2;i++){
            // System.out.println( list.get(i));
            if(!list.get(i) .equals(list.get(list.size() - 1 -i))) return false;
        }
        return true;
    }

}
